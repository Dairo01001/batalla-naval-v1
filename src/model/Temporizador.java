package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Temporizador extends Thread {
    
    private int segundos;
    private int minutos;
    private final JLabel display;

    public Temporizador(JLabel display) {
        this.display = display;
    }
    
    
    
    private void detenerSegundo() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while(true) {    
            detenerSegundo();
            segundos++;
        
            if(segundos == 60) {
                segundos = 0;
                minutos++;
            }
            
            display.setText("T (m:s): " + minutos + ":" + segundos);
        }
    }
}
