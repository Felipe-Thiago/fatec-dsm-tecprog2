/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Alunos
 */
public class Mesa extends Thread{
    public Jogador p1, p2, p3, p4;
   
    /* INICIAR INSTANCIA DA MESA (a ser utilizada em comum por todos) */
    public static Mesa instance;
    
    public static Mesa getInstance(){ 
    //se tiver parametros de configuração fazer um novo getInstance() vazio que só chame a instancia
        if(instance == null){
            instance = new Mesa();
        }
        return null;
    }
    /* INSTANCIA DA MESA */
    
    //Passos
    //Entrar jogadores, minimo de 4
    //Instanciar baralho
    //Se 4 jogadores, iniciar rodada
    //embaralha cartas e distribui 2 para cada jogador
    //Inicio da rodada, abrir aposta
    //encerrar rodada
    
    
    
    
    @Override
    public void run(){ //iniciar rodada
        //Aqui inicia a execução da Thread
        System.out.println("Iniciando...");
        while(true){
            
        }
    }
}
