package Logik;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public interface Persistenz {

	public void speichern() throws IOException;
	

	public void  laden() throws IOException, ClassNotFoundException;
	
}