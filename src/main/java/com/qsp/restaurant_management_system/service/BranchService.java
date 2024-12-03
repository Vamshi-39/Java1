package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.BranchDao;
import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) 
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully branch inserted into DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) 
	{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully branch fetched from DB");
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully branch deleted from DB");
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int oldId, Branch newBranch) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully branch updated  into DB");
		responseStructure.setData(branchDao.updateBranch(oldId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructureList<Branch>> findAllBranches() 
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("sucessfully fetched All Branches From DB");
		responseStructureList.setData(branchDao.findAllBranches());
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId, int addressId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Address To Existing Branch into DB");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address address) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Address To Existing Branch into DB");
		responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int branchId, int managerId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Manager To Existing Branch into DB");
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(branchId, managerId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int branchId, Manager manager) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Manager To Existing Branch into DB");
		responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, manager));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(int branchId, int menuId) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Mneu To Existing Branch into DB");
		responseStructure.setData(branchDao.addExistingMenuToExistingBranch(branchId, menuId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(int branchId, Menu menu) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Mneu To Existing Branch into DB");
		responseStructure.setData(branchDao.addNewMenuToExistingBranch(branchId, menu));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int branchId, int employeeId) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Employee To Existing Branch into DB");
		responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId, Employee employee) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Employee To Existing Branch into DB");
		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, employee));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int branchId, int customerId) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Customer To Existing Branch into DB");
		responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(int branchId, Customer customer) 
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Customer To Existing Branch into DB");
		responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, customer));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
}
