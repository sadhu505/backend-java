package com.test.restwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServiceApplication.class, args);
	}
	
	@Bean
	public org.springframework.web.servlet.LocaleResolver localeResolver() {
		SessionLocaleResolver locale = new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages");
		return ms;
	}

}
