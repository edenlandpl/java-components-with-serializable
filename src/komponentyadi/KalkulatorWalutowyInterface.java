/**
 * author Adrian, 2019.01.02, License MIT 
 */
package komponentyadi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KalkulatorWalutowyInterface extends JPanel {
    
    private JPanel KalkulatorWalutowPanel;
    private KalkulatorWalutowyKomponent przeliczonePLN;
    private KalkulatorWalutowyKomponent przeliczoneEURO;
    double PLN = 0.0, EURO = 0.0, pobranePLN, pobraneEURO;
    double parsedPLN, parsedEURO;
    String stringToParsedPLN, stringToParsedEURO, stringPLN, stringEURO;
    
    private JLabel labelPLN,labelPLN1, createPLN, createEURO;
    private JTextField fieldPLN;
    private JLabel labelEURO;
    private JLabel labelEURO1;
    private JTextField fieldEURO;
    private JButton obliczButtonPLN;
    
    public KalkulatorWalutowyInterface() {
        super();
        this.initialize();
    }
    
    private void initialize(){
                przeliczonePLN = new KalkulatorWalutowyKomponent();
                przeliczoneEURO = new KalkulatorWalutowyKomponent();
        	this.setPreferredSize(new Dimension(350,270));
		this.setSize(this.getPreferredSize());
		this.setLayout(new GridLayout(1,1));
		this.setBackground(Color.LIGHT_GRAY);
                this.add(this.createKalkulatorWalutowyPanel());
                obliczButtonPLN.addActionListener((ActionEvent e) -> {
                    pobierzDane();  
                        try{
                                pobranePLN = Integer.parseInt(stringToParsedPLN);
                                pobraneEURO = Integer.parseInt(stringToParsedEURO);
                                przeliczonePLN.setEURO(pobraneEURO);
                                przeliczoneEURO.setPLN(pobranePLN);
                                pobraneEURO = Integer.parseInt(stringToParsedEURO);
                                pobranePLN = Integer.parseInt(stringToParsedPLN);
                                przeliczoneEURO.setEURO(pobranePLN);
                                przeliczonePLN.setPLN(pobraneEURO);
                                PLN = przeliczonePLN.getPLN();
                                EURO = przeliczoneEURO.getEURO();
                                createPLN.setText(Double.toString(EURO));
                                createEURO.setText(Double.toString(PLN));
                        }
                        catch(NumberFormatException exp){
//                            
                        }
                        
                                System.out.println("PLN  " + PLN);
                                System.out.println("EURO " + EURO);
//                        konwertuj();
                    });
		this.setVisible(true);
    }
    
    private JPanel createKalkulatorWalutowyPanel(){
        if(this.KalkulatorWalutowPanel == null){
            this.KalkulatorWalutowPanel = new JPanel();			
//                    this.HelloWorldPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.KalkulatorWalutowPanel.setLayout(new GridLayout(0,2));			
//                    this.HelloWorldPanel.setOpaque(false);
//            this.KalkulatorWalutowyPanel.add(JLabel PLNLabel = new JLabel("PLN"));
            this.KalkulatorWalutowPanel.add(this.createLabelPLN());
            this.KalkulatorWalutowPanel.add(this.createFieldPLN());
            this.KalkulatorWalutowPanel.add(this.createLabelEURO());
            this.KalkulatorWalutowPanel.add(this.createFieldEURO());

            this.KalkulatorWalutowPanel.add(this.createLabelPLN1());
            this.KalkulatorWalutowPanel.add(this.createPLN());
            this.KalkulatorWalutowPanel.add(this.createLabelEURO1());
            this.KalkulatorWalutowPanel.add(this.createEURO());
                        this.KalkulatorWalutowPanel.add(this.obliczButtonPLN());
        }
        return this.KalkulatorWalutowPanel;
    }
    
//    private double konwertuj(){
//        
//    }
        
    private void pobierzDane(){
           stringToParsedPLN = fieldPLN.getText(); 
           stringToParsedEURO = fieldEURO.getText(); 
        }
    
    private JLabel createLabelPLN(){
        if(this.labelPLN == null){
            labelPLN = new JLabel("PLN");
        }return labelPLN;
    }
        private JLabel createLabelPLN1(){
        if(this.labelPLN1 == null){
            labelPLN1 = new JLabel("Ilość PLN po przeliczeniu EURO");
        }return labelPLN1;
    }
    private JTextField createFieldPLN(){
        if(this.fieldPLN == null){
            fieldPLN = new JTextField();
        } return fieldPLN;
    }
    
        private JLabel createLabelEURO(){
        if(this.labelEURO1 == null){
            labelEURO1 = new JLabel("EURO");
        }return labelEURO1;
    }
    private JLabel createLabelEURO1(){
        if(this.labelEURO == null){
            labelEURO = new JLabel("Ilość EURO po przeliczeniu PLN");
        }return labelEURO;
    }
    private JTextField createFieldEURO(){
        if(this.fieldEURO == null){
            fieldEURO = new JTextField();
        } return fieldEURO;
    }
    private JButton obliczButtonPLN(){
        if(this.obliczButtonPLN == null){
            obliczButtonPLN = new JButton("Konwertuj");
        }
        return obliczButtonPLN;
    }
    private JLabel createPLN(){
        if(this.createPLN == null){
            stringPLN = (Double.toString(PLN));
            createPLN = new JLabel(stringPLN);
        }return createPLN;
    }
        private JLabel createEURO(){
        if(this.createEURO == null){
            stringEURO = (Double.toString(EURO));
            createEURO = new JLabel(stringEURO);
        }return createEURO;
    }
}
