/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;


import Model.Estacionamento.ContaVeiculo;
import Model.Estacionamento.StatusConta;
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
                conta.setInicio(resultado.getInt((int) conta.getInicio()));
                conta.getVeiculo().setPlaca(resultado.getString("placa"));
                conta.setFim(resultado.getInt());
                conta.setStatus(StatusConta.valueOf(resultado.getString("status")));
                
                
                retorno.add(conta);
                
            }
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        
    }
    
    public boolean inserir(ContaVeiculo conta){
        String sql = "INSERT INTO conta(fim, status) VALUES(?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, (int) conta.getFim());
            stmt.setString(2, conta.getStatus().toString());
            
           
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(ContaVeiculo conta){
        String sql = "UPDATE conta SET fim=?, status=? WHERE placa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, (int) conta.getInicio());
            stmt.setString(2, conta.getStatus().toString());
            stmt.setString(3, conta.getVeiculo().getPlaca().toString());
            
            stmt.setString(4, conta.getVeiculo().getPlaca());
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean remover(String placa){
        String sql = "DELETE FROM conta where placa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.execute();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
