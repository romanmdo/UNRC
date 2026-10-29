import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackEnlazadoTest
{
    @Test
    public void testConstructor()
    {
        StackEnlazado<Integer> stack = new StackEnlazado<Integer>();
        String abstractSeq = stack.toString();
        assertEquals("[]", abstractSeq);
    }

    @Test 
    public void testPush()
    {
        StackEnlazado<Integer> stack = new StackEnlazado<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        String abstractSeq = stack.toString();
        assertEquals("[2, 5, 3]", abstractSeq);
    }

    @Test
    public void testPop()
    {
        StackEnlazado<Integer> stack = new StackEnlazado<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.pop();
        String abstractSeq = stack.toString();
        assertEquals("[5, 3]", abstractSeq);
    }

    @Test
    public void testSize()
    {
        StackEnlazado<Integer> stack = new StackEnlazado<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.pop();
        assertEquals(2, stack.size());
    }
} 
