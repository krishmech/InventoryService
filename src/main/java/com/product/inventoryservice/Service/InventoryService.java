package com.product.inventoryservice.Service;

import com.product.inventoryservice.DTO.AddProductRequest;
import com.product.inventoryservice.Model.InventoryItem;
import com.product.inventoryservice.Repository.InventoryRepo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public String addInventory(AddProductRequest item) {
        String productId = generateProductId();
        InventoryItem inventoryItem = InventoryItem.builder()
                .productId(productId)
                .productName(item.getProductName())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .productDescription(item.getProductDescription())
                .productCategory(item.getProductCategory())
                .productManufacturer(item.getProductManufacturer())
                .productSupplier(item.getProductSupplier())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        inventoryRepo.save(inventoryItem);
        return "Inventory item added successfully" + productId;
    }

    public String updateInventory(String productId, Long quantity) {
        InventoryItem item = inventoryRepo.findByProductId(productId);
        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);
            item.setUpdatedAt(LocalDateTime.now());
            inventoryRepo.save(item);
            return "Inventory item updated successfully";
        } else if (item.getQuantity() == 0) {
            return "Out of stock";
        }
        else {
            return "Insufficient inventory or item not found";
        }
    }


    private String generateProductId() {
        return "PROD-" + System.currentTimeMillis();
    }

}
