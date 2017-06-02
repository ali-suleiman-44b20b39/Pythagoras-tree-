/*-------------------------
Author: Ali Suleiman
Date: October 5, 2015
Assignment: Quiz #4
Package: com.ece535.quiz4.test
--------------------------*/


package com.ece535.quiz4.test;

import com.ece535.quiz4.svg.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SvgMaker svg = new SvgMaker(1000,1000,"svgtest.svg");
		
		Stroke strk = new Stroke();
		Fill fill = new Fill(); 
		Circle c = new Circle(150,100,40);
		Line ln = new Line(25,11,50,30);
		Path p = new Path();
		Rectangle rct = new Rectangle(100,100,50,50,strk, fill);
		RoundedRectangle rr = new RoundedRectangle(240,200,50,50,new Stroke(), new Fill(), 10);
		
		p.moveTo(10, 100).lineTo(10, 200).lineTo(300,300).closePath();
		p.fill = fill;
		fill.r = 0;
		fill.b = 195;
		fill.g = 0;
		
		strk.width = 1;
		
		c.fill.g =180;
		
		svg.drawCircle(c);
		svg.drawLine(ln);
		svg.drawPath(p);
		svg.drawRectangle(rct,-135);
		rct.x = rct.x - rct.width;
		rr.fill.b = 0;
		rr.fill.r = 200;
		rr.stroke.width=2;
		rr.stroke.r = 0;
		rr.stroke.b = 0;
		rr.stroke.g = 0;
		
		svg.drawRectangle(rct,0);
		svg.drawRectangle(rct,-135);
		svg.drawRoundedRectangle(rr);
		
		svg.close();
		
		System.out.println("done");
		

	}

}
