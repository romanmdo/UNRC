import java.util.HashSet;

/**
 * Clase que modela un personaje de nuestro RPG.
 * @author Román Maldonado
 */
public class Personaje 
{
    private String nombre;
    private int vida;
    private final int VIDA_MAXIMA = 100;
    private int pociones;
    private Arma armaEquipada;
    private EstrategiaAtaque estrategia;
    private HashSet<String> logrosDesbloqueados;

    /**
     * Constructor de la clase Personaje.
     * @pre vida debe ser menor a VIDA_MAXIMA.
     * @post personaje con nombre, vida y 3 pociones.
     */
    public Personaje(String nombre, int vida)
    {
        if (vida > VIDA_MAXIMA) {
            throw new IllegalArgumentException("La vida debe ser menor a VIDA MAXIMA.");
        }

        this.nombre = nombre;
        this.vida = vida;
        this.pociones = 3;
        this.logrosDesbloqueados = new HashSet<>();
    }

    /**
     * Método para consultar la vida del personaje.
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Método para consultar la vida del personaje.
     */
    public int getVida()
    {
        return this.vida;
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
            System.out.println("Tu personaje a muerto.");
        } else {
            System.out.println("A tu personaje le queda " + this.vida + " de vida.");
        }
    }

    /**
     * Método para curar al personaje, cada pocion da 20 de vida.
     */
    public void curarAlMaximo()
    {
        int curacionPorPocion = 20;

        while (this.pociones > 0 && this.vida < this.VIDA_MAXIMA) {
            this.vida += curacionPorPocion;
            this.pociones -= 1;
            
            if (this.vida > this.VIDA_MAXIMA) 
            {
                this.vida = this.VIDA_MAXIMA;
                break;
            }
        }
    }

    /**
     * Método que asigna una instancia de Arma al personaje.
     */
    public void equiparArma(Arma arma)
    {
        this.armaEquipada = arma;
        System.out.println("Ahora el personaje " + this.nombre + " cuenta con el arma: " + this.armaEquipada.getNombre());
    }

    /**
     * Método el cual ataca.
     */
    public int atacar()
    {
        if (armaEquipada == null) 
        {
            return 1;    
        } else 
        {
            return armaEquipada.usar();
        }
    }

    /**
     * Método para agregarle una estrategia de ataque al personaje
     */
    public void setEstrategia(EstrategiaAtaque nuevaEstrategia)
    {
        this.estrategia = nuevaEstrategia;
        System.out.println("La nueva estrategia de ataque empleada por: " + this.nombre + " es: " + this.estrategia + ".");
    }

    /**
     * Método para desbloquear logros
     */
    public boolean desbloquearLogro(String tituloLogro)
    {
        if (logrosDesbloqueados.add(tituloLogro)) 
        {
            System.out.println("¡Nuevo Logro Desbloqueado: " + tituloLogro);
            return true;    
        } else 
        {
            return false;
        }
    }
     
}
