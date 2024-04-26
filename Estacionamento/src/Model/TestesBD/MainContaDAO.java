/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TestesBD;

import Model.DAO.ContaDAO;
import Model.Estacionamento.ContaVeiculo;

import Model.DAO.VeiculoDAO;
import Model.Estacionamento.TipoVeiculoEnum;
import Model.Estacionamento.Veiculo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class MainContaDAO {
    public static void main(String[] args) throws SQLException{
        
        ContaDAO contaDAO = new ContaDAO();
        List<ContaVeiculo> lista;
        contaDAO.alterar(contaDAO.);
        lista = contaDAO.listar();
        
        
             
        for(ContaVeiculo cl: lista){
            System.out.println(cl.getInicio(), cl.getVeiculo());
        }
        
    }
}
