package Parking;

import java.util.ArrayList;

/**
 *
 * @author Guzman
 */
public class Parking {
    int numeroPlazas;
    int numeroPlazasOcupadas;
    boolean completo;

    
    public Parking(){
        numeroPlazas=115;
        completo=false;
        numeroPlazasOcupadas=0;

    }
    
    synchronized public void entraCoche() throws InterruptedException{
        while(completo){
            wait();
        }
            numeroPlazasOcupadas++;

            if(numeroPlazas==numeroPlazasOcupadas){
                completo = true;
                System.out.println("Parking completo, no se aceptan mas coches.");
            }
            
            
        
        
        
     
    }
    synchronized public void saleCoche(){
        if(completo){
            completo = false;
            numeroPlazasOcupadas--;
            System.out.println("-->Plazas disponibles, se aceptan mas coches.\n");
            notifyAll();

        }else{
            if(numeroPlazasOcupadas !=0){
                numeroPlazasOcupadas--;
            }else{
                System.out.println("La jodiste.");
            }           
        }

    }

}