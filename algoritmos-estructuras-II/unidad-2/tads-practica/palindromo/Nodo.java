public class Nodo<T>
{
    T item;
    Nodo<T> prev; 
    Nodo<T> next;

    public Nodo(T e)
    {
        this.prev = null;
        this.next = null;
        this.item = e;
    }
}