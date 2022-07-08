package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class VistaTablero extends javax.swing.JPanel {

    private JPanel[][] tablero;
    private ImageIcon dispa;
    private ImageIcon mar;
    private JLabel l;

    public VistaTablero() {
        initComponents();
        initTablero();
    }

    private void initTablero() {
        tablero = new JPanel[Tablero.TAMANIO][Tablero.TAMANIO];
        dispa = new ImageIcon("src/actions/explo.png");
        mar = new ImageIcon("src/actions/mar.png");

        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                tablero[i][j] = new JPanel();
                tablero[i][j].setSize(8, 8);
                tablero[i][j].setBackground(new Color(100, 181, 246));
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
                        l = new JLabel("");
                        l.setIcon(new ImageIcon(mar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

                        tablero[i][j].add(l);
                        tablero[i][j].setBackground(new Color(100, 181, 246));
                        break;
                    case DISPARO:
                        JLabel l = new JLabel("");
                        l.setIcon(new ImageIcon(dispa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

                        tablero[i][j].add(l);
                        tablero[i][j].setBackground(Color.WHITE);
                        break;
                    default:
                        tablero[i][j].setBackground(new Color(100, 181, 246));
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
                        l = new JLabel("");
                        l.setIcon(new ImageIcon(mar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

                        tablero[i][j].add(l);
                        tablero[i][j].setBackground(new Color(100, 181, 246));
                        break;
                    case BARCO:

                        tablero[i][j].setBackground(Color.GRAY);
                        break;
                    case DESCONOCIDO:
                        tablero[i][j].setBackground(new Color(100, 181, 246));
                        break;
                    case DISPARO:
                        l = new JLabel("");
                        l.setIcon(new ImageIcon(dispa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

                        tablero[i][j].add(l);
                        tablero[i][j].setBackground(Color.WHITE);
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

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.GridLayout(Tablero.TAMANIO, Tablero.TAMANIO, 2, 2));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
