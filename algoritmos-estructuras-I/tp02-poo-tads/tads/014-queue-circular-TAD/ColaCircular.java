package _014_cola_circular_TAD;

public interface ColaCircular {
    /**
     * Metodo encolar (Enqueue)
     * Este metodo encola un elemento a la cola
     * (agrega un elemento arriba de todo)  
    */
    void encolar(int item);

    /**
     * Metodo desencolar (Dequeue)
     * Este metodo desencola un elemento de la cola 
     * (saca el elemento que este arriba del todo) 
    */
    void desencolar();

    /**
     * Metodo estaLlena (isFull)
     * Este metodo devuelva true si la cola circular esta llena
     * false en caso de que la cola circular no este llena
     * @return true = esta llena / false = no esta llena 
    */
    boolean estaLlena();

    /**
     * Metodo estaVacia (isEmpty)
     * Este metodo devuelva true si la cola circular esta vacia
     * false en caso de que la cola circular no este vacia
     * @return true = esta vacia / false = no esta vacia 
    */
    boolean estaVacia();

    /**
     * Metodo getCola 
     * Muestra la cola
    */
    void getCola();
}