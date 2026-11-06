import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaDoblementeEnlazadaTest {

    @Test
    public void testConstructor() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testSetInicio() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addIndice(0,10);
        lista.addIndice(1, 20);

        int valorAnterior = lista.setInicio(99);
        
        assertEquals(10, valorAnterior);
        assertEquals("[99, 20]", lista.toString());
    }

    @Test
    public void testSetIndice() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int valorAnterior = lista.setIndice(1, 99);
        
        assertEquals(20, valorAnterior);
        assertEquals("[10, 99, 30]", lista.toString());
    }

    @Test
    public void testSetFinal() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int valorAnterior = lista.setFinal(99);
        
        assertEquals(30, valorAnterior);
        assertEquals("[10, 20, 99]", lista.toString());
    }

    @Test
    public void testGetInicio() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertEquals(10, lista.getInicio());
        assertEquals("[10, 20]", lista.toString()); // Verificamos que obtener no muta la lista
    }

    @Test
    public void testGetIndice() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(20, lista.getIndice(1));
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testGetFinal() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(30, lista.getFinal());
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddInicio() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(20);
        lista.addFinal(30);
        
        lista.addInicio(10);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddIndice() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(30);
        
        lista.addIndice(1, 20);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddFinal() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testRemoveInicio() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeInicio();
        
        assertEquals(10, datoRemovido);
        assertEquals("[20, 30]", lista.toString());
    }

    @Test
    public void testRemoveIndice() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeIndice(1);
        
        assertEquals(20, datoRemovido);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test
    public void testRemoveFinal() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeFinal();
        
        assertEquals(30, datoRemovido);
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    public void testRemoveSearch() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        boolean exito = lista.removeSearch(20);
        
        assertTrue(exito);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test
    public void testContains() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertTrue(lista.contains(10));
        assertFalse(lista.contains(99));
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    public void testIndexOf() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(1, lista.indexOf(20));
        assertEquals(-1, lista.indexOf(99));
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testRepOK() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertTrue(lista.repOK());
        assertEquals("[10, 20]", lista.toString());
    }
}