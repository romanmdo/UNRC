/**
 * Clase que modela un enemigo
 * @author Román Maldonado
 */
public abstract class Enemigo {
    protected String nombre;
    protected int vida;

    /**
     * Constructor de la clase enemigo
     */
    public Enemigo(String nombre, int vida)
    {
        this.nombre = nombre;
        this.vida = vida;
    }

    /**
     * @return retorna el nombre del enemigo
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * @return retona la vida del enemigo
     */
    public int getVida()
    {
        return this.vida;
    }

    /**
     * Método que retorna si el enemigo esta vivo o muerto.
     * @return true si esta vivo.
     * @return false si esta muerto.
     */
    public boolean estaVivo()
    {
        if (vida > 0) 
        {
            System.out.println("El enemigo " + this.nombre + " sigue vivo.");
            return true;    
        } else 
        {
            System.out.println("El enemigo " + this.nombre + " murio.");
            return false;
        }
    }

    /**
     * Método para que tu personaje reciba daño
     * @pre cantidad debe ser mayor o igual que 0.
     */
    public void recibirDanio(int cantidad)
    {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad es menor a 0."); 
        }

        this.vida -= cantidad;

        if (vida <= 0) {
            System.out.println("El enemigo a muerto.");
        } else {
            System.out.println("Al enemigo le queda " + this.vida + " de vida.");
        }
    }


    /**
     * Método de ataque del enemigo
     * @return daño que realiza.
     */
    public abstract int atacar();
}
