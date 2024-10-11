package com.simplecrm.dao;

import java.util.List;

import com.simplecrm.dao.GenericDAO;
import com.simplecrm.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}


