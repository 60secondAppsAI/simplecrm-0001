package com.simplecrm.dao;

import java.util.List;

import com.simplecrm.dao.GenericDAO;
import com.simplecrm.domain.Order;





public interface OrderDAO extends GenericDAO<Order, Integer> {
  
	List<Order> findAll();
	






}


