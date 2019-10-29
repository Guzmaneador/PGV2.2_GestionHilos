package Monitor;

import java.util.ArrayList;

/**
 *
 * @author Guzman
 */
public class Gestion {
       ArrayList<Coche> listaCoches;
       static Parking parking = new Parking(); 
     /* Genera 1000 objetos de tipo coche a la vez que los introduce en un array
        llama al metodo abreEl Parking*/    
    public Gestion() {
        listaCoches= new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listaCoches.add(new Coche(i,parking));   
        }
        abreElParking();
    }   
    //Inicia todos los hilos(Coches) que se han introducido en el array previamente
    public void  abreElParking(){
        
           for (Coche coche : listaCoches) {
                coche.start();       
           }
    }  
}
