package logicaDeNegocios;

/**
*
* @author BiiR4
*/
public class ExperienciaEducativa {
  private String nombreExperiencia;
  private int nrc;
  private int noClases;
  
  public String getNombreExperiencia(){
    return nombreExperiencia;
  }
  
  public int getNrc(){
    return nrc;
  }
  
  public void setNombreExperiencia(String nombreExperiencia){
    this.nombreExperiencia = nombreExperiencia;
  }
  
  public void setNrc(int nrc){
    this.nrc = nrc;
  }
  
  public void setNoClases(int noClases) {
    this.noClases = noClases;
  }
  
  public int getNoClases() {
    return noClases;
  }
}
