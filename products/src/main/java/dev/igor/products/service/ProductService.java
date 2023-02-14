package dev.igor.products.service;

import java.util.List;

import dev.igor.products.http.response.ProductResponseDTO;
import dev.igor.products.model.Product;

public interface ProductService {
    ProductResponseDTO create(Product product);
    ProductResponseDTO findOne(Long id);
    List<ProductResponseDTO> findAll();
}
