package com.mycompany.projectcolas;

import javax.swing.JOptionPane;

public class FrameCola extends javax.swing.JFrame {
    private ColaConArray objCola;
    
    public FrameCola() {
        initComponents();
        objCola = new ColaConArray(10); // Crear un objeto ColaConArray con un tamaño máximo de 10
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ttlColas = new javax.swing.JLabel();
        btnGetData = new javax.swing.JButton();
        btnDeleteData = new javax.swing.JButton();
        btnShowData = new javax.swing.JButton();
        btnFirstElement = new javax.swing.JButton();
        btnEmptyLine = new javax.swing.JButton();
        btnGoOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ttlColas.setText("COLAS");

        btnGetData.setText("Ingresar Datos");
        btnGetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        btnDeleteData.setText("Eliminar Datos");
        btnDeleteData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDataActionPerformed(evt);
            }
        });

        btnShowData.setText("Mostrar Datos");
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });

        btnFirstElement.setText("Primer Elemento");
        btnFirstElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstElementActionPerformed(evt);
            }
        });

        btnEmptyLine.setText("Vaciar Cola");
        btnEmptyLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyLineActionPerformed(evt);
            }
        });

        btnGoOut.setText("Salir");
        btnGoOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeleteData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmptyLine)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGetData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(btnFirstElement))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnShowData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGoOut)
                        .addGap(23, 23, 23)))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(ttlColas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ttlColas)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetData)
                    .addComponent(btnFirstElement))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteData)
                    .addComponent(btnEmptyLine))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowData)
                    .addComponent(btnGoOut))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
        // TODO add your handling code here:
        int elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un elemento"));
        objCola.InsertarCola(elemento);
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void btnDeleteDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDataActionPerformed
        // TODO add your handling code here:
        objCola.EliminarCola();
    }//GEN-LAST:event_btnDeleteDataActionPerformed

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        // TODO add your handling code here:
        objCola.MostrarCola();
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void btnFirstElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstElementActionPerformed
        // TODO add your handling code here:
        int primerElemento = objCola.primeroCola();
        if (primerElemento != -1) {
            JOptionPane.showMessageDialog(null, "Primer elemento en la cola: " + primerElemento);
        }
    }//GEN-LAST:event_btnFirstElementActionPerformed

    private void btnEmptyLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyLineActionPerformed
        // TODO add your handling code here:
        objCola.VaciarCola();
    }//GEN-LAST:event_btnEmptyLineActionPerformed

    private void btnGoOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoOutActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnGoOutActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteData;
    private javax.swing.JButton btnEmptyLine;
    private javax.swing.JButton btnFirstElement;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnGoOut;
    private javax.swing.JButton btnShowData;
    private javax.swing.JLabel ttlColas;
    // End of variables declaration//GEN-END:variables
}
