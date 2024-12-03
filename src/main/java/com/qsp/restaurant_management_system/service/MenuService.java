package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.MenuDao;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@Service
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
	@Autowired
	ResponseStructure<Menu> responseStructure;
	@Autowired
	ResponseStructureList<Menu> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully menu inserted into DB");
		responseStructure.setData(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(int menuId)
	{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully menu fetched from DB");
		responseStructure.setData(menuDao.fetchMenuById(menuId));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Menu>> deleteMenuById(int menuId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully menu deleted from DB");
		responseStructure.setData(menuDao.deleteMenuById(menuId));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int oldId,Menu newMenu)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully menu updated into DB");
		responseStructure.setData(menuDao.updateMenu(oldId, newMenu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructureList<Menu>> findAllMenu()
	{
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all menus fetched from DB");
		responseStructureList.setData(menuDao.findAllMenu());
		return new ResponseEntity<ResponseStructureList<Menu>>(responseStructureList, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Menu>> addExistingFoodToExistingMenu(int menuId,int foodId)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added Existing Food To Existing Menu");
		responseStructure.setData(menuDao.addExistingFoodToExistingMenu(menuId, foodId));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Menu>> addNewFoodToExistingMenu(int menuId,Food food)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully added New Food To Existing Menu");
		responseStructure.setData(menuDao.addNewFoodToExistingMenu(menuId, food));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}

}
