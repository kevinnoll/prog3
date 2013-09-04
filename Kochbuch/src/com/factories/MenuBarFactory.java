package com.factories;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.forms.Kochbuch;
import com.forms.NewReceipt;
import com.forms.ShoppingListDialog;
import com.shoppinglist.ShoppingList;

public class MenuBarFactory {
	public static JMenuBar getTheMenuBar() {
		// Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		//Menu selbst
		menu = new JMenu("Datei");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("Datei!");
		menuBar.add(menu);

		//Menuitem neues Rezept
		menuItem = new JMenuItem("Neues Rezept", new ImageIcon("icons/icon_recipe.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				NewReceipt.getInstance().resetFields();
				NewReceipt.getInstance().setVisible(true);
			}
		});
		menu.add(menuItem);
		menu.addSeparator();

		//Menuitem Favoriten
		menuItem = new JMenu("Favoriten");
		menuItem.setIcon(new ImageIcon("icons/icon_star.png"));
		JMenuItem subMenuItem1 = new JMenuItem("Favorit1");
		JMenuItem subMenuItem2 = new JMenuItem("Favorit2");
		JMenuItem subMenuItem3 = new JMenuItem("Favorit3");
		JMenuItem subMenuItem4 = new JMenuItem("Favorit4");
		JMenuItem subMenuItem5 = new JMenuItem("Favorit5");
		JMenuItem subMenuItem6 = new JMenuItem("...");
		menuItem.add(subMenuItem1);
		menuItem.add(subMenuItem2);
		menuItem.add(subMenuItem3);
		menuItem.add(subMenuItem4);
		menuItem.add(subMenuItem5);
		menuItem.add(subMenuItem6);
		menu.add(menuItem);
		menu.addSeparator();

		// Schlie�en
		menuItem = new JMenuItem("Schlie�en");
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				Kochbuch.getInstance().close();
			}
		});
		menu.add(menuItem);
		
		//Menues
		menu = new JMenu("Men�s");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
		menuBar.add(menu);
		
		// a group of JMenuItems
		menuItem = new JMenuItem("Men� erstellen", new ImageIcon("icons/icon_menu.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem2;
		menuItem2 = new JMenuItem("Men�s verwalten", new ImageIcon("icons/icon_menu.png"));
		menuItem2.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
			}
		});
		menu.add(menuItem2);
		
		//Shoppingliste
		menu = new JMenu("Shoppingliste");
		menu.setMnemonic(KeyEvent.VK_S);
		menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Shoppingliste anzeigen", new ImageIcon("icons/icon_dollar.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				ShoppingListDialog shoppingListDialog = new ShoppingListDialog();
				shoppingListDialog.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		menuItem2 = new JMenuItem("Shoppingliste leeren", new ImageIcon("icons/icon_cross.png"));
		menuItem2.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				ShoppingList.getInstance().clear();
			}
		});
		menu.add(menuItem2);

		return menuBar;
	}
}
