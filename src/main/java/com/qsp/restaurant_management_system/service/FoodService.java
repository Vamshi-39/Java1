package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.FoodDao;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully food inserted into DB");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int foodId)
	{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully food fetched from DB");
		responseStructure.setData(foodDao.fetchFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(int foodId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully food deleted from DB");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Food>> updateFood(int oldId,Food newFood)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully food updated into DB");
		responseStructure.setData(foodDao.updateFood(oldId, newFood));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructureList<Food>> findAllFoods()
	{
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all foods fetched from DB");
		responseStructureList.setData(foodDao.findAllFoods());
		return new ResponseEntity<ResponseStructureList<Food>>(responseStructureList, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Food>> addExistingFoodOrderToExistingFood(int foodId,int FoodOrderId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing FoodOrder To Existing Food");
		responseStructure.setData(foodDao.addExistingFoodOrderToExistingFood(foodId, FoodOrderId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Food>> addNewFoodOrderToExistingFood(int foodId,FoodOrder foodOrder)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New FoodOrder To Existing Food");
		responseStructure.setData(foodDao.addNewFoodOrderToExistingFood(foodId, foodOrder));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
	}
}
