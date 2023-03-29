package com.titan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titan.entity.Items;

public interface ItemsRepository extends JpaRepository<Items,Integer> {

	
	
}
