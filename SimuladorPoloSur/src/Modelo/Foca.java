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
public class Foca extends SerVivo{
    private int dia_nac;
    private int masa_corp;
    private String tipo = "Foca";
    
    public Foca(int dia, int masa){
        super(dia,masa);
        dia_nac = dia;
        masa_corp = masa;
    }
    
    public int Comer(){
        
        Random r = new Random();
        int peces_comidos = r.nextInt(25-15+1)+15;
        
        return peces_comidos;
    }
    
    public Boolean Reproducirse(){
        return true;
    }
    
    public Boolean Morir(){
        Random rm = new Random();
        int prob = rm.nextInt(1000);
        return prob <= 90;
    }

    @Override
    public String toString() {
        return "Foca{" + "dia_nac=" + dia_nac + ", masa_corp=" + masa_corp +'}';
    }
    
    
}
