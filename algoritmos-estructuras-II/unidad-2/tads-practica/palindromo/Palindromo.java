public class Palindromo
{
    private String palabraTest;    

    public Palindromo(String palabra)
    {
        this.palabraTest = palabra;
    }

    public boolean esPalindromo()
    {
        this.palabraTest.toUpperCase();
        
        ListaArreglo<Character> arreglo = new ListaArreglo<>();

        for (int i = 0; i < palabraTest.length(); i++) 
        {
            arreglo.addIndice(i, palabraTest.charAt(i));    
        }

        while (arreglo.size > 0) 
        {
            if (arreglo.size == 1) 
            {
                return true; 
            } else {
                char primero = arreglo.removeInicio();
                char ultimo = arreglo.removeFinal();

                if (primero != ultimo) 
                {
                    return false;
                } 
            }
        }

        return true;
    }
}
