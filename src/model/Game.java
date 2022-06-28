package model;

import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import model.barco.Barco;
import model.maquina.Maquina;
import model.player.Player;
import utils.Escribir;

public class Game {

    private final Player jugador;
    private final Maquina maquina;
    private Temporizador temporizador;
    private JTextArea textLog;

    public Game(Player jugador, Maquina maquina) {
        this.jugador = jugador;
        this.maquina = maquina;
        temporizador = null;
        this.maquina.inicializar();
    }

    public void setTextLog(JTextArea textLog) {
        this.textLog = textLog;
    }

    public boolean agregarBarcosJugador(Barco barco) {
        if (jugador.getTablero().esValido(barco)) {
            return jugador.agregarBarco(barco);
        } else {
            jugador.contarErrores();
        }
        return false;
    }

    public Player getJugador() {
        return jugador;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void crearTemporizador(JLabel display) {
        if (temporizador == null) {
            temporizador = new Temporizador(display);
        }
    }

    public boolean jugadorAtacaMaquina(int x, int y) {
        if (jugador.disparoValidoHistorial(x, y)) {
            textLog.append("Jugador ataca en [" + x + "," + y + "]\n");
            maquina.getTablero().hacerDisparo(x, y);
            return true;
        }
        return false;
    }

    public boolean JuegoTerminado() {
        return maquina.getTablero().estaTerminado() || jugador.juegoTerminado();
    }

    public void maquinaAtacaJugador() {
        Point ataque = maquina.atacar();
        textLog.append("Maquina ataca en [" + ataque.y + "," + ataque.x + "]\n");
        while (jugador.getTablero().hacerDisparo(ataque.x, ataque.y)) {
            ataque = maquina.atacar();
            textLog.append("Maquina ataca en [" + ataque.y + "," + ataque.x + "]\n");
        }
    }

    public void startTemporizador() {
        if (temporizador.isInterrupted()) {
            temporizador.start();
        }
    }

    public void stopTemporizador() {
        temporizador.interrupt();
    }

    public void guardarPuntajes() {
        try {
            Escribir.escribirPuntaje(jugador);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
