package com.mercadolibre.exam.core;

public enum WeatherForecastEnum {

	SEQUIA("Sequia"), 
	LLUVIA("Lluvia"), 
	CONDICIONES_OPTIMAS("Condiciones optimas"), 
	NORMAL("Normal");

	private String value;

	private WeatherForecastEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
}
