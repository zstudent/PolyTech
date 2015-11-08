package anonymous;


public class ExLocal {
	
	public static void main(String[] args) {
		
		int x = 10;
		
		class Task implements Runnable {
			@Override
			public void run() {
				System.out.println("Hello " + x); // inner.x = x;
			}
		};
		
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		
		
		
	}
	

}
