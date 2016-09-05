package com.mercadolibre.exam.util;

import org.springframework.stereotype.Service;

import com.mercadolibre.exam.core.WeatherForecastEnum;

@Service
public class WeatherForecastHelper implements IRound {

	private static final CartesianCoordinate SUN_COORDINATES = new CartesianCoordinate(0d, 0d);

	private CoordinatesCalculator coordinatesCalculator;
	private MathUtil mathUtil;

	public WeatherForecastHelper(CoordinatesCalculator coordinatesCalculator, MathUtil mathUtil) {
		this.coordinatesCalculator = coordinatesCalculator;
		this.mathUtil = mathUtil;
	}

	public WeatherForecastEnum getWeatherForecastForDay(int day) {
		final CartesianCoordinate ferengiCoordinatesForDay = this.coordinatesCalculator
				.getFerengiCoordinatesForDay(day);
		final CartesianCoordinate vulcanoCoordinatesForDay = this.coordinatesCalculator
				.getVulcanoCoordinatesForDay(day);
		final CartesianCoordinate betasoideCoordinatesForDay = this.coordinatesCalculator
				.getBetasoideCoordinatesForDay(day);

		// The equation for this line is: x = 0, so the planets and the sun form
		// a line and therefore the weather that day will by dry
		if (ferengiCoordinatesForDay.getX().equals(0d) && vulcanoCoordinatesForDay.getX().equals(0d)
				&& betasoideCoordinatesForDay.getX().equals(0d)) {
			return WeatherForecastEnum.SEQUIA;
		}

		if (this.mathUtil.arePointsColinear(ferengiCoordinatesForDay, vulcanoCoordinatesForDay,
				betasoideCoordinatesForDay)) {
			if (this.mathUtil.calculateLineFormulaForPoints(ferengiCoordinatesForDay, betasoideCoordinatesForDay)
					.pointBelongsToThisLine(SUN_COORDINATES.getX(), SUN_COORDINATES.getY())) {
				return WeatherForecastEnum.SEQUIA;
			}
			return WeatherForecastEnum.CONDICIONES_OPTIMAS;
		} else if (this.isRainyPeriod(ferengiCoordinatesForDay, vulcanoCoordinatesForDay, betasoideCoordinatesForDay)) {
			return WeatherForecastEnum.LLUVIA;
		}
		return WeatherForecastEnum.NORMAL;
	}

	private boolean isRainyPeriod(CartesianCoordinate ferengiCoordinatesForDay,
			CartesianCoordinate vulcanoCoordinatesForDay, CartesianCoordinate betasoideCoordinatesForDay) {
		double areasSum = this.round(this.mathUtil.areaOfTriangle(SUN_COORDINATES, ferengiCoordinatesForDay,
				vulcanoCoordinatesForDay)
				+ this.mathUtil.areaOfTriangle(SUN_COORDINATES, vulcanoCoordinatesForDay, betasoideCoordinatesForDay)
				+ this.mathUtil.areaOfTriangle(SUN_COORDINATES, betasoideCoordinatesForDay, ferengiCoordinatesForDay));
		double areaTotal = this.mathUtil.areaOfTriangle(ferengiCoordinatesForDay, vulcanoCoordinatesForDay,
				betasoideCoordinatesForDay);
		return areasSum == areaTotal;
	}

}
