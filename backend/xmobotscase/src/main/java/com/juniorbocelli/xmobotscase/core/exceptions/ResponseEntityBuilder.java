package com.juniorbocelli.xmobotscase.core.exceptions;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError globalResponseException) {
        return new ResponseEntity<>(globalResponseException, globalResponseException.getStatus());
    }
}
