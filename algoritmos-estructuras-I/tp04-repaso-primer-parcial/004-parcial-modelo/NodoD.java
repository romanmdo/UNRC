class NodoD<T> {
    T dato;
    NodoD<T> siguiente;
    NodoD<T> anterior;

    public NodoD(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}