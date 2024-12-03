package com.qsp.restaurant_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.repo.AddressRepo;


@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId)
	{
		return addressRepo.findById(addressId).get();
	}
	
	public Address deleteAddressById(int addressId)
	{
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddress(Address newAddress,int oldId)
	{
		newAddress.setAddressId(oldId);
		return addressRepo.save(newAddress);
	}
	public List<Address> findAllAddress()
	{
		return addressRepo.findAll();
	}

}
