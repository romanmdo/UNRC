package _002_linked_list;

import java.util.Random;
import java.util.LinkedList;

public class ListaEnlazada {
	public LinkedList<Integer> setListaEnlazada(int n){
		Random rand = new Random();
		LinkedList<Integer> linkedList = new LinkedList<>();

		for(int i = 0; i < n; i++){
			int x = rand.nextInt(); 
			linkedList.add(x);
		}

		for(int j = 0; j < linkedList.size(); j++){
			int numero = linkedList.get(j);
			System.out.println("# Elemento de la lista: " + numero);
		}

		return linkedList;
	}
}