/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Estacionamento.Conta;
import Model.Estacionamento.ContaVeiculo;
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
public class ContaDAO {
     private Connection connection;
    
    public ContaDAO(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
            String usuario = "APP";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
            
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ContaVeiculo> listar() throws SQLException{
        String sql = "SELECT * FROM conta";
        List<ContaVeiculo> retorno = new ArrayList<>();
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()){
                ContaVeiculo conta = new ContaVeiculo(conta.getInicio(), conta.getVeiculo()); //alterar aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
                conta.setId(resultado.getInt("id"));
                conta.setPlaca(resultado.getString("placa"));
                conta.setInicio(resultado.getInt("inicio"));
                conta.setFim(resultado.getInt("fim"));
                conta.setStatus(resultado.getString("status"));
                
                retorno.add(conta);
                
            }
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        
    }
    
    public boolean inserir(Conta conta){
        String sql = "INSERT INTO conta(id, placa, inicio, fim, status) VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            stmt.setString(2, conta.getPlaca());
            stmt.setInt(3, conta.getInicio());
            stmt.setInt(4, conta.getFim());
            stmt.setString(5, conta.getStatus());
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Conta conta){
        String sql = "UPDATE conta SET inicio=?, fim=?, status=? WHERE id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, conta.getInicio());
            stmt.setInt(2, conta.getFim());
            stmt.setString(3, conta.getStatus());
            stmt.setString(4, conta.)
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean remover(int id){
        String sql = "DELETE FROM conta where id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
