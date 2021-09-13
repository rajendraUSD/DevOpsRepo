package com.usd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.entity.Merchant;
import com.usd.repository.MerchnatRepository;

@Service
public class MerchantService {

	@Autowired
	private MerchnatRepository merchnatRepo;

	public Merchant fetchUserByEmailId(String email) {
		return merchnatRepo.findBymerchantEmail(email);

	}
   
	public Merchant saveMerchant(Merchant merchant) {
		return merchnatRepo.save(merchant);
	}

	/*
	 * public List<Merchant> getAllUserDetails() { return merchnatRepo.findAll(); }
	 */

	/*
	 * public List<Merchant> deleteMerchantAccount(Integer customerId) {
	 * merchnatRepo.deleteById(customerId); return merchnatRepo.findAll(); }
	 */

	/*
	 * public Optional<Merchant> getdataById(Integer customerId) { return
	 * merchnatRepo.findById(customerId); }
	 * 
	 * public Merchant updateMerchantRegistration(Merchant merchant) { return
	 * merchnatRepo.save(merchant); }
	 */

}
