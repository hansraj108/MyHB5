package com.hr.tmapp.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hr.tmapp.domain.FileBucket;
import com.hr.tmapp.domain.Order;
import com.hr.tmapp.service.MeasurementService;
import com.hr.tmapp.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private MeasurementService measurementService;

	private static final Logger logger = Logger.getLogger(OrderController.class);

	@RequestMapping(value = { "/user/add_order" })
	public String orderForm(@RequestParam(required = true) Integer customerId, Model m, HttpSession session) {
		logger.debug("==============> /user/add_order + orderForm + order_form <==============");
		// Integer customerId = (Integer) session.getAttribute("sessionCustId");
		Order order = new Order();
		m.addAttribute("customerId", customerId);
		m.addAttribute("orderAttribute", order);
		m.addAttribute("measurementList", measurementService.getAllMeasurementByCustomerId(customerId));
		return "order_form";
	}

	@RequestMapping(value = { "/user/showOrders" })
	// @RequestParam(required = false) Integer customerId
	// @RequestParam(required = false) Integer page,
	public ModelAndView ordersList(@RequestParam(required = true) Integer customerId, Model m, HttpSession session) {
		logger.debug("==============> /user/showOrders + ordersList + showOrders <==============");
		ModelAndView modelAndView = new ModelAndView("showOrders");

		// Integer customerId = (Integer) session.getAttribute("sessionCustId");
		System.out.println("sessionCustId" + customerId);
		session.setAttribute("showOrderCustId", customerId);
               List<Order> orderList = orderService.ordersByCustomerId(customerId);

		m.addAttribute("orderList", orderList);

		/*
		 * PagedListHolder<Order> pagedListHolder = new PagedListHolder<>(orderList);
		 * pagedListHolder.setPageSize(5); // Integer count =
		 * pagedListHolder.getPageCount(); //
		 * System.out.println("++++++++++++++++++++++ "+count);
		 * modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
		 * 
		 * if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		 * 
		 * modelAndView.addObject("page", page); if(page == null || page < 1 || page >
		 * pagedListHolder.getPageCount()){ pagedListHolder.setPage(0);
		 * modelAndView.addObject("orderList", pagedListHolder.getPageList()); } else
		 * if(page <= pagedListHolder.getPageCount()) { pagedListHolder.setPage(page-1);
		 * modelAndView.addObject("orderList", pagedListHolder.getPageList()); }
		 */
		return modelAndView;
	}

        // /user/showAllOrder
        @RequestMapping(value = { "/user/showAllOrder" })
	// @RequestParam(required = false) Integer customerId
	// @RequestParam(required = false) Integer page,
	public ModelAndView showAllOrder(Model m, HttpSession session) {
		logger.debug("==============> /user/showAllOrder + showAllOrder + showAllOrders <==============");
		ModelAndView modelAndView = new ModelAndView("showAllOrders");

		
		 List<Order> orderList = orderService.allOrders();

		m.addAttribute("orderList", orderList);

		/*
		 * PagedListHolder<Order> pagedListHolder = new PagedListHolder<>(orderList);
		 * pagedListHolder.setPageSize(5); // Integer count =
		 * pagedListHolder.getPageCount(); //
		 * System.out.println("++++++++++++++++++++++ "+count);
		 * modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
		 * 
		 * if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		 * 
		 * modelAndView.addObject("page", page); if(page == null || page < 1 || page >
		 * pagedListHolder.getPageCount()){ pagedListHolder.setPage(0);
		 * modelAndView.addObject("orderList", pagedListHolder.getPageList()); } else
		 * if(page <= pagedListHolder.getPageCount()) { pagedListHolder.setPage(page-1);
		 * modelAndView.addObject("orderList", pagedListHolder.getPageList()); }
		 */
		return modelAndView;
	}

        
        
	/// user/save_order
	@RequestMapping(value = { "/user/save_order" }, method = RequestMethod.POST)
	public String saveOrder(@RequestParam("custId") Integer customerId, @ModelAttribute("orderAttribute") Order order,
							BindingResult resultdoc, Model m, HttpSession session) throws IOException {
		logger.debug(
				"==============> /user/save_order + saveOrder + redirect:showOrders?act=sv&customerId= <==============");

		try {
			order.setCustomerId(customerId);
		//	order.setOrderStatus("PENDING");
			order.setOrderDate(new Date());
			// order.setMeasurementId((Integer)session.getAttribute("orderFormMeasurementId"));
			saveDocument(order, session);
			// return "redirect:showMeasurement?act=sv&customerId="+customerId;

			return "redirect:showOrders?act=sv&customerId=" + customerId;
		} catch (IOException ex) {

			m.addAttribute("err", ex.getMessage());
			return "order_form";
		}
	}

	private void saveDocument(Order order, HttpSession session) throws IOException {

		logger.debug("==============> saveDocument <==============");
		List<MultipartFile> photoList = order.getPhotos();
		if (null != photoList && photoList.size() > 0) {

			List<FileBucket> fbList = new ArrayList<FileBucket>();
			for (MultipartFile photo1 : photoList) {

				FileBucket fb = new FileBucket();
				fb.setName(photo1.getOriginalFilename());
				fb.setType(photo1.getContentType());
				fb.setContent(photo1.getBytes());
				fb.setOrderId(order.getOrderId());
				fb.setCustomerId((Integer) session.getAttribute("showOrderCustId"));
				fb.setMeasurementId(order.getMeasurementId());
				fb.setDescription(order.getDescription());
				fb.setSaveDate(new Date());
				orderService.saveFileBucket(fb);

				fbList.add(fb);

				/*
				 * fb.setName(photo1.getOriginalFilename());
				 * fb.setType(photo1.getContentType()); fb.setContent(photo1.getBytes());
				 * fb.setOrderId(order.getOrderId()); fb.setCustomerId(order.getCustomerId());
				 */
				order.setFileBucket(fbList);
			}
		}
		// userDocumentService.findAllUserDocument(userId);
		orderService.ordersByCustomerId(order.getCustomerId());

		orderService.save(order);
		
		Integer orderId = order.getOrderId();

		List<FileBucket> fbList2 = order.getFileBucket();
		Integer photoIds = 0;
		for (FileBucket fb : fbList2) {

			System.out.println("fb.getPhotoId(); " + fb.getPhotoId());
			photoIds = fb.getPhotoId();
			orderService.updateOrderIdInPhotos(orderId, photoIds);

		}
		

	}
	// this snippet of code for get multiple photoIds[] and pass to DB to set orderId into
	// photoIds but its not working
	/*
	 * orderService.ordersByCustomerId(order.getCustomerId());
	 * 
	 * orderService.save(order); Integer orderId = order.getOrderId();
	 * System.out.println("order.getOrderId()===================>" +
	 * order.getOrderId()); // FileBucket fb2 = new File
	 * 
	 * List<FileBucket> fbList2 = order.getFileBucket(); Integer[] photoIds = new
	 * Integer[fbList2.size()]; for(Integer i=0; i<=fbList2.size(); i++) { for(
	 * FileBucket fb : fbList2) {
	 * 
	 * System.out.println("fb.getPhotoId(); "+fb.getPhotoId()); photoIds[i] =
	 * fb.getPhotoId(); } //pass photoId[] to db and set the orderId on that array
	 * 
	 * } orderService.insertOrderIdInPhotos(orderId, photoIds); }
	 */

