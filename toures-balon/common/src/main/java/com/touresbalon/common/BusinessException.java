package com.touresbalon.common;

public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorsEnum error;

    public BusinessException(ErrorsEnum error)
    {
        super();
        this.error = error;
    }
    
    public ErrorsEnum getError()
    {
        return this.error;
    }
    
    public String getDescription()
    {
        return this.error.getDescription();
    }
    
    public int getCode()
    {
        return this.error.getCode();
    }
}
