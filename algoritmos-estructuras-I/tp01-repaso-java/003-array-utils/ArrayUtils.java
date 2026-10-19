/**
 * Clase ArrayUtils: contiene implementaciones de rutinas fundamentales
 * sobre arreglos.
 * 
 * @author N. Aguirre
 * @version 0.1
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class ArrayUtils
{
    
    /**
     * Comprueba si un elemento (entero) pertenece a un arreglo.
     */
    public boolean pertenece(int elem, int[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("# Arreglo nulo");
        
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elem) {
                System.out.println("# El elemento pertenece al arreglo");
                return true;
            }
        }

        System.out.println("# El elemento no pertenece al arreglo");
        return false;
    }
    
    /**
     * Calcula la suma de los elementos de un arreglo de enteros
     */
    public int suma(int[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("# Arreglo nulo");

        int sumaElementos = 0;
        for (int i = 0; i < arreglo.length; i++) {
            sumaElementos += arreglo[i];
        }
        
        System.out.println("# La suma de todos los elementos del arreglo da: " + sumaElementos);
        return sumaElementos;
    }
    
    /**
     * Calcula el valor mínimo de un arreglo de reales
     */
    public float minimo(float[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("# Arreglo nulo");
        
        float valorMinimo = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < valorMinimo) {
                valorMinimo = arreglo[i];
            }
        }
        
        System.out.println("# El valor minimo del arreglo es: " + valorMinimo );
        return valorMinimo;
    }
    
    /**
     * Calcula el valor máximo de un arreglo de reales
     */
    public float maximo(float[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("# Arreglo nulo");
        
        float valorMaximo = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > valorMaximo) {
                valorMaximo = arreglo[i];
            }
        }
        
        System.out.println("# El valor minimo del arreglo es: " + valorMaximo );
        return valorMaximo;
    }
    
    /**
     * Calcula el valor promedio de un arreglo de reales
     */
    public float promedio(float[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("# Arreglo nulo");

        int contador = 0;
        int suma = 0;
        int promedio = 0;

        for (int i = 0; i < arreglo.length; i++) {
            contador += 1;
            suma += arreglo[i];
        }
        
        promedio = suma / contador;
        System.out.println("# El promedio del arreglo es: " + promedio );
        return promedio;
    }
    
    /**
     * Retorna un arreglo con los primeros n números de Fibonacci
     */
    public int[] fibSequence(int n) {
        if (n <= 0) {
            return new int[0]; // arreglo vacío
        }
    
        int[] fib = new int[n];
    
        // Casos base
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
        }
    
        // Llenamos el resto del arreglo
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    
        return fib;
    }

    
    /**
     * Calcula la mediana de un arreglo de reales
     */
    public float mediana(float[] arreglo) {
        ArrayList<Float> ordenados = new ArrayList<>();

        // Copiar los elementos del arreglo a la lista
        for (float num : arreglo) {
            ordenados.add(num);
        }

        // Ordenar la lista
        Collections.sort(ordenados);

        int n = ordenados.size();

        if (n % 2 == 0) {
            // Si es par: promedio de los dos valores centrales
            float medio1 = ordenados.get(n / 2 - 1);
            float medio2 = ordenados.get(n / 2);
            return (medio1 + medio2) / 2.0f;
        } else {
            // Si es impar: valor central
            return ordenados.get(n / 2);
        }
    }

    /**
     * Comprueba si dos arreglos de enteros son iguales
     */
    public boolean iguales(int[] arr1, int[] arr2) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(); 
        
        for(int i: arr1)
        {
            array1.add(i);
        }
        
        for(int j: arr2)
        {
            array2.add(j);
        }
        
        Collections.sort(array1);
        Collections.sort(array2);
        
        int n = array1.size();
        int m = array2.size();
        
        if(n == m)
        {
            for(int i = 0; i < array1.size(); i++)
            {
                int valor1 = array1.get(i);
                int valor2 = array2.get(i);
                
                if(valor1 != valor2){
                    System.out.println("# Los arreglos son distintos");
                    return false;
                }
            }
            System.out.println("# Los arreglos son iguales");
            return true;
        } else
        {
            System.out.println("# Los arreglos son distintos");
            return false;
        }
    }
    
    /**
     * Comprueba si un arreglo tiene valores repetidos
     */
    public boolean tieneRepetidos(int[] arreglo) {
        Arrays.sort(arreglo);

        for(int i = 0; i < arreglo.length - 1; i++) {
            int actual = arreglo[i];
            int siguiente = arreglo[i + 1];

            if(actual == siguiente) {
                System.out.println("# Repetidos");
                return true;
            } else {
                System.out.println("# No repetidos");
                return false;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si un arreglo tiene dos valores cuya suma dé cero.
     */
    public boolean tieneOpuestos(float[] arreglo) {
        ArrayList<Float> listaNegativos = new ArrayList<>();
        ArrayList<Float> listaPositivos = new ArrayList<>(); 

        for(int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] > 0) {
                listaPositivos.add(arreglo[i]);
            } else {
                listaNegativos.add(arreglo[i]);
            } 
        }

        Collections.sort(listaNegativos, Collections.reverseOrder());
        Collections.sort(listaPositivos);

        for(int i = 0; i < listaPositivos.size(); i++) {
            for (int j = 0; j < listaNegativos.size(); j++) {
                if(listaPositivos.get(i) + listaNegativos.get(j) == 0 || listaNegativos.get(j) + listaPositivos.get(i) == 0){
                    System.out.println("# Hay opuestos");
                    return true;
                }
            }
        }

        System.out.println("# No hay opuestos");
        return false;
    }
    
}
