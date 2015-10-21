package interfaces;


public abstract class MusicInstrument  implements Cleanable {
	
	static class Trombon extends MusicInstrument {
		@Override
		public void clean() {
			System.out.println("cleaning tube and keys of trombon");
		}
	}

	static class Drum extends MusicInstrument {
		@Override
		public void clean() {
			System.out.println("cleaning skin and sides of drum");
		}
	}
	
}
