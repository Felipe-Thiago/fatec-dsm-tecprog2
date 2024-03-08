package calculahoras;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alunos
 */
public class CalculaHoras1 {
    
        
    public float retornaHoras(float inicio, float fim){
        Calendar c = Calendar.getInstance();
        float horas = 0;
        
        
        
        //horario do almoço
        if(fim - inicio > 6.00f) horas += 1.5f;
        
        //**************************************
        //Para o intervalo entre 08:00 e 18:00:
        horas += calculaIntervalo(inicio, fim, 0.00f, 6.00f) * 2.0f;
        
        horas += calculaIntervalo(inicio, fim, 6.00f, 8.00f) * 1.5f;
        
        horas += calculaIntervalo(inicio, fim, 8.00f, 18.00f);
        
        horas += calculaIntervalo(inicio, fim, 18.00f, 22.00f) * 1.5f;
        
        horas += calculaIntervalo(inicio, fim, 22.00f, 24.00f) * 2.0f;
        
        return horas;
    }
    
    
    private float calculaIntervalo(float inicioPeriodo, float fimPeriodo, float inicioIntervalo, float fimIntervalo){
        //O método é utilizado para calcular a quantidade de horas entre inicio e fim dentro de um intervalo de tempo
        //inicioPeriodo = 14, fimPeriodo = 19 /inicioIntervalo = 18 , fimIntervalo = 19
        if(inicioPeriodo < fimIntervalo && fimPeriodo > inicioIntervalo){
            //Periodo dentro de um intervalo
            if(inicioPeriodo < inicioIntervalo){ //definir sem hora extra
                inicioPeriodo = inicioIntervalo;
            }
            if(fimPeriodo > fimIntervalo){ //definir com hora extra
                fimPeriodo = fimIntervalo;
            }
            return (fimPeriodo - inicioPeriodo > 0)? fimPeriodo-inicioPeriodo:0;
        }  else{ //Não está dentro de um intervalo
            return 0;
        }
    }
    
    public float calculaHora(Calendar inicio, Calendar fim){
        return (fim.getTimeInMillis() - inicio.getTimeInMillis())/1000/60/60;
    }
    
  
    
    
}
