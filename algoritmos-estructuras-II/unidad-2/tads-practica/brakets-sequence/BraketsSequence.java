public class BraketsSequence 
{
    private String braketsSeq;

    public BraketsSequence(String seq)
    {
        this.braketsSeq = seq;
    }

    public boolean seqBalanceada()
    {
        ListaArreglo<Character> arreglo = new ListaArreglo<>();
        StackArr<Character> pila = new StackArr<>();

        for (int i = 0; i < braketsSeq.length(); i++) 
        {
            System.out.println("En el indice: " + i + " esta el valor: " + braketsSeq.charAt(i)); 
            arreglo.addIndice(i, braketsSeq.charAt(i));
        }
        
        System.out.println(arreglo.toString());

        int cont = 0;
        while (arreglo.size > cont) {
            if (arreglo.getIndice(cont) == '(' || arreglo.getIndice(cont) == '[' || arreglo.getIndice(cont) == '{') 
            {
                pila.push(arreglo.getIndice(cont));
            } else {
                if (pila.isEmpty()) 
                {
                    return false;     
                } else {
                    if (arreglo.getIndice(cont) == ')' && pila.top() == '(') 
                    {
                        pila.pop();
                    } else if (arreglo.getIndice(cont) == ']' && pila.top() == '[') 
                    {
                        pila.pop();
                    } else if (arreglo.getIndice(cont) == '}' && pila.top() == '{') 
                    {
                        pila.pop();
                    }
                }
            }
            cont++;
        }

        if (pila.isEmpty()) 
        {
            return true;    
        } else {
            return false;
        }
    }
}
