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
    int dia;
    public Foca(int dia, int masa){
        super(dia,masa);
    }
    
    public int Comer(){
        
        Random r = new Random();
        int peces_comidos = r.nextInt(25-15+1)+15;
        
        return peces_comidos;
    }
    
    public Boolean Reproducirse(){
        return true;
    }
    
    public void Morir(){
        
    }
}
