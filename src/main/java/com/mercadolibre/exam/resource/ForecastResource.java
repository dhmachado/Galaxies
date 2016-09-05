package com.mercadolibre.exam.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.exam.api.ForecastRespDto;
import com.mercadolibre.exam.exception.NumberOutOfValueException;
import com.mercadolibre.exam.service.ForecastService;

@RestController
public class ForecastResource {

	private ForecastService forecastService;
	
	public ForecastResource(ForecastService forecastService) {
		this.forecastService = forecastService;
	}
	
	@RequestMapping(value = "/clima", method = RequestMethod.GET)
	public ForecastRespDto getForecast(@RequestParam(value = "dia", defaultValue = "1") Integer dayNumber) {
		if (dayNumber < 0 || dayNumber > 3650) {
			throw new NumberOutOfValueException("The value for the day parameter must be in between 0 and 3649.");
		}
		return forecastService.getForecastByDayNumber(dayNumber);
	}

}
