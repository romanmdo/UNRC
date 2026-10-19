package _003_pertenece;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Pertenece p = new Pertenece();

		p.getPertenece(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 6);
		// List.of crea una lista inmutable
		// ArrayList<> copia la lista y la deja mutable
	}
}