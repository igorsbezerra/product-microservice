package dev.igor.products.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import dev.igor.products.event.CreateProductEvent;
import dev.igor.products.http.response.ProductResponseDTO;
import dev.igor.products.model.Product;
import dev.igor.products.repository.ProductRepository;
import jakarta.persistence.NoResultException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ApplicationEventPublisher publisher;

    public ProductServiceImpl(ProductRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public ProductResponseDTO create(Product product) {
        var productSave = repository.save(product);
        publisher.publishEvent(new CreateProductEvent(this, productSave));
        return ProductResponseDTO.toDTO(productSave);
    }

    @Override
    public ProductResponseDTO findOne(Long id) {
        var product = repository.findById(id)
            .orElseThrow(() -> new NoResultException(String.format("Product not found by %d", id)));
        return ProductResponseDTO.toDTO(product);
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        var products = repository.findAll();
        return products.stream().map(ProductResponseDTO::toDTO).collect(Collectors.toList());
    }
}
