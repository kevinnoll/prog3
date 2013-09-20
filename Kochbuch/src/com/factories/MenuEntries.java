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
	
	//Fleischgerichte - Yannic
	
	public static Receipt getMeat1() {
		Ingredient ingredient1 = new Ingredient("Hackfleisch vom Rind", Entity.g, 500);
		Ingredient ingredient2 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Petersilie", Entity.Stueck, 1);
		Ingredient ingredient3 = new Ingredient("Oregano, getrocknet", Entity.TL, 1);
		Ingredient ingredient4 = new Ingredient("Piment - und Kreuzkuemmelpulver", Entity.TL, 0.5);
		Ingredient ingredient6 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient7 = new Ingredient("Weissbrot, vom Vortag (Schreiben)", Entity.Stueck, 2);
		Ingredient ingredient8 = new Ingredient("Ei(er)", Entity.Stueck, 2);
		Ingredient ingredient9 = new Ingredient("Feta-Kaese", Entity.g, 150);
		Ingredient ingredient10 = new Ingredient("oel (Olivenoel)", Entity.EL, 6);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);

		String rezeptname = "Beefsteaks mit Schafkaese";
		String anleitung = "Hack in eine Schuessel geben. Zwiebel schaelen, fein wuerfeln und hinzufuegen. Petersilie abspuelen, trocken schuetteln, die Haelfte der Blaettchen fein hacken und mit Oregano, Piment, Kreuzkuemmel und Salz unterruehren. Brot in Wasser einweichen, ausdruecken, mit den Eiern zum Fleisch geben. Alles miteinander verkneten, bis ein geschmeidiger Teig entstanden ist. Das Fleisch in 8 Portionen teilen. Einen Suppenteller mit kaltem Wasser ausspuelen. Je eine Portion in die Vertiefung legen und einen Fladen formen. In die Mitte jeder Hackfleischportion einen Teil Kaese geben, eine Fladenhaelfte darueber klappen und fest andruecken, damit der Kaese beim Braten nicht auslaufen kann. Die Beefsteaks im heissen Olivenoel in der Pfanne so lange braten, bis sie sich auf Druck mit dem Bratenwender fest anfuehlen. Mit Petersilie garniert servieren.";
				
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 30, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/meat_1.jpg");
		receipt.setImage(file);
		return receipt;
		
	}

	public static Receipt getMeat2() {
		Ingredient ingredient1 = new Ingredient("Haehnchenbrustfilet", Entity.g, 250);
		Ingredient ingredient2 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Butterschmalz", Entity.EL, 1);
		Ingredient ingredient3 = new Ingredient("Curry, Pulver", Entity.TL, 0.5);
		Ingredient ingredient4 = new Ingredient("Orangensaft", Entity.Milliliter, 100);
		Ingredient ingredient6 = new Ingredient("Huehnerbruehe", Entity.Milliliter, 100);
		Ingredient ingredient7 = new Ingredient("Sahne", Entity.Milliliter, 50);
		Ingredient ingredient8 = new Ingredient("Saucenbinder", Entity.TL, 0.5);
		Ingredient ingredient9 = new Ingredient("Apfel", Entity.Stueck, 1);
		Ingredient ingredient10 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient11 = new Ingredient("Pfeffer", Entity.Prise, 1);
		Ingredient ingredient12 = new Ingredient("Minze (Blaettchen)", Entity.Stueck, 1);
		Ingredient ingredient13 = new Ingredient("Mehl", Entity.Prise, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);
		ingredients.add(ingredient11);
		ingredients.add(ingredient12);
		ingredients.add(ingredient13);

		String rezeptname = "Curry - Haehnchen";
		String anleitung = "Die gesaeuberten Haehnchenbrustfilets quer zur Faser in fingerdicke Streifen schneiden. Die Zwiebel wuerfeln und in dem Butterschmalz erhitzen, die Haehnchenstreifen pfeffern und mit Mehl bestaeuben und mit der Zwiebel kraeftig anbraten, herausnehmen. Den Bratenfond mit Orangensaft und Bruehe abloeschen, mit Curry wuerzen und die Sahne angiessen. Mit dem Sossenbinder andicken und kurz aufkochen lassen. Das Fleisch wieder zugeben und erwaermen, nicht kochen. Den Apfel in kleine Wuerfel schneiden und ueber das Gericht streuen, mit den Minzeblaettchen garnieren. Dazu passt Reis oder Nudeln.";
				
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 40, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/meat_2.jpg");
		receipt.setImage(file);
		return receipt;
		
	}

	public static Receipt getMeat3() {
		Ingredient ingredient1 = new Ingredient("Hackfleisch vom Schwein", Entity.g, 600);
		Ingredient ingredient2 = new Ingredient("Knoblauch", Entity.Stueck, 3);		
		Ingredient ingredient5 = new Ingredient("Paprikapulver, rosenscharf", Entity.TL, 2);
		Ingredient ingredient3 = new Ingredient("Salz", Entity.TL, 0.5);
		Ingredient ingredient4 = new Ingredient("Pfeffer", Entity.TL, 1);
		Ingredient ingredient6 = new Ingredient("Backpulver", Entity.Packung, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Serbische Cevapcici";
		String anleitung = "Die Knoblauchzehen am besten mit einer kleinen Prise Salz in einem Moerser stampfen, mit dem Hackfleisch vermischen. Dann das Salz, den Pfeffer, die Rosenpaprika (wer mag nimmt scharfes Chilipulver) dazugeben und gut durchkneten. Zum Schluss das Backpulver dazugeben, dadurch werden die Cevapcici schoen locker. Noch etwa 5 Minuten weiterkneten (wie Teig), Fleischkugeln etwas groesser als Tischtennisbaelle formen und dann zur Rolle formen. Die Cevapcici mindestens 2 Stunden ziehen lassen vor dem Grillen - koennen aber auch in der Pfanne ausgebraten werden.";
				
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 30, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/meat_3.jpg");
		receipt.setImage(file);
		return receipt;
		
	}
	
	//Regional - Jan
			
	public static Receipt getRegio1() {
		Ingredient ingredient1 = new Ingredient("Lyoner", Entity.g, 600);
		Ingredient ingredient2 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Doerfleisch", Entity.g, 60);
		Ingredient ingredient3 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient4 = new Ingredient("Pfeffer", Entity.Prise, 1);
		Ingredient ingredient6 = new Ingredient("Kraeuter", Entity.Prise, 20);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Saarlaendische Lyonerpfanne";
		String anleitung = "Doerfleisch und Zwiebeln klein schneiden und anbraten. Lyoner und Pellkartoffel in Scheiben schneiden und dazugeben. Alles schoen anbraten und mit Salz, Pfeffer und Kraeuter abschmecken";

		Receipt receipt = new Receipt(0, rezeptname, anleitung, 30, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(3));
		File file = new File("images/regio_1.png");
		receipt.setImage(file);
		return receipt;
		
	}
		
	public static Receipt getRegio2() {
		Ingredient ingredient1 = new Ingredient("Mehl", Entity.g, 200);
		Ingredient ingredient2 = new Ingredient("Zucker", Entity.g, 50);
		Ingredient ingredient5 = new Ingredient("Staerke", Entity.EL, 1.5);
		Ingredient ingredient3 = new Ingredient("Fluessige Butter", Entity.EL, 6);
		Ingredient ingredient4 = new Ingredient("Wasser", Entity.Liter, 0.25);
		Ingredient ingredient6 = new Ingredient("Backpulver", Entity.Packung, 1);
		Ingredient ingredient7 = new Ingredient("Quetschen", Entity.Stueck, 30);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);

		String rezeptname = "Saarlaendischer Quetschenkuchen";
		String anleitung = 	"Das gesiebte Mehl mit Stärkemehl und Zucker vermischen , dann das"+ 
							"Wasser u. die flüssige Butter hinzugeben und zu einem glatten Teig verarbeiten. 30 Min . bei Zimmertemperatur abgedeckt ruhen lassen."+ 
							"Nach dem Ruhen erst das Backpulver dazugeben und nochmal gut durchrühren. Die Mischung ist relativ flüssig. Nun den Teig in eine ausfettete und bemehlte Backform giessen , glatt streichen und mit den geputzten, entkernten Quetschen ordentlich belegen."+ 
							"Im vorgeheizten Backofen so 30 - 35 Min. bei 170 ° C backen. Lauwarm mit einer Kugel"+ 
							"Vanilleneis und einem Klecks frischer Sahne servieren";
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 40, Difficulty.mittel, Course.Dessert, ingredients, Categories.getInstance().get(3));
		File file = new File("images/regio_2.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	public static Receipt getRegio3() {
		Ingredient ingredient1 = new Ingredient("grosse Kartoffeln", Entity.Stueck, 10);
		Ingredient ingredient2 = new Ingredient("Mehl", Entity.g, 700);
		Ingredient ingredient5 = new Ingredient("Eier", Entity.Stueck, 3);
		Ingredient ingredient3 = new Ingredient("Doerfleisch", Entity.g, 100);
		Ingredient ingredient4 = new Ingredient("Sahne", Entity.g, 250);
		Ingredient ingredient6 = new Ingredient("Mineralwasser", Entity.Liter, 0.4);
		Ingredient ingredient7 = new Ingredient("Maggi", Entity.Prise, 1);
		Ingredient ingredient8 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient9 = new Ingredient("Fleischbruehe", Entity.Prise, 1);
		Ingredient ingredient10 = new Ingredient("Oel", Entity.Prise, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);

		String rezeptname = "Saarlaendische Geheiratete";
		String anleitung = 	"In einem Topf mit möglichst grossem Durchmesser Wasser erhitzen. Wenn es"
							+ "kocht, Salz, gekörnte Brühe und Maggi hinzufügen (wichtig, um den Knödeln nachher Geschmack zu verleihen)."
							+ "Kartoffeln schälen und in nicht zu dicke Spalten schneiden, in das heisse Wasser geben und weich kochen. Sind die Kartoffeln weich, aus dem Wasser nehmen und in die Schüssel geben, in der die Mehlknödel serviert werden sollen."
							+ "Derweil Mehl in eine grosse Schüssel geben, mit einer Prise Salz würzen. Mineralwasser dazu geben, aber noch nicht umrühren. Eier und 1 Schuss Milch dazu, erst dann kräftig umrühren, so dass der Teig schaumig wird, aber nicht trocken (wer die Knödel lieber etwas fester mag, kann 1 Ei mehr hinzu tun). Mit einem Esslöffel nun portionsweise aus dem Teig die Mehlknödel abstechen (nie viel mehr Teig abstechen, als auf den Löffel passt) und ins kochende Wasser geben. Den Löffel dabei immer wieder in die Brühe tauchen, damit der Teig nicht klebt. Die Mehlknödel schwimmen dann auf der Brühe. Den Topf nicht abdecken. Nach etwa 10 bis 15 Minuten sind die Mehlknödel gar. Aus der Brühe schöpfen und auf die Kartoffeln in die Schüssel geben."
							+ "In einer separaten Pfanne den Schinken in Öl anbraten und mit dem Öl über die Mehlknödel geben. Sahne in die gleiche, noch heisse Pfanne geben und kurz aufkochen lassen, dann auch über die Knödel geben. Gleich servieren.";
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 30, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(3));
		File file = new File("images/regio_3.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	
	//Asiatisch - Kevin
	
	public static Receipt getAsia1() {
		Ingredient ingredient1 = new Ingredient("Hähnchenfilet", Entity.g, 600);
		Ingredient ingredient2 = new Ingredient("Paprikaschote", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Zuckerschoten", Entity.g, 80);
		Ingredient ingredient3 = new Ingredient("Peperoni", Entity.Stueck, 3);
		Ingredient ingredient4 = new Ingredient("Chilischoten", Entity.Stueck, 16);
		Ingredient ingredient6 = new Ingredient("Knoblauchzehen", Entity.Stueck, 6);
		Ingredient ingredient7 = new Ingredient("Thaibasilikum-Blätter (Krapao)", Entity.Stueck, 20);
		Ingredient ingredient8 = new Ingredient("Hühnerbrühe", Entity.Milliliter, 150);
		Ingredient ingredient9 = new Ingredient("Austernsauce", Entity.EL, 5);
		Ingredient ingredient10 = new Ingredient("Fischsauce", Entity.EL, 5);
		Ingredient ingredient11 = new Ingredient("Limettensaft", Entity.TL, 1);
		Ingredient ingredient12 = new Ingredient("dicke, süsse Sojasauce", Entity.TL, 1);
		Ingredient ingredient13 = new Ingredient("Öl zum anbraten", Entity.TL, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);
		ingredients.add(ingredient11);
		ingredients.add(ingredient12);
		ingredients.add(ingredient13);

		String rezeptname = "Thailändisches Hühnchen Krapauw";
		String anleitung = 	"Das Hähnchenfilet in der Küchenmaschine zu Hackfleisch verarbeiten und im Wok scharf anbraten. Den Knoblauch, die Chilis, die Zuckerschoten, die Peperoni und die Paprika zugeben und für 2 Minuten mitschmoren lassen. Mit Hühnerbrühe aufgiessen, Austern-, Fisch- und dicke süsse Soja-Sauce zufügen und 4 Minuten köcheln lassen."
							+ "Mit Limettensaft abschmecken, die Bai Grapao-Blätter zufügen, eine weitere Minute kochen, umrühren - fertig."
							+ "Dazu reiche ich Thai-Duftreis";
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 25, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_1.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	/*
	500g Hähnchenbrustfilet, in Streifen
	○ 1 Stück Knoblauch, in würfeln
	○ 1 EL Sambal Oelek
	￼
	○ 4 EL Sonnenblumenöl
	○ 3 Stück Frühlingszwiebeln, in Rauten geschnitten
	○ 250g Karotten, in dünnen Streifen
	○ 250g Mie-Eiernudeln
	○ 200g Sojasprossen
	○ 4EL Sojasauce
	○ 4EL Chilisauce (Chili Garlic)
	○ 1 Prise Cayennepfeffer
	○ 1 Prise Paprikapulver
	○ 1 Prise Curry
*/
	
	
	public static Receipt getAsia2() {
		Ingredient ingredient1 = new Ingredient("Knoblauch", Entity.Stueck, 1);
		Ingredient ingredient2 = new Ingredient("Sambal Oelek", Entity.EL, 1);
		Ingredient ingredient5 = new Ingredient("Sonnenblumenöl", Entity.EL, 4);
		Ingredient ingredient3 = new Ingredient("Frühlingszwiebeln", Entity.Stueck, 3);
		Ingredient ingredient4 = new Ingredient("Karotten", Entity.g, 250);
		Ingredient ingredient6 = new Ingredient("Mie-Eiernudeln", Entity.g, 250);
		Ingredient ingredient7 = new Ingredient("Sojasprossen", Entity.g, 200);
		Ingredient ingredient8 = new Ingredient("Sojasauce", Entity.EL, 4);
		Ingredient ingredient9 = new Ingredient("Chilisauce (Chili Garlic)", Entity.EL, 4);
		Ingredient ingredient10 = new Ingredient("Cayennepfeffer", Entity.Prise, 1);
		Ingredient ingredient11 = new Ingredient("Paprikapulver", Entity.Prise, 1);
		Ingredient ingredient12 = new Ingredient("Curry", Entity.Prise, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);
		ingredients.add(ingredient11);
		ingredients.add(ingredient12);


		String rezeptname = "Gebratenes Hühnchen mit Mie-Nudeln";
		String anleitung = 	"Ca. 6 Stunden vor dem Anbraten die Hähnchenbruststreifen in Öl, Sojasauce, Sambal Oelek und Knoblauch marinieren. Die Mengenangaben variieren je nach Gusto. Vorsicht mit Sambal Oelek!!! Die Eier Mie Nudeln laut Packungsanleitung kochen, Nudelwasser leicht salzen. Die gekochten und abgetropften Nudeln in einer Pfanne (wenn vorhanden Wok!) mit etwas Öl anbraten. Dann aus der Pfanne nehmen. Nun die Hähnchenstreifen kurz scharf anbraten, so dass sich Poren schliessen und sie saftig bleiben. Kein weiteres Öl verwenden, Marinade reicht vollkommen aus! Nudeln wieder hinzugeben. Jetzt die Karottenstreifen hinzugeben und unterheben. Nicht zu lange garen, sonst werden sie labbrig, sollten eher bissfest sein. Gegen Ende die Frühlingszwiebeln dazu geben und unterheben. Pfanne vom Herd nehmen und die Sojasprossen (vorher mit warmen Wasser begiessen) unterheben. Dann noch schnell mit Cayennepfeffer, Currypulver, Paprikapulver, Sojasauce und Chili-Garlic-Sauce würzen. Menge je nach Gusto! Das Ganze im Wok auf dem Tisch servieren - dazu eventuell einen Eisbergsalat oder Chinakohlsalat. Hinweise: Garzeiten (insbesondere für Frühlingszwiebeln und Sojasprossen) kurz halten! Vorsicht mit Cayennepfeffer (kann schnell das Gericht \"überschärfen\") !";
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 45, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_2.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	/*
	 	Titel: Gyoza
	● Kategorie: Asiatisch
	● Zutaten:
	○ 2 Stück Packungen Gyozateig aus dem Asialaden
	○ 500g Hackfleisch gemischt
	○ 1 Stück Chinakohl, fein geschnitten
	○ 2 Stück Karotten
	○ 3 Stück Lauchzwiebeln, fein geschnitten
	○ 1 Stück Ingwer
	○ 1 Stück Knoblauch
	○ 3 EL Sojasauce
	○ 2 EL Sesamöl
	○ 1 EL Öl zum Braten
	● Zubereitung:
	
	
	 */
	
	public static Receipt getAsia3() {
		Ingredient ingredient1 = new Ingredient("Packungen Gyozateig aus dem Asialaden", Entity.Stueck, 2);
		Ingredient ingredient2 = new Ingredient("Hackfleisch gemischt", Entity.g, 500);
		Ingredient ingredient5 = new Ingredient("Chinakohl", Entity.Stueck, 1);
		Ingredient ingredient3 = new Ingredient("Karotten", Entity.Stueck, 2);
		Ingredient ingredient4 = new Ingredient("Lauchzwiebeln", Entity.Stueck, 3);
		Ingredient ingredient6 = new Ingredient("Ingwer", Entity.Stueck, 1);
		Ingredient ingredient7 = new Ingredient("Knoblauch", Entity.Stueck, 1);
		Ingredient ingredient8 = new Ingredient("Sojasauce", Entity.EL, 3);
		Ingredient ingredient9 = new Ingredient("Sesamoel", Entity.EL, 2);
		Ingredient ingredient10 = new Ingredient("Oel zum Braten", Entity.EL, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);

		String rezeptname = "Gyoza";
		String anleitung = 	"Gehacktes, ganz fein geschnittenen Chinakohl (mengenmässig – nicht gewichtsmässig –"
							+ "so viel wie das Gehackte) und die ebenfalls fein geschnittenen Lauchzwiebeln zusammen in eine"
							+ "Schüssel geben. Die Möhre schälen, fein raspeln und auch dazu geben. Ein daumengrosses Stück"
							+ "Ingwer und zwei mittlere Knoblauchzehen schälen und in einer Knoblauchpresse in die Schüssel"
							+ "pressen. Nun 3 1/2 EL Sojasauce und 2 1/2 EL Sesamöl in die Schüssel geben. Alles gut vermengen."
							+ "Dann immer etwa einen EL von der Füllung auf einen Teigfladen geben, an dem man vorher den Rand"
							+ "befeuchtet hat. Nun so umklappen, dass man Halbmonde bekommt. Die Ränder gut aneinander drücken"
							+ "(so dass keine Luft im Inneren ist) und 5 kleine Fältchen hinein machen. Das mit allen Fladen"
							+ "wiederholen."
							+ "Wenn alle fertig gefüllt sind, die Gyozas aufrecht in eine Pfanne mit etwas heissem Öl ganz dicht"
							+ "zusammenstellen und so lange anbraten, bis sie schön braun sind."
							+ "Nun einen Daumen hoch Wasser in die Pfanne geben. Einen Deckel drauf legen und so lange dünsten,"
							+ "bis kein Wasser mehr in der Pfanne ist."
							+ "Zum Essen gibt es dann ein Schälchen Sojasauce, in die man die Gyozas dippen kann und reicht Reis"
							+ "dabei."
							+ "Tipp: Wenn Füllung über bleibt, einfach ein Ei und etwas Mehl zugeben und als Minifrikadellen braten."
							+ "Schmeckt ebenfalls sehr gut, deshalb mache ich von vorne rein immer etwas mehr Füllung."
							+ "Anmerkung: In Japan werden die Gyozas erst in diesen Bambusaufsätzen gedünstet und dann"
							+ "angebraten. So ist es allerdings ein etwas grösserer Aufwand und macht für mich keinen"
							+ "geschmacklichen Unterschied.";
		Receipt receipt = new Receipt(0, rezeptname, anleitung, 60, Difficulty.mittel, Course.Vorspeise, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_3.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	//Vegetarisch - Lukas
	//Nudelgerichte -  Tom
	//Fischgerichte - Sascha
	//Suppen - Andreas
	//Suesses - Marc

}
