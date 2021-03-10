package com.hr.tmapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.tmapp.domain.Customer;
import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.service.MeasurementService;

@Controller
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;
//	
	private static final Logger logger = Logger.getLogger(MeasurementController.class);
	
	
	
	@RequestMapping(value= {"/user/add_measurement"})
	public String measurementForm(@RequestParam("custId") Integer customerId, Model m, HttpSession session) {
		logger.debug("==============> /user/add_measurement + measurementForm + measurement_form <==============");
		
		m.addAttribute("customerId", customerId);
		m.addAttribute("command", new Measurement());
		return "measurement_form";
	}
								  
	@RequestMapping(value= {"/user/save_measurement"}, method = RequestMethod.POST)
	public String saveMeasurement(@RequestParam("custId") Integer customerId, 
								  @ModelAttribute("command") Measurement measurement, Model m, HttpSession session) {
		logger.debug("==============> /user/save_measurement + saveMeasurement + redirect:showMeasurement?act=sv&custId= <==============");
		
		Integer measurementId = (Integer) session.getAttribute("editMeasurementId");
		System.out.println("==================================="+customerId);
		if(measurementId == null) {
			try {
				
					logger.info("==============> customerService.save(customer)");
					measurementService.insertMeasurement(measurement);
					session.setAttribute("save_measurementcustomerId", customerId);
					
					return "redirect:showMeasurement?act=sv&custId="+customerId;
				} catch (Exception e) {
					m.addAttribute("err","Failed to save customer");
					e.printStackTrace();
					return "measurement_form";
				}
			}
			else {
				try {
					measurement.setMeasurementId(measurementId);
					logger.info("==============> customerService.update(customer)");
					measurementService.update(measurement);
					// here we have to remove the session attribute CustomerId ==========================>
					System.out.println("------------------------------------->"+customerId);
					session.removeAttribute("editMeasurementId");
					System.out.println("------------------------------------->"+customerId);
					return "redirect:showMeasurement?act=ed&custId="+customerId;
				} catch (Exception e) {
					m.addAttribute("err","Failed to update contact");
					e.printStackTrace();
					return "measurement_form";
				}
			}
			
		}	
		
		
	/*	
		measurement.setCustomerId(customerId);
		session.setAttribute("save_measurementcustomerId", customerId);
		measurementService.insertMeasurement(measurement);
		return "redirect:showMeasurement?act=sv&custId="+customerId;
	} */
	
	
	
	
	@RequestMapping(value= {"/user/showMeasurement"})
	public String measurementList(Model m, HttpSession session, @RequestParam("custId") Integer customerId) {
		logger.debug("==============> /user/showMeasurement + measurementList + showMeasurement <==============");
		session.setAttribute("showMeasurement_custId" , customerId);
		List<Measurement> m1 = measurementService.getAllMeasurementByCustomerId(customerId);
		
		m.addAttribute("measurementList",m1);
		return "showMeasurement";
	}
	
	@RequestMapping(value= {"/user/edit_measurement"})
	public String prepareEditForm(@RequestParam("measurementId") Integer measurementId,@RequestParam("custId") Integer customerId, Model m, HttpSession session) {
		logger.debug("==============> /user/edit_measurement + prepareEditForm + redirect:showMeasurement?act=sv&custId= <==============");
		
		session.setAttribute("editMeasurementId", measurementId);
		session.setAttribute("editCustomerId", customerId);
		Measurement measure = measurementService.getMeasurementByMeasurementId(measurementId);
		m.addAttribute("command", measure);
		
		return "measurement_form";
	}
	
	@RequestMapping(value= {"/user/del_measurement"})
	public String deleteMeasurement(@RequestParam("custId") Integer customerId, @RequestParam("measurementId") Integer measurementId) {
		logger.debug("==============> /user/del_measurement + deleteMeasurement + redirect:showMeasurement?act=del&custId= <==============");
		measurementService.deleteMeasurement(measurementId);
		
		return "redirect:showMeasurement?act=del&custId="+customerId;
	}
	
	
	@RequestMapping(value= {"/user/bulk_mdelete"})
	public String deleteBulkMeasurement( @RequestParam("measIds") Integer[] measurementId, HttpSession session) {
		logger.debug("==============> /user/bulk_mdelete + deleteBulkMeasurement + redirect:showMeasurement?act=delBulk&custId= <==============");
		measurementService.deleteAll(measurementId);
		Integer customerId = (Integer) session.getAttribute("showMeasurement_custId");
		return "redirect:showMeasurement?act=delBulk&custId="+customerId;
	}
	

								   
	@RequestMapping(value= {"/user/measurement_search"})
	public String measurementSearch(Model m, @RequestParam("freeText") String freeText, HttpSession session) {
		logger.debug("==============> /user/measurement_search + measurementSearch + showMeasurement <==============");
		
		Integer customerId = (Integer) session.getAttribute("showMeasurement_custId");
		m.addAttribute("measurementList", measurementService.searchMeasurement(customerId, freeText));
		return "showMeasurement";
	}
	
	/*
	 * // /user/edit_measurement  not working
	 * 
	 * @RequestMapping(value= {"/user/edit_measurement"}) public String
	 * prepareEditForm(@RequestParam("custId") Integer
	 * customerId, @RequestParam("measurementId") Integer measurementId, Model m,
	 * HttpSession session) {
	 * 
	 * // session.setAttribute("aCustomerId", customerId); Measurement measurement =
	 * measurementService.getMeasurementByMeasurementId(measurementId);
	 * m.addAttribute("command", measurement);
	 * 
	 * return "measurement_form"; }
	 */
}
