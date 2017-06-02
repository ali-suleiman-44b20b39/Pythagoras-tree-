/*-------------------------
Author: Ali Suleiman
Date: October 5, 2015
Assignment: Quiz #4
Package: svg
--------------------------*/



package com.ece535.quiz4.svg;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SvgMaker {
	double imWidth = 500;
	double imHeight = 500;
	PrintWriter filename;
	
	
	public SvgMaker(double imWidth, double imHeight, String filename){
		try {
			this.filename = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String openSVGTag = "<svg\n\t\t\txmlns = \'http://www.w3.org/2000/svg\'\n\t\t\txmlns:xlink = \'http://www.w3.org/1999/xlink\'\n\t\t\tversion = \'1.1\'\n\t\t\twidth = \'{width}\'\n\t\t\theight = \'{height}\'>";
		openSVGTag = openSVGTag.replace("{width}", Double.toString(imWidth));
		openSVGTag = openSVGTag.replace("{height}", Double.toString(imHeight));
		System.out.println(openSVGTag);
		this.filename.println(openSVGTag);
		
	}
	
	public  String handleFill(String temp, Fill fill){
		String color = "rgb({red},{green},{blue})";
		temp = temp.replace("{opacity}", Double.toString(fill.opacity));
		color = color.replace("{red}", Integer.toString(fill.r));
		color = color.replace("{green}", Integer.toString(fill.g));
		color = color.replace("{blue}", Integer.toString(fill.b));
		temp = temp.replace("{fill}",color);
		
		return temp;
	}
	public  String handleStroke(String temp, Stroke stroke){
		String color = "rgb({red},{green},{blue})";
		
		temp = temp.replace("{strokeWidth}", Double.toString(stroke.width));
		color = color.replace("{red}", Integer.toString(stroke.r));
		color = color.replace("{green}", Integer.toString(stroke.g));
		color = color.replace("{blue}", Integer.toString(stroke.b));
		temp = temp.replace("{stroke}",color);
		return temp;
	}

	//Creates a circle in SVG format with a given center coordinate raduis and shade of green
	public  void drawCircle(Circle circ){
		
		/*Circle Open Tag template
		 *
		 *"<circle cx = '{cx}' cy = '{cy}' 
			r = '{radius}'
			fill = 'rgb({r},{g},{b})'
			stroke = '{stroke}' stroke-width = '{strokeWidth}'
			opacity = '{opacity}'/>";
		 */
		String circleTag = "<circle \n\tcx = '{cx}'\n\tcy = '{cy}'\n\tr = '{radius}'\n\tfill = '{fill}'\n\tstroke = '{stroke}' stroke-width = '{strokeWidth}'\n\topacity = '{opacity}'/>";
		
		circleTag = circleTag.replace("{cx}", Double.toString(circ.cx));
		circleTag = circleTag.replace("{cy}", Double.toString(circ.cy));
		circleTag = circleTag.replace("{radius}", Double.toString(circ.r));	
		circleTag = handleStroke(circleTag,circ.stroke);
		circleTag = handleFill(circleTag,circ.fill);

		filename.println(circleTag);
		
	}
	
	public  void drawRectangle(Rectangle rect,double angle){
		//<rect x = '{x}' y = '{y}' width = '{width}' height = '{height}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{fill}' opacity = '{opacity} transform = '{transform}' />
		String temp = "<rect x = '{x}' y = '{y}' width = '{width}' height = '{height}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{fill}' transform = '{transform}' />";
		temp = temp.replace("{x}",Double.toString(rect.x));
		temp = temp.replace("{y}",Double.toString(rect.y));
		temp = temp.replace("{height}",Double.toString(rect.height));
		temp = temp.replace("{width}",Double.toString(rect.width));
		temp = handleStroke(temp,rect.stroke);
		temp = handleFill(temp,rect.fill);
		temp = temp.replace("{transform}",  "rotate("+ Double.toString(angle) + " " +Double.toString(rect.x) +" "+  Double.toString(rect.y)+")" );
		filename.println(temp);
		
		
	}
	public  void drawLine(Line line){
		//<line x1 = '{x1}' y1 = '{y1}' x2 = '{x2}' y2 = '{y2}' stroke = '{stroke}' stroke-width = '{strokeWidth}' />
		String temp = "<line x1 = '{x1}' y1 = '{y1}' x2 = '{x2}' y2 = '{y2}' stroke = '{stroke}' stroke-width = '{strokeWidth}' />";
		temp = temp.replace("{x1}",Double.toString(line.x1));
		temp = temp.replace("{y1}",Double.toString(line.y1));
		temp = temp.replace("{x2}",Double.toString(line.x2));
		temp = temp.replace("{y2}",Double.toString(line.y2));
		temp = handleStroke(temp,line.stroke);
		filename.println(temp);
	}
	public  void drawRoundedRectangle(RoundedRectangle rrect){
		//<rect x = '{x}' y = '{y}' rx = '{r}' ry = '{r}' width = '{width}' height = '{height}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{fill}' opacity = '{opacity} transform = '{transform}' />
		String temp = "<rect x = '{x}' y = '{y}' rx = '{r}' ry = '{r}' width = '{width}' height = '{height}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{fill}' transform = '{transform}' />";
		temp = temp.replace("{x}",Double.toString(rrect.x));
		temp = temp.replace("{y}",Double.toString(rrect.y));
		temp = temp.replace("{height}",Double.toString(rrect.height));
		temp = temp.replace("{width}",Double.toString(rrect.width));
		temp = temp.replace("{r}",Double.toString(rrect.r));
		temp = handleStroke(temp,rrect.stroke);
		temp = handleFill(temp,rrect.fill);
		temp = temp.replace("{transform}",  "rotate("+ Double.toString(rrect.rotate) + " " +Double.toString(rrect.x) +" "+  Double.toString(rrect.y)+")" );
		filename.println(temp);
		
		
	}
	public  void drawPath(Path path){
		//<path d='{d}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{opacity}' />
		String temp = "<path d='{d}' stroke = '{stroke}' stroke-width = '{strokeWidth}' fill = '{opacity}' />";
		temp = temp.replace("{d}", path.d);
		temp = handleStroke(temp,path.stroke);
		temp = handleFill(temp,path.fill);
		filename.println(temp);
		
	}
	
	public void close(){
		String closeSVGTag = "\n</svg>";
		filename.println(closeSVGTag);
		filename.close();
		
		
	}

}
