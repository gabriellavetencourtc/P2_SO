/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import GUIS.main;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author gabriellavetencourtc
 */

public class Administrador extends Thread {

    Semaphore mutex;
    IA CPU;
    int contID;

    Lista smCOLA1;
    Lista smCOLA2;
    Lista smCOLA3;
    Lista smCOLAR;


    Lista avatarCOLA1;
    Lista avatarCOLA2;
    Lista avatarCOLA3;
    Lista avatarCOLAR;
    private main main;
    
    public Administrador(IA cpu, Semaphore m, main main) {
        this.CPU = cpu;
        this.contID = 0;
        this.mutex = m;
        this.main = main;
        
        this.smCOLA1 = new Lista();
        this.smCOLA2 = new Lista();
        this.smCOLA3 = new Lista();
        this.smCOLAR = new Lista();

        this.avatarCOLA1 = new Lista();
        this.avatarCOLA2 = new Lista();
        this.avatarCOLA3 = new Lista();
        this.avatarCOLAR = new Lista();
    }

    @Override
    public void run() {
        Random random = new Random();
        
        for(int i = 0; i < 10; i++){
            aggPersonaje("SM");
            aggPersonaje("AVATAR");
        }
        

        try {
            while (true) {
                
                sleep(10);
                mutex.acquire(1);


                if (this.CPU.getContadorRondas() >= 2) {
                    if (random.nextInt(100) <= 80) {
                        aggPersonaje("SM");
                        aggPersonaje("AVATAR");
                        verificarColaR(random);
                    }

                    this.CPU.setContadorRondas(0);
                }

              
                
                switch(this.CPU.getEstadoCPU()){
                
                    case "Empate":
                        empate();
                        break;
                        
                    case "Combate cancelado":
                        noPelea();
                        break;
                        
                }
                
                
                
                verificarColaR(random);
                // Incrementar la espera de los personajes en cada lista
                aumentarEspera(smCOLA2); // Para los de SM nivel 2
                aumentarEspera(smCOLA3); // Para los de SM nivel 3

                aumentarEspera(avatarCOLA2);  // Para los de AVATAR nivel 2
                aumentarEspera(avatarCOLA3);  // Para los de AVATAR nivel 3


                passSM();
                passAvatar();
                actualizarColas(smCOLA1, main.getCola1_CN());
                actualizarColas(smCOLA2, main.getCola2_CN());
                actualizarColas(smCOLA3, main.getCola3_CN());
                actualizarColas(smCOLAR, main.getColaR_CN());

                actualizarColas(avatarCOLA1, main.getCola1_Nick());
                actualizarColas(avatarCOLA2, main.getCola2_Nick());
                actualizarColas(avatarCOLA3, main.getCola3_Nick());
                actualizarColas(avatarCOLAR, main.getColaR_Nick());

                
                mutex.release();
                sleep(1000);
                
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizarColas(Lista lista, JTextPane textPane) {
        String laux = lista.mostrarLista1();
        SwingUtilities.invokeLater(() -> textPane.setText(laux));
    }



    private void aumentarEspera(Lista lactual) {
        Nodo nodoActual = lactual.getpFirst();
        while (nodoActual != null) {
            Personajes p = (Personajes) nodoActual.getData();
            if (p.getEspera() == 8) { 
                cambiarPrioridad(p, lactual); 
            } else {
                p.aumentarEspera(); 
            }
            nodoActual = nodoActual.getpNext();
        }
    }


// Nuevo método cambiarPrioridad
    private void cambiarPrioridad(Personajes p, Lista lactual) {
        if (lactual == smCOLA2 || lactual == smCOLA3) {
            prioridadSM(p, lactual);
            
        } else if (lactual == avatarCOLA2 || lactual == avatarCOLA3) {
            prioridadAvatar(p, lactual);
        }
    }

// Método para manejar el cambio de prioridad de los personajes de Show mas
    private void prioridadSM(Personajes p, Lista lactual) {
        if (lactual == smCOLA2) {
            proximoLista(p, lactual, smCOLA1);
        }else{
            proximoLista(p, lactual, smCOLA2);
        }
    }

// Método para manejar el cambio de prioridad de los personajes de Avatar
    private void prioridadAvatar(Personajes p, Lista lactual) {
        if (lactual == this.avatarCOLA2) {
            proximoLista(p, lactual, this.avatarCOLA1);
        } else{
            proximoLista(p, lactual, this.avatarCOLA2);
        }
    }

// Método para mover un personaje a la siguiente lista (utilizado por los métodos de manejo de prioridad)
    private void proximoLista(Personajes p, Lista lactual, Lista lprox) {
        lactual.eliminarPersonaje(p); 
        p.quitarEspera();
        lprox.aggFinal(new Nodo(p));
    }
    

    private void empate() {
        this.smCOLA1.aggFinal(new Nodo(this.CPU.getSMpersonaje()));
        this.avatarCOLA1.aggFinal(new Nodo(this.CPU.getAVATARpersonaje()));


        this.CPU.setSMpersonaje(null);
        this.CPU.setAVATARpersonaje(null);
    }

    public void noPelea() {
        
        this.smCOLAR.aggFinal(new Nodo(this.CPU.getSMpersonaje()));
        this.avatarCOLAR.aggFinal(new Nodo(this.CPU.getAVATARpersonaje()));
        
 
        this.CPU.setSMpersonaje(null);
        this.CPU.setAVATARpersonaje(null);
    }

    public void verificarColaR(Random random) {
        if (this.smCOLAR.getSize() != 0 && this.avatarCOLAR.getSize() != 0) {

            int outcome = random.nextInt(100);

            if (outcome <= 40) {
                Personajes tempSM = Personajes.class.cast(this.smCOLAR.delFirst().getData());
                Personajes tempAvatar = Personajes.class.cast(this.avatarCOLAR.delFirst().getData());
                
                this.smCOLA1.aggFinal(new Nodo(tempSM));
                this.avatarCOLA1.aggFinal(new Nodo(tempAvatar));
            }

        }

    }

    public void passSM() {

        if (this.smCOLA1.isEmpty()) {

            if (this.smCOLA2.isEmpty()) {

                if (this.smCOLA3.isEmpty()) {

                    this.CPU.setSMpersonaje(null);

                } else {
                    this.CPU.setSMpersonaje(Personajes.class.cast(this.smCOLA3.delFirst().getData()));
                }

            } else {
                this.CPU.setSMpersonaje(Personajes.class.cast(this.smCOLA2.delFirst().getData()));
            }

        } else {
            this.CPU.setSMpersonaje(Personajes.class.cast(this.smCOLA1.delFirst().getData()));
        }


    }

    public void passAvatar() {

        if (this.avatarCOLA1.isEmpty()) {

            if (this.avatarCOLA2.isEmpty()) {
                
                if (this.avatarCOLA3.isEmpty()){
                    
                    this.CPU.setAVATARpersonaje(null);
                }else{
                    this.CPU.setAVATARpersonaje(Personajes.class.cast(this.avatarCOLA3.delFirst().getData()));
                }
                
            } else {

                this.CPU.setAVATARpersonaje(Personajes.class.cast(this.avatarCOLA2.delFirst().getData()));
            }

        } else {
            this.CPU.setAVATARpersonaje(Personajes.class.cast(this.avatarCOLA1.delFirst().getData()));
        }
        

        
    }

    public void aggPersonaje(String series) {

        Personajes tempP = new Personajes(series, this.contID);
        int aux = (tempP.getHabilidades() * 100) + tempP.getVidas() + tempP.getFuerza() + tempP.getAgilidad();

        if (series.equals("SM")) {

            if (aux >= 3000) {
                this.smCOLA1.aggFinal(new Nodo(tempP));

            } else if (aux >= 2000) {
                this.smCOLA2.aggFinal(new Nodo(tempP));

            } else {
                this.smCOLA3.aggFinal(new Nodo(tempP));
            }

        } else {

            if (aux >= 3000) {
                this.avatarCOLA1.aggFinal(new Nodo(tempP));

            } else if (aux >= 2000) {
                this.avatarCOLA2.aggFinal(new Nodo(tempP));

            } else {
                this.avatarCOLA3.aggFinal(new Nodo(tempP));
            }
        }

        this.contID++;

    }


}
