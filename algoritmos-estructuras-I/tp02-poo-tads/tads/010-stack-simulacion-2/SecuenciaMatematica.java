package _010_píla_simulacion_2;

import _008_pila_TAD.PilaArreglo;;

public class SecuenciaMatematica<T>{
    private  PilaArreglo<Character> pilaArreglo = new PilaArreglo<>();

    public void comprobarBalanceo(String cadena){

        for(int i = 0; i < cadena.length(); i++){
            char c = cadena.charAt(i);
            
            if(c == '(' ){
                pilaArreglo.apilar(c); 
            }

            if(c == ')'){
                if(pilaArreglo.esVacia() == true){
                    System.out.println("Secuencia no balanceada");
                    return;
                } else {
                    pilaArreglo.desapilar();
                }
            }
        }

        if (pilaArreglo.esVacia()) {
            System.out.println("Secuencia balanceada");
        } else {
            System.out.println("Secuencia NO balanceada");
        }
    }
}