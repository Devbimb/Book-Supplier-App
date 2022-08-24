package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan(basePackages = {"com.example.service"})
@ComponentScan({"com.example.service"})
public class AppConfig {
	   @Bean
//	    public ModelMapper mapper() {
		   ModelMapper mapper() {
	        return new ModelMapper();
	    }
}
