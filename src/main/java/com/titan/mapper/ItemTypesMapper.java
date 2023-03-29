package com.titan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.titan.dto.ItemTypesDTO;
import com.titan.entity.ItemTypes;

@Mapper
public interface ItemTypesMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "itemCategory", source = "itemCategory")
	@Mapping(target = "url", source = "url")
	public ItemTypesDTO convertToDto(ItemTypes itemTypes);
	
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "itemCategory", source = "itemCategory")
	@Mapping(target = "url", source = "url")
	public ItemTypes convertToEntity(ItemTypesDTO itemTypesDTO);
}
