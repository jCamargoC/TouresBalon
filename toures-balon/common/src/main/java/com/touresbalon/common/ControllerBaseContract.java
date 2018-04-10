package com.touresbalon.common;

//import org.springframework.security.access.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ControllerBaseContract {
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BusinessException ex) {
        return ResponseFactory.buildErrorResponse(ex.getError());
    }

    /*@ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity exception403Handler(AccessDeniedException ex) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
    */
    @CrossOrigin
    @RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    //@PreAuthorize("hasAuthority('VIEW_PATIENTS')")
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
