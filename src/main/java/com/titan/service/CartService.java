package com.titan.service;

import java.util.List;

import com.titan.entity.Cart;
import com.titan.exceptions.UserNotLoggedInException;

public interface CartService {
	

	
	public String postToCart(String email, Integer itemId) throws UserNotLoggedInException;
	public List<Cart> getFromCart( String email);
}
