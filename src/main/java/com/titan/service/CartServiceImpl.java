package com.titan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titan.entity.Cart;
import com.titan.entity.Items;
import com.titan.entity.Login;
import com.titan.exceptions.UserNotLoggedInException;
import com.titan.repository.CartRepository;
import com.titan.repository.ItemsRepository;
import com.titan.repository.LoginReposiory;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	LoginReposiory loginReposiory;
	
	
	@Autowired
 ItemsRepository itemsRepository ;
	

	public String postToCart(String email, Integer itemId) throws UserNotLoggedInException {
		// TODO Auto-generated method stub
		
	      Login loginDetails =	loginReposiory.findByEmail(email);
	      if(loginDetails == null) {
	    	  throw new UserNotLoggedInException("User Not Logged In");
	      }
	      else {
	    	  Cart cart = new Cart();
		      cart.setLogin(loginDetails); 
		      Optional<Items> items = itemsRepository.findById(itemId);
		      Items itemdetails =  items.get();
		       cart.setItems(itemdetails);
		       cart.setTotalPrice(itemdetails.getPrice());
		       
		       Cart cartitems = cartRepository.findByLoginAndItems(loginDetails,itemdetails);
		       if(cartitems != null) {
		    	   cart.setQuantity(cartitems.getQuantity()+1);
		    	   cart.setTotalPrice(cart.getQuantity()*itemdetails.getPrice());
		    	   cart.setCartId(cartitems.getCartId());
		    	   cartRepository.save(cart);
		    	   return "Saved Successfully";
		       }
		       else {
		    	   cart.setQuantity(1);
		    	   cartRepository.save(cart);
		    	   
		 	      return "Saved Successfully";
		       }
		     
	      }
	     
	      
	      
		
	}

	public List<Cart> getFromCart(String email) {
		// TODO Auto-generated method stub
		Login login = loginReposiory.findByEmail(email);
		List<Cart> cartdetails = new ArrayList<>();
		  cartdetails =cartRepository.findByLogin(login);
		  return cartdetails;
		        
	}

	public String deleteFromCart(String email, Integer itemId) {
		// TODO Auto-generated method stub
		
		  
		
		cartRepository.deleteByemailAndItemId(email,itemId);
		return "deleted successfully";
		
		
	}
		 
}
