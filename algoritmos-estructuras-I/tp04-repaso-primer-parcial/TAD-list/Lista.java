public interface Lista<T> {
	/**
     * Metodos insertar
     * estos metodos insertan un elemento al TAD Lista
    */
	void insertarFin(T item);
	void insertarInicio(T item); 
	void insertarPos(T item, int pos);

	/**
     * Metodos eliminar
     * estos metodos eliminan un elemento del TAD Lista
    */
	T eliminarUltimo(); 
	T eliminarPrimero();
	T eliminarPos(int pos);

	/**
     * Metodos obtener 
     * estos metodos retornan un elemento de l TAD Lista
    */
	T getPrimero();
	T getUltimo();
	T getPos(int pos);

	/**
     * Metodos auxiliares
	 * estos metodos son metodos auxiliares del TAD Lista
    */
	void imprimir();
	int longitud();
	boolean esVacia();
	int buscar(T item);
}