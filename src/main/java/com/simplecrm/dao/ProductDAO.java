package com.simplecrm.dao;

import java.util.List;

import com.simplecrm.dao.GenericDAO;
import com.simplecrm.domain.Product;





public interface ProductDAO extends GenericDAO<Product, Integer> {
  
	List<Product> findAll();
	






}


