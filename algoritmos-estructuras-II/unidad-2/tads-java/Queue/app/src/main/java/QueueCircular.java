import java.util.NoSuchElementException;

public class QueueCircular<T> implements Queue<T> 
{
    private static final int INIT_CAPACITY = 7;
    protected T[] queue;
    protected int size;
    protected int first;
    protected int last;
    
    public QueueCircular()
    {
        queue = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        first = 0;
        last = 0;
    }

    public void enqueue(T item)
    {
        if(size == INIT_CAPACITY)
        {
            throw new NoSuchElementException("Cola llena 😏"); 
        }

        queue[last] = item;
        last++;
        size++;
    }

    public T dequeue()
    {   
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Cola vacia 😏");   
        }

        T item = queue[first];
        queue[first] = null;
        first++;
        size--;
        return item;
    }

    public T peek()
    {
        return queue[first];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public String toString()
    {
        String res = "[";

        for (int i = 0; i < size; i++) 
        {
            res += queue[(first + i) % queue.length];
            if (i < size - 1) 
            {
                res += ", ";    
            }    
        }
        res += "]";
        return res;
    }
}
