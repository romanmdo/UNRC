import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueEnlazadasTest {
    @Test 
    public void testConstructor()
    {
        Queue<Integer> queue = new QueueEnlazadas<Integer>();
        assertEquals("[]", queue.toString());
    } 

    @Test 
    public void testEnqueue()
    {
        Queue<Integer> queue = new QueueEnlazadas<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("[1, 2]", queue.toString());
    }

    @Test 
    public void testDequeue()
    {
        Queue<Integer> queue = new QueueEnlazadas<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
    }

    @Test 
    public void testToString()
    {
        Queue<Integer> queue = new QueueEnlazadas<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        assertEquals("[2, 3, 4]", queue.toString());
    }
}
