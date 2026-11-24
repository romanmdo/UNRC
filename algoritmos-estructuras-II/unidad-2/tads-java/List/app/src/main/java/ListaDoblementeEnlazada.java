import java.util.NoSuchElementException;


public class ListaDoblementeEnlazada<T> implements Lista<T> 
{
    private int size;
    private Nodo<T> first;
    private Nodo<T> last; 
    

    public ListaDoblementeEnlazada()
    {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override 
    public T setInicio(T e)
     {   
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        T dato = first.item;
        first.item = e;
        return dato;
     } 

    @Override
    public T setIndice(int indice, T e)
     {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        // Creamos un indice que 
        // nos va a servir para recorrer 
        // la lista.
        int pos;
        T dato = null;

        // En caso de que el indice, sea mayor o igual
        // a size / 2, empezamos por atras de la lista.
        if (indice >= size / 2) 
        {
            
            Nodo<T> curr = last;
            pos = size - 1;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    dato = curr.item;
                    curr.item = e; 
                    return dato;     
                }

                pos--;
                curr = curr.prev;
            }
        } else 
        {
            Nodo<T> curr = first;
            pos = 0;
            
            while (curr != null) 
            {
                if (pos == indice) 
                {
                    dato = curr.item;
                    curr.item = e;
                    return dato;    
                }

                pos++;
                curr = curr.next;
            }
        }

        return null;
    }

    @Override
    public T setFinal(T e)
     {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        T dato = last.item;
        last.item = e;
        return dato;
     }

    @Override 
    public T getInicio()
    {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }
        
        return first.item;
    }

    @Override 
    public T getIndice(int indice)
    {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        int pos;

        if (indice >= size / 2) 
        {
            Nodo<T> curr = last;
            pos = size - 1;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    return curr.item;
                }

                pos--;
                curr = curr.prev;
            }
        } else 
        {
            Nodo<T> curr = first;
            pos = 0;
            
            while (curr != null) 
            {
                if (pos == indice) 
                {
                    return curr.item;
                }

                pos++;
                curr = curr.next;
            }
        }

        return null;
    }

    @Override 
    public T getFinal()
    {
        if (size == 0) 
        {
            throw new NoSuchElementException("Error, Lista vacia.");
        }
        return last.item;
    }

    @Override
    public void addInicio(T e)
    {
        Nodo<T> nodoNuevo = new Nodo<T>(e);

        if (size == 0) 
        {
            first = nodoNuevo;
            last = nodoNuevo;
        } else {
            first.prev = nodoNuevo;
            nodoNuevo.next = first;
            first = nodoNuevo;
        }
        size++;
    }

    @Override 
    public void addIndice(int indice, T e)
    {
        Nodo<T> nodoNuevo = new Nodo<T>(e);
        int pos;

        if (indice < 0 || indice > size) 
        {
            throw new IllegalArgumentException("Error, Indice no valido.");
        }

        if (indice == 0) 
        {
            addInicio(e);    
            return;
        }

        if (indice == size) 
        {
            addFinal(e);   
            return; 
        }


        if (indice >= size / 2)  
        {
            Nodo<T> curr = last;
            pos = size - 1;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    curr.prev.next = nodoNuevo;
                    nodoNuevo.prev = curr.prev;
                    curr.prev = nodoNuevo;
                    nodoNuevo.next = curr;
                    break;
                }
                pos--;
                curr = curr.prev;
            }
 
        } else {
            Nodo<T> curr = first;
            pos = 0;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    curr.prev.next = nodoNuevo;
                    nodoNuevo.prev = curr.prev;
                    curr.prev = nodoNuevo;
                    nodoNuevo.next = curr;
                    break;
                } 
                pos++;
                curr = curr.next;
            }
        }

        size++;
    }
    
    @Override 
    public void addFinal(T e)
    {
        Nodo<T> nodoNuevo = new Nodo<T>(e);

        if (size == 0) 
        {
            first = nodoNuevo;
            last = nodoNuevo;
        } else {
            last.next = nodoNuevo;
            nodoNuevo.prev = last;
            last = nodoNuevo;
        }
        size++;
    }

    @Override 
    public T removeInicio()
    {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        T dato = first.item;
        first = first.next;

        if (first != null) 
        {
            first.prev = null;     
        } else {
            last = null;
        }

        size--;
        return dato;
    }

    @Override 
    public T removeIndice(int indice)
    {
        T dato;
        int pos;

        if (indice < 0 || indice >= size) 
        {
            throw new IllegalArgumentException("Error, Indice no valido.");
        }

        if (indice == 0) 
        {
            return removeInicio();   
        }

        if (indice == size - 1) 
        {
            return removeFinal();   
        }

        if (indice >= size / 2)  
        {
            Nodo<T> curr = last;
            pos = size - 1;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    dato = curr.item;
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    size--;
                    return dato;
                }
                pos--;
                curr = curr.prev;
            }
 
        } else {
            Nodo<T> curr = first;
            pos = 0;

            while (curr != null) 
            {
                if (pos == indice) 
                {
                    dato = curr.item;
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    size--;
                    return dato;
                } 
                pos++;
                curr = curr.next;
            }
        }

        size--;
        return null;
    }

    @Override 
    public T removeFinal()
    {
        if (size == 0) {
            throw new NoSuchElementException("Error, Lista vacia.");
        }

        T dato = first.item;
        last = last.prev;

        if (last != null) 
        {
            last.next = null;    
        } else {
            last = null;
        }

        size--;
        return dato;
    }

    @Override 
    public boolean removeSearch(T e)
    {   
        int contador = 0;
        Nodo<T> curr = first;
        
        while (curr != null) 
        {
            if (curr.item.equals(e)) 
            {
                removeIndice(contador);    
                return true;
            }    

            contador++;
            curr = curr.next;
        }

        return false;
    }

    @Override 
    public boolean contains(T e)
    {
        Nodo<T> curr = first;
        
        while (curr != null) 
        {
            if (curr.item.equals(e)) 
            {
                return true;
            }    
            curr = curr.next;
        }
        return false;
    }

    @Override 
    public int indexOf(T e)
    {
        int contador = 0;
        Nodo<T> curr = first;
        
        while (curr != null) 
        {
            if (curr.item.equals(e)) 
            {
                return contador;
            }    

            contador++;
            curr = curr.next;
        }

        return -1;
    }

    @Override 
    public String toString()
    {
        String res = "[";
        Nodo<T> curr = first;
        int contador = 0;

        while (curr != null) 
        {
            res += curr.item.toString();
            if (contador < size - 1) 
            {
                res += ", ";
            }
            contador++;
            curr = curr.next;
        }

        res += "]";
        return res;
    }

    @Override 
    public boolean repOK()
    {
        // Algun dia, seras implementado..
        // Invariante de Condición...
        return true;
    }

    public String reverse()
    {
        String res = "[";
        Nodo<T> curr = last;
        int contador = size - 1;

        while (curr != null) 
        {
            res += curr.item.toString();
            if (contador > 0) 
            {
                res += ", ";
            }
            contador--;
            curr = curr.prev;
        }

        res += "]";
        return res;
    }
}
