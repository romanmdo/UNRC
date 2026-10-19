public class Main {
	public static void main(String[] args) {
		Caja<String> c1 = new Caja<>("Pepito el mago");
		Caja<String> c2 = new Caja<>("Goblin Machine");

		c1.getInfo();
		c2.getInfo();
		c1.getItem();
	}
}



