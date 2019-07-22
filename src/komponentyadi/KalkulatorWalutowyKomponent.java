/**
 * author Adrian, 2019.01.02, License MIT 
 */
package komponentyadi;

public class KalkulatorWalutowyKomponent {
    
    private double PLN, EURO, kurs = 4.3;
    
    public void setPLN(double PLN){
        this.PLN = PLN;
    }
        public void setEURO(double EURO){
        this.EURO = EURO;
    }
    public double getEURO(){
        EURO = PLN / kurs;
        return EURO;
    }        
        public double getPLN(){
        PLN = EURO * kurs;
        return PLN;
    }    
}
