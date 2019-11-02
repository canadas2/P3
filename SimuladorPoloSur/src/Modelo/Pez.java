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
}
