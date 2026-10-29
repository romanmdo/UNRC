public class Nodo<T>
{
    private T item;
    private Nodo<T> prev; 
    private Nodo<T> next;

    public Nodo(T e)
    {
        this.item = e;
    }

}