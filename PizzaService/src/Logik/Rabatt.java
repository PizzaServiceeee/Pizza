//package Logik;
//
//import java.util.Calendar;
//import java.util.Date;
//
//public class Rabatt {
//	
//	private final double percent = 10.0;
//	double newPrice;
//	PizzaManager manager;
//	public Rabatt() {
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date(2019,05,02));
//		boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
//		
//		if(monday == true) {
//			for(int i = 0; i<manager.getPizzaList().size(); i++) {
//				double price = manager.getPizzaList().get(i).getPrice();		
//				double ergebnis = price/percent * 100.0;
//				newPrice = Math.round(ergebnis);
//				manager.getPizzaList().get(i).setPrice(newPrice);
//			}
//		}
//		
//		
//	}
//	
//	public double getRabatt() {
//		
//		return newPrice;
//		
//	}
//	
//	
//	
//	
//}
