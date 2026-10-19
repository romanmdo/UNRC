package _008_pila_TAD;

public interface Pila<T> {
    /**
     * Metodo apilar (Push)
     * Este metodo apila un elemento a la pila
     * (agrega un elemento arriba de todo)  
    */
    void apilar(T item);

    /**
     * Metodo desapilar (Pop)
     * Este metodo desapila un elemento a la pila 
     * (saca el elemento que este arriba del todo) 
    */
    void desapilar();

    /**
     * Metodo esVacia (isEmpty)
     * Este metodo devuelva true si la pila esta vacia
     * false en caso de que la pila no este vacia
     * @return true = esta vacia / false = no esta vacia 
    */
    boolean esVacia();

    /**
     * Metodo vaciar (empty)
     * vacia la pila
    */
    void vaciar();

    /**
     * Metodo getPila 
     * Devuelve la pila
    */
    void getPila();

    /**
     * Metodo tope
     * Devuelve el tope de la pila
     */
    T tope();

}