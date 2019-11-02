/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author raulg
 */
public class Esquimal extends SerVivo {
    
    int dia;
    
    public Esquimal(int dia, int masa){
        super(dia,masa);
    }
    
    public int ComerPeces(){
        Random rc_peces = new Random();
        int num_peces;
        double prob = 0.0+((rc_peces.nextDouble()*(1.0-0.0)));
        
        if(prob <= 1/3){
            num_peces = 2;
        } else if ((prob <= (1/3)*2)&&(prob > 1/3)){
            num_peces = 3;
        } else{
            num_peces = 4;
        }
        return num_peces;
    }
    
    public Boolean ComerFocas(){
        Random rc_focas = new Random();
        Boolean come = false;
        int foc =  rc_focas.nextInt(1);
        if(foc == 1){
            come = false;
        }else if (foc == 0){
            come = true;
        }
        
        return come;
    }
    
    public void Reproducirse(){
        Random rr = new Random();
    }
    
    public void Morir(){
        Random rm = new Random();
    }
}
