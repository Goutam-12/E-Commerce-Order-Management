package com.amazon.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amazon.customer.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	@Query("select c from CustomerEntity c LEFT JOIN FETCH c.orders")
	public List<CustomerEntity> findAllCustomerWithOrder();
}