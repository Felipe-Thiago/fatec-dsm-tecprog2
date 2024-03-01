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
    public CalculaHoras calc;
    @Before
    public void InicializarCalc(){
        calc = new CalculaHoras();
    }
    
    
      
    //Método para calcular horas abaixo de 6 por dia
    @Test
    public void calculaHorasNormais(){
    double horas = calc.retornaHoras(13, 18);
    assertEquals(5, horas, 0);
    
    
        System.out.println("1. Você será pago por " + horas + " horas hoje");
    }

    //Método para calcular horas acima de 6
    @Test
    public void calculaHorasComExtras(){
        double horasTotais = calc.retornaHoras(8, 18);
        assertEquals(11.5, horasTotais, 0);
        
        System.out.println("2. Você será pago, ao todo, por " + horasTotais + " horas");
        
    }
        

    //Método para calcular horas com adicional noturno
    @Test
    public void calculaHorasComExtraMaiorQue18(){
        double horasTrabalhadas = calc.retornaHoras(14, 19);
        assertEquals(5.5, horasTrabalhadas, 0);
        System.out.println("4. Você receberá por " + horasTrabalhadas + " horas");
    }
    
    @Test
    public void calculaHorasComExtraMenorQue8(){
        double horasTrabalhadas = calc.retornaHoras(6, 13);
        assertEquals(9.5, horasTrabalhadas, 0);
        System.out.println("5.Você receberá por " + horasTrabalhadas + " horas");
    }
    
    @Test
    public void calculaHorasComNoturno(){
        double horasTrabalhadas = calc.retornaHoras(0, 9);
        assertEquals(17.5, horasTrabalhadas, 0);
        System.out.println("7.Você receberá por " + horasTrabalhadas + " horas");
    }
    
    @Test
    public void calculaHorasEntreDias(){
        double horasTrabalhadas = calc.retornaHoras(14, 2);
        assertEquals(19.5, horasTrabalhadas, 0);
        System.out.println("9. Você receberá por " + horasTrabalhadas + " horas");
    }
}
