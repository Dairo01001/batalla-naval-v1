package model.tablero;

import java.awt.Point;
import java.util.ArrayList;
import model.barco.Barco;

public class Tablero {

    public static final int TAMANIO = 8;

    private final TipoCeldaTablero[][] tablero;
    private final ArrayList<Barco> barcos;

    public Tablero() {
        barcos = new ArrayList<>();
        tablero = new TipoCeldaTablero[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = TipoCeldaTablero.DESCONOCIDO;
            }
        }
    }
    
    public void limpiarTablero() {
        barcos.clear();
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = TipoCeldaTablero.DESCONOCIDO;
            }
        }
    }

    public boolean esValido(Barco barco) {
        if(barco == null) {
            return false;
        }
        
        if (barco.getInicio().y < 0 || barco.getInicio().y >= TAMANIO) {
            return false;
        }

        if (barco.getInicio().x < 0 || barco.getInicio().x >= TAMANIO) {
            return false;
        }

        if (barco.getFinal().x < 0 || barco.getFinal().x >= TAMANIO) {
            return false;
        }

        if(barco.getFinal().y < 0 || barco.getFinal().y >= TAMANIO){
            return false;
        }
        
        for (Point parte: barco.getPartes()) {
            if(tablero[parte.x][parte.y].equals(TipoCeldaTablero.BARCO)){
                return false;
            }
        }

        return true;
    }

    public boolean agregarBarco(Barco barco) {
        barcos.add(barco);
        for (Point parte : barco.getPartes()) {
            tablero[parte.x][parte.y] = TipoCeldaTablero.BARCO;
        }
        return true;
    }

    public boolean estaTerminado() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (tablero[i][j] == TipoCeldaTablero.BARCO) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean disparoValido(int x, int y) {
        if (x < 0 || x >= TAMANIO) {
            return false;
        }

        return !(y < 0 || y >= TAMANIO);
    }

    public boolean hacerDisparo(int x, int y) {
        if (disparoValido(x, y)) {
            tablero[x][y] = TipoCeldaTablero.AGUA;
            for (Barco barco : barcos) {
                if (barco.evaluarDisparo(x, y)) {
                    tablero[x][y] = TipoCeldaTablero.DISPARO;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaLleno() {
        return barcos.size() == Barco.CANTIDAD_DE_BARCOS * Barco.CANTIDAD_POR_BARCO;
    }

    public TipoCeldaTablero[][] getTablero() {
        return tablero;
    }
}
