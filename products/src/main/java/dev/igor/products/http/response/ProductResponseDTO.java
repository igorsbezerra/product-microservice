package dev.igor.products.http.response;

import java.math.BigDecimal;

import dev.igor.products.model.Product;

public class ProductResponseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;

    public ProductResponseDTO(Long id, String description, BigDecimal amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }
    
    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getDescription(), product.getAmount());
    }
}
