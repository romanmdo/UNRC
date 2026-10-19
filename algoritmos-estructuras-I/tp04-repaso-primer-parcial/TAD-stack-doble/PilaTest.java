// Archivo: PilaTest.java
public class PilaTest {
    public static void main(String[] args) {

        Pila<Integer> pila = new PilaDoblementeEnlazada<>();

        // Test 1: pila vacía al inicio
        if (pila.esVacia()) {
            System.out.println("[OK] Test 1: la pila está vacía al inicio");
        } else {
            System.out.println("[FAIL] Test 1: la pila no está vacía al inicio");
        }

        // Test 2: apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        if (pila.tamanio() == 3 && pila.tope() == 30) {
            System.out.println("[OK] Test 2: apilar funciona correctamente");
        } else {
            System.out.println("[FAIL] Test 2: error al apilar");
        }

        // Test 3: desapilar
        int desapilado = pila.desapilar();
        if (desapilado == 30 && pila.tamanio() == 2) {
            System.out.println("[OK] Test 3: desapilar funciona correctamente");
        } else {
            System.out.println("[FAIL] Test 3: error al desapilar");
        }

        // Test 4: tope
        if (pila.tope() == 20) {
            System.out.println("[OK] Test 4: tope correcto");
        } else {
            System.out.println("[FAIL] Test 4: tope incorrecto");
        }

        // Test 5: vaciar completamente
        pila.desapilar();
        pila.desapilar();

        if (pila.esVacia()) {
            System.out.println("[OK] Test 5: la pila se vacía correctamente");
        } else {
            System.out.println("[FAIL] Test 5: error al vaciar la pila");
        }
    }
}
