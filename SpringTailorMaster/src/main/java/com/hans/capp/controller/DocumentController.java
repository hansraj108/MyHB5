package com.hans.capp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hans.capp.domain.UserDocument;
import com.hans.capp.service.UserDocumentService;
import com.hans.capp.service.UserService;


@Controller
public class DocumentController {

	@Autowired
	private UserDocumentService userDocumentService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = { "/user/doc_form"})
	public String addDocuments(ModelMap model, HttpSession session) {
		
		UserDocument ud = new UserDocument();
		model.addAttribute("userDocument", ud);
		return "document_form";
	}
	
	@RequestMapping(value = { "/user/savedoc"}, method = RequestMethod.POST)
public String uploadDocument(@ModelAttribute("userDocument") UserDocument userDocument, BindingResult resultdoc, Model m, HttpSession session) throws IOException{
		
		try {
			System.out.println("getDescription==============>"+userDocument.getDescription());
			System.out.println("getUserId==============>"+userDocument.getUserId());
			Integer userId = (Integer) session.getAttribute("userId");
			userDocument.setUserId(userId);
			saveDocument(userDocument, session);
		
		return "redirect:doclist1";
		}catch(IOException ex){
			
			m.addAttribute("err", ex.getMessage());
			return "document_form";
		}
	}
		
		
	
private void saveDocument(UserDocument userDocument, HttpSession session) throws IOException{
		
		List<MultipartFile> multipartFiles = userDocument.getFiles();
		
		if(null != multipartFiles && multipartFiles.size() > 0) {
			
			for(MultipartFile multipartFile: multipartFiles) {
		
		userDocument.setName(multipartFile.getOriginalFilename());
		userDocument.setType(multipartFile.getContentType());
		userDocument.setContent(multipartFile.getBytes());
		
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("XXXXXXXXXXXXXXXXXXXXx"+userId);
		
		userDocumentService.findAllUserDocument(userId);
		userDocumentService.save(userDocument);
			}
		}
	}

@RequestMapping(value= {"/user/doclist1", "/user/doclist1/{type}"})
public String documentList(@PathVariable Map<String, String>  pathVariablesMap, Model m, HttpSession session, HttpServletRequest req) {
//	Integer userId = (Integer) session.getAttribute("userId");
	
//	List<UserDocument> l = userDocumentService.findAllUserDocument(userId);
//	m.addAttribute("documentList",l);
//	return "doclist1";
	String x = setPagination(pathVariablesMap, req, session, m);
	return x;
}

@RequestMapping(value = { "/download_document_{userId}_{id}" }, method = RequestMethod.GET)
public String downloadDocument(@PathVariable Integer userId, @PathVariable Integer id, HttpServletResponse response) throws IOException {
	UserDocument document = userDocumentService.findById(id);
	response.setContentType(document.getType());
    response.setContentLength(document.getContent().length);
    response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");

    FileCopyUtils.copy(document.getContent(), response.getOutputStream());

		return "redirect:doclist1";
}

@RequestMapping(value = {"/delete_document_{userId}_{id}"}, method = RequestMethod.GET)
public String deleteDocument(@PathVariable Integer userId, @PathVariable Integer id) {
	userDocumentService.delete(id);
	
	//	return "redirect:/user/doc_form";
	return "redirect:/user/doclist1?act=doc_del";
}

@RequestMapping(value= {"/user/bulk_docdelete"})
public String deleteBulkContact(@RequestParam("did") Integer[] contactIds) {
	userDocumentService.deleteAll(contactIds);
	
	return "redirect:/user/doclist1?act=docs_del";
}
@RequestMapping(value= {"/user/document_search"})
public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
	Integer userId = (Integer) session.getAttribute("userId");
	m.addAttribute("documentList",userDocumentService.findUserDocument(userId, freeText));
	
	return "doclist1";
}


public String setPagination(Map<String, String> pathVariablesMap, HttpServletRequest req, HttpSession session, Model m) {
	System.out.println("------------------------------->setPagination"); 
	PagedListHolder<UserDocument> documentList = null;
        
	Integer userId =  (Integer) session.getAttribute("userId");
        String type = pathVariablesMap.get("type");
        
        if(null == type) {
            // First Request, Return first set of list
            List<UserDocument> docList = userDocumentService.findAllUserDocument(userId);
            for(UserDocument u : docList) {
            	System.out.println("=================================>>>>>"+u.getName());
            }
            documentList = new PagedListHolder<UserDocument>();
            documentList.setSource(docList);
            documentList.setPageSize(10);
            
           
            req.getSession().setAttribute("documentList",  documentList);
            m.addAttribute("documentList", documentList);
            printPageDetails(documentList);
            
        } else if("next".equals(type)) {
            // Return next set of list
        	documentList = (PagedListHolder<UserDocument>) req.getSession()
                                .getAttribute("documentList");
            
        	documentList.nextPage();
        	m.addAttribute("documentList", documentList);
            printPageDetails(documentList);
            
        } else if("prev".equals(type)) {
            // Return previous set of list
        	documentList = (PagedListHolder<UserDocument>) req.getSession()
                                .getAttribute("documentList");
            
        	documentList.previousPage();
            
            printPageDetails(documentList);
            
        } else {
            // Return specific index set of list
            System.out.println("type:" + type);
            
            documentList = (PagedListHolder<UserDocument>) req.getSession()
                                .getAttribute("documentList");
            
            int pageNum = Integer.parseInt(type);
            
            documentList.setPage(pageNum);
            
            
            printPageDetails(documentList);
            m.addAttribute("documentList", documentList);
        }
                    
        
        
        return  "doclist1";
    }


private void printPageDetails(PagedListHolder documentList) {

System.out.println("curent page - productList.getPage() :"
        + documentList.getPage());

System.out.println("Total Num of pages - productList.getPageCount :"
        + documentList.getPageCount());

System.out.println("is First page - productList.isFirstPage :"
        + documentList.isFirstPage());

System.out.println("is Last page - productList.isLastPage :"
        + documentList.isLastPage());
}
}
