package com.titan;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.titan.entity.Items;
import com.titan.mapper.ItemTypesMapperImpl;
import com.titan.mapper.ItemsMapperImpl;
import com.titan.mapper.ItemsTypesListDTOMapperImpl;

@SpringBootApplication
public class TitanDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TitanDatabaseApplication.class, args);
		
		System.out.println("Welcome to the Titan Database");
		
		
	}
	
	@Bean
	public ItemTypesMapperImpl getItemTypesMapper() {
		return new ItemTypesMapperImpl();
	}
	@Bean
	public ItemsMapperImpl getItemsDTOMapper() {
		return new ItemsMapperImpl();
	}
	@Bean
	public ItemsTypesListDTOMapperImpl getItemTypesListDTO() {
		return new ItemsTypesListDTOMapperImpl();
	}

}
