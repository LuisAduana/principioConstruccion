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
    
    if(nombre.length() > 299) {
      validarNombre = false;
    }
    
    return validarNombre;
  }
  
  public void validarApellidoPaterno(String apellidoPatAlumno) throws ExcepcionPersonal {
    if(apellidoPatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Paterno del alumno");
    }
    
    if(apellidoPatAlumno.length() > 49){
      throw new ExcepcionPersonal("El Apellido Paterno del Alumno es demasiado grande");
    }
    
    if(apellidoPatAlumno.length() == 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos de solo 2 letras");
    }
  }
  
  public void validarApellidoMaterno(String apellidoMatAlumno) throws ExcepcionPersonal {
    if(apellidoMatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Materno del alumno");
    }
    
    if(apellidoMatAlumno.length() > 49){
      throw new ExcepcionPersonal("El Apellido Materno del Alumno es demasiado grande");
    }
    
    if(apellidoMatAlumno.length() == 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos de solo 2 letras");
    }
  }
  
  public void validarNombreAlumno(String nombreAlumno) throws ExcepcionPersonal {
    if(nombreAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Nombre del Alumno");
    }
    
    if(nombreAlumno.length() > 69){
      throw new ExcepcionPersonal("El nombre del Alumno es demasiado grande");
    }
    
    if(nombreAlumno.length() == 1) {
      throw new ExcepcionPersonal("No puede ingresar un nombre de solo 1 letra");
    }
  }
  
  public void validarMatricula(String matricula) throws ExcepcionPersonal {
    
    if(matricula.equals("")){
      throw new ExcepcionPersonal("Ingrese una matrícula");
    }
    
    if(matricula.length() < 9 || matricula.length() > 9){
      throw new ExcepcionPersonal("Matrícula no válida");
    }
    
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
