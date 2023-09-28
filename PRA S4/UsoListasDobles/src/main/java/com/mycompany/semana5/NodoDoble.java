
package com.mycompany.semana5;

public class NodoDoble {
    public int dato;
    NodoDoble siguiente,anterior;
    public NodoDoble(int el){
        this(el,null,null);
    }
    public NodoDoble(int el, NodoDoble s, NodoDoble a){
        dato=el;
        siguiente=s;
        anterior=a;
    }
}
