package com.location.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class ItemNotFoundException extends Exception{

    private String parentItem ;
    private String childItem ;

}
