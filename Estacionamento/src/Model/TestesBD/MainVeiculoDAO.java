/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TestesBD;

import java.util.List;
import Model.DAO.VeiculoDAO;
import Model.Estacionamento.TipoVeiculoEnum;
import Model.Estacionamento.Veiculo;
import java.sql.SQLException;

/**
 *
 * @author Alunos
 */
public class MainVeiculoDAO {
    public static void main(String[] args) throws SQLException{
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> lista;
        veiculoDAO.alterar(new Veiculo("golzinho", "abc1234", TipoVeiculoEnum.CARRO_PASSEIO));
                
        lista= veiculoDAO.listar();
        
        for(Veiculo vl: lista){
            System.out.println(vl.toString());
        }
        
    }
}
