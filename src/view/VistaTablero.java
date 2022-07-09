package view;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.barco.Barco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;
import utils.Const;

public class VistaTablero extends javax.swing.JPanel {

    private JLabel[][] tablero;

    private static final ImageIcon DESCONOCIDO = new ImageIcon(Const.PATH_IMG + "desconocido.png");
    private static final ImageIcon DISPARO = new ImageIcon(Const.PATH_IMG + "explosion.png");
    private static final ImageIcon MAR = new ImageIcon(Const.PATH_IMG + "mar.png");
    private static final ImageIcon CUERPO_BARCO_VE = new ImageIcon(Const.PATH_IMG + "cuerpoBarco.png");
    private static final ImageIcon CUERPO_BARCO_HO = new ImageIcon(Const.PATH_IMG + "cuerpoBarcoLateral.png");
    private static final ImageIcon PUNTA_BARCO_U = new ImageIcon(Const.PATH_IMG + "puntaBarcoU.png");
    private static final ImageIcon PUNTA_BARCO_D = new ImageIcon(Const.PATH_IMG + "puntaBarcoD.png");
    private static final ImageIcon PUNTA_BARCO_L = new ImageIcon(Const.PATH_IMG + "puntaBarcoL.png");
    private static final ImageIcon PUNTA_BARCO_R = new ImageIcon(Const.PATH_IMG + "puntaBarcoR.png");

    public VistaTablero() {
        initComponents();
        initTablero();
    }

    private void initTablero() {
        setBackground(Color.CYAN);
        tablero = new JLabel[Tablero.TAMANIO][Tablero.TAMANIO];

        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                tablero[i][j] = new JLabel();
                tablero[i][j].setIcon(MAR);
                add(tablero[i][j]);
            }
        }
    }

    public void limpiarTablero() {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                tablero[i][j].setIcon(DESCONOCIDO);
            }
        }
    }

    public void setModelMaquina(TipoCeldaTablero[][] tableroMaquina) {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                switch (tableroMaquina[i][j]) {
                    case AGUA:
                        tablero[i][j].setIcon(MAR);
                        break;
                    case DISPARO:
                        tablero[i][j].setIcon(DISPARO);
                        break;
                    default:
                        tablero[i][j].setIcon(DESCONOCIDO);
                        break;
                }

            }
        }
    }

    private Barco getBarcoFrom(ArrayList<Barco> barcos, int i, int j) {
        for (Barco barco : barcos) {
            for (Point punto : barco.getPartes()) {
                if (punto.x == i && punto.y == j) {
                    return barco;
                }
            }
        }
        return null;
    }

    private ImageIcon getBarcoImage(ArrayList<Barco> barcos, int i, int j) {
        Barco barco = getBarcoFrom(barcos, i, j);

        if (barco.getOrientacion() != Barco.ORIENTACION_HORIZONTAL) {
            if (barco.isHead(i, j)) {
                return PUNTA_BARCO_R;
            }

            if (barco.isFinal(i, j)) {
                return PUNTA_BARCO_L;
            }

            return CUERPO_BARCO_HO;

        } else {
            
            if (barco.isHead(i, j)) {
                return PUNTA_BARCO_U;
            }

            if (barco.isFinal(i, j)) {
                return PUNTA_BARCO_D;
            }

            return CUERPO_BARCO_VE;
        }
    }

    public void setModelJugadorBarcos(TipoCeldaTablero[][] tableroJugador, ArrayList<Barco> barcos) {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                switch (tableroJugador[i][j]) {
                    case AGUA:
                        tablero[i][j].setIcon(MAR);
                        break;
                    case BARCO:
                        tablero[i][j].setIcon(getBarcoImage(barcos, i, j));
                        break;
                    case DESCONOCIDO:
                        tablero[i][j].setIcon(DESCONOCIDO);
                        break;
                    case DISPARO:
                        tablero[i][j].setIcon(DISPARO);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }

    public void setModelJugador(TipoCeldaTablero[][] tableroJugador) {
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                switch (tableroJugador[i][j]) {
                    case AGUA:
                        tablero[i][j].setIcon(MAR);
                        break;
                    case BARCO:
                        tablero[i][j].setIcon(CUERPO_BARCO_VE);
                        break;
                    case DESCONOCIDO:
                        tablero[i][j].setIcon(DESCONOCIDO);
                        break;
                    case DISPARO:
                        tablero[i][j].setIcon(DISPARO);
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
        setLayout(new java.awt.GridLayout(Tablero.TAMANIO, Tablero.TAMANIO));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
