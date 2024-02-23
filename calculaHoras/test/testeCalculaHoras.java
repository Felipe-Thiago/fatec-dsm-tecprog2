/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author Alunos
 */
public class testeCalculaHoras {
    public int entrada = 8;
    public int saida = 17;
    
    public int dataInicio = 01;
    public int dataFim = 30;
    
    public int retornaHoras(int entrada, int saida, int dataInicio, int dataFim){
        int horas = saida - entrada - 1;
        int dias = dataFim - dataInicio;
        int horasTotais = horas * dias;
        
        return horas;
        
    }
    
    public int retornaHorasTotais(int entrada, int saida, int dataInicio, int dataFim, String diaSemana){
        int horas = saida - entrada - 1;
        int dias = dataFim - dataInicio;
        int horasTotais = horas * dias;
        
        switch(diaSemana){
            case "Segunda":
            case "Terça":
            case "Quarta":
            case "Quinta":
            case "Sexta":
                if (entrada < 8){
                    int extra = horas + (8 - entrada)/2;
                    horasTotais = horasTotais + extra;
                }
                if (saida > 18){
                    int extra = horas + (saida - 18)/2;
                    horasTotais = horasTotais + extra;
                }
                return horasTotais;
                
                
            case "Sábado":
            case "Domingo":
                horasTotais = horasTotais + horasTotais/2;
                return horasTotais;
            default:
                return horasTotais;
        }
        
        
    }
      
    //Método para calcular horas considerando 1 hora de almoço
    @Test
    public void calculaHorasTotais(){
    int horas = saida - entrada - 1;
    
    
        System.out.println("Você trabalhou por " + horas + " horas hoje");
    }

    //Método para calcular horas com a diferença entre dias
    //Ex: trabalhou do dia 02 ao dia 05 das 05:00 às 14:00
    @Test
    public void calculaHorasEmDias(){
        int horas = saida - entrada - 1;
        
        int dias = dataFim - dataInicio;
        
        int horasTotais = horas * dias;
        
        System.out.println("Você trabalhou, ao todo, por " + horasTotais + " horas");
        
    }
    
    //Método para calcular horas considerando o dia da semana
    @Test
    public void calculaHorasEmDiasComDiaSemana(){
        int horasTrabalhadas = retornaHorasTotais(8, 17, 1, 30, "Sábado");
        System.out.println("Você receberá por " + horasTrabalhadas + " horas neste mês");
    }
}
