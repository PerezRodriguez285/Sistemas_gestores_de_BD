/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JOEL2777
 */
public class CONEXION {
    
    private final String url= "jdbc:mysql://localhost/hospital";
    PreparedStatement ps;
    Connection con=null;
    //Método para realizar la conexión a la base de Datos
    
    public CONEXION(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            if (con!=null){
                System.out.println("Conexión exitosa");}
        }//fin del try
    catch(SQLException e){
        System.out.println(e);
    }// cerramos catch MySql
    catch(ClassNotFoundException e){
        System.out.println(e);
    }  //cerramos Catch Java
        
    }
    
    //Método para deconectar la Base de Datos
    public void desconectar(){
        con=null;
        System.out.println("La conexión se cerro exitosamente");
    }
    
    //Método para conocer el estado de la conexión
    public Connection conectado(){
        return con;
    }
    
}
