package com.titan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.titan.dto.ItemsDTO;
import com.titan.entity.ItemTypes;
import com.titan.entity.Items;
@Mapper
public interface ItemsMapper {

	@Mapping(target = "itemId", source = "itemId")
	@Mapping(target = "url", source = "url")
	@Mapping(target = "itemName", source = "itemName")
	@Mapping(target = "price", source = "price")
	@Mapping(target = "watchType", source = "watchType")
	@Mapping(target = "paymentOptions", source = "paymentOptions")
	public Items convertToDto(Items item);
	
	@Mapping(target = "itemId", source = "itemId")
	@Mapping(target = "url", source = "url")
	@Mapping(target = "itemName", source = "itemName")
	@Mapping(target = "price", source = "price")
	@Mapping(target = "watchType", source = "watchType")
	@Mapping(target = "paymentOptions", source = "paymentOptions")
	public Items convertToEntity(ItemsDTO itemDTO);
}
