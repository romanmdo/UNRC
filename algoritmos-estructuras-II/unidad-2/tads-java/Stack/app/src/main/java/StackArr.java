import java.util.NoSuchElementException;

public class StackArr<T> implements Stack<T>{
    private static final int INIT_CAPACITY = 8;
    protected T[] array;
    protected int size;

    @SuppressWarnings("unchecked")
    public StackArr()
    {
        array = (T[]) new Object[INIT_CAPACITY];
    }

    @Override
    public void push(T item)
    {
        if (size == INIT_CAPACITY) 
        {
            throw new NoSuchElementException("Pila llena");    
        }
        
        array[size] = item;
        size++;
    }

    @SuppressWarnings("null")
    @Override
    public T pop()
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Pila vacia");
        }
        
        T item = array[size - 1];
        array[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public T top()
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Pila vacia");
        }
        
        return array[size - 1];
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

    @Override
    public String toString()
    {
        String res = "[";

        for (int i = size - 1; i >= 0; i--) 
        {
            res += array[i].toString();
            if (i > 0 )
            {
                res += ", ";     
            }
        }

        res += "]";
        return res;
    }

    public boolean repOK()
    {
        if (size < 0 || size > array.length) 
        {
            return false;    
        }

        for (int i = 0; i < size; i++) 
        {
            if (array[i] == null) 
            {
                return false;    
            }    
        }

        return true;
    }
}


