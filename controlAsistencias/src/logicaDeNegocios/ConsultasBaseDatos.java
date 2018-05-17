package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import java.util.ArrayList;

/**
*
* @author BiiR4
*/
public class ConsultasBaseDatos {
  Validadores validador = new Validadores();
  ConexionConsultas consulta = new ConexionConsultas();
  
  public String[][] obtenerMatrizAlumno(int nrc) {
    ArrayList<Alumno> listaAlumnos = consulta.buscarAlumnos(nrc);
    String matrizListas[][] = new String[listaAlumnos.size()][4];
    for(int i = 0; i < listaAlumnos.size(); i++) {
      matrizListas[i][0] = listaAlumnos.get(i).getNombeAlumno() + "";
      matrizListas[i][1] = listaAlumnos.get(i).getApePatAlumno()+ "";
      matrizListas[i][2] = listaAlumnos.get(i).getApeMatAlumno()+ "";
      matrizListas[i][3] = listaAlumnos.get(i).getAsistencia() + "";
    }
    return matrizListas;
  }
  
  public String[][] obtenerMatrizExperiencia() {
    ConexionConsultas consultarExperiencias = new ConexionConsultas();
    ArrayList<ExperienciaEducativa> listaExperiencias = 
        consultarExperiencias.buscarExperiencias();
    String matrizListas[][] = new String[listaExperiencias.size()][3];
    for(int i = 0; i < listaExperiencias.size(); i++){
      matrizListas[i][0] = listaExperiencias.get(i).getNombreExperiencia() + "";
      matrizListas[i][1] = listaExperiencias.get(i).getNrc() + "";
      matrizListas[i][2] = listaExperiencias.get(i).getNoClases() + "";
    }
    return matrizListas;
  }
  
  public ExperienciaEducativa consultarExperiencia(String nrc) {
    ConexionConsultas consultarExperiencia = new ConexionConsultas();
    
    return consultarExperiencia.buscarEsperiencia(nrc);
  }
  
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }  
}