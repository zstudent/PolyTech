package common.scheme;

public class Hello extends Application {

	@Override
	public void start() {
		System.out.println("Hello");
	}

	@Override
	public void onTouch() {
		System.out.println("Hello app is touched");
	}

	@Override
	public void onSwipe() {
	}

}
