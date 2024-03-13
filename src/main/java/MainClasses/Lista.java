/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author gabriellavetencourtc
 */
public class Lista {
    private Nodo pFirst;
    private Nodo pLast;
    private int size = 0;

  
    public Nodo getpFirst() {
        return pFirst;
    }

 
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

 
    public Nodo getpLast() {
        return pLast;
    }


    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }
 
    
    public Lista(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    
    public void aggInicio(Nodo data){
    if(isEmpty()){
        this.pFirst = data;
        this.pLast = data;
    }else{
        data.setpNext(this.pFirst);
        this.pFirst = data;
        }
    this.size++;
    }
    
    public void aggFinal(Nodo data){
        if(isEmpty()){
            this.pFirst = data;
            this.pLast = data;
        }else{
            this.pLast.setpNext(data);
            this.pLast = data;
        }
        this.size++;
        }
    
    public Nodo delFirst(){
        if(isEmpty()){
        return null;
        }else{
            Nodo aux = this.pFirst;
            this.pFirst = aux.getpNext();
            this.size--;
            return aux;
        }
    }
    
    public Nodo delLast(){
        if(isEmpty()){
            return null;
        }else{
            Nodo aux = this.pFirst;
            Nodo previousLast = this.pLast;
            for(int i = 0; i < this.size - 1; i++){
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            this.pLast = aux;
            this.size--;
            return previousLast;
        }   
    }
    
     public boolean existePersonaje(Personajes p) {
        Nodo currentNode = this.pFirst;
        while (currentNode != null) {
            if (((Personajes) currentNode.getData()).getId() == p.getId()) {
                return true;
            }
            currentNode = currentNode.getpNext();
        }
        return false;
    }

    public void eliminarPersonaje(Personajes p) {
        //Si esta vacio, no hace nada (realmente se leeria esta linea?)
        if (isEmpty()) {
            return;
            
            
        //Si no esta vacio, verifica que caso es
        }else{
        
            //Caso 1: el personaje a eliminar es el primero, solo se usa el metodo delFirst
            if (((Personajes) this.pFirst.getData()).getId() == p.getId()) {
                this.delFirst();
            
            //Caso 2: el personaje a eliminar es el ultimo, se usa el metodo delLast
            }else if (((Personajes) this.pLast.getData()).getId() == p.getId()) {
                this.delLast();
                
            }else{
            
                Nodo current = this.pFirst;
                Nodo previous = null;
                while (current != null && ((Personajes) current.getData()).getId() != p.getId()) {
                    previous = current;
                    current = current.getpNext();
                }

                // Eliminar el nodo actual de la lista
                previous.setpNext(current.getpNext());
                this.size--;
            }   
        }
    }
    
 

}
