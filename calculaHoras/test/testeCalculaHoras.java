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
    public CalculaHoras1 calc;
    @Before
    public void InicializarCalc(){
        calc = new CalculaHoras1();
    }
    
    
    @Test
    public void calculaHTPeriodoNormal(){        
        //Entra as 08:00 sai as 12:00 = 4 horas        
        assertEquals(4, calc.retornaHoras(8,12), 0);
        //Entra as 13:00 sai as 18:00 = 5 horas        
        assertEquals(5, calc.retornaHoras(13,18), 0);
        //Entra as 08:00 sai as 18:00 = 10 horas + 1,5 almoço = 11,5      
        assertEquals(11.5, calc.retornaHoras(8,18), 0);
    }
    @Test
    public void calculaHTPeridoExtra50(){
        assertEquals(5.5, calc.retornaHoras(14,19), 0);
        //Entra as 13:00 sai as 18:00 = 5 horas        
        assertEquals(7.0, calc.retornaHoras(06,12), 0);
        //Entra as 08:00 sai as 18:00 = 10 horas + 1,5 almoço = 11,5      
        assertEquals(9.5, calc.retornaHoras(6,13), 0);        
    }
    @Test
    public void calculaHTPeridoExtra100(){
        assertEquals(9.0f, calc.retornaHoras(17.0f,23.0f), 0);
        assertEquals(17.5f, calc.retornaHoras(0.0f,9.0f), 0);
        assertEquals(8.0f, calc.retornaHoras(22.00f,02.00f), 0);  
        assertEquals(19.5f, calc.retornaHoras(14.00f,02.00f), 0); 
    }
}
