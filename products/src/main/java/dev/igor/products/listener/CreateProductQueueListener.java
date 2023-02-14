package dev.igor.products.listener;

import dev.igor.products.event.CreateProductEvent;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;

@Component
public class CreateProductQueueListener implements ApplicationListener<CreateProductEvent> {

    private static final Logger logger = Logger.getLogger(CreateProductQueueListener.class.getName());

    private final ObjectMapper mapper;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCreateProduct;

    public CreateProductQueueListener(ObjectMapper mapper, RabbitTemplate rabbitTemplate, Queue queueCreateProduct) {
        this.mapper = mapper;
        this.rabbitTemplate = rabbitTemplate;
        this.queueCreateProduct = queueCreateProduct;
    }

    @Override
    public void onApplicationEvent(CreateProductEvent event) {
        try {
            var product = event.getProduct();
            String json = mapper.writeValueAsString(product);
            rabbitTemplate.convertAndSend(queueCreateProduct.getName(), json);
        } catch (JsonProcessingException e) {
            logger.finer(e.getMessage());
        }
    }
}
