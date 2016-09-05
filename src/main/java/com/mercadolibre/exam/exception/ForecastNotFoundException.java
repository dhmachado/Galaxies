package com.mercadolibre.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ForecastNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3643547693117914035L;

}
