package Logik;

public class Besteck {

	boolean besteck = false;
	
	public static Besteck dasBesteck;
	
	private Besteck() {
		
	}
	
	public static Besteck getInstance() {
		if(dasBesteck == null) {
			dasBesteck = new Besteck();
		}
		
		return dasBesteck;
	}
	
	public boolean getBesteck() {
		return besteck;
	}
	
	public void setBesteck(boolean besteck) {
		this.besteck = besteck;
	}

}
