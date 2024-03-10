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

public class Ahorcado {
     private String palabraSecreta;
    private StringBuilder palabraActual;
    private int intentosMaximos;
    private int intentosRestantes;

    /**
     * Constructor de la clase Ahorcado.
     * 
     * @param palabraSecreta La palabra secreta a adivinar.
     * @param intentosMaximos El número máximo de intentos permitidos.
     */
    public Ahorcado(String palabraSecreta, int intentosMaximos) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.intentosMaximos = intentosMaximos;
        this.intentosRestantes = intentosMaximos;
        this.palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
    }

    /**
     * Método para realizar un intento de adivinar una letra.
     * 
     * @param letra La letra a intentar adivinar.
     * @return true si la letra es correcta, false si no.
     */
    public boolean intento(char letra) {
        letra = Character.toUpperCase(letra);
        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraActual.setCharAt(i, letra);
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
        }

        return acierto;
    }

    /**
     * Método que indica si el jugador ha perdido el juego.
     * 
     * @return true si el jugador ha perdido, false si no.
     */
    public boolean haPerdido() {
        return intentosRestantes == 0;
    }

    /**
     * Método que indica si el jugador ha ganado el juego.
     * 
     * @return true si el jugador ha ganado, false si no.
     */
    public boolean haGanado() {
        return palabraActual.indexOf("_") == -1;
    }

    /**
     * Método que devuelve la palabra actual, con las letras adivinadas.
     * 
     * @return La palabra actual.
     */
    public String getPalabraActual() {
        return palabraActual.toString();
    }

    /**
     * Método que devuelve el número de intentos restantes.
     * 
     * @return El número de intentos restantes.
     */
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    /**
     * Método que proporciona una pista sobre la longitud de la palabra secreta.
     * 
     * @return Un mensaje de pista.
     */
    public String getMensajePista() {
        int longitud = palabraSecreta.length();

        if (longitud >= 5) {
            return "La palabra secreta tiene " + longitud + " letras.";
        } else {
            return "La palabra secreta es corta.";
        }
    }
}
