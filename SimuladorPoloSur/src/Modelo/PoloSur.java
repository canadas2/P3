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
public class PoloSur {
    
    ArrayList<SerVivo> seres_vivos = new ArrayList();
    int dia = 1;
    int temp_media_agua = 4;
    
    public PoloSur(){
        creacionEsquimales();
        creacionOsosPolares();
        creacionMorsas();
        creacionFocas();
        creacionPeces();
        creacionKrillPlancton();
    }
    
    public void Comer(){
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo ser_vivo = seres_vivos.get(i);
            if(ser_vivo instanceof Esquimal){
                comerEsquimales(ser_vivo);
            }
            else if(ser_vivo instanceof OsoPolar){
                comerOso(ser_vivo);
            }
            else if(ser_vivo instanceof Morsa){
                comerMorsa(ser_vivo);
            }
            else if(ser_vivo instanceof Foca){
                
            }
            else if(ser_vivo instanceof Pez){
                
            }
        }
    }
    
    public void comerFoca(SerVivo ser_vivo){
        
    }
    
    public void comerMorsa(SerVivo ser_vivo){
        int num_osos_comidos,num_focas_comidas;
        
        num_focas_comidas = ((Morsa) ser_vivo).ComerFocas();
        eliminarFocas(num_focas_comidas); 
        num_osos_comidos = ((Morsa) ser_vivo).ComerOsos(); 
        eliminarOsos(num_osos_comidos);
    }
    
    public void comerOso(SerVivo ser_vivo){
        Boolean come_f;
        int num_peces_comidos,num_focas_comidas;
        
        num_focas_comidas = ((OsoPolar) ser_vivo).ComerFocas();
        eliminarFocas(num_focas_comidas); 
        num_peces_comidos = ((OsoPolar) ser_vivo).ComerPeces(); 
        eliminarPeces(num_peces_comidos);
    }
    
    
    public void comerEsquimales(SerVivo ser_vivo){
        Boolean come_f;
        int num_peces_comidos,num_focas_comidas=0;
        come_f = ((Esquimal) ser_vivo).ComerFocas();
        if(come_f == true){
            num_focas_comidas = 1;
            eliminarFocas(num_focas_comidas);
        }
        num_peces_comidos = ((Esquimal) ser_vivo).ComerPeces();
        
        eliminarPeces(num_peces_comidos);
    }
    
    public Boolean eliminarFocas(int num){
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo servivo = seres_vivos.get(i);
            if((servivo instanceof Foca) && (num!= 0)){
                seres_vivos.remove(i);
                num--;
            }
            else if(num==0){
                return true;
            }
        }
        return false; //no se ha podido realizar eliminacion focas
    }
    
    public Boolean eliminarPeces(int num){
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo servivo = seres_vivos.get(i);
            if((servivo instanceof Pez) && (num!= 0)){
                seres_vivos.remove(i);
                num--;
            }
            else if(num==0){
                return true;
            }
        }
        return false;
    }
    
    private Boolean eliminarOsos(int num){
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo servivo = seres_vivos.get(i);
            if((servivo instanceof OsoPolar) && (num!= 0)){
                seres_vivos.remove(i);
                num--;
            }
            else if(num==0){
                return true;
            }
        }
        return false;
    }
    
    private void creacionEsquimales(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(14-12+1)+12;
        int masa = r2.nextInt(48-35+1)+35;
        for(int i = 0; i < individuos;i++){
            Esquimal esquimal = new Esquimal(dia, masa);
            seres_vivos.add(esquimal);
        }
        
    }
    
    private void creacionOsosPolares(){
        
        Random r1 = new Random();
         Random r2 = new Random();
        int individuos = r1.nextInt(28-22+1)+22;
        int masa = r2.nextInt(55-40+1)+40;
        for(int i = 0; i < individuos;i++){
            OsoPolar oso_polar = new OsoPolar(dia, masa);
            seres_vivos.add(oso_polar);
        }
    }
    
    private void creacionMorsas(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(48-42+1)+42;
        int masa = r2.nextInt(42-30+1)+30;
        for(int i = 0; i < individuos;i++){
            Morsa morsa = new Morsa(dia, masa);
            seres_vivos.add(morsa);
        }
    }
    
    private void creacionFocas(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(290-260+1)+260;
        int masa = r2.nextInt(32-25+1)+25;
        for(int i = 0; i < individuos;i++){
            Foca foca = new Foca(dia,masa);
            seres_vivos.add(foca);
        }
    }
    
    private void creacionPeces(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(8000-7000+1)+7000;
        int masa = r2.nextInt(70-55+1)+55;
        for(int i = 0; i < individuos;i++){
           Pez pez = new Pez(dia,masa);
           seres_vivos.add(pez);
        }
    }
    
    private void creacionKrillPlancton(){
        Random r1 = new Random();
        long min = 65000000000L;
        long max = 75000000000L;
//        min = Long.parseUnsignedLong("65000000000");
//        max=Long.parseUnsignedLong("75000000000");
        //long individuos = r1.nextLong();
        
        long individuos = min+((long)(r1.nextDouble()*(max-min)));
        
//        long individuos = (long)(Math.random()*((75000000000-65000000000)+1))+65000000000;
        for(int i = 0; i < individuos;i++){
            KrillPlancton kp = new KrillPlancton();
            seres_vivos.add(kp);
        }
    }
}
