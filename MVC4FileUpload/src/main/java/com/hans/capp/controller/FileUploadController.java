package com.hans.capp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	
	private FileUploadInDb fileUploadInDb;
	
	static String fileDescription;
    static FileUpload fileUploadObj;
    static String saveDirectory = "uploadedFiles";  
    static ModelAndView modelViewObj;
    
    @RequestMapping(value = {"/", "fileupload"}, method = RequestMethod.GET)
    public ModelAndView showUploadFileForm(ModelMap model) {
        modelViewObj = new ModelAndView("fileupload");
        return  modelViewObj;
    }

 // This Method Is Used To Get Or Retrieve The Uploaded File And Save It In The Db
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public ModelAndView saveUploadedFileInDatabase(HttpServletRequest request, final @RequestParam("attachFileObj") CommonsMultipartFile[] attachFileObj1) throws IllegalStateException, IOException {
 
    	// Reading File Upload Form Input Parameters        
        fileDescription = request.getParameter("description");
        
     // Logging The Input Parameter (i.e. File Description) For The Debugging Purpose
        System.out.println("\nFile Description Is?= " + fileDescription + "\n");
        
     // Determine If There Is An File Upload. If Yes, Attach It To The Client Email              
        if ((attachFileObj1 != null) && (attachFileObj1.length > 0) && (!attachFileObj1.equals(""))) {
        	for (CommonsMultipartFile aFile : attachFileObj1) {
        	if(aFile.isEmpty()) {
                continue;
            } else {
                System.out.println("Attachment Name?= " + aFile.getOriginalFilename() + "\n");
                if (!aFile.getOriginalFilename().equals("")) {
                    fileUploadObj = new FileUpload();
                    fileUploadObj.setFileName(aFile.getOriginalFilename());
                    fileUploadObj.setFileDescription(fileDescription);
                    fileUploadObj.setData(aFile.getBytes());

                    // Calling The Db Method To Save The Uploaded File In The Db
                    fileUploadInDb.fileSaveInDb(fileUploadObj);
                }
            }
        	System.out.println("File Is Successfully Uploaded & Saved In The Database.... Hurrey!\n");
            }
        } else {
            // Do Nothing
        }
        modelViewObj = new ModelAndView("success","messageObj","Thank You! The File(s) Is Successfully Uploaded!");
        return  modelViewObj;   
    }
        
            
    }

