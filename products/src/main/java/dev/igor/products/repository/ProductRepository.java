package dev.igor.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.igor.products.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
