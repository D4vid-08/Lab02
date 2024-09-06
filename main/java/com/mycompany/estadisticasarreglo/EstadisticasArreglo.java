/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estadisticasarreglo;

import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author juan david ruiz gomez, elkin santiago ruiz rodriguez
 */
public class EstadisticasArreglo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Paso 1: Solicitar tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();
        
        double[] arreglo = new double[n];
        Random random = new Random();
        
        // Llenar el arreglo con números aleatorios
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextDouble() * 100;  // Números aleatorios entre 0 y 100
        }
        
        // Imprimir el arreglo generado
        System.out.println("Arreglo generado: " + Arrays.toString(arreglo));
        
        // Calcular media
        double media = calcularMedia(arreglo);
        System.out.println("Media: " + media);
        
        // Calcular mediana
        double mediana = calcularMediana(arreglo);
        System.out.println("Mediana: " + mediana);
        
        // Calcular varianza
        double varianza = calcularVarianza(arreglo, media);
        System.out.println("Varianza: " + varianza);
        
        // Calcular desviación estándar
        double desviacionEstandar = Math.sqrt(varianza);
        System.out.println("Desviación Estándar: " + desviacionEstandar);
        
        // Calcular moda
        double moda = calcularModa(arreglo);
        System.out.println("Moda: " + moda);
        
        scanner.close();
    }
    
    // Función para calcular la media
    public static double calcularMedia(double[] arreglo) {
        double suma = 0;
        for (double num : arreglo) {
            suma += num;
        }
        return suma / arreglo.length;
    }
    
    // Función para calcular la mediana
    public static double calcularMediana(double[] arreglo) {
        Arrays.sort(arreglo);
        int n = arreglo.length;
        if (n % 2 == 0) {
            return (arreglo[n / 2 - 1] + arreglo[n / 2]) / 2;
        } else {
            return arreglo[n / 2];
        }
    }
    
    // Función para calcular la varianza
    public static double calcularVarianza(double[] arreglo, double media) {
        double suma = 0;
        for (double num : arreglo) {
            suma += Math.pow(num - media, 2);
        }
        return suma / arreglo.length;
    }

    private static double calcularModa(double[] arreglo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    


