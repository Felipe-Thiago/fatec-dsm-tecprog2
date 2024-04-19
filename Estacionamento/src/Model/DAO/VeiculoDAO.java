/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Estacionamento.ContaVeiculo;
import Model.Estacionamento.TipoVeiculoEnum;
import Model.Estacionamento.Veiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class VeiculoDAO {
    
    private Connection connection;
    
    public VeiculoDAO(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
            String usuario = "APP";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
            
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Veiculo> listar() throws SQLException{
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> retorno = new ArrayList<>();
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()){
                Veiculo veiculo = new Veiculo(resultado.getString("placa"), resultado.getString("nome"), TipoVeiculoEnum.valueOf(resultado.getString("tipo")));
             /*   veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setNome(resultado.getString("nome"));
                veiculo.setTipo(TipoVeiculoEnum.valueOf(resultado.getString("tipo"))); */
                retorno.add(veiculo);
                
            }
        } catch(SQLException ex){
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        
    }
    
    public boolean inserir(Veiculo veiculo){
        String sql = "INSERT INTO veiculo(placa, nome, tipo) VALUES(?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getNome());
            stmt.setString(3, veiculo.getTipo().toString());
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Veiculo veiculo){
        String sql = "UPDATE veiculo SET nome=?, tipo=? WHERE placa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getTipo().toString());
            stmt.setString(3, veiculo.getPlaca());
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean remover(String placa){
        String sql = "DELETE FROM veiculo where placa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
