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
public class Morsa extends SerVivo{
    int dia;
    public Morsa(int dia, int masa){
        super(dia,masa);
    }
    
    public int ComerOsos(){
        Random rc = new Random();
        int num_osos = rc.nextInt(2-1+1)+1;
        
        return num_osos;
    }
    
    public int ComerFocas(){
        Random rf = new Random();
        int num_focas = rf.nextInt(2-1+1)+1;
        
        return num_focas;
    }
    
    public void Reproducirse(){
        
    }
    
    public void Morir(){
        
    }
            
}
