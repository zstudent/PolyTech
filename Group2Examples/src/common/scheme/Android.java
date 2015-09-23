package common.scheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Android {
	
	private static List<Application> appList = new ArrayList<Application>();
	
	public static void main(String[] args) {
		
		System.out.println("starting android system");
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			System.out.println(nextLine);
			process(nextLine);
		}
		
		
	}

	private static void process(String nextLine) {
		
		String[] words = nextLine.split(" ");
		
		switch (words[0]) {
		case "touch":
			for (Application application : appList) {
				application.onTouch();
			}
			break;
		case "swipe": 
			// TODO do something
			break;
		case "load": 
			load(words);
			break;
		}
		
	}

	private static void load(String[] words) {
		if (words.length < 2) {
			return;
		}
		String appName = words[1];
		System.out.println("loading " + appName);
		
		try {
			Class<?> appClass = Class.forName(appName);
			System.out.println(appClass.getName());
			if (!Application.class.isAssignableFrom(appClass)) {
				System.out.println("must be application");
				return;
			}
			
			Application app = (Application) appClass.newInstance();
			
			appList.add(app);
			
			app.start();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
