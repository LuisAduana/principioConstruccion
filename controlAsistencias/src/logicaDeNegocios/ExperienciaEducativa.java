package logicaDeNegocios;

/**
*
* @author BiiR4
*/
public class ExperienciaEducativa {
  private int idExperiencia;
  private String nombreExperiencia;
  private int nrc;
  
  public int getIdExperiencia(){
    return idExperiencia;
  }
  
  public String getNombreExperiencia(){
    return nombreExperiencia;
  }
  
  public int getNrc(){
    return nrc;
  }
  
  public void setIdExperiencia(int idExperiencia){
    this.idExperiencia = idExperiencia;
  }
  
  public void setNombreExperiencia(String nombreExperiencia){
    this.nombreExperiencia = nombreExperiencia;
  }
  
  public void setNrc(int nrc){
    this.nrc = nrc;
  }
}
