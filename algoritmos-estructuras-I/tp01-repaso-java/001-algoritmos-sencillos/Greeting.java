public class Greeting {
    public static void main ( String [] args ) {
        if (args.length > 0) {
            String name = args [0];
            System.out.println ("Hola, " + name + " bienvenido a Java! ");
        } else {
            System.out.println ("Porfavor, inicia el programa con un nombre como argumento");
        }
    }
}