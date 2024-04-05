
package Model.Estacionamento;

import java.io.Serializable;

public enum TipoVeiculoEnum implements Serializable{
    
    MOTOCICLETA(1,2,20), //QM = 4, UH = 2, VQH = 0.83
    CARRO_PASSEIO(2,4,40), //QM = 8, UH = 4, VQH = 1.66
    CAMINHOES(4,8,80); //QM = 16, UH = 8, VQH = 3.33
    
    public double quinzeMinutos, umaHora, vinteQuatroHoras;
    
    TipoVeiculoEnum(double valor15min, double valor1Hora, double valor24Horas){
        quinzeMinutos=valor15min;
        umaHora=valor1Hora;
        vinteQuatroHoras=valor24Horas;
    }  

    public double getQuinzeMinutos() {
        return quinzeMinutos;
    }

    public double getUmaHora() {
        return umaHora;
    }

    public double getVinteQuatroHoras() {
        return vinteQuatroHoras;
    }
    
}
