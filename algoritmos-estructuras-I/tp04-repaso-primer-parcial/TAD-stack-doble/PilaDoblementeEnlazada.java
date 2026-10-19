// Archivo: PilaDoblementeEnlazada.java
public class PilaDoblementeEnlazada<T> implements Pila<T> {

    private Nodo<T> tope;
    private int cantidad;

    public PilaDoblementeEnlazada() {
        this.tope = null;
        this.cantidad = 0;
    }

    @Override
    public void apilar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<T>(elemento);
        if(this.tope == null){
            tope = nuevoNodo;
            nuevoNodo.anterior = null;
            nuevoNodo.siguiente = null;
            this.cantidad++;
            return;
        } else {
            tope.anterior = nuevoNodo;
            nuevoNodo.siguiente = tope;
            nuevoNodo.anterior = null;
            
            tope = nuevoNodo;
            this.cantidad++;
        }
    }

    @Override
    public T desapilar() {
        if (this.esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }

        Nodo<T> aux = this.tope.siguiente;
        
        T dato = this.tope.dato;
    
        this.tope.siguiente = null;
        this.tope.anterior = null;
        this.tope = aux;    

        if(this.tope != null){
            this.tope.anterior = null;
        }
        
        this.cantidad--;
        return dato;
    }

    @Override
    public T tope() {
        return this.tope.dato;
    }

    @Override
    public boolean esVacia() {
        return this.tope == null;
    }

    @Override
    public int tamanio() {
        return cantidad;
    }
}
