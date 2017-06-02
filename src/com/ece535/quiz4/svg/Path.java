package com.ece535.quiz4.svg;


/*
 * 
	M = moveto
	L = lineto
	H = horizontal lineto
	V = vertical lineto
	C = curveto
	S = smooth curveto
	Q = quadratic Bézier curve
	T = smooth quadratic Bézier curveto
	A = elliptical Arc
	Z = closepath
 */

public class Path {
	public String d;
	public Stroke stroke;
	public Fill fill;
	
	public String str(double x,double y){
		return Double.toString(x)+ " " + Double.toString(y)+ " ";
	}
	
	public Path moveTo(double x,double y){
		d = d +"M"+ str(x,y);
		return this;
	}
	public Path lineTo(double x,double y){
		d = d +"L"+ str(x,y);
		return this;
	}
	public Path horizontalLineTo(double x,double y){
		d = d +"H"+ str(x,y);
		return this;
	}
	public Path() {
		d = "";
		fill = new Fill();
		stroke = new Stroke();

	}

	public Path verticalLineTo(double x,double y){
		d = d +"V"+ str(x,y);
		return this;
	}
	public Path curveTo(double x,double y){
		d = d +"C"+ str(x,y);
		return this;
	}
	public Path smoothCurveTo(double x,double y){
		d = d +"S"+ str(x,y);
		return this;
	}
	public Path quadraticBézierCurve(double x,double y){
		d = d +"Q"+ str(x,y);
		return this;
	}
	public Path smoothQuadraticBézierCurveTo(double x,double y){
		d = d +"T"+ str(x,y);
		return this;
	}
	public Path ellipticalArc(double x,double y){
		d = d +"A"+ str(x,y);
		return this;
	}
	public Path closePath(){
		d = d +"Z";
		return this;
	}
	

}
