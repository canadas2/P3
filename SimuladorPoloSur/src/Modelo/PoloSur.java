/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
/**
 *
 * @author raulg
 */
public class PoloSur {
    
   private ArrayList<SerVivo> seres_vivos = new ArrayList();
   //private HashSet<SerVivo> seres_vivos = new HashSet<SerVivo>();
   private int dia = 1;
   private int temp_media_agua = 4;
   private long num_krill_plancton;
    
    public PoloSur(){
        System.out.println("-------Creando esquimales...-------");
        creacionEsquimales();
        System.out.println("-------Creando osos polares...-------");
        creacionOsosPolares();
        System.out.println("-------Creando morsas...-------");
        creacionMorsas();
        System.out.println("-------Creando focas...-------");
        creacionFocas();
        System.out.println("-------Creando peces...-------");
        creacionPeces();
        System.out.println("-------Creando krill y plancton...-------");
        creacionKrillPlancton();
        System.out.println("-------SE HA CREADO EL NUEVO POLO SUR-------");
    }
    
    public void transcurrirUnDia(){
        System.out.println("COMER() a todos los seres vivos:");
        //Comer();
        System.out.println("REPRODUCIRSE() a todos los seres vivos:");
        //Reproducirse();
        //System.out.println("MORIR() a todos los seres vivos:");
        
    }
    
    public void Reproducirse(){
        Boolean comprobar = false;
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo ser_vivo = seres_vivos.get(i);
            if(ser_vivo instanceof Esquimal){
                comprobar = ((Esquimal) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Esquimal esquimal = new Esquimal(dia,masa);
                    //seres_vivos.add(esquimal);
                    System.out.println("Acaba de reproducirse el esquimal numero:"+i);
                }
                
            }
            else if(ser_vivo instanceof OsoPolar){
                comprobar = ((OsoPolar) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    OsoPolar oso_polar = new OsoPolar(dia,masa);
                    //seres_vivos.add(oso_polar);
                    System.out.println("Acaba de reproducirse el oso polar numero:"+i);
                }
            }
            else if(ser_vivo instanceof Morsa){
                comprobar = ((Morsa) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Morsa morsa = new Morsa(dia,masa);
                    //seres_vivos.add(morsa);
                    System.out.println("Acaba de reproducirse la morsa numero:"+i);
                }
            }
            else if(ser_vivo instanceof Foca){
                comprobar = ((Foca) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Foca foca = new Foca(dia,masa);
                    //seres_vivos.add(foca);
                    System.out.println("Acaba de reproducirse la foca numero:"+i);
                }
            }
            else if(ser_vivo instanceof Pez){
                comprobar = ((Pez) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    String especie = ((Pez) ser_vivo).getEspecie();
                    Pez pez = new Pez(dia,masa,especie);
                    //seres_vivos.add(pez);
                    System.out.println("Acaba de reproducirse el pez numero:"+i);
                }
            }
        }
        
