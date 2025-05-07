package com.rodolfo.mongodbtest.exceptions;

public record FieldMessage(
        String fieldName,

        String message) {
}