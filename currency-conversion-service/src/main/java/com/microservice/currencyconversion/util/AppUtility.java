package com.microservice.currencyconversion.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservice.currencyconversion.service.CurrencyConversionBean;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppUtility {

	public CurrencyConversionBean getRespnseByRestTemplate(String from, String to) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> respEnt = new RestTemplate().getForEntity(
				"http://localhost:8000/exchange-service/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean respBody = respEnt.getBody();
		log.info("restClient call successfull..convMultiple: " + respBody.getConversionmultiple());
		return respBody;
	}

}
