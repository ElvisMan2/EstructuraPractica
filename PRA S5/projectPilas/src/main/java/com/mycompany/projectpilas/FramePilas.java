package com.mycompany.projectpilas;

import javax.swing.JOptionPane;

public class FramePilas extends javax.swing.JFrame { 
    private PilaArray objPila;
    public FramePilas() {
        initComponents();
        objPila = new PilaArray(10); // Crear un objeto PilaArray con un tamaño máximo de 10
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGetData = new javax.swing.JButton();
        btnDeleteData = new javax.swing.JButton();
        btnShowData = new javax.swing.JButton();
        btnLastElement = new javax.swing.JButton();
        btnEmptyStack = new javax.swing.JButton();
        btnGoOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pilas");

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

        btnLastElement.setText("Último Elemento");
        btnLastElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastElementActionPerformed(evt);
            }
        });

        btnEmptyStack.setText("Vaciar Pila");
        btnEmptyStack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyStackActionPerformed(evt);
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
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteData)
                    .addComponent(btnGetData)
                    .addComponent(btnShowData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLastElement)
                    .addComponent(btnEmptyStack)
                    .addComponent(btnGoOut))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetData)
                    .addComponent(btnLastElement))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteData)
                    .addComponent(btnEmptyStack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowData)
                    .addComponent(btnGoOut))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
        // TODO add your handling code here:
        // Obtener el elemento a ingresar (puedes usar JTextField para ingresar el valor)
        int elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un elemento"));
        objPila.InsertarPila(elemento);
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void btnLastElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastElementActionPerformed
        // TODO add your handling code here:
        int ultimoElemento = objPila.primeroPila();
        if (ultimoElemento != -1) { // Verificar si la pila está vacía
            JOptionPane.showMessageDialog(null, "Último elemento ingresado en la Pila: " + ultimoElemento);
        }
    }//GEN-LAST:event_btnLastElementActionPerformed

    private void btnDeleteDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDataActionPerformed
        // TODO add your handling code here:
        if(confirmarEliminar()){
            objPila.EliminarPila();
        }
    }//GEN-LAST:event_btnDeleteDataActionPerformed

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        // TODO add your handling code here:
        objPila.MostrarPila();
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void btnEmptyStackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyStackActionPerformed
        // TODO add your handling code here:
        objPila.VaciarPila();
    }//GEN-LAST:event_btnEmptyStackActionPerformed

    private void btnGoOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoOutActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnGoOutActionPerformed

    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePilas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteData;
    private javax.swing.JButton btnEmptyStack;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnGoOut;
    private javax.swing.JButton btnLastElement;
    private javax.swing.JButton btnShowData;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private boolean confirmarEliminar() {
        
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Desea eliminar el elemento de la pila?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION
        );
        return opcion == JOptionPane.YES_OPTION;
    }  
}
