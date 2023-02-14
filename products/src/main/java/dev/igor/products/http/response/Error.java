package dev.igor.products.http.response;

import java.util.Objects;

import org.springframework.lang.NonNull;

public class Error {
    private final String code;
    private final String message;
    
    public Error(@NonNull String code, @NonNull String message) {
        this.code = Objects.requireNonNull(code);
        this.message = Objects.requireNonNull(message);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
