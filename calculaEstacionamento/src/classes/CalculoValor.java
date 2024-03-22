/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Alunos
 */
interface CalculoValor{
    
    

    public static double calcular(long l, estacionamento.Veiculo veiculo){
        double HORA = 0;
        double periodo = 0;
        double valorDiaria = 0;
        return valorDiaria * Math.ceil(periodo / HORA);
    };
    
}
