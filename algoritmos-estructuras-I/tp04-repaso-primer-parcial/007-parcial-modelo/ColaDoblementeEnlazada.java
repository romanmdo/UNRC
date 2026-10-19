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

        if ( frente == null ) { // cola vacía
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo; // enlazar fin con nuevo
            nuevo.anterior = fin; // enlazar nuevo con fin
            fin = nuevo; // mover fin al nuevo nodo
        }
        cantidad++;
    }

    @Override
    public T desencolar() {
        if ( frente == null ) // cola vacía
            throw new RuntimeException("Cola vacía");

        T dato = frente.dato; // guardar dato del frente
        frente = frente.siguiente; // mover frente al siguiente
        if ( frente == null ) // si frente es null
            fin = null; // fin también es null
        else
            frente.anterior = null; // limpiar anterior del nuevo frente
        cantidad--;
        return dato;
    }
}
