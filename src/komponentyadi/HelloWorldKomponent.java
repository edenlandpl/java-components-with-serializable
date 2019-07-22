/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponentyadi;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JSlider;

/**
 *
 * @author Adrian
 */
public class HelloWorldKomponent implements Serializable{
   
    
    private String textHelloWorldKomponent = "Hello World !";
    String[] colorText= new String[]{"Color.RED","Color.BLACK","Color.RED","Color.WHITE"};
    int i=0;
    String color;
    
    public String getHelloWorld(){
        System.out.println("NI Hurra " + textHelloWorldKomponent);
        return this.textHelloWorldKomponent;
    }
    
    public void setHelloWorld(){
          color = colorText[i];
          i++;
          if(i>3){
              i=0;
          }
    }
    public String getColor(){     
        System.out.println("Color " + color);
        return this.colorText[i];
    }

}
