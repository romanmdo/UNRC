/**
 * Clase que modela una posada, donde los 
 * personajes se sientan a descansar.
 * @author Román Maldonado
 */
public class Posada 
{
    private String nombreTaberna;
    private int precioDescanso;
    
    /**
     * Constructor de la clase Posada
     */
    public Posada(String nombre, int precio)
    {   
        if (nombre == null || nombre.strip() == "") 
        {
            throw new IllegalArgumentException("Nombre no puede ser ni null ni vacio");    
        }

        if (precio < 0) 
        {
            throw new IllegalArgumentException("Precio no puede ser menor a 0");    
        }

        this.nombreTaberna = nombre;
        this.precioDescanso = precio;
    }
}
