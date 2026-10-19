public interface ColaCircular<T> {
    boolean esVacia();
    boolean esLlena();
    int tamaño();
    void encolar(T dato);
    T desencolar();
    T frente();
    void limpiar();
    void mostrar();
}
