package com.titan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titan.entity.Login;

public interface LoginReposiory extends JpaRepository<Login, Integer> {

	public Login findByFirstName(String firstName);

	public Login findByEmailAndPassword(String email, String password);

	public Login findByEmail(String email);

}
