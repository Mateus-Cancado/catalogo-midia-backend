package com.mateuscancado.catalogo_midia.dto;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Map;

public record StandardError (
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path,
        Map<String, String> errors
) {
    public StandardError(HttpStatus status, String message, String path) {
        this(Instant.now(), status.value(), status.getReasonPhrase(), message, path, null);
    }

    public StandardError(HttpStatus status, String message, String path, Map<String, String> errors) {
        this(Instant.now(), status.value(), status.getReasonPhrase(), message, path, errors);
    }
}
