package com.atec.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String s){
        super(s);
    }
}
