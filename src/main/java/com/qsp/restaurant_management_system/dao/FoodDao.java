package com.qsp.restaurant_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public Food saveFood(Food food)
	{
		return foodRepo.save(food);
	}
	public Food fetchFoodById(int foodId)
	{
		return foodRepo.findById(foodId).get();
	}
	public Food deleteFoodById(int foodId)
	{
		Food food=fetchFoodById(foodId);
		foodRepo.delete(food);
		return food;
	}
	public Food updateFood(int oldId,Food newFood)
	{
		newFood.setFoodId(oldId);
		return foodRepo.save(newFood);
	}
	public List<Food> findAllFoods()
	{
		return foodRepo.findAll();
	}
	public Food addExistingFoodOrderToExistingFood(int foodId,int FoodOrderId)
	{
		Food food=fetchFoodById(foodId);
		FoodOrder foodOrder=foodOrderDao.fetchFoodOrderById(FoodOrderId);
		List<FoodOrder> list=food.getFoodOrder();
		list.add(foodOrder);
		food.setFoodOrder(list);
		return saveFood(food);
	}
	public Food addNewFoodOrderToExistingFood(int foodId,FoodOrder foodOrder)
	{
		Food food=fetchFoodById(foodId);
		List<FoodOrder> list=food.getFoodOrder();
		list.add(foodOrder);
		food.setFoodOrder(list);
		return saveFood(food);
	}

}
