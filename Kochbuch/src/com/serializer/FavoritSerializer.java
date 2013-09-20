package com.serializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.favorites.FavoritList;

public class FavoritSerializer {
	
	public final static String FAVORIT_FILE = "favorites.kbd";
	
	/**
	 * Deserializes the favorites
	 * 
	 * @param fileName path of the favoritsfile
	 * @return deserialized favorits
	 */
	public static FavoritList deserializeValues(String fileName) {
		
		FavoritList receipts = null;
		
		File serializeFile = new File(fileName);
		
		if (serializeFile.exists() && serializeFile.canRead()) {
			
			ObjectInputStream ois = null;
			
			try {
			
				ois = new ObjectInputStream(new FileInputStream(serializeFile));
				
				receipts = (FavoritList) ois.readObject();
				
			} catch (IOException ioEx) {		
				System.err.println("Fehler beim Laden der Favoriten: " + ioEx.getLocalizedMessage());
			} catch (ClassNotFoundException cnfEx) {
				System.err.println("Fehler beim Laden der Favoriten: " + cnfEx.getLocalizedMessage());
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
			System.err.println("Keine Favoriten, standard wird geladen !");
		}
		
		if (receipts == null) {
			System.out.println("Und wir geben null zurück");
		}
		
		return receipts;
		
	}
	
	/**
	 * Serializes the favoriten
	 * 
	 * @param fileName path of the favoritfile
	 * @return true if success, false if error
	 */
	public static boolean serializeValues(String fileName, FavoritList receipts) {
		
		boolean success = false;
		
		File serializeFile = new File(fileName);
		
		ObjectOutputStream ous = null;
		
		try {
			
			if (!serializeFile.exists()) {
				serializeFile.createNewFile();
			}
		
			if (serializeFile.canWrite()) {
		
				ous = new ObjectOutputStream(new FileOutputStream(serializeFile));
				
				ous.writeObject(receipts);
				
				success = true;
				
			} else {
				System.err.println("Fehler bei Speichern der Favoriten !");
			}
		
		} catch (IOException ioEx) {		
			System.err.println("Fehler beim Laden der Favoriten: " + ioEx.getLocalizedMessage());
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
