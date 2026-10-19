package _012_cola_simulacion;

public class Main {
    public static void main(String[] args) {
        ColaImpresion<String> ci = new ColaImpresion<>();
        ci.procesarDocumento("Trabajo1.txt");
        ci.procesarDocumento("Trabajo2.txt");
        ci.procesarDocumento("Trabajo3.txt");
        ci.mostrarCola();
    }
}