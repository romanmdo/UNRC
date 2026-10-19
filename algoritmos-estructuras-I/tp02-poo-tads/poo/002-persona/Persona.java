public class Persona {
	private int dni;
	private String nombre;
	private String apellido;

	public Persona(int dni, String nombre, String apellido){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getDni(){
		System.out.println("# DNI: " + this.dni);
		return this.dni;
	}

	public String getName(){
		System.out.println("# Nombre: " + this.nombre);
		return this.nombre;
	}

	public String getSurname(){
		System.out.println("# Apellido: " +this.apellido);
		return this.apellido;
	}
}