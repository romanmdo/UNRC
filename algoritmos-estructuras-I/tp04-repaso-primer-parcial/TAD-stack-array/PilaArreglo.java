public class PilaArreglo<T> implements Pila<T> {

    private T[] datos;
    private int tope;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public PilaArreglo(int capacidad) {
        this.capacidad = capacidad;
        this.datos = (T[]) new Object[capacidad];
        this.tope = -1;
    }

    public boolean esVacia() {
        return (this.tope == -1);
    }

    public boolean esLlena() {
        return (this.tope == this.capacidad - 1);
    }

    @Override
    public void apilar(T elemento) {
        if (this.esLlena()) // condición de pila llena
            throw new RuntimeException("Pila llena");

        tope++; // avanzar el tope
        datos[tope] = elemento; // insertar el elemento en el arreglo
    }

    @Override
    public T desapilar() {
        if (this.esVacia()) // condición de pila vacía
            throw new RuntimeException("Pila vacía");

        T dato = datos[tope]; // obtener elemento del tope
        tope--; // disminuir el tope
        return dato;
    }

    @Override
    public T tope() {
        if (this.esVacia())
            throw new RuntimeException("Pila vacía");
        return datos[tope];
    }

    @Override
    public int tamanio() {
        return tope + 1;
    }
}
