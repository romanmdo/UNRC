/**
 * Subclase que hereda Enemigo.
 * Modela un Dragon.
 * @author Román Maldonado
 */
public class Dragon extends Enemigo
{
    /**
     *  Constructor de la clase Orco.   
     */    
    public Dragon(String nombre, int vida)
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
        return 100;
    }
}
