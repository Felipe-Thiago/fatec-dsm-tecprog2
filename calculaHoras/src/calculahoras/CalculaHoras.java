package calculahoras;

/**
 *
 * @author Alunos
 */
public class CalculaHoras {
    //Dados
    private int entrada = 0;
    private int saida = 0;
    
    private int dataInicio = 0;
    private int dataFim = 0;
    

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }
    
    
    //Métodos
    public int retornaHoras(int entrada, int saida){
        int horas = saida - entrada - 1;
        
        return horas;
        
    }
    
    public int retornaHorasDias(int entrada, int saida, int dataInicio, int dataFim){
        int horas = saida - entrada - 1;
        int dias = dataFim - dataInicio + 1;
        
        int horasTotais = horas * dias;
        
        return horasTotais;
    }
    
    
    public int retornaHorasSemana(int entrada, int saida, int dataInicio, int dataFim, String diaSemana){
        int horas = saida - entrada - 1;
        int dias = dataFim - dataInicio + 1;
        int horasTotais = horas * dias;
        int total = 0;
        
        for(int i = dataInicio; i >= dataFim; i++){
            switch(diaSemana){
            case "Segunda":
            case "Terça":
            case "Quarta":
            case "Quinta":
            case "Sexta":
                total = total + horas;
                /////////////////////////////
                
            case "Sábado":
            case "Domingo":
                horasTotais = horasTotais + horasTotais/2;
                return horasTotais;
            default:
                return horasTotais;
        }
        }
        
        switch(diaSemana){
            case "Segunda":
            case "Terça":
            case "Quarta":
            case "Quinta":
            case "Sexta":
                if (entrada < 8){
                    int extra = horas + (8 - entrada)/2;
                    horasTotais = horasTotais + extra;
                }
                if (saida > 18){
                    int extra = horas + (saida - 18)/2;
                    horasTotais = horasTotais + extra;
                }
                return horasTotais;
                
                
            case "Sábado":
            case "Domingo":
                horasTotais = horasTotais + horasTotais/2;
                return horasTotais;
            default:
                return horasTotais;
        }
        
        
    }
    
    public int retornaHorasNoturno(int entrada, int saida, int dataInicio, int dataFim){
        int horas = saida - entrada - 1;
        int dias = dataFim - dataInicio + 1;
        
        int horasTotais = horas * dias;
        
        if(entrada > saida){ //20 -> 04:00
            horas = horas + 24;
            if(saida < 6){
                 
            }
        } 
        
        return horasTotais;
    }
    
}
