package com.simplecrm.dao;

import java.util.List;

import com.simplecrm.dao.GenericDAO;
import com.simplecrm.domain.Customer;





public interface CustomerDAO extends GenericDAO<Customer, Integer> {
  
	List<Customer> findAll();
	






}


