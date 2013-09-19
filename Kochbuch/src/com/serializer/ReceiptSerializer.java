package com.serializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.receipt.ReceiptList;

public class ReceiptSerializer {
	
	public final static String RECEIPT_FILE = "receipt.kbd";
	
	/**
	 * Deserializes the receipts
	 * 
	 * @param fileName path of the receiptsfile
	 * @return deserialized receipts
	 */
	public static ReceiptList deserializeValues(String fileName) {
		
		ReceiptList receipts = null;
		
		File serializeFile = new File(fileName);
		
		if (serializeFile.exists() && serializeFile.canRead()) {
			
			ObjectInputStream ois = null;
			
			try {
			
				ois = new ObjectInputStream(new FileInputStream(serializeFile));
				
				receipts = (ReceiptList) ois.readObject();
				
			} catch (IOException ioEx) {		
				System.err.println("Fehler beim Laden der Rezepte: " + ioEx.getLocalizedMessage());
			} catch (ClassNotFoundException cnfEx) {
				System.err.println("Fehler beim Laden der Rezepte: " + cnfEx.getLocalizedMessage());
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
			System.err.println("Keine Rezepte, standard wird geladen !");
		}
		
		if (receipts == null) {
			System.out.println("Und wir geben null zurück");
		}
		
		return receipts;
		
	}
	
	/**
	 * Serializes the receipts
	 * 
	 * @param fileName path of the receiptsfile
	 * @return true if success, false if error
	 */
	public static boolean serializeValues(String fileName, ReceiptList receipts) {
		
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
				System.err.println("Fehler bei Speichern der Rezepte !");
			}
		
		} catch (IOException ioEx) {		
			System.err.println("Fehler beim Laden der Rezepte: " + ioEx.getLocalizedMessage());
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
