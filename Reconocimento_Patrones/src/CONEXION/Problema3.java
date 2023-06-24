/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Integrantes:

-Antonio Alberto De La Luz Pérez Rodríguez 
-Joel Ramírez Martínez 
-Luis Fernando Sámano Rivera

*/

package CONEXION;
import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto
 */
public class Problema3 extends javax.swing.JFrame {
    
    public static final String URL = "jdbc:mysql://localhost:3306/Reconocimiento_Patrones";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection(){
    Connection con = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (Exception e) {
        System.out.println(e);
    }

    return con;
    }


    /**
     * Creates new form Problema3
     */
    public Problema3() {
        initComponents();
    }
    
    private void limpiarCaja(){
        txtIdOrden.setText(null);
        txtIdCliente.setText(null);
        txtRespuesta1.setText(null);
        txtRespuesta2.setText(null);
        txtRespuesta3.setText(null);
        txtFirma.setText(null);
        
    }
    
    private void guardarDatos() throws SQLException{

       Connection con = null;
        try {
            con = getConection();

            ps = con.prepareStatement("insert into Problema3 ( IdOrden, IdCliente, Respuesta1, Respuesta2, Respuesta3, Firma) values ( ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(txtIdOrden.getText()));
            ps.setInt(2, Integer.parseInt(txtIdCliente.getText()));
            ps.setString(3, txtRespuesta1.getText());
            ps.setString(4, txtRespuesta2.getText());
            ps.setString(5, txtRespuesta3.getText());
            ps.setString(6, txtFirma.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "El Ploblema3 se registro con éxito!");
                limpiarCaja();
            }else{
               JOptionPane.showMessageDialog(null, "Hubo un error al guardar!");

            }

            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }


    }
    
    public void eliminarDatos(){
        Connection con = null;
        try {
            con = getConection();

            ps = con.prepareStatement("delete from Problema3 where IdOrden = ?");
            ps.setInt(1, Integer.parseInt(txtIdOrden.getText()));
            int res = ps.executeUpdate();
            if (res > 0) {
              JOptionPane.showMessageDialog(null, "Se elimino La orden con clave: "+txtIdOrden.getText() + " de forma exitosa!");
              limpiarCaja();
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar!");
            }

            con.close();

        } catch (Exception e) {
        }
    }
    
    public void buscarDatos(){
         Connection con = null;
        try {
            con = getConection();

            ps = con.prepareStatement("select * from Ploblema3 where IdOrden=?");
            ps.setInt(1, Integer.parseInt(txtIdOrden.getText()));

           rs = ps.executeQuery();

            if (rs.next() ) {
              txtIdCliente.setText(Integer.toString(rs.getInt("IdCliente")));
              txtRespuesta1.setText(rs.getString("Respuesta 1"));
              txtRespuesta2.setText(rs.getString("Respuesta 2"));
              txtRespuesta3.setText(rs.getString("Respuesta 3"));
              txtFirma.setText(rs.getString("Firma"));
              

            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al buscar!");
            }

            con.close();

        } catch (Exception e) {
        }
    }

    public void actualizarDatos() throws SQLException{
        Connection con = null;
        try{
            con = getConection();
            ps = con.prepareStatement("update Orden set IdCliente=?, Respuesta1=?, Respuesta2=?, Respuesta3=?, Firma=? WHERE IdOrden=?");
            ps.setInt(4, Integer.parseInt(txtIdOrden.getText()));
            ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
            ps.setString(2, txtRespuesta1.getText());
            ps.setString(3, txtRespuesta2.getText());
            ps.setString(4, txtRespuesta3.getText());
            ps.setString(3, txtFirma.getText());
            int res = ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Ploblema3 modificado"); 
                limpiarCaja();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Modificar Problema3");
                limpiarCaja();
            }
        con.close();
        }

        catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdOrden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtRespuesta1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtRespuesta2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtRespuesta3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        txtFirma = new javax.swing.JTextField();
        btSeleccionar = new javax.swing.JButton();
        lbFirma = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Cliente: ");

        jLabel2.setText("Id Orden: ");

        jLabel3.setText("Problema 1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Escriba el abecedario español con letras minúsculas (SIN LOS GUIONES)\na-b-c-d-e-f-g-h-i-j-k-l-m-n-ñ-o-p-q-r-s-t-u-v-w-x-y-z");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Respuesta 1:");

        jLabel5.setText("Problema 2:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Escriba los caracteres siguientes (SIN LOS GUIONES)\nA-B-C-D-E-F-G-H-I-J-K-L-M-N-Ñ-O-P-Q-R-S-T-U-V-W-X-Y-Z 0-1-2-3-4-5-6-7-8-9");
        jScrollPane2.setViewportView(jTextArea2);

        jLabel6.setText("Respuesta 2:");

        jLabel7.setText("Problema 3:");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Escriba RÁPIDAMENTE el siguiente texto, pero que continúe legible\n");
        jScrollPane3.setViewportView(jTextArea3);

        jLabel8.setText("Respuesta 3:");

        jLabel9.setText("ESTOY DE ACUERDO CON QUE SE INCORPOREN MIS TEXTOS MANUSCRITOS Y MIS FIRMAS A UNA BASE DE DATOS CON FINES DE INVESTIGACIÓN CIENTÍFICA");

        lb.setText("Firma:");

        btSeleccionar.setText("Seleccionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });

        jLabel10.setText("¡LE AGRADECEMOS MUCHO SU COLABORACIÓN…! Laboratorio de Reconocimiento de Patrones del CIC-IPN");

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btActualizar.setText("Actualizar");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRespuesta3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtRespuesta1)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel1)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(27, 27, 27)
                                                            .addComponent(jLabel2)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtIdOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addComponent(jLabel5))
                                                .addComponent(jLabel6)
                                                .addComponent(txtRespuesta2))
                                            .addComponent(jLabel7)))
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btSeleccionar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lbFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btGuardar)
                        .addGap(28, 28, 28)
                        .addComponent(btLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btActualizar)
                        .addGap(27, 27, 27)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEliminar)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb)
                    .addComponent(txtFirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btLimpiar)
                    .addComponent(btActualizar)
                    .addComponent(btEliminar)
                    .addComponent(btBuscar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccionarActionPerformed
        // TODO add your handling code here:
        JFileChooser archivo=new JFileChooser();
        int ventana=archivo.showOpenDialog(null);
        if(ventana == JFileChooser.APPROVE_OPTION){
            File[] file= archivo.getSelectedFiles();
            txtFirma.setText(String.valueOf(file));
            Image firma=getToolkit().getImage(txtFirma.getText());
            firma=firma.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            lbFirma.setIcon(new ImageIcon(firma));
                    
        }
    }//GEN-LAST:event_btSeleccionarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        try {
            guardarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCaja();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        // TODO add your handling code here:
        try {
        actualizarDatos();
    } catch (SQLException ex) {
        Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        buscarDatos();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
        eliminarDatos();
    }//GEN-LAST:event_btEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Problema3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Problema3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Problema3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Problema3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Problema3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbFirma;
    private javax.swing.JTextField txtFirma;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdOrden;
    private javax.swing.JTextField txtRespuesta1;
    private javax.swing.JTextField txtRespuesta2;
    private javax.swing.JTextField txtRespuesta3;
    // End of variables declaration//GEN-END:variables
}
