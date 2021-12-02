package test;

import capa_datos.ClienteDaoJdbc;
import dominio.Cliente;
import java.util.List;

public class test {

    public static void main(String[] args) {
        //Cliente cliente = new Cliente("Pablo", "Escobar", "pablo.escobar@gmail.com", "938817345", 350);
        List<Cliente> clientes=new ClienteDaoJdbc().listar();
        for (Cliente c: clientes)
            System.out.println(c);
        System.out.println("hola mundo");
        //int fila = new ClienteDaoJdbc().insertar(cliente);
    }
}
