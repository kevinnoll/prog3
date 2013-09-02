package com.receipt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iD;
	private String name;
	private int duration;
	private Difficulty difficulty;
	private String receipt;
	private LinkedList<Ingredient> ingredientList;
	private Course course;
	private String category;
	private ImageIcon image;

	//TODO	private LinkedList<String> tagList;

	public Receipt(int iD, String name, String receipt, int duration, Difficulty difficulty, Course course, LinkedList<Ingredient> ingredientList, String category) {
		this.iD = iD;
		this.name = name;
		this.receipt = receipt;
		this.duration = duration;
		this.difficulty = difficulty;
		this.ingredientList = ingredientList;
		this.course = course;
		this.category = category;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	@Override
//	public String toString() {
//		return "Receipt [iD=" + iD + ", name=" + name + ", duration=" + duration + ", difficulty=" + difficulty + ", receipt=" + receipt + ", ingredientList="
//				+ ingredientList + ", course=" + course + ", category=" + category + "]";
//	}
	
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(File image) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(image);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		this.image = new ImageIcon(img, "bild");
	}
	

	@Override
	public String toString(){
		return name;
	}

}
