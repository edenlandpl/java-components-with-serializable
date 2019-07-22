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

public class KalkulatorInterface extends JPanel {
    
    private JPanel KalkulatorPanel;
    private KalkulatorKomponent przeliczonePLN;
    private KalkulatorKomponent przeliczoneEURO;
    private KalkulatorKomponent przeliczonePLN1;
    private KalkulatorKomponent przeliczoneEURO1;
    double PLN = 0.0, EURO = 0.0,PLN1 = 0.0, EURO1 = 0.0, pobranePLN, pobraneEURO;
    double parsedPLN, parsedEURO;
    String stringToParsedPLN, stringToParsedEURO, stringPLN, stringEURO, stringPLN1, stringEURO1;
    
    private JLabel labelPLN,labelPLN1, labelPLN2, createPLN, createEURO, createPLN1, createEURO1;
    private JTextField fieldPLN;
    private JLabel labelEURO;
    private JLabel labelEURO1, labelEURO2;
    private JTextField fieldEURO;
    private JButton obliczButtonPLN;
    
    public KalkulatorInterface() {
        super();
        this.initialize();
    }
    
    private void initialize(){
                przeliczonePLN = new KalkulatorKomponent();
                przeliczoneEURO = new KalkulatorKomponent();
        	this.setPreferredSize(new Dimension(350,270));
		this.setSize(this.getPreferredSize());
		this.setLayout(new GridLayout(1,1));
		this.setBackground(Color.LIGHT_GRAY);
                this.add(this.createKalkulatorPanel());
                obliczButtonPLN.addActionListener((ActionEvent e) -> {
                    pobierzDane();  
                        try{
                                pobranePLN = Integer.parseInt(stringToParsedPLN);
                                pobraneEURO = Integer.parseInt(stringToParsedEURO);
                                przeliczonePLN.setPLN(pobranePLN);
                                przeliczonePLN.setEURO(pobraneEURO);
//                                przeliczonePLN1.setPLN(pobranePLN);
//                                przeliczoneEURO1.setEURO(pobraneEURO);
//                                pobraneEURO = Integer.parseInt(stringToParsedEURO);
//                                pobranePLN = Integer.parseInt(stringToParsedPLN);
//                                przeliczoneEURO.setEURO(pobranePLN);
//                                przeliczonePLN.setPLN(pobraneEURO);
                                PLN = przeliczonePLN.getDodawanie();
                                EURO = przeliczonePLN.getOdejmowanie();
                                PLN1 = przeliczonePLN.getMnozenie();
                                EURO1 = przeliczonePLN.getDzielenie();
                                createPLN.setText(Double.toString(PLN));
                                createEURO.setText(Double.toString(EURO));
                                createPLN1.setText(Double.toString(PLN1));
                                if(pobraneEURO == 0) {createEURO1.setText("Cholero nie dziel przez 0");}
                                else{createEURO1.setText(Double.toString(EURO1));}
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
    
    private JPanel createKalkulatorPanel(){
        if(this.KalkulatorPanel == null){
            this.KalkulatorPanel = new JPanel();			
//                    this.HelloWorldPanel.setBorder(new TitledBorder("Podaj objętość"));		
                    this.KalkulatorPanel.setLayout(new GridLayout(0,2));			
//                    this.HelloWorldPanel.setOpaque(false);
//            this.KalkulatorWalutowyPanel.add(JLabel PLNLabel = new JLabel("PLN"));
            this.KalkulatorPanel.add(this.createLabelPLN());
            this.KalkulatorPanel.add(this.createFieldPLN());
            this.KalkulatorPanel.add(this.createLabelEURO());
            this.KalkulatorPanel.add(this.createFieldEURO());

            this.KalkulatorPanel.add(this.createLabelPLN1());
            this.KalkulatorPanel.add(this.createPLN());
            this.KalkulatorPanel.add(this.createLabelEURO1());
            this.KalkulatorPanel.add(this.createEURO());
            this.KalkulatorPanel.add(this.createLabelPLN2());
            this.KalkulatorPanel.add(this.createPLN1());
            this.KalkulatorPanel.add(this.createLabelEURO2());
            this.KalkulatorPanel.add(this.createEURO1());
            this.KalkulatorPanel.add(this.obliczButtonPLN());
        }
        return this.KalkulatorPanel;
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
            labelPLN = new JLabel("Pierwsza liczba");
        }return labelPLN;
    }
        private JLabel createLabelPLN1(){
        if(this.labelPLN1 == null){
            labelPLN1 = new JLabel("Dodawanie");
        }return labelPLN1;
    }
        private JLabel createLabelPLN2(){
        if(this.labelPLN2 == null){
            labelPLN2 = new JLabel("Mnożenie");
        }return labelPLN2;
    }
    private JTextField createFieldPLN(){
        if(this.fieldPLN == null){
            fieldPLN = new JTextField();
        } return fieldPLN;
    }
    
        private JLabel createLabelEURO(){
        if(this.labelEURO == null){
            labelEURO = new JLabel("Druga liczba");
        }return labelEURO;
    }
    private JLabel createLabelEURO1(){
        if(this.labelEURO1 == null){
            labelEURO1 = new JLabel("Odejmowanie");
        }return labelEURO1;
    }
    
    private JLabel createLabelEURO2(){
        if(this.labelEURO2 == null){
            labelEURO2 = new JLabel("Dzielenie");
        }return labelEURO2;
    }
    private JTextField createFieldEURO(){
        if(this.fieldEURO == null){
            fieldEURO = new JTextField();
        } return fieldEURO;
    }
    private JButton obliczButtonPLN(){
        if(this.obliczButtonPLN == null){
            obliczButtonPLN = new JButton("Działaj");
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
            private JLabel createPLN1(){
        if(this.createPLN1 == null){
            stringPLN1 = (Double.toString(PLN1));
            createPLN1 = new JLabel(stringPLN1);
        }return createPLN1;
    }
        private JLabel createEURO1(){
        if(this.createEURO1 == null){
            stringEURO1 = (Double.toString(EURO1));
            createEURO1 = new JLabel(stringEURO1);
        }return createEURO1;
    }
}
