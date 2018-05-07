package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicaDeNegocios.ExperienciaEducativa;

/**
*
* @author BiiR4
*/
public class ConexionConsultas {
  
  public ArrayList<ExperienciaEducativa> buscarExperiencias(){
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<ExperienciaEducativa> listaExperiencias = new ArrayList<ExperienciaEducativa>();
    ExperienciaEducativa experiencia;

    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = 
          estatuto.executeQuery("SELECT nombreExperiencia, nrc FROM experienciaeducativa");
      while(resultado.next()) {
        experiencia = new ExperienciaEducativa();
        experiencia.setNombreExperiencia(resultado.getString("nombreExperiencia"));
        experiencia.setNrc(Integer.parseInt(resultado.getString("nrc")));
        listaExperiencias.add(experiencia);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaExperiencias;
  }

  public ExperienciaEducativa buscarEsperiencia(String nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ExperienciaEducativa experiencia = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM experienciaeducativa WHERE nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, nrc);
      resultado = statement.executeQuery();
      
      while(resultado.next() == true) {
        experiencia = new ExperienciaEducativa();
        experiencia.setIdExperiencia(resultado.getInt("idExperiencia"));
        experiencia.setNrc(resultado.getInt("nrc"));
        experiencia.setNombreExperiencia(resultado.getString("nombreExperiencia"));
      }
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
            
    return experiencia;
  }
}
  
