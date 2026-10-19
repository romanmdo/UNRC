public interface Cola<T> {
    void encolar(T elem);   // Agregar al final
    T desencolar();         // Sacar del frente
    T verFrente();          // Ver el primero sin sacarlo
    boolean esVacia();      // Chequear si está vacía
    int tamaño();           // Cantidad de elementos
}
