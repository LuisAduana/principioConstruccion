package logicaDeNegocios;

import conexionBaseDatos.ConexionEliminar;

/**
*
* @author BiiR4
*/
public class EliminacionBaseDatos {
  public boolean eliminarExperiencia(String idNrc){
    ConexionEliminar eliminar = new ConexionEliminar();
    boolean exito;
    
    if(eliminar.eliminarExperienciaEducativa(idNrc)) {
      exito = true;
    } else {
      exito = false;
    }
    
    return exito;
  }
}
