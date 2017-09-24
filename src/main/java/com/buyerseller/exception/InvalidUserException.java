package com.buyerseller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidUserException extends RuntimeException
{

    /**
     * Default constructor
     */
    public InvalidUserException()
    {
        super();
    }

    /**
     * Construct a new InvalidDeviceIdException for a given subject
     * 
     * @param subject asset subject
     */
    public InvalidUserException(String subject)
    {
        super(" User_Id not found in header :"+subject); //$NON-NLS-1$
    }

    private static final long serialVersionUID = 1L;

}
