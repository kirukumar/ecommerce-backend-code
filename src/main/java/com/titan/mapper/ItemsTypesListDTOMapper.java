package com.titan.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.titan.dto.ItemTypesDTO;
import com.titan.entity.ItemTypes;
import com.titan.entity.Items;


@Mapper
public interface ItemsTypesListDTOMapper {

	
	

	@Mapping(target = "id", source = "id")
	@Mapping(target = "itemCategory", source = "itemCategory")
	@Mapping(target = "url", source = "url")
			public List<ItemTypesDTO> convertToDto(List<ItemTypes> items);
			
	@Mapping(target = "id", source = "id")
	@Mapping(target = "itemCategory", source = "itemCategory")
	@Mapping(target = "url", source = "url")
			public List<ItemTypes> convertToEntity(List<ItemTypesDTO> itemTypesDTO );
		}

