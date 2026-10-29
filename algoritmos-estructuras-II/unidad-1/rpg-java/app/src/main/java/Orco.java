/**
 * Subclase que hereda Enemigo.
 * Modela un Orco.
 * @author Román Maldonado
 */
public class Orco extends Enemigo
{
    /**
     *  Constructor de la clase Orco.   
     */    
    public Orco(String nombre, int vida)
    {
        super(nombre, vida);
    }

    /**
     * Método de ataque del enemigo
     * @return daño que realiza.
     */
    @Override
    public int atacar()
    {
        return 20;
    }
}
