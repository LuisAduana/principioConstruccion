package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import java.util.ArrayList;

/**
*
* @author BiiR4
*/
public class ConsultasBaseDatos {
  Validadores validador = new Validadores();
  
  public String[][] obtenerMatriz() {
    ConexionConsultas consultarExperiencias = new ConexionConsultas();
    ArrayList<ExperienciaEducativa> listaExperiencias = 
        consultarExperiencias.buscarExperiencias();
    String matrizListas[][] = new String[listaExperiencias.size()][2];
    for(int i = 0; i < listaExperiencias.size(); i++){
      matrizListas[i][0] = listaExperiencias.get(i).getNombreExperiencia()+"";
      matrizListas[i][1] = listaExperiencias.get(i).getNrc()+"";
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
