package komponentyadi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Adrian
 */
public class HelloWorldInterface extends JPanel{
        
    private JPanel HelloWorldPanel;
    private HelloWorldKomponent textHelloWorld;
    private HelloWorldKomponent color;
    
    private JButton wyswietlButton;
    private JTextField fieldHelloWorold;
    
    //String text;
    
    	public HelloWorldInterface(){
		super();	
		this.initialize();
	}
	
        
    private void initialize(){
                textHelloWorld = new HelloWorldKomponent();
                color = new HelloWorldKomponent();
		this.setPreferredSize(new Dimension(350,270));
		this.setSize(this.getPreferredSize());
		this.setLayout(new GridLayout(8,1));
		this.setBackground(Color.LIGHT_GRAY);
                this.add(this.createHelloWorldPanel());
		//this.readData();
                    wyswietlButton.addActionListener((ActionEvent e) -> {
                        int num = 0; 
                        String text = textHelloWorld.getHelloWorld();
                        String colorH = color.getColor();
                        color.setHelloWorld();
                        System.out.println("text - " + text);
                        System.out.println("ColorH - " + colorH);
                        try{
//                              parsedNumberSzerokosc = Integer.parseInt(stringToParseSzerokosc);
//                              parsedNumber = Integer.parseInt(stringToParse);
                                JOptionPane.showMessageDialog(null, "Tekst ->: "+ text + "\nKolor - " + colorH
                                , text,
                                JOptionPane.INFORMATION_MESSAGE);  
//                                wyswietlButton.setBackground(colorH);
                        }
                        catch(NumberFormatException exp){
//                            JOptionPane
//                            .showMessageDialog(null, exp.getStackTrace(),
//                            "Wynik parsowania",
//                            JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    });
		this.setVisible(true);
                
	}
    
    private JPanel createHelloWorldPanel(){		
            if(this.HelloWorldPanel == null){			
                    this.HelloWorldPanel = new JPanel();			
//                    this.HelloWorldPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.HelloWorldPanel.setLayout(new GridLayout(1,2));			
//                    this.HelloWorldPanel.setOpaque(false);			
//                    this.HelloWorldPanel.add(this.fieldHelloWorld());	
                    this.HelloWorldPanel.add(this.wyswietlButton());
            }		
            return this.HelloWorldPanel;
	}
    
            private JButton wyswietlButton(){
                if(this.wyswietlButton == null){
                    wyswietlButton = new JButton("Wyświetl Hello World");
                }
                return wyswietlButton;
            }
            
            
        private JTextField fieldHelloWorld(){
            if(this.fieldHelloWorold == null){
                fieldHelloWorold = new JTextField();
            }
            return fieldHelloWorold;            
        }

}
