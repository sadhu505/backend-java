package com.test.restwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("filter")
public class FilterController {

	private static final Logger log = LoggerFactory.getLogger(FilterController.class);

	@GetMapping("/get-filter")
	public MappingJacksonValue getFilter() {
		log.info("inside getFilter controller..");
		FilterBean bean = new FilterBean("val1", "val2", "val3");

		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filter = new SimpleFilterProvider().addFilter("SampleFileterBean", propertyFilter);

		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filter);

		return mapping;
	}

	@GetMapping("/get-filter-list")
	public MappingJacksonValue getFilterList() {
		log.info("inside getFilterList controller..");

		List<FilterBean> filterList = Arrays.asList(new FilterBean("val1", "val1", "val1"),
				new FilterBean("val2", "val2", "val2"));

		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		FilterProvider filter = new SimpleFilterProvider().addFilter("SampleFileterBean", propertyFilter);

		MappingJacksonValue mapping = new MappingJacksonValue(filterList);
		mapping.setFilters(filter);

		return mapping;
	}
}
