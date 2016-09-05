package com.mercadolibre.exam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mercadolibre.exam.core.Forecast;
import com.mercadolibre.exam.repository.ForecastRepository;
import com.mercadolibre.exam.util.WeatherForecastHelper;

@SpringBootApplication
public class GalaxiesApplication {

	private static final Logger log = LoggerFactory.getLogger(GalaxiesApplication.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(GalaxiesApplication.class, args);
	}

	@Bean
	public CommandLineRunner forecastWeatherForTheNextTenYears(ForecastRepository forecastRepo,
			WeatherForecastHelper weatherForecastHelper) {
		return (args) -> {
			if (forecastRepo.count() == 0) {
				IntStream.range(0, 10).parallel().forEach(year -> {
					IntStream.range(0, 365).forEach(day -> {
						final Integer dayIgnoringYear = day + (year * 365);
						forecastRepo.save(
								new Forecast(dayIgnoringYear, weatherForecastHelper.getWeatherForecastForDay(dayIgnoringYear)));
					});
				});
			}
			
			log.info("Job finished at : " + dateFormat.format(new Date()));
		};
	}

}
