package com.buyerseller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.buyerseller.common.ResourceMessageUtil;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BidExpiredException extends RuntimeException
{

    /**
     * Default constructor
     */
    public BidExpiredException()
    {
        super();
    }

    /**
     * Construct a new InvalidDeviceIdException for a given subject
     * 
     * @param subject asset subject
     */
    public BidExpiredException(String subject)
    {
        super(" Bid already expired :"+subject); //$NON-NLS-1$
    }

    private static final long serialVersionUID = 1L;

}
