package com.microservice.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyconversion.service.CurrencyConversionBean;
import com.microservice.currencyconversion.util.AppUtility;
import com.microservice.currencyconversion.util.FeignProxy;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/currency-conversion")
@Slf4j
public class CurrencyConversionController {
	
	@Autowired
	AppUtility appUtil;
	
	@Autowired
	FeignProxy proxy;

	@GetMapping("/from/{from}/to/{to}/qty/{qty}")
	public CurrencyConversionBean getCalculatedAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {
		log.info("inside getCalculatedAmount controller..qty: " + qty);

		CurrencyConversionBean respBody = appUtil.getRespnseByRestTemplate(from, to);

		return new CurrencyConversionBean(respBody.getId(), from, to, respBody.getConversionmultiple(), qty,
				qty.multiply(respBody.getConversionmultiple()), respBody.getPort());

	}
	
	@GetMapping("/feign/from/{from}/to/{to}/qty/{qty}")
	public CurrencyConversionBean getCalculatedAmountFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {
		log.info("inside getCalculatedAmountFeign controller..qty: " + qty);
		
		CurrencyConversionBean respBody = proxy.retrieveExchangeMultiple(from, to);
		
		return new CurrencyConversionBean(respBody.getId(), from, to, respBody.getConversionmultiple(), qty,
				qty.multiply(respBody.getConversionmultiple()), respBody.getPort());
		
	}

}
