package com.favorites;

import java.util.LinkedList;

import com.forms.Kochbuch;
import com.receipt.Receipt;
import com.serializer.FavoritSerializer;

public class FavoritList extends LinkedList<Receipt> {
	
	private static final long serialVersionUID = 1L;
	
	private static FavoritList instance = null;
	
	public static synchronized FavoritList getInstance(){
		if(instance==null){
			if ((instance = FavoritSerializer.deserializeValues(Kochbuch.APP_DATA_FOLDER + "/" + FavoritSerializer.FAVORIT_FILE)) == null) {
				instance=new FavoritList();
			}			
		}
		return instance;
	}
	
	private FavoritList(){
		
	}
}
