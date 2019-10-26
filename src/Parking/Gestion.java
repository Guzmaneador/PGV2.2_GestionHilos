package Parking;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guzman
 */
public class Gestion {
       ArrayList<Coche> listaCoches;
       static Parking parking = new Parking();

    public Gestion() {
        listaCoches= new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listaCoches.add(new Coche(i));   
        }
        abreElParking();
    }
       
       

    public void  abreElParking(){
        
           for (Coche coche : listaCoches) {
                coche.start();
//                parking.entraCoche(coche);
//                coche.estanciaAparcado();
//                parking.saleCoche(coche);        
           }
           for (Coche coche : listaCoches) {
               try {
                   parking.entraCoche(coche);
                   coche.estanciaAparcado();        
                   parking.saleCoche(coche);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
  
    }
//    public static void entraCoche() throws InterruptedException{
//        parking.entraCoche();
//    }
//    public static void saleCoche(){
//        parking.saleCoche();
//    }
    
    

}