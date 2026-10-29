package main.java;

public class ListaArreglo<T> implements Lista<T> 
{
    private static final int INIT_CAPACITY = 8;
    protected T[] array;
    protected int size;

    @SuppressWarnings("unchecked")
    public ListaArreglo()
    {
        array = (T[]) new Object[INIT_CAPACITY];
    }

    @Override
    public T setInicio(T e)
    {
        T dato = array[0];
        array[0] = e;
        return dato;
    }

    @Override 
    public T setIndice(int indice, T e)
    {
        if(indice >= INIT_CAPACITY)
        {
            throw new IllegalArgumentException('Error: Indice no valido');
        }

        T dato = array[indice];
        array[indice] = e;
        return dato;
    }

    @Override
    public T setFinal(T e)
    {
        T dato = array[size - 1];
        array[size - 1] = e;
        return dato;
    }

    @Override
    public T getInicio()
    {
        return array[0];
    }

    @Override
    public T getIndice(int indice)
    {
        if(indice >= INIT_CAPACITY)
        {
            throw new IllegalArgumentException('Error: Indice no valido');
        }

        return array[indice];

    }

    @Override
    public T getFinal()
    {
        return array[size - 1];
    }
    
    @Override
    public void addInicio()
    {
        if(size == INIT_CAPACITY)
        {
            error;
        }

        for(int i = size - 1; i >= 0; i--)
        {
            array[i + 1] = array[i]
        }

        array[0] = e; 
        size++;
    }

    /**
     * Agrega en cualquier posición de la lista
     */
    @Override
    public void add(int index, T e)
    {
        if(size == INIT_CAPACITY)
        {
            System.out.println("Error: Lista llena");
        } 
        
        for(int i = size - 1; i <= index; i--)
        {
            array[i + 1] = array[i];
        }

        array[index] = e;
        size++;
    }

    /**
     * Remueve en cualquier posición de la lista
     */
    @Override
    public T remove(int index)
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }
        
        T dato = array[index];

        for(int i = index; i < size - 1; i++)
        {
            array[i] = array[i + 1];
        }

        size--;
        array[size] = null;
        return dato;
    }

    @Override
    public boolean contains(T e)
    {
        for(int i = 0; i < size; i++)
        {
            if(array[i] == e)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Agrega adelante de la lista
     */
    @Override
    public void add(T e)
    {
        if(size == INIT_CAPACITY)
        {
            System.out.println("Error: Lista llena");
        } 
        
        for(int i = size - 1; 0 <= i; i--)
        {
            array[i + 1] = array[i];
        }
        size++;
        array[0] = e;
    }

    @Override
    public boolean remove(T e)
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }

        for(int i = 0; i < size - 1; i++)
        {
            if(array[i] == e)
            {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(T e)
    {
        int indice = -1;

        for(int i = 0; i < size - 1; i++)
        {
            if(array[i] == e)
            {
                indice = i; 
                return indice;
            }
        }

        return indice;
    }

    private String toString()
    {
        String res = "[";
        
        for(int i = 0; i < size - 1; i++)
        {
            res += array[i].toString();
            if(i < size - 1)
            {
                res += ", " ;
            }   
        }

        res += "]";
        return res;
    }

    private boolean repOk()
    {
        for(int i = 0; i < size - 1; i++)
        {
            if(array[i] == null)
            {
                return false;
            }
        }
        
        int contador = 0;
        for(int i = 0; i < size - 1; i++)
        {
            contador++;
        }

        if(contador != size)
        {
            return false;
        }
        
        return true;
    }
}
