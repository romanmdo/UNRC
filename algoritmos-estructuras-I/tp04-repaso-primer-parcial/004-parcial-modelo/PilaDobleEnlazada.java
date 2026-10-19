// Pila doblemente enlazada (esqueleto parcial)
public class PilaDobleEnlazada<T> implements Pila<T> {

    private NodoD<T> nodoTope;
    private int cantidad;

    public PilaDobleEnlazada() {
        nodoTope = null;
        cantidad = 0;
    }

    @Override
    public void apilar(T dato) {
        NodoD<T> nuevo = new NodoD<>(dato);
        if (this.esVacia()) // pila vacía
            nodoTope = nuevo;
        else {
            nuevo.siguiente = nodoTope; // enlazar nuevo con nodoTope
            nodoTope = nuevo; // actualizar nodoTope
        }
        cantidad++;
    }

    @Override
    public T desapilar() {
        if (this.esVacia()) // pila vacía
            throw new RuntimeException("Pila vacía");

        T dato = nodoTope.dato; // obtener dato de nodoTope
        nodoTope = null; // actualizar nodoTope
        cantidad--;
        return dato;
    }

    @Override
    public T tope() {
        if (this.esVacia()) // pila vacía
            throw new RuntimeException("Pila vacía");

        return nodoTope.dato; // retornar dato de nodoTope
    }

    @Override
    public boolean esVacia() {
        return nodoTope == null; // condición pila vacía
    }

    @Override
    public void mostrar() {
        NodoD<T> aux = nodoTope;
        while ( aux.siguiente != null ) { // recorrer hasta null
            System.out.print( aux.dato + " ");
            aux = aux.siguiente; // avanzar
        }
        System.out.println();
    }
}
