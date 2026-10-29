import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiarioMisionesTest 
{
    @Test
    public void testMisionesInsercion()
    {
        Mision m1 = new Mision("Matar al dragon", 1000);
        Mision m2 = new Mision("Darle de comer a CA", 200);
        DiarioMisiones d1 = new DiarioMisiones();
        d1.agregarMision(m1);
        d1.agregarMision(m2);
        assertEquals(2, d1.getCantidadMisionesActivas());
    }

    @Test
    public void testLimpiarMisionesCompletadasReduceElTamano()
    {
        Mision m1 = new Mision("Matar al dragon", 1000);
        Mision m2 = new Mision("Darle de comer a CA", 200);
        Mision m3 = new Mision("Darle de comer a AG", 400);
        DiarioMisiones d1 = new DiarioMisiones();
        
        m2.marcarComoCompletada();

        d1.agregarMision(m1);
        d1.agregarMision(m2);
        d1.agregarMision(m3);

        d1.limpiarMisionesCompletadas();

        assertEquals(2, d1.getCantidadMisionesActivas());

    }

    @Test
    public void testRemoverMisiones()
    {
        Mision m1 = new Mision("Matar al dragon", 1000);
        Mision m2 = new Mision("Darle de comer a CA", 200);
        Mision m3 = new Mision("Darle de comer a AG", 400);
        DiarioMisiones d1 = new DiarioMisiones();
        
        d1.agregarMision(m1);
        d1.agregarMision(m2);
        d1.agregarMision(m3);

        System.out.println("Total de misiones: " + d1.getCantidadMisionesActivas());
        d1.removerMision("Matar al dragon");

        assertEquals(2, d1.getCantidadMisionesActivas());

    }

}
