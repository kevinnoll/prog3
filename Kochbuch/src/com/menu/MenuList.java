package com.menu;

import java.util.LinkedList;

import com.receipt.Categories;

public class MenuList extends LinkedList<Menu>{
	private static MenuList instance = null;
	
	public static synchronized MenuList getInstance() {
		if (instance == null) {
			instance = new MenuList();
		}
		return instance;
	}
}
