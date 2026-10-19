public class PilaTesteo {
    public static void main(String[] args) {
        Pila<Integer> pila = new PilaEnlazada<>();

        // 1️⃣ Test: pila vacía
        if (pila.esVacia()) {
            System.out.println("[OK] Test 1 completado: pila vacía");
        } else {
            System.out.println("[FAIL] Test 1 falló");
        }

        // 2️⃣ Test: apilar un elemento
        pila.apilar(10);
        if (!pila.esVacia() && pila.verTope() == 10) {
            System.out.println("[OK] Test 2 completado: apilar un elemento");
        } else {
            System.out.println("[FAIL] Test 2 falló");
        }

        // 3️⃣ Test: apilar varios elementos
        pila.apilar(20);
        pila.apilar(30);
        if (pila.verTope() == 30) {
            System.out.println("[OK] Test 3 completado: apilar varios elementos");
        } else {
            System.out.println("[FAIL] Test 3 falló");
        }

        // 4️⃣ Test: desapilar
        int valor = pila.desapilar();
        if (valor == 30 && pila.verTope() == 20) {
            System.out.println("[OK] Test 4 completado: desapilar elemento");
        } else {
            System.out.println("[FAIL] Test 4 falló");
        }

        // 5️⃣ Test: tamaño
        if (pila.tamaño() == 2) {
            System.out.println("[OK] Test 5 completado: tamaño correcto");
        } else {
            System.out.println("[FAIL] Test 5 falló");
        }

        // 6️⃣ Test: desapilar todos y verificar vacío
        pila.desapilar();
        pila.desapilar();
        if (pila.esVacia()) {
            System.out.println("[OK] Test 6 completado: pila vacía después de desapilar todo");
        } else {
            System.out.println("[FAIL] Test 6 falló");
        }
    }
}
