
package Semana4;


public class Nodo {
    public int dato;
    public Nodo siguiente;
    
    public Nodo(int d){
        this.dato=d;
        this.siguiente=null;
    }
    
    public Nodo(int d, Nodo n){
        this.dato=d;
        this.siguiente=n;
    }
    
    
}
