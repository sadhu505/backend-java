package com.test.restwebservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonPropertyOrder({"name", "age"})
public class StudentModel {
	
	@JsonProperty("studentName")
	@Size(min=3, message="name should have atleast 2 chars")
	private String name;
	
	@JsonProperty("studentAge")
	@Schema(description = "age can not be negetive") //swaggerV3 related
	private int age;
	
	@NotNull
	private String address;

}
