
package Controller;

import Model.DAO.*;
import Model.Estacionamento.*;
import View.TelaPrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Controlador {
    
    private List<ContaVeiculo> listaVeiculos;
    private Thread t0,t1;
    private PersistenciaDados DAO;
    
    public Controlador(){
        listaVeiculos=new ArrayList<ContaVeiculo>();  
        DAO=new PersistenciaDados();
    }
    
    public void addContaVeiculo(String nome, String placa, TipoVeiculoEnum tipo)throws Exception{
        listaVeiculos.add(new ContaVeiculo(Calendar.getInstance().getTimeInMillis()-(1000*60*60*2), new Veiculo(nome, placa, tipo)));
    }
    
    public String[][] listaVeiculosCadastrados() throws Exception{
        
        String[][] aux=new String[listaVeiculos.size()][6];
        ContaVeiculo conta;
        Date dataAux;
        for(int i=0;i<listaVeiculos.size();i++){
            conta=(ContaVeiculo) listaVeiculos.get(i);
            aux[i][0]=conta.getVeiculo().getNome();
            aux[i][1]=conta.getVeiculo().getPlaca();
            aux[i][2]=conta.getVeiculo().getTipo().toString();
            dataAux=new Date(conta.getInicio());
            aux[i][3]= dataAux.toString();
            dataAux=new Date(conta.getFim());
            aux[i][4]= dataAux.toString();
            aux[i][5]=conta.getStatus().toString();
        }
        return aux;
        
    }
    
    private ContaVeiculo getConta(String placaVeiculo){
       ContaVeiculo conta = null;
        for(int i = 0; i<listaVeiculos.size();i++){
            if(listaVeiculos.get(i).getVeiculo().getPlaca() == placaVeiculo){
                conta = (ContaVeiculo) listaVeiculos.get(i);
            }
        }
        return conta;
   }
    
    public void finalizarConta(String placaVeiculo,MetricaCalculoEnum metrica) throws Exception{
        ContaVeiculo conta = getConta(placaVeiculo);
        
        //Finaliza a conta, utilizando a metrica de calculo recebida como paramentro.
        // Se a metrica for AUTOMATICO, o sistema deverá verificar a opção mais barata e utiliza-la
        /*switch(metrica){
            case AUTOMATICO:
                if((conta.getVeiculo().getTipo().quinzeMinutos)*4 < conta.getVeiculo().getTipo().umaHora
                        && (conta.getVeiculo().getTipo().quinzeMinutos)*4 < (conta.getVeiculo().getTipo().vinteQuatroHoras)/24)
                {
                    Calculo15Minutos calculo = null;
                    valor_final = calculo.calcular(Permanencia, conta.getVeiculo());
                } else if(conta.getVeiculo().getTipo().umaHora < conta.getVeiculo().getTipo().quinzeMinutos*4
                        && (conta.getVeiculo().getTipo().umaHora) < conta.getVeiculo().getTipo().vinteQuatroHoras/24)
                {
                    CalculoHorista calculo = null;
                    valor_final = calculo.calcular(Permanencia, conta.getVeiculo());
                } else if(conta.getVeiculo().getTipo().vinteQuatroHoras/24 < conta.getVeiculo().getTipo().quinzeMinutos*4
                        && conta.getVeiculo().getTipo().vinteQuatroHoras/24 < conta.getVeiculo().getTipo().umaHora)
                {
                    CalculoDiaria calculo = null;
                    valor_final = calculo.calcular(Permanencia, conta.getVeiculo());
                }
                break;
                
            case DIARIA:
                break;
                
            case HORA:
                break;
                
            case UM_QUARTO_HORA:
                break;
        }*/
        
        // Altera o status para fechado e salva o registro.
        //Se valor da conta for zero retorna um erro.
        
        //Se não for possivel registra no BD, salve um backup local da listaVeiculos;
        //Utilize o objeto DAO
       
    }
    public String calculaValorEstacionamento2(String placaVeiculo, MetricaCalculoEnum metrica){
        return Double.toString(calculaValorEstacionamento(placaVeiculo, metrica));
    }
    public double calculaValorEstacionamento(String placaVeiculo, MetricaCalculoEnum metrica){
        ContaVeiculo conta = getConta(placaVeiculo);
        
        
        switch(metrica){
            case AUTOMATICO:         
                automatico(conta);
                break;
            case DIARIA:
                conta.setCalculo(new CalculoDiaria());
                break;

            case HORA:
                conta.setCalculo(new CalculoHorista());
                break;
            case UM_QUARTO_HORA:
                conta.setCalculo(new Calculo15Minutos());
                break;
        }
        double aux = conta.valorConta(Calendar.getInstance().getTimeInMillis());
        return aux;
    }
    
    public String calculaPermanencia(String placaVeiculo){
        //pegar o valor da placa do veiculo na lista
        
        ContaVeiculo conta;
        float Permanencia = 0;
        long dataInicio;
        
        for(int i = 0; i < listaVeiculos.size(); i++){ //vai rodar cada veiculo cadastrado até achar a placa igual ao textbox
            
            if(listaVeiculos.get(i).getVeiculo().getPlaca().equals(placaVeiculo)){
                //fazer o calculo
                conta = (ContaVeiculo) listaVeiculos.get(i);
                dataInicio = conta.getInicio();
                Permanencia = Calendar.getInstance().getTimeInMillis() - dataInicio;
                
            }
        }
        return Float.toString(Permanencia/(60*1000*60));
    }

    private double automatico(ContaVeiculo conta) {
        long periodo = Calendar.getInstance().getTimeInMillis() - conta.getInicio();
        if(periodo < 1){
            return calculaValorEstacionamento(conta.getVeiculo().getPlaca(), MetricaCalculoEnum.UM_QUARTO_HORA);
        } else if(periodo >= 1 && periodo < 12){
            return calculaValorEstacionamento(conta.getVeiculo().getPlaca(), MetricaCalculoEnum.HORA);
        } else{
            return calculaValorEstacionamento(conta.getVeiculo().getPlaca(), MetricaCalculoEnum.DIARIA);
        }
        
        
    }
    
    
    
}
