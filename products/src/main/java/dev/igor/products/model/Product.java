package dev.igor.products.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.lang.NonNull;

import dev.igor.products.http.request.CreateProductDTO;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String description;
    
    @Column(nullable = false)
    private BigDecimal amount;

    @Deprecated    
    public Product() {
    }

    public Product(@NonNull Long id, @NonNull String description, @NonNull BigDecimal amount) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
        this.amount = Objects.requireNonNull(amount);
    }

    public Product(@NonNull String description, @NonNull BigDecimal amount) {
        this.description = Objects.requireNonNull(description);
        this.amount = Objects.requireNonNull(amount);
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    public static Product of(CreateProductDTO dto) {
        return new Product(dto.getDescription(), dto.getAmount());
    }
} 
