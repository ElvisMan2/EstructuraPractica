//GRUPO 1 - ESTRUCTURA DE DATOS
package Semana3;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class EjercicioPropuesto extends javax.swing.JFrame {
    //declaracion de la lista enlazada simple
    //este nodo contiene la informacion que se almacenara y su constructor
    public class Nodo{
        String codigo;
        String nombre;
        String contrato;
        String sueldo;
        String movilidad;
        String tardanza;
        Nodo sig;
        public Nodo(String cod, String nom, String con, String suel, String mov, String tar){
            codigo = cod;
            nombre = nom;
            contrato = con;
            sueldo = suel;
            movilidad = mov;
            tardanza = tar;        }     }
    //Declaracion de variables locales
    public Nodo ini, fin;
    public Nodo pFound;
    int num = 0;
    
    void Encabezado(){
        txaReporte.setFont(new Font("monospaced", Font.PLAIN, 12));
        txaReporte.setText("");
        //Insertar encabezado;
        txaReporte.append("");
        txaReporte.append("    N°  CODIGO  NOMBRES Y APELLIDOS        SUELDOS   CONTRATO  MOVILIDAD  TARDANZA\n");
        txaReporte.append("-----------------------------------------------------------------------------------\n");
    }
    
 public EjercicioPropuesto() {
        initComponents();
        Deshabilitar();//inicia con botones deshabilitados
        this.setTitle("Registro de Empleados (G1- ED)");//titulos
        this.setResizable(false);//evita que se pueda agrandar la ventana 
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
    
    Nodo Buscar(Nodo inicio, String cod){
        Nodo pos = inicio;
        //recoddiendo la lista para encontrar la informacion
        while(pos != null && !cod.equalsIgnoreCase(pos.codigo))
            pos = pos.sig;
        return pos;
    }
    
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
        }
    }
    
    void VerDatos(){
        //Variable para recorrer la lista
        String cod, nom, s, cont, mov, tard;
        Nodo aux = ini;
        num = 0;
        //Colocando el Encabezado
        Encabezado();
        //Recorriendo la lista
        while(aux != null){
            cod = aux.codigo;
            nom = aux.nombre;
            s = aux.sueldo;
            cont= aux.contrato;
            mov= aux.movilidad;
            tard = aux.tardanza;
            num++;
            String numera = String.valueOf(num);
            //modificando el tamaño de la numeracion con espacios en blanco a la izquierda
            for(int i = String.valueOf(num).length(); i < 5; i++)
                numera = " " + numera;
            //modificando el tamaño de la cadena codigo con espacios en blanco a la derecha
            for(int i = cod.length(); i < 12; i++)
                cod = cod + " ";
            //modificando el tamaño de la cadena nombre con espacios en blanco a la derecha
            for(int i = nom.length(); i < 18; i++)
                nom = nom + " ";
            //le damos formato al sueldo solo con dos decimales
            DecimalFormat df2 = new DecimalFormat("####.00");
            s = df2.format(Double.valueOf(s));
            //modificando el tamaño de la cadena sueldo con espacios en blanco a la izquierda
            for(int i = s.length(); i < 12; i++)
                s = " " + s;
            //modificando el tamaño de la cadena sueldo con espacios en blanco a la izquierda
            for(int i = cont.length(); i < 9; i++)
                cont = " " + cont;
            //modificando el tamaño de la cadena sueldo con espacios en blanco a la izquierda
            for(int i = mov.length(); i < 9; i++)
                mov = " " + mov;
            //modificando el tamaño de la cadena sueldo con espacios en blanco a la izquierda
            for(int i = tard.length(); i < 9; i++)
                tard = " " + tard;
            //Colocando la informacion en el TextArea
            txaReporte.append(numera + "  " + cod + nom + s + cont + mov + tard +"\n");
            aux = aux.sig;
        }
    }
    
    void LimpiarEntradas(){
        txtCodigo.setText("");
        txtNombre.setText("");
        ComboBoxContrato.setSelectedIndex(0);
        txtSueldo.setText("");
        txtMovilidad.setText("");
        txtTardanza.setText("");
        txtCodigo.requestFocus();
    }
    
    void PreguntaA(){
        txaReporte.setText("");
        txaReporte.setFont(new Font("monospaced", Font.PLAIN, 12));
        txaReporte.append("");
        
        int cantidad = 0;
        int aux_tardanza;
        Nodo aux = ini;
        
        while(aux != null){
            aux_tardanza = Integer.parseInt(aux.tardanza);
            if(aux_tardanza > 15)
                cantidad++;
            aux = aux.sig;
        }
        
        txaReporte.append("El número de empleados con más de 15 minutos de tardanza es: " + cantidad + "\n");
    }    
    
    void PreguntaB(){
        int mayor = 0;
        String empleado = "";
        int aux_tardanza;
        Nodo aux = ini;
        
        while(aux != null){
            aux_tardanza = Integer.parseInt(aux.tardanza);
            if(aux_tardanza > mayor && aux.contrato.equals("Services")){
                mayor = aux_tardanza;
                empleado = aux.nombre;
            }
            aux = aux.sig;
        }
        
        txaReporte.append("El nombre del empleado con mayor tardanza y contrato Services: " + empleado + "\n");
    }

    void PreguntaC(){
        int mayor = 0;
        int aux_movilidad;
        Nodo aux = ini;
        
        while(aux != null){
            aux_movilidad = Integer.parseInt(aux.tardanza);
            if(aux_movilidad > mayor && aux.contrato.equals("A plazo fijo") && Integer.parseInt(aux.sueldo) < 1500){
                mayor = aux_movilidad;
            }
            aux = aux.sig;
        }
        
        txaReporte.append("Mayor movilidad de empleado a plazo fijo con sueldo menor a 1500: " + mayor + "\n");
    }
    
    Nodo InsertaInicio(Nodo inicio, String cod, String nom, String con, String suel, String mov, String tar){
        Nodo nuevo = new Nodo(cod, nom, con, suel, mov, tar);
        //realizando los elnlaces correspondientes
        nuevo.sig = inicio;
        inicio = nuevo;
        return inicio;
    }
    
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
        btnCalcular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxContrato = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtMovilidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTardanza = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

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

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setText("TIPO DE CONTRATO");

        ComboBoxContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A plazo fijo", "Servicios no personales", "Services" }));
        ComboBoxContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxContratoActionPerformed(evt);
            }
        });

        jLabel6.setText("MONTO MOVILIDAD");

        txtMovilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovilidadActionPerformed(evt);
            }
        });

        jLabel7.setText("TARDANDA (MIN)");

        txtTardanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTardanzaActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtCodigo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(29, 29, 29)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTardanza)
                                    .addComponent(txtMovilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBoxContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnConsultar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnCalcular))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMovilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTardanza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//guardo los datos de los inputs
        String cod = txtCodigo.getText();
        String nom = txtNombre.getText().toUpperCase();
        String con = (String)ComboBoxContrato.getSelectedItem();
        String suel = txtSueldo.getText();
        String mov = txtMovilidad.getText();
        String tar = txtTardanza.getText();
        //creo el nodo con los datos guardados
        ini = InsertaInicio(ini, cod, nom, con, suel, mov, tar);
        LimpiarEntradas();
        VerDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JOptionPane.showMessageDialog(this, "Saliendo");
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ComboBoxContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxContratoActionPerformed

    private void txtMovilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovilidadActionPerformed

    private void txtTardanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTardanzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTardanzaActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        PreguntaA();
        PreguntaB();
        PreguntaC();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        pFound.codigo = txtCodigo.getText();
        pFound.nombre = txtNombre.getText();
        pFound.contrato = (String)ComboBoxContrato.getSelectedItem();
        pFound.sueldo = txtSueldo.getText();
        pFound.movilidad = txtMovilidad.getText();
        pFound.tardanza = txtTardanza.getText();
        LimpiarEntradas();
        Deshabilitar();
        VerDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar(pFound);
        LimpiarEntradas();
        VerDatos();
        if(ini == null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        Deshabilitar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
         String cod = txtCodigo.getText();
        if(cod.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(this, "Usuario, por favor ingrese un código");
        else{
            //llamada a la funcion que retorna la posicion del datos buscado
            pFound = Buscar(ini, cod);
            //verificando el puntero pFound para mostrar la inf. buscada
            if(pFound != null){
                txtNombre.setText(pFound.nombre);
                ComboBoxContrato.setSelectedItem(pFound.contrato);
                txtSueldo.setText(pFound.sueldo);
                txtMovilidad.setText(pFound.movilidad);
                txtTardanza.setText(pFound.tardanza);
                //Habilitar para eliminar y actualizar
                Habilitar();
            }
            else
                JOptionPane.showMessageDialog(this, "El codigo: " + cod + ", no esta en la lista");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(EjercicioPropuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EjercicioPropuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EjercicioPropuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EjercicioPropuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EjercicioPropuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxContrato;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaReporte;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMovilidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTardanza;
    // End of variables declaration//GEN-END:variables
}
