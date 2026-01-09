package com.aja.exceptions;

public class PlaceAlreadyExistsException extends RuntimeException {
    public PlaceAlreadyExistsException(String message) {
        super(message);
    }
}
