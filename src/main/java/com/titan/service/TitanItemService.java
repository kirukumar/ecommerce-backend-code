package com.titan.service;

import java.util.List;

import com.titan.dto.ItemTypesDTO;
import com.titan.entity.ItemTypes;
import com.titan.entity.Items;
import com.titan.exceptions.ItemNotFoundException;

public interface TitanItemService {

	public String saveItemDetails(ItemTypesDTO itemTypesDTO);
	public List<ItemTypesDTO> getall() throws ItemNotFoundException;
	public String deleteItemTypes(int id);
	 public List<Items> sortingPriceLowtoHigh(String itemCategory) throws ItemNotFoundException;
	 public List<Items> sortingPriceHightoLow(String itemCategory) throws ItemNotFoundException;
}
