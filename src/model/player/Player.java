package model.player;

import model.barco.Barco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class Player {

    private final Tablero tablero;
    private String nombre;
    private int puntaje;
    private int errores;
    private StringBuilder historialDisparos;
    private final int contarBarcosCreados[];

    private int numeroAtaques;

    public Player(String nombre) {
        historialDisparos = new StringBuilder();
        this.nombre = nombre;
        tablero = new Tablero();
        puntaje = 0;
        errores = 0;
        contarBarcosCreados = new int[Barco.CANTIDAD_DE_BARCOS];
        for (int i = 0; i < Barco.CANTIDAD_DE_BARCOS; i++) {
            contarBarcosCreados[i] = Barco.CANTIDAD_POR_BARCO;
        }
    }

    public boolean disparoValidoHistorial(int x, int y) {
        if (historialDisparos.toString().contains("[" + x + "," + y + "]")) {
            return false;
        }
        historialDisparos.append("[").append(x).append(",").append(y).append("]");
        return true;
    }

    public void limpiarTablero() {
        for (int i = 0; i < contarBarcosCreados.length; i++) {
            contarBarcosCreados[i] = Barco.CANTIDAD_POR_BARCO;
        }
        tablero.limpiarTablero();
    }

    public boolean agregarBarco(Barco barco) {

        for (int i = 0; i < Barco.TIPOS_BARCO.length; i++) {
            if (Barco.TIPOS_BARCO[i].equals(barco.getTIPO())) {
                if (contarBarcosCreados[i] == 0) {
                    return false;
                }
                contarBarcosCreados[i]--;
                break;
            }
        }

        return tablero.agregarBarco(barco);
    }

    public boolean terminoAcomodarBarcos() {
        for (int i = 0; i < contarBarcosCreados.length; i++) {
            if (contarBarcosCreados[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] getBarcosCreados() {
        return contarBarcosCreados;
    }

    public int getErrores() {
        return errores;
    }

    public int aumentarPuntaje() {
        return ++puntaje;
    }

    public int contarAtaques() {
        return ++numeroAtaques;
    }

    public int contarErrores() {
        return ++errores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public TipoCeldaTablero[][] getModelTablero() {
        return tablero.getTablero();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormatoPuntaje() {
        return this.nombre + "," + this.puntaje + "," + this.numeroAtaques + "," + this.errores;
    }

    public String getFormatShowPuntaje() {
        return "Nombre: " + nombre + "\n"
                + "Puntaje: " + puntaje + "\n"
                + "Numero ataques: " + numeroAtaques + "\n"
                + "Numero Errores: " + errores;
    }

    public boolean juegoTerminado() {
        return this.tablero.estaTerminado();
    }

    public void inicializar() {
        limpiarTablero();
        historialDisparos = new StringBuilder();
        puntaje = 0;
        errores = 0;
    }
}
