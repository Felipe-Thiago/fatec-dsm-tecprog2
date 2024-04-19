package Model.TestesBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alunos
 */
public class VeiculoDelete {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "APP";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "DELETE FROM VEICULO WHERE PLACA='abc1234'";
        PreparedStatement ps = connection.prepareStatement(sql);
                
        ps.execute();
    }
}
