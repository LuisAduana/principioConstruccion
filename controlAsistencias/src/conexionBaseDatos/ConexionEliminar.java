package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaDeNegocios.ExperienciaEducativa;

/**
*
* @author BiiR4
*/
public class ConexionEliminar {
  public boolean eliminarExperienciaEducativa(String idNrc) {
    
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    int nrc = Integer.parseInt(idNrc);
    boolean exito;
    String sentencia =  "DELETE FROM experienciaeducativa WHERE nrc = ?";
    
    try {  
      PreparedStatement preStatement = connection.prepareStatement(sentencia);
      preStatement.setInt(1, nrc);
      
      preStatement.executeUpdate();
      exito = true;
      preStatement.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println(excepcion.getMessage());
      exito = false;
    }
    return exito;
  }
}
