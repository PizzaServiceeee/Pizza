package Logik;

public class Zutaten {
	
	private boolean cheese;
	private boolean salami;
	private boolean thunfisch;
	private boolean spinat;
	
	
	public Zutaten(boolean cheese, boolean salami, boolean thunfisch, boolean spinat) {
		this.cheese = cheese;
		this.salami = salami;
		this.thunfisch = thunfisch;
		this.spinat = spinat;
	}


	public boolean isCheese() {
		return cheese;
	}


	public void setCheese(boolean cheese) {
		this.cheese = cheese;
	}


	public boolean isSalami() {
		return salami;
	}


	public void setSalami(boolean salami) {
		this.salami = salami;
	}


	public boolean isThunfisch() {
		return thunfisch;
	}


	public void setThunfisch(boolean thunfisch) {
		this.thunfisch = thunfisch;
	}


	public boolean isSpinat() {
		return spinat;
	}


	public void setSpinat(boolean spinat) {
		this.spinat = spinat;
	}



}
