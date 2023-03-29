package com.titan.controller;

import java.util.List;

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
import com.titan.entity.Cart;
import com.titan.service.CartServiceImpl;

@RestController
@RequestMapping("/Cart")
@CrossOrigin
public class CartController {

	@Autowired
	CartServiceImpl cartserviceImpl;

//	posting items to individual cart using email id.
	@PostMapping("/save/{email}/{itemId}")
	public ResponseEntity<String> saveToCart(@PathVariable("email") String email,
			@PathVariable("itemId") Integer itemId) {

		ResponseEntity<String> responseEntity;
		try {
			responseEntity = new ResponseEntity<String>(cartserviceImpl.postToCart(email, itemId), HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}
	
	
	
//getting all the items in the cart using email id.
	@GetMapping("get/{email}")
	public ResponseEntity<?> getAllCart(@PathVariable("email") String email) {

		ResponseEntity<?> responseEntity;
		try {
			responseEntity = new ResponseEntity<List<Cart>>(cartserviceImpl.getFromCart(email), HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}
	
//deleting particular item in the cart.
	@DeleteMapping("delete/{email}/{itemId}")
	public ResponseEntity<String> DeleteCart(@PathVariable("email") String email,
			@PathVariable("itemId") Integer itemId) {

		ResponseEntity<String> responseEntity;
		try {
			responseEntity = new ResponseEntity<String>(cartserviceImpl.deleteFromCart(email, itemId), HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;

	}

}
