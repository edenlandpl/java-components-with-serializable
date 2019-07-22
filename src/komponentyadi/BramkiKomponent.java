/**
 * author Adrian, 2019.01.02, License MIT 
 */
package komponentyadi;

import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class BramkiKomponent extends JPanel implements Serializable{
    
    private int and, or;
    private int b1, b2;
    
    public BramkiKomponent(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
        JPanel panelSlider=new JPanel();  
        panelSlider.add(slider);  
        add(panelSlider);  
    }
    
   
    public void setb1(int b1){
        System.out.println("B1 - " + b1);
        this.b1 = b1;
    }
    public void setb2(int b2){
            System.out.println("B2 - " + b2);
        this.b2 = b2;
    }
 
    public int getAND(){
        and = b1 & b2;
        System.out.println("AND " + and);
        return and;
    }
    public int getOR(){
        or = b1 | b2;
        System.out.println("OR " + or);
        return or;
    }   
        public int getNOT1(){
        if(b1 == 0){
            b1 = 1;
        }
        else
        {
            b1 = 0;
        }
//        System.out.println("PLN / EURO" + PLN + EURO + dzielenie);
        return b1;
        }
        public int getNOT2(){
        if(b2 == 0){
            b2 = 1;
        }
        else
        {
            b2 = 0;
        }
//        System.out.println("PLN / EURO" + PLN + EURO + dzielenie);
        return b2;
        }
}
