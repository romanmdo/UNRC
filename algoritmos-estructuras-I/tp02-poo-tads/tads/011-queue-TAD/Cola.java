package _011_cola_TAD;

public interface Cola<T> {
    /**
     * Metodo encolar (Enqueue)
     * Este metodo encola un elemento a la cola
     * (agrega un elemento arriba de todo)  
    */
    void encolar(T item);

    /**
     * Metodo desencolar (Dequeue)
     * Este metodo desencola un elemento de la cola 
     * (saca el elemento que este arriba del todo) 
    */
    void desencolar();

    /**
     * Metodo esVacia (isEmpty)
     * Este metodo devuelva true si la cola esta vacia
     * false en caso de que la cola no este vacia
     * @return true = esta vacia / false = no esta vacia 
    */
    boolean esVacia();

    /**
     * Metodo vaciar (empty)
     * vacia la cola
    */
    void vaciar();

    /**
     * Metodo getCola 
     * Muestra la cola
    */
    void getCola();
}