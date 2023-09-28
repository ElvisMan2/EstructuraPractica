
package com.mycompany.semana5;
import javax.swing.JOptionPane;
public class UsoListaDoble {

    public static void main(String[] args) {
        ListaDoble lista2=new ListaDoble();
        int opcion=0,elemento;
        do{
            try{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un Nodo al inicio\n"+
                        "2. Agregar un Nodo al final\n"+
                        "3. Mostrar la Lista de inicio a fin\n"+
                        "4. Mostrar la Lista de fin a inicio\n"+
                        "5. Eliminar un Nodo del inicio\n"+
                        "6. Eliminar un Nodo del final\n"+
                        "7. Salir\n"+
                        "¿Que deseas hacer?", "Menu de opciones", JOptionPane.INFORMATION_MESSAGE));
                switch(opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del Nodo","Agregando el Nodo al inicio",
                                JOptionPane.INFORMATION_MESSAGE));
                        lista2.agregarAlInicio(elemento);
                        break;
                    case 2:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del Nodo","Agregando el Nodo al final",
                                JOptionPane.INFORMATION_MESSAGE));
                        lista2.agregarAlFinal(elemento);

                        break;
                    case 3:
                        if(!lista2.estaVacia()){
                            lista2.mostrarListaInicioFin();
                        }else{
                        JOptionPane.showMessageDialog(null,"No hay nodos aun",
                                "Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!lista2.estaVacia()){
                            lista2.mostrarListaFinInicio();
                        }else{
                        JOptionPane.showMessageDialog(null,"No hay nodos aun",
                                "Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if(!lista2.estaVacia()){
                            elemento=lista2.eliminarDelInicio();
                        JOptionPane.showMessageDialog(null,"El elemento eliminado es: "+elemento,
                                "Eliminando del inicio",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                                JOptionPane.showMessageDialog(null,"No hay nodos aun",
                                "Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!lista2.estaVacia()){
                            elemento=lista2.eliminarDelFinal();
                        JOptionPane.showMessageDialog(null,"El elemento eliminado es: "+elemento,
                                "Eliminando del final",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                                JOptionPane.showMessageDialog(null,"No hay nodos aun",
                                "Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Aplicacion Finalizada",
                                "Fin",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"La Opcion no esta en el Menu",
                                "Incorrecto",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error "+n.getMessage());
            }
        }while(opcion!=7);
    }
}
