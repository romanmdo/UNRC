import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemigoTest 
{
    @Test
    public void testDespachoDinamico()
    {
        Enemigo jefe = new Dragon("Dragonite", 100);
        assertEquals(100, jefe.atacar());
    }

    @Test
    public void testIgualdadReferencias()
    {
        Enemigo e1 = new Orco("Uruk", 50);
        Enemigo e2 = new Orco("Uruk", 50);
        Enemigo e3 = e1;

        assertFalse(e1 == e2);
        assertTrue(e1 == e3);
    }

    @Test
    public void testHordaNumeros()
    {
        Enemigo e1 = new Orco("Uruk", 50);
        Enemigo e2 = new Orco("Uruk", 50);
        Enemigo e3 = new Orco("Uruk", 50);
        Enemigo e4 = new Orco("Uruk", 50);
        Enemigo d1 = new Dragon("Dragonite", 100);
        HordaEnemigos h1 = new HordaEnemigos();

        h1.agregarEnemigo(e1);
        h1.agregarEnemigo(e2);
        h1.agregarEnemigo(e3);
        h1.agregarEnemigo(e4);
        h1.agregarEnemigo(d1);

        assertEquals(180, h1.calcularDanioTotalHorda());
    }
}
