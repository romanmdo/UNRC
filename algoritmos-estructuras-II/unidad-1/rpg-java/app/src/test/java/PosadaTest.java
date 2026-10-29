import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosadaTest 
{
    @Test 
    public void testConstructorRechazaPreciosNegativos()
    {   
        assertThrows(IllegalArgumentException.class, () -> {
            Posada p1 = new Posada("Posada las palmas", -1);
    }, "El constructor deberia rechazar precios negativos");
    }

    @Test 
    public void testNombreNull()
    {   
        assertThrows(IllegalArgumentException.class, () -> {
            Posada p1 = new Posada(null, 1);
    }, "El constructor deberia rechazar nombres null");
    }

    @Test 
    public void testNombreEspacioBlanco()
    {   
        assertThrows(IllegalArgumentException.class, () -> {
            Posada p1 = new Posada("           ", 1);
    }, "El constructor deberia rechazar nombres vacios");
    }
}
