/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.touresbalon.common;

/**
 *
 * @author Aritz
 */
public class ErrorResponse extends CommonResponse {
    private int errorCode;
    private String message;

    public ErrorResponse()
    {
        super(null);
    }

    public ErrorResponse(int errorCode, String message)
    {
        super(null);
        this.errorCode = errorCode;
        this.message = message;
    }
    
    public int getErrorCode() {
            return errorCode;
    }
    public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
    }
    public String getMessage() {
            return message;
    }
    public void setMessage(String message) {
            this.message = message;
    }
}
