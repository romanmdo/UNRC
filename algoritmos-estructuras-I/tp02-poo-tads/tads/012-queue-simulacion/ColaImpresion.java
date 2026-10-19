package _012_cola_simulacion;

import _011_cola_TAD.ColaArreglo;

public class ColaImpresion<T>{
    private  ColaArreglo<String> colaImpresion = new ColaArreglo<>();

    public void procesarDocumento(String cadena){
        colaImpresion.encolar(cadena);
    }

    public void mostrarCola(){
        colaImpresion.getCola();
    }
}