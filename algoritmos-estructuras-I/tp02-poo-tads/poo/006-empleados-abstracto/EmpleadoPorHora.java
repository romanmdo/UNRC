public class EmpleadoPorHora extends Empleado {
	private float horasTrabajadas;
	private float tarifaPorHora;

	public EmpleadoPorHora(String nombre, float salarioTotal, float horasTrabajadas, float tarifaPorHora){
		super(nombre, salarioTotal);
		this.horasTrabajadas = horasTrabajadas;
		this.tarifaPorHora = tarifaPorHora;
	}

	@Override
	public float calcularPago(){
		float salarioTotal = this.tarifaPorHora * this.horasTrabajadas;
		System.out.println("# El pago de: " + getName() + " es de: " + salarioTotal);
		return salarioTotal;
	}
}