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
public class ContaEstacionamento {

        private estacionamento.Veiculo veiculo;
        private long inicio, fim;
        private CalculoValor calculo;

        public ContaEstacionamento(long inicio, long fim, String veiculo) {
            
            
        }

        public void setCalculo(CalculoValor calculo) { //calculo = tipo
            this.calculo = calculo;
        }

        public double valorConta() {
            return CalculoValor.calcular(fim - inicio, veiculo);
        }

    }
