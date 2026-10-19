public class Triangulo extends Figura {
	private float base;
	private float altura;
	private float a;
	private float b;
	private float c;

	public Triangulo(float base, float altura, float a, float b, float c){
		this.base = base;
		this.altura = altura;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float getBase(){
		return this.base;
	}

	public float getAltura(){
		return this.altura;
	}

	public float getA(){
		return this.a;
	}

	public float getB(){
		return this.b;
	}

	public float getC(){
		return this.c;
	}

	@Override
	public void setArea(){
		float area = (this.base * this.altura) / 2;
		System.out.println("# El area de este triangulo es: " + area);
	}

	@Override
	public void setPerimetro(){
		float perimetro = this.a + this.b + this.c;
		System.out.println("# El perimetro de este triangulo es: " + perimetro);
	}
}