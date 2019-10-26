/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author raulg
 */
public abstract class SerVivo {
    
    private int dia_nac;
    
    private int por_masmusc;
    
    public SerVivo(){}
    
    public SerVivo(int dia_nac, int por_masmusc){
        this.dia_nac = dia_nac;
        this.por_masmusc = por_masmusc;
    }
    
    public void comer(){
        
    }
    
    public void reproducirse(){
        
    }
    
    public void morir(){
        
    }
    
    
    
}
