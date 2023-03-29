package com.titan.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.dto.ItemTypesDTO;
import com.titan.entity.ItemTypes;
import com.titan.entity.Items;
import com.titan.exceptions.ItemNotFoundException;
import com.titan.service.TitanItemServiceImpl;

@RestController
@RequestMapping("/titan")
@CrossOrigin
public class TitanController {

	@Autowired
	TitanItemServiceImpl titanItemServiceImpl;

//	posting items into the database.
	@PostMapping("/admin/saveitems")
	public ResponseEntity<String> post(@RequestBody ItemTypesDTO itemTypesDTO) {
		ResponseEntity<String> responseEntity;
		try {
			responseEntity = new ResponseEntity<String>(titanItemServiceImpl.saveItemDetails(itemTypesDTO),
					HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}
//	getting all the items from the database

	@GetMapping("/all")
	public ResponseEntity<?> GET() {

		ResponseEntity<List<ItemTypesDTO>> responseEntity;
		try {
			responseEntity = new ResponseEntity<List<ItemTypesDTO>>(titanItemServiceImpl.getall(), HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;
	}

//	deleting particular item from the database using itemname.
	@DeleteMapping("{name}")
	public ResponseEntity<String> DELETE(@PathVariable("name") String name) {
		ResponseEntity<String> responseEntity;
		ItemTypesDTO Itemdetails = titanItemServiceImpl.findByname(name);
		int id = -1;
		if (Itemdetails != null) {
			id = Itemdetails.getId();
			String message = titanItemServiceImpl.deleteItemTypes(id);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			String errorMessage = "Theater with this ID doesnt Exists";
			responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

//	getting particular item.
	@GetMapping("itemName/{name}")
	public ResponseEntity<?> GET(@PathVariable("name") String name) {

		List<Items> items = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		try {
			ItemTypesDTO itemTypesDTO = titanItemServiceImpl.findByname(name);
			items = itemTypesDTO.getItems();
			responseEntity = new ResponseEntity<List<Items>>(items, HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;
	}

//	getting items in the sorted order in the form of ascending order.
	@GetMapping("/sortByPriceLowtoHigh/{itemCategory}")
	public ResponseEntity<?> sortByPrice(@PathVariable("itemCategory") String itemCategory) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Items> items = titanItemServiceImpl.sortingPriceLowtoHigh(itemCategory);
			responseEntity = new ResponseEntity<List<Items>>(items, HttpStatus.OK);

		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}

//getting items in the sorted order in the form of descending order.
	@GetMapping("/sortByPriceHightoLow/{itemCategory}")
	public ResponseEntity<?> sortByPriceHightoLow(@PathVariable("itemCategory") String itemCategory) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Items> items = titanItemServiceImpl.sortingPriceHightoLow(itemCategory);
			responseEntity = new ResponseEntity<List<Items>>(items, HttpStatus.OK);

		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}

}
