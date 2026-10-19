public class Nodo<T>{
	T dato;
    Nodo<T> siguiente;

    public Nodo(T informacion) {
        this.dato = informacion;
        this.siguiente = null;
    }
}