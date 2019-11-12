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
    private int dia_nac;
    private int masa_corp;
    private String tipo = "Pez";
    
    
    public Pez(int dia, int masa){
        super(dia,masa);
        dia_nac = dia;
        masa_corp = masa;
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
        this.dia_nac = dia;
        this.masa_corp = masa;
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
    
    public Boolean Morir(){
        Random rm = new Random();
        int prob = rm.nextInt(1000);
        //System.out.println("prob de pez:"+prob);
        return prob <= 163;
    }

    @Override
    public String toString() {
        return "Pez{" + "especie=" + especie + ", dia_nac=" + dia_nac + ", masa_corp=" + masa_corp +  '}';
    }
    
}
