/**
 * El ejercicio consistia en completar los metodos, lo que
 * habia que comentar estaba con __________________
 * asi que no hay que compilar este codigo.
 * Parcial simulacro creado por chat gpt.
*/

public class ListaEnlazada<T> implements Lista<T>{
    private Nodo <T> comienzo;
    private int cantidad;
    
    public boolean isEmpty(){
        return (this.cantidad == 0)
    }

    public void eliminarUltimo() {
        if (this.isEmpty()) {
            throw new ListaException("Lista vacía");
        }

        Nodo<T> aux = this.comienzo;
        Nodo<T> previo = null;

        while (aux.next != null) {
            previo = aux;
            aux = aux.next;
        }

        if (previo == null) {
            this.comienzo = null;
        } else {
            previo.next = null;
        }

        this.cantidad--;
    }

    public int contar(T dato) {
        int contador = 0;
        Nodo<T> aux = this.comienzo;

        while ( aux != null ) {
            if ( aux.dato.equals(dato)) {
                contador++;
            }
            aux = aux.next;
        }

        return contador;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        
        if ( this.comienzo == null ) {
            this.comienzo = nuevo;
        } else {
            nuevo.next = this.comienzo;
            this.comienzo = nuevo;
        }
        
        this.cantidad++;    
    }

    public T buscarUltimo() {
        if ( this.comienzo == null ) {
            throw new ListaException("Lista vacía");
        }
        
        Nodo<T> aux = this.comienzo;
        
        while ( aux.next != null ) {
            aux = aux.next;
        }
        
        return aux.dato;
    }


}