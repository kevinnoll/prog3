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
import com.forms.CategorieManager;
import com.forms.Kochbuch;
import com.forms.MenuCreator;
import com.forms.MenuManager;
import com.forms.Messages;
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
		menu = new JMenu(Messages.getString("MenuBarFactory.data")); //$NON-NLS-1$
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(Messages.getString("MenuBarFactory.data_des")); //$NON-NLS-1$
		menuBar.add(menu);

		//Menuitem neues Rezept
		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.new_receipt"), new ImageIcon("icons/icon_recipe.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				NewReceipt.getInstance().resetFields();
				NewReceipt.getInstance().setVisible(true);
			}
		});
		menu.add(menuItem);
		menu.addSeparator();
		
		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.manage_categories"), new ImageIcon("icons/icon_menu.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				CategorieManager.getInstance().setVisible(true);
			}
		});
		menu.add(menuItem);
		menu.add(menuItem);
		
		menu.addSeparator();

		//Menuitem Favoriten
		menuItem = new JMenu(Messages.getString("MenuBarFactory.favorites")); //$NON-NLS-1$
		menuItem.setIcon(new ImageIcon("icons/icon_star.png")); //$NON-NLS-1$
		if (FavoritList.getInstance().isEmpty()) {
			JMenuItem subMenuItem1 = new JMenuItem(Messages.getString("MenuBarFactory.no_favorits_saved"));	 //$NON-NLS-1$
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

		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.language"));
		menuItem.setIcon(new ImageIcon("icons/icon_world.png"));
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				if(Messages.language == 1){
					Messages.language = 2;
				} else {
					Messages.language = 1;
				}
				Messages.refresh();
				Kochbuch.getInstance().refresh();
			}
		});
		menu.add(menuItem);
		menu.addSeparator();
		
		// Schlie�en
		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.close")); //$NON-NLS-1$
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				Kochbuch.getInstance().close();
			}
		});
		menu.add(menuItem);

		//Menues
		menu = new JMenu(Messages.getString("MenuBarFactory.menus")); //$NON-NLS-1$
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription(Messages.getString("MenuBarFactory.menus_des")); //$NON-NLS-1$
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.create_menu"), new ImageIcon("icons/icon_menu.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				MenuCreator menuCreator = new MenuCreator();
				menuCreator.setVisible(true);
			}
		});
		menu.add(menuItem);

		JMenuItem menuItem2;
		menuItem2 = new JMenuItem(Messages.getString("MenuBarFactory.manage_menu"), new ImageIcon("icons/icon_menu.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem2.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				MenuManager.getInstance().setVisible(true);
			}
		});
		menu.add(menuItem2);

		//Shoppingliste
		menu = new JMenu(Messages.getString("MenuBarFactory.shopping_list")); //$NON-NLS-1$
		menu.setMnemonic(KeyEvent.VK_S);
		menu.getAccessibleContext().setAccessibleDescription(Messages.getString("MenuBarFactory.shopping_list_des")); //$NON-NLS-1$
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem(Messages.getString("MenuBarFactory.show_shopping_list"), new ImageIcon("icons/icon_dollar.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				ShoppingListDialog shoppingListDialog = new ShoppingListDialog();
				shoppingListDialog.setVisible(true);
			}
		});
		menu.add(menuItem);

		menuItem2 = new JMenuItem(Messages.getString("MenuBarFactory.clear_shooping_list"), new ImageIcon("icons/icon_cross.png")); //$NON-NLS-1$ //$NON-NLS-2$
		menuItem2.addActionListener(new ActionListener() {
			public final void actionPerformed(final ActionEvent e) {
				ShoppingList.getInstance().clear();
			}
		});
		menu.add(menuItem2);

		return menuBar;
	}
}
