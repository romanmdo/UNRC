public class StackEnlazado<T> implements Stack<T>
{
    protected int size;
    protected Nodo<T> top;    

    public StackEnlazado()
    {
        this.size = 0;
        this.top = null;
    }

    @Override 
    public void push(T item)
    {   
        Nodo<T> viejoTope = top;
        top = new Nodo<T>(item);
        top.next = viejoTope;
        size++;
    }

    @Override
    public T pop()
    {
        T item = top.item;
        top = top.next;
        size--; 
        return item;
    }

    @Override
    public T top()
    {
        T item = this.top.item;
        return item;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @SuppressWarnings("null")
    @Override
    public String toString()
    {
        String res = "[";
        Nodo<T> curr = top;

        while (curr != null) 
        {
            res += curr.item.toString();
            if (curr.next != null) 
            {
                res += ", ";
            }
            curr = curr.next;    
        }

        res += "]";
        return res;
    }

    public boolean repOK()
    {
        if (size < 0) 
        {
            return false;    
        }

        int numeroNodos = 0;
        Nodo<T> curr = top;
        while (curr != null && numeroNodos <= size) 
        {
            numeroNodos++;
            curr = curr.next;    
        }

        if (numeroNodos != size || curr != null) 
        {
            return false;    
        }

        return true;
    }

}
