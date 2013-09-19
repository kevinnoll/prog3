package com.receipt;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.forms.Kochbuch;
import com.serializer.CategorieSerializer;

public class Categories extends LinkedList<String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Categories instance = null;
	
	private Categories() {
		add("Alle");
		add("Favoriten");
		add("Kartoffeln");
		add("Rindfleisch");
		add("Hähnchen");
		add("Schweinefleisch");
		add("Asiatisch");
		add("Tomatig");
		add("Vegetarisch");
		add("Nudelgerichte");
		add("Fischgerichte");
		add("Suppen");
		add("Vorspeisen");
		add("Dessert");		
	}

	public static synchronized Categories getInstance() {
		if (instance == null) {
			if ((instance = CategorieSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + CategorieSerializer.CATEGORIES_FILE)) == null) {
				instance = new Categories();
			}	
		}
		return instance;
	}
}
