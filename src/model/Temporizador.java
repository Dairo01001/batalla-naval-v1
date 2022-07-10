package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Temporizador extends Thread {
    
    private int segundos;
    private int minutos;
    private boolean running;
    private final JLabel display;

    public Temporizador(JLabel display) {
        this.display = display;
        this.running = false;
    }
    
    private void detenerSegundo() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pausa() {
        running = false;
    }
    
    public void reanudar() {
        running = true;
    }
    

    public void reiniciar() {
        segundos = 0;
        minutos = 0;
    }
    
    @Override
    public void run() {
        while(running) {    
            detenerSegundo();
            segundos++;
        
            if(segundos == 60) {
                segundos = 0;
                minutos++;
            }
            
            display.setText("Tiempo: " + minutos + ":" + segundos);
        }
    }
    
    @Override
    public String toString() {
        return minutos + ":" + segundos + " m:s";
    }
}
