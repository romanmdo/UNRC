abstract class Empleado { 
	private String nombre;
	private float salarioTotal;

	public abstract float calcularPago();

	public Empleado(String nombre, float salarioTotal){
		this.nombre = nombre;
		this.salarioTotal = salarioTotal;
	}

	public String getName(){
		return this.nombre;
	}

	public float getSalarioTotal(){
		return this.salarioTotal;
	}
}