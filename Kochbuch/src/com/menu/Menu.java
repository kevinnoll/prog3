package com.menu;

import com.receipt.Receipt;

public class Menu {

	private int iD;
	private String name;
	private Receipt starter;
	private Receipt main;
	private Receipt dessert;
	
	public Menu(int iD, String name, Receipt starter, Receipt main, Receipt dessert) {
		super();
		this.iD = iD;
		this.name = name;
		this.starter = starter;
		this.main = main;
		this.dessert = dessert;
	}
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Receipt getStarter() {
		return starter;
	}
	public void setStarter(Receipt starter) {
		this.starter = starter;
	}
	public Receipt getMain() {
		return main;
	}
	public void setMain(Receipt main) {
		this.main = main;
	}
	public Receipt getDessert() {
		return dessert;
	}
	public void setDessert(Receipt dessert) {
		this.dessert = dessert;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
