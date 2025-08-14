package com.vendedores.backend_vendedores.services.exceptions;


public class DatabaseException extends RuntimeException {

    public DatabaseException(String messaage){
        super(messaage);
    }
}