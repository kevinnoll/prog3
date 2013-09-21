package com.forms;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	public static int language; // 1 = German
	public static String BUNDLE_NAME = "com.forms.kochbuch_de"; //$NON-NLS-1$
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static void refresh(){
		if(language == 1){
			BUNDLE_NAME = "com.forms.kochbuch_en";
		} else {
			BUNDLE_NAME = "com.forms.kochbuch_de";
		}
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	}
	
	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
