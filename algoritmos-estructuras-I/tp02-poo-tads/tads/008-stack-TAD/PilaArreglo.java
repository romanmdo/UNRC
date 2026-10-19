package _008_pila_TAD;

import _006_lista_TAD.ListaArreglo;

public class PilaArreglo<T> implements Pila<T> {
    private  ListaArreglo<T> listaArreglo = new ListaArreglo<>();
    
    public void apilar(T item){
       listaArreglo.insertarInicio(item);
    }

    public void desapilar(){
        listaArreglo.eliminarPrimero();
    }

    public boolean esVacia(){
        return listaArreglo.longitud() == 0;
    }

    public void vaciar(){
        while (!esVacia()) {
            listaArreglo.eliminarPrimero();
        }
    }

    public void getPila(){
        listaArreglo.imprimir();
    }

    public T tope(){
        return listaArreglo.getPrimero();
    }
}
