package com.test.restwebservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericErrorResponseModel {
	
	private String errorMsg;

	@JsonFormat(pattern = "yyyy-dd-mm hh:mm:ss a", timezone = "Asia/Kolkata")
	private Date time;
}
