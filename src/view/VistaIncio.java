
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

        panelNorte = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        botonSalir = new javax.swing.JButton();
        buttonPuntajes = new javax.swing.JButton();
        botonJugar = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.GridLayout(1, 0));

        labelTitulo.setFont(new java.awt.Font("Fira Code Medium", 1, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Batalla Naval");
        panelNorte.add(labelTitulo);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jLabel1.setText("Nombre:");

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");

        buttonPuntajes.setText("Puntajes");

        botonJugar.setText("Jugar");

        btnHelp.setText("help");

        javax.swing.GroupLayout panelCentroLayout = new javax.swing.GroupLayout(panelCentro);
        panelCentro.setLayout(panelCentroLayout);
        panelCentroLayout.setHorizontalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentroLayout.createSequentialGroup()
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCentroLayout.createSequentialGroup()
                                .addComponent(buttonPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCentroLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHelp)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelCentroLayout.setVerticalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentroLayout.createSequentialGroup()
                .addComponent(btnHelp)
                .addGap(14, 14, 14)
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPuntajes)
                    .addComponent(botonJugar))
                .addGap(18, 18, 18)
                .addComponent(botonSalir)
                .addGap(17, 17, 17))
        );

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
