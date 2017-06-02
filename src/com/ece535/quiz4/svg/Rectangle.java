package com.ece535.quiz4.svg;

public class Rectangle {
	public double x,y,width,height;
	public Stroke stroke;
	public Fill fill;
	public double rotate;
	public Rectangle(double x, double y, double width, double height, Stroke stroke, Fill fill) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stroke = stroke;
		this.fill = fill;
		this.rotate = 0;
	}
	public Rectangle(double x, double y, double width, double height, double r) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stroke = new Stroke();
		this.fill = new Fill();
		this.rotate = r;
	}

}
