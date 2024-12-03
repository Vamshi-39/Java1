package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.OwnerDao;
import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully owner inserted into DB");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully owner fetched from DB");
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully owner deleted from DB");
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwner(int oldId, Owner newOwner) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully owner updated into DB");
		responseStructure.setData(ownerDao.updateOwner(oldId, newOwner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructureList<Owner>> findAllOwner() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully fetched all owners from DB");
		responseStructureList.setData(ownerDao.findAllOwner());
		return new ResponseEntity<ResponseStructureList<Owner>>(responseStructureList, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(int ownerId,int restaurantId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Sucessfully added Existing Restaurant To Existing Owner");
		responseStructure.setData(ownerDao.addExistingRestaurantToExistingOwner(ownerId, restaurantId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(int ownerId,Restaurant restaurant)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Sucessfully added New Restaurant To Existing Owner");
		responseStructure.setData(ownerDao.addNewRestaurantToExistingOwner(ownerId, restaurant));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
	}
}