package com.menu;

import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.factories.MenuEntries;
import com.forms.Kochbuch;
import com.forms.Messages;
import com.serializer.MenuSerializer;

public class MenuList extends LinkedList<Menu> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static MenuList instance = null;
	
	private MenuList() {
		addDefaultMenues();
	}
	
	public static synchronized MenuList getInstance() {
		if (instance == null) {
			if ((instance = MenuSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + MenuSerializer.MENU_FILE)) == null) { //$NON-NLS-1$
				instance = new MenuList();
			}			
		}
		return instance;
	}
	
	public void addDefaultMenues() {
		
		int answer = JOptionPane.YES_NO_OPTION;//showConfirmDialog(null, Messages.getString("MenuList.first_start_menu"), Messages.getString("MenuList.no_menus_found"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		
		switch (answer) {
			case JOptionPane.YES_OPTION:
				//add(new Menu(0, Messages.getString("MenuList.example_menu"), MenuEntries.get_Kartoffeln(),  MenuEntries.get_Burger(), MenuEntries.get_Eis())); //$NON-NLS-1$
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
