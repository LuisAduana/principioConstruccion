package conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author BiiR4
*/

public class ConexionBaseDatos {
  private static final String USERNAME = "root";
  private static final String PASSWORD = "1234";
  private static final String CONN_STRING = 
      "jdbc:mysql://localhost:3306/controlasistencia?autoReconnect=true&useSSL=false";
  Connection conn = null;
  
  public ConexionBaseDatos() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
      //System.out.println("Conectado!");
      if(conn != null){
        System.out.println("Conexion exitosa  a la BD controlasistencia!");
      }
    } catch (ClassNotFoundException excepcion){
      System.out.println("ocurre una ClassNotFoundException: " + excepcion.getMessage());
    } catch (SQLException excepcion) {
      System.out.println("ocurre una SQLException: " + excepcion.getMessage());
    }
  }
  
  public Connection getConnection(){
    return conn;
  }
  
  void desconectar(){
    conn = null;
  }
}