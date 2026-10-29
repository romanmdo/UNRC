import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que modela un diario de misiones.
 * @author Román Maldonado.
 */
public class DiarioMisiones {
    private ArrayList<Mision> diarioMisiones;

    /**
     * Constructor de la lista DiarioMisiones.
     */
    public DiarioMisiones()
    {
        diarioMisiones = new ArrayList<>();
    }

    /**
     * Método para agregar una misión al diario de misiones.
     */
    public void agregarMision(Mision nuevaMision)
    {
        diarioMisiones.addLast(nuevaMision);
    }

    /**
     * Método para retornar la cantidad de misiones que tiene la lista.
     */
    public int getCantidadMisionesActivas()
    {
        return diarioMisiones.size(); 
    }

    /**
     * Método para mostrar el diario.
     */
    public void mostrarDiario()
    {
        for (Mision m : diarioMisiones) 
        {
            if (m.getCondicion()) 
            {
                System.out.println("La misión " + m.getTitulo() + " con recompensa de: " + m.getRecompensaOro() + " de oro, esta completa.");
            } else 
            {
                System.out.println("La misión " + m.getTitulo() + " con recompensa de: " + m.getRecompensaOro() + " de oro, esta incompleta.");
            }
        }
    }

    /**
     * Método para limpiar las misiones completadas.
     */
    public void limpiarMisionesCompletadas()
    {
        Iterator<Mision> m = diarioMisiones.iterator();
        
        while (m.hasNext()) 
        {
            if (m.next().getCondicion()) 
            {
                m.remove();    
            }
        }
    }

    /**
     * Método para remover una misión del diario de misiones
     */
    public void removerMision(String tituloMision)
    {
        Iterator<Mision> m = diarioMisiones.iterator();

        while (m.hasNext()) 
        {
            if (m.next().getTitulo().equals(tituloMision)) 
            {
                m.remove();
            }    
        }
    }

    /**
     * Método para vaciar el diario de misiones
     */
    public void limpiarDiario()
    {
        diarioMisiones.clear();
    }

    /**
     * Método para buscar una misión por su nombre
     * Si la misión esta en el diario retorna true
     * En caso contrario, false.
     */
    public boolean buscarMision(String nombreMision)
    {
        for (Mision mision : diarioMisiones) 
        {
            if (mision.getTitulo().equals(nombreMision)) 
            {
                return true;    
            }     
        }

        return false;
    }

    /**
     * Función de abstracción
     */
    public String toString()
    {
        return diarioMisiones.toString();
    }
}
