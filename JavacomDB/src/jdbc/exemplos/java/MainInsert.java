package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Classes.Cliente;

public class MainInsert {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "APP";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "INSERT INTO CLIENTES (nome, cpf, telefone) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        Cliente cliente = new Cliente("PEDRO GOMES", "445.555.777-34", "(44) 4444-4444");
        
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getTelefone());
        ps.execute();
    }
}
