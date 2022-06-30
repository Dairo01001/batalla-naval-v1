package view;

import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class VistaJuego extends javax.swing.JPanel {

    private VistaTablero tableroJugador, tableroMaquina;

    public VistaJuego() {
        initComponents();
        initTableros();
    }

    private void initTableros() {
        tableroJugador = new VistaTablero();
        tableroMaquina = new VistaTablero();

        panelJugador.add(tableroJugador, BorderLayout.CENTER);
        panelMaquina.add(tableroMaquina, BorderLayout.CENTER);
    }
    
    public void clearView() {
        textLog.setText("");
        tableroJugador.limpiarTablero();
        tableroMaquina.limpiarTablero();
    }

    public JButton getBotonAtacar() {
        return botonAtacar;
    }
    
    public void setModelMaquina(TipoCeldaTablero[][] tableroMaquina) {
        this.tableroMaquina.setModelMaquina(tableroMaquina);
    }
    
    public void setModelJugador(TipoCeldaTablero [][] tableroJugador) {
        this.tableroJugador.setModelJugador(tableroJugador);
    }
    
    public void setKeyListener(KeyListener k) {
        inputX.addKeyListener(k);
        inputY.addKeyListener(k);
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public void setNombreJugador(String nombre) {
        textNombre.setText(nombre);
    }

    public JLabel getLabelTiempo() {
        return textTiempo;
    }
    
    public void setContadorAtaques(int ataques) {
        textAtaques.setText("Ataques: " + ataques);
    }

    public boolean verificarEntradas() {
        try {
            int x = Integer.parseInt(inputX.getText());
            int y = Integer.parseInt(inputY.getText());

            if (x < 0 || x >= Tablero.TAMANIO || y < 0 || y >= Tablero.TAMANIO) {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    

    public int getInputX() {
        return Integer.parseInt(inputY.getText());
    }

    public int getInputY() {
        return Integer.parseInt(inputX.getText());
    }

    public JTextArea getTextLog() {
        return textLog;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        textNombre = new javax.swing.JLabel();
        textAtaques = new javax.swing.JLabel();
        textTiempo = new javax.swing.JLabel();
        panelSur = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textX = new javax.swing.JLabel();
        inputX = new javax.swing.JTextField();
        textY = new javax.swing.JLabel();
        inputY = new javax.swing.JTextField();
        botonAtacar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();
        panelCentro = new javax.swing.JPanel();
        panelJugador = new javax.swing.JPanel();
        panelMaquina = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.GridLayout(1, 0));

        textNombre.setText("Dairo");
        panelNorte.add(textNombre);

        textAtaques.setText("Contador Ataques");
        panelNorte.add(textAtaques);

        textTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTiempo.setText("1:3");
        panelNorte.add(textTiempo);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelSur.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        textX.setText("X: ");
        jPanel1.add(textX);
        jPanel1.add(inputX);

        textY.setText("Y: ");
        jPanel1.add(textY);
        jPanel1.add(inputY);

        botonAtacar.setText("Atacar");
        jPanel1.add(botonAtacar);

        botonAtras.setText("Atas");
        jPanel1.add(botonAtras);

        panelSur.add(jPanel1);

        textLog.setColumns(20);
        textLog.setRows(5);
        jScrollPane1.setViewportView(textLog);

        panelSur.add(jScrollPane1);

        add(panelSur, java.awt.BorderLayout.PAGE_END);

        panelCentro.setLayout(new java.awt.GridLayout());

        panelJugador.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador"));
        panelJugador.setLayout(new java.awt.BorderLayout());
        panelCentro.add(panelJugador);

        panelMaquina.setBorder(javax.swing.BorderFactory.createTitledBorder("Maquina"));
        panelMaquina.setLayout(new java.awt.BorderLayout());
        panelCentro.add(panelMaquina);

        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtacar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JTextField inputX;
    private javax.swing.JTextField inputY;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelJugador;
    private javax.swing.JPanel panelMaquina;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JLabel textAtaques;
    private javax.swing.JTextArea textLog;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textTiempo;
    private javax.swing.JLabel textX;
    private javax.swing.JLabel textY;
    // End of variables declaration//GEN-END:variables
}
