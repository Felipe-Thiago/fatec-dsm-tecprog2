

import classes.CalculoHorista;
import classes.CalculoDiaria;
import classes.ContaEstacionamento;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class testeEstacionamento {
    
    
    
@Test
    public void calculoDiaria(){        
        Calendar inicio = Calendar.getInstance();
        inicio.set(2024, 3, 17);
        Calendar fim = Calendar.getInstance();
        fim.set(2024, 3, 18);
        
        ContaEstacionamento conta=new ContaEstacionamento(inicio.getTimeInMillis(), fim.getTimeInMillis(), "Corolla");
        CalculoDiaria tipo = new CalculoDiaria(50);
        
        conta.setCalculo(tipo);
        assertEquals(50,conta.valorConta(), 0);        
    }
    
    @Test
    public void calculoHorista(){        
        Calendar inicio = Calendar.getInstance();
        inicio.set(2024, 3, 17);
        Calendar fim = Calendar.getInstance();
        fim.set(2024, 3, 18);
        
        ContaEstacionamento conta=new ContaEstacionamento(inicio.getTimeInMillis(), fim.getTimeInMillis(), "Corolla");
        CalculoHorista tipo = new CalculoHorista(4);        
        conta.setCalculo(tipo);
        assertEquals(4*24,conta.valorConta(), 0);        
    }
    
}
