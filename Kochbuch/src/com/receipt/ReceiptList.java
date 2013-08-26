package com.receipt;

import java.io.Serializable;
import java.util.LinkedList;

public class ReceiptList extends LinkedList<Receipt> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ReceiptList instance;
	
	/**
	 * liefert die aktuelle synchrone Version der ReceiptList zurück
	 * @return
	 */
	public static synchronized ReceiptList getInstance() {
		if (instance == null)
			instance = new ReceiptList();
		return instance;
	}

	private ReceiptList() { }
}
