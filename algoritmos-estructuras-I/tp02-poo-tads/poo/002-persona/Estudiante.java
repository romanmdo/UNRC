public class Estudiante extends Persona{
	private boolean esRegular;
	private float promedio;
	private int cantidadMateriasAprobadas;

	public Estudiante(int dni, String nombre, String apellido, boolean esRegular, float promedio, int cantidadMateriasAprobadas){
		super(dni, nombre, apellido);
		this.esRegular = esRegular;
		this.promedio = promedio;
		this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
	}

	public boolean getCondicion(){
		System.out.println("# Condicion: " + this.esRegular);
		return this.esRegular;
	}

	public float getPromedio(){
		System.out.println("# Promedio: " + this.promedio);
		return this.promedio;
	}

	public int getCantidadMaterias(){
		System.out.println("# Cantidad de materias aprobadas: " + this.cantidadMateriasAprobadas);
		return this.cantidadMateriasAprobadas;
	}

	public void aproboMateria(int nota) {
        if (nota >= 5) {
            this.promedio = ((this.promedio * this.cantidadMateriasAprobadas) + nota) 
            / (this.cantidadMateriasAprobadas + 1);
            this.cantidadMateriasAprobadas++;
            System.out.println("# Nuevo promedio: " + this.promedio + "/ Materias aprobadas: " + this.cantidadMateriasAprobadas);
        } else { 
            this.promedio = ((this.promedio * this.cantidadMateriasAprobadas) + nota) 
            / (this.cantidadMateriasAprobadas == 0 ? 1 : this.cantidadMateriasAprobadas);
            System.out.println("# Nuevo promedio: " + this.promedio + "Materias aprobadas: " + this.cantidadMateriasAprobadas);
        }
    }
}