public interface Pila<T> {

    // Inserta un elemento en el tope de la pila
    void apilar(T elemento);

    // Elimina el elemento del tope
    T desapilar();

    // Devuelve el elemento del tope sin eliminarlo
    T tope();

    // Verifica si la pila está vacía
    boolean esVacia();

    // Devuelve la cantidad de elementos en la pila
    int tamanio();
}
