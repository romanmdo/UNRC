/**
 * Clase que modela un arma del RPG.
 */
public class Arma 
{
    private String nombre;
    private int danioBase;
    private int durabilidad;
    
    /**
     * Constructor del arma.
     * @pre danioBase > 0
     * @pre durabilidad > 0
     */
    public Arma(String nombre, int danioBase, int durabilidad)
    {
        if (danioBase < 0) 
        {
            throw new IllegalArgumentException("Daño base no puede ser menor a 0.");
        }

        if (durabilidad < 0) 
        {
            throw new IllegalArgumentException("Durabilidad no puede ser menor a 0.");
        }

        this.nombre = nombre;
        this.danioBase = danioBase;
        this.durabilidad = durabilidad;
    }

    /** 
     * Método para obtener el nombre del arma.
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /** 
     * Método para obtener la durabilidad del arma.
     */
    public int getDurabilidad()
    {
        return this.durabilidad;
    }

    /**
     * Método el cual permite usar el arma.
     */
    public int usar()
    {
        if (this.durabilidad > 0) 
        {
            this.durabilidad -= 1;    
            return this.danioBase;
        }
        return 0;
    }
}
