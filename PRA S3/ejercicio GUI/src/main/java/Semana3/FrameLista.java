//GRUPO 1 - ESTRUCTURA DE DATOS
package Semana3;
import java.text.DecimalFormat;
import java.awt.Font;
import javax.swing.JOptionPane;
public class FrameLista extends javax.swing.JFrame {
    //declaracion de la lista enlazada simple
    //este nodo contiene la informacion que se almacenara y su constructor
    public class Nodo{
        String codigo;
        String nombre;
        String sueldo;
        Nodo sig;
        public Nodo(String cod, String nom, String suel){
            codigo = cod;
            nombre = nom;
            sueldo = suel;
        }     }
    //Declaracion de variables locales
    public Nodo ini, fin;
    public Nodo pFound;
    int num = 0;  
    public FrameLista() {
        initComponents();
        Deshabilitar();//inicia con botones deshabilitados
        this.setTitle("Registro de Empleados (G1 - ED)");//titulos
        this.setResizable(false);//evita que se pueda agrandar la ventana
    }

    void Encabezado(){
        txaReporte.setFont(new Font("monospaced", Font.PLAIN, 12));
        txaReporte.setText("");
        //Insertar encabezado;
        txaReporte.append("");
        txaReporte.append("     N°  CODIGO  NOMBRES Y APELLIDOS       SUELDOS\n");
        txaReporte.append("--------------------------------------------------\n");
    }
    
    void Habilitar(){
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
    }
    
    void Deshabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }
    
    void LimpiarEntradas(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtSueldo.setText("");
        txtCodigo.requestFocus();
    }
    
    void VerDatos(){
        //Variable para recorrer la lista
        String cod, nom, s;
        Nodo aux = ini;
        num = 0;
        //Colocando el Encabezado
        Encabezado();
        //Recorriendo la lista
        while(aux != null){
            cod = aux.codigo;
            nom = aux.nombre;
            s = aux.sueldo;
            num++;
            String numera = String.valueOf(num);
            //modificando el tamaño de la numeracion con espacios en blanco a la izquierda
            for(int i = String.valueOf(num).length(); i < 5; i++)
                numera = " " + numera;
            //modificando el tamaño de la cadena codigo con espacios en blanco a la derecha
            for(int i = cod.length(); i < 12; i++)
                cod = cod + " ";
            //modificando el tamaño de la cadena nombre con espacios en blanco a la derecha
            for(int i = nom.length(); i < 23; i++)
                nom = nom + " ";
            //le damos formato al sueldo solo con dos decimales
            DecimalFormat df2 = new DecimalFormat("####.00");
            s = df2.format(Double.valueOf(s));
            //modificando el tamaño de la cadena sueldo con espacios en blanco a la izquierda
            for(int i = s.length(); i < 12; i++)
                s = " " + s;
            //Colocando la informacion en el TextArea
            txaReporte.append(numera + " " + cod + nom + s + "\n");
            aux = aux.sig;
        }
    }
    
    Nodo Buscar(Nodo inicio, String cod){
        Nodo pos = inicio;
        //recoddiendo la lista para encontrar la informacion
        while(pos != null && !cod.equalsIgnoreCase(pos.codigo))
            pos = pos.sig;
        return pos;     }
    
    Nodo InsertaInicio(Nodo inicio, String cod, String nom, String suel){
        Nodo nuevo = new Nodo(cod, nom, suel);
        //realizando los elnlaces correspondientes
        nuevo.sig = inicio;
        inicio = nuevo;
        return inicio;     }
    
    void Eliminar(Nodo actual){
        //creando un puntero al nodo anterior del actual
        Nodo anterior = ini;
        //1. buscar el nodo anterior
        while(anterior.sig != actual && anterior.sig != null)
            anterior = anterior.sig;
        //2. eliminar el nodo si existe
        if(actual != null){
            if(anterior == actual) ini = actual.sig; //borrar el primero
            else anterior.sig = actual.sig; //borrar en el otro sitio
        }     }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaReporte = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE EMPLEADOS");

        txaReporte.setColumns(20);
        txaReporte.setRows(5);
        jScrollPane1.setViewportView(txaReporte);

        jLabel2.setText("CODIGO");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("SUELDO");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSueldo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRestaurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultar)
                            .addComponent(btnEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRestaurar)
                            .addComponent(btnSalir))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //capturando la informacion de los objetos
        String cod = txtCodigo.getText();
        String nom = txtNombre.getText().toUpperCase();
        String suel = txtSueldo.getText();
        //creando el nodo de la lista en memoria y colocando la informacion
        ini = InsertaInicio(ini, cod, nom, suel);
        LimpiarEntradas();
        //insertar(num, cod, nom, suel);
        VerDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        pFound.codigo = txtCodigo.getText();
        pFound.nombre = txtNombre.getText();
        pFound.sueldo = txtSueldo.getText();
        LimpiarEntradas();
        Deshabilitar();
        VerDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar(pFound);
        LimpiarEntradas();
        VerDatos();
        if(ini == null)
            JOptionPane.showMessageDialog(this, "La lista se encuentra vacia");
        Deshabilitar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String cod = txtCodigo.getText();
        if(cod.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(this, "Usuario, por favor ingrese un codigo");
        else{
            //llamada a la funcion que retorna la posicion del datos buscado
            pFound = Buscar(ini, cod);
            //verificando el puntero pFound para mostrar la inf. buscada
            if(pFound != null){
                txtNombre.setText(pFound.nombre);
                txtSueldo.setText(pFound.sueldo);
                //Habilitar para eliminar y actualizar
                Habilitar();
            }
            else
                JOptionPane.showMessageDialog(this, "El codigo: " + cod + ", no esta en la lista");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JOptionPane.showMessageDialog(this, "Saliendo");
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
       LimpiarEntradas();
       Deshabilitar();
    }//GEN-LAST:event_btnRestaurarActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt){
        //Colocando el encabezado
        Encabezado();
        //Deshabilitando objetos
        Deshabilitar();    
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrameLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaReporte;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
