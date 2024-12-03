package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.CustomerDao;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully customer inserted into DB");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully customer fetched from DB");
		responseStructure.setData(customerDao.fetchCustomerById(customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully customer deleted from DB");
		responseStructure.setData(customerDao.deleteCustomerById(customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int oldId, Customer newCustomer) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully customer updated into DB");
		responseStructure.setData(customerDao.updateCustomer(oldId, newCustomer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructureList<Customer>> findAllCustomers() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all customers fetched from DB");
		responseStructureList.setData(customerDao.findAllCustomers());
		return new ResponseEntity<ResponseStructureList<Customer>>(responseStructureList, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(int foodOrderId,int customerId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing FoodOrder To Existing Customer");
		responseStructure.setData(customerDao.addExistingFoodOrderToExistingCustomer(foodOrderId, customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		
	}
	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(FoodOrder foodOrder,int customerId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New FoodOrder To Existing Customer");
		responseStructure.setData(customerDao.addNewFoodOrderToExistingCustomer(foodOrder, customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
	}
}
