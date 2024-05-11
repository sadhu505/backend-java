package com.sudipto.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudipto.microservices.limitsservice.bean.Configuration;
import com.sudipto.microservices.limitsservice.bean.LimitsConfigurationBean;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LimitsController {
	
	@Autowired
	Configuration config;
	
	@GetMapping("/get-limits")
	public LimitsConfigurationBean getLimitsConfiguration() {
		log.info("inside getLimitsConfiguration controller..");
		return new LimitsConfigurationBean(config.getMax(),config.getMin());
	}
}
