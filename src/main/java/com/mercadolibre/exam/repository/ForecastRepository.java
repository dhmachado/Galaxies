package com.mercadolibre.exam.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mercadolibre.exam.core.Forecast;

public interface ForecastRepository extends CrudRepository<Forecast, Long> {

	Optional<Forecast> findByDayNumber(Integer dayNumber);

}
