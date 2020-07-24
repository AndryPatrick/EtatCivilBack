package com.person.Exception;

public class PersonException extends Exception{
	
	  /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final String code;

    /**
     * 
     * @param code
     * @param message
     */
    public PersonException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

}
