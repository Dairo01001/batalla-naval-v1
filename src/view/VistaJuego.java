package view;

import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import model.barco.Barco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class VistaJuego extends javax.swing.JPanel {

    private VistaTablero tableroJugador, tableroMaquina;

    public VistaJuego() {
        initComponents();
        initTableros();
    }

    public JButton getBtnHelp() {
        return btnHelp;
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
    
    public void setModelJugadorBarcos(TipoCeldaTablero[][] modelTablero, ArrayList<Barco> barcos) {
        tableroJugador.setModelJugadorBarcos(modelTablero, barcos);
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
        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        textAtaques = new javax.swing.JLabel();
        textTiempo = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        fontsup = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fondinfe = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        panelJugador = new javax.swing.JPanel();
        panelMaquina = new javax.swing.JPanel();

        setBackground(new java.awt.Color(226, 166, 122));
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setLayout(new java.awt.BorderLayout());

        panelNorte.setOpaque(false);
        panelNorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setText("Nombre Jugador: ");
        panelNorte.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 190, 32));

        textNombre.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textNombre.setText("Nombre");
        panelNorte.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, 32));

        textAtaques.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textAtaques.setText("Contador Ataques");
        panelNorte.add(textAtaques, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 216, 40));

        textTiempo.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTiempo.setText("1:3");
        panelNorte.add(textTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 160, 40));

        btnHelp.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda.png"))); // NOI18N
        btnHelp.setText("Ayuda");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusPainted(false);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(2).png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(1).png"))); // NOI18N
        panelNorte.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 110, -1));

        fontsup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/superio.png"))); // NOI18N
        panelNorte.add(fontsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 40));

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelSur.setOpaque(false);
        panelSur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textX.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textX.setText("X: ");
        jPanel1.add(textX, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 7, 40, -1));
        jPanel1.add(inputX, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2, 160, 30));

        textY.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textY.setText("Y: ");
        jPanel1.add(textY, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 35, 40, 30));
        jPanel1.add(inputY, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 34, 160, 30));

        botonAtacar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atacar.png"))); // NOI18N
        botonAtacar.setBorder(null);
        botonAtacar.setBorderPainted(false);
        botonAtacar.setContentAreaFilled(false);
        botonAtacar.setFocusPainted(false);
        botonAtacar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atacar (2).png"))); // NOI18N
        botonAtacar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atacar (1).png"))); // NOI18N
        jPanel1.add(botonAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 210, 40));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras.png"))); // NOI18N
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setFocusPainted(false);
        botonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (2).png"))); // NOI18N
        botonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (1).png"))); // NOI18N
        jPanel1.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, 40));

        panelSur.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, -1));

        textLog.setColumns(20);
        textLog.setRows(5);
        jScrollPane1.setViewportView(textLog);

        panelSur.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 400, 90));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setText("Movimientos");
        panelSur.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 130, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setText("Historial ");
        panelSur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 120, -1));

        fondinfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inferfiorjuego.png"))); // NOI18N
        panelSur.add(fondinfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 110));

        add(panelSur, java.awt.BorderLayout.PAGE_END);

        panelCentro.setOpaque(false);
        panelCentro.setLayout(new java.awt.GridLayout(1, 0));

        panelJugador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tablero Jugador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 18))); // NOI18N
        panelJugador.setOpaque(false);
        panelJugador.setLayout(new java.awt.BorderLayout());
        panelCentro.add(panelJugador);

        panelMaquina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tablero Maquina", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 18))); // NOI18N
        panelMaquina.setOpaque(false);
        panelMaquina.setLayout(new java.awt.BorderLayout());
        panelCentro.add(panelMaquina);

        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtacar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel fondinfe;
    private javax.swing.JLabel fontsup;
    private javax.swing.JTextField inputX;
    private javax.swing.JTextField inputY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
