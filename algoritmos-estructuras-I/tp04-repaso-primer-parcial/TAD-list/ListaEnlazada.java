import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Lista<T> {
    private Nodo<T> nodoCabeza;

    @Override
    public void insertarFin(T elem){
        Nodo<T> nodoNuevo = new Nodo<T>(elem);

        if(nodoCabeza == null){
            nodoCabeza = nodoNuevo;
            return;
        } else {
            Nodo<T> nodoAux = nodoCabeza;
            while(nodoAux.siguiente != null){
                nodoAux = nodoAux.siguiente;
            }
            nodoAux.siguiente = nodoNuevo;
        }
    }

    @Override 
    public void insertarInicio(T elem){
        Nodo<T> nodoNuevo = new Nodo<T>(elem);
        
        if(nodoCabeza == null){
            nodoCabeza = nodoNuevo;
            return;
        } else {
            nodoNuevo.siguiente = nodoCabeza;
            nodoCabeza = nodoNuevo;
        }
    }

    @Override
    public void insertarPos(T elem, int pos){
        throw new UnsupportedOperationException("No implementado aún");
    }

    @Override
    public T eliminarUltimo(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        if(nodoCabeza.siguiente == null){
            T dato = nodoCabeza.dato;
            nodoCabeza = null;
            return dato; 
        }

        Nodo<T> nodoAux = nodoCabeza;

        while (nodoAux.siguiente.siguiente != null){
            nodoAux = nodoAux.siguiente;
        }

        T dato = nodoAux.siguiente.dato;
        nodoAux.siguiente = null;
        return dato;
    }

    @Override
    public T eliminarPrimero(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        T dato = nodoCabeza.dato;
        nodoCabeza = nodoCabeza.siguiente;

        return dato;
    }

    @Override 
    public T eliminarPos(int pos){
        throw new UnsupportedOperationException("No implementado aún");
    }

    @Override
    public T getPrimero(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        return nodoCabeza.dato;
    }

    @Override
    public T getUltimo(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        Nodo<T> nodoAux = nodoCabeza;

        while (nodoAux.siguiente != null) {
            nodoAux = nodoAux.siguiente;
        }

        return nodoAux.dato;
    }

    @Override 
    public T getPos(int pos){
        if (pos < 0) throw new IndexOutOfBoundsException();
    
        Nodo<T> nodoAux = nodoCabeza;
        int contador = 0;

        while (nodoAux != null) {
            if(contador == pos){
                return nodoAux.dato;
            } contador++;
            nodoAux = nodoAux.siguiente;
        }

        return null;
    }

    public int longitud(){
        Nodo<T> nodoAux = nodoCabeza;
        int contador = 0;

        while (nodoAux != null) {
            nodoAux = nodoAux.siguiente;
            contador++;
        }

        return contador;
    }

    public boolean esVacia(){
        return nodoCabeza == null;
    }

    public int buscar(T item){
        Nodo<T> nodoAux = nodoCabeza;
        int pos = 0;

        while (nodoAux != null) {
            if(nodoAux.dato.equals(item)){
                return pos;                  
            } pos++;
            nodoAux = nodoAux.siguiente;
        }

        return -1;
    }

    public void imprimir(){
        
    }
}