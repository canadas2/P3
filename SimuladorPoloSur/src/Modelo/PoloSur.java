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
   private ArrayList<SerVivo> mueren_inanicion = new ArrayList(); //array donde almacenamos cada dia los que se mueren por falta de comida, para eliminarlos despues de la funcion comer.
   private ArrayList<SerVivo> nuevos = new ArrayList(); //array donde almacenamos los nuevos del metodo Reproducir, ya que si lo haces al momento da problema como en comer
   private ArrayList<SerVivo> muertos = new ArrayList();
   private int dia = 1, num_osos_tot;
   private int num_focas_elim=0,num_peces_elim=0,num_osos_elim=0;
   private int temp_media_agua = 4; //faltaria usar esto para mostrarlo como info en la app, y para el crecimiento del crill.
   private long num_krill_plancton;
   private int num_peces_esquimales = 0, num_focas_esquimales = 0, num_peces_osos = 0, num_focas_osos = 0;
   private int num_focas_morsa = 0, num_osos_morsa = 0, num_peces_foca = 0;
   //variables para llevar la cuenta del numero de seres vivos por especie:
   private int esq_tot, osos_tot,focas_tot,morsa_tot,peces_tot;
   
    
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

    public ArrayList<SerVivo> getSeres_vivos() {
        return seres_vivos;
    }
    
    
    
    public void transcurrirUnDia(){
        System.out.println("COMER() a todos los seres vivos:");
        Comer();
        //ahora eliminamos todos los seres vivos comidos, hay que hacerlo despues de comer puesto que el array es dinamico y sino da problemas
        
        if(peces_tot>0) eliminarPeces(num_peces_elim);
        if(focas_tot>0) eliminarFocas(num_focas_elim);
        if(osos_tot>0) eliminarOsos(num_osos_elim);
        muerenInanicion();
        
        System.out.println("REPRODUCIRSE() a todos los seres vivos:");
        Reproducirse();
        
        System.out.println("MORIR() a todos los seres vivos:");
        Morir();
        
        dia++; //cuando finaliza el dia pasa al siguiente
        
    }
    
    
    /*
    *funcion reproducirse para todos los seres vivos, con instanceof mira de que tipo es, y añade un nuevo individuo
    *si le ha tocado reproducirse, heredando su masa comporal y pasando el dia 
    *al finalizar añadimos esos seres al Array global
    */
    public void Reproducirse(){
        Boolean comprobar = false;
        int num_esq = 0, num_osos=0, num_focas=0, num_morsas=0, num_peces =0;
        
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo ser_vivo = seres_vivos.get(i);
            if(ser_vivo instanceof Esquimal){
                comprobar = ((Esquimal) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Esquimal esquimal = new Esquimal(dia,masa);
                    nuevos.add(esquimal);
                    num_esq++;
                }
                
            }
            
            else if(ser_vivo instanceof OsoPolar){
                comprobar = ((OsoPolar) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    OsoPolar oso_polar = new OsoPolar(dia,masa);
                    num_osos++;
                    nuevos.add(oso_polar);
                }
            }
            else if(ser_vivo instanceof Morsa){
                comprobar = ((Morsa) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Morsa morsa = new Morsa(dia,masa);
                    nuevos.add(morsa);
                    num_morsas++;
                }
            }
            else if(ser_vivo instanceof Foca){
                comprobar = ((Foca) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    Foca foca = new Foca(dia,masa);
                    nuevos.add(foca);
                    num_focas++;
                }
            }
            else if(ser_vivo instanceof Pez){
                comprobar = ((Pez) ser_vivo).Reproducirse();
                if(comprobar == true){
                    int masa = ser_vivo.getPor_masmusc();
                    String especie = ((Pez) ser_vivo).getEspecie();
                    Pez pez = new Pez(dia,masa,especie);
                    nuevos.add(pez);
                    num_peces++;
                }
            }
        }
        
        //añadimos ahora los nuevos hijos al vector de seres_vivos despues de reproducirse todos:
        for(int j = 0; j < nuevos.size(); j++){
            seres_vivos.add(nuevos.get(j)); 
        }
        
        System.out.println("YA SE HAN REPRODUCIDO TODOS");
        System.out.println("Numero de esquimales que se reproducen:"+num_esq+", osos: "+num_osos+", morsas:"+num_morsas+", focas:"+num_focas+", peces:"+num_peces);
    }
    
    
    
    //funcion para que realicen la funcion morir todos los seres vivos
    public void Morir(){
        Boolean muere;
        int esq=0, osos=0, morsas=0, focas=0, peces=0;
        for(int i=0; i < seres_vivos.size();i++){
            SerVivo servivo = seres_vivos.get(i);
            if(servivo instanceof Esquimal){
                muere = ((Esquimal) servivo).Morir();
                if(muere){
                    muertos.add(servivo);
                    esq++;
                }
            }
            if(servivo instanceof OsoPolar){
                muere = ((OsoPolar) servivo).Morir();
                if(muere){
                    muertos.add(servivo);
                    osos++;
                }
            }
            if(servivo instanceof Morsa){
                muere = ((Morsa) servivo).Morir();
                if(muere){
                    muertos.add(servivo);
                    morsas++;
                }
                    
            }
            if(servivo instanceof Foca){
                muere = ((Foca) servivo).Morir();
                if(muere){
                    muertos.add(servivo);
                    focas++;
                }
            }
            if(servivo instanceof Pez){
                muere = ((Pez) servivo).Morir();
                if(muere){
                    muertos.add(servivo);
                    peces++;
                }
            }
        }
        
        for(int i=0; i < muertos.size();i++){
            seres_vivos.remove(muertos.get(i));
        }
        
        System.out.println("YA SE HA RELIZADO LA FUNCION MORIR.");
        System.out.println("Se han muerto "+esq+" esquimales, "+osos+" osos, "+morsas+" morsas, "+focas+" focas, "+peces+" peces.");
        
    }
    
    
    
    
    /*funcion Comer(): realiza la funcion de comer de todos los seres vivos del polo
    *dentro realiza la funcion comer de cada uno de los seres vivos, comprobando con instanceof a que clase pertenece
    */
    public void Comer(){
        int esquimales = 0, osos = 0, morsas = 0, focas = 0, peces = 0; //(para debug)estas variables las uso solo comprobar que el numero de animales que comen es el numero que le toca(hago ++ luego de ellas), para comprobar que funciona todo bien
        int num_peces_totales = 0, num_focas_totales = 0;
        
        for(int i = 0; i < seres_vivos.size();i++){
            SerVivo ser_vivo = seres_vivos.get(i);
            
            if(ser_vivo instanceof Esquimal){
                esquimales++;   
                comerEsquimales(ser_vivo); //funcion para que coman los esquimales, y así para todos.(el nombre es algo contradictorio y x eso lo digo jeje xd)
            }
            else if(ser_vivo instanceof OsoPolar){
                osos++;
                comerOso(ser_vivo);
            }
            else if(ser_vivo instanceof Morsa){
                morsas++;
                comerMorsa(ser_vivo);
            }
            else if(ser_vivo instanceof Foca){
                focas++;
                comerFoca(ser_vivo);
            }
            else if(ser_vivo instanceof Pez){
                peces++;
                comerPez(ser_vivo);
                
            }
        }
        num_osos_tot=osos;
        System.out.println("YA HAN COMIDO TODOS");
        //debug
        System.out.println("Han comido: Num esqui:"+esquimales+". Num osos:"+osos+". Num morsas:"+morsas+". Num focas:"+focas+". Num peces:"+peces);
        //info con el numero de seres vivos que come cada grupo(en total) de ser vivo al final del dia:
        System.out.println("Num de peces que comen esquimales: " +num_peces_esquimales+" y focas:"+num_focas_esquimales);
        System.out.println("Num de peces que comen osos: " +num_peces_osos+" y focas:"+num_focas_osos);
        System.out.println("Num de peces que comen focas: " +num_peces_foca);
        System.out.println("Num de osos que comen morsas: " +num_osos_morsa+" y focas:"+num_focas_morsa);
    }
    
    
    //funcion donde eliminaremos del array los seres que se han muerto x inanicion
    public void muerenInanicion(){
        for(int i = 0; i < mueren_inanicion.size();i++){
            seres_vivos.remove(mueren_inanicion.get(i)); //elimino cada uno sel array de seres vivo totales del polo sur
        }
    }
    
    //funcion para que coman los peces x numero de krill
    public void comerPez(SerVivo ser_vivo){
        
        long num_kp = ((Pez) ser_vivo).Comer();  
        
        num_krill_plancton = num_krill_plancton - num_kp;
        
    }
    
    public void comerFoca(SerVivo ser_vivo){
        if(peces_tot>0){
            int num_peces = ((Foca) ser_vivo).Comer(); //lamo a la funcion comer de foca que devuelve el numero de peces que se come
            num_peces_elim+=num_peces; //lo sumo al numero de peces que luego habrá que eliminar
            num_peces_foca+=num_peces; //lo sumo a la variable que muestro x pantalla en el metodo Comer() para debuguear, que dice el numero de peces que han comido todas las focas
            
        }else{
            mueren_inanicion.add(ser_vivo); //si no quedan peces, se muere por inanicion(lo almaceno en el array de los que se mueren d hambre para eliminar luego)
        }
        //sigo este mismo proceso para todos los seres vivos, la unica diferencia es que los otros comen mas de un ser vivo.
    }
    
    public void comerMorsa(SerVivo ser_vivo){
        int num_osos_comidos=0,num_focas_comidas;
        ((Morsa) ser_vivo).Comer(); //este metodo almacena en la Morsa el numero de focas y osos que se come (ver metodo Comer() propio de ese animal)
        
        if(focas_tot>0){
            num_focas_comidas = ((Morsa) ser_vivo).getFocas_comidas(); //get del numero de focas que le ha tocado comer
            num_focas_elim+=num_focas_comidas;
            num_focas_morsa+=num_focas_comidas;
             
        }
        if(osos_tot>0){
            num_osos_comidos = ((Morsa) ser_vivo).getOsos_comidos(); //get del numero de osos que le ha tocado comer
            num_osos_elim+=num_osos_comidos; //suele pasar que el primer dia se comen a todos los osos, en la parte dos 2 puedes cambiar las probabilidades si ves que las que hay no son buenas, para que no haya tan pocos osos, o que las morsas no coman tanto
            num_osos_morsa+=num_osos_comidos;
            
        }
        else 
            System.out.println("Esta morsa se ha quedado sin comer osos :("); //para saber el numero de morsas que se han quedado sin comer osos, pero pueden no morirse de hambre si han comido focas
        if(focas_tot<0 && (osos_tot<0 || num_osos_comidos==0)){ //si no quedan focas ni osos, o no quedan focas y no le ha tocado comer osos, se muere
            mueren_inanicion.add(ser_vivo);
        }
    }
    
    public void comerOso(SerVivo ser_vivo){
        Boolean come_f;
        int num_peces_comidos,num_focas_comidas;
        ((OsoPolar) ser_vivo).Comer();
        if(focas_tot>0){
            num_focas_comidas = ((OsoPolar) ser_vivo).getFocas_comidas();
            num_focas_elim+=num_focas_comidas;
            num_focas_osos+=num_focas_comidas;
        }
        if(peces_tot>0){
            num_peces_comidos = ((OsoPolar) ser_vivo).getPeces_comidos(); 
            num_peces_elim+=num_peces_comidos;
            num_peces_osos+=num_peces_comidos;
        }
        if(focas_tot<0 && peces_tot<0){ //si no quedan focas ni peces se muere
            mueren_inanicion.add(ser_vivo);
        }
    }
    
    
    public void comerEsquimales(SerVivo ser_vivo){
        Boolean come_f;
        int num_peces_comidos,num_focas_comidas=0;
        ((Esquimal) ser_vivo).Comer();
        
        if(focas_tot>0){
            come_f = ((Esquimal) ser_vivo).getComer_focas_dia();
            if(come_f == true){
                num_focas_comidas = 1;
                num_focas_elim++;
                num_focas_esquimales++;
            }
        }
        if(peces_tot>0){
            num_peces_comidos = ((Esquimal) ser_vivo).getPeces_comidos_dia();
            num_peces_elim+=num_peces_comidos;
            num_peces_esquimales++;
        }
        if((focas_tot<0 && peces_tot<0) || (num_focas_comidas==0 && peces_tot<0)){ //si no quedan focas ni peces, o no quedan peces y no le toca tomer focas, se muere d hambre
            mueren_inanicion.add(ser_vivo);
        }
    }
    
    //elimina el numero d focas que se han comido, siempre eliminando primero el que menos masa muscular tenga(mirar enunciado lab)
    //el resto de eliminar hace lo mismo pero para el resto de tipos de seres vivo que se comen y hay que eliminar 
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
            focas_tot--;
            //System.out.println("Se acaba de eliminar la foca numero: "+indice_menor_masa);
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
            //System.out.println("numero de peces = "+peces_tot);
            if(peces_tot>0){
            seres_vivos.remove(indice_menor_masa);
            peces_tot--;
            }
            //System.out.println("Se acaba de eliminar el pez numero: "+indice_menor_masa);
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
            osos_tot--;
            //System.out.println("Se acaba de eliminar el oso numero: "+indice_menor_masa);
        }
    }
    
    private void creacionEsquimales(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(14-12+1)+12;
        
        System.out.println("individuos esquimal:"+individuos);
        esq_tot=individuos;
        for(int i = 0; i < individuos;i++){
            int masa = r2.nextInt(48-35+1)+35;
            Esquimal esquimal = new Esquimal(dia, masa);
            seres_vivos.add(esquimal);
        }
        
    }
    
    private void creacionOsosPolares(){
        
        Random r1 = new Random();
         Random r2 = new Random();
        int individuos = r1.nextInt(28-22+1)+22;
        
        System.out.println("individuos oso polar:"+individuos);
        osos_tot=individuos;
        for(int i = 0; i < individuos;i++){
            int masa = r2.nextInt(55-40+1)+40;
            OsoPolar oso_polar = new OsoPolar(dia, masa);
            seres_vivos.add(oso_polar);
        }
    }
    
    private void creacionMorsas(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(48-42+1)+42;
        
        System.out.println("individuos morsa:"+individuos);
        morsa_tot=individuos;
        for(int i = 0; i < individuos;i++){
            int masa = r2.nextInt(42-30+1)+30;
            Morsa morsa = new Morsa(dia, masa);
            seres_vivos.add(morsa);
        }
    }
    
    private void creacionFocas(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(290-260+1)+260;
        
        System.out.println("individuos foca:"+individuos);
        focas_tot=individuos;
        for(int i = 0; i < individuos;i++){
            int masa = r2.nextInt(32-25+1)+25;
            Foca foca = new Foca(dia,masa);
            seres_vivos.add(foca);
        }
    }
    
    private void creacionPeces(){
        
        Random r1 = new Random();
        Random r2 = new Random();
        int individuos = r1.nextInt(8000-7000+1)+7000;
        
        System.out.println("individuos pez:"+individuos);
        peces_tot=individuos;
        for(int i = 0; i < individuos;i++){
            int masa = r2.nextInt(70-55+1)+55;
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

    }
}
