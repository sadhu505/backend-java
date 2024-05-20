package com.example.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulFilterProxy extends ZuulFilter{

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean shouldFilter() {
		// return true/false..may implement other business logic to decide that
		// true-> we want to execute this filter for every API req
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// main functionality of this filter is written here
//		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
//		log.info("request uri -> {}, ", request.getRequestURI());
//		log.info("remote host -> {}, ", request.getRemoteHost());
		return null;
	}

	@Override
	public String filterType() {
		// pre/post/error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// to set priority if there are multiple filters
		return 1;
	}

}
