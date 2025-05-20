package com.cts;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringrestwithDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestwithDtoApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapperBean()
	{
		return new ModelMapper();
	}
}
