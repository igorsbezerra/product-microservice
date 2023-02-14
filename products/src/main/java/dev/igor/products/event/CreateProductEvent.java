package dev.igor.products.event;

import org.springframework.context.ApplicationEvent;

import dev.igor.products.model.Product;

public class CreateProductEvent extends ApplicationEvent {

    private final Product product;

    public CreateProductEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
