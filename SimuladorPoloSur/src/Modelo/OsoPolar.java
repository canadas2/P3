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
    private int focas_comidas, peces_comidos;
    private int dia_nac;
    private int masa_corp;
    private String tipo = "Oso Polar";
    
    public OsoPolar(int dia, int masa){
        super(dia,masa);
        dia_nac = dia;
        masa_corp = masa;
    }

    public int getFocas_comidas() {
        return focas_comidas;
    }

    public int getPeces_comidos() {
        return peces_comidos;
    }
    
    
    
    public void Comer(){
        focas_comidas = ComerFocas();
        peces_comidos = ComerPeces();
    }
    
    public int ComerFocas(){
        Random rc_focas = new Random();
        int num_focas=1;
        int foc =  rc_focas.nextInt(2);
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
    
    public Boolean Reproducirse(){
        Random rr = new Random();
        double prob = 0.0+((rr.nextDouble()*(1.0-0.0)));
        return prob <= 0.153;
    }
    
    public Boolean Morir(){
        Random rm = new Random();
        int prob = rm.nextInt(1000);
        return prob <= 95;
    }

    @Override
    public String toString() {
        return "OsoPolar{" + "dia_nac=" + dia_nac + ", masa_corp=" + masa_corp +  '}';
    }
    
    
    
}
