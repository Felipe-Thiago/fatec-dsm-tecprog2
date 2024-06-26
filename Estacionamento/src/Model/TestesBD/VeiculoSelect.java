/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TestesBD;

import Model.Estacionamento.TipoVeiculoEnum;
import Model.Estacionamento.Veiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alunos
 */
public class VeiculoSelect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "APP";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "SELECT * FROM VEICULO";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Veiculo veiculo = new Veiculo(rs.getString("placa"), rs.getString("nome"), TipoVeiculoEnum.valueOf(rs.getString("tipo")));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setNome(rs.getString("nome"));
            veiculo.setTipo(TipoVeiculoEnum.valueOf(rs.getString("tipo")));
            System.out.println("Placa: " + veiculo.getPlaca() + "; Nome: " + veiculo.getNome() + "; Tipo: " + veiculo.getTipo().toString());
        }
    }
}
