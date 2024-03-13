/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainClasses;

/**
 *
 * @author gabriellavetencourtc
 */
public class Nodo<T> {
    private T data;
    private Nodo pNext;
    
   
    public Object getData() {
        return data;
    }

 
    public void setData(T data) {
        this.data = data;
    }

  
    public Nodo getpNext() {
        return pNext;
    }


    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
    public Nodo(T data) {
        this.data = data;
        this.pNext = null;
    }
    
    

}
