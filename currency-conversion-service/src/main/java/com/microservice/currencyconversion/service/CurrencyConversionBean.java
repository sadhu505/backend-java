package com.microservice.currencyconversion.service;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionmultiple;
	private BigDecimal qty;
	private BigDecimal totalCalculatedAmount;
	private int port;
}
