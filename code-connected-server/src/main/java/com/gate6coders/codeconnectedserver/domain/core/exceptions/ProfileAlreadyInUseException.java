package com.gate6coders.codeconnectedserver.domain.core.exceptions;

public class ProfileAlreadyInUseException extends Exception{
    public ProfileAlreadyInUseException(String message){
        super(message);
    }
}
