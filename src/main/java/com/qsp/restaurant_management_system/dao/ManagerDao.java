package com.qsp.restaurant_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;
	public Manager saveManager(Manager manager)
	{
		return managerRepo.save(manager);
	}
	public Manager fetchManagerById(int managerId)
	{
		return managerRepo.findById(managerId).get();
	}
	public Manager deleteManagerById(int managerId)
	{
		Manager manager=fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}
	public Manager updateManager(int oldId,Manager newManager)
	{
		newManager.setManagerId(oldId);
		return managerRepo.save(newManager);
	}
	public List<Manager> findAllManagers()
	{
		return managerRepo.findAll();
	}
}
