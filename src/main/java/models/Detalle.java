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

    @Override
    public String toString() {
        return "Detalle{" + "codigo=" + codigo + ", nombreCurso=" + nombreCurso + ", nota=" + nota + '}';
    }

}
