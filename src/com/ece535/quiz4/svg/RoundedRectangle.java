package com.ece535.quiz4.svg;

public class RoundedRectangle extends Rectangle {
	double r;
	

	public RoundedRectangle(double x, double y, double width, double height, Stroke stroke, Fill fill, double r) {
		super(x, y, width, height, stroke, fill);
		this.r = r;
	}

}
