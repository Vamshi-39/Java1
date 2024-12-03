package com.qsp.restaurant_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	public Payment fetchPaymentById(int paymentId) {
		return paymentRepo.findById(paymentId).get();
	}

	public Payment deletePaymentById(int paymentId) {
		Payment payment = fetchPaymentById(paymentId);
		paymentRepo.delete(payment);
		return payment;
	}

	public Payment updatePayment(int oldId, Payment newPayment) {
		newPayment.setPaymentId(oldId);
		return paymentRepo.save(newPayment);
	}

	public List<Payment> findAllPayment() {
		return paymentRepo.findAll();
	}

}
