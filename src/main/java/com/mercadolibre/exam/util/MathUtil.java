package com.mercadolibre.exam.util;

import org.springframework.stereotype.Service;

@Service
public class MathUtil implements IRound {

	public boolean arePointsColinear(CartesianCoordinate coordinatesOne, CartesianCoordinate coordinatesTwo,
			CartesianCoordinate coordinatesThree) {
		// return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
		return (coordinatesOne.getY() - coordinatesTwo.getY())
				* (coordinatesOne.getX() - coordinatesThree.getX()) == (coordinatesOne.getY() - coordinatesThree.getY())
						* (coordinatesOne.getX() - coordinatesTwo.getX());
	}

	public LineFormula calculateLineFormulaForPoints(CartesianCoordinate coordinateOne,
			CartesianCoordinate coordinateTwo) {
		double slope = this.caculateSlope(coordinateOne, coordinateTwo);
		return new LineFormula(slope, this.calculateYInterceptForPoint(coordinateOne, slope));
	}

	public double areaOfTriangle(CartesianCoordinate coordinateOne, CartesianCoordinate coordinateTwo,
			CartesianCoordinate coordinateThree) {
		// [(x1 * y2) + (x2 * y3) + (x3 * y1)] - [(x1 * y3) + (x3 * y2) + (x2 * y1)]
		// --------------------------------------------------------------------------
		//                                     2
		double firstTerm = (coordinateOne.getX() * coordinateTwo.getY())
				+ (coordinateTwo.getX() * coordinateThree.getY()) + (coordinateThree.getX() * coordinateOne.getY());
		double secondTerm = (coordinateOne.getX() * coordinateThree.getY())
				+ (coordinateThree.getX() * coordinateTwo.getY()) + (coordinateTwo.getX() * coordinateOne.getY());
		return this.round((firstTerm - secondTerm) / 2);
	}

	private Double calculateYInterceptForPoint(CartesianCoordinate coordinateOne, double slope) {
		return this.round(coordinateOne.getY() - (slope * coordinateOne.getX()));
	}

	private double caculateSlope(CartesianCoordinate coordinateOne, CartesianCoordinate coordinateTwo) {
		return this
				.round((coordinateTwo.getY() - coordinateOne.getY()) / (coordinateTwo.getX() - coordinateOne.getX()));
	}
	
}
