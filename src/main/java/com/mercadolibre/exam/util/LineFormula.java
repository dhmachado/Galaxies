package com.mercadolibre.exam.util;

/*
 *	The formula of any given line its y = mx+b 
 *  where m is the slope, and b is the y-intercept.
 */
public class LineFormula {

	private Double slope;
	private Double yIntercept;
	
	public LineFormula(Double slope, Double yIntercept) {
		this.slope = slope;
		this.yIntercept = yIntercept;
	}

	public Double getSlope() {
		return slope;
	}

	public void setSlope(Double slope) {
		this.slope = slope;
	}

	public Double getyIntercept() {
		return yIntercept;
	}

	public void setyIntercept(Double yIntercept) {
		this.yIntercept = yIntercept;
	}

	public boolean pointBelongsToThisLine(double x, double y) {
		return y == ((this.slope * x) + this.yIntercept);
	}
	
}
