import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaArreglosTest {

    @Test 
    public void testConstructor() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        assertEquals("[]", lista.toString());
    } 

    @Test 
    public void testAdd() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals("[1, 2, 3]", lista.toString());
    }

    @Test 
    public void testAddAtIndex() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10); // [10]
        lista.add(30); // [10, 30]
        lista.add(1, 20); // Inserta en el medio: [10, 20, 30]
        lista.add(0, 5);  // Inserta al principio: [5, 10, 20, 30]
        assertEquals("[5, 10, 20, 30]", lista.toString());
    }

    @Test 
    public void testGet() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        assertEquals(10, lista.get(0));
        assertEquals(20, lista.get(1));
        assertEquals(30, lista.get(2));
    }

    @Test 
    public void testSet() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        
        // Reemplaza el elemento en el índice 1 (que es 20) por 99
        int valorAnterior = lista.set(1, 99); 
        
        assertEquals(20, valorAnterior);
        assertEquals("[10, 99]", lista.toString());
    }

    @Test 
    public void testRemoveAtIndex() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        
        // Elimina el elemento en el índice 1
        int valorEliminado = lista.remove(1);
        
        assertEquals(20, valorEliminado);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test 
    public void testRemoveElement() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        
        // Nota: Casteamos a (Integer) para asegurarnos de llamar a remove(T e) 
        // y no a remove(int index) cuando trabajamos con listas de enteros.
        boolean eliminadoCorrectamente = lista.remove((Integer) 20);
        boolean noEliminado = lista.remove((Integer) 99); // No existe
        
        assertTrue(eliminadoCorrectamente);
        assertFalse(noEliminado);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test 
    public void testContains() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        
        assertTrue(lista.contains(10));
        assertTrue(lista.contains(20));
        assertFalse(lista.contains(50));
    }

    @Test 
    public void testIndexOf() {
        Lista<Integer> lista = new ListaArreglos<Integer>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(20); // Elemento repetido
        
        assertEquals(0, lista.indexOf(10));
        assertEquals(1, lista.indexOf(20)); // Debe devolver la primera ocurrencia
        assertEquals(-1, lista.indexOf(99)); // Si no está, devuelve -1
    }
}