package view;

import java.awt.Color;
import javax.swing.JPanel;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class VistaTablero extends javax.swing.JPanel {
    
    private JPanel[][] tablero;
    
    public VistaTablero() {
        initComponents();
        initTablero();
    }
    
    private void initTablero() {
        tablero = new JPanel[Tablero.TAMANIO][Tablero.TAMANIO];
        
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                tablero[i][j] = new JPanel();
                tablero[i][j].setSize(8, 8);
                tablero[i][j].setBackground(Color.BLUE);
                add(tablero[i][j]);
            }
        }
    }
    
    public void limpiarTablero() {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                tablero[i][j].setBackground(Color.BLUE);
            }
        }
    }
    
    public void setModelMaquina(TipoCeldaTablero[][] tableroMaquina) {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                switch (tableroMaquina[i][j]) {
                    case AGUA:
                        tablero[i][j].setBackground(Color.BLUE);
                        break;
                    case DISPARO:
                        tablero[i][j].setBackground(Color.RED);
                        break;
                    default:
                        tablero[i][j].setBackground(Color.DARK_GRAY);
                        break;
                }
                
            }
        }
    }
    
    public void setModelJugador(TipoCeldaTablero[][] tableroJugador) {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                switch (tableroJugador[i][j]) {
                    case AGUA:
                        tablero[i][j].setBackground(Color.BLUE);
                        break;
                    case BARCO:
                        tablero[i][j].setBackground(Color.ORANGE);
                        break;
                    case DESCONOCIDO:
                        tablero[i][j].setBackground(Color.DARK_GRAY);
                        break;
                    case DISPARO:
                        tablero[i][j].setBackground(Color.RED);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(Tablero.TAMANIO, Tablero.TAMANIO, 2, 2));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
