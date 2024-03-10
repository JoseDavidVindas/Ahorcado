/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Jose
 */
/**
 *
 * 
 */
/**
 * Clase principal que contiene el método main para ejecutar el juego.
 */
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Juego del Ahorcado.");
        System.out.print("Ingresa la palabra secreta: ");
        String palabraSecreta = scanner.nextLine();

        System.out.print("Ingresa el número máximo de intentos: ");
        int intentosMaximos = Integer.parseInt(scanner.nextLine());

        Ahorcado juego = new Ahorcado(palabraSecreta, intentosMaximos);

        while (!juego.haPerdido() && !juego.haGanado()) {
            System.out.println("\nPalabra actual: " + juego.getPalabraActual());
            System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
            System.out.println("Pista: " + juego.getMensajePista());

            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            if (juego.intento(letra)) {
                System.out.println("¡Acierto!");
            } else {
                System.out.println("¡Error! Te estás acercando a la muerte...");
            }
        }

        if (juego.haGanado()) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + juego.getPalabraActual());
        } else {
            System.out.println("\nHas perdido. La palabra era: " + palabraSecreta);
        }
    }
    
}
