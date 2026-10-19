public class Circulo extends Figura {
	private float radio;

	public Circulo(float radio){
		this.radio = radio;
	}

	public float getRadio(){
		return this.radio;
	}

	@Override
	public void setArea(){
		float pi = 3.1416f;
		float area = (this.radio * this.radio) * pi;
		System.out.println("# El area de este circulo es: " + area);
	}

	@Override
	public void setPerimetro(){
		float pi = 3.1416f;
		float perimetro = 2 * pi * this.radio;
		System.out.println("# El perimetro de este circulo es: " + perimetro);
	}
}