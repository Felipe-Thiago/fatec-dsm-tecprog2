
package jdbc.exemplos.java;

import java.util.List;
import Model.ClienteDAO.ClienteDAO;
import Model.Classes.Cliente;

public class MainClienteDAO {
    
    public static void main(String[] args){
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> lista;
        clienteDAO.inserir(new Cliente("Rodrigo", "322.223.455-43", "95966-1234"));
                
        lista= clienteDAO.listar();
        
        for(Cliente cl: lista){
            System.out.println(cl.toString());
        }
        
    }
}
