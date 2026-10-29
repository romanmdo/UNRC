import java.util.HashMap;

/**
 * Clase que modela un Grimorio.
 * @author Román Maldonado
 */
public class Grimorio 
{
    // KEY (K) -> String (palabra).
    // VALUE (V) -> Integer (cantidad de veces que aparece la palabra).
    private HashMap<String, Integer> palabrasImportantes; 

    /**
     * Constructor de la clase Grimorio
     */
    public Grimorio()
    {
        palabrasImportantes = new HashMap<>();
    }

    public void analizarPergamino(String texto)
    {
        String textoLimpio = texto.toLowerCase().replace(",", "").replace(".", "");
        String[] palabras = textoLimpio.split(" ");

        for (String palabra : palabras) 
        {
            palabrasImportantes.put(palabra, palabrasImportantes.getOrDefault(palabra, 0) + 1);    
        }
    
        System.out.println("📜 --- ANÁLISIS DEL PERGAMINO --- 📜");
        for (String clave : palabrasImportantes.keySet()) {
            System.out.println("Palabra: '" + clave + "' -> Aparece " + palabrasImportantes.get(clave) + " vez/veces.");
        }
    }
}
