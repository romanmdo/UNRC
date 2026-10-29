/**
 * Clase que modela una misión.
 * @author Román Maldonado.
 */
public class Mision 
{
    private String titulo;
    private int recompensaOro;
    private boolean completada;

    /**
     * Constructor de la clase misión.
     */
    public Mision(String titulo, int recompensaOro)
    {
        this.titulo = titulo;
        this.recompensaOro = recompensaOro;
        this.completada = false;
    }

    /**
     * Método getter para obtener el titulo.
     */
    public String getTitulo()
    {
        return this.titulo;
    }

    /**
     * Método getter para obtener la cantidad de oro que recompensa la misión.
     */
    public int getRecompensaOro()
    {
        return this.recompensaOro;
    }

    /** 
     * Método getter para obtener la condición de la mision (Completa/incompleta).
     */
    public boolean getCondicion()
    {
        return this.completada;
    }

    /**
     * Método para marcar como completa una misión.
     */
    public void marcarComoCompletada()
    {
        if (this.completada = true) 
        {
            System.out.println("Esta misión ya fue completada con exito.");    
        }

        this.completada = true;
    }
}
