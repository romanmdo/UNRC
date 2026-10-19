// Interfaz del TAD Lista
public interface Lista<T> {
    boolean esVacia();
    int tamaño();
    void insertarInicio(T dato);
    void insertarFinal(T dato);
    void insertar(int pos, T dato);
    void eliminarInicio();
    void eliminarFinal();
    void eliminar(int pos);
    T obtener(int pos);
    void modificar(int pos, T dato);
    int buscar(T dato);
    void limpiar();
    void mostrar();
}
