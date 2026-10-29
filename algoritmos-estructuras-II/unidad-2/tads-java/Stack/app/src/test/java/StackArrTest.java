import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrTest
{
    @Test
    public void testConstructor()
    {
        StackArr<Integer> stack = new StackArr<Integer>();
        String abstractSeq = stack.toString();
        assertEquals("[]", abstractSeq);
    }

    @Test 
    public void testPush()
    {
        StackArr<Integer> stack = new StackArr<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        String abstractSeq = stack.toString();
        assertEquals("[2, 5, 3]", abstractSeq);
    }

    @Test
    public void testPop()
    {
        StackArr<Integer> stack = new StackArr<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.pop();
        String abstractSeq = stack.toString();
        assertEquals("[3, 5]", abstractSeq);
    }

    @Test
    public void testSize()
    {
        StackArr<Integer> stack = new StackArr<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.pop();
        assertEquals(2, stack.size());
    }
} 
