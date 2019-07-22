package komponentyadi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Rysowanie extends JPanel implements Serializable, Runnable{
	
    	private JTextField nameField; //pole na nazwę
	private JPasswordField passField; //pole na hasło
	private JButton loginButton; //przycisk logowania
//	private LoginListener listener; //słuchacz przycisku
    
    
    
    private int funkcja;	
	private int a;	
	private int b;	
	private int c;	
	private int d;   
        private int ee;
	
	public Rysowanie(){
		
		super();
                this.setPreferredSize(new Dimension(800,600));		
		this.setSize(this.getPreferredSize());		
		this.setOpaque(false);  //bez tła
		this.readData();
	}
	
	private void createComponents() {
		JLabel name = new JLabel("Name: ");
		JLabel password = new JLabel("Password: ");
		nameField = new JTextField();
		passField = new JPasswordField();

		//pomocniczy panel do wprowadzania danych
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 2));
		inputPanel.add(name);
		inputPanel.add(nameField);
		inputPanel.add(password);
		inputPanel.add(passField);
		//tworzymy przycisk logowania
		loginButton = new JButton("Zaloguj");
//		loginButton.addActionListener(listener);

		//pomocniczy panel do wyśrodkowania elementów
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(inputPanel, BorderLayout.CENTER);
		parentPanel.add(loginButton, BorderLayout.SOUTH);

		// dodajemy do głównego panelu
		this.add(parentPanel);
	}
        
//        public LoginPanel(LoginListener listener) {
//		super();
//		// ustawiamy layout
//		GridBagLayout gridBag = new GridBagLayout();
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.fill = GridBagConstraints.CENTER;
//		gridBag.setConstraints(this, constraints);
//		setLayout(gridBag);
//		// tworzymy komponenty logowania
//		this.listener = listener;
//		this.listener.setPanel(this);
//		createComponents();
//	}
        
//        JLabel szerokoscField = new JLabel("Objętość");
//        //String objetosc = szerokoscField.getText();
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new GridLayout(2,2));
//        inputPanel.add(szerokoscField);
//        
        private int xs = 400;
        private int ys = 275;      
	public void paint(Graphics g){
		//szkielet wykresu
		super.paintComponent(g);
		g.setColor(Color.black);
                g.drawLine(xs-300,ys,xs+300,ys);
                g.drawLine(xs,ys-270,xs,ys+270);
                
                int dlugosc = 7;
                //podziałka
                for(int i=0 ; i<=600 ; i=i+15){
                    g.drawLine(xs-300+i,ys-dlugosc,xs-300+i,ys+dlugosc);
                    g.drawLine(xs-dlugosc,ys-270+i,xs+dlugosc,ys-270+i);
                }
                
                //wartości na osi X
                int j=0;
                for(int i=-20 ; i<=20 ; i=i+5){
                    if(i==0){
                    
                        g.drawString((int) i + "",xs+dlugosc,ys+3*dlugosc);
                        j=375;
                        continue;
                    
                    }
                    g.drawString((int) i + "",xs-305+j,ys+3*dlugosc);
                    j=j+75;
                }    
                
                //wartosci na osi Y
                int j1=0;
                for(int i=-15 ; i<=15 ; i=i+5){
                    if(i==0){
                        g.drawString("18",xs+dlugosc+2,ys-265);
                        g.drawString("-19",xs+dlugosc+2,ys+274);
                        j1=300;
                        continue;
                                
                                
                    }
                    g.drawString((int)i + "",xs+dlugosc+2,ys+229-j1);
                    j1=j1+75;
                   
                }
		g.setColor(Color.blue);
                
                int ljednostek=20;
                int skala = 15;
                int x0=400;
		int y0=275;
                float x=0,xs=0,y=0,ys=0; 
                
                //petla odrysowujaca funckje
                for(float i=-ljednostek;i<=ljednostek;i=i+0.01f)
		{
			x=x0+i*skala;
			y=y0-(int)(y(i,this.funkcja)*skala);
                        if(i==-ljednostek)
			{
				xs=x;
				ys=y;
			}
                        
			g.drawLine((int)xs,(int)ys, (int)x,(int)y);
			xs=x;
			ys=y;
		}
        }
	//Uśpienie odrysowania wykresu
	public void run() {
		while(true){ //petla nieskonczona
			synchronized (this) {
				try{
					wait();
				}
				catch(InterruptedException e){
					System.err.println(e.getMessage());
				}
				this.repaint();
			}
		}
	}
	
	public void setFunction(int function){	
		this.funkcja = function;
	}
        
	public void setAValue(int a){	
		this.a = a;
	}
	
	public int getAValue(){
		return this.a;
	}
	
	public void setBValue(int b){
		this.b = b;
	}
	
	public int getBValue(){
		return this.b;
	}
	
	public void setCValue(int c){
		this.c = c;
	}
	
	public int getCValue(){
		return this.c;
	}
	
	public void setDValue(int d){
		this.d = d;
	}
	
	public int getDValue(){
		return this.d;
	}
        
        public void setEValue(int ee){
		this.ee = ee;
	}
	
	public int getEValue(){
		return this.ee;
	}
	//wybor funkcji	
	private double y(float x,int f){
		double wynik = 0;
		switch(f){
		case 0:			
			wynik = (float) a * x + (float) b;			
			break;
			
		case 1:			
			wynik = (float) a * Math.pow(x, 2d) + (float) b * x + (float) c;;			
			break;
			
		case 2:			
			wynik = (float) a * Math.pow(x, 3d) + (float) b * Math.pow(x, 2d) + (float) c * x + (float) d;			
			break;
			
		case 3:			
			wynik = (float) a * Math.pow(x, 4d) + (float) b * Math.pow(x, 3d) + (float) c * Math.pow(x, 2d) + (float) d * x + (float) ee;			
			break;
			
		}		
		return wynik;
	}
	//zapisywanie do xml'a'
	public void saveData(){
		
		XMLEncoder encoder = null;		
		try {
			encoder = new XMLEncoder(
			        new BufferedOutputStream(
			                new FileOutputStream( "Rysowanie.xml" ) ) );
		}
		catch (FileNotFoundException e) {			
			System.err.println(e.getMessage());			
			return;
		}		
		encoder.writeObject(this.a);		
		encoder.writeObject(this.b);       
		encoder.writeObject(this.c);		
		encoder.writeObject(this.d);                
                encoder.writeObject(this.ee);		
		encoder.writeObject(this.funkcja);		
		encoder.writeObject(this.hashCode());		
        encoder.close();
	}
	
	//odczytanie z xml'a
	public void readData(){	
		XMLDecoder decoder = null;	
		try {		
			decoder = new XMLDecoder(
			        new BufferedInputStream(
			                new FileInputStream( "Rysowanie.xml" ) ) );
		} 
		catch (FileNotFoundException e) {		
			System.err.println(e.getMessage());		
			return;
		}

		try{	   	                
	        this.a = Integer.parseInt(decoder.readObject().toString());
	        this.b = Integer.parseInt(decoder.readObject().toString());	        
	        this.c = Integer.parseInt(decoder.readObject().toString());	        
	        this.d = Integer.parseInt(decoder.readObject().toString());                
                this.ee = Integer.parseInt(decoder.readObject().toString());	        
	        this.funkcja = Integer.parseInt(decoder.readObject().toString());
		}
		
		catch(NumberFormatException e){
			System.err.println(e.getMessage());
			return;
		}
		//zamykanie
		finally{
			
			if(decoder != null)
				
				decoder.close();
		}
	}
}
