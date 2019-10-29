package Monitor;

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
    /*Al inicializarla un hilo sumara una a numeroPlazas Ocupada, si llega al numero 
        de plazas maxima (numeroPlazas) pondra el buleano completo en true.
        Si un hilo desea entrar y completo es true tendra que cumplir el wait 
        siatuado en el while. Al ser synchronized solo podre haber un hilo ejecutando
        este codigo a la vez.*/
    synchronized public void entraCoche() throws InterruptedException{
        while(completo){
            wait();
        }
            numeroPlazasOcupadas++;

            if(numeroPlazas==numeroPlazasOcupadas){
                completo = true;
                System.out.println("-->Parking completo, no se aceptan mas coches.");
            }

    }
    /*Al inicializarla un hilo restara uno a numero de plazas ocupada, en caso de 
        completo ser true, restara una plaza y liberara todos los hilos esperando por
        el wait.. Al ser synchronized solo podre haber un hilo ejecutando
        este codigo a la vez.*/
    synchronized public void saleCoche(){
        if(completo){
            completo = false;
            numeroPlazasOcupadas--;
            notifyAll();

        }else{
            if(numeroPlazasOcupadas !=0){
                numeroPlazasOcupadas--;
            }          
        }

    }

}