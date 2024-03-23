package com.projeto.curso.Services.ServicesExceptions;

public class getException extends RuntimeException {
    public getException(long id) {
        super("Elemento com id " + id + " não encontrado");
    }
}
