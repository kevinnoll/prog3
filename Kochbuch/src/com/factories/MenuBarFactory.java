package com.factories;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.favorites.FavoritList;
import com.forms.Kochbuch;
import com.forms.MenuCreator;
import com.forms.MenuManager;
import com.forms.NewReceipt;
import com.forms.ShoppingListDialog;
import com.receipt.Receipt;
import com.shoppinglist.ShoppingList;

public class MenuBarFactory {
	private static Receipt currentReceipt;
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
		
		menuItem = new JMenuItem("Kategorien verwalten", new ImageIcon("icons/icon_menu.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				//TODO verwaltung einfuegen...
			}
		});
		menu.add(menuItem);
		menu.add(menuItem);
		
		menu.addSeparator();

		//Menuitem Favoriten
		menuItem = new JMenu("Favoriten");
		menuItem.setIcon(new ImageIcon("icons/icon_star.png"));
		if (FavoritList.getInstance().isEmpty()) {
			JMenuItem subMenuItem1 = new JMenuItem("Keine Favoriten anlegelt");	
			subMenuItem1.enable(false);
			menuItem.add(subMenuItem1);
			
		} else {
			for(int i= 0; i< FavoritList.getInstance().size();i++){
				JMenuItem subMenutItem = new JMenuItem(FavoritList.getInstance().get(i).getName());
				currentReceipt = FavoritList.getInstance().get(i);
				subMenutItem.addActionListener(new ActionListener() {
					public final void actionPerformed(final ActionEvent e) {
						Kochbuch.getInstance().fillRightPanelWithFav(currentReceipt);
					}
				});
				menuItem.add(subMenutItem);
			}
		}
		menu.add(menuItem);
		menu.addSeparator();

		// Schlie�en
		menuItem = new JMenuItem("Schliessen");
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				Kochbuch.getInstance().close();
			}
		});
		menu.add(menuItem);

		//Menues
		menu = new JMenu("Menues");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Menue erstellen", new ImageIcon("icons/icon_menu.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				MenuCreator menuCreator = new MenuCreator();
				menuCreator.setVisible(true);
			}
		});
		menu.add(menuItem);

		JMenuItem menuItem2;
		menuItem2 = new JMenuItem("Menues verwalten", new ImageIcon("icons/icon_menu.png"));
		menuItem2.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				MenuManager.getInstance().setVisible(true);
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
