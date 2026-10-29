import java.util.HashMap;

/**
 * Clase que modela una bolsa de items.
 * @author Román Maldonado
 */
public class BolsaItems 
{   
    // Nombre item -> CLAVE (KEY)
    // Cantidad item -> VALOR (VALUE)
    
   private HashMap<String, Integer> inventario; 
   private static final int LIMITE_CANTIDAD = 99;

   /**
    * Constructor de la clase.
    */
    public BolsaItems()
    {
        this.inventario = new HashMap<>();
    }

    /**
     * Método para agregar items a la bolsa.
     */
    public void agregarItem(String nombreItem, int cantidadEncontrada)
    {
        int numeroItem = inventario.getOrDefault(nombreItem, 0);
        int cantidadItem = numeroItem + cantidadEncontrada;

        if (cantidadItem > LIMITE_CANTIDAD) 
        {
            cantidadItem = LIMITE_CANTIDAD;    
        }

        inventario.put(nombreItem, cantidadItem);
       
    }

    /**
     * Método para buscar un item en la bolsa de items.
        @return true si esta el item
        @return false si no esta el item
     */
   public boolean buscarItem(String nombreItem)
   {
        return inventario.containsKey(nombreItem);
   }

   /**
    * Método para retornar la cantidad de items que tiene el inventario
    */
   public int cantidadItems()
   {
        return inventario.size();
   }


   /**
    * Método para eliminar un item del inventario.
    */
   public void eliminarItem(String nombreItem)
   {
        inventario.remove(nombreItem);
   }

   /** 
    * Método para imprimir el HashMap (Función de Abstracción)
    */
   public String toString()
   {
        return inventario.toString();
   }

}

