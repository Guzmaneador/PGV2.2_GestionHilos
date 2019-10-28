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
    
    private void tiempoEstancia(){
        Random aleatorio= new Random();
        tiempo =aleatorio.nextInt(1000)+100;  
    }
    
    public void estanciaAparcado() throws InterruptedException{
        sleep(tiempo);
    }

    public int getNumeroCoche() {
        return numeroCoche;
    }
    

}