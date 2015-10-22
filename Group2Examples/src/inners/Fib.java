package inners;


public class Fib {
	
	interface Fibonacci {
		int fib(int n);
	}
	
	static Fibonacci recursive = new Fibonacci() {
		@Override
		public int fib(int n) {
			if (n < 2) {
				return n;
			}
			return fib(n-2) + fib(n-1);
		}
	};
	
	
	public static void main(String[] args) {
		
//		int f = recursive.fib(45);
//		System.out.println(f);
		
		System.out.println(run(recursive, 45));
		
	}
	
	public static long run(Fibonacci method, int n) {
		long start = System.nanoTime();
		method.fib(n);
		long stop = System.nanoTime();
		return stop - start;
	}

}
