package com.receipt;

import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.factories.MenuEntries;
import com.forms.Kochbuch;
import com.menu.Menu;
import com.serializer.ReceiptSerializer;

public class ReceiptList extends LinkedList<Receipt> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ReceiptList instance;
	
	private ReceiptList() { 
		addDefaultReceipts();
	}
	
	/**
	 * liefert die aktuelle synchrone Version der ReceiptList zurueck
	 * @return
	 */
	public static synchronized ReceiptList getInstance() {
		if (instance == null) {
			if ((instance = ReceiptSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + ReceiptSerializer.RECEIPT_FILE)) == null) {
				instance = new ReceiptList();
			}	
		}
		return instance;
	}
	
	public void addDefaultReceipts() {
		
		int answer = JOptionPane.showConfirmDialog(null, "Dies scheint Ihr erster Start zu sein !\nMöchten Sie die Beispiel Rezepte laden ?", "Keine Menues gefunden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		switch (answer) {
			case JOptionPane.YES_OPTION:
				add(MenuEntries.get_Burger());
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
