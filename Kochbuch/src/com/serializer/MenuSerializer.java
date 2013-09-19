package com.serializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.menu.MenuList;

public class MenuSerializer {
	
	public final static String MENU_FILE = "menus.kbd";
	
	/**
	 * Deserializes the menus
	 * 
	 * @param fileName path of the menussfile
	 * @return deserialized menus
	 */
	public static MenuList deserializeValues(String fileName) {
		
		MenuList menus = null;
		
		File serializeFile = new File(fileName);
		
		if (serializeFile.exists() && serializeFile.canRead()) {
			
			ObjectInputStream ois = null;
			
			try {
			
				ois = new ObjectInputStream(new FileInputStream(serializeFile));
				
				menus = (MenuList) ois.readObject();
				
			} catch (IOException ioEx) {		
				System.err.println("Fehler beim Laden der Menus: " + ioEx.getLocalizedMessage());
			} catch (ClassNotFoundException cnfEx) {
				System.err.println("Fehler beim Laden der Menus: " + cnfEx.getLocalizedMessage());
			} finally {
				
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException ioEx) {
						System.err.println("Fehler beim Schliessen des Streams: " + ioEx.getLocalizedMessage());
					}
					
				}
				
			}
			
		} else {
			System.err.println("Keine Menu, standard wird geladen !");
		}
		
		return menus;
		
	}
	
	/**
	 * Serializes the menus
	 * 
	 * @param fileName path of the menusfile
	 * @return true if success, false if error
	 */
	public static boolean serializeValues(String fileName, MenuList menus) {
		
		boolean success = false;
		
		File serializeFile = new File(fileName);
		
		ObjectOutputStream ous = null;
		
		try {
			
			if (!serializeFile.exists()) {
				serializeFile.createNewFile();
			}
		
			if (serializeFile.canWrite()) {
		
				ous = new ObjectOutputStream(new FileOutputStream(serializeFile));
				
				ous.writeObject(menus);
				
				success = true;
				
			} else {
				System.err.println("Fehler bei Speichern der Menues !");
			}
		
		} catch (IOException ioEx) {		
			System.err.println("Fehler beim Laden der Menues: " + ioEx.getLocalizedMessage());
		} finally {
			
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException ioEx) {
					System.err.println("Fehler beim Schliessen des Streams: " + ioEx.getLocalizedMessage());
				}
				
			}
			
		}
		
		return success;
		
	}

}
