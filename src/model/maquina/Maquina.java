package model.maquina;

import java.awt.Point;
import java.util.Random;
import model.barco.Barco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class Maquina {

    private Tablero tablero;
    private final Random random;
    private StringBuilder historialDisparos;
    private final int contarBarcosCreados[];

    public Maquina() {
        random = new Random();
        tablero = new Tablero();
        contarBarcosCreados = new int[Barco.CANTIDAD_DE_BARCOS];
        for (int i = 0; i < Barco.CANTIDAD_DE_BARCOS; i++) {
            contarBarcosCreados[i] = Barco.CANTIDAD_POR_BARCO;
        }
    }
    
    public  int[] getBarcosCreados() {
        return contarBarcosCreados;
    }

    public Point atacar() {
        int x = random.nextInt(Tablero.TAMANIO);
        int y = random.nextInt(Tablero.TAMANIO);

        while (historialDisparos.toString().contains("[" + x + "," + y + "]")) {
            x = random.nextInt(Tablero.TAMANIO);
            y = random.nextInt(Tablero.TAMANIO);
        }

        historialDisparos.append("[").append(x).append(",").append(y).append("]");
        return new Point(x, y);
    }

    public void llenarTablero() {
        int index = 0;

        while (!tablero.estaLleno()) {
            if (contarBarcosCreados[index] > 0) {
                Barco barco = Barco.crearBarco(Barco.TIPOS_BARCO[index], random.nextInt(10) % 2, new Point(random.nextInt(Tablero.TAMANIO), random.nextInt(Tablero.TAMANIO)));
                if (tablero.esValido(barco)) {
                    tablero.agregarBarco(barco);
                    contarBarcosCreados[index]--;
                }
            } else {
                index++;
            }
        }
    }
    
    public TipoCeldaTablero[][] getModelTablero() {
        return tablero.getTablero();
    }

    public void inicializar() {
        historialDisparos = new StringBuilder();
        tablero = new Tablero();
        llenarTablero();
    }

    public Tablero getTablero() {
        return tablero;
    }
}
