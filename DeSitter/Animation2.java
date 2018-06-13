package pojava.brycie.DeSitter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Animation2 extends JPanel{

	
	private static final long serialVersionUID = 1L;
	static int window_width = 640;
	static int window_height = 250;
	static int R = 40;
	static int x0 = 80;
	static int y0 = 80;
	private static boolean isRunning=true;
	static int value=0;
	static double vOfQuantum = value/10 + 5;
	static int howManyRotations = (150-value);
	static int howManyQuantums = 2; // im wieksza tym mniej

	
	static ArrayList<Quantum> kwanty = new ArrayList<Quantum>();
	
	static Planet p1 = new Planet(x0,y0-R,1,Math.PI/2,howManyRotations);
	static Planet p2 = new Planet(x0,y0+R,1,3*Math.PI/2,howManyRotations);


		public void paintComponent(Graphics g){
			super.paintComponent(g);
			//nastepuja aktualizacje wartosci
			value=Interface.toChange;
			vOfQuantum = value/10 + 5;
			howManyRotations = (150-value);
			
			/*
			if(value>80)howManyQuantums = 1;
			else if(value>60)howManyQuantums = 2;
			else if(value>40)howManyQuantums = 3;
			else if(value>20)howManyQuantums = 4;
			else howManyQuantums = 4;
			*/
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.black);
			g2d.fill(new Rectangle2D.Double(0,0,window_width,window_height));
		
			
			if(isRunning){
				planetMove(p1,howManyRotations);
				planetMove(p2,howManyRotations);
				
				g2d.setColor(Color.yellow);
				g2d.fill(p1.drawPlanet());
				g2d.fill(p2.drawPlanet());
				
				if(p1.getN()%howManyQuantums==0) sendQuantum(kwanty,p1);
				if(p2.getN()%howManyQuantums==0) sendQuantum(kwanty,p2);
				
				for(int i=0;i<kwanty.size();i++){
					moveQuantum(kwanty,i);
					//System.out.println(kwanty.get(i).getV());
					changeColorQ(kwanty,i);
					g2d.setColor(kwanty.get(i).getColor());
					g2d.fill(kwanty.get(i).drawQuantum());	
				}
			}
			else{
				g2d.setColor(Color.yellow);
				g2d.fill(p1.drawPlanet());
				g2d.fill(p2.drawPlanet());
				for(int i=0;i<kwanty.size();i++){
					changeColorQ(kwanty,i);
					g2d.setColor(kwanty.get(i).getColor());
					g2d.fill(kwanty.get(i).drawQuantum());	
				}
			}
			/*
			System.out.print(kwanty.get(kwanty.size()-1).getY());
			System.out.print("  ");
			System.out.print(kwanty.get(kwanty.size()-1).getX());
			System.out.println(kwanty.size());
			*/
		}
		
		//ruch planet, obrot, zwiekszenie kroku
		void planetMove(Planet p, int howManyDeg){
			//zmienia x i y biorac pod uwage kat 
			double rotation = 2*Math.PI/howManyDeg;
			p.setDegree(p.getDegree()+rotation);
			p.setX(x0-R*Math.cos(p.getDegree()));
			p.setY(y0-R*Math.sin(p.getDegree()));
			p.setN(p.getN()+1);
		}
		
		//dodanie kwanta do tablicy, nadanie mu x i y oraz v w zaleznosci od kata
		void sendQuantum (ArrayList<Quantum> list, Planet p){
			double v; 
			if(value>0) v = Math.sin(p.getDegree());
			else v=0.17;
			Quantum q = new Quantum(p.getX()+R/2,p.getY(),v);
			q.setvOQ(vOfQuantum);
			list.add(q);
		}
		
		//ruch kwanta i usowanie z listy
		void moveQuantum (ArrayList<Quantum> list, int n){
			if(list.get(n).getX()>=window_width){
				list.remove(n);
			}
			list.get(n).setX(list.get(n).getX()+list.get(n).getvOQ()/2*list.get(n).getV()+10);
		}
		
		//zmiana koloru kwantu w zaleznosci od predkosci
		void changeColorQ (ArrayList<Quantum> list, int n){
			/*bierzemy kwant, jego v i w zaleznosci jaka ma to przesowamy w ktoras strone 
			v kwantu moze być od -1 do +1 bo sin i cos kątów 
			to sie potem mnoży gdzieś czy coś
			mozna jescze zrobic w kazdym przedziale jasniejsze i ciemniejsze odcienie
			albo coś zeby się kolorki rózniły jeszcze*/
			double qV = list.get(n).getV();
			if(qV<(-0.66)) list.get(n).setColor(Color.magenta);
			if((-0.66)<qV && qV<(-0.33)) list.get(n).setColor(Color.blue);
			if((-0.33)<qV && qV<(0.16)) list.get(n).setColor(Color.green);
			if((0.16)<qV && qV<(0.33)) list.get(n).setColor(Color.yellow);
			if((0.33)<qV && qV<(0.5)) list.get(n).setColor(Color.orange);
			if((0.5)<qV) list.get(n).setColor(Color.red);
		}
		
		public static void start() {
			//startowanie animacji
			//main(null);
			//new Animation2();
			isRunning=true;
		}
		
		
		public static void stop() {
			//włączanie animacji ze wstrzymania
			isRunning=false;
		}
		
		public static boolean ifRunning(){
			return isRunning;
		}
 
		public static void main(String[] args) {
			//new Animation2(); 

    	}	
 
}
