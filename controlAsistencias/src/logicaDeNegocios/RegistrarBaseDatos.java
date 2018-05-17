package logicaDeNegocios;

import conexionBaseDatos.ConexionRegistros;
import javax.swing.JOptionPane;

/**
*
* @author BiiR4
*/
public class RegistrarBaseDatos {
  ConexionRegistros registro = new ConexionRegistros();
  Validadores validador = new Validadores();
  
  public void modificarExperiencia(ExperienciaEducativa experiencia, int nrcEntero) {
    boolean exitoso = registro.modificarExperiencia(experiencia, nrcEntero);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSA");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN MODIFICAR");
    }
  }
  
  public void registrarExperiencia(ExperienciaEducativa experiencia) {
    boolean exitoso = registro.registrarExperiencia(experiencia);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
    }
  }
  
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }
  
  public Integer enviarNoClases(String noClases) {
    Integer noClasesValidado = validador.validarNoClases(noClases);
    return noClasesValidado;
  }
}
