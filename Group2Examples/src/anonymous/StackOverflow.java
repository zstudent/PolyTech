package anonymous;

import java.util.ArrayList;
import java.util.List;

public class StackOverflow {

	static List<long[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		a();
	}

	private static void a() {
		list.add(new long[1000000]);
		a();
	}
	
}
