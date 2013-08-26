package com.shoppinglist;

import java.util.LinkedList;

import com.receipt.Ingredient;

public class ShoppingList {
	private LinkedList<Ingredient> list;
	
	public ShoppingList(LinkedList<Ingredient> list){
		this.list=list;
	}

	public LinkedList<Ingredient> getList() {
		return list;
	}

	public void setList(LinkedList<Ingredient> list) {
		this.list = list;
	}
	
}
