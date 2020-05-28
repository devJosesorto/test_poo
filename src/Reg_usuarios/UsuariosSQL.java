
package Reg_usuarios;

public class UsuariosSQL {
    
   
    private String carnet;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String grado;
    private String seccion;
    private String especialidad;
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
   
    
     // SENTENCIAS PARA REGISTRO DE DOCENTES 
    
    
   public static String listar_D =  "SELECT * FROM docente";
   
   public static String registrar_D = "INSERT INTO docente("
           + "carnet,"
           + "nombres,"
           + "apellidos,"
           + "sexo,"
           + "especialidad)"
           + "VALUES(?,?,?,?,?)";
   
  public static String actualizar_D = "UPDATE docente SET "
          + "carnet = ?,"
           + "nombres = ?,"
           + "apellidos = ?,"
           + "sexo = ?,"
           + "especialidad = ?"
           + "WHERE id = ?";
  
  public static String eliminar_D = "DELETE FROM docente WHERE id = ? ";
            
  public static String eliminar_todo_D = "TRUNCATE TABLE docente";
    

  
  // SENTENCIAS PARA REGISTRO DE ESTUDIANTE 
  
  
   public static String listar_E =  "SELECT * FROM estudiante";
   
   public static String registrar_E = "INSERT INTO estudiante("
           + "carnet,"
           + "nombres,"
           + "apellidos,"
           + "sexo,"
           + "grado,"
           + "seccion)"
           + "VALUES(?,?,?,?,?,?)";
   
  public static String actualizar_E = "UPDATE estudiante SET "
          + "carnet = ?,"
           + "nombres = ?,"
           + "apellidos = ?,"
           + "sexo = ?,"
           + "grado = ?,"
           + "seccion = ?"
           + "WHERE id = ?";
  
  public static String eliminar_E = "DELETE FROM estudiante WHERE id = ? ";
            
  public static String eliminar_todo_E = "TRUNCATE TABLE estudiante";
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}// CIERRE
