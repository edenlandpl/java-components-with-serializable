/* file name    : {name}
 * authors      : Adrian 
 * created      : {date}
 * copyright    : MIT
 * version      : 0.1
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponentyadi;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class KomponentyAdi extends JFrame{

        private Okno okno;
        private BramkiInterface Okno1;
    
    public KomponentyAdi(){
        super("Programowanie komponentowe");
        this.setPreferredSize(new Dimension(500,700));
        this.setSize(this.getPreferredSize() );
        this.okno = new Okno();
//        this.okno = new Okno1();
//        JFrame frame = new JFrame("FrameDemo");
        this.add(this.okno);
        okno.readDataBramki();
        this.setVisible(true);
        this.addWindowStateListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                okno.saveDataOpcje();
                okno.saveDataObjetosc();
                okno.saveDataBramki();
                //okno.readDataBramki();
                System.exit(0);
            }
        });
//        this.okno1 = new BramkiInterface();
////        JFrame frame = new JFrame("FrameDemo");
//        this.add(this.okno1);
////        this.add(this.BramkiInterface());
//        this.setVisible(true);
    }    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                KomponentyAdi komponentyAdi = new KomponentyAdi();
            }
        });
//        JFrame frame = new JFrame("FrameDemo");
//        frame.setPreferredSize(new Dimension(800,600));
//        frame.setSize(frame.getPreferredSize());
        //frame.okno = new Okno();
        //frame.add(this.okno);
//        frame.setVisible(true);
    }
}
