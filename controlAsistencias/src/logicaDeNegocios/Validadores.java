package logicaDeNegocios;

import conexionBaseDatos.ConexionRegistros;

/**
*
* @author BiiR4
*/
public class Validadores {
  
  ConexionRegistros conexion = new ConexionRegistros();
  public boolean validarRegistroExperiencia(ExperienciaEducativa experiencia) {
          
    boolean validarNombre = false;
    String nombre = experiencia.getNombreExperiencia();
    
    if(nombre != null && !nombre.equals("")) {
      validarNombre = true;
    }
    
    return validarNombre;
  }
  
  public Integer validarNrc(String nrc) {
    Integer nrcValidado;
    try {
      nrcValidado = Integer.parseInt(nrc);
    } catch (Exception exception) {
      nrcValidado = null;
    }
    return nrcValidado;
  }
  
}
