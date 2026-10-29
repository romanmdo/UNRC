import java.util.NoSuchElementException;

public class QueueEnlazadas<T> implements Queue<T> 
{
    private int size;
    private Nodo<T> first;
    private Nodo<T> last;
    
    public QueueEnlazadas()
    {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public void enqueue(T item)
    {
        Nodo<T> oldLast = last;
        
        last = new Nodo<T>(item);
        last.next = null;

        if (isEmpty()) 
        {
            first = last;
        } else 
        {
            oldLast.next = last;
        }
        
        size++;
        
    }

    public T dequeue()
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Cola vacia"); 
        }

        T dato = first.item;
        first = first.next;
        size--;
        return dato;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public T peek()
    {
        return this.first.item;
    }

    public String toString()
    {
        String res = "[";
        Nodo<T> curr = first;
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
}
