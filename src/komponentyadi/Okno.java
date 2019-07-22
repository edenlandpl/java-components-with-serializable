/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentyadi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class Okno extends JPanel{

	private Objetosc objetosc;
        private HelloWorldInterface helloWorld;
        private KalkulatorWalutowyInterface kalkulatorWalutowy;
        private KalkulatorInterface kalkulator;
        private BramkiInterface bramki;
	public Okno(){
		
		super();
                this.setPreferredSize(new Dimension(800,400));	
		this.setSize(this.getPreferredSize());		
		this.setLayout(new GridLayout(0,1));		
		this.setBackground(Color.lightGray);				
		this.add(this.createObjetosc());	
                this.add(this.createHelloWorld());
                this.add(this.kalkulatorWalutowy());
                this.add(this.kalkulator());
                this.add(this.bramki());
		this.setVisible(true);
	}
	

	private Objetosc createObjetosc(){		
		if(this.objetosc == null){			
			this.objetosc = new Objetosc();
		}		
		return this.objetosc;
	}
	
        	private HelloWorldInterface createHelloWorld(){		
		if(this.helloWorld == null){			
			this.helloWorld = new HelloWorldInterface();
		}		
		return this.helloWorld;
	}
                
                private KalkulatorWalutowyInterface kalkulatorWalutowy(){		
		if(this.kalkulatorWalutowy == null){			
			this.kalkulatorWalutowy = new KalkulatorWalutowyInterface();
		}		
		return this.kalkulatorWalutowy;
	}
                
              private KalkulatorInterface kalkulator(){		
		if(this.kalkulator == null){			
			this.kalkulator = new KalkulatorInterface();
		}		
		return this.kalkulator;
	}
        
        private BramkiInterface bramki(){		
		if(this.bramki == null){			
			this.bramki = new BramkiInterface();
		}		
		return this.bramki;
	}
              

		
	public void saveDataOpcje(){	
		this.objetosc.saveData();
	}
	public void saveDataObjetosc(){	
		this.objetosc.saveData();
	}
        public void saveDataBramki(){	
		this.bramki.saveData();
	}
	public void readDataBramki(){	
		this.bramki.readData();
	}
}
