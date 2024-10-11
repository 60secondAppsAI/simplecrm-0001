package com.simplecrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.simplecrm.domain.OrderItem;
import com.simplecrm.dto.OrderItemDTO;
import com.simplecrm.dto.OrderItemSearchDTO;
import com.simplecrm.dto.OrderItemPageDTO;
import com.simplecrm.dto.OrderItemConvertCriteriaDTO;
import com.simplecrm.service.GenericService;
import com.simplecrm.dto.common.RequestDTO;
import com.simplecrm.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface OrderItemService extends GenericService<OrderItem, Integer> {

	List<OrderItem> findAll();

	ResultDTO addOrderItem(OrderItemDTO orderItemDTO, RequestDTO requestDTO);

	ResultDTO updateOrderItem(OrderItemDTO orderItemDTO, RequestDTO requestDTO);

    Page<OrderItem> getAllOrderItems(Pageable pageable);

    Page<OrderItem> getAllOrderItems(Specification<OrderItem> spec, Pageable pageable);

	ResponseEntity<OrderItemPageDTO> getOrderItems(OrderItemSearchDTO orderItemSearchDTO);
	
	List<OrderItemDTO> convertOrderItemsToOrderItemDTOs(List<OrderItem> orderItems, OrderItemConvertCriteriaDTO convertCriteria);

	OrderItemDTO getOrderItemDTOById(Integer orderItemId);







}





