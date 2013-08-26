package com.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.receipt.ReceiptList;

/**
 * ReceiptSerializerklasse zum Serializen eines Objekts.
 * 
 * @author <a href="pib.kevin.noll@htw-saarland.de">Kevin Noll</a>
 *
 */
public class ReceiptListSerializer {
	/**
	 * Speichert das Objekt auf der Festplatte ab
	 * 
	 * @param dateiname
	 * @param studenten
	 * @throws IOException
	 */
	public static void serialize(String dateiname, ReceiptList receiptList)
			throws IOException {
		// Outputstream fuer die Ausgabe anlegen
		FileOutputStream datei = new FileOutputStream(dateiname);
		// ObjectOutPutStream drueber legen
		ObjectOutputStream outputStream = new ObjectOutputStream(datei);
		// das Objekt schreiben
		outputStream.writeObject(receiptList);
		// Stream schliessen
		outputStream.close();
	}

	/**
	 * Versucht ein Objekt aus einer Datei auszulesen
	 * 
	 * @param dateiname
	 * @return das StudentWarteschlange-Objekt, falls gefunden
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ReceiptList deserialize(String dateiname)
			throws IOException,
			ClassNotFoundException {

		// File einlesen
		FileInputStream datei = new FileInputStream(dateiname);
		// Objekt auslesen
		ObjectInputStream o = new ObjectInputStream(datei);
		// Objekt in Student casten
		ReceiptList receiptList = (ReceiptList) o.readObject();
		// InputStream wieder schlieﬂen
		o.close();

		// nun wird der Student zurueck gegeben
		return receiptList;
	}
}
