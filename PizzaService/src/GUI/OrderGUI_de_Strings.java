package GUI;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class OrderGUI_de_Strings {
	private static final String BUNDLE_NAME = "GUI.OrderGUI_de"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private OrderGUI_de_Strings() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
