
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alunos
 */
public class Mesa {
    
    static Jogador p1, p2, p3, p4;
    
    public static void main(String[] args) throws InterruptedException {
        
        p1 = new Jogador("Lucas");
        p2 = new Jogador("Pedro");
        p3 = new Jogador("João");
        p4 = new Jogador("Thiago");
        
       
        new Thread(() ->{
            try {
                p1.jogar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }).start();
        
        new Thread(() ->{
            try {
                p2.jogar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }).start();
        
        new Thread(() ->{
            try {
                p3.jogar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }).start();
        
        new Thread(() ->{
            try {
                p4.jogar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }).start();
        
    }
}
