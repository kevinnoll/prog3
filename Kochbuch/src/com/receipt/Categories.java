package com.receipt;

import java.util.LinkedList;
import java.util.List;

import com.forms.Kochbuch;
import com.serializer.CategorieSerializer;

public class Categories extends LinkedList<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Categories instance = null;
	
	private Categories() {
		add("Alle");
		add("Favoriten");
		add("Fleischgerichte");
		add("Regional");
		add("Asiatisch");
		add("Vegetarisch");
		add("Nudelgerichte");
		add("Fischgerichte");
		add("Suppen");
		add("Suesses");
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
