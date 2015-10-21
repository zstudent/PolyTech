package interfaces;

import interfaces.Furniture.Chair;
import interfaces.Furniture.Table;
import interfaces.MusicInstrument.Drum;
import interfaces.MusicInstrument.Trombon;

public class InterfaceExample {
	
	public static void main(String[] args) {
		
		Trombon trombon = new Trombon();
		Table table = new Table();
		Chair chair = new Chair();
		Drum drum = new Drum();

		trombon.clean();
		table.clean();
		chair.clean();
		drum.clean();
		
		cleanAll(trombon, table, chair, drum);
//		cleanMusicInstruments(trombon, drum);
		
	}
	
	public static void cleanAll(Cleanable... objects) {
		for (Cleanable object : objects) {
			object.clean();
		}
	}

//	public static void cleanMusicInstruments(MusicInstrument... objects) {
//		for (MusicInstrument object : objects) {
//			object.clean();
//		}
//	}
	
}
