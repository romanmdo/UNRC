package _008_pila_TAD;

import _006_lista_TAD.ListaEnlazada;

public class PilaEnlazada<T> implements Pila<T> {
    private  ListaEnlazada<T> listaEnlazada = new ListaEnlazada<>();
    
    public void apilar(T item){
       listaEnlazada.insertarInicio(item);
    }

    public void desapilar(){
        listaEnlazada.eliminarPrimero();
    }

    public boolean esVacia(){
        return listaEnlazada.longitud() == 0;
    }

    public void vaciar(){
        while (!esVacia()) {
            listaEnlazada.eliminarPrimero();
        }
    }

    public void getPila(){
        listaEnlazada.imprimir();
    }

    public T tope(){
        return listaEnlazada.getPrimero();
    }
}
