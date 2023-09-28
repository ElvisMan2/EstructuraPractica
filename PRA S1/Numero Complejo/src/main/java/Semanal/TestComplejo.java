package Semanal;

import java.util.Scanner;

public class TestComplejo {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        float real, imag;
        numComplejo complejo1, complejo2, resultado;
        System.out.print("Escribe el primer real: ");
        real = teclado.nextFloat();
        System.out.print("Escribe el primer imaginario: ");
        imag = teclado.nextFloat();
        complejo1 = new numComplex(real, imag);
        System.out.print("Escribe el segundo real: ");
        real = teclado.nextFloat();
        System.out.print("Escribe el segundo imaginario: ");
        imag = teclado.nextFloat();
        complejo2 = new numComplex(real, imag);
        resultado = complejo1.suma(complejo2);

        if (resultado.getImag() < 0.0) {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + -resultado.getImag());
        } else {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + resultado.getImag());
        }

        resultado = complejo1.resta(complejo2);
        if (resultado.getImag() < 0.0) {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + -resultado.getImag());
        } else {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + resultado.getImag());
        }

        resultado = complejo1.multiplicacion(complejo2);
        if (resultado.getImag() < 0.0) {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + -resultado.getImag());
        } else {
            System.out.println("El resultado es: "
                    + resultado.getReal() + "+ i" + resultado.getImag());
        }
        
        System.out.println("El módulo del primer número complejo es: " + complejo1.modulo());
        System.out.println("El módulo del segundo número complejo es: " + complejo2.modulo());

        if (complejo1.esigual(complejo2)) {
            System.out.println("Los números complejos son iguales");
        } else {
            System.out.println("Los números complejos son diferentes");
        }

    }

}
