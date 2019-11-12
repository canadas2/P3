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
    
    private int osos_comidos, focas_comidas;
    private int dia_nac;
    private int masa_corp;
    private String tipo = "Morsa";
    
    public Morsa(int dia, int masa){
        super(dia,masa);
        dia_nac = dia;
        masa_corp = masa;
    }

    public int getOsos_comidos() {
        return osos_comidos;
    }

    public int getFocas_comidas() {
        return focas_comidas;
    }
    
    
    public void Comer(){
        osos_comidos = ComerOsos();
        focas_comidas = ComerFocas();
    }
    
    public int ComerOsos(){
        Random rc = new Random();
        int num_osos = rc.nextInt(3);
        
        return num_osos;
    }
    
    public int ComerFocas(){
        Random rf = new Random();
        int num_focas = rf.nextInt(2-1+1)+1;
        
        return num_focas;
    }
    
    public Boolean Reproducirse(){
        Random rr = new Random();
        double prob = 0.0+((rr.nextDouble()*(1.0-0.0)));
        return prob <= 0.098;
    }
    
    public Boolean Morir(){
        Random rm = new Random();
        int prob = rm.nextInt(1000);
        return prob <= 95;
    }

    @Override
    public String toString() {
        return "Morsa{" + "dia_nac=" + dia_nac + ", masa_corp=" + masa_corp + '}';
    }
            
}
