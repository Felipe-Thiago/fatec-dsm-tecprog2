package calculahoras;

/**
 *
 * @author Alunos
 */
public class CalculaHoras {
    //Dados
    private double entrada = 0;
    private double saida = 0;
    
    private double horas = 0;
    

    //getters e setters
    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }
    
    public double getHoras(){
        return horas;
    }
    
    public void setHoras(double horas){
        this.horas = horas;
    }
    
    
    //Métodos
    public double retornaHoras(double entrada, double saida){
        horas = saida - entrada;
        double extra;
        double extraNot;
        if(horas > 6){
            horas = horas + 1.5;
        }
        if(saida > 18 && saida < 22){
            extra = (saida - 18) * 0.5;
            horas = horas + extra;
        }
        if(entrada < 8 && entrada >= 6){
            extra = (8 - entrada) * 0.5;
            horas = horas + extra;
        }
        if(saida > 22){
            extraNot = (saida - 22);
            extra = ((saida - 18 - extraNot) * 0.5) + extraNot;
            horas = horas + extra;    
        }
        if(entrada < 6){
            extraNot = (6 - entrada);
            
            extra = ((8 - entrada - extraNot) * 0.5) + extraNot;
            horas = horas + extra;
        }
        if(entrada >= 22){
            if(saida < 6){
                extraNot = (saida - entrada) + 24;
                horas = horas + extraNot;
            }
        }
        
        if(saida < entrada){
            horas = horas + 24;
            if(saida < 6){
                extraNot = (saida - 22) + 24;
                if(entrada > 8 && entrada < 18){
                    extra = (22 - 18) * 0.5;
                    horas = (18 - entrada) + extra + extraNot;
                            //das 18 às 22 + das 22 à saída
                }
            }
            
        }
        
        return horas;
    }
    
    /*
    public double retornaHorasSemana(double entrada, double saida, int dataInicio, int dataFim, String diaSemana){
        horas = retornaHoras(entrada, saida);
        double horasTotais = 0;
        
        for(int i = dataInicio; i <= dataFim; i++){
            switch(diaSemana){
            case "Segunda":
                horasTotais = horasTotais + horas;
                diaSemana = "Terça";
                break;
            case "Terça":
                horasTotais = horasTotais + horas;
                diaSemana = "Quarta";
                break;
            case "Quarta":
                horasTotais = horasTotais + horas;
                diaSemana = "Quinta";
                break;
            case "Quinta":
                horasTotais = horasTotais + horas;
                diaSemana = "Sexta";
                break;
            case "Sexta":
                horasTotais = horasTotais + horas;
                diaSemana = "Sábado";
                break;            
            case "Sábado":
                horasTotais = horasTotais + horas * 1.5;
                diaSemana = "Domingo";
                break;
            case "Domingo":
                horasTotais = horasTotais + horas * 1.5;
                diaSemana = "Segunda";
                break;            
        }
    }
        
        return horasTotais;
    }
    */
    
    
}
