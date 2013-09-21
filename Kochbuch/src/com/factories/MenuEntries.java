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
				
		Receipt receipt = new Receipt(1, rezeptname, anleitung, 40, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
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
				
		Receipt receipt = new Receipt(2, rezeptname, anleitung, 30, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
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

		Receipt receipt = new Receipt(3, rezeptname, anleitung, 30, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(3));
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
		String anleitung = 	"Das gesiebte Mehl mit StaÌˆrkemehl und Zucker vermischen , dann das"+ 
							"Wasser u. die fluÌˆssige Butter hinzugeben und zu einem glatten Teig verarbeiten. 30 Min . bei Zimmertemperatur abgedeckt ruhen lassen."+ 
							"Nach dem Ruhen erst das Backpulver dazugeben und nochmal gut durchruÌˆhren. Die Mischung ist relativ fluÌˆssig. Nun den Teig in eine ausfettete und bemehlte Backform giessen , glatt streichen und mit den geputzten, entkernten Quetschen ordentlich belegen."+ 
							"Im vorgeheizten Backofen so 30 - 35 Min. bei 170 Â° C backen. Lauwarm mit einer Kugel"+ 
							"Vanilleneis und einem Klecks frischer Sahne servieren";
		Receipt receipt = new Receipt(4, rezeptname, anleitung, 40, Difficulty.mittel, Course.Dessert, ingredients, Categories.getInstance().get(3));
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
		String anleitung = 	"In einem Topf mit moÌˆglichst grossem Durchmesser Wasser erhitzen. Wenn es"
							+ "kocht, Salz, gekoÌˆrnte BruÌˆhe und Maggi hinzufuÌˆgen (wichtig, um den KnoÌˆdeln nachher Geschmack zu verleihen)."
							+ "Kartoffeln schaÌˆlen und in nicht zu dicke Spalten schneiden, in das heisse Wasser geben und weich kochen. Sind die Kartoffeln weich, aus dem Wasser nehmen und in die SchuÌˆssel geben, in der die MehlknoÌˆdel serviert werden sollen."
							+ "Derweil Mehl in eine grosse SchuÌˆssel geben, mit einer Prise Salz wuÌˆrzen. Mineralwasser dazu geben, aber noch nicht umruÌˆhren. Eier und 1 Schuss Milch dazu, erst dann kraÌˆftig umruÌˆhren, so dass der Teig schaumig wird, aber nicht trocken (wer die KnoÌˆdel lieber etwas fester mag, kann 1 Ei mehr hinzu tun). Mit einem EssloÌˆffel nun portionsweise aus dem Teig die MehlknoÌˆdel abstechen (nie viel mehr Teig abstechen, als auf den LoÌˆffel passt) und ins kochende Wasser geben. Den LoÌˆffel dabei immer wieder in die BruÌˆhe tauchen, damit der Teig nicht klebt. Die MehlknoÌˆdel schwimmen dann auf der BruÌˆhe. Den Topf nicht abdecken. Nach etwa 10 bis 15 Minuten sind die MehlknoÌˆdel gar. Aus der BruÌˆhe schoÌˆpfen und auf die Kartoffeln in die SchuÌˆssel geben."
							+ "In einer separaten Pfanne den Schinken in OÌˆl anbraten und mit dem OÌˆl uÌˆber die MehlknoÌˆdel geben. Sahne in die gleiche, noch heisse Pfanne geben und kurz aufkochen lassen, dann auch uÌˆber die KnoÌˆdel geben. Gleich servieren.";
		Receipt receipt = new Receipt(5, rezeptname, anleitung, 30, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(3));
		File file = new File("images/regio_3.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	
	//Asiatisch - Kevin
	
	public static Receipt getAsia1() {
		Ingredient ingredient1 = new Ingredient("HaÌˆhnchenfilet", Entity.g, 600);
		Ingredient ingredient2 = new Ingredient("Paprikaschote", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Zuckerschoten", Entity.g, 80);
		Ingredient ingredient3 = new Ingredient("Peperoni", Entity.Stueck, 3);
		Ingredient ingredient4 = new Ingredient("Chilischoten", Entity.Stueck, 16);
		Ingredient ingredient6 = new Ingredient("Knoblauchzehen", Entity.Stueck, 6);
		Ingredient ingredient7 = new Ingredient("Thaibasilikum-BlaÌˆtter (Krapao)", Entity.Stueck, 20);
		Ingredient ingredient8 = new Ingredient("HuÌˆhnerbruÌˆhe", Entity.Milliliter, 150);
		Ingredient ingredient9 = new Ingredient("Austernsauce", Entity.EL, 5);
		Ingredient ingredient10 = new Ingredient("Fischsauce", Entity.EL, 5);
		Ingredient ingredient11 = new Ingredient("Limettensaft", Entity.TL, 1);
		Ingredient ingredient12 = new Ingredient("dicke, suÌˆsse Sojasauce", Entity.TL, 1);
		Ingredient ingredient13 = new Ingredient("OÌˆl zum anbraten", Entity.TL, 1);
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

		String rezeptname = "ThailaÌˆndisches HuÌˆhnchen Krapauw";
		String anleitung = 	"Das HaÌˆhnchenfilet in der KuÌˆchenmaschine zu Hackfleisch verarbeiten und im Wok scharf anbraten. Den Knoblauch, die Chilis, die Zuckerschoten, die Peperoni und die Paprika zugeben und fuÌˆr 2 Minuten mitschmoren lassen. Mit HuÌˆhnerbruÌˆhe aufgiessen, Austern-, Fisch- und dicke suÌˆsse Soja-Sauce zufuÌˆgen und 4 Minuten koÌˆcheln lassen."
							+ "Mit Limettensaft abschmecken, die Bai Grapao-BlaÌˆtter zufuÌˆgen, eine weitere Minute kochen, umruÌˆhren - fertig."
							+ "Dazu reiche ich Thai-Duftreis";
		Receipt receipt = new Receipt(6, rezeptname, anleitung, 25, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_1.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	/*
	500g HaÌˆhnchenbrustfilet, in Streifen
	â—‹ 1 StuÌˆck Knoblauch, in wuÌˆrfeln
	â—‹ 1 EL Sambal Oelek
	ï¿¼
	â—‹ 4 EL SonnenblumenoÌˆl
	â—‹ 3 StuÌˆck FruÌˆhlingszwiebeln, in Rauten geschnitten
	â—‹ 250g Karotten, in duÌˆnnen Streifen
	â—‹ 250g Mie-Eiernudeln
	â—‹ 200g Sojasprossen
	â—‹ 4EL Sojasauce
	â—‹ 4EL Chilisauce (Chili Garlic)
	â—‹ 1 Prise Cayennepfeffer
	â—‹ 1 Prise Paprikapulver
	â—‹ 1 Prise Curry
*/
	
	
	public static Receipt getAsia2() {
		Ingredient ingredient1 = new Ingredient("Knoblauch", Entity.Stueck, 1);
		Ingredient ingredient2 = new Ingredient("Sambal Oelek", Entity.EL, 1);
		Ingredient ingredient5 = new Ingredient("SonnenblumenoÌˆl", Entity.EL, 4);
		Ingredient ingredient3 = new Ingredient("FruÌˆhlingszwiebeln", Entity.Stueck, 3);
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


		String rezeptname = "Gebratenes HuÌˆhnchen mit Mie-Nudeln";
		String anleitung = 	"Ca. 6 Stunden vor dem Anbraten die HaÌˆhnchenbruststreifen in OÌˆl, Sojasauce, Sambal Oelek und Knoblauch marinieren. Die Mengenangaben variieren je nach Gusto. Vorsicht mit Sambal Oelek!!! Die Eier Mie Nudeln laut Packungsanleitung kochen, Nudelwasser leicht salzen. Die gekochten und abgetropften Nudeln in einer Pfanne (wenn vorhanden Wok!) mit etwas OÌˆl anbraten. Dann aus der Pfanne nehmen. Nun die HaÌˆhnchenstreifen kurz scharf anbraten, so dass sich Poren schliessen und sie saftig bleiben. Kein weiteres OÌˆl verwenden, Marinade reicht vollkommen aus! Nudeln wieder hinzugeben. Jetzt die Karottenstreifen hinzugeben und unterheben. Nicht zu lange garen, sonst werden sie labbrig, sollten eher bissfest sein. Gegen Ende die FruÌˆhlingszwiebeln dazu geben und unterheben. Pfanne vom Herd nehmen und die Sojasprossen (vorher mit warmen Wasser begiessen) unterheben. Dann noch schnell mit Cayennepfeffer, Currypulver, Paprikapulver, Sojasauce und Chili-Garlic-Sauce wuÌˆrzen. Menge je nach Gusto! Das Ganze im Wok auf dem Tisch servieren - dazu eventuell einen Eisbergsalat oder Chinakohlsalat. Hinweise: Garzeiten (insbesondere fuÌˆr FruÌˆhlingszwiebeln und Sojasprossen) kurz halten! Vorsicht mit Cayennepfeffer (kann schnell das Gericht \"uÌˆberschaÌˆrfen\") !";
		Receipt receipt = new Receipt(7, rezeptname, anleitung, 45, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_2.png");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
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
		String anleitung = 	"Gehacktes, ganz fein geschnittenen Chinakohl (mengenmaÌˆssig â€“ nicht gewichtsmaÌˆssig â€“"
							+ "so viel wie das Gehackte) und die ebenfalls fein geschnittenen Lauchzwiebeln zusammen in eine"
							+ "SchuÌˆssel geben. Die MoÌˆhre schaÌˆlen, fein raspeln und auch dazu geben. Ein daumengrosses StuÌˆck"
							+ "Ingwer und zwei mittlere Knoblauchzehen schaÌˆlen und in einer Knoblauchpresse in die SchuÌˆssel"
							+ "pressen. Nun 3 1/2 EL Sojasauce und 2 1/2 EL SesamoÌˆl in die SchuÌˆssel geben. Alles gut vermengen."
							+ "Dann immer etwa einen EL von der FuÌˆllung auf einen Teigfladen geben, an dem man vorher den Rand"
							+ "befeuchtet hat. Nun so umklappen, dass man Halbmonde bekommt. Die RaÌˆnder gut aneinander druÌˆcken"
							+ "(so dass keine Luft im Inneren ist) und 5 kleine FaÌˆltchen hinein machen. Das mit allen Fladen"
							+ "wiederholen."
							+ "Wenn alle fertig gefuÌˆllt sind, die Gyozas aufrecht in eine Pfanne mit etwas heissem OÌˆl ganz dicht"
							+ "zusammenstellen und so lange anbraten, bis sie schoÌˆn braun sind."
							+ "Nun einen Daumen hoch Wasser in die Pfanne geben. Einen Deckel drauf legen und so lange duÌˆnsten,"
							+ "bis kein Wasser mehr in der Pfanne ist."
							+ "Zum Essen gibt es dann ein SchaÌˆlchen Sojasauce, in die man die Gyozas dippen kann und reicht Reis"
							+ "dabei."
							+ "Tipp: Wenn FuÌˆllung uÌˆber bleibt, einfach ein Ei und etwas Mehl zugeben und als Minifrikadellen braten."
							+ "Schmeckt ebenfalls sehr gut, deshalb mache ich von vorne rein immer etwas mehr FuÌˆllung."
							+ "Anmerkung: In Japan werden die Gyozas erst in diesen BambusaufsaÌˆtzen geduÌˆnstet und dann"
							+ "angebraten. So ist es allerdings ein etwas groÌˆsserer Aufwand und macht fuÌˆr mich keinen"
							+ "geschmacklichen Unterschied.";
		Receipt receipt = new Receipt(8, rezeptname, anleitung, 60, Difficulty.mittel, Course.Vorspeise, ingredients, Categories.getInstance().get(4));
		File file = new File("images/asia_3.png");
		receipt.setImage(file);
		return receipt;
		
	}
	

	
	//Vegetarisch - Lukas
	public static Receipt getVeggie1() {
		Ingredient ingredient1 = new Ingredient("Sojaoel", Entity.EL, 8);
		Ingredient ingredient2 = new Ingredient("Knoblauchzehen", Entity.Stueck, 4);
		Ingredient ingredient5 = new Ingredient("Tomatenmark", Entity.EL, 1);
		Ingredient ingredient3 = new Ingredient("Gemuesebruehe", Entity.Milliliter, 150);
		Ingredient ingredient4 = new Ingredient("schwarzer Pfeffer", Entity.Prise, 2);
		Ingredient ingredient6 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient7 = new Ingredient("Lauch", Entity.Stueck, 1);
		Ingredient ingredient8 = new Ingredient("Karotte", Entity.Stueck, 1);
		Ingredient ingredient9 = new Ingredient("Salz", Entity.Prise, 2);
		Ingredient ingredient10 = new Ingredient("Sellerie", Entity.g, 100);
		Ingredient ingredient11 = new Ingredient("Chili", Entity.Prise, 1);
		Ingredient ingredient12 = new Ingredient("Tomaten", Entity.g, 500);
		Ingredient ingredient13 = new Ingredient("kleine rote Chilischoten", Entity.Stueck, 2);
		Ingredient ingredient14 = new Ingredient("Kidneybohnen aus der Dose", Entity.g, 500);
		Ingredient ingredient15 = new Ingredient("Tofu", Entity.g, 250);
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
		ingredients.add(ingredient12);;
		ingredients.add(ingredient13);
		ingredients.add(ingredient14);;
		ingredients.add(ingredient15);


		String rezeptname = "Würziges Cili mit Tofu";
		String anleitung = 	"Enthäuten Sie die Tomaten. Dazu ritzen Sie die Tomaten über Kreuz ein, überbrühen diese kurz und schrecken sie dann kurz ab. Entfernen Sie die Stielansätze und schneiden Sie das Tomatenfleisch in Würfel. "+ 
				"Schälen Sie die Möhre und den Sellerie und schneiden Sie beides in feine Würfel. Dann waschen Sie den Lauch und würfeln Sie diesen ebenfalls."+
				"Schälen Sie die Zwiebel und die Knoblauchzehen und hacken Sie beide Zutaten klein. Anschließend waschen Sie die Chilischoten, halbieren und entkernen diese und schneiden sie in Würfel. Den Tofu schneiden Sie ebenfalls in Würfel."+
				"Erhitzen Sie die Hälfte des Sojaöls in einem großen Topf und braten Sie die Tofuwürfel etwa 5 Minuten von jeder Seite an. Nehmen Sie die Tofustücke anschließend heraus. Auf Küchenpapier abtropfen lassen."+
				"Gießen Sie das restliche Sojaöl in den Bratensatz. Dann dünsten Sie die Möhren-, Lauch- und Selleriewürfel zusammen mit den Zwiebel-, Chilischoten- und Knoblauchstücken an. Geben Sie das Tomatenmark hinzu und lassen Sie das Ganze anbraten. Dabei gelegentlich umrühren."+
				"Löschen Sie das Gemüse mit der Brühe ab. Anschließend geben Sie die Bohnen, den Saft und die Tomatenstücke in die Brühe. Würzen Sie das Ganze mit dem Chiligewürz, Salz und Pfeffer. Dann bei geringer Hitze 15 Minuten köcheln lassen."+
				"Mischen Sie die Tofuwürfel vorsichtig dazu und schmecken Sie alles nochmal ab.";
		Receipt receipt = new Receipt(9, rezeptname, anleitung, 30, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(5));
		File file = new File("images/veggie_1.jpg");
		receipt.setImage(file);
		return receipt;
		
	}
	
	
	public static Receipt getVeggie2() {
		Ingredient ingredient1 = new Ingredient("rote Spitzpaprika", Entity.Stueck, 3);
		Ingredient ingredient2 = new Ingredient("Baguette", Entity.g, 200);
		Ingredient ingredient5 = new Ingredient("Olivenoel", Entity.EL, 6);
		Ingredient ingredient3 = new Ingredient("Knoblauchzehen", Entity.Stueck, 2);
		Ingredient ingredient4 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient6 = new Ingredient("Büffelmozzarella", Entity.Stueck, 2);
		Ingredient ingredient7 = new Ingredient("Pfeffer", Entity.Prise, 1);
		Ingredient ingredient8 = new Ingredient("Basilikumblätter", Entity.Stueck, 3);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);


		String rezeptname = "Bruschetta mit Paprika";
		String anleitung = 	"3 rote Spitzpaprika putzen und in dünne Ringe schneiden. " + 
				"Ca. 200 g Baguette schräg in 12 dünne Scheiben schneiden. Mit 2–3 El Olivenöl beträufeln. In mehreren Portionen in einer Pfanne bei mittlerer Hitze auf beiden Seiten hellbraun rösten. 2 Knoblauchzehen halbieren und mit den Schnittstellen leicht über die Brotscheiben reiben."+
				"1 El Olivenöl in der Pfanne erhitzen und die Paprikaringe darin anbraten. Bei mittlerer Hitze ca. 5 Min. weiterbraten, mit salz würzen. 2 Kugeln Büffelmozzarella (à 125 g) abtropfen lassen, trocken tupfen, halbieren und in Scheiben schneiden."+
				"Paprika und Mozzarella auf den Brotscheiben verteilen, mit Pfeffer würzen und mit 1–2 El Olivenöl beträufeln. Mit einigen Basilikumblättern bestreut servieren.";
		Receipt receipt = new Receipt(10, rezeptname, anleitung, 15, Difficulty.einfach, Course.Vorspeise, ingredients, Categories.getInstance().get(5));
		File file = new File("images/veggie_2.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	
	public static Receipt getVeggie3() {
		Ingredient ingredient1 = new Ingredient("Eier", Entity.Stueck, 4);
		Ingredient ingredient2 = new Ingredient("Sahne", Entity.Milliliter, 100);
		Ingredient ingredient5 = new Ingredient("Mehl", Entity.g, 40);
		Ingredient ingredient3 = new Ingredient("Zucker", Entity.g, 45);
		Ingredient ingredient4 = new Ingredient("Vanillearoma", Entity.Milliliter, 2);
		Ingredient ingredient6 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient7 = new Ingredient("Zimt", Entity.TL, 1);
		Ingredient ingredient8 = new Ingredient("Toastbrotscheiben", Entity.Stueck, 6);
		Ingredient ingredient9 = new Ingredient("Butter zum Braten", Entity.g, 10);
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


		String rezeptname = "Fabulous French Toast";
		String anleitung = 	"Alle Zutaten miteinander verrühren und die Toastscheiben hineinlegen. Am besten mit einer Gabel viele kleine Löcher in die Toastscheiben stechen, damit sie sich schön voll saugen. Nach 1-2 Minuten die Scheiben wenden. "+
				" In einer Pfanne Fett erhitzen und die Toasts auf mittlerer Hitze zur gewünschten Bräune von beiden Seiten backen."+
				" Am besten schmecken sie mit Puderzucker und Ahornsirup, aber auch mit Marmelade, geschlagener Sahne, saurer Sahne, Frischkäse oder Eiscreme.";
		Receipt receipt = new Receipt(11, rezeptname, anleitung, 10, Difficulty.einfach, Course.Dessert, ingredients, Categories.getInstance().get(5));
		File file = new File("images/veggie_3.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	//Nudelgerichte -  Tom,
	

	public static Receipt getPasta1() {
		Ingredient ingredient1 = new Ingredient("Zwiebeln", Entity.Stueck, 2);
		Ingredient ingredient2 = new Ingredient("Knoblauchzehen", Entity.Stueck, 3);
		Ingredient ingredient5 = new Ingredient("Tomaten", Entity.Stueck, 5);
		Ingredient ingredient3 = new Ingredient("pürierte Tomaten", Entity.Packung, 1);
		Ingredient ingredient4 = new Ingredient("Stangen Sellerie", Entity.Stueck, 3);
		Ingredient ingredient6 = new Ingredient("Karotten", Entity.Stueck, 2);
		Ingredient ingredient7 = new Ingredient("Rinderhack", Entity.g, 500);
		Ingredient ingredient8 = new Ingredient("Weisswein", Entity.Milliliter, 200);
		Ingredient ingredient9 = new Ingredient("Spaghetti", Entity.g, 500);
		Ingredient ingredient10 = new Ingredient("Pecorino-Käse", Entity.Stueck, 1);
		Ingredient ingredient11 = new Ingredient("Basilikum", Entity.Stueck, 1);
		Ingredient ingredient12 = new Ingredient("Salbeiblätter", Entity.g, 5);
		Ingredient ingredient13 = new Ingredient("Rosmarin", Entity.g, 5);
		Ingredient ingredient14 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient15 = new Ingredient("Pfeffer", Entity.Prise, 1);
		Ingredient ingredient16 = new Ingredient("Olivenöl", Entity.TL, 1);
		
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
		ingredients.add(ingredient14);
		ingredients.add(ingredient15);
		ingredients.add(ingredient16);

		String rezeptname = "Spaghetti Bolognese";
		String anleitung = 	"Eine Zwiebel und den Knoblauch schneiden und in reichlich Olivenöl anschwitzen. Die Tomaten kreuzförmig einschneiden und für drei bis vier Minuten in kochendes Wasser geben. Anschließend heraus nehmen und die Haut abziehen. Die geschälten Tomaten klein schneiden und zu den Zwiebeln und dem Knoblauch dazu geben. Mit pürierten Tomaten auffüllen. Die Sauce mit Salz und frischem Basilikum würzen und eine Stunde ziehen lassen."+
				"Die Karotten schälen. Anschließend die zweite Zwiebel, Sellerie und Karotten in etwa gleich große Stücke schneiden und mit einem guten Schuss Olivenöl anbraten. Salbei und Rosmarin zusammen binden und zu dem Gemüse geben. Dann das Rinderhack dazu geben und kross braten. Hackfleisch und Gemüse mit einem viertel Liter Weißwein ablöschen. Wenn der Alkohol verdampft ist, die Tomatensauce unterrühren. Die Bolognese mit einer Prise Salz würzen. Das Ganze vier bis fünf Stunden auf kleiner Flamme ziehen lassen. "+
				"Wasser mit reichlich Salz in einem Topf zum kochen bringen. Die Spaghetti dazu geben und al dente kochen. Nicht abschrecken, nur abtropfen lassen. Auf einem Teller anrichten. Das Kräuterbündel aus der Bolognese nehmen und die Sauce über die Spaghetti geben. Den Pecorino auf die Nudeln reiben und zum Schluss eine Prise frisch gemahlenem Pfeffer darüber geben..";
		Receipt receipt = new Receipt(12, rezeptname, anleitung, 45, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(6));
		File file = new File("images/pasta_1.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getPasta2() {
		Ingredient ingredient1 = new Ingredient("Spaghetti", Entity.g, 180);
		Ingredient ingredient2 = new Ingredient("Garnelen", Entity.g, 250);
		Ingredient ingredient5 = new Ingredient("glatte Petersilie", Entity.Stueck, 4);
		Ingredient ingredient3 = new Ingredient("Knoblauchzehen", Entity.Stueck, 2);
		Ingredient ingredient4 = new Ingredient("Olivenöl", Entity.EL, 5);
		Ingredient ingredient6 = new Ingredient("Salz", Entity.Prise, 1);
		Ingredient ingredient7 = new Ingredient("Zitronensaft", Entity.TL, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);

		String rezeptname = "Spaghetti aglio olio e Scampi";
		String anleitung = 	"Die Shrimps, wenn tiefgefroren, vorher auftauen, lassen. Die Zwiebeln werden in feine Würfelchen gehackt und in Olivenöl angeschwitzt. Nach 1 - 2 Minuten können Knoblauch, Salbeiblätter und Chilischote hinzugefügt werden. Hier kann nach Geschmack entschieden werden, ob einzelne oder alle drei Zutaten zerkleinert werden (intensiverer Geschmack) oder ob man sie als Ganzes in den Topf gibt. "+
				"Das Tomatenmark in den Topf geben und gut verteilen. Die Soße nun mit 1 1/2 cl Olivenöl und einem guten Schuss Weißwein ablöschen. Mit Salz, Pfeffer und Oregano abschmecken und vor sich hinköcheln lassen. " +
				"Nun die Shrimps mit reichlich Öl in eine Pfanne geben und mit dem Saft einer halben Zitrone anschwitzen, sodass sie angewärmt werden. Sie sollten nicht braun angebraten werden. Die Shrimps samt Öl in den Topf geben und nochmals abschmecken.  "+
				"Die Soße am besten direkt zu den inzwischen im Salzwasser gegarten Nudeln geben und nicht erst auf dem Teller zusammenfügen, damit sich alles besser verteilen kann. Servieren und eventuell mit Basilikum und Parmesan dekorieren.";
		Receipt receipt = new Receipt(13, rezeptname, anleitung, 20, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(6));
		File file = new File("images/pasta_2.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getPasta3() {
		Ingredient ingredient1 = new Ingredient("Knollen Kohlrabi", Entity.Stueck, 2);
		Ingredient ingredient2 = new Ingredient("Karotten", Entity.Stueck, 2);
		Ingredient ingredient5 = new Ingredient("Olivenöl", Entity.EL, 2);
		Ingredient ingredient3 = new Ingredient("Gemüsebrühe", Entity.Liter, 1);
		Ingredient ingredient4 = new Ingredient("Suppennudeln", Entity.g, 200);
		Ingredient ingredient6 = new Ingredient("Petersilie und Schnittlauch", Entity.Stueck, 3);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Gemüse-Nudelsuppe";
		String anleitung = 	"Für die Zubereitung der Nudelsuppe, Kohlrabi schälen, Karotten schälen, beide Gemüsesorten zuerst in Streifen, anschließend in kleinere Würfel schneiden. " +
				"In einem Topf das Olivenöl erhitzen, die Karotten- und Kohlrabiwürfel, sanft im Öl anbraten. " +
				"Die Nudelsuppe mit 1 Liter Gemüsebrühe ablöschen, aufkochen, und etwa 8 Minuten kochen lassen. " +
				"In einem extra Kochtopf in Salzwasser, Suppennudeln kochen.";
		Receipt receipt = new Receipt(14, rezeptname, anleitung, 20, Difficulty.einfach, Course.Vorspeise, ingredients, Categories.getInstance().get(6));
		File file = new File("images/pasta_3.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	//Fischgerichte - Sascha

	public static Receipt getFisch1() {
		Ingredient ingredient1 = new Ingredient("Fischfilet", Entity.g, 1300);
		Ingredient ingredient2 = new Ingredient("Shrimps", Entity.g, 150);
		Ingredient ingredient5 = new Ingredient("Krebse", Entity.g, 100);
		Ingredient ingredient3 = new Ingredient("Suppengrün", Entity.Stueck, 1);
		Ingredient ingredient4 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient6 = new Ingredient("Chilischote", Entity.Stueck, 1);
		Ingredient ingredient7 = new Ingredient("Knoblauchzehen", Entity.Stueck, 1);
		Ingredient ingredient8 = new Ingredient("Kräuterbutter", Entity.EL, 2);
		Ingredient ingredient9 = new Ingredient("Creme Fraiche", Entity.g, 400);
		Ingredient ingredient10 = new Ingredient("Fischfond", Entity.Milliliter, 800);
		Ingredient ingredient11 = new Ingredient("Weisswein", Entity.Milliliter, 300);
		
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
		
		String rezeptname = "Fischsuppe";
		String anleitung = 	"Das Suppengemüse (2 große Möhren, ein Stück Sellerie, eine halbe Stange Porree - das Weiße) und die Zwiebel in gleichgroße Würfelchen schneiden (den Porree längs halbieren und in Streifen schneiden), Knoblauch und Chilischote hacken. Alles zusammen in der Kräuterbutter anschwitzen. Mit gut 200 ml Weißwein löschen und etwas einkochen lassen. Fischfonds mit derselben Menge Wasser dazugeben. Hummer- und Krustentierpaste und die Creme fraiche einrühren. Mit Salz abschmecken. Alles zusammen kurz aufkochen lassen. Jetzt die Fischfilets in nicht zu kleinen Stücken, die Shrimp und die Flusskrebsschwänze dazugeben und alles zusammen auf ganz kleiner Flamme 15 Minuten ziehen lassen.";
		Receipt receipt = new Receipt(15, rezeptname, anleitung, 35, Difficulty.mittel, Course.Vorspeise, ingredients, Categories.getInstance().get(7));
		File file = new File("images/fisch_1.png");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getFisch2() {
		Ingredient ingredient1 = new Ingredient("Kürbis (Butternut)", Entity.g, 750);
		Ingredient ingredient2 = new Ingredient("Zwiebel", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Butter", Entity.g, 30);
		Ingredient ingredient3 = new Ingredient("Mehl", Entity.g, 30);
		Ingredient ingredient4 = new Ingredient("Sahne", Entity.Milliliter, 250);
		Ingredient ingredient6 = new Ingredient("Gemüsebrühe", Entity.Milliliter, 500);
		Ingredient ingredient7 = new Ingredient("Gouda", Entity.g, 200);
		Ingredient ingredient8 = new Ingredient("Bund Dill", Entity.Stueck, 1);
		Ingredient ingredient9 = new Ingredient("Lasagneplatten", Entity.g, 250);
		Ingredient ingredient10 = new Ingredient("Lachs", Entity.g, 200);
		Ingredient ingredient11 = new Ingredient("Salz und Pfeffer", Entity.Prise, 1);
		
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
		
		String rezeptname = "Kürbis-Lachs-Lasagne";
		String anleitung = 	"Für die Lasagne unbedingt Butternut-Kürbis verwenden. Mit einer anderen Kürbisart, z.B. Hokkaido, schmeckt die Lasagne nicht so gut. " + 
				"Den Kürbis schälen, die Kerne entfernen und in Würfel schneiden. Die Zwiebel würfeln und in der Butter glasig dünsten. Mehl darüber streuen, anschwitzen und unter Rühren mit der Sahne und der Gemüsebrühe ablöschen. Mit Salz, Pfeffer und Muskatnuss würzen. Bei schwacher Hitze 5 min köcheln lassen. Den Gouda klein schneiden und unter die Soße rühren. Den Dill klein schneiden und ebenfalls unter die Soße rühren. " +
				"In eine Auflaufform abwechselnd Soße, Lasagneplatten, Lachs und Kürbis schichten. Mit einer Lage Lasagneplatten abschließen und die restliche Soße darüber verteilen. " +
				"Im vorgeheizten Backofen bei 200°C ca. 45 min backen.";
		Receipt receipt = new Receipt(16, rezeptname, anleitung, 45, Difficulty.mittel, Course.Hauptgericht, ingredients, Categories.getInstance().get(7));
		File file = new File("images/fisch_2.png");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getFisch3() {
		Ingredient ingredient1 = new Ingredient("Fischfilet", Entity.g, 800);
		Ingredient ingredient2 = new Ingredient("Schalotten", Entity.Stueck, 3);
		Ingredient ingredient5 = new Ingredient("Creme Fraiche", Entity.g, 100);
		Ingredient ingredient3 = new Ingredient("Eier", Entity.Stueck, 2);
		Ingredient ingredient4 = new Ingredient("Olivenöl", Entity.EL, 3);
		Ingredient ingredient6 = new Ingredient("Basilikumblätter", Entity.Stueck, 1);
		Ingredient ingredient7 = new Ingredient("Salz und Pfeffer", Entity.Prise, 1);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		
		String rezeptname = "Fischpudding";
		String anleitung = 	"Die Fischfilets in kleine Stücke schneiden, zusammen mit den feingehackten Schalotten im heißen Öl kurz anbraten. Etwas abkühlen lassen und mit Basilikum, Eiern, Creme Fraiche, Salz und Pfeffer zu einer Farce mixen. Souffleförmchen  einölen und Farce einfüllen. Im 200 Grad heißen Wasserbad 20 Minuten stocken lassen. Danach im ausgeschalteten Ofen etwas ruhen lassen.";
		Receipt receipt = new Receipt(17, rezeptname, anleitung, 20, Difficulty.schwer, Course.Dessert, ingredients, Categories.getInstance().get(7));
		File file = new File("images/fisch_3.png");
		receipt.setImage(file);
		return receipt;
	}
	
	//Suppen - Andreas
	public static Receipt getSuppe1() {
		Ingredient ingredient1 = new Ingredient("Hackfleisch", Entity.g, 100);
		Ingredient ingredient2 = new Ingredient("Öl", Entity.EL, 1);
		Ingredient ingredient5 = new Ingredient("Champignons", Entity.g, 100);
		Ingredient ingredient3 = new Ingredient("Zwiebeln", Entity.Stueck, 1);
		Ingredient ingredient4 = new Ingredient("Porree", Entity.g, 100);
		Ingredient ingredient6 = new Ingredient("Weisswein", Entity.Milliliter, 125);
		Ingredient ingredient7 = new Ingredient("Bruehe", Entity.Milliliter, 250);
		Ingredient ingredient8 = new Ingredient("Schmelzkäse", Entity.g, 200);
		Ingredient ingredient9 = new Ingredient("Stärkemehl", Entity.TL, 3);
		Ingredient ingredient10 = new Ingredient("Salz und Pfeffer", Entity.Prise, 1);
		Ingredient ingredient11 = new Ingredient("Creme Fraiche", Entity.g, 30);
		
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
		
		String rezeptname = "Käsesuppe mit Lauch";
		String anleitung = 	"Käsesuppe mit Lauch lässt sich auch in größeren Mengen als Partysuppe schnell und einfach zubereiten. Besonders aromatisch schmeckt die Käsesuppe mit Lauch, wenn man sie mit frischen Champignons zubereitet. Dazu am besten frisches Baguette reichen. In einer beschichteten Pfanne zunächst neutrales Öl wie Maiskeimöl, Sojaöl oder Sonnenblumenöl erhitzen. Hackfleisch zufügen und scharf anbraten. Dabei das Hackfleisch mit einem Kochlöffel oder Bratenwender zerkleinern, bis es feinkrümelig ist. Inzwischen frische Champignons mit einem weichen Tuch trocken abreiben und evtl. braune Schnittstellen vom Stiel abschneiden. Champignons in Scheiben schneiden und zum Hackfleisch geben. Eine Zwiebel pellen, halbieren und in kleine Würfel schneiden. Zwiebelwürfel in die Pfanne geben und zusammen mit den Champignons, wie oben auf dem Bild zu sehen, hellbraun braten. Die Hitze auf mittlere Stufe zurückschalten. Porree / Lauch putzen, in etwas dickere Ringe schneiden und in der Pfanne so lange mitschmoren, bis die Lauchringe weich werden. Für die Käsesuppe mit Lauch den Pfanneninhalt in einen Kochtopf füllen und auf mittlerer Temperatur erhitzen. Trockenen oder halbtrockenen Weißwein zufügen und mit Brühe auffüllen. Am besten schmeckt die Käsesuppe mit Lauch, wenn man selbstgekochte Rindfleischbrühe verwendet (s. Rezept). Schmelzkäse, je nach Geschmack Sahneschmelzkäse, Kräuterschmelzkäse oder eine andere Sorte, in die Käsesuppe mit Lauch rühren und darin schmelzen lassen. Stärkemehl in eine kleine Schüssel geben und mit etwas kaltem Wasser glatt rühren. Die Käsesuppe mit Lauch einmal kurz aufkochen und die Suppe mit dem angerührten Stärkemehl binden. Die Temperatur auf niedrigste Stufe zurückschalten, damit die Creme Fraiche beim Einrühren nicht ausflockt. Käsesuppe mit Lauch mit frisch gemahlenem Pfeffer und Salz würzen und kurz vor dem Servieren Creme Fraiche mit einem Schneebesen unterrühren.";
		Receipt receipt = new Receipt(18, rezeptname, anleitung, 20, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(8));
		File file = new File("images/suppe_1.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getSuppe2() {
		Ingredient ingredient1 = new Ingredient("Schalotten", Entity.Stueck, 1);
		Ingredient ingredient2 = new Ingredient("Zehe Knoblauch", Entity.Stueck, 1);
		Ingredient ingredient5 = new Ingredient("Olivenöl", Entity.EL, 1);
		Ingredient ingredient3 = new Ingredient("Kartoffeln, mehlig", Entity.g, 150);
		Ingredient ingredient4 = new Ingredient("Bund Basilikum", Entity.Stueck, 1);
		Ingredient ingredient6 = new Ingredient("Gemüsebrühe", Entity.Milliliter, 200);
		Ingredient ingredient7 = new Ingredient("Milch", Entity.Milliliter, 200);
		Ingredient ingredient8 = new Ingredient("Salz und Pfeffer", Entity.Prise, 1);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		
		String rezeptname = "Basilikumcremesuppe";
		String anleitung = 	"Basilikum Creme Suppe ist eine leichte und kalorienarme Suppe, die sich schnell und einfach zubereiten lässt. Mit frischem Basilikum, dessen Blätter groß und kräftig sind, schmeckt die Basilikum Creme Suppe besonders aromatisch. Schalotte und Knoblauch pellen und in möglichst feine Würfel schneiden. In einem Suppentopf Olivenöl erhitzen und Schalotten und Knoblauch darin glasig dünsten. Eine etwas größere mehligkochende Sorte Kartoffel mit einem Sparschäler schälen, unter fließend Wasser abspülen und in gleichmäßig kleine Würfel schneiden. Die Kartoffelwürfel in den Suppentopf geben und auf hoher Temperatur ca. 2-3 Minuten anbraten. Die Temperatur auf mittlere Stufe zurückschalten, einen Deckel auf den Suppentopf legen und die Kartoffeln ca. 5 Minuten dünsten. Dabei hin und wieder mit dem Kochlöffel umrühren. Inzwischen die Blätter vom Basilikum abzupfen und einige Blätter für die Dekoration, wie oben auf dem Bild zu sehen, beiseite legen. Restliches Basilikum mit einem scharfen Kochmesser grob hacken, zu den Kartoffeln geben und kurz andünsten. Gemüsebrühe zufügen und dabei unter Rühren den hellen Bratensatz vom Boden des Topfes lösen. Milch zufügen und die Suppe einmal aufkochen lassen. Die Temperatur auf mittlere Stufe zurückschalten und die Kartoffeln, je nach Größe der Würfel, in ca. 10-12 Minuten weich kochen. Die Kartoffeln und Basilikum mit dem Pürierstab fein pürieren und die Basilikum Creme Suppe mit Pfeffer und Salz kräftig würzen. Basilikum Creme Suppe in tiefe Teller oder Schälchen füllen und kurz vor dem Servieren mit dem beiseite gelegten Basilikum dekorieren.";
		Receipt receipt = new Receipt(19, rezeptname, anleitung, 20, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(8));
		File file = new File("images/suppe_2.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getSuppe3() {
		Ingredient ingredient1 = new Ingredient("Hühnerbrühe", Entity.Milliliter, 750);
		Ingredient ingredient2 = new Ingredient("Avocado", Entity.Stueck, 2);
		Ingredient ingredient5 = new Ingredient("Limone", Entity.Stueck, 1);
		Ingredient ingredient3 = new Ingredient("Sahne", Entity.Milliliter, 125);
		Ingredient ingredient4 = new Ingredient("Pfeffer und Salz", Entity.Prise, 1);
		Ingredient ingredient6 = new Ingredient("Chili", Entity.Prise, 1);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		
		String rezeptname = "Avocadosuppe";
		String anleitung = 	"Basilikum Creme Suppe ist eine leichte und kalorienarme Suppe, die sich schnell und einfach zubereiten lässt. Mit frischem Basilikum, dessen Blätter groß und kräftig sind, schmeckt die Basilikum Creme Suppe besonders aromatisch. Schalotte und Knoblauch pellen und in möglichst feine Würfel schneiden. In einem Suppentopf Olivenöl erhitzen und Schalotten und Knoblauch darin glasig dünsten. Eine etwas größere mehligkochende Sorte Kartoffel mit einem Sparschäler schälen, unter fließend Wasser abspülen und in gleichmäßig kleine Würfel schneiden. Die Kartoffelwürfel in den Suppentopf geben und auf hoher Temperatur ca. 2-3 Minuten anbraten. Die Temperatur auf mittlere Stufe zurückschalten, einen Deckel auf den Suppentopf legen und die Kartoffeln ca. 5 Minuten dünsten. Dabei hin und wieder mit dem Kochlöffel umrühren. Inzwischen die Blätter vom Basilikum abzupfen und einige Blätter für die Dekoration, wie oben auf dem Bild zu sehen, beiseite legen. Restliches Basilikum mit einem scharfen Kochmesser grob hacken, zu den Kartoffeln geben und kurz andünsten. Gemüsebrühe zufügen und dabei unter Rühren den hellen Bratensatz vom Boden des Topfes lösen. Milch zufügen und die Suppe einmal aufkochen lassen. Die Temperatur auf mittlere Stufe zurückschalten und die Kartoffeln, je nach Größe der Würfel, in ca. 10-12 Minuten weich kochen. Die Kartoffeln und Basilikum mit dem Pürierstab fein pürieren und die Basilikum Creme Suppe mit Pfeffer und Salz kräftig würzen. Basilikum Creme Suppe in tiefe Teller oder Schälchen füllen und kurz vor dem Servieren mit dem beiseite gelegten Basilikum dekorieren.";
		Receipt receipt = new Receipt(20, rezeptname, anleitung, 15, Difficulty.einfach, Course.Vorspeise, ingredients, Categories.getInstance().get(8));
		File file = new File("images/suppe_3.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	//Suesses - Marc
	public static Receipt getSweet1() {
		Ingredient ingredient1 = new Ingredient("Zucker", Entity.EL, 9);
		Ingredient ingredient2 = new Ingredient("Mehl", Entity.EL, 9);
		Ingredient ingredient5 = new Ingredient("Pflanzenöl", Entity.EL, 9);
		Ingredient ingredient3 = new Ingredient("Beutel Backpulver", Entity.Stueck, 1);
		Ingredient ingredient4 = new Ingredient("Eier", Entity.Stueck, 4);
		Ingredient ingredient6 = new Ingredient("Äpfel", Entity.Stueck, 3);
		Ingredient ingredient7 = new Ingredient("Zitrone", Entity.Stueck, 1);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		
		String rezeptname = "Apfelkuchen";
		String anleitung = 	"Den Backofen auf 170 Grad bei Ober- und Unterhitze vorheizen. Die Eier mit dem Zucker mit dem Mixer auf schlagen, bis der Zucker sich auf gelöst hat. Das Mehl mit dem Backpulver vermengen. Die Mehlmischung zu den Eiern geben und auf kleiner Stufe verrühren. Das Öl mit dazu geben und weiter rühren. Die Äpfel schälen, in Spalten scheiden und mit Zitronensaft beträufeln, damit sie nicht braun werden. Eine runde Backform einfetten. Ungefähr die Hälfte des Teiges in die Form geben und die Apfelspalten darauf legen. Mit der anderen Hälfte des Teiges abdecken. Die Form in den Backofen schieben. Nach einer halben Stunde den Kuchen mit einem Holzstäbchen anpieken, es darf kein Teig mehr daran kleben bleiben. Wenn der Kuchen durchgebacken ist, aus dem Ofen holen und abkühlen lassen.";
		Receipt receipt = new Receipt(21, rezeptname, anleitung, 20, Difficulty.einfach, Course.Dessert, ingredients, Categories.getInstance().get(9));
		File file = new File("images/sweet_1.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getSweet2() {
		Ingredient ingredient1 = new Ingredient("Eier", Entity.Stueck, 3);
		Ingredient ingredient2 = new Ingredient("Zucker", Entity.g, 50);
		Ingredient ingredient5 = new Ingredient("Mascarpone", Entity.g, 250);
		Ingredient ingredient3 = new Ingredient("Zitronenschale", Entity.Prise, 1);
		Ingredient ingredient4 = new Ingredient("Löffelbiscuits", Entity.g, 200);
		Ingredient ingredient6 = new Ingredient("Espresso", Entity.Stueck, 4);
		Ingredient ingredient7 = new Ingredient("Kaffeelikör", Entity.Milliliter, 50);
		Ingredient ingredient8 = new Ingredient("Kakaopulver", Entity.g, 20);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		
		String rezeptname = "Tiramisu";
		String anleitung = 	"Eier trennen, Eigelb und Eiweiß mit je der Hälfte des Zuckers steif , bzw. cremig schlagen. Mascarpone + Zitronenabrieb unter die Eigelbmasse rühren und anschließend unter den Eischnee heben. Die Hälfte der Löffelbiskuits in eine Form geben und mit Espresso und Likör tränken. Mit der Hälfte der Mascarponemasse auf füllen, glatt streichen und das Ganze wiederholen. Gut 4 Std. im Kühlschrank abkühlen lassen. Vor dem Servieren kräftig mit Kakao bestäuben. Guten Appetit!";
		Receipt receipt = new Receipt(22, rezeptname, anleitung, 20, Difficulty.mittel, Course.Dessert, ingredients, Categories.getInstance().get(9));
		File file = new File("images/sweet_2.jpg");
		receipt.setImage(file);
		return receipt;
	}
	
	public static Receipt getSweet3() {
		Ingredient ingredient1 = new Ingredient("weiche Butter", Entity.g, 100);
		Ingredient ingredient2 = new Ingredient("Zucker", Entity.g, 50);
		Ingredient ingredient5 = new Ingredient("Nutella", Entity.g, 200);
		Ingredient ingredient3 = new Ingredient("Eier", Entity.Stueck, 1);
		Ingredient ingredient4 = new Ingredient("Weizenmehl", Entity.g, 300);
		Ingredient ingredient6 = new Ingredient("Vanillezucker", Entity.Packung, 4);
		Ingredient ingredient7 = new Ingredient("Backpulver", Entity.Packung, 1);
		Ingredient ingredient8 = new Ingredient("Salz", Entity.Prise, 1);
		
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		
		String rezeptname = "Nutellakekse";
		String anleitung = 	"Die weiche Butter mit dem Zucker und der Haselnusscreme schaumig rühren. Das Ei hinzufügen und weiterrühren. Das Mehl mit dem Vanillezucker, Backpulver und dem Salz verkneten und den Teig für ca. 2 Stunden im Kühlschrank ruhen lassen. Danach den Teig in Scheiben schneiden, auf ein mit Backpapier ausgelegtes Blech legen und ca. 10 - 15 Minuten backen (die Backzeit variiert je nach Dicke der Kekse bzw. der gewünschten Konsistenz).";
		Receipt receipt = new Receipt(23, rezeptname, anleitung, 15, Difficulty.einfach, Course.Dessert, ingredients, Categories.getInstance().get(9));
		File file = new File("images/sweet_3.jpg");
		receipt.setImage(file);
		return receipt;
	}
}
