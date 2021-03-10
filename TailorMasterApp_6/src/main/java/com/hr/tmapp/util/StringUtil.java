package com.hr.tmapp.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.hr.tmapp.domain.Customer;
import com.hr.tmapp.service.CustomerService;

@Component
public class StringUtil {
	
	@Autowired
	private CustomerService customerService;

	public static String toCommaSeperatedString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		for(Object ob : items) {
			sb.append(ob).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	
	public String setPaginationForCustomerList(Map<String, String> pathVariablesMap, HttpServletRequest req, HttpSession session, Model m) {
		System.out.println("------------------------------->setPagination"); 
		PagedListHolder<Customer> customerList = null;
	        
		Integer userId =  (Integer) session.getAttribute("userId");
	        String type = pathVariablesMap.get("type");
	        
	        if(null == type) {
	            // First Request, Return first set of list
	            List<Customer> custList = customerService.findUserCustomer(userId);
	            for(Customer c : custList) {
	            	System.out.println("=================================>>>>>"+c.getFirstName());
	            }
	            customerList = new PagedListHolder<Customer>();
	            customerList.setSource(custList);
	            customerList.setPageSize(5);
	            
	           
	            req.getSession().setAttribute("customerList",  customerList);
	            m.addAttribute("customerList", customerList);
	            printPageDetails(customerList);
	            
	        } else if("next".equals(type)) {
	            // Return next set of list
	        	customerList = (PagedListHolder<Customer>) req.getSession()
	                                .getAttribute("customerList");
	            
	        	customerList.nextPage();
	        	m.addAttribute("customerList", customerList);
	            printPageDetails(customerList);
	            
	        } else if("prev".equals(type)) {
	            // Return previous set of list
	        	customerList = (PagedListHolder<Customer>) req.getSession()
	                                .getAttribute("customerList");
	            
	        	customerList.previousPage();
	            
	            printPageDetails(customerList);
	            
	        } else {
	            // Return specific index set of list
	            System.out.println("type:" + type);
	            
	            customerList = (PagedListHolder<Customer>) req.getSession()
	                                .getAttribute("customerList");
	            
	            int pageNum = Integer.parseInt(type);
	            
	            customerList.setPage(pageNum);
	            
	            
	            printPageDetails(customerList);
	            m.addAttribute("customerList", customerList);
	        }
	                    
	        
	        
	        return  "clist";
	    }


	private void printPageDetails(PagedListHolder customerList) {

	System.out.println("curent page - productList.getPage() :"
	        + customerList.getPage());

	System.out.println("Total Num of pages - productList.getPageCount :"
	        + customerList.getPageCount());

	System.out.println("is First page - productList.isFirstPage :"
	        + customerList.isFirstPage());

	System.out.println("is Last page - productList.isLastPage :"
	        + customerList.isLastPage());
	}
}