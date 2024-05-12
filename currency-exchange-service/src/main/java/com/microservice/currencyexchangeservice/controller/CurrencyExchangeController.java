package com.microservice.currencyexchangeservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyexchangeservice.bean.ExchangeBean;
import com.microservice.currencyexchangeservice.bean.ExchangeBeanEntity;
import com.microservice.currencyexchangeservice.repo.CurrencyExchangeRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("exchange-service")
@Slf4j
public class CurrencyExchangeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchangeRepo repo;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeBean retrieveExchangeMultiple(@PathVariable String from, @PathVariable String to) {
		log.info("inside retrieveExchangeMultiple controller..from:{}, to:{}", from , to);
//		ExchangeBean bean = new ExchangeBean(1000L, from, to, BigDecimal.valueOf(83L));
		ExchangeBean bean = new ExchangeBean();
		
		ExchangeBeanEntity ent = repo.findByFromAndTo(from, to);
		
		if (ent != null) {
			log.info("entity found!");
			BeanUtils.copyProperties(ent, bean);
		} else
			log.info("entity NOT found!");
			
		
		int portName = Integer.parseInt(env.getProperty("local.server.port"));
		bean.setPort(portName);
		return bean;
	}
}
