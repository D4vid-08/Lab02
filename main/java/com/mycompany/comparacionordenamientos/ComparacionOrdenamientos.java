/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comparacionordenamientos;


/**
 *
 * @author juand
 */
  import java.util.Arrays;
import java.util.Random;

public class ComparacionOrdenamientos {

    public static void main(String[] args) {
        int[] tamaños = {100, 500, 1000, 5000, 10000};
        System.out.println("Tamaños de arreglo: " + Arrays.toString(tamaños));

        // Para cada tamaño de arreglo
        for (int n : tamaños) {
            System.out.println("\nTamaño del arreglo: " + n);
            
            double[] arregloOriginal = generarArregloAleatorio(n);
            
            // Bubble sort
            double[] arregloBurbuja = arregloOriginal.clone();
            long inicio = System.nanoTime();
            bubbleSort(arregloBurbuja);
            long tiempoBurbuja = System.nanoTime() - inicio;
            System.out.println("Tiempo Bubble Sort: " + tiempoBurbuja / 1e6 + " ms");
            
            // Insertion sort
            double[] arregloInsercion = arregloOriginal.clone();
            inicio = System.nanoTime();
            insertionSort(arregloInsercion);
            long tiempoInsercion = System.nanoTime() - inicio;
            System.out.println("Tiempo Insertion Sort: " + tiempoInsercion / 1e6 + " ms");
            
            // Selection sort
            double[] arregloSeleccion = arregloOriginal.clone();
            inicio = System.nanoTime();
            selectionSort(arregloSeleccion);
            long tiempoSeleccion = System.nanoTime() - inicio;
            System.out.println("Tiempo Selection Sort: " + tiempoSeleccion / 1e6 + " ms");
            
            // Merge sort
            double[] arregloMerge = arregloOriginal.clone();
            inicio = System.nanoTime();
            mergeSort(arregloMerge, 0, n - 1);
            long tiempoMerge = System.nanoTime() - inicio;
            System.out.println("Tiempo Merge Sort: " + tiempoMerge / 1e6 + " ms");
        }
    }

    // Generar un arreglo de números aleatorios tipo double
    public static double[] generarArregloAleatorio(int n) {
        Random random = new Random();
        double[] arreglo = new double[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextDouble() * 1000;  // Números aleatorios entre 0 y 1000
        }
        return arreglo;
    }

    // Bubble Sort
    public static void bubbleSort(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; ++i) {
            double key = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[min_idx]) {
                    min_idx = j;
                }
            }
            double temp = arreglo[min_idx];
            arreglo[min_idx] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    // Merge Sort
    public static void mergeSort(double[] arreglo, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arreglo, l, m);
            mergeSort(arreglo, m + 1, r);
            merge(arreglo, l, m, r);
        }
    }

    public static void merge(double[] arreglo, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        double[] L = new double[n1];
        double[] R = new double[n2];
        
        for (int i = 0; i < n1; ++i) {
            L[i] = arreglo[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arreglo[m + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }
}

