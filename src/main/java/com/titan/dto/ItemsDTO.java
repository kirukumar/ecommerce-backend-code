package com.titan.dto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDTO {

	private int itemId;
	private String url;
	private String itemName;
	private int price;
	private String watchType;
	private String paymentOptions;
}
