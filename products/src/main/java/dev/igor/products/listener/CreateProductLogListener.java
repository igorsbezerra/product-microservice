package dev.igor.products.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.igor.products.event.CreateProductEvent;

@Component
public class CreateProductLogListener implements ApplicationListener<CreateProductEvent> {
    @Override
    public void onApplicationEvent(CreateProductEvent event) {
        var product = event.getProduct();
        System.out.println(product.getDescription());
    }
}
