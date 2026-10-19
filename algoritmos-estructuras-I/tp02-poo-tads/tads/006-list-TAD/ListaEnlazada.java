package _006_lista_TAD;

import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Lista<T> {
    private Nodo<T> nodoCabeza;

    /**
     * Metodo set
     * Inserta un elemento generico de tipo T 
     * al final de la lista
     * 
     * @param un elemento de tipo T
    */
    @Override
    public void insertarFin(T elem){
        Nodo<T> nodoNuevo = new Nodo<T>(elem);
        Nodo<T> punteroAuxiliar = nodoCabeza;
        
        if(nodoCabeza == null){
            nodoCabeza = nodoNuevo;
            return;
        }
        
        while (punteroAuxiliar.siguiente != null) {
            punteroAuxiliar = punteroAuxiliar.siguiente;
        }

        punteroAuxiliar.siguiente = nodoNuevo;
    }

    /**
     * Metodo set
     * Inserta un elemento generico de tipo T
     * al inicio de la lista
     * 
     * @param un elemento de tipo T
    */
    @Override
    public void insertarInicio(T elem){
        Nodo<T> nodoNuevo = new Nodo<T>(elem);
        nodoNuevo.siguiente = nodoCabeza;
        nodoCabeza = nodoNuevo; 
    }

    /**
     * Metodo set
     * Inserta un elemento generico de tipo T
     * en la posicion que ingresa el usuario
     * 
     * @param un elemento de tipo T
     * @param la posicion en entero
    */
    @Override
    public void insertarPos(T elem, int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Posición negativa");
        }

        Nodo<T> nodoNuevo = new Nodo<>(elem);

        // Insertar al inicio
        if (pos == 0) {
            nodoNuevo.siguiente = nodoCabeza;
            nodoCabeza = nodoNuevo;
            return;
        }

        Nodo<T> nodoAuxiliar = nodoCabeza;
        int index = 0;

        // Recorrer hasta la posición anterior
        while (nodoAuxiliar != null && index < pos - 1) {
            nodoAuxiliar = nodoAuxiliar.siguiente;
            index++;
        }

        if (nodoAuxiliar == null) {
            throw new IndexOutOfBoundsException("Posición mayor a la longitud de la lista");
        }

        // Insertar el nuevo nodo
        nodoNuevo.siguiente = nodoAuxiliar.siguiente;
        nodoAuxiliar.siguiente = nodoNuevo;
    }


    /**
     * Metodo set
     * Elimina el ultimo elemento de la lista
     * 
     * @return campo dato del nodo eliminado
    */
    @Override
    public T eliminarUltimo() {
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        if (nodoCabeza.siguiente == null) {
            T dato = nodoCabeza.dato;
            nodoCabeza = null;
            return dato;
        }

        Nodo<T> nodoAuxiliar = nodoCabeza;
        while (nodoAuxiliar.siguiente.siguiente != null) {
            nodoAuxiliar = nodoAuxiliar.siguiente;
        }

        T dato = nodoAuxiliar.siguiente.dato;
        nodoAuxiliar.siguiente = null; 
        return dato;
    }

    /**
     * Metodo set
     * Elimina el ultimo elemento de la lista
     * 
     * @return campo dato del nodo eliminado
    */
    @Override
    public T eliminarPrimero(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        Nodo<T> nodoAuxiliar;
        nodoAuxiliar = nodoCabeza;
        nodoCabeza = nodoCabeza.siguiente;
        
        return nodoAuxiliar.dato;
    }

    /**
     * Metodo set
     * Elimina un elemento de la lista
     * dependiendo la posicion ingresada por el usuario
     * 
     * @param pos la cual es un tipo int
     * @return campo dato del nodo eliminado
    */
    @Override 
    public T eliminarPos(int pos){
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Posición negativa");
        }

        if (nodoCabeza == null) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }

        if (pos == 0) {
            T dato = nodoCabeza.dato;       // Guardás el dato a devolver
            nodoCabeza = nodoCabeza.siguiente; // La cabeza apunta al siguiente nodo
            return dato;
        }

        Nodo<T> nodoAuxiliarActual = nodoCabeza;
        Nodo<T> nodoAuxiliarAnterior = nodoCabeza;

        int index = 1;

        while (nodoAuxiliarActual != null) {
            if(index == pos){
               nodoAuxiliarAnterior.siguiente = nodoAuxiliarActual.siguiente;
               return nodoAuxiliarActual.dato;
            }  
            nodoAuxiliarAnterior = nodoAuxiliarActual;
            nodoAuxiliarActual = nodoAuxiliarActual.siguiente;
            index++;
        }
        throw new IndexOutOfBoundsException("Posición mayor a la longitud de la lista");
    }

    /**
     * Metodo get
     * retorna el primer elemento de la lista
     * 
     * @return dato del primer elemento
    */
    @Override
    public T getPrimero(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        Nodo<T> nodoAuxiliar;
        nodoAuxiliar = nodoCabeza;

        return nodoAuxiliar.dato;
    }

    /**
     * Metodo get
     * retorna el ultimo elemento de la lista
     * 
     * @return dato del ultimo elemento
    */
    @Override
    public T getUltimo(){
        if (nodoCabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        Nodo<T> nodoAuxiliar;
        nodoAuxiliar = nodoCabeza;

        while (nodoAuxiliar.siguiente != null) {
            nodoAuxiliar = nodoAuxiliar.siguiente;
        }
        
        return nodoAuxiliar.dato;
    }

    /**
     * Metodo get
     * retorna el elemento en la posicion
     * ingresada por el usuario
     * 
     * @return dato del elemento
    */
    @Override
    public T getPos(int pos){
        Nodo<T> nodoAuxiliar = nodoCabeza;
        
        int index = 0;

        while (nodoAuxiliar != null) {
            if(index == pos){
                return nodoAuxiliar.dato;
            } 
            nodoAuxiliar = nodoAuxiliar.siguiente;
            index++;
        }

        throw new IndexOutOfBoundsException("Posición inválida");
    }

    /**
     * Metodo get
     * retorna la lista
    */
    @Override
    public void imprimir() {
        Nodo<T> nodoAuxiliar = nodoCabeza;

        while (nodoAuxiliar != null) {
            String siguiente = (nodoAuxiliar.siguiente != null) ? nodoAuxiliar.siguiente.dato.toString() : "null";
            System.out.println("Nodo: " + nodoAuxiliar.dato + " | Siguiente nodo: " + siguiente);

            nodoAuxiliar = nodoAuxiliar.siguiente; 
        }
    }

    /**
     * Metodo get
     * retorna la longitud de la lista
     * 
     * @return longitud de la lista
    */
    @Override
    public int longitud(){
        Nodo<T> nodoAuxiliar;
        nodoAuxiliar = nodoCabeza;
        int contador = 0;

        while (nodoAuxiliar != null) {
            contador++;
            nodoAuxiliar = nodoAuxiliar.siguiente;
        }
        
        return contador;
    }

    /**
     * Metodo get
     * comprueba si la lista esta vacia
     * 
     * @return valor de verdad acerca del tamaño de la lista
    */
    @Override
    public boolean esVacia(){
        if(nodoCabeza == null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo get
     * busca un elemento de la lista
     * 
     * @return valor del indice donde se encuentra el elemento 
     * de la lista
    */
    @Override
    public int buscar(T item){
        Nodo<T> nodoAuxiliar = nodoCabeza;
        
        int index = 0;

        while (nodoAuxiliar != null) {
            if(nodoAuxiliar.dato.equals(item)){
                return index;
            } 
            nodoAuxiliar = nodoAuxiliar.siguiente;
            index++;
        }

        return -1;
    }
}