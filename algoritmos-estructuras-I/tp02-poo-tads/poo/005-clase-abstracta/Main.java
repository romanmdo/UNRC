import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Figura> figuras = new ArrayList<>();

		Circulo c1 = new Circulo(5); // <-- Ingresar Radio
		Rectangulo r1 = new Rectangulo(6, 3); // <-- Ingresar Base y Altura 
		Triangulo t1 = new Triangulo(6, 4, 5, 6, 7); // <-- Ingresar Base, Altura, Lados A, B y C 
		
		figuras.add(c1);
		figuras.add(r1);
		figuras.add(t1);

		for(int i = 0; i < figuras.size(); i++){
			Figura f = figuras.get(i);
			f.setArea();
		}
	}
}