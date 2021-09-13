package com.usd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usd.entity.Merchant;
import com.usd.service.MerchantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/app")
public class MerchantController {

	@Autowired
	private MerchantService service;

	// register user
	@PostMapping("/registermerchat")
	public Merchant registerUser(@RequestBody Merchant merchant) throws Exception {
		String tempEmailId = merchant.getMerchantEmail();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			Merchant userObj = service.fetchUserByEmailId(tempEmailId);
			if (userObj != null) {
				throw new Exception("User with " + tempEmailId + " is already exist");
			}
		}
		Merchant userObj = null;
		userObj = service.saveMerchant(merchant);
		return merchant;

	}

	/*
	 * @DeleteMapping("/deletecustomerId/{customerId}") public List<Merchant>
	 * deleteMerchantAccountde(@PathVariable Integer customerId) { return
	 * service.deleteMerchantAccount(customerId); }
	 */

	/*
	 * @GetMapping("/getcustomerId/{customerId}") public Optional<Merchant>
	 * getDataById(@PathVariable Integer customerId) { return
	 * service.getdataById(customerId); }
	 * 
	 * @PutMapping("/updateUserRegistration") public String
	 * updateMerchantRegistration(@RequestBody Merchant merchant) { Merchant
	 * merchant1 = null; merchant1 = service.updateMerchantRegistration(merchant);
	 * return "merchant ID is successfully updated...!!";
	 * 
	 * }
	 * 
	 * @GetMapping("/showAllUserDetails") public List<Merchant> getUserDetails() {
	 * return service.getAllUserDetails(); }
	 */
}
