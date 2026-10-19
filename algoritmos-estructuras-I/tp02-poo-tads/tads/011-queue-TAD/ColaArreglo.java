package _011_cola_TAD;

import _006_lista_TAD.ListaArreglo;

public class ColaArreglo<T> implements Cola<T> {
    private  ListaArreglo<T> listaArreglo = new ListaArreglo<>();
    
    public void encolar(T item){
       listaArreglo.insertarInicio(item);
    }

    public void desencolar(){
        listaArreglo.eliminarUltimo();
    }

    public boolean esVacia(){
        return listaArreglo.longitud() == 0;
    }

    public void vaciar(){
        while (!esVacia()) {
            listaArreglo.eliminarPrimero();
        }
    }

    public void getCola(){
        listaArreglo.imprimir();
    }
}
