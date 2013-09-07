package com.factories;

import java.io.File;
import java.util.LinkedList;

import com.receipt.Categories;
import com.receipt.Course;
import com.receipt.Difficulty;
import com.receipt.Entity;
import com.receipt.Ingredient;
import com.receipt.Receipt;

public class MenuEntries {
	public static Receipt get_Burger() {
		Ingredient ingredient1 = new Ingredient("Rinderhack", Entity.g, 150);
		Ingredient ingredient2 = new Ingredient("Salz", Entity.g, 10);
		Ingredient ingredient5 = new Ingredient("Pfeffer", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Salat", Entity.Stück, 1);
		Ingredient ingredient4 = new Ingredient("Brötchen", Entity.Stück, 1);
		Ingredient ingredient6 = new Ingredient("Ketchup", Entity.Milliliter, 20);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Burger";
		String anleitung = "Das Hackfleisch mit dem Salz und dem Pfeffer würzen, eine flache Scheibe formen ganz durchbraten."
				+ " Das Brötchen in der in der Hälfte aufschneiden, nach Wunsch toasten und mit dem Ketchup nach Belieben bestreichen."
				+ " Das fertig gebratene Hackfleisch aus der Pfanne nehmen und auf den Ketchup legen. Anschließend mit Salat garnieren. Fertig. ";

		Receipt receipt = new Receipt(0, rezeptname, anleitung, 25, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/burger.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt get_Burger2() {
		Ingredient ingredient1 = new Ingredient("Rinderhackz", Entity.g, 150);
		Ingredient ingredient2 = new Ingredient("Salzz", Entity.g, 10);
		Ingredient ingredient5 = new Ingredient("Pfefferz", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Salatz", Entity.Stück, 1);
		Ingredient ingredient4 = new Ingredient("Brötchenz", Entity.Stück, 1);
		Ingredient ingredient6 = new Ingredient("Ketchupz", Entity.Milliliter, 20);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Burgerz";
		String anleitung = "Das Hackfleisch mit dem Salz und dem Pfeffer würzen, eine flache Scheibe formen ganz durchbraten."
				+ " Das Brötchen in der in der Hälfte aufschneiden, nach Wunsch toasten und mit dem Ketchup nach Belieben bestreichen."
				+ " Das fertig gebratene Hackfleisch aus der Pfanne nehmen und auf den Ketchup legen. Anschließend mit Salat garnieren. Fertig. ";

		Receipt receipt = new Receipt(0, rezeptname, anleitung, 25, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/burger.jpg");
		receipt.setImage(file);
		return receipt;
	}

	public static Receipt get_Kartoffeln() {
		Ingredient ingredient1 = new Ingredient("Kartoffel", Entity.kg, 1);
		Ingredient ingredient2 = new Ingredient("Salz", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Wasser", Entity.Liter, 2.5);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);

		String rezeptname = "Salzkartoffeln";
		String anleitung = "Alles zusamnwerfen und 25 minuten kochen(außer die Petersilie"
				+ ") dann mit der Gabel prüfen ob die Kartoffeln weich sind und das Wasser abgießen und die Petersilie " + "drüberstreuen. Fertig.";

		Receipt receipt = new Receipt(1, rezeptname, anleitung, 25, Difficulty.einfach, Course.Vorspeise, ingredients, Categories.getInstance().get(1));
		File file = new File("images/salzkartoffeln.png");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt get_Kartoffeln2() {
		Ingredient ingredient1 = new Ingredient("Kartoffelzz", Entity.kg, 1);
		Ingredient ingredient2 = new Ingredient("Salzz", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Wasserz", Entity.Liter, 2.5);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);

		String rezeptname = "Salzkartoffelnzzz";
		String anleitung = "Alles zusamnwerfen und 25 minuten kochen(außer die Petersilie"
				+ ") dann mit der Gabel prüfen ob die Kartoffeln weich sind und das Wasser abgießen und die Petersilie " + "drüberstreuen. Fertig.";

		Receipt receipt = new Receipt(1, rezeptname, anleitung, 25, Difficulty.einfach, Course.Vorspeise, ingredients, Categories.getInstance().get(1));
		File file = new File("images/salzkartoffeln.png");
		receipt.setImage(file);
		return receipt;
	}

	public static Receipt get_Eis() {
		Ingredient ingredient1 = new Ingredient("Milch", Entity.Milliliter, 100);
		Ingredient ingredient2 = new Ingredient("Schokolade, zartbitter", Entity.g, 50);
		Ingredient ingredient3 = new Ingredient("Schokolade, Vollmilch", Entity.g, 50);
		Ingredient ingredient4 = new Ingredient("Sahne", Entity.g, 200);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		String rezeptname = "Schokoladeneis";
		String anleitung = "Die Milch erwärmen. Schokolade darin schmelzen und abkühlen lassen. Sahne mit dem Puderzucker halbsteif schlagen. Die abgekühlte Schokomasse unter die Sahne rühren. Mischung in die Eismaschine füllen und nach Herstellerangaben gefrieren lassen.";
		Receipt receipt = new Receipt(2, rezeptname, anleitung, 25, Difficulty.einfach, Course.Dessert, ingredients, Categories.getInstance().get(12));
		File file = new File("images/schokoeis.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt get_Eis6() {
		Ingredient ingredient1 = new Ingredient("Milc6h", Entity.Milliliter, 100);
		Ingredient ingredient2 = new Ingredient("Schokolade5, zartbitter", Entity.g, 50);
		Ingredient ingredient3 = new Ingredient("Schokoladze, Vollmilch", Entity.g, 50);
		Ingredient ingredient4 = new Ingredient("Sahnez", Entity.g, 200);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		String rezeptname = "Schokoladeneiszz";
		String anleitung = "Die Milch erwärmen. Schokolade darin schmelzen und abkühlen lassen. Sahne mit dem Puderzucker halbsteif schlagen. Die abgekühlte Schokomasse unter die Sahne rühren. Mischung in die Eismaschine füllen und nach Herstellerangaben gefrieren lassen.";
		Receipt receipt = new Receipt(2, rezeptname, anleitung, 25, Difficulty.einfach, Course.Dessert, ingredients, Categories.getInstance().get(12));
		File file = new File("images/schokoeis.jpg");
		receipt.setImage(file);
		return receipt;
	}
}
