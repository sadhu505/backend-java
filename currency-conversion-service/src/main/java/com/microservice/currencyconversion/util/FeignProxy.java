package com.microservice.currencyconversion.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.currencyconversion.service.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
public interface FeignProxy {

	@GetMapping("/exchange-service/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeMultiple(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
