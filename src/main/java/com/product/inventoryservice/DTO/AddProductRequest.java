package com.product.inventoryservice.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
	private String productName;
	private Long quantity;
	private Long price;
	private String productDescription;
	private String productCategory;
	private String productManufacturer;
	private String productSupplier;

}
