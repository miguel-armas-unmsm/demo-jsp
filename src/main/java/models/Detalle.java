package models;

public class Detalle {
    
    private String codigo;

    private String nombreCurso;

    private Integer nota;

    public Detalle(String codigo, String nombreCurso, Integer nota) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.nota = nota;
    }

    public Detalle() {
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Integer getNota() {
        return nota;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    
    
    @Override
    public String toString() {
        return "Detalle{" + "codigo=" + codigo + ", nombreCurso=" + nombreCurso + ", nota=" + nota + '}';
    }

}
