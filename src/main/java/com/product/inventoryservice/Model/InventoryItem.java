package com.product.inventoryservice.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Inventoryitems")

public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String productName;
    private Long quantity;
    private Long price;
    private String productDescription;
    private String productCategory;
    private String productManufacturer;
    private String productSupplier;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}