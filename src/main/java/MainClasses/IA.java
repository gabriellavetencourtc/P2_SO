/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
import GUIS.Ganadores;
import GUIS.main;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author gabriellavetencourtc
 */
public class IA extends Thread{
    public Personajes SMpersonaje;
    public Personajes AVATARpersonaje;
    private Personajes p1;
    private Personajes p2;
    private Personajes ganador;
    private int smGANADOR;
    private int avatarGANADOR;
    private String estadoCPU;
    private Lista listaGANADORES;
    public Lista listaGANADORESsm;
    public Lista listaGANADORESavatar;
    private Semaphore mutex;
    private int contadorRondas;
    private  int duracionCombate;
    

    private main main;
    private Ganadores ganadoresInterfaz;

    public IA(Semaphore m, Lista winnersList,Lista winnerListSM, Lista winnerListAvatar, main mainUI,Ganadores ganadoresUI ) {
        this.SMpersonaje = null;
        this.AVATARpersonaje = null;
        this.p1 = null;
        this.p2 = null;
        this.ganador = null;
        this.estadoCPU = "Esperando";
        this.smGANADOR = 0;
        this.avatarGANADOR = 0;
        this.listaGANADORES = winnersList;
        this.listaGANADORESsm = winnerListSM;
        this.listaGANADORESavatar = winnerListAvatar; 
        this.mutex = m;
        this.contadorRondas = 0;
        this.main = mainUI;
        this.ganadoresInterfaz = ganadoresUI;
        this.duracionCombate = 1000; //CAMBIAR A 10000
    }

