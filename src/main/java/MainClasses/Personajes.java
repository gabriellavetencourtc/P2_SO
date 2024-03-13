/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
import java.util.Random;
/**
 *
 * @author gabriellavetencourtc
 */
public class Personajes {
     private String nombre;
    private int vidas;
    private int fuerza;
    private int agilidad;
    private int habilidades;
    private String[] movimientos;
    private int id;
    public int espera;
    
    
    public Personajes(String series, int id){
        this.id = id;
        this.espera = 0;
        AsignarNombres(series);
        Estadisticas();
        
    }

    public void aumentarEspera() {
        this.espera++;
    }

    public void quitarEspera() {
        this.espera = 0;
    }

    public void AsignarNombres(String series){
        String[] SMnombres = {"Starla", "Fantasmin", "Eileen", "CJ", "Maellard", "Alien", "Ghost", "Ana", "Maria", "Julia", "Lucas", "Robb", "Juliett", "Sidney", "Anton", "Bob", "Joshua", "Mary", "Zack", "Pochi"};
        String[] SMespeciales = {"Mordecai", "Musculoso", "Rigby", "Papaleta", "Benson", "Skips", "Margarita"};
        
        String[] AVATARnombres = {"Loak", "Ronal", "Sokka", "Tuktirey", "Eytukan", "Tsireya", "Neteyam", "Korra", "Moat", "Jupi", "Ter", "Venus", "Urano", "Kuzck", "Herc", "Phillip", "Auro", "Lion", "Sebas", "Ricky"};
        String[] AVATARespeciales = {"Jake", "Sully", "Neytiri", "Aang", "Kiri", "Miles", "Zuko"};
                
        Random random = new Random();
        int nameType = random.nextInt(101);        
        
        if(nameType > 70){
            
            int seleccionarNombre = random.nextInt(7);
            
            if (series.equals("SM")){
                this.nombre = SMespeciales[seleccionarNombre];
                
            }else{
                this.nombre = AVATARespeciales[seleccionarNombre];
            }
            
        }else{
            
            int seleccionarNombre = random.nextInt(20);
            
            if(series.equals("SM")){
                this.nombre = SMnombres[seleccionarNombre];
                
            }else{
                this.nombre = AVATARnombres[seleccionarNombre];
            }
            
            
        }
    }
    
