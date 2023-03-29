package com.titan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titan.entity.Cart;
import com.titan.entity.Login;
import com.titan.exceptions.LoginDetailsAlreadyExistException;
import com.titan.repository.CartRepository;
import com.titan.repository.LoginReposiory;

@Service
public class LoginServiceImpl implements LoginService{

	
	
	
	@Autowired
	LoginReposiory loginReposiory;
	
	@Autowired
	CartRepository cartRepository;
	@Override
	public String saveLoginDetails(Login login) throws LoginDetailsAlreadyExistException {
		// TODO Auto-generated method stub
		     Login loginPerson=findbyemail(login.getEmail());
//		     if(loginPerson == null) {
//		         Cart cart = new Cart();
////		         cart.setCartId(login.getLoginId());
////		         login.setCart(cart);
//		         cart.setLogin(login);
//		         cartRepository.save(cart);
		
		
	if(loginPerson == null) {
		 loginReposiory.save(login);
    	 return "Sign Up details saved Successfully";
	}
	else {
		 return "Email already exists";
	}
		    	 
		    
//		     }
//		     else {
//		    	 throw new LoginDetailsAlreadyExistException("Login details already exist");
//		     }
	     
	}

	private Login findbyemail(String email) {
		// TODO Auto-generated method stub
		return  loginReposiory.findByEmail(email);
	}

	private Login findbyname(String firstName) {
		// TODO Auto-generated method stub
		return loginReposiory.findByFirstName(firstName);
	}

	public String getbyPasswordAndEmail(String email, String password) {
		// TODO Auto-generated method stub
		
		Login login =  loginReposiory.findByEmailAndPassword(email,password);
		if(login == null) {
			return "unable to login";
		}
		else {
//		System.out.println(login);
		return "logged in successfully with email "+login.getEmail();
		}
	}
	
	
	

}
