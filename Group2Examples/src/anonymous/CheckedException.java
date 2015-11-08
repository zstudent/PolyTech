package anonymous;

public class CheckedException {
	
	
	public static void main(String[] args) {
		
		try {
			a();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private static void a() throws InterruptedException {
		Thread.sleep(1000);
	}
	

}
