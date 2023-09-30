/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpilas;

import javax.swing.JOptionPane;

public class PilaArray {
    private int MAX;
    private int[] Pila;
    private int cima;

    public PilaArray(int max) {
        MAX = max;
        Pila = new int[MAX + 1];
        cima = 0;
    }

    public boolean IsPilaLlena() {
        boolean isLlena = cima == MAX;
        System.out.println("La pila está llena: " + isLlena);
        return isLlena;
    }

    public boolean IsPilaVacia() {
        boolean isVacia = cima == 0;
        System.out.println("La pila está vacía: " + isVacia);
        return isVacia;
    }

    public void InsertarPila(int elemento) {
        if (IsPilaLlena()) {
            JOptionPane.showMessageDialog(null, "La pila está llena");
        } else {
            Pila[++cima] = elemento;
            System.out.println("Elemento insertado en la pila: " + elemento);
        }
    }
     
    public void EliminarPila() {
        if (IsPilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        } else {
            int elementoEliminado = Pila[cima--];
            System.out.println("Elemento eliminado de la pila: " + elementoEliminado);
        }
    }

    public void MostrarPila() {
        if (IsPilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        } else {
            StringBuilder pilaStr = new StringBuilder("Elementos de la Pila:\n");
            System.out.println("Elementos de la Pila:");
            for (int i = 1; i <= cima; i++) {
                pilaStr.append(Pila[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, pilaStr.toString());
        }
    }

    public void VaciarPila() {
        System.out.println("La pila se ha vaciado.");
        cima = 0;
    }

    public int primeroPila() {
        if (IsPilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
            return -1; // Otra opción sería lanzar una excepción en lugar de retornar -1
        } else {
            int primerElemento = Pila[cima];
            System.out.println("Primer elemento de la pila: " + primerElemento);
            return primerElemento;
        }
    }
}

