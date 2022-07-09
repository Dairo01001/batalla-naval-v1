package model;

import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.barco.Barco;
import model.maquina.Maquina;
import model.player.Player;
import utils.Write;

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
            temporizador.start();
        }
    }

    public boolean jugadorAtacaMaquina(int x, int y) {
        if (jugador.disparoValidoHistorial(x, y)) {
            textLog.append("Jugador ataca en [" + x + "," + y + "]\n");
            jugador.contarAtaques();
            if (maquina.getTablero().hacerDisparo(x, y)) {
                JOptionPane.showMessageDialog(null, "Has acertado el disparo!");
                jugador.aumentarPuntaje();
            }
            return true;
        }
        return false;
    }

    public boolean JuegoTerminado() {
        if (maquina.getTablero().estaTerminado()) {
            JOptionPane.showMessageDialog(null, jugador.getFormatShowPuntaje(), "Resultado!", JOptionPane.INFORMATION_MESSAGE);

            return true;
        }

        if (jugador.juegoTerminado()) {
            JOptionPane.showMessageDialog(null, "La Maquina te ha ganado!");
            return true;
        }

        return false;
    }

    public void maquinaAtacaJugador() {
        Point ataque = maquina.atacar();
        textLog.append("Maquina ataca en [" + ataque.y + "," + ataque.x + "]\n");
        while (ataque != null && jugador.getTablero().hacerDisparo(ataque.x, ataque.y)) {
            ataque = maquina.atacar();

            if (ataque != null) {
                textLog.append("Maquina ataca en [" + ataque.y + "," + ataque.x + "]\n");
            }
        }
    }

    public void startTemporizador() {
        temporizador.reanudar();
    }

    public void stopTemporizador() {
        temporizador.pausa();
    }

    public void clear() {
        stopTemporizador();
        temporizador = null;
        jugador.inicializar();
        maquina.inicializar();
    }

    public void guardarPuntajes() {
        Write.writeLineScore(jugador.getFormatoPuntaje() + "\n");
    }
}
