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
  
  public void registrarExperiencia(ExperienciaEducativa experiencia) {
    if(validador.validarRegistroExperiencia(experiencia)) {
      boolean exitoso = registro.registrarExperiencia(experiencia);
      if(exitoso){
        JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
      } else {
        JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
      }
    } else {
      JOptionPane.showMessageDialog(null, "CAMPOS INVÁLIDOS", "Error",JOptionPane.WARNING_MESSAGE);
    }
  }
  
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }
}
