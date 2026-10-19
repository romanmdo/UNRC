package _006_lista_TAD;

public class Main {
	public static void main(String[] args) {
		Lista<Character> la1 = new ListaEnlazada<>();
		Lista<Character> la2 = new ListaArreglo<>();

		// Testeos - Implementacion con listas enlazadas
		la1.insertarFin('Z');
		la1.insertarInicio('A');
		la1.insertarPos('B', 1);
		la1.insertarPos('C', 2);
		la1.insertarPos('D', 3);
		la1.imprimir();

		la1.eliminarPos(2);
		System.out.println("______________________");
		la1.imprimir();
		la1.buscar('C');
		la1.getPos(2);

		// Testeos - Implementacion con arreglos
		la2.insertarInicio('A');
		la2.insertarFin('U');
		la2.insertarPos('E', 1);
		la2.insertarPos('I', 2);
		la2.insertarPos('O', 3);
		la2.imprimir();

		la2.eliminarPrimero();
		la2.eliminarUltimo();
		la2.imprimir();

		la2.insertarInicio('A');
		la2.insertarFin('U');
		la2.getPrimero();
		la2.getUltimo();
		la2.getPos(3);

		


	}
}



