package com.menu;

import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.factories.MenuEntries;
import com.forms.Kochbuch;
import com.serializer.MenuSerializer;

public class MenuList extends LinkedList<Menu> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static MenuList instance = null;
	
	private MenuList() {
		addDefaultMenues();
	}
	
	public static synchronized MenuList getInstance() {
		if (instance == null) {
			if ((instance = MenuSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + MenuSerializer.MENU_FILE)) == null) {
				instance = new MenuList();
			}			
		}
		return instance;
	}
	
	public void addDefaultMenues() {
		
		int answer = JOptionPane.showConfirmDialog(null, "Dies scheint Ihr erster Start zu sein !\nMöchten Sie ein Beispiel Menus laden ?", "Keine Menues gefunden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		switch (answer) {
			case JOptionPane.YES_OPTION:
				add(new Menu(0, "Beispiel Menue", MenuEntries.get_Kartoffeln(),  MenuEntries.get_Burger(), MenuEntries.get_Eis()));
				break;
			case JOptionPane.NO_OPTION:
				//Do nothing
				break;
			case JOptionPane.CLOSED_OPTION:
				//Do nothing
				break;
			default:
				//Do nothing
				break;
		}
		
	}
	
}