    public void Estadisticas(){
        Random random = new Random();
        
        int calidadVidas = random.nextInt(101); 
        int calidadFuerza = random.nextInt(101);
        int calidadHabilidades = random.nextInt(101);
        int calidadAgilidad = random.nextInt(101);
        
        if(calidadHabilidades <= 60){
            this.habilidades = random.nextInt(10 - 5) + 5;
        }else{
            this.habilidades = random.nextInt(6 - 1) + 1;
        }
        
        
        if(calidadVidas <= 70){
            this.vidas = random.nextInt(3000 - 1500) + 1500;
        }else{
            this.vidas = random.nextInt(2000 - 1000) + 1000;
        }
        
        
        if(calidadFuerza <= 50){
            this.fuerza = random.nextInt(300 - 120) + 120;
        }else{
            this.fuerza = random.nextInt(210 - 50) + 50;
        }
        
        if(calidadAgilidad <= 40){
            this.agilidad = random.nextInt(300 - 120) + 120;
        }else{
            this.agilidad = random.nextInt(180 - 20) + 20;
        }
        
        //casos especiales estadisticas
        
        switch(this.nombre){
            
        
            //fuerza y habilidad de calidad
            case "Starla":
                this.fuerza = random.nextInt(300 - 120) + 120;
                this.habilidades = random.nextInt(10 - 7) + 7;  
                break;
                
 
            //fuerza de calidad / habilidad alta unica y variante / vida pobre
            case "Eileen":
                this.fuerza = random.nextInt(300 - 120) + 120;
                this.habilidades = random.nextInt(10 - 8) + 8;  
                this.vidas = random.nextInt(1500 - 800) + 800;
                break;
                
   
             //fuerza de calidad y calidad de vida mayor a lo normal
            case "Maellard":
               this.fuerza = random.nextInt(300 - 200) + 200;
               this.vidas = random.nextInt(3000 - 2000) + 2000; 
               break;
              
            //habilidad y agilidad de calidad
            case "CJ":
                this.habilidades = random.nextInt(10 - 5) + 5; 
                this.agilidad = random.nextInt(300 - 120) + 120;
                break;
    
            //agilidad y fuerza de calidad
            case "Mary":
                this.agilidad = random.nextInt(300 - 120) + 120;
                this.fuerza = random.nextInt(300 - 120) + 120;
                break;
 
            //agilidad de calidad y habilidades de calidad en un rango mayor de lo normal
            case "Loak":
                this.habilidades = random.nextInt(10 - 7) + 7;
                this.agilidad = random.nextInt(320 - 120) + 120;
                break;
                

            //fuerza de calidad, y habilidad de calidad en un rango mayor de lo normal
            case "Ronal":
                this.habilidades = random.nextInt(10 - 7) + 7;
                this.fuerza = random.nextInt(300 - 120) + 120;
                break;
                
            //vida y habilidades de calidad, y fuerza de calidad mayor de lo normal
            case "Sokka":
                this.vidas = random.nextInt(3000 - 1500) + 1500;
                this.habilidades = random.nextInt(10 - 5) + 5;
                this.fuerza = random.nextInt(300 - 200) + 200;
                break;
            
            //fuerza extremadamente alta
            case "Auro":
                this.fuerza = random.nextInt(300 - 250) + 250;
                break;
           

            //habilidad extremadamente alta y agilidad es extremadamente pobre
            case "Venus":
                this.habilidades = random.nextInt(10 - 9) + 9;
                this.agilidad = random.nextInt(80 - 20) + 20;
                break;
                

            //menores limites inferiores de vida, habilidad alta y un mayor rango de velocidad
            case "Rigby":
                this.vidas = random.nextInt(1800 - 800) + 800; 
                this.habilidades = random.nextInt(10 - 7) + 7;
                this.agilidad = random.nextInt(300 - 200) + 200;
                break;
                
                

            //limites inferiores de fuerza de calidad, su habilidad de calidad, mayor limite de velocidad y menos vida de lo normal
            case "Papaleta":
                this.fuerza = random.nextInt(300 - 170) + 170;
                this.habilidades = random.nextInt(10 - 5) + 5;
                this.agilidad = random.nextInt(300 - 120) + 120;
                this.vidas = random.nextInt(1600 - 900) + 900; 
                break;
                

            //lo mejor
            case "Margarita":
                this.fuerza = random.nextInt(300 - 250) + 250;
                this.habilidades = random.nextInt(10 - 9) + 9;
                this.agilidad = random.nextInt(300 - 180) + 180;
                this.vidas = random.nextInt(3000 - 1500) + 1500; 
                break;
                
 
            //agilidad muy alta y vida de calidad
            case "Jake":
                this.agilidad = random.nextInt(300 - 250) + 250;
                this.vidas = this.vidas = random.nextInt(3000 - 1500) + 1500;
                break;
             

            //extremadamente rapido, siempre tendra una agilidad mayor y habilidad de calidad
            case "Aang":
                this.agilidad = 350;
                this.habilidades = this.habilidades = random.nextInt(10 - 5) + 5;
                break;
            

            //vida mas concistente y  velocidad de calidad
            case "Sully":
                this.vidas = random.nextInt(1200 - 900) + 900;
                this.agilidad = random.nextInt(300 - 250) + 250;
                break;
        }
       

    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(int habilidades) {
        this.habilidades = habilidades;
    }

    public String[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String[] movimientos) {
        this.movimientos = movimientos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEspera() {
        return espera;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }
//    @Override
    public String toString() {
        return "" + this.nombre + ",";
    }

    
}
