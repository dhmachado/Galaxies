package com.mercadolibre.exam.util;

import org.springframework.stereotype.Service;

@Service
public class CoordinatesCalculator implements IRound {

	private static final double RADIANS_TO_DEGREES = Math.PI / 180;
	
	private static final int DISTANCE_BETWEEN_FERENGI_AND_SUN = 500;
	private static final int DISTANCE_BETWEEN_VULCANO_AND_SUN = 1000;
	private static final int DISTANCE_BETWEEN_BETASOIDE_AND_SUN = 2000;

	public CartesianCoordinate getFerengiCoordinatesForDay(int day) {
		return this.getCoordinates(day * 1, DISTANCE_BETWEEN_FERENGI_AND_SUN);
	}
	
	public CartesianCoordinate getVulcanoCoordinatesForDay(int day) {
		return this.getCoordinates(360 - (day * 5), DISTANCE_BETWEEN_VULCANO_AND_SUN);
	}
	
	public CartesianCoordinate getBetasoideCoordinatesForDay(int day) {
		return this.getCoordinates(day * 3, DISTANCE_BETWEEN_BETASOIDE_AND_SUN);
	}
	
	private CartesianCoordinate getCoordinates(int angleForDay, int distance) {
		final double theta = RADIANS_TO_DEGREES * angleForDay;
		final double y = distance * (Math.cos(theta));
		final double x = distance * (Math.sin(theta));
		return new CartesianCoordinate(this.round(x), this.round(y));
	}

}
