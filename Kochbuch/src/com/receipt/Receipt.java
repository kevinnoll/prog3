package com.receipt;

import java.io.Serializable;
import java.util.LinkedList;

public class Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int duration;
	private Difficulty difficulty;
	private String receipt;
	private LinkedList<Ingredient> ingredientList;
//TODO	private LinkedList<String> tagList;
	
	public Receipt(String name, String receipt, int duration, Difficulty difficulty, LinkedList<Ingredient> ingredientList){
		this.name=name;
		this.receipt=receipt;
		this.duration=duration;
		this.difficulty=difficulty;
		this.ingredientList=ingredientList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public LinkedList<Ingredient> getIngredients() {
		return ingredientList;
	}

	public void setIngredients(LinkedList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	@Override
	public String toString() {
		return "" + name + "    " + duration + "min    " + difficulty;
	}
	
	
}
