public class Main {
	public static void main(String[] args) {
		Estudiante p = new Estudiante(1, "Pepito", "El mago", true, 7.00f, 3);

		System.out.println("______________________________________________");
		// Metodos de persona
		p.getDni();
		p.getName();
		p.getSurname();

		// Metodos de estudiante
		p.getCondicion();
		p.getPromedio();
		p.getCantidadMaterias();

		// Metodos auxiliares
		p.aproboMateria(9);
		System.out.println("______________________________________________");

		Estudiante[] estudiantes = {
		    new Estudiante(2, "Goblin", "Machine", true, 7.00f, 3),
		    new Estudiante(3, "Elver", "Gudo", false, 5.00f, 4)
		};

		for(int i = 0; i < estudiantes.length; i++){
			System.out.println(estudiantes[i].getName() + estudiantes[i].getSurname() + estudiantes[i].getDni());
			System.out.println("______________________________________________");
		}
	}
}