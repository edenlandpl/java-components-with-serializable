/**
 * author Adrian, 2019.01.02, License MIT 
 */
package komponentyadi;

import java.awt.Color;
import static java.awt.Color.green;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BramkiInterface extends JPanel{
    
    private JPanel BramkiPanel;
    private BramkiKomponent B1;
    private BramkiKomponent B2;
    private BramkiKomponent przeliczonePLN1;
    private BramkiKomponent przeliczoneEURO1;
    int PLN , EURO,PLN1, EURO1, pobranePLN, pobraneEURO;
    double parsedPLN, parsedEURO;
    String stringToParsedPLN, stringToParsedEURO, stringPLN, stringEURO, stringPLN1, stringEURO1;
    String colorButton = new String("Color.LIGHT_GRAY");
    int b1 = 0, b2 = 0, A1, A2, A3, A4, sb1, sb2, index = 0;
    
    private JLabel createA1, createA2, createA3, createA4, LA1, LA2, LA3, LA4;
    private JTextField fieldPLN;
    private JLabel labelEURO;
    private JLabel labelEURO1, labelEURO2;
    private JTextField fieldEURO;
    private JButton obliczButtonPLN;
    private Color[] colors = { Color.GREEN, Color.BLUE, Color.RED, Color.LIGHT_GRAY, Color.WHITE };
    
    JRadioButton r1=new JRadioButton("0");    
    JRadioButton r2=new JRadioButton("1");  
    JRadioButton r3=new JRadioButton("0");    
    JRadioButton r4=new JRadioButton("1");  
    
    JRadioButton bc1=new JRadioButton("Niebieski");    
    JRadioButton bc2=new JRadioButton("Czerwony");  
    JRadioButton bc3=new JRadioButton("Szary");    
    JRadioButton bc4=new JRadioButton("Biały");  
    	public BramkiInterface(){
		
		super();
                readData();
                b1 = sb1;
                b2 = sb2;
                this.setPreferredSize(new Dimension(800,400));	
		this.setSize(this.getPreferredSize());		
		this.setLayout(new GridLayout(0,1));		
		this.setBackground(Color.lightGray);				
//		this.add(this.createBramki());					
		this.setVisible(true); 
                this.initialize();
	}
    
    private void initialize(){
                B1 = new BramkiKomponent();
                B2 = new BramkiKomponent();
        	this.setPreferredSize(new Dimension(350,270));
		this.setSize(this.getPreferredSize());
		this.setLayout(new GridLayout(1,1));
		this.setBackground(Color.LIGHT_GRAY);
                this.add(this.createBramkiPanel());
                obliczButtonPLN.addActionListener((ActionEvent e) -> {
                        try{
                                 if (r1.isSelected()) {
                                    b1 = 0;
                                    }
                                else{
                                        b1 = 1;
                                }
                                if (r3.isSelected()) {
                                        b2 = 0;
                                    }
                                else{
                                        b2 = 1;
                                }
                                System.out.println("b1  " + b1);
                                System.out.println("b2 " + b2);
                                sb1 = b1;
                                sb2 = b2;
                                B1.setb1(b1);
                                B1.setb2(b2);
                                saveData();
                                A1 = B1.getAND();
                                A2 = B1.getOR();
                                A3 = B1.getNOT1();
                                A4 = B1.getNOT2();
                                createA1.setText(Integer.toString(A1));
                                createA2.setText(Integer.toString(A2));
                                createA3.setText(Integer.toString(A3));
                                createA4.setText(Integer.toString(A4));
                                if(bc1.isSelected()){
                                    index = 1;
                                }
                                if(bc2.isSelected()){
                                    index = 2;
                                }
                                if(bc3.isSelected()){
                                    index = 3;
                                }
                                if(bc4.isSelected()){
                                    index = 4;
                                }
                                obliczButtonPLN.setBackground(colors[index]);
                                repaint();
                        }
                        catch(NumberFormatException exp){
//                            
                        }
                                System.out.println("A1  " + A1);
                                System.out.println("A2 " + A2);
//                        konwertuj();
                    });
		this.setVisible(true);
    }
    
    private JPanel createBramkiPanel(){
        if(this.BramkiPanel == null){
            this.BramkiPanel = new JPanel();		
                    this.BramkiPanel.setLayout(new GridLayout(0,2));	
            r1.setBounds(75,50,100,30);    
            r2.setBounds(75,100,100,30);    
            ButtonGroup bg=new ButtonGroup(); 
            if(sb1 == 0){
            r1.setSelected(true);}
            else{
                r2.setSelected(true);
            }
            bg.add(r1);bg.add(r2);    
            BramkiPanel.add(r1);BramkiPanel.add(r2);  
            r3.setBounds(75,50,100,30);    
            r4.setBounds(75,100,100,30);    
            ButtonGroup bg1=new ButtonGroup();  
            if(sb2 == 0){
                r3.setSelected(true);}
            else{
                r4.setSelected(true);
            }
            bg1.add(r3);bg1.add(r4);    
            BramkiPanel.add(r3);BramkiPanel.add(r4);  

//            this.BramkiPanel.add(this.createLabelPLN());
//            this.BramkiPanel.add(this.createFieldPLN());
//            this.BramkiPanel.add(this.createLabelEURO());
//            this.BramkiPanel.add(this.createFieldEURO());

            this.BramkiPanel.add(this.createLabelPLN1());
            this.BramkiPanel.add(this.createA1());
            this.BramkiPanel.add(this.createLabelEURO1());
            this.BramkiPanel.add(this.createA2());
            this.BramkiPanel.add(this.createLabelPLN2());
            this.BramkiPanel.add(this.createA3());
            this.BramkiPanel.add(this.createLabelEURO2());
            this.BramkiPanel.add(this.createA4());
            this.BramkiPanel.add(this.obliczButtonPLN());
            this.BramkiPanel.add(this.createLabelPLN4());
            bc1.setBounds(75,50,100,30);    
            bc2.setBounds(75,100,100,30);    
            bc3.setBounds(75,150,100,30);    
            bc4.setBounds(75,200,100,30);   
            ButtonGroup bc=new ButtonGroup(); 
            if(sb1 == 0){
            r1.setSelected(true);}
            else{
                r2.setSelected(true);
            }
            bc.add(bc1);bc.add(bc2); bc.add(bc3);bc.add(bc4); 
            BramkiPanel.add(bc1);BramkiPanel.add(bc2); BramkiPanel.add(bc3);BramkiPanel.add(bc4);
            
        }
        return this.BramkiPanel;
    }
    
//    private double konwertuj(){
//        
//    }
        
    private void pobierzDane(){
           stringToParsedPLN = fieldPLN.getText(); 
           stringToParsedEURO = fieldEURO.getText(); 
        }
    
//    private JLabel createLabelPLN(){
//        if(this.LA1 == null){
//            LA1 = new JLabel("PLN");
//        }return LA1;
//    }
        private JLabel createLabelPLN1(){
        if(this.LA1 == null){
            LA1 = new JLabel("AND bramki 1 i 2");
        }return LA1;
    }
                private JLabel createLabelPLN4(){
        if(this.LA4 == null){
            LA4 = new JLabel("");
        }return LA4;
    }
        private JLabel createLabelPLN2(){
        if(this.LA2 == null){
            LA2 = new JLabel("NOT Bramki 1");
        }return LA2;
    }
    private JTextField createFieldPLN(){
        if(this.fieldPLN == null){
            fieldPLN = new JTextField();
        } return fieldPLN;
    }
    
        private JLabel createLabelEURO(){
        if(this.labelEURO == null){
            labelEURO = new JLabel("EURO");
        }return labelEURO;
    }
    private JLabel createLabelEURO1(){
        if(this.labelEURO1 == null){
            labelEURO1 = new JLabel("OR bramki 1 i 2");
        }return labelEURO1;
    }
    
    private JLabel createLabelEURO2(){
        if(this.labelEURO2 == null){
            labelEURO2 = new JLabel("NOT nramki 2");
        }return labelEURO2;
    }
    private JTextField createFieldEURO(){
        if(this.fieldEURO == null){
            fieldEURO = new JTextField();
        } return fieldEURO;
    }
    private JButton obliczButtonPLN(){
        if(this.obliczButtonPLN == null){
            obliczButtonPLN = new JButton("Strzelaj do bramki");
//            obliczButtonPLN.setBackground(colorButton);
//            obliczButtonPLN.setSize(200,80);
        }
        return obliczButtonPLN;
    }
    private JLabel createA1(){
        if(this.createA1 == null){
            stringPLN = (Integer.toString(A1));
            createA1 = new JLabel(stringPLN);
        }return createA1;
    }
        private JLabel createA2(){
        if(this.createA2 == null){
            stringEURO = (Integer.toString(EURO));
            createA2 = new JLabel(stringEURO);
        }return createA2;
    }
            private JLabel createA3(){
        if(this.createA3 == null){
            stringPLN1 = (Integer.toString(PLN1));
            createA3 = new JLabel(stringPLN1);
        }return createA3;
    }
        private JLabel createA4(){
        if(this.createA4 == null){
            stringEURO1 = (Integer.toString(EURO1));
            createA4 = new JLabel(stringEURO1);
        }return createA4;
    }
        /////////////////////////////////////////////////////////
     public void saveData(){
		
		XMLEncoder encoder = null;		
		try {
			encoder = new XMLEncoder(
			        new BufferedOutputStream(
			                new FileOutputStream( "Bramki.xml" ) ) );
		}
		catch (FileNotFoundException e) {			
			System.err.println(e.getMessage());		
			return;
		}	
                System.out.println("sb1 " + sb1);
		encoder.writeObject(this.sb1);		
		encoder.writeObject(this.sb2);        
//		encoder.writeObject(this.glebokoscWartosc);		
//		encoder.writeObject(this.objetoscWartosc); 
		
        encoder.close();
	}
	
	public void readData(){		
		XMLDecoder decoder = null;		
		try {			
			decoder = new XMLDecoder(
			        new BufferedInputStream(
			                new FileInputStream( "Bramki.xml" ) ) );
		} 
		catch (FileNotFoundException e) {			
			System.err.println(e.getMessage());			
			return;
		}
		try{		        
	        this.sb1 = Integer.parseInt(decoder.readObject().toString());	        
	        this.sb2 = Integer.parseInt(decoder.readObject().toString());	        
//	        this.glebokoscWartosc = Integer.parseInt(decoder.readObject().toString());	        
//	        this.objetoscWartosc = Integer.parseInt(decoder.readObject().toString());  
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
