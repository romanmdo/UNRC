public class Caja<T> {
	private T contenido; 

	public Caja(T contenido){
		this.contenido = contenido;
	}

	public void saveItem(T item){
		this.contenido = item;
	}

	public void getInfo(){
		System.out.println("# El item almacenado es: " + this.contenido);
	}

	public T getItem(){
		return this.contenido;
	}
}
