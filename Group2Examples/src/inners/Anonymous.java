package inners;

import interfaces.Cleanable;

public class Anonymous {
	
	public static void main(String[] args) {
		
		Cleanable c = new Cleanable() {
			@Override
			public void clean() {
				System.out.println("cleaning something");
			}
		};
		
		cleanIt(c);
		
		Object o = new Object() {
			
			public void supeeerCool() {
				
			}
		};
		
	}

	private static void cleanIt(Cleanable c) {
		
	}

}
