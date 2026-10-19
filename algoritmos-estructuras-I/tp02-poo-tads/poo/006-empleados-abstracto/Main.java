import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Empleado> empleado = new ArrayList<>();

		EmpleadoPorHora eh1 = new EmpleadoPorHora("Goblin Machine", 0, 4.00f, 4000f); 
		EmpleadoMensual em1 = new EmpleadoMensual("Pepito el mago", 100);  
		
		empleado.add(eh1);
		empleado.add(em1);

		for(int i = 0; i < empleado.size(); i++){
			Empleado e = empleado.get(i);
			e.calcularPago();
		}
	}
}