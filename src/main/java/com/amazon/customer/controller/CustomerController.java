package com.amazon.customer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.customer.request.CustomerRequest;
import com.amazon.customer.response.CustomerResponse;
import com.amazon.customer.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	// Create Customer
	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
		
		CustomerResponse customerResponse=customerService.createCustomer(customerRequest);
		return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
	}
	
	// Find All Customer
	@GetMapping("/allCustomer")
	public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
		
		List<CustomerResponse> customerList=customerService.findAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}
	
	// Find By Customer Id
	@GetMapping("/customerById")
	public ResponseEntity<CustomerResponse> getCustomerById(@RequestParam(value = "id") Long customerId){
		
		CustomerResponse customerResponse=customerService.findCustomerById(customerId);
		return ResponseEntity.status(HttpStatus.FOUND).body(customerResponse);
	}
}