public class Simulador {
    public static void intentarCrearPosada(String nombre, int precio)
    {   
        try {
            Posada p1 = new Posada(nombre, precio);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo generar el mapa: Argumento equivocado");
        }
        
    }
}
