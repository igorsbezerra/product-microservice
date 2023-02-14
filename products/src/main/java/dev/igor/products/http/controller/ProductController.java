package dev.igor.products.http.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.igor.products.http.request.CreateProductDTO;
import dev.igor.products.http.response.ProductResponseDTO;
import dev.igor.products.model.Product;
import dev.igor.products.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponseDTO create(@RequestBody @Valid CreateProductDTO request) {
        return service.create(Product.of(request));
    }

    @GetMapping("{id}")
    public ProductResponseDTO findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping
    public List<ProductResponseDTO> findAll() {
        return service.findAll();
    }
}
