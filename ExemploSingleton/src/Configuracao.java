
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alunos
 */
public class Configuracao {
    
    private static Configuracao instance;
    private Calendar data;
    
    private Configuracao(){
        data = Calendar.getInstance();
        
    }
    
    public static Configuracao getInstance(){
        if(instance == null){
            instance = new Configuracao();
        }
        return instance;
    }
    
    public String getData(){
        return data.toString();
    }
}
