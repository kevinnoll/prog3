package com.receipt;

import java.awt.Image;
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
	private File imagefile;
	private ImageIcon icon;
	private ImageIcon icon_big;

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
		setImagefile(image);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(image);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		this.image = new ImageIcon(img, "bild");
		setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		setIcon_big(new ImageIcon(img.getScaledInstance(105, 105, Image.SCALE_SMOOTH)));
	}
	
	

	public File getImagefile() {
		return imagefile;
	}

	public void setImagefile(File imagefile) {
		this.imagefile = imagefile;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	
	
	public ImageIcon getIcon_big() {
		return icon_big;
	}

	public void setIcon_big(ImageIcon icon_big) {
		this.icon_big = icon_big;
	}

	@Override
	public String toString(){
		return name;
	}

}
