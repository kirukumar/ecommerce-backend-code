package com.titan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titan.entity.ItemTypes;

public interface ItemRepository extends JpaRepository<ItemTypes, Integer> {

	public ItemTypes findByItemCategory(String name);
}
