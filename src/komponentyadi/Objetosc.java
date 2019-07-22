/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentyadi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Dell
 */
public class Objetosc extends JPanel implements Serializable{

        private JTextField szerokoscField;
        private JTextField wysokoscField;
        private JTextField glebokoscField;
        private JLabel objetoscField;
        
        private int szerokoscWartosc = 1;
        private int wysokoscWartosc = 5;
        private int glebokoscWartosc = 3;
        private int objetoscWartosc = 0;
        
                
        private JPanel szerokoscPanel;
        private JPanel wysokoscPanel;
        private JPanel glebokoscPanel;
        private JPanel objetoscPanel;
        
        private JButton obliczButton;
        String zTextBoxa;
        Integer parsedNumberSzerokosc;
        Integer parsedNumberWysokosc;
        Integer parsedNumberGlebokosc;
        String stringToParseSzerokosc;
        String stringToParseWysokosc;
        String stringToParseGlebokosc;
        
	public Objetosc(){
		super();	
		this.initialize();
	}
	
	private void initialize(){
		this.setPreferredSize(new Dimension(350,170));
		this.setSize(this.getPreferredSize());
		this.setLayout(new GridLayout(8,1));
		this.setBackground(Color.LIGHT_GRAY);
                this.add(this.createSzerokoscPanel());
                this.add(this.createWysokoscPanel());
                this.add(this.createGlebokoscPanel());
                this.add(this.createObjetoscPanel());
		this.readData();
                    obliczButton.addActionListener((ActionEvent e) -> {
                        int num = 0; 
                        saveData();
                        pobierzDane();                        
                        try{
                                parsedNumberSzerokosc = Integer.parseInt(stringToParseSzerokosc);
                                parsedNumberWysokosc = Integer.parseInt(stringToParseWysokosc);
                                parsedNumberGlebokosc = Integer.parseInt(stringToParseGlebokosc);
//                              parsedNumber = Integer.parseInt(stringToParse);
//                                JOptionPane.showMessageDialog(null, "Liczba: "
//                                + parsedNumber.intValue(), "Wynik parsowania",
//                    JOptionPane.INFORMATION_MESSAGE);  
                        }
                        catch(NumberFormatException exp){
//                            JOptionPane
//                            .showMessageDialog(null, exp.getStackTrace(),
//                            "Wynik parsowania",
//                            JOptionPane.INFORMATION_MESSAGE);
                        }
                        if(null == null)
                        
                        obliczObjetosc();
                    });
 
                //System.out.println(zTextBoxa);
		this.setVisible(true);
	}
	
        //  tworzenie pola z Label
        private JLabel createSzerokosc(){
            JLabel szerokosc = new JLabel("Szerokość");
            return szerokosc;
        }
        
        private JLabel createWysokosc(){
            JLabel wysokosc = new JLabel("Wysokość");
            return wysokosc;
        }
        
        private JLabel createGlebokosc(){
            JLabel glebokosc = new JLabel("Głębokość");
            return glebokosc;
        }  
        
        private JLabel createObjetosc(){
            JLabel objetoscLabel = new JLabel("Objętość");
            return objetoscLabel;
        }
        
        //  tworzenie field do edycji, przepisanie do zmiennej globalnej z pola szerokosc
        private JTextField createSzerokoscField(){
            if(this.szerokoscField == null){
                szerokoscField = new JTextField();
            }
            return szerokoscField;            
        }
        
        private JTextField createWysokoscField(){
            if(this.wysokoscField == null){
                wysokoscField = new JTextField();
            }
            return wysokoscField;            
        }  
        
        private JTextField createGlebokoscField(){
            if(this.glebokoscField == null){
                glebokoscField = new JTextField();
            }
            return glebokoscField;            
        } 
        
        private JLabel createObjetoscField(){
            if(this.objetoscField == null){
                objetoscField = new JLabel("Mamy 0");
            }
            return objetoscField;            
        } 
        
        private int obliczObjetosc(){
            zTextBoxa = createSzerokoscField().getText();
            szerokoscWartosc = parsedNumberSzerokosc;
            wysokoscWartosc = parsedNumberGlebokosc;
            glebokoscWartosc = parsedNumberSzerokosc;
            System.out.println(szerokoscWartosc * wysokoscWartosc * glebokoscWartosc);
            System.out.println(szerokoscWartosc);
            System.out.println(wysokoscWartosc);
            System.out.println(glebokoscWartosc);
            objetoscWartosc = szerokoscWartosc * wysokoscWartosc * glebokoscWartosc;
            objetoscField.setText(Integer.toString(objetoscWartosc));
            return objetoscWartosc;
        }
        
