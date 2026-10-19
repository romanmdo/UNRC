package _003_pertenece;

import java.util.ArrayList;

public class Pertenece {
	public boolean getPertenece(ArrayList<Integer> lista, int n){
		for(int i = 0; i < lista.size(); i++ ){
			if(lista.get(i) == n){
				System.out.println("# El numero: " + n + " pertenece a la lista");
				return true;
			} 
		}
		System.out.println("# El numero: " + n + " no pertenece a la lista");
		return false;
	}
}