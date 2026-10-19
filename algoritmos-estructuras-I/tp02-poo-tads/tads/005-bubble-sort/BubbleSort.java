package _005_buble_sort;

import java.util.ArrayList;

public class BubbleSort {

    public static void bubbleSort(ArrayList<Integer> lista) {
        boolean swapped;

        for (int i = 0; i < lista.size() - 1; i++) {
            swapped = false;

            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        System.out.println("# Lista ordenada: " + lista);
        
    }
}