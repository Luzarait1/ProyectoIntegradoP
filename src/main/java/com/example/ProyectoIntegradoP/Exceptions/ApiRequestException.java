package com.example.ProyectoIntegradoP.Exceptions;

//Se crean las excepciones necesarias
public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
