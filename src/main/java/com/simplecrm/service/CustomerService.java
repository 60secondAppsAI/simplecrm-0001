package com.simplecrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.simplecrm.domain.Customer;
import com.simplecrm.dto.CustomerDTO;
import com.simplecrm.dto.CustomerSearchDTO;
import com.simplecrm.dto.CustomerPageDTO;
import com.simplecrm.dto.CustomerConvertCriteriaDTO;
import com.simplecrm.service.GenericService;
import com.simplecrm.dto.common.RequestDTO;
import com.simplecrm.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CustomerService extends GenericService<Customer, Integer> {

	List<Customer> findAll();

	ResultDTO addCustomer(CustomerDTO customerDTO, RequestDTO requestDTO);

	ResultDTO updateCustomer(CustomerDTO customerDTO, RequestDTO requestDTO);

    Page<Customer> getAllCustomers(Pageable pageable);

    Page<Customer> getAllCustomers(Specification<Customer> spec, Pageable pageable);

	ResponseEntity<CustomerPageDTO> getCustomers(CustomerSearchDTO customerSearchDTO);
	
	List<CustomerDTO> convertCustomersToCustomerDTOs(List<Customer> customers, CustomerConvertCriteriaDTO convertCriteria);

	CustomerDTO getCustomerDTOById(Integer customerId);







}





