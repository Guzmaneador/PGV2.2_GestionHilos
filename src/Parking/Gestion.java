package Parking;

import java.util.ArrayList;

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
            listaCoches.add(new Coche(i,parking));   
        }
        abreElParking();
    }
       
       

    public void  abreElParking(){
        
           for (Coche coche : listaCoches) {
                coche.start();       
           }
  
    }

    public static Parking getParking() {
        return parking;
    }

    public static void setParking(Parking parking) {
        Gestion.parking = parking;
    }
    
    

}