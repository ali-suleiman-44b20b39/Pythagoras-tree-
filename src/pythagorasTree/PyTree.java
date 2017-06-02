/*-------------------------
Author: Ali Suleiman
Date: October 5, 2015
pythagorasTree
--------------------------*/

package pythagorasTree;
import java.util.ArrayList;
import com.ece535.quiz4.svg.*;

public class PyTree {
	public static double ratio = 0.70710678118654752440084436210485;
	static ArrayList<Rectangle> rList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		rList = new ArrayList<Rectangle>();
		
		
		SvgMaker svg = new SvgMaker(2000,1000,"test17.svg");	
		
		drawPyTree(650,650,100);
		for(Rectangle rx : rList){
			svg.drawRectangle(rx,rx.rotate);
		}	
		svg.close();
		System.out.println("done");

	}
	
	public static void drawPyTree(double x, double y, double side){
		
		Rectangle rect = new Rectangle(x,y-50,side,2.5*side,0);
		rList.add(rect);
		left(x,y,-180+45,side*ratio,1);
		right(x+side,y,-180+45,side*ratio,1);
		
	}
	
	public static void right(double x,double y, double angle, double side, double depth){
		if (depth >17)return;
		//angle = angle +45;
		Rectangle rect1 = new Rectangle(x,y,side,2.5*side,angle);
		rect1.fill.g = 15*(int)depth;
		rList.add(rect1);
		rect1 = new Rectangle(x,y,side,side,angle-90);
		//rect1.fill.g = 15*(int)(depth-1);
		//rList.add(rect1);
		
		double rdx = 2*side*Math.cos(Math.toRadians(angle+90));
		double rdy = 2*side*Math.sin(Math.toRadians(angle+90));
		
		double ldx = Math.sqrt((Math.pow(side,2))+(Math.pow(2*side,2)))*Math.cos(Math.toRadians(angle + 64));
		double ldy = Math.sqrt((Math.pow(side,2))+(Math.pow(2*side,2)))*Math.sin(Math.toRadians(angle + 64));
		
		
		right(x+rdx,y+rdy, angle+45,side*ratio,depth+1);
		left(x+ldx,y+ldy, angle+45,side*ratio,depth+1);
	}
	
	public static void left(double x,double y, double angle, double side, double depth){
		if (depth >17)return;
	
		Rectangle rect1 = new Rectangle(x,y,2.5*side,side,angle);
		rect1.fill.g = 15*(int)depth;
	
		rList.add(rect1);

		double ldx = 2*side*Math.cos(Math.toRadians(angle));
		double ldy = 2*side*Math.sin(Math.toRadians(angle));
		
		//double rdx = Math.sqrt((2*Math.pow(side,2)))*Math.cos(Math.toRadians(angle + 45));
		//double rdy = Math.sqrt((2*Math.pow(side,2)))*Math.sin(Math.toRadians(angle + 45));
		double rdx = Math.sqrt((Math.pow(side,2))+(Math.pow(2*side,2)))*Math.cos(Math.toRadians(angle+26));
		double rdy = Math.sqrt((Math.pow(side,2))+(Math.pow(2*side,2)))*Math.sin(Math.toRadians(angle+26));
		
		
	
		left(x + ldx, y + ldy, angle-45,side*ratio,depth+1);
		right(x+rdx,y+rdy, angle-45,side*ratio,depth+1);
		
	}
}
