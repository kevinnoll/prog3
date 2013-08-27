package com.receipt;

import java.util.LinkedList;
import java.util.List;

public class Categories extends LinkedList<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Categories instance = null;
	
	private Categories() {
		add("Kartoffeln");
		add("Rindfleisch");
		add("Hühnchen");
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
			instance = new Categories();
		}
		return instance;
	}
}
