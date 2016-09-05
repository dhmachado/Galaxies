package com.mercadolibre.exam.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forecast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "day_number", unique = true, nullable = false)
	private Integer dayNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private WeatherForecastEnum weather;

	@Deprecated
	public Forecast() {
		// Used by Hibernate
	}
	
	public Forecast(Integer dayNumber, WeatherForecastEnum weather) {
		this.dayNumber = dayNumber;
		this.weather = weather;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public WeatherForecastEnum getWeather() {
		return weather;
	}

	public void setWeather(WeatherForecastEnum weather) {
		this.weather = weather;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Forecast)) {
			return false;
		}
		
		Forecast that = (Forecast) o;
		return Objects.equals(this.dayNumber, that.dayNumber) && Objects.equals(this.weather, that.weather);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.dayNumber, this.weather);
	}

}
