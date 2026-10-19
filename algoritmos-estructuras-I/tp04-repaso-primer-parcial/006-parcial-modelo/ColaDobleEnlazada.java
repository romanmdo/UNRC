public class ColaDobleEnlazada<T> implements Cola<T> {

    private NodoD<T> frente;
    private NodoD<T> fin;
    private int cantidad;

    public ColaDobleEnlazada() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    @Override
    public void encolar(T dato) {
        NodoD<T> nuevo = new NodoD<>(dato);

        if ( this.esVacia() ) { // si la cola está vacía
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo; // enlazar fin con nuevo
            nuevo.anterior = fin; // actualizar puntero anterior del nuevo
            fin = nuevo; // mover fin al nuevo nodo
        }
        cantidad++;
    }

    @Override
    public T desencolar() {
        if ( this.esVacia() ) // si está vacía
            throw new RuntimeException("Cola vacía");

        T dato = frente.dato; // guardar el dato del frente
        frente = frente.siguiente; // mover frente al siguiente
        if ( frente == null ) // si ahora frente es null
            fin = null;
        else
            frente.anterior = null; // quitar referencia al nodo anterior

        cantidad--;
        return dato;
    }

    @Override
    public T frente() {
        if ( this.esVacia() ) // cola vacía
            throw new RuntimeException("Cola vacía");

        return frente.dato; // devolver dato del frente
    }

    @Override
    public boolean esVacia() {
        return frente == null; // condición de vacío
    }

    @Override
    public void mostrar() {
        NodoD<T> aux = frente;
        while ( aux != null ) { // recorrer hasta null
            System.out.print( au + " ");
            aux = aux.siguiente; // avanzar al siguiente
        }
        System.out.println();
    }
}
