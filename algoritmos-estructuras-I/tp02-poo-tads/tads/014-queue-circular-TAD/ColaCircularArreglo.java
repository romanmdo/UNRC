package _014_cola_circular_TAD;

public class ColaCircularArreglo implements ColaCircular {
    private int[] elementos;
    private int front;
    private int rear;
    private int maxSize;

    public ColaCircularArreglo(int size) {
        maxSize = size + 1; // espacio extra para diferenciar llena/vacía
        elementos = new int[maxSize];
        front = 0;
        rear = 0;
    }


    @Override
    public void encolar(int item){
       if((rear + 1) % maxSize == front){
            throw new RuntimeException("La cola circular esta llena");
       } 

       elementos[rear] = item;
       rear = (rear + 1) % maxSize;
    }

    @Override
    public void desencolar(){
        if(rear == front){
            throw new RuntimeException("La cola circular esta vacia");
        }

        int valor = elementos[front]; 
        front = (front + 1) % maxSize;
    }

    @Override
    public boolean estaVacia(){
       if(rear == front){
            return true;
       } else {
        return false;
       }
    }

    @Override
    public boolean estaLlena(){
       if((rear + 1) % maxSize == front){
            return true;
       } else {
        return false;
       }
    }

    @Override
    public void getCola(){
        int i = front;
        while (i != rear) {
            System.out.println(elementos[i]);
            i = (i + 1) % maxSize;
        }
    }
}
