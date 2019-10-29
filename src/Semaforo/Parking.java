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
    //Se crea el objeto de tipo Semaphore
    Semaphore semaforoEntrada;


    
    public Parking(){
        numeroPlazas=115;
        completo=false;
        numeroPlazasOcupadas=0;
        //Creamos el semaforo de tipo binario
        semaforoEntrada = new Semaphore(1);


    }
    
    public void entraCoche() throws InterruptedException{
        while(completo){
            //El semaforo podra su bit a cero si completo es true.
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
            //El semaforo podra el bit a uno cuando se libre un plaza estando completo = true.
            semaforoEntrada.release();
            


        }else{
            if(numeroPlazasOcupadas !=0){
                numeroPlazasOcupadas--;
            }       
        }

    }

}