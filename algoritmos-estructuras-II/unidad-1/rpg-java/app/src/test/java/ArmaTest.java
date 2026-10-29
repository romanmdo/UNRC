import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmaTest {
    @Test
    public void testPersonajeAtacaConArma()
    {
        Personaje p1 = new Personaje("Mdo", 100);
        Arma a1 = new Arma("DK", 15, 100);
        p1.equiparArma(a1);
        p1.atacar();
        assertEquals(15, p1.atacar());
    }

    @Test
    public void testArmaSeRompeTrasUso(){
        Personaje p1 = new Personaje("Mdo", 100);
        Arma a1 = new Arma("DK", 15, 1);
        p1.equiparArma(a1);
        p1.atacar();
        assertEquals(0, a1.getDurabilidad());
        p1.atacar();

        assertEquals(0, p1.atacar());
        assertEquals(0, a1.getDurabilidad());
    }
}
