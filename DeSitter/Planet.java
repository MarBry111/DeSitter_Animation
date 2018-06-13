package pojava.brycie.DeSitter;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Planet
{

	private Color color = Color.WHITE;
	
	private static double radius=25;
	private double x;
	private double y;
	private double v, degree; //dajemy mu w radianach
	private int n_max,n; //ilosc krokow w obrocie  aktualny krok
	
	public Planet(){
		x=0; y=0;
		v=0;
		degree = 0;
	}
	
	public Planet( double b, double c, double d, double e, int f){
		x=b; y=c;
		v=d;
		degree = e;
		n_max = f;
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
	public static double getRadius(){
		return radius;
	}
	public double getDegree(){
		return degree;
	}
	public int getN(){
		return n;
	}
	
	public void setX(double a){
		x=a;
	}
	public void setV(double a){
		v=a;
	}
	public void setY(double a){
		y=a;
	}
	
	void setDegree(double d){
		if(d>=2*Math.PI) degree= d-2*Math.PI;
		else degree= d;
	}
	public void setN(int a){
		if(a==n_max) n=0;
		else n=a;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Ellipse2D.Double drawPlanet()
	{
		Ellipse2D.Double p1 = new Ellipse2D.Double(this.x,this.y,(Planet.radius*2),(Planet.radius*2));
		return p1;	
	}

}
