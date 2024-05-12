package com.microservice.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.currencyexchangeservice.bean.ExchangeBeanEntity;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<ExchangeBeanEntity, Long>{

	ExchangeBeanEntity findByFromAndTo(String from, String to);
	
}
