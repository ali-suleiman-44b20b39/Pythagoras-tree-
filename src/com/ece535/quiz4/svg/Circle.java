package com.ece535.quiz4.svg;

public class Circle {
	double cx,cy,r;
	public Stroke stroke;
	public Fill fill;

	public Circle(double cx, double cy, double r) {
		super();
		this.cx = cx;
		this.cy = cy;
		this.r = r;
		fill = new Fill();
		stroke = new Stroke();
	}

}
