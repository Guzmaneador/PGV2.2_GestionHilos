package Monitor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guzman
 */
public class Coche extends Thread{
    Parking parking ;//= new Parking();
    private final int numeroCoche;
    private int tiempo;//milisegundos 1000=1s

    public Coche(int numeroCoche,Parking parking) {
        this.parking=parking;
        this.numeroCoche=numeroCoche;
        tiempoEstancia();
    } 
   /*
    Hace que el hilo ejecute la zonas syncorinizadas de la instancia de parking
    que tienes todos los hilos en comun de forma que nunca podran salir ni entrar
    dos hilos a la vez del parking . Tambien imprime un mensaje informando de que
    coche ha entrado al parking y de que coche ha salido del parking.
    */ 
    @Override
    public void run(){
        try {
            parking.entraCoche();   
            System.out.println("Entra el coche numero: "+numeroCoche);
            sleep(tiempo); 
            parking.saleCoche();
            System.out.println("Sale el coche numero: "+numeroCoche);

        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Crea un tiempo de estancia aleatroio que ronda entre 100 milisegundos y 1s.
    private void tiempoEstancia(){
        Random aleatorio= new Random();
        tiempo =aleatorio.nextInt(1000)+100;  
    }
    //Duereme el hilo durante el tiempo que este aparcado
    public void estanciaAparcado() throws InterruptedException{
        sleep(tiempo);
    }

}