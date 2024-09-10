/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modificarcadena;

/**
 *
 * @author Juan David Ruiz Gomez -  Elkin Santiago Ruiz Rodriguez
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ModificarCadena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Paso 1: Leer una línea de caracteres del usuario
        System.out.println("Ingrese una línea de texto: ");
        String linea = scanner.nextLine();
        
        // Paso 2: Encontrar el carácter que más se repite
        char caracterMasRepetido = encontrarCaracterMasRepetido(linea);
        System.out.println("Carácter que más se repite: " + caracterMasRepetido);
        
        // Paso 3: Reemplazar vocales por el carácter más repetido
        String lineaModificada = reemplazarVocales(linea, caracterMasRepetido);
        System.out.println("Línea modificada con vocales reemplazadas: " + lineaModificada);
        
        // Paso 4: Invertir la línea
        String lineaInvertida = invertirLinea(lineaModificada);
        System.out.println("Línea invertida: " + lineaInvertida);
        
        scanner.close();
    }

    // Función para encontrar el carácter que más veces se repite
    public static char encontrarCaracterMasRepetido(String linea) {
        HashMap<Character, Integer> frecuencia = new HashMap<>();
        
        for (char c : linea.toCharArray()) {
            if (c != ' ') { // Ignorar espacios
                frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
            }
        }
        char maxChar = linea.charAt(0);
        int maxFrecuencia = 0;
       
        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxChar = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }
       
        return maxChar;
    }

    // Función para reemplazar las vocales con el carácter más repetido
    public static String reemplazarVocales(String linea, char caracter) {
        return linea.replaceAll("[aeiouAEIOU]", String.valueOf(caracter));
    }

    // Función para invertir la línea de caracteres
    public static String invertirLinea(String linea) {
        StringBuilder sb = new StringBuilder(linea);
        return sb.reverse().toString();
    }
}

    
