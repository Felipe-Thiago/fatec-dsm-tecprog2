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
import calculahoras.*;


/**
 *
 * @author Alunos
 */
public class testeCalculaHoras {
    
    CalculaHoras calc = new CalculaHoras();
    
      
    //Método para calcular horas considerando 1 hora de almoço
    @Test
    public void calculaHorasTotais(){
    int horas = calc.retornaHoras(8, 17);
    
    
        System.out.println("1. Você trabalhou por " + horas + " horas hoje");
    }

    //Método para calcular horas com a diferença entre dias
    //Ex: trabalhou do dia 02 ao dia 05 das 05:00 às 14:00
    @Test
    public void calculaHorasEmDias(){
        int horasTotais = calc.retornaHorasDias(5, 14, 2, 5);
        
        System.out.println("2. Você trabalhou, ao todo, por " + horasTotais + " horas");
        
    }
        
    //Método para calcular horas considerando o dia da semana
    //Ex: trabalhou das 8 às 17 do dia 1 ao 30 "como o horário de sábado"
    @Test
    public void calculaHorasEmDiasComDiaSemana(){
        int horasTrabalhadas = calc.retornaHorasSemana(8, 17, 1, 30, "Sábado");
        System.out.println("3. Você receberá por " + horasTrabalhadas + " horas neste mês");
    }
    
    //Método para calcular horas com adicional noturno
    @Test
    public void calculaHorasEmDiasComDiaSemanaComNoturno(){
        int horasTrabalhadas = 
    }
}
