package com.mercadolibre.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberOutOfValueException extends RuntimeException {

	private static final long serialVersionUID = -7768269239006922318L;

	public NumberOutOfValueException(String message) {
		super(message);
	}

}
