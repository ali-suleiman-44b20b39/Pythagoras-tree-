package com.ece535.quiz4.svg;

public class Fill {
	public int r,g,b;
	public double opacity;

	public Fill(int r, int g, int b, double opacity) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.opacity = opacity;
	}
	public Fill() {
		super();
		this.r = 0;
		this.g = 50;
		this.b = 0;
		this.opacity = 1;
	}

}
