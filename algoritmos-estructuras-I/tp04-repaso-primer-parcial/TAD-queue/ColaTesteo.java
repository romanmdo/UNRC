import java.util.NoSuchElementException;

public class ColaTesteo {
    public static void main(String[] args) {
        Cola<Integer> cola = new ColaEnlazada<>();

        // 1️⃣ Test: cola vacía al inicio
        try {
            if (cola.esVacia() && cola.tamaño() == 0) {
                System.out.println("[OK] Test 1: cola vacía al inicio");
            } else {
                System.out.println("[FAIL] Test 1: cola no vacía o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 1 con excepción: " + e.getMessage());
        }

        // 2️⃣ Test: encolar un elemento
        try {
            cola.encolar(10);
            if (!cola.esVacia() && cola.verFrente().equals(10) && cola.tamaño() == 1) {
                System.out.println("[OK] Test 2: encolar un elemento");
            } else {
                System.out.println("[FAIL] Test 2: valor o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 2 con excepción: " + e.getMessage());
        }

        // 3️⃣ Test: encolar varios elementos
        try {
            cola.encolar(20);
            cola.encolar(30);
            if (cola.verFrente().equals(10) && cola.tamaño() == 3) {
                System.out.println("[OK] Test 3: encolar varios elementos");
            } else {
                System.out.println("[FAIL] Test 3: frente o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 3 con excepción: " + e.getMessage());
        }

        // 4️⃣ Test: desencolar un elemento
        try {
            int valor = cola.desencolar();
            if (valor == 10 && cola.verFrente().equals(20) && cola.tamaño() == 2) {
                System.out.println("[OK] Test 4: desencolar elemento");
            } else {
                System.out.println("[FAIL] Test 4: valor, frente o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 4 con excepción: " + e.getMessage());
        }

        // 5️⃣ Test: desencolar todos
        try {
            cola.desencolar();
            cola.desencolar();
            if (cola.esVacia() && cola.tamaño() == 0) {
                System.out.println("[OK] Test 5: cola vacía tras desencolar todo");
            } else {
                System.out.println("[FAIL] Test 5: cola no vacía o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 5 con excepción: " + e.getMessage());
        }

        // 6️⃣ Test: desencolar de cola vacía (debe lanzar excepción)
        try {
            cola.desencolar();
            System.out.println("[FAIL] Test 6: no lanzó excepción en cola vacía");
        } catch (NoSuchElementException e) {
            System.out.println("[OK] Test 6: lanzó excepción correctamente");
        } catch (Exception e) {
            System.out.println("[FAIL] Test 6 con excepción inesperada: " + e.getMessage());
        }

        // 7️⃣ Test: encolar/desencolar alternadamente
        try {
            cola.encolar(100);
            cola.encolar(200);
            cola.desencolar(); // quita 100
            cola.encolar(300);
            if (cola.verFrente().equals(200) && cola.tamaño() == 2) {
                System.out.println("[OK] Test 7: encolar/desencolar alternadamente");
            } else {
                System.out.println("[FAIL] Test 7: frente o tamaño incorrecto");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 7 con excepción: " + e.getMessage());
        }

        // 8️⃣ Test: carga grande (rendimiento)
        try {
            for (int i = 0; i < 1000; i++) {
                cola.encolar(i);
            }
            for (int i = 0; i < 1000; i++) {
                cola.desencolar();
            }
            if (!cola.esVacia()) {
                // todavía quedan 200 y 300 del test anterior
                cola.desencolar();
                cola.desencolar();
            }
            if (cola.esVacia()) {
                System.out.println("[OK] Test 8: carga grande correcta");
            } else {
                System.out.println("[FAIL] Test 8: cola no vacía tras carga grande");
            }
        } catch (Exception e) {
            System.out.println("[FAIL] Test 8 con excepción: " + e.getMessage());
        }

        System.out.println("\n[OK] Todos los tests ejecutados.");
    }
}
