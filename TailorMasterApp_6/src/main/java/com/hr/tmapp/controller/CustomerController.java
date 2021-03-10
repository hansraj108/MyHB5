package com.hr.tmapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hr.tmapp.domain.Customer;
import com.hr.tmapp.service.CustomerService;
import com.hr.tmapp.util.StringUtil;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private StringUtil stringUtil;
	
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@RequestMapping("/user/customer_form")
	public String customerForm(Model m) {
		logger.info("==============> /user/customer_form");
		m.addAttribute("command", new Customer());
		return "customer_form";
	}
	
	// /user/save_contact
	@RequestMapping(value= {"/user/save_contact"})
	public String saveOrUpdateContact(@ModelAttribute("command") Customer customer, Model m, HttpSession session) {
		logger.info("==============> /user/save_contact");
		Integer customerId = (Integer) session.getAttribute("CustomerId");
		System.out.println("CustomerId==============>"+customerId);
		
		if(customerId == null) {
		try {
			
				Integer userId = (Integer) session.getAttribute("userId");
				customer.setUserId(userId);
				logger.info("==============> customerService.save(customer)");
				customerService.save(customer);
				session.setAttribute("aCustomerId", customer.getCustomerId());
				return "redirect:custList?act=sv";
			} catch (Exception e) {
				m.addAttribute("err","Failed to save customer");
				e.printStackTrace();
				return "customer_form";
			}
		}
		else {
			try {
				customer.setCustomerId(customerId);
				logger.info("==============> customerService.update(customer)");
				customerService.update(customer);
				// here we have to remove the session attribute CustomerId ==========================>
				session.removeAttribute("CustomerId");
				return "redirect:custList?act=ed";
			} catch (Exception e) {
				m.addAttribute("err","Failed to update contact");
				e.printStackTrace();
				return "contact_form";
			}
		}
		
	}	
	
	@RequestMapping(value= {"/user/custList"})
	public ModelAndView customerList(@RequestParam(required = false) Integer page, Model m, HttpSession session, HttpServletRequest req) {
		logger.info("==============> customerList");
		 ModelAndView modelAndView = new ModelAndView("clist");
		Integer userId = (Integer) session.getAttribute("userId");
		List<Customer> customerList = customerService.findUserCustomer(userId);
		for(Customer c : customerList) {
			System.out.println("+++++++++++++++++++++++ "+c.getFirstName());
		}
		
		PagedListHolder<Customer> pagedListHolder = new PagedListHolder<>(customerList);
        pagedListHolder.setPageSize(5);
//        Integer count = pagedListHolder.getPageCount();
//        System.out.println("++++++++++++++++++++++ "+count);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("customerList", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("customerList", pagedListHolder.getPageList());
        }

        return modelAndView;
		
	}
	
	
	
	@RequestMapping(value= {"/user/edit_customer"})
	public String prepareEditForm(@RequestParam("custId") Integer customerId, Model m, HttpSession session) {
		logger.info("==============> prepareEditForm");
		session.setAttribute("CustomerId", customerId);
		Customer c = customerService.findById(customerId);
		m.addAttribute("command", c);
		
		return "customer_form";
	}
	
	@RequestMapping(value= {"/user/del_customer"})
	public String deleteCustomer(@RequestParam("custId") Integer customerId) {
		logger.info("==============> deleteContact");
		
		customerService.delete(customerId);
		return "redirect:custList?act=del";
	}
	
	@RequestMapping(value= {"/user/customer_search"})
	public String customerSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
		logger.info("==============> customerSearch");
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("customerList", customerService.findUserCustomer(userId, freeText));
		return "clist";
	}
	
	@RequestMapping(value= {"/user/bulk_cdelete"})
	public String deleteBulkCustomer(@RequestParam("cid") Integer[] contactIds) {
		logger.info("==============> deleteBulkCustomer");
		customerService.deleteAll(contactIds);
		
		return "redirect:custList?act=del";
	}
	
	/*
	 * @RequestMapping(value = "/customerList", method=RequestMethod.GET) public
	 * ModelAndView getUserLists(HttpSession session) { Integer userId = (Integer)
	 * session.getAttribute("userId"); ModelAndView mav = new ModelAndView();
	 * List<Customer> customers = customerService.findUserCustomer(userId);
	 * mav.addObject("customers", customers); mav.setViewName("contactsview");
	 * return mav; }
	 */
	
	
	
	
	
	}