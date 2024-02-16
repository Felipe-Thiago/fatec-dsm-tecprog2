
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePilha {
    
    //Método para empilhar um elemento na Pilha
    //A pilha irá trabalhar com Object
    
    @Test
    public void empilharUmObjeto(){
    
        Pilha p = new Pilha();
        
        assertTrue(p.vazia());
        p.empilha("Elemento 1");
        assertFalse(p.vazia());
    }
    
    @Test
    public void empilharDoisObjetosDesempilhaUm(){
    
        Pilha p = new Pilha();
        
        assertTrue(p.vazia());
        p.empilha("Elemento 1");
        p.empilha("Elemento 2");
        Object retorno = p.desempilha();
        assertEquals("Elemento 1", p.verificaTopo());
                
        assertFalse(p.vazia());
    }
    
    
}
