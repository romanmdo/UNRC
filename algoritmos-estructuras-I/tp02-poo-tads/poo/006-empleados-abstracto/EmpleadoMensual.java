public class EmpleadoMensual extends Empleado {
	public EmpleadoMensual(String nombre, float salarioTotal){
		super(nombre, salarioTotal);
	}

	@Override
	public float calcularPago(){
		System.out.println("# El pago de: " + getName() + " es de: " + getSalarioTotal());
		return getSalarioTotal();
	}
}