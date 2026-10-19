package _011_cola_TAD;

import _006_lista_TAD.ListaEnlazada;

public class ColaEnlazada<T> implements Cola<T> {
    private  ListaEnlazada<T> listaEnlazada = new ListaEnlazada<>();
    
    public void encolar(T item){
       listaEnlazada.insertarInicio(item);
    }

    public void desencolar(){
        listaEnlazada.eliminarUltimo();
    }

    public boolean esVacia(){
        return listaEnlazada.longitud() == 0;
    }

    public void vaciar(){
        while (!esVacia()) {
            listaEnlazada.eliminarPrimero();
        }
    }

    public void getCola(){
        listaEnlazada.imprimir();
    }
}
