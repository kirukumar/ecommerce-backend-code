package com.titan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Entity
@Data
@Table(name="Orders")
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String delieveryAddress;
	private String delieveryDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	private Cart cart;
	

}
