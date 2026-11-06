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

    private void resize(int capacity)
    {
        if (capacity <= size()) {
            throw new IllegalArgumentException("El nuevo arreglo es más largo que el tamaño actual.");          
        }

        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) 
        {
            copy[i] = array[i];    
        }
    }

    private int size()
    {
        return size;
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
        if(indice >= array.length)
        {
            throw new IllegalArgumentException("Error: Indice no valido");
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
        if(indice >= array.length)
        {
            throw new IllegalArgumentException("Error: Indice no valido");
        }

        return array[indice];

    }

    @Override
    public T getFinal()
    {
        return array[size - 1];
    }
    
    @Override
    public void addInicio(T e)
    {
        if(size == array.length)
        {
            resize(2 * array.length);
        }

        for(int i = size - 1; i >= 0; i--)
        {
            array[i + 1] = array[i];
        }

        array[0] = e; 
        size++;
    }

    /**
     * Agrega en cualquier posición de la lista
     */
    @Override
    public void addIndice(int index, T e)
    {
        if(size == array.length)
        {
            resize(2 * array.length);
        }
        
        for(int i = size - 1; index <= i; i--)
        {
            array[i + 1] = array[i];
        }

        array[index] = e;
        size++;
    }

    @Override 
    public void addFinal(T e)
    {   
        if(size == array.length)
        {
            resize(2 * array.length);
        }
        
        array[size] = e;
        size++;
    }

    @Override 
    public T removeInicio()
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }

        T dato = array[0];

        array[0] = null;

        for(int i = 0; i < size; i++)
        {
            array[i] = array[i + 1];
        }

        size--;
        return dato;
    }

    /**
     * Remueve en cualquier posición de la lista
     */
    @Override
    public T removeIndice(int index)
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
    public T removeFinal()
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }
        
        T dato = array[size - 1];
        array[size - 1] = null;
        size--;
        return dato; 
    }

    @Override 
    public boolean removeSearch(T e)
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }
        
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i].equals(e)) 
            {
                removeIndice(i); 
                return true;   
            }    
        }

        return false;
    }

    @Override
    public boolean contains(T e)
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }
        
        for(int i = 0; i < size; i++)
        {
            if(array[i] == e)
            {
                return true;
            }
        }

        return false;
    }


    @Override
    public int indexOf(T e)
    {
        if(size == 0)
        {
            System.out.println("Error: Lista vacia");
        }
        
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

    @Override
    public String toString()
    {
        String res = "[";
        
        for(int i = 0; i < size; i++)
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

    @Override
    public boolean repOK()
    {
        for(int i = 0; i < size - 1; i++)
        {
            if(array[i] == null)
            {
                return false;
            }
        }
        
        int contador = 0;
        for(int i = 0; i < size; i++)
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
