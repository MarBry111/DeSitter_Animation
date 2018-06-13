package pojava.brycie.DeSitter;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Quantum
{
	
	private Color color = Color.yellow;
	
	private static double height=50, width=5;
	private double x, y;
	private double v;
	
	private double vOQ;
	
	//nie pamietam po co to bylo XD chyba do jakiejs animacji
	//public static boolean imWorking = true; 
	//public static double c = 3*10^8;
	
	public Quantum(){
		x=0; y=0;
		v=0;
	}
	
	public Quantum(double c, double d, double e){
		x=c; y=d;
		v=e;
	}
	
	public double getV(){
		return v;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public static double getHeight(){
		return height;
	}
	public double getWidth(){
		return width;
	}
	
	public void setX(double a){
		x=a;
	}
	public void setY(double a){
		y=a;
	}
	public void setV(double a){
		v=a;
	}
	public void setHeight(double h){
		height=h;
	}
	public void setWidth(double w){
		width=w;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Rectangle2D.Double drawQuantum()
	{
		Rectangle2D.Double p1 = new Rectangle2D.Double(this.x,this.y,Quantum.width,Quantum.height);
		return p1;	
	}

	public double getvOQ() {
		return vOQ;
	}

	public void setvOQ(double vOQ) {
		this.vOQ = vOQ;
	}

	

}
