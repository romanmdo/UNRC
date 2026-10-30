import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaArregloTest {

    @Test
    public void testConstructor() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testSetInicio() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addIndice(0,10);
        lista.addIndice(1, 20);

        int valorAnterior = lista.setInicio(99);
        
        assertEquals(10, valorAnterior);
        assertEquals("[99, 20]", lista.toString());
    }

    @Test
    public void testSetIndice() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int valorAnterior = lista.setIndice(1, 99);
        
        assertEquals(20, valorAnterior);
        assertEquals("[10, 99, 30]", lista.toString());
    }

    @Test
    public void testSetFinal() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int valorAnterior = lista.setFinal(99);
        
        assertEquals(30, valorAnterior);
        assertEquals("[10, 20, 99]", lista.toString());
    }

    @Test
    public void testGetInicio() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertEquals(10, lista.getInicio());
        assertEquals("[10, 20]", lista.toString()); // Verificamos que obtener no muta la lista
    }

    @Test
    public void testGetIndice() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(20, lista.getIndice(1));
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testGetFinal() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(30, lista.getFinal());
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddInicio() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(20);
        lista.addFinal(30);
        
        lista.addInicio(10);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddIndice() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(30);
        
        lista.addIndice(1, 20);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testAddFinal() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testRemoveInicio() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeInicio();
        
        assertEquals(10, datoRemovido);
        assertEquals("[20, 30]", lista.toString());
    }

    @Test
    public void testRemoveIndice() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeIndice(1);
        
        assertEquals(20, datoRemovido);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test
    public void testRemoveFinal() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        int datoRemovido = lista.removeFinal();
        
        assertEquals(30, datoRemovido);
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    public void testRemoveSearch() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        boolean exito = lista.removeSearch(20);
        
        assertTrue(exito);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test
    public void testContains() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertTrue(lista.contains(10));
        assertFalse(lista.contains(99));
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    public void testIndexOf() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        
        assertEquals(1, lista.indexOf(20));
        assertEquals(-1, lista.indexOf(99));
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testRepOK() {
        ListaArreglo<Integer> lista = new ListaArreglo<>();
        lista.addFinal(10);
        lista.addFinal(20);
        
        assertTrue(lista.repOK());
        assertEquals("[10, 20]", lista.toString());
    }
}