package com.mercadolibre.exam.api;

import java.util.Objects;

public class ForecastRespDto {

	private Integer dayNumber;
	private String weather;

	public ForecastRespDto(Integer dayNumber, String weather) {
		this.dayNumber = dayNumber;
		this.weather = weather;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ForecastRespDto)) {
			return false;
		}

		ForecastRespDto that = (ForecastRespDto) o;
		return Objects.equals(this.dayNumber, that.dayNumber) && Objects.equals(this.weather, that.weather);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.dayNumber, this.weather);
	}

}
