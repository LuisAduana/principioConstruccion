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
public class ConexionRegistros {
  
  public boolean registrarExperiencia(ExperienciaEducativa experiencia) {
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    PreparedStatement preStatement = null;
    connection = conexion.getConnection();
    String consulta = "INSERT INTO experienciaeducativa (idExperiencia, nombreExperiencia, nrc) "
              + "VALUES (?, ?, ?)";
    try {
      preStatement = connection.prepareStatement(consulta);
      preStatement.setInt(1, 0);
      preStatement.setString(2, experiencia.getNombreExperiencia());
      preStatement.setInt(3, experiencia.getNrc());
      preStatement.execute();
      exitoso = true;
      
    } catch (SQLException ex) {
      exitoso = false;
      Logger.getLogger(ConexionRegistros.class.getName()).log(Level.SEVERE, null, ex);
    }
    return exitoso;
  }

  public boolean modificarExperiencia(ExperienciaEducativa experiencia) {
    
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    String consulta = "UPDATE experienciaeducativa SET nombreExperiencia = ?, nrc = ? "
        + "WHERE idExperiencia = ?";
    
    try {
      PreparedStatement preStatement = connection.prepareStatement(consulta);
      preStatement.setString(1, experiencia.getNombreExperiencia());
      preStatement.setInt(2, experiencia.getNrc());
      preStatement.setInt(3, experiencia.getIdExperiencia());
      preStatement.executeUpdate();
      
      exitoso = true;
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      exitoso = false;
    }
    
    return exitoso;
  }
}
