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
public class OsoPolar extends SerVivo{
    int dia;
    public OsoPolar(int dia, int masa){
        super(dia,masa);
    }
    
    public int ComerFocas(){
        Random rc_focas = new Random();
        int num_focas=1;
        int foc =  rc_focas.nextInt(1);
        if(foc == 1){
            num_focas = 1;
        }else if (foc == 0){
            num_focas = 2;
        }
        
        return num_focas;
    }
    
    public int ComerPeces(){
        Random r1 = new Random();
        int num_peces = r1.nextInt(15-10+1)+10;
         
         return num_peces;
    }
    
    public void Resproducirse(){
        
        
    }
    
    public void Morir(){
        
    }
}
