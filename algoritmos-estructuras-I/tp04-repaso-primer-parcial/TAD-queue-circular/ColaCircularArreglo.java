public class ColaCircularArreglo<T> implements ColaCircular<T> {

    private T[] datos;
    private int front;
    private int rear;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public ColaCircularArreglo(int capacidad) {
        this.capacidad = capacidad + 1; // espacio extra para diferenciar llena/vacía
        this.datos = (T[]) new Object[this.capacidad];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean esVacia() {
        return front == rear;
    }

    @Override
    public boolean esLlena() {
        return (rear + 1) % capacidad == front;
    }

    @Override
    public int tamaño() {
        return (rear - front + capacidad) % capacidad;
    }

    @Override
    public void encolar(T dato) {
        if (this.esLlena()) // cola llena
            throw new RuntimeException("Cola llena");

        datos[rear] = dato; // agregar elemento en rear
        rear = (rear + 1) % capacidad; // actualizar rear circularmente
    }

    @Override
    public T desencolar() {
        if (this.esVacia()) // cola vacía
            throw new RuntimeException("Cola vacía");

        T dato = datos[front]; // obtener elemento de front
        front = (front + 1) % capacidad; // actualizar front circularmente
        return dato;
    }

    @Override
    public T frente() {
        if (this.esVacia()) // cola vacía
            throw new RuntimeException("Cola vacía");

        return datos[front]; // devolver elemento en front
    }

    @Override
    public void limpiar() {
        front = 0;
        rear = 0;
    }

    @Override
    public void mostrar() {
        int i = front;
        while (i != rear) {
            System.out.print(datos[i] + " "); // imprimir elemento
            i = (i + 1) % capacidad;
        }
        System.out.println();
    }
}
