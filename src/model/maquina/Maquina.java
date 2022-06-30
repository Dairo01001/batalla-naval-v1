package model.maquina;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import model.barco.Barco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class Maquina {
    
    private Tablero tablero;
    private final Random random;
    private int index;
    private final ArrayList<Point> disparos;
    private final int contarBarcosCreados[];
    
    public Maquina() {
        random = new Random();
        tablero = new Tablero();
        
        disparos = new ArrayList<>();
        for (int i = 0; i < Tablero.TAMANIO; i++) {
            for (int j = 0; j < Tablero.TAMANIO; j++) {
                disparos.add(new Point(i, j));
            }
        }
    
        
        contarBarcosCreados = new int[Barco.CANTIDAD_DE_BARCOS];
        
        index = 0;
    }
    
    public int[] getBarcosCreados() {
        return contarBarcosCreados;
    }
    
    public Point atacar() {
        return disparos.get(index++);
    }
    
    public void llenarTablero() {
        int i = 0;
        
        while (!tablero.estaLleno()) {
            if (contarBarcosCreados[i] > 0) {
                Barco barco = Barco.crearBarco(Barco.TIPOS_BARCO[i], random.nextInt(10) % 2, new Point(random.nextInt(Tablero.TAMANIO), random.nextInt(Tablero.TAMANIO)));
                if (tablero.esValido(barco)) {
                    tablero.agregarBarco(barco);
                    contarBarcosCreados[i]--;
                }
            } else {
                i++;
            }
        }
    }
    
    public TipoCeldaTablero[][] getModelTablero() {
        return tablero.getTablero();
    }
    
    public void clearCountBarcos() {
        for (int i = 0; i < Barco.CANTIDAD_DE_BARCOS; i++) {
            contarBarcosCreados[i] = Barco.CANTIDAD_POR_BARCO;
        }
    }
    
    public void inicializar() {
        index = 0;
        Collections.shuffle(disparos);
        clearCountBarcos();
        tablero.limpiarTablero();
        llenarTablero();
    }
    
    public Tablero getTablero() {
        return tablero;
    }
}