        private JButton obliczButton(){
            if(this.obliczButton == null){
                obliczButton = new JButton("Oblicz");
            }
            return obliczButton;
        }
        
        private void pobierzDane(){
           stringToParseSzerokosc = szerokoscField.getText(); 
           stringToParseWysokosc = wysokoscField.getText(); 
           stringToParseGlebokosc = glebokoscField.getText(); 
        }
        
        private int szerokoscWartosc(){            
            return szerokoscWartosc;
        }
        private JPanel createSzerokoscPanel(){		
            if(this.szerokoscPanel == null){			
                    this.szerokoscPanel = new JPanel();			
    //                this.objetoscPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.szerokoscPanel.setLayout(new GridLayout(1,2));			
                    this.szerokoscPanel.setOpaque(false);			
                    this.szerokoscPanel.add(this.createSzerokosc());			
                    this.szerokoscPanel.add(this.createSzerokoscField());
            }		
            return this.szerokoscPanel;
	}
        
        private JPanel createWysokoscPanel(){		
            if(this.wysokoscPanel == null){			
                    this.wysokoscPanel = new JPanel();			
    //                this.objetoscPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.wysokoscPanel.setLayout(new GridLayout(1,2));			
                    this.wysokoscPanel.setOpaque(false);			
                    this.wysokoscPanel.add(this.createWysokosc());			
                    this.wysokoscPanel.add(this.createWysokoscField());
            }		
            return this.wysokoscPanel;
	}
        
        private JPanel createGlebokoscPanel(){		
            if(this.glebokoscPanel == null){			
                    this.glebokoscPanel = new JPanel();			
    //                this.objetoscPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.glebokoscPanel.setLayout(new GridLayout(1,2));			
                    this.glebokoscPanel.setOpaque(false);			
                    this.glebokoscPanel.add(this.createGlebokosc());			
                    this.glebokoscPanel.add(this.createGlebokoscField());
                    //this.glebokoscPanel.add(this.obliczButton());
            }		
            return this.glebokoscPanel;
	}

        private JPanel createObjetoscPanel(){		
            if(this.objetoscPanel == null){			
                    this.objetoscPanel = new JPanel();			
    //                this.objetoscPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.objetoscPanel.setLayout(new GridLayout(1,3));			
                    this.objetoscPanel.setOpaque(false);			
                    this.objetoscPanel.add(this.createObjetosc());			
                    this.objetoscPanel.add(this.createObjetoscField());
                    this.objetoscPanel.add(this.obliczButton());
            }		
            return this.objetoscPanel;
	}
                
        ////////////////////////////////////////////////////////////////////////////////////////
		
	public void saveData(){
		
		XMLEncoder encoder = null;		
		try {
			encoder = new XMLEncoder(
			        new BufferedOutputStream(
			                new FileOutputStream( "Objetosc.xml" ) ) );
		}
		catch (FileNotFoundException e) {			
			System.err.println(e.getMessage());		
			return;
		}	
                System.out.println("szerokoscWartosc" + szerokoscWartosc);
		encoder.writeObject(this.szerokoscWartosc);		
		encoder.writeObject(this.wysokoscWartosc);        
		encoder.writeObject(this.glebokoscWartosc);		
		encoder.writeObject(this.objetoscWartosc); 
		
        encoder.close();
	}
	
	public void readData(){		
		XMLDecoder decoder = null;		
		try {			
			decoder = new XMLDecoder(
			        new BufferedInputStream(
			                new FileInputStream( "Objetosc.xml" ) ) );
		} 
		catch (FileNotFoundException e) {			
			System.err.println(e.getMessage());			
			return;
		}
		try{		        
	        this.szerokoscWartosc = Integer.parseInt(decoder.readObject().toString());	        
	        this.wysokoscWartosc = Integer.parseInt(decoder.readObject().toString());	        
	        this.glebokoscWartosc = Integer.parseInt(decoder.readObject().toString());	        
	        this.objetoscWartosc = Integer.parseInt(decoder.readObject().toString());  
		}		
		catch(NumberFormatException e){			
			System.err.println(e.getMessage());			
			return;
		}		
		finally{			
			if(decoder != null)				
				decoder.close();
		}
	}
}
