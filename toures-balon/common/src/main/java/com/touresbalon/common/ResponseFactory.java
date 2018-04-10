package com.touresbalon.common;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
	public static ResponseEntity<ErrorResponse> buildErrorResponse(ErrorsEnum error) {
        return buildErrorResponse(error, HttpStatus.PRECONDITION_FAILED);
    }

    public static ResponseEntity<CommonResponse> buildResponse(Object o) {
        CommonResponse response;
        if (o instanceof List) {
            response = new ResponseListOfObjects((List) o);
        } else {
            response = new ResponseSingleObject(o);
        }

        return new ResponseEntity<CommonResponse>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ErrorResponse> buildErrorResponse(ErrorsEnum error, HttpStatus httpCode) {
        //ApplicationContext appContext = ContextLoader.getCurrentWebApplicationContext();

        //MessageSourceService messageResolver = appContext.getBean(MessageSourceService.class);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(error.getCode());
        String message = error.getDescription();

        errorResponse.setMessage(message);
        return new ResponseEntity<ErrorResponse>(errorResponse, httpCode);
    }
}
