package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicaDeNegocios.Alumno;
import logicaDeNegocios.ExperienciaEducativa;

/**
*
* @author BiiR4
*/
public class ConexionConsultas {
  
  public ArrayList<Alumno> buscarAlumnos(int nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT nombreAlumno, apeAlumnoPat, "
          + "apeAlumnoMat, asistencia FROM alumno WHERE nrc = " + nrc +"");
      while(resultado.next()) {
        alumno = new Alumno();
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        alumno.setAsistencia(resultado.getInt("asistencia"));
        listaAlumnos.add(alumno);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      System.out.println(excepcion.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar alumnos", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaAlumnos;
  }
  
  public ArrayList<ExperienciaEducativa> buscarExperiencias(){
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<ExperienciaEducativa> listaExperiencias = new ArrayList<ExperienciaEducativa>();
    ExperienciaEducativa experiencia;

    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = 
          estatuto.executeQuery("SELECT nrc, nombreExperiencia FROM experienciaeducativa");
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
        experiencia.setNrc(resultado.getInt("nrc"));
        experiencia.setNombreExperiencia(resultado.getString("nombreExperiencia"));
      }
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
            
    return experiencia;
  }
}
  
