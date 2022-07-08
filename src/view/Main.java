package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Game;
import model.maquina.Maquina;
import model.player.Player;
import utils.Leer;
import utils.Open;

public class Main extends JFrame {

    private CardLayout paneles;

    private final Game game;

    private JPanel panelPrincipal;
    private VistaIncio vistaIncio;
    private VistaConfiguracion vistaConfiguracion;
    private VistaJuego vistaJuego;
    private VistaScore vistaScore;

    public Main() throws HeadlessException {
        initComponents();
        game = new Game(new Player("Ramdom"), new Maquina());
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        vistaIncio = new VistaIncio();
        vistaIncio.getBotonJugar().addActionListener(new JugarListener());
        vistaIncio.getBotonSalir().addActionListener(new SalirListener());
        vistaIncio.getButtonPuntajes().addActionListener((ActionEvent ae) -> {
            try {
                vistaScore.setPuntajes(Leer.leerPuntaje());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            paneles.show(panelPrincipal, "puntaje");
        });
        vistaIncio.getBtnHelp().addActionListener(l -> {
            Open.openPdf();
        });

        vistaConfiguracion = new VistaConfiguracion();
        vistaConfiguracion.getBotonComenzar().addActionListener((ActionEvent ae) -> {
            if (game.getJugador().getTablero().estaLleno()) {
                paneles.show(panelPrincipal, "juego");
                game.crearTemporizador(vistaJuego.getLabelTiempo());
                game.startTemporizador();
            } else {
                vistaConfiguracion.setContadorErrores(game.getJugador().contarErrores());
                JOptionPane.showMessageDialog(panelPrincipal, "Acomoda todos lo varcos!");
            }
        });
        vistaConfiguracion.getBotonAtras().addActionListener(new AtrasListener());
        vistaConfiguracion.getBotonAgregar().addActionListener(new AgregarBarcoListener());
        vistaConfiguracion.getBotonLimpiarTablero().addActionListener(new LimpiarTableroPlayerListener());
        vistaConfiguracion.getBtnHelp().addActionListener(l -> {
            Open.openPdf();
        });

        vistaJuego = new VistaJuego();
        vistaJuego.getBotonAtras().addActionListener((ActionEvent ae) -> {
            if (seguroDeseasSalir()) {
                vistaJuego.clearView();
                game.clear();
                vistaConfiguracion.limpiarTablero();
                paneles.show(panelPrincipal, "inicio");
            }
        });
        vistaJuego.getBotonAtacar().addActionListener(new AtacarListener());
        vistaJuego.setKeyListener(new PressEnter());
        vistaJuego.getBtnHelp().addActionListener(l -> {
            Open.openPdf();
        });

        vistaScore = new VistaScore();
        vistaScore.getBotonAtras().addActionListener(new AtrasListener());
        vistaScore.getBotonSalir().addActionListener(new SalirListener());
        vistaScore.getBtnHelp().addActionListener(l -> {
            Open.openPdf();
        });

        paneles = new CardLayout();
        panelPrincipal = new JPanel(paneles);

        panelPrincipal.add(vistaIncio, "inicio");
        panelPrincipal.add(vistaConfiguracion, "config");
        panelPrincipal.add(vistaJuego, "juego");
        panelPrincipal.add(vistaScore, "puntaje");

        add(panelPrincipal, BorderLayout.CENTER);
    }

    private boolean seguroDeseasSalir() {
        int resul = JOptionPane.showConfirmDialog(panelPrincipal, "Seguro deseas salir!?");
        return resul == 0;
    }

    private class JugarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (vistaIncio.getNombre().equals("")) {
                JOptionPane.showMessageDialog(panelPrincipal, "Escribe tu nombre!");
            } else {
                game.getJugador().setNombre(vistaIncio.getNombre());

                vistaIncio.clearView();

                vistaConfiguracion.setNombreJugador(game.getJugador().getNombre());
                vistaConfiguracion.setContadorErrores(game.getJugador().getErrores());

                vistaJuego.setNombreJugador(game.getJugador().getNombre());
                vistaJuego.setModelJugador(game.getJugador().getModelTablero());

                game.setTextLog(vistaJuego.getTextLog());
                paneles.show(panelPrincipal, "config");
            }
        }
    }

    private class PressEnter implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (KeyEvent.VK_ENTER == ke.getKeyCode()) {
                Atack();
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }

    }

    private void Atack() {
        if (vistaJuego.verificarEntradas()) {
            vistaJuego.setContadorAtaques(game.getJugador().contarAtaques());
            if (game.jugadorAtacaMaquina(vistaJuego.getInputX(), vistaJuego.getInputY())) {
                vistaJuego.setModelMaquina(game.getMaquina().getModelTablero());
                
                game.maquinaAtacaJugador();
                vistaJuego.setModelJugador(game.getJugador().getModelTablero());
                
                if (game.JuegoTerminado()) {
                    game.guardarPuntajes();
                    vistaJuego.clearView();
                    vistaConfiguracion.limpiarTablero();
                    game.clear();
                    paneles.show(panelPrincipal, "inicio");
                }

            } else {
                game.getJugador().contarErrores();
                JOptionPane.showMessageDialog(panelPrincipal, "Ya has hecho ese atque!");
            }
        } else {
            game.getJugador().contarErrores();
            JOptionPane.showMessageDialog(panelPrincipal, "Entrada invalida!");
        }
    }

    private class AtacarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Atack();
        }
    }

    private class LimpiarTableroPlayerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            game.getJugador().limpiarTablero();
            vistaConfiguracion.setBarcosAgregados(game.getJugador().getBarcosCreados());
            vistaConfiguracion.limpiarTablero();
        }
    }

    private class AgregarBarcoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (game.getJugador().terminoAcomodarBarcos()) {
                JOptionPane.showMessageDialog(panelPrincipal, "Ya puedes comenzar el Juego!");
            } else {
                if (vistaConfiguracion.verificarEntradas()) {
                    if (game.agregarBarcosJugador(vistaConfiguracion.getBarco())) {
                        vistaConfiguracion.setBarcosAgregados(game.getJugador().getBarcosCreados());
                        vistaConfiguracion.agregarModelo(game.getJugador().getModelTablero());
                    } else {

                        JOptionPane.showMessageDialog(panelPrincipal, "No se pudo crear el Barco!");

                        vistaConfiguracion.setContadorErrores(game.getJugador().contarErrores());
                    }
                } else {
                    JOptionPane.showMessageDialog(panelPrincipal, "Entrada invalida!");
                    vistaConfiguracion.setContadorErrores(game.getJugador().contarErrores());
                }
            }

        }
    }

    private class SalirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int resultado = JOptionPane.showConfirmDialog(panelPrincipal, "Seguro deseas salir?");
            if (resultado == 0) {
                System.exit(0);
            }
        }
    }

    private class AtrasListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vistaConfiguracion.limpiarTablero();
            paneles.show(panelPrincipal, "inicio");
        }
    }

    public static void main(String[] args) {
        Main ventana = new Main(); 
        ventana.pack();
        ventana.setVisible(true);
    }
}
