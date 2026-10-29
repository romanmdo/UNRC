import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BolsaItemsTest {
    @Test
    public void testCantidadItems()
    {
        BolsaItems b1 = new BolsaItems();
        b1.agregarItem("Ramas", 10);
        b1.agregarItem("Vendas", 2);

        assertEquals(2, b1.cantidadItems());
    }

    @Test
    public void testToString()
    {
        BolsaItems b1 = new BolsaItems();
        b1.agregarItem("Ramas", 10);
        b1.agregarItem("Vendas", 2);

        assertEquals("{Ramas=10, Vendas=2}", b1.toString());
    }

    @Test
    public void testSobrepasarLimite()
    {
        BolsaItems b1 = new BolsaItems();
        b1.agregarItem("Ramas", 100);

        assertEquals("{Ramas=99}", b1.toString());
    }

    @Test
    public void testBuscarItem()
    {
        BolsaItems b1 = new BolsaItems();
        b1.agregarItem("Ramas", 100);

        assertEquals(true, b1.buscarItem("Ramas"));
    }

    @Test
    public void testEliminarItem()
    {
        BolsaItems b1 = new BolsaItems();
        b1.agregarItem("Ramas", 100);
        b1.agregarItem("Vendas", 2);
        b1.eliminarItem("Ramas");

        assertEquals("{Vendas=2}", b1.toString());
    }
    
}
