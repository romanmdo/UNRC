package main.java;

public interface Lista<T>
{
    public T setInicio(T e);
    public T setIndice(int indice, T e);
    public T setFinal(T e);

    public T getInicio();
    public T getIndice(int indice);
    public T getFinal();

    public void addInicio(T e);
    public void addIndice(int indice, T e);
    public void addFinal(T e);

    public T removeInicio();
    public T removeIndice(int indice);
    public T removeFinal();
    public boolean removeSearch(T e);

    public boolean contains(T e);
    public int indexOf(T e);    

    public String toString();
    public boolean repOK();
}
