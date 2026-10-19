import java.util.NoSuchElementException;

public class ColaEnlazada<T> implements Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int cantidad;

    public ColaEnlazada() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    @Override
    public void encolar(T elem) {
        Nodo<T> nodoNuevo = new Nodo<T>(elem);
        nodoNuevo.siguiente = null;
        
        if (this.frente == null) {
            frente = nodoNuevo;
            fin = nodoNuevo;
        } else{
            fin.siguiente = nodoNuevo;
            fin = nodoNuevo;
        }

        cantidad++;
    }

    @Override
    public T desencolar() {
        if (this.frente == null) {
            throw new NoSuchElementException("La cola está vacía");
        } 

        T dato = frente.dato;
        frente = frente.siguiente;
        
        cantidad--;
        return dato;
    }

    @Override
    public T verFrente() {
        if (this.frente == null) {
            throw new NoSuchElementException("La cola está vacía");
        } 
        return frente.dato;
    }

    @Override
    public boolean esVacia() {
        return this.frente == null;
    }

    @Override
    public int tamaño() {
        return cantidad;
    }
}
