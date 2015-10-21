package inners;


public class Dog {
	

	interface Brain {
		void feed();
		void stroke();
	}
	
	private class Fed implements Brain {
		
		private static final int STROKE_BOUND = 3;
		int strokeCount;
		
		@Override
		public void feed() {
			Dog.this.bark(); Dog.this.wag();
		}
		
		@Override
		public void stroke() {
			Dog.this.wag(); Dog.this.wag();
			if (++strokeCount > STROKE_BOUND ) {
				Dog.this.brain = Dog.this.new Hungry();
			}
		}
	}
	
	private class Hungry implements Brain {
		@Override
		public void feed() {
			eat();
			wag();
			brain = new Fed();
		}

		@Override
		public void stroke() {
			bark(); bite();
		}
	}
	
	private Brain brain = new Hungry();
	
	public void feed() {
		brain.feed();
	}
	
	public void stroke() {
		brain.stroke();
	}

	private void bite() {
		System.out.println("bites");
	}

	private void bark() {
		System.out.println("barks");
	}

	private void wag() {
		System.out.println("wags");
	}

	private void eat() {
		System.out.println("eats");
	}


}
