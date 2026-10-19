import java.util.NoSuchElementException;

public class PilaEnlazada<T> implements Pila<T> {
    private Nodo<T> nodoTope;   // Referencia al tope de la pila
    private int cantidad;

    public PilaEnlazada() {
        nodoTope = null;
        cantidad = 0;
    }

    @Override
    public void apilar(T elem) {
        Nodo<T> nodoNuevo = new Nodo<T>(elem);

        nodoNuevo.siguiente = nodoTope;
        nodoTope = nodoNuevo;
        
        cantidad++;
    }

    @Override
    public T desapilar() {
        if(nodoTope == null){
            throw new NoSuchElementException("La pila está vacía");
        }

        T dato = nodoTope.dato;

        nodoTope = nodoTope.siguiente;

        cantidad--;
        return dato;
    }

    @Override
    public T verTope() {
        return nodoTope.dato;
    }

    @Override
    public boolean esVacia() {
        return nodoTope == null;
    }

    @Override
    public int tamaño() {
        return cantidad;
    }
}
