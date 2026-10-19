// Implementación con arreglo
public class ListaArreglo<T> implements Lista<T> {

    private T[] datos;
    private int cantidad;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public ListaArreglo(int capacidad) {
        this.capacidad = capacidad;
        this.datos = (T[]) new Object[capacidad];
        this.cantidad = 0;
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }

    @Override
    public int tamaño() {
        return capacidad;
    }

    @Override
    public void insertarFinal(T dato) {
        if (cantidad == capacidad) // lista llena
            throw new RuntimeException("Lista llena");

        datos[cantidad] = dato; // colocar dato al final
        cantidad++; // aumentar cantidad
    }

    @Override
    public void insertarInicio(T dato) {
        if (cantidad == capacidad) // lista llena
            throw new RuntimeException("Lista llena");

        for (int i = cantidad; i > 0; i--) {
            datos[i] = datos[i - 1]; // mover elementos hacia atrás
        }

        datos[0] = dato; // colocar dato en posición 0
        cantidad++; // aumentar cantidad
    }

    @Override
    public void insertar(int pos, T dato) {
        if (pos >= capacidad || pos < 0) // posición inválida
            throw new IndexOutOfBoundsException();

        if (cantidad == capacidad) // lista llena
            throw new RuntimeException("Lista llena");

        for (int i = cantidad; i > pos; i--) {
            datos[i] = datos[i - 1]; // mover elementos hacia atrás
        }

        datos[pos] = dato; // colocar dato en pos
        cantidad++; // aumentar cantidad
    }

    @Override
    public void eliminarInicio() {
        if (this.esVacia()) // lista vacía
            throw new RuntimeException("Lista vacía");

        for (int i = 0; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1]; // mover elementos hacia adelante
        }

        cantidad--; // disminuir cantidad
    }

    @Override
    public void eliminarFinal() {
        if (this.esVacia()) // lista vacía
            throw new RuntimeException("Lista vacía");

        cantidad--; // disminuir cantidad
    }

    @Override
    public void eliminar(int pos) {
        if ( pos >= capacidad || pos < 0 ) // posición inválida
            throw new IndexOutOfBoundsException();

        for (int i = pos; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1]; // mover elementos hacia adelante
        }

        cantidad--; // disminuir cantidad
    }

    @Override
    public T obtener(int pos) {
        if ( pos >= capacidad || pos < 0 ) // posición inválida
            throw new IndexOutOfBoundsException();

        return datos[pos]; // retornar elemento en pos
    }

    @Override
    public void modificar(int pos, T dato) {
        if ( pos >= capacidad || pos < 0 ) // posición inválida
            throw new IndexOutOfBoundsException();

        datos[pos] = dato; // asignar nuevo valor
    }

    @Override
    public int buscar(T dato) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].equals(dato)) // comparar elemento con dato
                return i;
        }
        return -1;
    }

    @Override
    public void limpiar() {
        cantidad = 0; // cantidad = 0
    }

    @Override
    public void mostrar() {
        for (int i = 0; i < cantidad; i++) {
            System.out.print( datos[i] + " "); // imprimir elemento
        }
        System.out.println();
    }
}
