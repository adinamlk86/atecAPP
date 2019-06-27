package com.atec.service;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String s){
        super(s);
    }
}
