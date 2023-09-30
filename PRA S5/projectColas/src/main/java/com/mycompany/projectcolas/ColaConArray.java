/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcolas;

import javax.swing.JOptionPane;

public class ColaConArray {
    private int MAX;
    private int[] Cola;
    private int frente;
    private int finalCola;

    public ColaConArray(int max) {
        MAX = max;
        Cola = new int[MAX + 1];
        frente = 0;
        finalCola = 0;
    }

    public boolean IsColaLlena() {
        return (finalCola == MAX);
    }

    public boolean IsColaVacia() {
        return (frente == finalCola);
    }

    public void InsertarCola(int elemento) {
        if (IsColaLlena()) {
            JOptionPane.showMessageDialog(null, "La cola está llena");
        } else {
            Cola[++finalCola] = elemento;
        }
    }

    public void EliminarCola() {
        if (IsColaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
        } else {
            frente++;
        }
    }

    public void MostrarCola() {
        if (IsColaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
        } else {
            StringBuilder colaStr = new StringBuilder("Elementos de la Cola:\n");
            for (int i = frente + 1; i <= finalCola; i++) {
                colaStr.append(Cola[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, colaStr.toString());
        }
    }

    public void VaciarCola() {
        frente = 0;
        finalCola = 0;
    }

    public int primeroCola() {
        if (IsColaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
            return -1; // Otra opción sería lanzar una excepción en lugar de retornar -1
        } else {
            return Cola[frente + 1];
        }
}
}

