public class MainBrakets 
{
    public static void main(String[] args) 
    {
        BraketsSequence bs = new BraketsSequence("(]");
        
        boolean res = bs.seqBalanceada(); 

        System.out.println(res);
    }
}
