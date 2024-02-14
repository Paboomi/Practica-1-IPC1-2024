/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.util.Scanner;

/**
 *
 * @author saien
 */
public class Wordle {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String palabra;
        String palabraRival;
        char letras[];
        char letrasRival[];
        int intentos = 0;

        System.out.println("Ingrese una palabra de 6 letras");
        palabra = sc.nextLine();
        palabra = palabra.toUpperCase();

        //Verificamos que las palabras tengan 6 letras
        if (palabra.length() != 5) {
            System.out.println("La palabra tiene: " + palabra.length() + " letras");
        }

        letras = palabra.toCharArray();

        do {
            System.out.println(" \nIntenta adivinar la palabra");
            palabraRival = sc.nextLine();
            palabraRival = palabraRival.toUpperCase();

            if (palabraRival.length() != 5) {
                System.out.println("La palabra tiene: " + palabraRival.length() + " letras");
            }
            letrasRival = palabraRival.toCharArray();

            System.out.println("Verificar palabras almacenadas");

            mostrarPalabras(letras);
            mostrarPalabras(letrasRival);

            compararLetras(letras, letrasRival);
            if (palabraRival.equalsIgnoreCase(palabra)) {
                System.out.println("\nHa adivinado la palabra! ! la palabra era: " + palabra);
                break;
            } else {
                intentos++;
            }

            if (intentos == 5) {
                System.out.println("\nNo ha podido adivinar la palabra era: " + palabra);
            }

        } while (intentos < 6);

        if (palabraRival.equalsIgnoreCase(palabra)) {
            System.out.println("\nHa adivinado la palabra! ! la palabra era: " + palabra);
        } else {
            System.out.println("No ha podido adivinar la palabra era: " + palabra);
        }

    }

    public static void mostrarPalabras(char[] letras) {
        for (char letra : letras) {
            System.out.print(" | " + letra);
        }
        System.out.println("\n");
    }

    public static void compararLetras(char[] letras, char[] letrasRival) {
        for (int i = 0; i < 6; i++) { // Iteramos hasta i < 6
            char letraRival = letrasRival[i];
            boolean coincidencia = false;

            for (int j = 0; j < 6; j++) { // Iteramos para comparar con todas las letras
                char letra = letras[j];

                if (letraRival == letra && i == j) {
                    System.out.println(GREEN + letraRival + RESET); // Coinciden en la misma posición, se pinta de verde
                    coincidencia = true; //Cambiamos la coincidencia para que pueda entrar a los otros condicionales
                    break; // Salimos del bucle interno
                }
            }

            if (!coincidencia) {
                for (int j = 0; j < 6; j++) { // Iteramos nuevamente para comprobar si coincide en otra posición
                    char letra = letras[j];

                    if (letraRival == letra) {
                        System.out.println(YELLOW + letraRival + RESET); // Coinciden pero no en la misma posición, se pinta de amarillo
                        coincidencia = true;
                        break; // Salimos del bucle interno
                    }
                }
            }

            if (!coincidencia) {
                System.out.println(RED + letraRival + RESET); // No coincide en ninguna posición, se pinta de rojo
            }
        }
    }
}
