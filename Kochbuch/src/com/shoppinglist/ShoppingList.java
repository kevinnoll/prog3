package com.shoppinglist;

import java.util.LinkedList;

import com.receipt.Categories;
import com.receipt.Ingredient;

public class ShoppingList extends LinkedList<Ingredient> {
	
	private static ShoppingList instance;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShoppingList(){
	}
	
	public static synchronized ShoppingList getInstance() {
		if (instance == null) {
			instance = new ShoppingList();
		}
		return instance;
	}
}
