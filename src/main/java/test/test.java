package test;

import repository.AlumnoDao;
import models.Alumno;
import java.util.List;

public class test {

    public static void main(String[] args) {
        //Cliente cliente = new Cliente("Pablo", "Escobar", "pablo.escobar@gmail.com", "938817345", 350);
        List<Alumno> clientes=new AlumnoDao().listar();
        for (Alumno c: clientes)
            System.out.println(c);
        System.out.println("hola mundo");
        //int fila = new ClienteDaoJdbc().insertar(cliente);
    }
}
