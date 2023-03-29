package com.titan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.dto.ItemTypesDTO;
import com.titan.entity.Login;
import com.titan.service.LoginServiceImpl;

@RestController
@RequestMapping("/add")
@CrossOrigin
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;

//	 posting login details into the database.
	@PostMapping("/save")
	public ResponseEntity<?> postLoginDetails(@RequestBody Login login) {

		ResponseEntity<String> responseEntity;
		try {
			responseEntity = new ResponseEntity<String>(loginServiceImpl.saveLoginDetails(login), HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
		}
		return responseEntity;

	}

//	getting login details from the database.
	@GetMapping("login/{email}/{password}")
	public ResponseEntity<?> GET(@PathVariable("email") String email, @PathVariable("password") String password) {

		ResponseEntity<String> responseEntity;
		try {
			responseEntity = new ResponseEntity<String>(loginServiceImpl.getbyPasswordAndEmail(email, password),
					HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.IM_USED);

		}
		return responseEntity;
	}

}
