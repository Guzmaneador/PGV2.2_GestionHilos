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
    //Coche cochesAparcados[] ;
    //ArrayList<Integer> plazasOcupadas;

    
    public Parking(){
        numeroPlazas=115;
        completo=false;
        numeroPlazasOcupadas=0;
       // cochesAparcados = new Coche[115];

    }
    
    synchronized public void entraCoche(Coche coche) throws InterruptedException{
        if(completo){
            wait();
        }else{
            numeroPlazasOcupadas++;
            System.out.println("Entra el coche numero: "+coche.getNumeroCoche());

            if(numeroPlazas==numeroPlazasOcupadas){
                completo = true;
                System.out.println("Parking completo, no se aceptan mas coches.");
            }
            
            
        }
        
        
     
    }
    synchronized public void saleCoche(Coche coche){
        if(completo){
            completo = false;
            numeroPlazasOcupadas--;
        }else{
            if(numeroPlazasOcupadas !=0){
                numeroPlazasOcupadas--;
                System.out.println("Sale el coche numero: "+coche.getNumeroCoche());

            }else{
                System.out.println("La jodiste.");
            }           
        }

    }

}