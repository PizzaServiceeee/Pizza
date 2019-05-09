package Logik;

import java.util.Calendar;
import java.util.Date;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

public class Gutschein {
	
	private Pizza pizza;
	private String date;
	private boolean gutschein = false;
	
	public boolean isGutschein() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(2019,05,02));
		boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
		
		if(monday == true) {
			return true;
		}else {
			return false;
		}
		
	}
	

	
	
	
}


