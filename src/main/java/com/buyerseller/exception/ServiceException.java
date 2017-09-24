package com.buyerseller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Construct a new InvalidDeviceIdException for a given subject
	 * 
	 * @param subject
	 *            asset subject
	 */
	public ServiceException(String subject) {
		super("Buyer Seller Service failed :" + subject); //$NON-NLS-1$
	}

	private static final long serialVersionUID = 1L;

}
