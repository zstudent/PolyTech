package interfaces;

public abstract class Furniture implements Cleanable {
	
	static class Table extends Furniture {
		@Override
		public void clean() {
			System.out.println("cleaning surface of table");
		}
	}

	static class Chair extends Furniture {
		@Override
		public void clean() {
			System.out.println("cleaning surface and back of chair");
		}
	}
	
}
