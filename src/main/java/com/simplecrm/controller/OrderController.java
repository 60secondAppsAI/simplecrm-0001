package com.simplecrm.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.simplecrm.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.simplecrm.domain.Order;
import com.simplecrm.dto.OrderDTO;
import com.simplecrm.dto.OrderSearchDTO;
import com.simplecrm.dto.OrderPageDTO;
import com.simplecrm.service.OrderService;
import com.simplecrm.dto.common.RequestDTO;
import com.simplecrm.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/order")
@RestController
public class OrderController {

	private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Order> getAll() {

		List<Order> orders = orderService.findAll();
		
		return orders;	
	}

	//@ReadAccess
	@GetMapping(value = "/{orderId}")
	@ResponseBody
	public OrderDTO getOrder(@PathVariable Integer orderId) {
		
		return (orderService.getOrderDTOById(orderId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = orderService.addOrder(orderDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/orders")
	public ResponseEntity<OrderPageDTO> getOrders(OrderSearchDTO orderSearchDTO) {
 
		return orderService.getOrders(orderSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
	public ResponseEntity<?> updateOrder(@RequestBody OrderDTO orderDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = orderService.updateOrder(orderDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
