package _006_lista_TAD;

public class ListaArreglo<T> implements Lista<T> {
    public static final int MAX_LISTA = 5; // Capacidad maxima del arreglo
    private int tamanio = 0; // Elementos en el arreglo
    private T[] items; // Arreglo de elementos genericos
    
    /**
     * Metodo constructor
     * constructor de la implementacion del TAD Lista 
     * con arreglos
    */
    @SuppressWarnings("unchecked")
    public ListaArreglo(){
        items = (T[]) new Object[MAX_LISTA];
    }

    /**
     * Metodo set
     * Inserta un elemento generico de tipo T 
     * al final de la lista
     * 
     * @param un elemento de tipo T
    */
    @Override
    public void insertarFin(T item){
        if (tamanio == MAX_LISTA) {
            throw new RuntimeException("La lista está llena");
        }

        items[tamanio] = item;
        tamanio++;
    }

    /**
     * Metodo set
     * Inserta un elemento generico de tipo T
     * al inicio de la lista
     * 
     * @param un elemento de tipo T
    */
    @Override
    public void insertarInicio(T item) {
        if (tamanio == MAX_LISTA) {
            throw new RuntimeException("La lista está llena");
        }

        for (int i = tamanio; i > 0; i--) {
            items[i] = items[i - 1];
        }

        items[0] = item;
        tamanio++;
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
    public void insertarPos(T item, int pos){
        if (tamanio == MAX_LISTA) {
            throw new RuntimeException("La lista está llena");
        }
        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        for (int i = tamanio; i > 0; i--) {
            items[i] = items[i + 1];
        }

        items[pos] = item;
        tamanio++;     
    }

    /**
     * Metodo set
     * Elimina el ultimo elemento de la lista
     * 
     * @return campo dato del nodo eliminado
    */
    @Override
    public T eliminarUltimo(){
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }

        T itemEliminado = items[tamanio];
        items[tamanio] = null;

        tamanio--;
        return itemEliminado;
    }

    /**
     * Metodo set
     * Elimina el ultimo elemento de la lista
     * 
     * @return campo dato del nodo eliminado
    */
    @Override
    public T eliminarPrimero(){
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }

        T itemEliminado = items[0];
        
        for (int i = 0; i < items.length; i++)  {
            items[i] = items[i + 1];

        }

        return itemEliminado;
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
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }   
        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        T itemEliminado = items[pos];
        
        for (int i = pos; i < tamanio - 1; i++) {
            items[i] = items[i + 1];
        }

        return itemEliminado;
    }

    /**
     * Metodo get
     * retorna el primer elemento de la lista
     * 
     * @return dato del primer elemento
    */
    @Override
    public T getPrimero(){
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }
        return items[0];
    }

    /**
     * Metodo get
     * retorna el ultimo elemento de la lista
     * 
     * @return dato del ultimo elemento
    */
    @Override
    public T getUltimo(){
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }
        return items[MAX_LISTA - 1];
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
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }
        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        return items[pos];
    }

    /**
     * Metodo get
     * retorna la lista
    */
    @Override
    public void imprimir(){
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }
            
        for(int i = 0; i < tamanio; i++){
            System.out.println("# Item: " + items[i] + " pos: " + i);
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
        return tamanio;
    }

    /**
     * Metodo get
     * comprueba si la lista esta vacia
     * 
     * @return valor de verdad acerca del tamaño de la lista
    */
    @Override
    public boolean esVacia(){
        if(tamanio > 0){
            return false;
        } else {
            return true;
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
        if (tamanio == 0) {
            throw new RuntimeException("La lista está vacía");
        }

        if (item == null) {
            throw new RuntimeException("El item no puede ser 'null' ");
        }

        for(int i = 0; i < tamanio; i++){
            if(item.equals(items[i])){
                return i;
            }
        }
        return -1;
    }
}