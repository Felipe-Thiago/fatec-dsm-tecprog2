/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
class Pilha {

    Object[] pilha;
    int topo = 0;
    
    public Pilha(){
        pilha = new Object[10];
    }
            
    void empilha(Object elemento) {
        pilha[topo] = elemento;
        topo++;
    }

    boolean vazia() {
        if(topo == 0)
            return true;
        else
            return false;
    }

    Object verificaTopo() {
        return pilha[topo - 1];
    }

    Object desempilha() {
        topo--;
        return pilha[topo];
    }
    
}
