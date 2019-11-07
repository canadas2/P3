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
    
    private Boolean comer_focas_dia;
    private int peces_comidos_dia;
    
    public Esquimal(int dia, int masa){
        super(dia,masa);
    }
    
//    public int GetDiaNac(){
//        return super.getDia_nac();
//    }
//    
//    public int GetMasaCorp(){
//        return super.getPor_masmusc();
//    }

    public Boolean getComer_focas_dia() {
        return comer_focas_dia;
    }

    public int getPeces_comidos_dia() {
        return peces_comidos_dia;
    }


    
    public void Comer(){
        peces_comidos_dia = ComerPeces();
        comer_focas_dia = ComerFocas();
    }
    
    public int ComerPeces(){
        Random rc_peces = new Random();
        int num_peces=0;
        double prob = 0.0+((rc_peces.nextDouble()*(1.0-0.0)));
        
        if(prob <= 0.333){
            num_peces = 2;
        } else if ((prob <= 0.666)&&(prob > 0.333)){
            num_peces = 3;
        } else if(prob > 0.666){
            num_peces = 4;
        }
        return num_peces;
    }
    
    public Boolean ComerFocas(){
        Random rc_focas = new Random();
        Boolean come = false;
        int foc =  rc_focas.nextInt(2);
        if(foc == 1){
            come = false;
        }else if (foc == 0){
            come = true;
        }
        
        return come;
    }
    
    public Boolean Reproducirse(){
        Random rr = new Random();
        double prob = 0.0+((rr.nextDouble()*(1.0-0.0)));
        return prob <= 0.032;
    }
    
    public Boolean Morir(){
        Random rm = new Random();
        int prob = rm.nextInt(1000-0+1)+1000;
        return prob <= 24;
    }
    
    
}
