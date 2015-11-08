package anonymous;


public class Ex {
	
	public static void main(String[] args) {
		
		int x = 10;
		
		Runnable r = new Runnable () {
			@Override
			public void run() {
				System.out.println("Hello " + x); // inner.x = x;
			}
		};
		
		new Thread(r).start();
		
	}
	

}
