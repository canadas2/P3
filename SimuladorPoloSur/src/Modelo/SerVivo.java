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
    
    private static int dia_nac;
    
    private static int por_masmusc;
    
    public SerVivo(){}
    
    public SerVivo(int dia_nac, int por_masmusc){
        this.dia_nac = dia_nac;
        this.por_masmusc = por_masmusc;
    }

    public int getDia_nac() {
        return dia_nac;
    }

    public void setDia_nac(int dia_nac) {
        this.dia_nac = dia_nac;
    }

    public int getPor_masmusc() {
        return por_masmusc;
    }

    public void setPor_masmusc(int por_masmusc) {
        this.por_masmusc = por_masmusc;
    }
    
    
    
    
    
}
