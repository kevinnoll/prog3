package com.serializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.receipt.Categories;

public class CategorieSerializer {
		
	public final static String CATEGORIES_FILE = "categories.kbd";
	
	/**
	 * Deserializes the categories
	 * 
	 * @param fileName path of the categoriesfile
	 * @return deserialized categories
	 */
	public static Categories deserializeValues(String fileName) {
		
		Categories cats = null;
		
		File serializeFile = new File(fileName);
		
		if (serializeFile.exists() && serializeFile.canRead()) {
			
			ObjectInputStream ois = null;
			
			try {
			
				ois = new ObjectInputStream(new FileInputStream(serializeFile));
				
				cats = (Categories) ois.readObject();
				
			} catch (IOException ioEx) {		
				System.err.println("Fehler beim Laden der Kategorien: " + ioEx.getLocalizedMessage());
			} catch (ClassNotFoundException cnfEx) {
				System.err.println("Fehler beim Laden der Kategorien: " + cnfEx.getLocalizedMessage());
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
			System.err.println("Keine Kategorien, standard wird geladen !");
		}
		
		return cats;
		
	}
	
	/**
	 * Serializes the categories
	 * 
	 * @param fileName path of the categoriesfile
	 * @return true if success, false if error
	 */
	public static boolean serializeValues(String fileName, Categories categories) {
		
		boolean success = false;
		
		File serializeFile = new File(fileName);
		
		ObjectOutputStream ous = null;
		
		try {
			
			if (!serializeFile.exists()) {
				serializeFile.createNewFile();
			}
		
			if (serializeFile.canWrite()) {
		
				ous = new ObjectOutputStream(new FileOutputStream(serializeFile));
				
				ous.writeObject(categories);
				
				success = true;
				
			} else {
				System.err.println("Fehler bei Speichern der Kategorien !");
			}
		
		} catch (IOException ioEx) {		
			System.err.println("Fehler beim Laden der Kategorien: " + ioEx.getLocalizedMessage());
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
