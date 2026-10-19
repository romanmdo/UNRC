public class ArrayUtilsTest{
    public static void main(String[] args) {
        ArrayUtils a1 = new ArrayUtils();

        // Algoritmos de arreglos basicos
        a1.pertenece(1, new int[]{1, 2, 3, 4, 5});
        a1.suma(new int[]{1, 2, 3, 4, 5});
        a1.minimo(new float[]{-1 , 1, 2, 3, 4, 5});
        a1.maximo(new float[]{1, 2, 3, 4, 5, 6, 100, -1, 1000});
        a1.promedio(new float[]{1, 2, 3, 4, 5});


        // Algoritmos de arreglos tryhards
        a1.fibSequence(0);
        a1.mediana(new float[]{1, 2, 3, 4, 5});
        a1.iguales(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        a1.tieneRepetidos(new int[]{1, 2, 5, 3});
        a1.tieneOpuestos(new float[]{1, 2, 3, 4, 5});
    }
}
