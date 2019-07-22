/**
 * author Adrian, 2019.01.02, License MIT 
 */
package komponentyadi;

public class KalkulatorKomponent {
    
    private double PLN, EURO, dodawanie = 0.0d, odejmowanie = 0.0d , mnozenie = 0.0d , dzielenie = 0.0d;
    
    public void setPLN(double PLN){
        System.out.println("PLN - " + PLN);
        this.PLN = PLN;
    }
    public void setEURO(double EURO){
            System.out.println("EURO - " + EURO);
        this.EURO = EURO;
    }
    public double getDodawanie(){
        dodawanie = PLN + EURO;
        System.out.println("PLN + EURO" + PLN + EURO + dodawanie);
        return dodawanie;
    }        
    public double getOdejmowanie(){
        odejmowanie = PLN - EURO;
        System.out.println("PLN - EURO" + PLN + EURO + odejmowanie);
        return odejmowanie;
    }    
    public double getMnozenie(){
        mnozenie = EURO * PLN;
        System.out.println("PLN * EURO" + PLN + EURO + mnozenie);
        return mnozenie;
    }   
    public double getDzielenie(){
        dzielenie =  PLN / EURO;
        System.out.println("PLN / EURO" + PLN + EURO + dzielenie);
        return dzielenie;
    }   
}
