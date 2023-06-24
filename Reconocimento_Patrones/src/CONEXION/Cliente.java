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
 * @author JOEL2777
 */
public class Cliente extends javax.swing.JFrame {
    
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
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
    }
    
    private void limpiarCaja(){
        txtIdCliente.setText(null);
        txtNombre.setText(null);
        txtApellido1.setText(null);
        txtApellido2.setText(null);
        txtCiudad.setText(null);
        txtRegion.setText(null);
        txtPais.setText(null);
        txtGenero.setText(null);
        txtEdad.setText(null);
        txtEstadoCivil.setText(null);
        txtNacionalidad.setText(null);
        txtFechaNacimiento.setText(null);
        txtCantidadHijos.setText(null);
        txtOcupacion.setText(null);
        txtEscolaridad.setText(null);
        txtTrabajo.setText(null);
        txtObservaciones.setText(null);
        txtFirma.setText(null);
        
        
    }
    
    private void guardarDatos() throws SQLException{

       Connection con = null;
        try {
            con = getConection();

            ps = con.prepareStatement("insert into Cliente ( IdCliente, Nombre, Apellido1, Apellido2, Ciudad, Region, Pais, Genero, Edad, Estado_civil, Nacionalidad, Fecha_Nacimiento, Cantidad_hijos, Ocupacion, Escolaridad, Trabajo, Firma, Observaciones) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtApellido1.getText());
            ps.setString(4, txtApellido2.getText());
            ps.setString(5, txtCiudad.getText());
            ps.setString(6, txtRegion.getText());
            ps.setString(7, txtPais.getText());
            ps.setString(8, txtGenero.getText());
            ps.setInt(9, Integer.parseInt(txtEdad.getText()));
            ps.setString(10, txtEstadoCivil.getText());
            ps.setString(11, txtNacionalidad.getText());
            ps.setDate(12, Date.valueOf(txtFechaNacimiento.getText()));
            ps.setInt(13, Integer.parseInt(txtCantidadHijos.getText()));
            ps.setString(14, txtOcupacion.getText());
            ps.setString(15, txtEscolaridad.getText());
            ps.setString(16, txtTrabajo.getText());
            ps.setString(17, txtFirma.getText());
            ps.setString(18, txtObservaciones.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "El cliente se registro con éxito!");
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

            ps = con.prepareStatement("delete from Cliente where IdCliente = ?");
            ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
            int res = ps.executeUpdate();
            if (res > 0) {
              JOptionPane.showMessageDialog(null, "Se elimino el cliente con clave: "+txtIdCliente.getText() + " de forma exitosa!");
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

            ps = con.prepareStatement("select * from Cliente where IdCliente=?");
            ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));

           rs = ps.executeQuery();

            if (rs.next() ) {
              txtNombre.setText(rs.getString("Nombre"));
              txtApellido1.setText(rs.getString("Apellido Paterno"));
              txtApellido2.setText(rs.getString("Apellido Materno"));
              txtCiudad.setText(rs.getString("Ciudad"));
              txtRegion.setText(rs.getString("Region"));
              txtPais.setText(rs.getString("Pais"));
              txtGenero.setText(rs.getString("Genero"));
              txtEdad.setText(Integer.toString(rs.getInt("Edad")));
              txtEstadoCivil.setText(rs.getString("Estado Civil"));
              txtNacionalidad.setText(rs.getString("Nacionalidad"));
              txtFechaNacimiento.setText(rs.getDate("Fecha de Nacimiento").toString());
              txtCantidadHijos.setText(Integer.toString(rs.getInt("Cantidad de Hijos")));
              txtOcupacion.setText(rs.getString("Ocupacion"));
              txtEscolaridad.setText(rs.getString("Escolaridad"));
              txtTrabajo.setText(rs.getString("Trabajo"));
              txtFirma.setText(rs.getString("Firma"));
              txtObservaciones.setText(rs.getString("Observaciones"));
              

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
            ps = con.prepareStatement("update Cliente set Nombre=?, Apellido1=?, Apellido2=?, Ciudad=?, Region=?, Pais=?, Genero=?, Edad=?, Estado_civil=?, Nacionalidad=?, Fecha_Nacimiento=?, Cantidad_hijos=?, Ocupacion=?, Escolaridad=?, Trabajo=?, Firma=?, Observaciones=? WHERE IdCliente=?");
            ps.setInt(18, Integer.parseInt(txtIdCliente.getText()));
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtApellido1.getText());
            ps.setString(3, txtApellido2.getText());
            ps.setString(4, txtCiudad.getText());
            ps.setString(5, txtRegion.getText());
            ps.setString(6, txtPais.getText());
            ps.setString(7, txtGenero.getText());
            ps.setInt(8, Integer.parseInt(txtEdad.getText()));
            ps.setString(9, txtEstadoCivil.getText());
            ps.setString(10, txtNacionalidad.getText());
            ps.setDate(11, Date.valueOf(txtFechaNacimiento.getText()));
            ps.setInt(12, Integer.parseInt(txtCantidadHijos.getText()));
            ps.setString(13, txtOcupacion.getText());
            ps.setString(14, txtEscolaridad.getText());
            ps.setString(15, txtTrabajo.getText());
            ps.setString(16, txtFirma.getText());
            ps.setString(17, txtObservaciones.getText());
            int res = ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Cliente modificado"); 
                limpiarCaja();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Modificar Cliente");
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

        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtCantidadHijos = new javax.swing.JTextField();
        txtOcupacion = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtEscolaridad = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTrabajo = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        txtRegion = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        txtFirma = new javax.swing.JTextField();
        btSeleccionar = new javax.swing.JButton();
        lbFirma = new javax.swing.JLabel();

        jTextField7.setText("jTextField7");

        jTextField10.setText("jTextField10");

        jTextField15.setText("jTextField15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Cliente: ");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido Paterno: ");

        jLabel4.setText("Ciudad:");

        jLabel5.setText("Nacionalidad: ");

        jLabel6.setText("Estado Civil: ");

        jLabel7.setText("Observaciones: ");

        jLabel8.setText("Pais:");

        jLabel9.setText("Region: ");

        jLabel10.setText("Trabajo:");

        jLabel11.setText("Apellido Materno: ");

        jLabel12.setText("Escolaridad:");

        jLabel13.setText("Fecha de Nacimiento:");

        jLabel14.setText("Ocupacion: ");

        jLabel15.setText("Cantidad de hijos: ");

        jLabel16.setText("Genero:");

        jLabel17.setText("Edad:");

        jLabel18.setText("Firma:");

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

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btSeleccionar.setText("Seleccionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btLimpiar)
                                .addGap(36, 36, 36)
                                .addComponent(btActualizar)
                                .addGap(26, 26, 26)
                                .addComponent(btBuscar)
                                .addGap(33, 33, 33)
                                .addComponent(btEliminar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(88, 88, 88)
                                            .addComponent(txtCantidadHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEscolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btSeleccionar)))))
                        .addGap(0, 53, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9)
                        .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCantidadHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtEscolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btLimpiar)
                    .addComponent(btActualizar)
                    .addComponent(btBuscar)
                    .addComponent(btEliminar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        try {
            guardarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btGuardarActionPerformed

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

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        buscarDatos();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCaja();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        // TODO add your handling code here:
        try {
        actualizarDatos();
    } catch (SQLException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbFirma;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCantidadHijos;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEscolaridad;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFirma;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtOcupacion;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtRegion;
    private javax.swing.JTextField txtTrabajo;
    // End of variables declaration//GEN-END:variables
}
