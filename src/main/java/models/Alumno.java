package models;

public class Alumno {
    
    private String codAlumno;
    private String nombre;
    private String apellido;
    
    public Alumno(){}

    public Alumno(String codigo) {
        this.codAlumno = codigo;
    }

    public Alumno(String nombre, String apellido) {        
        this.nombre = nombre;
        this.apellido = apellido;
    }    

    public Alumno(String codigo, String nombre, String apellido) {
        this.codAlumno = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codAlumno + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
}
