package com.titan.service;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.titan.dto.ItemTypesDTO;
import com.titan.entity.ItemTypes;
import com.titan.entity.Items;
import com.titan.exceptions.ItemNotFoundException;
import com.titan.mapper.ItemTypesMapperImpl;
import com.titan.mapper.ItemsTypesListDTOMapper;
import com.titan.repository.ItemRepository;
import com.titan.repository.ItemsRepository;

@Service
public class TitanItemServiceImpl implements TitanItemService {
     
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Autowired
	ItemTypesMapperImpl itemTypesMapperImpl;
	
	@Autowired
	ItemsTypesListDTOMapper itemsTypesListDTOMapper;
	@Override
	public String saveItemDetails(ItemTypesDTO itemTypesDTO) {
		// TODO Auto-generated method stub
		
		
		ItemTypes itemTypes = itemTypesMapperImpl.convertToEntity(itemTypesDTO);
		itemRepository.save(itemTypes);
		
	return "saved Successfully";
	}
	@Override
	public List<ItemTypesDTO> getall() throws ItemNotFoundException {
		// TODO Auto-generated method stub
		List<ItemTypes> allitems = new ArrayList<ItemTypes>() ;
		List<ItemTypesDTO> allitemsDTO =  new ArrayList<ItemTypesDTO>();
		allitems = itemRepository.findAll();
		if(allitems.isEmpty()) {
			throw new ItemNotFoundException("Item doesnot exist");
		}else {
			allitemsDTO = itemsTypesListDTOMapper.convertToDto(allitems);
		}
		
		
		return allitemsDTO;
	}
	public ItemTypesDTO findByname(String name) {
		//		returns the theater details with that theatre name
		ItemTypes itemTypes =itemRepository.findByItemCategory(name);
		ItemTypesDTO itemTypesDTO = itemTypesMapperImpl.convertToDto(itemTypes);
		return itemTypesDTO;
	}
	
	public String deleteItemTypes(int id) {
		//		deletes theater with the particular id from the database.
		itemRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
 public List<Items> sortingPriceLowtoHigh(String itemCategory) throws ItemNotFoundException{
	 
	 List<Items> items = findAllItems(itemCategory);
	 if(items.isEmpty()) {
		 throw new ItemNotFoundException("No data found in the database");
	 }
	 else {
		 Collections.sort(items,(o1,o2)->{
				// TODO Auto-generated method stub
							if (o1.getPrice() > o2.getPrice()) {
								return 0;
							} else {
								return -1;
							}
			  });
	 }
	 
	  return items;
 }
private List<Items> findAllItems(String itemCategory) {
	// TODO Auto-generated method stub
	         ItemTypes itemIndividualCategory = itemRepository.findByItemCategory(itemCategory);
	         List<Items> items = itemIndividualCategory.getItems();
	         return items;
	         
}
public List<Items> sortingPriceHightoLow(String itemCategory) throws ItemNotFoundException {
	// TODO Auto-generated method stub
	List<Items> items = findAllItems(itemCategory);
	 if(items.isEmpty()) {
		 throw new ItemNotFoundException("No data found in the database");
	 }
	 else {
		 Collections.sort(items,(o1,o2)->{
				// TODO Auto-generated method stub
							if (o1.getPrice() < o2.getPrice()) {
								return 0;
							} else {
								return -1;
							}
			  });
	 }
	 
	  return items;
}

}
