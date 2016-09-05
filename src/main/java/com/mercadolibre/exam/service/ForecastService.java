package com.mercadolibre.exam.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mercadolibre.exam.api.ForecastRespDto;
import com.mercadolibre.exam.core.Forecast;
import com.mercadolibre.exam.exception.ForecastNotFoundException;
import com.mercadolibre.exam.repository.ForecastRepository;

@Component("forecastService")
public class ForecastService {

	private ForecastRepository repo;

	public ForecastService(ForecastRepository repo) {
		this.repo = repo;
	}

	public ForecastRespDto getForecastByDayNumber(Integer dayNumber) {
		final Optional<Forecast> forecastOpt = this.repo.findByDayNumber(dayNumber);
		forecastOpt.orElseThrow(ForecastNotFoundException::new);
		final Forecast forecast = forecastOpt.get();
		return new ForecastRespDto(forecast.getDayNumber(), forecast.getWeather().getValue());
	}
	
}