//	/user/showPhoto    
	@RequestMapping(value = { "/user/showPhoto" })
	public String photoList(@RequestParam("orderId") Integer orderId, @RequestParam("custId") Integer customerId,
							@RequestParam("measurementId") Integer measurementId, Model m, HttpSession session, 
							HttpServletRequest req) {
		logger.debug("==============> /user/showPhoto + photoList + showPhoto <==============");

		List<FileBucket> photoList = orderService.findAllFileBucketByCustomerId(customerId);
		m.addAttribute("photoList", photoList);
                m.addAttribute("showPhotoCustomerId", customerId);
                m.addAttribute("showPhotoMesurementId", measurementId);
		return "showPhoto";
	}
	
	@RequestMapping(value = {"/user/showOrders/change_orderStatus", "/user/showAllOrder/change_orderStatus"} )
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer orderId, @RequestParam Integer orderStatus) {
		try {
			orderService.changeOrderStatus(orderId, orderStatus);
			return "SUCCESS: Status Changed";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR: Unable to Change Status";
		}
	}
        
        
        @RequestMapping(value= {"/user/order_search"})
	public String orderSearch(Model m, @RequestParam("freeText") String freeText, HttpSession session) {
		logger.debug("==============> /user/order_search + orderSearch + showOrders <==============");
		
		Integer customerId = (Integer) session.getAttribute("showOrderCustId");
		m.addAttribute("orderList", orderService.searchOrders(customerId, freeText));
		return "showOrders";
	}
        
       
	@RequestMapping(value= {"/user/bulk_odelete"})
	public String deleteBulkOrder( @RequestParam("orderIds") Integer[] orderIds, HttpSession session) {
		logger.debug("==============> /user/bulk_odelete + deleteBulkOrder + redirect:showMeasurement?act=delBulk&custId= <==============");
		orderService.deleteAll(orderIds);
		Integer customerId = (Integer) session.getAttribute("showOrderCustId");
		return "redirect:showOrders?act=delBulk&customerId="+customerId;
	}
        
        
        @RequestMapping(value= {"/user/del_order"})
	public String deleteOrder(@RequestParam("orderId") Integer orderId, @RequestParam("customerId") Integer customerId) {
		logger.debug("==============> /user/del_order + deleteOrder + redirect:showMeasurement?act=del&custId= <==============");
		orderService.deleteOrder(orderId);
		
		return "redirect:showOrders?act=del&customerId="+customerId;
	}
        
        @RequestMapping(value = { "/download_image_{orderId}_{photoId}_{measurementId}" }, method = RequestMethod.GET)
    public String downloadFile(@PathVariable Integer orderId, @PathVariable Integer photoId, @PathVariable Integer measurementId, 
    								HttpServletResponse response, HttpSession session) throws IOException {
       logger.debug("==============> /download_document_{orderId}_{photoId} + downloadDocument + redirect:showPhoto?orderId=\"+orderId+\"&custId=\"+customerId+\"&mesurementId=\"+mesurementId <==============");
       FileBucket fileBucket = orderService.findByPhotoId(photoId);
	response.setContentType(fileBucket.getType());
    response.setContentLength(fileBucket.getContent().length);
    response.setHeader("Content-Disposition","attachment; filename=\"" + fileBucket.getName() +"\"");

    FileCopyUtils.copy(fileBucket.getContent(), response.getOutputStream());
    Integer customerId = (Integer) session.getAttribute("showPhotoCustomerId");
		return "redirect:showPhoto?orderId="+orderId+"&custId="+customerId+"&measurementId="+measurementId;
}
        
      
        @RequestMapping(value = {"/delete_image_{orderId}_{photoId}_{measurementId}"}, method = RequestMethod.GET)
        public String deleteFile(@PathVariable Integer orderId, @PathVariable Integer photoId, @PathVariable Integer measurementId,
        							HttpSession session) {
        	logger.debug("==============> /delete_image_{orderId}_{photoId}_{measurementId} + deleteFile + redirect:showPhoto?orderId=\"+orderId+\"&custId=\"+customerId+\"&measurementId=\"+measurementId <==============");
        	Integer customerId = (Integer) session.getAttribute("showOrderCustId");
        	orderService.deleteFile(photoId);
        	
        	return "redirect:user/showPhoto?act=del&orderId="+orderId+"&custId="+customerId+"&measurementId="+measurementId; // ----> java.lang.IllegalStateException: Cannot call sendRedirect() after the response has been committed
        //	return "redirect:custList";  ----> No mapping found for HTTP request with URI [/TailorMasterApp_6/custList]
        //	return "clist";
        }
        
        @RequestMapping(value= {"/user/bulk_pdelete"})
    	public String deleteBulkPhoto( @RequestParam("photoIds") Integer[] photoIds, HttpSession session) {
    		logger.debug("==============> /user/bulk_pdelete + deleteBulkPhoto + redirect:showMeasurement?act=delBulk&custId= <==============");
    		orderService.deleteSelectedPhotots(photoIds);
    		Integer customerId = (Integer) session.getAttribute("showOrderCustId");
    		Integer orderId = (Integer) session.getAttribute("showPhotoJspOrderId");
    		Integer measurementId = (Integer) session.getAttribute("showPhotoJspMeasurementId");
    		
    		
    		
    		return "redirect:showPhoto?act=delBulk&orderId="+orderId+"&custId="+customerId+"&measurementId="+measurementId; 
    	}

        @RequestMapping(value= {"/user/showSingleImage_{photoId}"})
        public String showSingleImageShow(HttpServletResponse response, @PathVariable Integer photoId) throws Exception {
        	response.setContentType("image/jpeg");
        	FileBucket image = orderService.findByPhotoId(photoId);
        	byte[] imageBytes = null;
        	imageBytes = image.getContent();
        	InputStream inputStream = new ByteArrayInputStream(imageBytes);
    		IOUtils.copy(inputStream, response.getOutputStream());
        	return "";
        }
}
