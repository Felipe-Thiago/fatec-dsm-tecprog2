
//package Classes_Jogo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Baralho {
    /* Classe composta por 52 cartas distintas formadas por 4 naipes e 13 numeros*/
    
    private List<Cartas> baralho=new ArrayList<>();
    public String nome;
    
    private static Baralho instance;
    
    public static Baralho getInstance(){
        if(instance == null){
            instance = new Baralho();
        }
        return instance;
    }
    
    private Baralho(){
                             
        for (Naipes naipe: Naipes.values())
        {
            for(NumerosCartas numero: NumerosCartas.values())
            {
                baralho.add(new Cartas(naipe,numero,numero.getValor())) ;
            }
        }
        Collections.shuffle(baralho); //embaralha o baralho
    }
    
   
    

    public int getQuantidadeCartas(){
        return baralho.size();
    }
    public synchronized String pegarCarta(){
        if(baralho.size() > 0)
            return baralho.remove(0).getNome();
        return null;
    }
    
    
    
}
