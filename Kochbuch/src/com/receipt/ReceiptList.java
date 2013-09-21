package com.receipt;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.factories.MenuEntries;
import com.forms.Kochbuch;
import com.forms.Messages;
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
			if ((instance = ReceiptSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + ReceiptSerializer.RECEIPT_FILE)) == null) { //$NON-NLS-1$
				instance = new ReceiptList();
			}	
		}
		return instance;
	}
	
	public void addDefaultReceipts() {
		
		int answer = JOptionPane.showConfirmDialog(null, Messages.getString("ReceiptList.first_start_dialog_receipt"), Messages.getString("ReceiptList.no_reiceipts_found"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		
		switch (answer) {
			case JOptionPane.YES_OPTION:
				add(MenuEntries.getMeat1());
				add(MenuEntries.getMeat2());
				add(MenuEntries.getMeat3());
				
				add(MenuEntries.getRegio1());
				add(MenuEntries.getRegio2());
				add(MenuEntries.getRegio3());
				
				add(MenuEntries.getAsia1());
				add(MenuEntries.getAsia2());
				add(MenuEntries.getAsia3());
				
				add(MenuEntries.getVeggie1());
				add(MenuEntries.getVeggie2());
				add(MenuEntries.getVeggie3());
				
				add(MenuEntries.getPasta1());
				add(MenuEntries.getPasta2());
				add(MenuEntries.getPasta3());
				
				add(MenuEntries.getFisch1());
				add(MenuEntries.getFisch2());
				add(MenuEntries.getFisch3());
				
				add(MenuEntries.getSuppe1());
				add(MenuEntries.getSuppe2());
				add(MenuEntries.getSuppe3());
				
				add(MenuEntries.getSweet1());
				add(MenuEntries.getSweet2());
				add(MenuEntries.getSweet3());
				break;
			case JOptionPane.NO_OPTION:
				LinkedList<Ingredient> list = new LinkedList<Ingredient>();
				list.add(new Ingredient("nichts", Entity.g, 0));
				add(new Receipt(0, "Beispiel", "leer", 5, Difficulty.einfach, Course.Vorspeise, list, Categories.getInstance().get(4)));
				get(0).setImage(new File("images/placeholder.png"));
				break;
			case JOptionPane.CLOSED_OPTION:
				LinkedList<Ingredient> list1 = new LinkedList<Ingredient>();
				list1.add(new Ingredient("nichts", Entity.g, 0));
				add(new Receipt(0, "Beispiel", "leer", 5, Difficulty.einfach, Course.Vorspeise, list1, Categories.getInstance().get(4)));
				get(0).setImage(new File("images/placeholder.png"));
				break;
			default:
				LinkedList<Ingredient> list2 = new LinkedList<Ingredient>();
				list2.add(new Ingredient("nichts", Entity.g, 0));
				add(new Receipt(0, "Beispiel", "leer", 5, Difficulty.einfach, Course.Vorspeise, list2, Categories.getInstance().get(4)));
				get(0).setImage(new File("images/placeholder.png"));
				break;
		}
		
	}

	
}
