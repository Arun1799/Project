package com.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ems.config.JwtFilter;

//@Configuration, @EnableAutoConfiguration , @ComponentScan
@SpringBootApplication
public class EmsApplication {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean register = new FilterRegistrationBean();
		register.setFilter(new JwtFilter());
		register.addUrlPatterns("/api/*");
		return register;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
		System.out.println("Employee management system is running...");
	}

}
