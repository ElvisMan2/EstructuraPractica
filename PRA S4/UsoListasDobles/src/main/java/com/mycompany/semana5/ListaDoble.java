
package com.mycompany.semana5;
import javax.swing.JOptionPane;
public class ListaDoble {
    private NodoDoble inicio,fin;
    public ListaDoble(){
        inicio=fin=null;
    }
    //Método para saber cuando la lista está vacía
    public boolean estaVacia(){
        return inicio==null;
    }
    //Método para agregar nodos al Final
    public void agregarAlFinal(int el){
        if(!estaVacia()){
            fin=new NodoDoble(el, null, fin);
            fin.anterior.siguiente=fin;
        }else{
            inicio=fin=new NodoDoble(el);
        }
    }
    //Método para agregar al inicio
    public void agregarAlInicio(int el){
        if(!estaVacia()){
            inicio=new NodoDoble(el, inicio, null);
            inicio.siguiente.anterior=inicio;
        }else{
            inicio=fin=new NodoDoble(el);
        }
    }
    //Método para mostrar la lista de inicio a fin
    public void mostrarListaInicioFin(){
        if(!estaVacia()){
            String datos="<=>";
            NodoDoble auxiliar=inicio;
            while(auxiliar!=null){
                datos= datos + "["+auxiliar.dato+"]<=>";
                auxiliar=auxiliar.siguiente;
            }
            JOptionPane.showMessageDialog(null, datos,
                    "Mostrando Lista de Inicio a Fin",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Método para mostrar la Lista de Fin a Inicio
    public void mostrarListaFinInicio(){
        if(!estaVacia()){
            String datos="<=>";
            NodoDoble auxiliar=fin;
            while(auxiliar!=null){
                datos= datos + "["+auxiliar.dato+"]<=>";
                auxiliar=auxiliar.anterior;
            }
            JOptionPane.showMessageDialog(null, datos,
                    "Mostrando Lista de Fin a Inicio",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Metodo para eliminar del inicio
    public int eliminarDelInicio(){
        int elemento=inicio.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else{
            inicio=inicio.siguiente;
            inicio.anterior=null;
        }
        return elemento;
    }
    //metodo para eliminar del final
    public int eliminarDelFinal(){
        int elemento=fin.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else{
            fin=fin.anterior;
            fin.siguiente=null;
        }
        return elemento;
    }
}
