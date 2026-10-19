public class Rectangulo extends Figura {
	private float base;
	private float altura;

	public Rectangulo(float base, float altura){
		this.base = base;
		this.altura = altura;
	}

	public float getBase(){
		return this.base;
	}

	public float getAltura(){
		return this.altura;
	}

	@Override
	public void setArea(){
		float area = this.base * this.altura;
		System.out.println("# El area de este rectangulo es: " + area);
	}

	@Override
	public void setPerimetro(){
		float perimetro = (this.base + this.altura) * 2;
		System.out.println("# El perimetro de este rectangulo es: " + perimetro);
	}
}