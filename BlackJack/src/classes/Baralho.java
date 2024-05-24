/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Thiago
 */
public class Baralho {
    /* Classe composta por 52 cartas distintas formadas por 4 naipes e 13 numeros*/
    private List<Cartas> baralho = new ArrayList();


    public static Baralho instance; //aplicando singleton
    
    public static Baralho getInstance(){
    if(instance == null){ //se a instancia não tiver sido criada
        instance = new Baralho();
    }
    return instance;
    }
    
    private Baralho(){
    
        for(Naipes naipe: Naipes.values()){
            for(NumerosCartas numero: NumerosCartas.values()){
                baralho.add(new Cartas(naipe, numero, numero.getValor()));
            }
        }
    }
    
    public int getQuantidadeCartas(){
        return baralho.size(); //52 total
    }
    
    public synchronized String pegarCarta(){ //aplicando singleton novamente
        if(baralho.size() > 0){
            return baralho.remove(0).getNome();
        }
        return null;
    }
}
