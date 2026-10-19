/**
 * El ejercicio consistia en completar los metodos, lo que
 * habia que comentar estaba con __________________
 * asi que no hay que compilar este codigo.
 * Parcial simulacro creado por chat gpt.
*/

public class Nodo <T>{
    private T info;
    private Nodo <T> next;

    public Nodo<T> getNext(){
        return this.next;
    }

    public void setNext(Nodo<T> next){
        this.next = next;
    }

}