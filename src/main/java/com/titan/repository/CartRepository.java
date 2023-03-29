package com.titan.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.titan.entity.Cart;
import com.titan.entity.Items;
import com.titan.entity.Login;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByLogin(Login login);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Cart WHERE login_email = ?1 AND item_id = ?2", nativeQuery = true)
	public void deleteByemailAndItemId(String email, Integer itemId);

	Cart findByLoginAndItems(Login loginDetails, Items itemdetails);

}
