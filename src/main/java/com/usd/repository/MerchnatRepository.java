package com.usd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.usd.entity.Merchant;

@Repository
@EnableJpaRepositories
public interface MerchnatRepository extends JpaRepository<Merchant, Integer> {

	public Merchant findBymerchantEmail(String emailId);

	/* public List<Merchant> getAllUserDetails(); */

	/* public List<Merchant> deleteMerchantAccount(Integer id); */
	/*
	 * public Optional<Merchant> getdataById(Integer id);
	 * 
	 * public Merchant updateMerchantRegistration(Merchant merchant);
	 */
}
