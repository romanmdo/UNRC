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

        if ( nodoTope == null ) // pila vacía
            nodoTope = nuevo;
        else {
            nuevo.siguiente = nodoTope; // nuevo.siguiente apunta al tope actual
            nodoTope.anterior = nuevo; // tope anterior apunta al nuevo
            nodoTope = nuevo; // actualizar nodoTope
        }
        cantidad++;
    }

    @Override
    public T desapilar() {
        if ( nodoTope == null ) // pila vacía
            throw new RuntimeException("Pila vacía");

        T dato = nodoTope.dato; // guardar dato del nodoTope
        nodoTope = nodoTope.siguiente; // actualizar nodoTope
        if ( nodoTope != null ) // si nodoTope no es null
            nodoTope.anterior = null; // limpiar puntero anterior
        cantidad--;
        return dato;
    }
}
