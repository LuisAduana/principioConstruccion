package logicaDeNegocios;

/**
*
* @author BiiR4
*/
public class ExcepcionPersonal extends Exception{
  
  public static final long serialVersionUID = 700L;
  
  public ExcepcionPersonal(String mensaje) {
    super(mensaje);
  }
  
}
