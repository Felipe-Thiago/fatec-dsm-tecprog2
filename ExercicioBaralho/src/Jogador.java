/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alunos
 */
public class Jogador {
    String nome;
    
    public Jogador(String nome){
        this.nome = nome;
    }
    public void jogar() throws InterruptedException{
        String carta = "";
        while(carta!=null){
            carta = Baralho.getInstance().pegarCarta();
            System.out.println(nome + " - " + carta);
            Thread.sleep(100);
        }
    }
}
