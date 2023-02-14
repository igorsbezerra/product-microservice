package dev.igor.products.http.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateProductDTO {
    @NotBlank
    private String description;
    @Min(1)
    private BigDecimal amount;

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
