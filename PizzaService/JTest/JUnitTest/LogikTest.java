package JUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Logik.Pizza;
import Logik.Warenkorb;

public class LogikTest {
	
	@Test
	public void warenkorbAddTest() {
		Warenkorb warenkorb = new Warenkorb();
		Pizza pizza = Pizza.getInstance("Salami", 10, "medium", "cheeseCrust");
		warenkorb.add(pizza);	
		assertEquals("Der Warenkorb sollte 1 Pizza beinhalten", 1, warenkorb.getWarenkorb().size());
	}
	@Test
	public void getWarenkorbListTest() {
		List<Pizza> testList = new ArrayList<Pizza>();
		Warenkorb warenkorb = new Warenkorb();
		Pizza pizza = Pizza.getInstance("testName", 10, "testGroesse", "testCrust");
		warenkorb.add(pizza);
		testList = warenkorb.getWarenkorb();
		assertNotNull("getWarenkorb gibt die Liste korrekt zurueck", testList);
	}
	@Test
	public void setWarenkorbListTest() {
		List<Pizza> testList = new ArrayList<Pizza>();
		Warenkorb warenkorb = new Warenkorb();
		Pizza pizza = Pizza.getInstance("testName", 10, "testGroesse", "testCrust");
		testList.add(pizza);
		warenkorb.setWarenkorb(testList);
		assertNotNull("setWarenkorb speichert die Liste korrekt", warenkorb.getWarenkorb());
	}
	@Test
	public void preisTest() {
		Warenkorb warenkorb = new Warenkorb();
		Pizza pizza1 = Pizza.getInstance("testName", 10, "testGroesse", "testCrust");
		Pizza pizza2 = Pizza.getInstance("testName", 10, "testGroesse", "testCrust");
		Pizza pizza3 = Pizza.getInstance("testName", 10, "testGroesse", "testCrust");
		warenkorb.add(pizza1);
		warenkorb.add(pizza2);
		warenkorb.add(pizza3);
		double i = warenkorb.preis(warenkorb.getWarenkorb());
		assertSame("Der Preis sollte 30 betragem", 30, warenkorb.preis(warenkorb.getWarenkorb()));
	}
	

}
