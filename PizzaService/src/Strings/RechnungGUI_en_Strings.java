package Strings;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class RechnungGUI_en_Strings {
	private static final String BUNDLE_NAME = "Properties.RechnungGUI_en"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private RechnungGUI_en_Strings() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
