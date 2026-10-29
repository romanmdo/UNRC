import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogrosTest {
    @Test
    public void testLogrosPersonaje()
    {
        Personaje p1 = new Personaje("Román", 100);
        assertEquals(true, p1.desbloquearLogro("Primer Paso"));
    }

    @Test
    public void testLogrosPersonajeRepetidos()
    {
        Personaje p1 = new Personaje("Román", 100);
        p1.desbloquearLogro("Primer Paso");
        assertEquals(false, p1.desbloquearLogro("Primer Paso"));
    }
}
