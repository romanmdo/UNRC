public interface Pila<T> {
    void apilar(T elem);       // Push: agregar al tope
    T desapilar();             // Pop: sacar del tope
    T verTope();               // Peek: ver el elemento del tope sin sacarlo
    boolean esVacia();         // Chequear si la pila está vacía
    int tamaño();              // Cantidad de elementos
}
