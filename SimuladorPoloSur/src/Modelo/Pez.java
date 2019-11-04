/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Random;
/**
 *
 * @author raulg
 */
public class Pez extends SerVivo{
    
    String especie;
    
    
    public Pez(int dia, int masa){
        super(dia,masa);
        Random r = new Random();
        double prob_especie = 0.0+((r.nextDouble()*(99.9-0.0)));
        if(prob_especie <= 33.3){
            especie = "bacalao";
        } else if ((prob_especie <= 66.6)&&(prob_especie > 33.3)){
            especie = "raya";
        } else{
            especie = "merluza negra";
        }
    }
    
    public Pez(int dia, int masa, String especie){
        super(dia,masa);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }
    

    public long Comer(){
        int prob;
        long num_peces=0;
        Random rc = new Random();
        prob = rc.nextInt(1);
        if(prob == 0)
            num_peces = 1000000L;
        else if(prob == 1)
            num_peces = 2000000L;
        
        return num_peces;
    }
    
    public Boolean Reproducirse(){
        Random rr = new Random();
        double prob = 0.0+((rr.nextDouble()*(1.0-0.0)));
        return prob <= 0.185;
    }
}
