package model.barco;

import java.awt.Point;

public class Barco {

    public static final int CANTIDAD_POR_BARCO = 1;
    public static final int CANTIDAD_DE_BARCOS = 4;

    public static final int ORIENTACION_HORIZONTAL = 0;
    public static final int ORIENTACION_VERTICAL = 1;

    public static final TipoBarco[] TIPOS_BARCO = new TipoBarco[]{TipoBarco.PORTA_AVIONES, TipoBarco.ACORAZADO, TipoBarco.SUBMARINO, TipoBarco.DESTRUCTOR};

    private final TipoBarco TIPO;
    private final int TAMANIO;
    private int vida;
    private Point[] partes;
    private final int orientacion;

    private Barco(TipoBarco tipo, int tamanio, int orientacion, Point inicio) {
        TIPO = tipo;
        TAMANIO = tamanio;
        vida = tamanio;
        this.orientacion = orientacion;
        contruirBarco(orientacion, inicio);
    }

    public int getOrientacion() {
        return orientacion;
    }
    
    public boolean isHead(int i, int j) {
        return getInicio().x == i && getInicio().y == j;
    }
    
    public boolean isFinal(int i, int j) {
        return getFinal().x == i && getFinal().y == j;
    }

    private void contruirBarco(int orientacion, Point inicio) {
        partes = new Point[TAMANIO];
        partes[0] = inicio;

        if (Barco.ORIENTACION_HORIZONTAL == orientacion) {
            for (int i = 1; i < TAMANIO; i++) {
                partes[i] = new Point(inicio.x + i, inicio.y);
            }
        } else {
            for (int i = 1; i < TAMANIO; i++) {
                partes[i] = new Point(inicio.x, i + inicio.y);
            }
        }
    }

    public TipoBarco getTIPO() {
        return TIPO;
    }

    public int getTAMANIO() {
        return TAMANIO;
    }

    public Point[] getPartes() {
        return partes;
    }

    public Point getInicio() {
        return partes[0];
    }

    public Point getFinal() {
        return partes[TAMANIO - 1];
    }

    public boolean evaluarDisparo(int x, int y) {
        for (Point parte : partes) {
            if (parte.x == x && parte.y == y) {
                vida--;
                return true;
            }
        }
        return false;
    }

    public boolean estaUndido() {
        return vida == 0;
    }

    public static Barco crearBarco(TipoBarco tipo, int orientacion, Point inicio) {
        switch (tipo) {
            case PORTA_AVIONES:
                return new Barco(tipo, 5, orientacion, inicio);
            case ACORAZADO:
                return new Barco(tipo, 4, orientacion, inicio);
            case SUBMARINO:
                return new Barco(tipo, 3, orientacion, inicio);
            default:
                return new Barco(tipo, 2, orientacion, inicio);
        }
    }
}
