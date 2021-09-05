package com.alkemy.ong.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessedEntity extends Exception {

    public ApiUnprocessedEntity( String message ) {
        super(message);
    }
}
