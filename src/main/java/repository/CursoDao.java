package repository;

import java.util.ArrayList;
import java.util.List;
import models.Curso;

public class CursoDao {
    
    private List<Curso> cursos;
    
    public CursoDao() {
        cursos = new ArrayList<>();
        
        Curso cursoOne = new Curso("C001", "Patrones de Diseño", 4);
        Curso cursoTwo = new Curso("C002", "Programación Paralela", 4); 
        Curso cursoThree = new Curso("C003", "Integración de Sistemas", 4);  
        
        this.cursos.add(cursoOne);
        this.cursos.add(cursoTwo);
        this.cursos.add(cursoThree);
    }

    public List<Curso> listar() {
        return this.cursos;
    }
    
    public Curso encontrar(Curso curso) {
        Curso response = new Curso();
        for (Curso c: this.cursos) {
            if(curso.getCodigo().equals(c.getCodigo())) {
                response = curso; 
            }
        }
        return response;
    }
    
    public int insertar(Curso curso) {
        this.cursos.add(curso);
        return 1;
    }
    
    public int actualizar(Curso curso) {
        Curso response = curso;
        
        for(Curso c: this.cursos) {
            if(c.getCodigo().equals(curso.getCodigo())) {
                this.cursos.remove(c);
            }
        }
        this.cursos.add(response);
        return 1;
    }
    
    public int eliminar (Curso curso) {
        this.cursos.remove(curso);
        return 1;
    }
}
