package view;

import java.awt.BorderLayout;
import java.awt.Point;
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
        textPortaAviones.setText("Porta Aviones(5): " + Barco.CANTIDAD_POR_BARCO);
        textAcorazado.setText("Acorazado(4): " + Barco.CANTIDAD_POR_BARCO);
        textSubmarino.setText("Submarino(3): " + Barco.CANTIDAD_POR_BARCO);
        textDestructor.setText("Destructor(2): " + Barco.CANTIDAD_POR_BARCO);
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
        textPortaAviones.setText("Porta Aviones(5) :" + barcosAgreagos[0]);
        textAcorazado.setText("Acorazado(4): " + barcosAgreagos[1]);
        textSubmarino.setText("Submarino(3): " + barcosAgreagos[2]);
        textDestructor.setText("Destructor(2): " + barcosAgreagos[3]);
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
        panelNorte = new javax.swing.JPanel();
        textNombre = new javax.swing.JLabel();
        textContadorErrores = new javax.swing.JLabel();
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

        setLayout(new java.awt.BorderLayout());

        panelSur.setLayout(new java.awt.GridLayout(1, 0));

        botonLimpiarTablero.setText("Limpiar Tablero");
        panelSur.add(botonLimpiarTablero);

        botonComenzar.setText("Comenzar");
        panelSur.add(botonComenzar);

        botonAtras.setText("Atras");
        panelSur.add(botonAtras);

        add(panelSur, java.awt.BorderLayout.PAGE_END);

        panelNorte.setLayout(new java.awt.GridLayout(1, 0));

        textNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textNombre.setText("Nombre");
        panelNorte.add(textNombre);

        textContadorErrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textContadorErrores.setText("Contador Errores");
        panelNorte.add(textContadorErrores);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelCenter.setLayout(new java.awt.BorderLayout());

        panelOpciones.setLayout(new java.awt.GridLayout(12, 1));

        btnHelp.setText("help");
        panelOpciones.add(btnHelp);

        textPortaAviones.setText("Porta Aviones(5)");
        panelOpciones.add(textPortaAviones);

        textAcorazado.setText("Acorazado(4)");
        panelOpciones.add(textAcorazado);

        textSubmarino.setText("Submarino(3)");
        panelOpciones.add(textSubmarino);

        textDestructor.setText("Destructor(2)");
        panelOpciones.add(textDestructor);

        tipoBarco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porta Aviones", "Acorazado", "Submarino", "Destructor" }));
        panelOpciones.add(tipoBarco);

        selectOrientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vertical", "Horizontal" }));
        selectOrientacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOrientacionActionPerformed(evt);
            }
        });
        panelOpciones.add(selectOrientacion);

        textX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textX.setText("Coordenada X");
        panelOpciones.add(textX);
        panelOpciones.add(inputX);

        textY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textY.setText("Coordenada Y");
        panelOpciones.add(textY);
        panelOpciones.add(inputY);

        botonAgregar.setText("Agregar");
        panelOpciones.add(botonAgregar);

        panelCenter.add(panelOpciones, java.awt.BorderLayout.LINE_START);

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
    private javax.swing.JTextField inputX;
    private javax.swing.JTextField inputY;
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
