package com.titan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int quantity;
	private int totalPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Login_email", referencedColumnName = "email")
	private Login login;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id", referencedColumnName = "itemId")
	private Items items;
	
}
