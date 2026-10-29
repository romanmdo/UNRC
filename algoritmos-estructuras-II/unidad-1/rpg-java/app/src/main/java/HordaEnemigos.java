import java.util.ArrayList;

/**
 * Clase que modela una horda de enemigos.
 * @author Román Maldonado.
 */
public class HordaEnemigos 
{
    private ArrayList<Enemigo> hordaEnemigos;

    /**
     * Constructor de la clase.
     */
    public HordaEnemigos()
    {
        hordaEnemigos = new ArrayList<>();
    }

    /**
     * Método para agregar un enemigo a la horda.
     */
    public void agregarEnemigo(Enemigo enemigo)
    {
        hordaEnemigos.add(enemigo);
    }

    /**
     * Método para calcular el daño total de la horda.
     * @return daño total de la horda.
     */
    public int calcularDanioTotalHorda()
    {
        int result = 0;
        
        for (Enemigo enemigo : hordaEnemigos) 
        {
            result += enemigo.atacar();
        }

        return result;
    }

}
