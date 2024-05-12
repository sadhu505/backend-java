package com.microservice.currencyexchangeservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ExchangeBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionmultiple;
	private int port;
	
	public ExchangeBean(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionmultiple = conversionMultiple;
	}
	
}
