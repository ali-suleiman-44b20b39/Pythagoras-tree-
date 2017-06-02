package com.ece535.quiz4.svg;

public class Line {
	public double x1,x2,y1,y2;
	public Stroke stroke;

	public Line(double x1,  double y1, double x2, double y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		stroke = new Stroke();
	}

}
