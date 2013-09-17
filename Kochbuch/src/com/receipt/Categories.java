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
		add("Alle");
		add("Favoriten");
		add("Fleischgerichte");
		add("Regional");
		add("Asiatisch");
		add("Vegetarisch");
		add("Nudelgerichte");
		add("Fischgerichte");
		add("Suppen");
		add("Süßes");
	}

	public static synchronized Categories getInstance() {
		if (instance == null) {
			instance = new Categories();
		}
		return instance;
	}
}