    @Override
    public void run() {

        try {
            Random random = new Random();
            int outcome;

            sleep(20);

            while (true) {

                mutex.acquire(1);

                if (this.AVATARpersonaje != null && this.SMpersonaje != null) {

                    this.estadoCPU = "Procesando";
                    setEstadoCPU(estadoCPU);
                 
                    
                    //Cambiar este sleep
                    sleep(duracionCombate);

                    outcome = random.nextInt(100);
               

                    if (outcome < 40) {
                        this.estadoCPU = "Hubo un ganador";
                        setEstadoCPU(estadoCPU);
        

                        combate();

                        this.estadoCPU = "Combate finalizado";

                    } else if (outcome < 67) {
                        this.estadoCPU = "Empate";
                        setEstadoCPU(estadoCPU);
        

                    } else {
                        this.estadoCPU = "Personajes NO listos";
                        setEstadoCPU(estadoCPU);


                    }


                sinJugadores();
                    
               }else{
                    this.estadoCPU = "En espera";
                    setEstadoCPU(estadoCPU);

                    
                }
            
            this.contadorRondas++;
            mutex.release();
            sleep(1000);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void combate() throws InterruptedException{
        
        this.p1 = MejorAgilidad();
        this.p2 = peorAgilidad();
        setAVATARpersonaje(AVATARpersonaje);
        setSMpersonaje(SMpersonaje);
        this.main.setVidaSM(this.SMpersonaje.toString());
        this.main.setVidaAvatar(this.AVATARpersonaje.toString());

        
        while(this.p1.getVidas() > 0 && this.p2.getVidas() > 0){
            p1Combate();
            
            if(this.p2.getVidas() <= 0){
                this.ganador = this.p1;
                break;
            }

            sleep(duracionCombate);
            p2Combate();
            
            if(this.p1.getVidas() <= 0){
                this.ganador = this.p2;
                break;
            }

            sleep(duracionCombate);
        }
        

        this.listaGANADORES.aggFinal(new Nodo(this.ganador));
       
        setGanadoresInterfaz();
        asignarGanador();
        this.ganador = null;
    }

 
    public Personajes MejorAgilidad() {
        if (this.AVATARpersonaje.getAgilidad() > this.SMpersonaje.getAgilidad()) {
            return this.AVATARpersonaje;
        } else {
            return this.SMpersonaje;
        }
    }

    public Personajes peorAgilidad() {
        if (this.p1 == this.AVATARpersonaje) {
            return this.SMpersonaje;
        } else {
            return this.AVATARpersonaje;
        }
    }
    
    public void setGanadoresInterfaz(){
        this.ganadoresInterfaz.getListSM().setText(listaGANADORESsm.mostrarLista());
        this.ganadoresInterfaz.getListAvatar().setText(listaGANADORESavatar.mostrarLista());
}

    public void asignarGanador() {

        if (this.ganador == this.SMpersonaje) {
            this.smGANADOR += 1;
            this.main.getSMWin().setText(Integer.toString(this.smGANADOR));
            
       
        String ganador = this.ganador.getNombre() + " ID: " + this.ganador.getId();
        listaGANADORESsm.aggFinal(new Nodo(ganador));
         setGanadoresInterfaz();

        } else {
            this.avatarGANADOR += 1;
            this.main.getAvatarWin().setText(Integer.toString(this.avatarGANADOR));
            
       
        String ganador = this.ganador.getNombre() + " ID: " + this.ganador.getId();
        listaGANADORESavatar.aggFinal(new Nodo(ganador));
         setGanadoresInterfaz();
        }

    }

    public void p1Combate() {
        Random random = new Random();
        int daño;
        this.main.setVidaSM(this.SMpersonaje.toString());
        this.main.setVidaAvatar(this.AVATARpersonaje.toString());
        int selectedMove = random.nextInt(3);
        switch (selectedMove) {

            case 0:
                daño = (this.p1.getFuerza());
                this.p2.setVidas(this.p2.getVidas() - daño);
                
                
                if (this.p1 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());
                   
                  
                    
                    
                } else {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());
    
                   
                }
                
                break;
                
                

            case 1:
                daño = (this.p1.getHabilidades() * 75);
                this.p2.setVidas(this.p2.getVidas() - daño);
                
                
                if (this.p1 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());
      
    
                    
                } else {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());

                   
                }

                break;

            case 2:
                
                daño = (this.p1.getFuerza() * this.p1.getHabilidades());
                this.p2.setVidas(this.p2.getVidas() - daño);
                
                if (this.p1 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());

                   
                    
                    
                } else {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());

                    
                }
                
                break;

        }

    }

    public void p2Combate() {
        Random random = new Random();
        int damage;
        this.main.setVidaSM(this.SMpersonaje.toString());
        this.main.setVidaAvatar(this.AVATARpersonaje.toString());
        int ataque = random.nextInt(3);
        switch (ataque) {
            

            case 0:
                damage = (this.p2.getFuerza());
                this.p1.setVidas(this.p1.getVidas() - damage);

                if (this.p2 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());

                    
                    
                    
                } else {
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());

                    
                }
                
                
                break;

            case 1:
                
                damage = (this.p2.getHabilidades() * 75);
                this.p1.setVidas(this.p1.getVidas() - damage);
                this.p1.setVidas(this.p1.getVidas() - damage);

                if (this.p2 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());
      
                   
                    
                } else {
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());

                    
                }
               
                break;

            case 2:
                
                damage = (this.p2.getFuerza() * this.p2.getHabilidades());
                
                this.p1.setVidas(this.p1.getVidas() - damage);
                this.p1.setVidas(this.p1.getVidas() - damage);

                if (this.p2 == this.AVATARpersonaje) {
                    this.main.setVidaAvatar("Vida" + ":" + this.p2.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p1.getVidas());

                   
                    
                } else {
                    
                    
                    this.main.setVidaAvatar("Vida" + ":" + this.p1.getVidas());
                    this.main.setVidaSM("Vida" + ":" + this.p2.getVidas());
        
                   
                }
                
                break;

        }

    }

    public void sinJugadores() {
        this.p1 = null;
        this.p2 = null;
    }

    public Personajes getSMpersonaje() {
        return SMpersonaje;

    }

    public void setSMpersonaje(Personajes SMpersonaje) {
        this.SMpersonaje = SMpersonaje;
        
        if (SMpersonaje != null) {
            this.main.setFuerzaSM("Fuerza: "+Integer.toString(this.SMpersonaje.getFuerza()));
            this.main.setAgilidadSM("Agilidad: "+Integer.toString(this.SMpersonaje.getAgilidad()));
            this.main.setVidaSM("Habilidad: " + Integer.toString(this.SMpersonaje.getHabilidades()));          
            this.main.setPersonajeSMLabel(SMpersonaje.getNombre());
        
        
        } else {
            this.main.setPersonajeSMLabel("No asignado"); 
        }
    }


    public Personajes getAVATARpersonaje() {
        return AVATARpersonaje;
    }
    
    

    public void setAVATARpersonaje(Personajes AVATARpersonaje) {
        
        this.AVATARpersonaje = AVATARpersonaje;
        
        if (AVATARpersonaje != null) {
            this.main.setFuerzaAvatar("Fuerza: "+Integer.toString(this.AVATARpersonaje.getFuerza()));
            this.main.setAgilidadAvatar("Agilidad: "+Integer.toString(this.AVATARpersonaje.getAgilidad()));
            this.main.setVidaAvatar("Habilidad: " + Integer.toString(this.AVATARpersonaje.getHabilidades()));

            this.main.setPersonajeAvatarLabel(AVATARpersonaje.getNombre());
        
        
        } else {
            this.main.setPersonajeAvatarLabel("No asignado"); 
        }
    }


    public void setDur(int durSegInterf) {
        this.duracionCombate = durSegInterf;
    }

    public Personajes getGanador() {
        return ganador;
    }

    public void setGanador(Personajes ganador) {
        this.ganador = ganador;
    }

    public String getEstadoCPU() {
        return estadoCPU;
    }

    public void setEstadoCPU(String estadoCPU) {
        this.estadoCPU = estadoCPU;
        this.main.getEstadoCPU().setText(estadoCPU);
    }

    public Personajes getP1() {
        return p1;
    }

    public void setP1(Personajes p1) {
        this.p1 = p1;
    }

    public Personajes getP2() {
        return p2;
    }

    public void setP2(Personajes p2) {
        this.p2 = p2;
    }

    public Lista getListaGANADORES() {
        return listaGANADORES;
    }

    public void setListaGANADORES(Lista listaGANADORES) {
        this.listaGANADORES = listaGANADORES;
    }

    public int getContadorRondas() {
        return contadorRondas;
    }

    public void setContadorRondas(int contadorRondas) {
        this.contadorRondas = contadorRondas;
    }

}