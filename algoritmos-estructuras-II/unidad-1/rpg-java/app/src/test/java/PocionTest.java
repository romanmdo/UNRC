import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PocionTest {
    @Test
    public void testAplicarCuracionSinExcederMaximo()
    {
        Pocion p1 = new Pocion("Curadora", 50);
        assertEquals(100, p1.aplicarCuracion(50, 100));
    }

    @Test
    public void testAplicarCuracionSuperaVida()
    {
        Pocion p1 = new Pocion("Curadora", 50);
        assertEquals(100, p1.aplicarCuracion(80, 100));
    }
}