        System.out.println("YA SE HAN REPRODUCIDO TODOS");
    }
    
    public void Morir(){
        
    }
    
    public void Comer(){
        int esquimales = 0, osos = 0, morsas = 0, focas = 0, peces = 0;
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo ser_vivo = seres_vivos.get(i);
            if(ser_vivo instanceof Esquimal){
                esquimales++;
                comerEsquimales(ser_vivo);
                System.out.println("Acaba de comer el esquimal numero:"+i);
            }
            else if(ser_vivo instanceof OsoPolar){
                osos++;
                comerOso(ser_vivo);
                System.out.println("Acaba de comer el oso polar numero:"+i);
            }
            else if(ser_vivo instanceof Morsa){
                morsas++;
                comerMorsa(ser_vivo);
                System.out.println("Acaba de comer la morsa numero:"+i);
            }
            else if(ser_vivo instanceof Foca){
                focas++;
                comerFoca(ser_vivo);
                System.out.println("Acaba de comer la foca numero:"+i);
            }
            else if(ser_vivo instanceof Pez){
                peces++;
                comerPez(ser_vivo);
                System.out.println("Acaba de comer el pez numero:"+i);
            }
        }
        
        System.out.println("YA HAN COMIDO TODOS");
        System.out.println("Num esqui:"+esquimales+". Num osos:"+osos+". Num morsas:"+morsas+". Num focas:"+focas+". Num peces:"+peces);
    }
    
    public void comerPez(SerVivo ser_vivo){
        
        long num_kp = ((Pez) ser_vivo).Comer();  
        num_krill_plancton = num_krill_plancton - num_kp;
        
    }
    
    public void comerFoca(SerVivo ser_vivo){
        int num_peces = ((Foca) ser_vivo).Comer();
        eliminarPeces(num_peces);
    }
    
    public void comerMorsa(SerVivo ser_vivo){
        int num_osos_comidos,num_focas_comidas;
        
        ((Morsa) ser_vivo).Comer();
        num_focas_comidas = ((Morsa) ser_vivo).getFocas_comidas();
        eliminarFocas(num_focas_comidas); 
        num_osos_comidos = ((Morsa) ser_vivo).getOsos_comidos(); 
        eliminarOsos(num_osos_comidos);
    }
    
    public void comerOso(SerVivo ser_vivo){
        Boolean come_f;
        int num_peces_comidos,num_focas_comidas;
        
        ((OsoPolar) ser_vivo).Comer();
        
        num_focas_comidas = ((OsoPolar) ser_vivo).getFocas_comidas();
        eliminarFocas(num_focas_comidas); 
        num_peces_comidos = ((OsoPolar) ser_vivo).getPeces_comidos(); 
        eliminarPeces(num_peces_comidos);
    }
    
    
    public void comerEsquimales(SerVivo ser_vivo){
        Boolean come_f;
         int num_peces_comidos,num_focas_comidas=0;
         
         ((Esquimal) ser_vivo).Comer();
         come_f = ((Esquimal) ser_vivo).getComer_focas_dia();
       
        if(come_f == true){
            num_focas_comidas = 1;
            eliminarFocas(num_focas_comidas);
        }
        num_peces_comidos = ((Esquimal) ser_vivo).getPeces_comidos_dia();
        
        eliminarPeces(num_peces_comidos);
    }
    
    public void eliminarFocas(int num){
        int num_focas = num, minimo_masa = 100, masa_act,indice_menor_masa=0;
        ArrayList<SerVivo> a_eliminar = new ArrayList();
        
        for(int j = 0; j < num; j++){
            for(int i = 0; i < seres_vivos.size();i++){
                if(seres_vivos.get(i) instanceof Foca){
                    masa_act = seres_vivos.get(i).getPor_masmusc();
                    if(masa_act < minimo_masa){
                        indice_menor_masa = i;
                        minimo_masa = masa_act;
                    }   
                }
            }
            seres_vivos.remove(indice_menor_masa);
            System.out.println("Se acaba de eliminar la foca numero: "+indice_menor_masa);
        }
        

        
    }
    
    public void eliminarPeces(int num){
        int num_focas = num, minimo_masa = 100, masa_act,indice_menor_masa=0;
        ArrayList<SerVivo> a_eliminar = new ArrayList();
        
        for(int j = 0; j < num; j++){
            for(int i = 0; i < seres_vivos.size();i++){
                if(seres_vivos.get(i) instanceof Pez){
                    masa_act = seres_vivos.get(i).getPor_masmusc();
                    if(masa_act < minimo_masa){
                        indice_menor_masa = i;
                        minimo_masa = masa_act;
                    }  
                }
            }
            seres_vivos.remove(indice_menor_masa);
            System.out.println("Se acaba de eliminar el pez numero: "+indice_menor_masa);
        }
    }
    
    private void eliminarOsos(int num){
        int num_focas = num, minimo_masa = 100, masa_act,indice_menor_masa=0;
        ArrayList<SerVivo> a_eliminar = new ArrayList();
        
        for(int j = 0; j < num; j++){
            for(int i = 0; i < seres_vivos.size();i++){
                if(seres_vivos.get(i) instanceof OsoPolar){
                    masa_act = seres_vivos.get(i).getPor_masmusc();
                    if(masa_act < minimo_masa){
                        indice_menor_masa = i;
                        minimo_masa = masa_act;
                    }  
                }
            }
            seres_vivos.remove(indice_menor_masa);
            System.out.println("Se acaba de eliminar el oso numero: "+indice_menor_masa);
        }
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
        System.out.println("individuos morsa:"+individuos);
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
        System.out.println("individuos foca:"+individuos);
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
        System.out.println("individuos pez:"+individuos);
        for(int i = 0; i < individuos;i++){
           Pez pez = new Pez(dia,masa);
           seres_vivos.add(pez);
        }
    }
    
    private void creacionKrillPlancton(){
        Random r1 = new Random();
        long min = 65000000000L;
        long max = 75000000000L;
        
        long individuos = min+((long)(r1.nextDouble()*(max-min)));
        System.out.println("numero de krills y plancton: "+individuos);
        num_krill_plancton = individuos;
//        long individuos = (long)(Math.random()*((75000000000-65000000000)+1))+65000000000;
//        for(int i = 0; i < individuos;i++){
//            KrillPlancton kp = new KrillPlancton();
//            seres_vivos.add(kp);
//            System.out.println("Se ha añadido el KryPl numero: "+i);
//        }
    }
}
