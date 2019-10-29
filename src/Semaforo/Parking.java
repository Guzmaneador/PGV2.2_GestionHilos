package Semaforo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guzman
 */
public class Parking {
    int numeroPlazas;
    int numeroPlazasOcupadas;
    boolean completo;
    Semaphore semaforoEntrada;


    
    public Parking(){
        numeroPlazas=115;
        completo=false;
        numeroPlazasOcupadas=0;
        semaforoEntrada = new Semaphore(1);


    }
    
    public void entraCoche() throws InterruptedException{
        while(completo){
            semaforoEntrada.acquire();
        }
            numeroPlazasOcupadas++;

            if(numeroPlazas==numeroPlazasOcupadas){
                completo = true;
                System.out.println("Parking completo, no se aceptan mas coches.");
            }
            
            
        
        
        
     
    }
    public void saleCoche(){
        if(completo){
            completo = false;
            numeroPlazasOcupadas--;
            semaforoEntrada.release();

        }else{
            if(numeroPlazasOcupadas !=0){
                numeroPlazasOcupadas--;
            }       
        }

    }

}