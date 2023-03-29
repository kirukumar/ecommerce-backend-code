package com.titan.dto;

import java.util.List;

import com.titan.entity.Items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemTypesDTO {

	private int id;
	private String itemCategory;
	private String url;
	private List<Items> items;
	
}
