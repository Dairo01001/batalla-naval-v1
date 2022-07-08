
package view;

import javax.swing.JButton;
import javax.swing.JTextField;

public class VistaIncio extends javax.swing.JPanel {


    public VistaIncio() {
        initComponents();
    }
    
    public void clearView(){
        textNombre.setText("");
    }

    public JButton getBtnHelp() {
        return btnHelp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        botonSalir = new javax.swing.JButton();
        buttonPuntajes = new javax.swing.JButton();
        botonJugar = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(102, 153, 255));
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setLayout(new java.awt.BorderLayout());

        panelCentro.setOpaque(false);
        panelCentro.setPreferredSize(new java.awt.Dimension(1080, 600));
        panelCentro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nombre.png"))); // NOI18N
        panelCentro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 314, -1, 38));

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        panelCentro.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 314, 277, 38));

        botonSalir.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(null);
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setFocusPainted(false);
        botonSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir(2).png"))); // NOI18N
        botonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir(1).png"))); // NOI18N
        panelCentro.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 549, 165, -1));

        buttonPuntajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_puntajes.png"))); // NOI18N
        buttonPuntajes.setBorder(null);
        buttonPuntajes.setBorderPainted(false);
        buttonPuntajes.setContentAreaFilled(false);
        buttonPuntajes.setFocusPainted(false);
        buttonPuntajes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_puntajes (2).png"))); // NOI18N
        buttonPuntajes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_puntajes (1).png"))); // NOI18N
        panelCentro.add(buttonPuntajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 464, 238, 64));

        botonJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_jugar.png"))); // NOI18N
        botonJugar.setBorder(null);
        botonJugar.setBorderPainted(false);
        botonJugar.setContentAreaFilled(false);
        botonJugar.setFocusPainted(false);
        botonJugar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_jugar (2).png"))); // NOI18N
        botonJugar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_jugar (1).png"))); // NOI18N
        panelCentro.add(botonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 394, 238, 59));

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda.png"))); // NOI18N
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusPainted(false);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(2).png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(1).png"))); // NOI18N
        panelCentro.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 16, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bata.png"))); // NOI18N
        panelCentro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 16, -1, 280));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        panelCentro.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 600));

        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed


    public JButton getButtonPuntajes() {
        return buttonPuntajes;
    }

    public JButton getBotonJugar() {
        return botonJugar;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }
    
    public String getNombre() {
        return textNombre.getText();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonJugar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton buttonPuntajes;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
