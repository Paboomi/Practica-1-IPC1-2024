package com.mycompany.practica1;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author saien
 */
public class Juego {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String BRIGHT_RED = "\033[0;91m";   // BRIGHT RED
    public static final String BRIGHT_GREEN = "\033[0;92m";   // BRIGHT GREEN
    public static final String BRIGHT_YELLOW = "\033[0;93m";   // BRIGHT YELLOW
    public static final String BRIGHT_BLUE = "\033[0;94m";   // BRIGHT BLUE
    public static final String BRIGHT_MAGENTA = "\033[0;95m";   // BRIGHT MAGENTA
    public static final String BRIGHT_CYAN = "\033[0;96m";   // BRIGHT CYAN
    public static final String basketball = "\uD83C\uDFC0";   // Balon de basket
    public static final String bloqueo = "\uD7C9\uDF0B";   // Tapon XD

    public static String nomPlayer1;
    public static String nomPlayer2;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int opcion;

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        System.out.println("Elija un juego por favor");
        System.out.println("1.- Adivina palabra");
        System.out.println("2.- Basketball");
        System.out.println("3.- 2048");
        opcion = Integer.valueOf(sc.nextLine());

        switch (opcion) {
            case 2:
                System.out.println(BRIGHT_CYAN + "\n\nBienvenido al juego de Basketball" + RESET);

                System.out.println("\nIngrese el nombre del primer jugador");
                nomPlayer1 = sc.nextLine();
                System.out.println("Ingrese el nombre del segundo jugador");
                nomPlayer2 = sc.nextLine();
                Basketball();
                break;
            default:
                throw new AssertionError();
        }

    }

    public static void Basketball() {

        int turnos;
        int contador = 0;
        boolean turnoPlayer1;
        boolean turnoPlayer2;
        int asignarTurno;
//        int optiro;
//        int opdefensa;
        double probAnotar = 0;
        double probTapar = 0;
        double probFalta = 0;
        int puntos = 0;
        int puntosPlayer1 = 0;
        int puntosPlayer2 = 0;

        System.out.println(BRIGHT_YELLOW+"Ingrese la cantidad de turnos que desea jugar"+RESET);
        turnos = Integer.valueOf(sc.nextLine());
        asignarTurno = turnoRandom();
        System.out.println(asignarTurno);

        turnoPlayer1 = (asignarTurno == 1);
//        if (asignarTurno == 1) {
//            turnoPlayer1 = true;
//            turnoPlayer2 = false;
//        } else {
//            turnoPlayer1 = false;
//            turnoPlayer2 = true;
//        }

        while (contador < turnos) {
            if (turnoPlayer1) {
                
                puntosPlayer1 += Jugar(nomPlayer1);
                
//                System.out.println("Turno de: " + nomPlayer1);
//                System.out.println("Elija un tipo de tiro");
//                System.out.println("1.- Tiro largo");
//                System.out.println("2.- Tiro corto");
//                optiro = Integer.valueOf(sc.nextLine());
//
//                switch (optiro) {
//                    case 1:
//                            probAnotar=0.65;
//                        break;
//                    case 2:
//                            probAnotar=0.8;
//                        break;
//                    default:
//                        System.out.println("No es posible realizar ese tiro");
//                }
//
//                System.out.println("\n Jugador 2 elije una defensa:");
//                System.out.println("1.- Defensa cuerpo a cuerpo");
//                System.out.println("2.- Defensa fuerte");
//                opdefensa = Integer.valueOf(sc.nextLine());
//                
//                switch (opdefensa) {
//                    case 1:
//                            probTapar = 0.15;
//                            probFalta = 0.35;
//                        break;
//                    case 2:
//                            probTapar = 0.3;
//                            probFalta = 0.65;
//                        break;
//                    default:
//                        System.out.println("No es posible seleccionar esa defensa");
//                }
//                
//                
//                if (optiro==1&&opdefensa==1 || optiro==1&&opdefensa==2) {
//                    if (calcTiro(probAnotar, probTapar)) {
//                    puntos+=3;
//                    System.out.println("Ha anotado Suma " + "3 puntos");
//                }else{
//                    System.out.println("No ha anotado");
//                }
//                }

//                if (calcTiro(probAnotar, probTapar)) {
//                    puntos+=
//                    System.out.println("Ha anotado Suma " + "3 puntos");
//                }else{
//                    System.out.println("No ha anotado");
//                }
            } else {
                    puntosPlayer2+=Jugar(nomPlayer2);
//                System.out.println("Turno de: " + nomPlayer2);
//                System.out.println("Elija un tipo de tiro");
//                System.out.println("1.- Tiro largo");
//                System.out.println("2.- Tiro corto");
//                optiro = Integer.valueOf(sc.nextLine());
//
//                System.out.println("\n Jugador 1 elije una defensa:");
//                System.out.println("1.- Defensa cuerpo a cuerpo");
//                System.out.println("2.- Defensa fuerte");
//                opdefensa = Integer.valueOf(sc.nextLine());
            }

            turnoPlayer1 = !turnoPlayer1;
            // turnoPlayer2 = !turnoPlayer2;
            contador++;

        }
        
        System.out.println("\nPuntos de " + nomPlayer1 + ": " + puntosPlayer1);
        System.out.println("Puntos de " + nomPlayer2 + ": " + puntosPlayer2);

    }

    public static int Jugar(String turnojugador) {
        System.out.println(BRIGHT_MAGENTA+"\nTurno de: "+RESET + turnojugador);
        int puntos;
        int puntosTotales=0;
        boolean encesto;
        int opTiro;
        int opDefensa;
        System.out.println("\nElija un tipo de tiro");
        System.out.println("1.- Tiro largo");
        System.out.println("2.- Tiro corto");
        opTiro = Integer.valueOf(sc.nextLine());

        System.out.println("\n Rival elije una defensa:");
        System.out.println("1.- Defensa cuerpo a cuerpo");
        System.out.println("2.- Defensa fuerte");
        opDefensa = Integer.valueOf(sc.nextLine());

        encesto = calcTiro(opTiro, opDefensa);

        if (encesto) {
            puntos = (opTiro == 1) ? 3 : 2;
            puntosTotales +=puntos;
            System.out.println(GREEN+"\nHa encestado!! " +basketball+ " Suma +"+RESET + puntos + GREEN+" puntos"+RESET);
        }else{
            System.out.println(RED+"\nHa sido bloqueado!!! "+RESET+ bloqueo);
        }
            return puntosTotales;
    }

    public static int turnoRandom() {
        return rand.nextInt(2) + 1;
    }

    public static boolean calcTiro(int tiro, int defensa) {

            double probAnotar=(tiro==1)?0.65:0.8;
            double probTapar=(defensa==1)?0.15:0.3;
            
            return rand.nextDouble() < (probAnotar-probTapar);
//        double tiroFinal = tiro - defensa;
//
//        Random rand = new Random();
//
//        if (rand.nextDouble() < tiroFinal) {
//            return true;
//        } else {
//            return false;
//        }

    }

    public static int tipoDefensa(int tipo) {

        if (tipo == 1) {
            return 15;
        } else {
            return 30;
        }
    }

}
