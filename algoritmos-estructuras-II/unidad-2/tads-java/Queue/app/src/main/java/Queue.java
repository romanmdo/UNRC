public interface Queue<T> 
{
    public void enqueue(T e);
    public T dequeue();
    public int size();
    public boolean isEmpty();
    public T peek();
    public String toString();
}
