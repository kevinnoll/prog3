package com.favorites;

import java.util.LinkedList;

import com.receipt.Receipt;

public class FavoritList extends LinkedList<Receipt>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static FavoritList instance = null;
	
	public FavoritList getInstance(){
		if(instance==null){
			instance=new FavoritList();
		}
		return instance;
	}
	
	private FavoritList(){
		
	}
}
