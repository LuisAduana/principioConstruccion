package logicaDeNegocios;

/**
*
* @author BiiR4
*/
public class Alumno {
  private int idAlumno;
  private String nombreCompleto;
  private String nombreAlumno;
  private String apePatAlumno;
  private String apeMatAlumno;
  private String matricula;
  private boolean repite;
  private int asistencia;
  private int idExperiencia;
  
  public int getIdAlumno() {
    return idAlumno;
  }
  
  public void setIdAlumno(int idAlumno) {
    this.idAlumno = idAlumno;
  }
  
  public String getNombeAlumno() {
    return nombreAlumno;
  }
  
  public void setNombreAlumno(String nombreAlumno) {
    this.nombreAlumno = nombreAlumno;
  }
  
  public String getApePatAlumno() {
    return apePatAlumno;
  }
  
  public void setApePatAlumno(String apePatAlumno) {
    this.apePatAlumno = apePatAlumno;
  }
  
  public String getApeMatAlumno() {
    return apeMatAlumno;
  }
  
  public void setApeMatAlumno(String apeMatAlumno) {
    this.apeMatAlumno = apeMatAlumno;
  }
  
  public String getMatricula() {
    return matricula;
  }
  
  public void setMatricula(String matricula){
    this.matricula = matricula;
  }
  
  public boolean getRepite() {
    return repite;
  }
  
  public void setRepite(boolean repite) {
    this.repite = repite;
  }
  
  public int getAsistencia() {
    return asistencia;
  }
  
  public void setAsistencia(int asistencia) {
    this.asistencia = asistencia;
  }
  
  public int getIdExperiencia() {
    return idExperiencia;
  }
  
  public void setIdExperiencia(int idExperiencia) {
    this.idExperiencia = idExperiencia;
  }
  
  public String getNombreCompleto() {
    nombreCompleto = nombreAlumno + apePatAlumno + apeMatAlumno + "";
    return nombreCompleto;
  }
  
}
