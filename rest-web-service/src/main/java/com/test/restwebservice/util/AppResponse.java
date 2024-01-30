package com.test.restwebservice.util;

import lombok.Data;

@Data
public class AppResponse<T> {
	private int statusCode;
	private String message;
	private T data;
}
