package com.rodolfo.mongodbtest.exceptions;

import org.bson.types.ObjectId;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(ObjectId id) {
        super("Record not found with id: " + id);
    }

    public RecordNotFoundException(String text) {
        super("Record not found with content: " + text);
    }
}