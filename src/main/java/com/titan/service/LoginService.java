package com.titan.service;

import com.titan.entity.Login;
import com.titan.exceptions.LoginDetailsAlreadyExistException;

public interface LoginService {

	public String saveLoginDetails(Login login) throws LoginDetailsAlreadyExistException;
	public String getbyPasswordAndEmail(String email, String password);
	
}
