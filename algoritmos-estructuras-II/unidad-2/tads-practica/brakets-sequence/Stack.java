public interface Stack<T> 
{
    public void push(T e);
    public T pop();
    public T top();    
    public int size();
    public boolean isEmpty();
    public String toString();
}
