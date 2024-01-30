package com.test.restwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("SampleFileterBean")
public class FilterBean {
	private String field1;
	private String field2;
	private String field3;
}
