package logicaDeNegocios;

import conexionBaseDatos.ConexionRegistros;

/**
*
* @author BiiR4
*/
class Validadores {
  
  ConexionRegistros conexion = new ConexionRegistros();
  boolean validarRegistroExperiencia(ExperienciaEducativa experiencia){
    boolean validarNombre = false;
    boolean validarNrc = true;
    String nombre = experiencia.getNombreExperiencia();
    int nrc = experiencia.getNrc();
    
    if(nombre != null && !nombre.equals("")) {
      validarNombre = true;
    }
    // if(nrc != null && !nrc.equals("")) {
      //validarNrc = true;
    //}
    
    if(validarNombre) {
      return true;
    } else {    
      return false;
    }
  }
  
  public Integer validarNrc(String nrc) {
    Integer nrcValidado = null;
    try {
      nrcValidado = Integer.parseInt(nrc);
    } catch (Exception exception) {
      nrcValidado = null;
    }
    return nrcValidado;
  }
  
}
