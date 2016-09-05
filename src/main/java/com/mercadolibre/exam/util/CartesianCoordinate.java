package com.mercadolibre.exam.util;

public class CartesianCoordinate {

	private Double x;
	private Double y;
	
	public CartesianCoordinate(Double x, Double y) {
		this.setX(x);
		this.setY(y);
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
	
}
