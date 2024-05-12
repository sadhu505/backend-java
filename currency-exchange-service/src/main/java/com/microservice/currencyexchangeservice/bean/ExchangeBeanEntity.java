package com.microservice.currencyexchangeservice.bean;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency_exchange")
@Data
public class ExchangeBeanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fromcurr")
	private String from;
	@Column(name = "tocurr")
	private String to;
	private BigDecimal conversionmultiple;
}
