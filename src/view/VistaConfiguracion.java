package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;
import model.barco.Barco;
import model.barco.TipoBarco;
import model.tablero.Tablero;
import model.tablero.TipoCeldaTablero;

public class VistaConfiguracion extends javax.swing.JPanel {

    private VistaTablero tablero;

    public VistaConfiguracion() {
        initComponents();
        agregarTablero();
    }

    public JButton getBtnHelp() {
        return btnHelp;
    }

    private void agregarTablero() {
        tablero = new VistaTablero();
        panelCenter.add(tablero, BorderLayout.CENTER);
    }

    public void agregarModelo(TipoCeldaTablero[][] tableroJugador) {
        tablero.setModelJugador(tableroJugador);
    }

    public void agregarModeloBarcos(TipoCeldaTablero[][] tableroJugador, ArrayList<Barco> barcos) {
        tablero.setModelJugadorBarcos(tableroJugador, barcos);
    }

    public VistaTablero getTablero() {
        return tablero;
    }

    public JButton getBotonComenzar() {
        return botonComenzar;
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public JButton getBotonLimpiarTablero() {
        return botonLimpiarTablero;
    }

    public void limpiarTablero() {
        textPortaAviones.setText("" + Barco.CANTIDAD_POR_BARCO);
        textAcorazado.setText("" + Barco.CANTIDAD_POR_BARCO);
        textSubmarino.setText("" + Barco.CANTIDAD_POR_BARCO);
        textDestructor.setText("" + Barco.CANTIDAD_POR_BARCO);
        inputX.setText("");
        inputY.setText("");
        tablero.limpiarTablero();
    }

    public void setNombreJugador(String nombre) {
        textNombre.setText(nombre);
    }

    public void setContadorErrores(int errors) {
        textContadorErrores.setText("Errores: " + errors);
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
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

    public Barco getBarco() {

        TipoBarco tipo = TipoBarco.PORTA_AVIONES;

        switch (tipoBarco.getSelectedIndex()) {
            case 0:
                tipo = TipoBarco.PORTA_AVIONES;
                break;
            case 1:
                tipo = TipoBarco.ACORAZADO;
                break;
            case 2:
                tipo = TipoBarco.SUBMARINO;
                break;
            case 3:
                tipo = TipoBarco.DESTRUCTOR;
                break;
            default:
                throw new AssertionError();
        }

        int orientacion = selectOrientacion.getSelectedIndex();

        Point inicio = new Point(getInputX(), getInputY());
        inputX.setText("");
        inputY.setText("");

        return Barco.crearBarco(tipo, orientacion, inicio);
    }

    public void setBarcosAgregados(int[] barcosAgreagos) {
        textPortaAviones.setText("" + barcosAgreagos[0]);
        textAcorazado.setText("" + barcosAgreagos[1]);
        textSubmarino.setText("" + barcosAgreagos[2]);
        textDestructor.setText("" + barcosAgreagos[3]);
    }

    public int getInputX() {
        return Integer.parseInt(inputY.getText());
    }

    public int getInputY() {
        return Integer.parseInt(inputX.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSur = new javax.swing.JPanel();
        botonLimpiarTablero = new javax.swing.JButton();
        botonComenzar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        fondinfe = new javax.swing.JLabel();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        textContadorErrores = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fondo_sup = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        btnHelp = new javax.swing.JButton();
        textPortaAviones = new javax.swing.JLabel();
        textAcorazado = new javax.swing.JLabel();
        textSubmarino = new javax.swing.JLabel();
        textDestructor = new javax.swing.JLabel();
        tipoBarco = new javax.swing.JComboBox<>();
        selectOrientacion = new javax.swing.JComboBox<>();
        textX = new javax.swing.JLabel();
        inputX = new javax.swing.JTextField();
        textY = new javax.swing.JLabel();
        inputY = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        imgPorta = new javax.swing.JLabel();
        imgAcorazado = new javax.swing.JLabel();
        imgSubmarino = new javax.swing.JLabel();
        imgDestructor = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1080, 600));
        setLayout(new java.awt.BorderLayout());

        panelSur.setOpaque(false);
        panelSur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonLimpiarTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_limpiar-tablero.png"))); // NOI18N
        botonLimpiarTablero.setBorder(null);
        botonLimpiarTablero.setBorderPainted(false);
        botonLimpiarTablero.setContentAreaFilled(false);
        botonLimpiarTablero.setFocusPainted(false);
        botonLimpiarTablero.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_limpiar-tablero (2).png"))); // NOI18N
        botonLimpiarTablero.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_limpiar-tablero (1).png"))); // NOI18N
        panelSur.add(botonLimpiarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 230, 60));

        botonComenzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_comenzar.png"))); // NOI18N
        botonComenzar.setBorder(null);
        botonComenzar.setBorderPainted(false);
        botonComenzar.setContentAreaFilled(false);
        botonComenzar.setFocusPainted(false);
        botonComenzar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_comenzar (2).png"))); // NOI18N
        botonComenzar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_comenzar (1).png"))); // NOI18N
        panelSur.add(botonComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 220, 60));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras.png"))); // NOI18N
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setFocusPainted(false);
        botonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (2).png"))); // NOI18N
        botonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (1).png"))); // NOI18N
        panelSur.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 250, 60));

        fondinfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inferior.png"))); // NOI18N
        panelSur.add(fondinfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 60));

        add(panelSur, java.awt.BorderLayout.PAGE_END);

        panelNorte.setOpaque(false);
        panelNorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre Jugador: ");
        panelNorte.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 200, 50));

        textNombre.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textNombre.setText("Nombre");
        panelNorte.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 100, 50));

        textContadorErrores.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        textContadorErrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textContadorErrores.setText("Contador Errores");
        panelNorte.add(textContadorErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 190, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconojuga.png"))); // NOI18N
        panelNorte.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 50));

        fondo_sup.setBackground(new java.awt.Color(204, 255, 255));
        fondo_sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/superio.png"))); // NOI18N
        panelNorte.add(fondo_sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 50));

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelCenter.setOpaque(false);
        panelCenter.setLayout(new java.awt.BorderLayout());

        panelOpciones.setOpaque(false);
        panelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHelp.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda.png"))); // NOI18N
        btnHelp.setText("Ayuda");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusPainted(false);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(2).png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(1).png"))); // NOI18N
        panelOpciones.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 41));

        textPortaAviones.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textPortaAviones.setText("1");
        panelOpciones.add(textPortaAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 30, 40));

        textAcorazado.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textAcorazado.setText("1");
        panelOpciones.add(textAcorazado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 30, 41));

        textSubmarino.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textSubmarino.setText("1");
        panelOpciones.add(textSubmarino, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 30, 41));

        textDestructor.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textDestructor.setText("1");
        panelOpciones.add(textDestructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 30, 41));

        tipoBarco.setBackground(new java.awt.Color(19, 79, 92));
        tipoBarco.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        tipoBarco.setForeground(new java.awt.Color(255, 255, 255));
        tipoBarco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Port Aviones", "Acorazado", "Submarino", "Destructor" }));
        tipoBarco.setFocusable(false);
        panelOpciones.add(tipoBarco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 30));

        selectOrientacion.setBackground(new java.awt.Color(19, 79, 92));
        selectOrientacion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        selectOrientacion.setForeground(new java.awt.Color(255, 255, 255));
        selectOrientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vertical", "Horizontal" }));
        selectOrientacion.setFocusable(false);
        selectOrientacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOrientacionActionPerformed(evt);
            }
        });
        panelOpciones.add(selectOrientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 30));

        textX.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textX.setText("Coordenada X");
        panelOpciones.add(textX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 120, 41));
        panelOpciones.add(inputX, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 30));

        textY.setFont(new java.awt.Font("DialogInput", 1, 15)); // NOI18N
        textY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textY.setText("Coordenada Y");
        panelOpciones.add(textY, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 120, 30));

        inputY.setPreferredSize(new java.awt.Dimension(10, 20));
        panelOpciones.add(inputY, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 30));

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_agregar.png"))); // NOI18N
        botonAgregar.setBorder(null);
        botonAgregar.setBorderPainted(false);
        botonAgregar.setContentAreaFilled(false);
        botonAgregar.setFocusPainted(false);
        botonAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_agregar (2).png"))); // NOI18N
        botonAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_agregar (1).png"))); // NOI18N
        panelOpciones.add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 140, 40));

        imgPorta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/portaAbiones.png"))); // NOI18N
        panelOpciones.add(imgPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 40, 250, 50));

        imgAcorazado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/acorazado.png"))); // NOI18N
        panelOpciones.add(imgAcorazado, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 90, -1, -1));

        imgSubmarino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/submarino.png"))); // NOI18N
        panelOpciones.add(imgSubmarino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        imgDestructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/destructor.png"))); // NOI18N
        panelOpciones.add(imgDestructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        panelOpciones.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 490));

        panelCenter.add(panelOpciones, java.awt.BorderLayout.LINE_START);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 100));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/geneal.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 490));

        panelCenter.add(jPanel1, java.awt.BorderLayout.LINE_END);

        add(panelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void selectOrientacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectOrientacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectOrientacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonComenzar;
    private javax.swing.JButton botonLimpiarTablero;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel fondinfe;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo_sup;
    private javax.swing.JLabel imgAcorazado;
    private javax.swing.JLabel imgDestructor;
    private javax.swing.JLabel imgPorta;
    private javax.swing.JLabel imgSubmarino;
    private javax.swing.JTextField inputX;
    private javax.swing.JTextField inputY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelSur;
    private javax.swing.JComboBox<String> selectOrientacion;
    private javax.swing.JLabel textAcorazado;
    private javax.swing.JLabel textContadorErrores;
    private javax.swing.JLabel textDestructor;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textPortaAviones;
    private javax.swing.JLabel textSubmarino;
    private javax.swing.JLabel textX;
    private javax.swing.JLabel textY;
    private javax.swing.JComboBox<String> tipoBarco;
    // End of variables declaration//GEN-END:variables
}
