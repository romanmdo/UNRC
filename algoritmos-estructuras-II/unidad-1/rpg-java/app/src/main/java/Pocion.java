/**
 * Clase que modela una pocion.
 * @author Román Maldonado. 
 */
public class Pocion {
    private String nombre;
    private int puntosCuracion;

    /**
     * Constructor que modela una poción. 
     */
    public Pocion(String nombrePocion, int puntosCuracion)
    {
        this.nombre = nombrePocion;
        this.puntosCuracion = puntosCuracion;
    }

    /**
     * Método para retornar el nombre de la poción.
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Método para retornar los puntos de curación que da la poción.
     */
    public int getPuntosCuracion()
    {
        return this.puntosCuracion;
    }

    /**
     * Método para aplicar curación.
     * @post vidaActual && vidaMaxima > 0
     */
    public int aplicarCuracion(int vidaActual, int vidaMaxima)
    {
        if (vidaActual < 0) {
            throw new IllegalArgumentException("La vida actual es negativa.");
        }

        if (vidaMaxima < 0) {
            throw new IllegalArgumentException("La vida maxima es negativa.");
        }

        vidaActual += this.puntosCuracion;
        if (vidaActual > vidaMaxima) 
        {
            vidaActual = vidaMaxima;    
        }

        return vidaActual;
    }
}
