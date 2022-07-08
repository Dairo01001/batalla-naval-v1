
package view;

import javax.swing.JButton;

public class VistaScore extends javax.swing.JPanel {


    public VistaScore() {
        initComponents();
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }
    
    public void setPuntajes(String text) {
        textPuntajes.setText(text);
    }

    public JButton getBtnHelp() {
        return btnHelp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPuntajes = new javax.swing.JTextArea();
        botonAtras = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textTitulo.setFont(new java.awt.Font("Fira Code Medium", 0, 24)); // NOI18N
        textTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/puntuacion.png"))); // NOI18N
        add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 58, -1, -1));

        textPuntajes.setEditable(false);
        textPuntajes.setColumns(20);
        textPuntajes.setRows(5);
        jScrollPane1.setViewportView(textPuntajes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 146, 729, 309));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras.png"))); // NOI18N
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setFocusPainted(false);
        botonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (2).png"))); // NOI18N
        botonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_atras (1).png"))); // NOI18N
        add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 473, 179, 44));

        botonSalir.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(null);
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setFocusPainted(false);
        botonSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir(2).png"))); // NOI18N
        botonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_salir(1).png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(986, 546, -1, -1));

        btnHelp.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda.png"))); // NOI18N
        btnHelp.setText("Ayuda");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusPainted(false);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(2).png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_ayuda(1).png"))); // NOI18N
        add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 12, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textPuntajes;
    private javax.swing.JLabel textTitulo;
    // End of variables declaration//GEN-END:variables
}
