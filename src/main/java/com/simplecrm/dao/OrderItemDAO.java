package com.simplecrm.dao;

import java.util.List;

import com.simplecrm.dao.GenericDAO;
import com.simplecrm.domain.OrderItem;





public interface OrderItemDAO extends GenericDAO<OrderItem, Integer> {
  
	List<OrderItem> findAll();
	






}


