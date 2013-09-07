package com.menu;

import java.util.LinkedList;

public class MenuList extends LinkedList<Menu>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MenuList instance = null;
	
	public static synchronized MenuList getInstance() {
		if (instance == null) {
			instance = new MenuList();
		}
		return instance;
	}
}
