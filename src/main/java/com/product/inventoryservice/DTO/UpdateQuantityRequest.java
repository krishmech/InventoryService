package com.product.inventoryservice.DTO;

import lombok.Data;

@Data
public class UpdateQuantityRequest {
    private String productId;
    private Long quantity;
}
