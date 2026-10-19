package _007_pila_simulacion;

import java.util.Stack;

public class SecuenciaMatematica{
    private Stack<Character> pila;

    public SecuenciaMatematica(){
        pila = new Stack<>();
    }

    public void comprobarBalanceo(String cadena){

        for(int i = 0; i < cadena.length(); i++){
            char c = cadena.charAt(i);
            
            if(c == '(' ){
                pila.push(c);
            }

            if(c == ')'){
                if(pila.empty() == true){
                    System.out.println("Secuencia no balanceada");
                    return;
                } else {
                    pila.pop();
                }
            }
        }

        if (pila.empty()) {
            System.out.println("Secuencia balanceada");
        } else {
            System.out.println("Secuencia NO balanceada");
        }
    }
}