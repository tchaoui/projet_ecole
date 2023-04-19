package com.location.exception;


import lombok.Data;

@Data
public class ItemAlreadyInUseException extends Exception{
    private String response ;

    public ItemAlreadyInUseException (String response){
        this.response = response;
    }
}
