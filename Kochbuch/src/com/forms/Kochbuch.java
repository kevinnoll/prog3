package com.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sun.awt.WindowClosingListener;

import net.miginfocom.swing.MigLayout;

import com.factories.MenuBarFactory;
import com.factories.MenuEntries;
import com.factories.StarButton;
import com.favorites.FavoritList;
import com.menu.MenuList;
import com.receipt.Categories;
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;
import com.serializer.CategorieSerializer;
import com.serializer.FavoritSerializer;
import com.serializer.MenuSerializer;
import com.serializer.ReceiptSerializer;
import com.shoppinglist.ShoppingList;

public class Kochbuch extends JFrame {

	public final static String APP_DATA_FOLDER = System.getProperty("user.home") + "/kochbuch"; //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmKochbuch;
	private JTextField textFieldSearch;
	private DefaultListModel<Receipt> entries;
	private static Kochbuch instance;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnRezeptLschen;
	private JComboBox<String> comboBoxCategory;
	private JList<Receipt> list;
	private JScrollPane scrollPane_2;
	private JButton searchButton;
	private JList<Ingredient> listIngredientsRightSide;
	private JTextPane textPane;
	private JLabel lblRezeptselektiert;
	private JLabel lblDifficulty;
	private JLabel lblDuration;
	private JLabel lblCourse;
	private JLabel labelPicture;
	private StarButton starButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kochbuch.getInstance();
					
					Runtime.getRuntime().addShutdownHook(new Thread() {
						public void run() {
							CategorieSerializer.serializeValues(APP_DATA_FOLDER + "/" + CategorieSerializer.CATEGORIES_FILE, Categories.getInstance()); //$NON-NLS-1$
							ReceiptSerializer.serializeValues(APP_DATA_FOLDER + "/" + ReceiptSerializer.RECEIPT_FILE, ReceiptList.getInstance()); //$NON-NLS-1$
							MenuSerializer.serializeValues(APP_DATA_FOLDER + "/" + MenuSerializer.MENU_FILE, MenuList.getInstance()); //$NON-NLS-1$
							FavoritSerializer.serializeValues(APP_DATA_FOLDER + "/" + FavoritSerializer.FAVORIT_FILE, FavoritList.getInstance()); //$NON-NLS-1$
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Kochbuch(String name) {
		super(name);
		createDataFolder();
		initialize();		
	}

	public static synchronized Kochbuch getInstance() {
		if (instance == null)
			instance = new Kochbuch(""); //$NON-NLS-1$
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//external initializations
		//		receiptDialog = NewReceipt.getInstance();

		
		
		frmKochbuch = new JFrame();
		frmKochbuch.setTitle(Messages.getString("Kochbuch.recipe_book")); //$NON-NLS-1$
		frmKochbuch.setBounds(100, 100, 1127, 677);
		frmKochbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKochbuch.setVisible(false);
		frmKochbuch.setVisible(true);

		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frmKochbuch.setJMenuBar(menuBar);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblRezepte = new JLabel(Messages.getString("Kochbuch.receipt")); //$NON-NLS-1$

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);

		panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmKochbuch.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblRezepte))
						.addGap(18).addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE).addGap(26)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout.createSequentialGroup().addGap(8).addComponent(lblRezepte).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(35))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(29).addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE).addGap(37))
						.addGroup(
								groupLayout.createSequentialGroup().addGap(8).addComponent(separator, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
										.addContainerGap()));
		panel_1.setLayout(new MigLayout("", "[][grow][]", "[][grow][][grow][][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		lblRezeptselektiert = new JLabel(Messages.getString("Kochbuch.select_receipt")); //$NON-NLS-1$
		panel_1.add(lblRezeptselektiert, "cell 0 0,growx"); //$NON-NLS-1$

		JPanel panel_2 = new JPanel();

		JLabel lblFavoritHinzufgen = new JLabel(Messages.getString("Kochbuch.add_favorits")); //$NON-NLS-1$
		panel_1.add(lblFavoritHinzufgen, "cell 1 0,alignx right"); //$NON-NLS-1$

		starButton = new StarButton(""); //$NON-NLS-1$
		starButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (starButton.isSelected()) {
					FavoritList.getInstance().add(list.getSelectedValue());
				} else {
					if(FavoritList.getInstance().contains(list.getSelectedValue())){
						FavoritList.getInstance().remove(list.getSelectedValue());
					}
				}
			}
		});
		panel_1.add(starButton, "cell 2 0"); //$NON-NLS-1$

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, "cell 0 1,grow"); //$NON-NLS-1$

		listIngredientsRightSide = new JList<Ingredient>();
		listIngredientsRightSide.setSelectionBackground(new Color(154, 205, 50));
		listIngredientsRightSide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listIngredientsRightSide.setSelectionModel(new DefaultListSelectionModel() {
			private int i0 = -1;
			private int i1 = -1;

			public void setSelectionInterval(int index0, int index1) {
				if (i0 == index0 && i1 == index1) {
					if (getValueIsAdjusting()) {
						setValueIsAdjusting(false);
						setSelection(index0, index1);
					}
				} else {
					i0 = index0;
					i1 = index1;
					setValueIsAdjusting(false);
					setSelection(index0, index1);
				}
			}

			private void setSelection(int index0, int index1) {
				if (super.isSelectedIndex(index0)) {
					super.removeSelectionInterval(index0, index1);
				} else {
					super.addSelectionInterval(index0, index1);
				}
			}
		});
		scrollPane_3.setViewportView(listIngredientsRightSide);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, "flowx,cell 0 0,grow"); //$NON-NLS-1$

		labelPicture = new JLabel(""); //$NON-NLS-1$
		labelPicture.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		scrollPane_1.setViewportView(labelPicture);
		panel_1.add(panel_2, "cell 1 1 2 1,grow"); //$NON-NLS-1$
		panel_2.setLayout(new MigLayout("", "[grow]", "[50px,grow]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		JButton btnNewButton = new JButton(Messages.getString("Kochbuch.add_shopping_list")); //$NON-NLS-1$
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listIngredientsRightSide.getSelectedIndex() == -1) {
					JOptionPane.showConfirmDialog(listIngredientsRightSide, Messages.getString("Kochbuch.add_ingredient"), Messages.getString("Kochbuch.no_ingredient"), //$NON-NLS-1$ //$NON-NLS-2$
							JOptionPane.DEFAULT_OPTION);
				} else {
					List<Ingredient> listOfIngredients = listIngredientsRightSide.getSelectedValuesList();
					for (int i = 0; i < listOfIngredients.size(); i++) {
						if (!ShoppingList.getInstance().contains(listOfIngredients.get(i))) {
							ShoppingList.getInstance().add(listOfIngredients.get(i));
						}
					}
				}
			}
		});
		panel_1.add(btnNewButton, "cell 0 2,growx"); //$NON-NLS-1$

		JButton btnNewButton_1 = new JButton(Messages.getString("Kochbuch.show_shopping_list")); //$NON-NLS-1$
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingListDialog shoppingListDialog = new ShoppingListDialog();
				shoppingListDialog.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_1, "cell 1 2 2 1,growx"); //$NON-NLS-1$

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 200));
		panel_1.add(scrollPane, "cell 0 3 3 1,grow"); //$NON-NLS-1$

		textPane = new JTextPane();
		textPane.setSelectionColor(new Color(154, 205, 50));
		textPane.setPreferredSize(new Dimension(6, 200));
		textPane.setMaximumSize(new Dimension(2147483647, 200));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);

		JLabel lblSchwierigkeit = new JLabel(Messages.getString("Kochbuch.difficulty_level")); //$NON-NLS-1$
		panel_1.add(lblSchwierigkeit, "cell 0 4"); //$NON-NLS-1$

		lblDifficulty = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblDifficulty, "cell 1 4 2 1"); //$NON-NLS-1$

		JLabel lblDauer = new JLabel(Messages.getString("Kochbuch.duration")); //$NON-NLS-1$
		panel_1.add(lblDauer, "cell 0 5"); //$NON-NLS-1$

		lblDuration = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblDuration, "cell 1 5 2 1"); //$NON-NLS-1$

		JLabel lblPlatzImMenu = new JLabel(Messages.getString("Kochbuch.course")); //$NON-NLS-1$
		panel_1.add(lblPlatzImMenu, "cell 0 6"); //$NON-NLS-1$

		lblCourse = new JLabel(""); //$NON-NLS-1$
		lblCourse.setPreferredSize(new Dimension(100, 14));
		lblCourse.setMinimumSize(new Dimension(100, 14));
		lblCourse.setMaximumSize(new Dimension(100, 14));
		lblCourse.setOpaque(true);
		panel_1.add(lblCourse, "cell 1 6 2 1"); //$NON-NLS-1$

		searchButton = new JButton(Messages.getString("Kochbuch.go")); //$NON-NLS-1$
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //OnClick
				searchAndDisplay(textFieldSearch.getText());
			}
		});

		JLabel lblZutatWaehlen = new JLabel(Messages.getString("Kochbuch.select_categorie")); //$NON-NLS-1$

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setToolTipText(Messages.getString("Kochbuch.please_choose")); //$NON-NLS-1$
		setCategories();
		comboBoxCategory.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSearch.setText(""); //$NON-NLS-1$
					filterList(comboBoxCategory.getSelectedItem().toString());
				}
			}
		});

		JLabel lblNewLabel = new JLabel(Messages.getString("Kochbuch.seach")); //$NON-NLS-1$

		textFieldSearch = new JTextField();
		textFieldSearch.setToolTipText(Messages.getString("Kochbuch.searching")); //$NON-NLS-1$
		textFieldSearch.addKeyListener(new TextFieldListener());

		JButton btnNeuesRezept = new JButton(Messages.getString("Kochbuch.new_receipt")); //$NON-NLS-1$
		btnNeuesRezept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewReceipt.getInstance().resetFields();
				NewReceipt.getInstance().setVisible(true);
			}
		});
		btnRezeptLschen = new JButton(Messages.getString("Kochbuch.delete_receipt")); //$NON-NLS-1$
		btnRezeptLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(scrollPane_2, Messages.getString("Kochbuch.confirm_delete"), Messages.getString("Kochbuch.please_confirm"), JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) { //$NON-NLS-1$ //$NON-NLS-2$
					ReceiptList.getInstance().remove(list.getSelectedValue());
					entries.removeElement(list.getSelectedValue());
					searchAndDisplay(textFieldSearch.getText());
				}
			}
		});

		scrollPane_2 = new JScrollPane();
		list = new JList<Receipt>();
		list.setSelectionBackground(new Color(154, 205, 50));

		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (listSelectionEvent.getValueIsAdjusting()) {
					if (list.getSelectedIndex() != -1) {
						fillRightPanel();
					}
				}
			}
		};
		list.addListSelectionListener(listSelectionListener);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		list.setFont(font);

		JButton btnRezeptBearbeiten = new JButton(Messages.getString("Kochbuch.edit_receipt")); //$NON-NLS-1$
		btnRezeptBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showConfirmDialog(scrollPane_2, Messages.getString("Kochbuch.choose_receipt_for_edit"), Messages.getString("Kochbuch.no_receipt_selected"), //$NON-NLS-1$ //$NON-NLS-2$
							JOptionPane.DEFAULT_OPTION);
				} else {
					NewReceipt.getInstance().setFields(list.getSelectedValue());
					NewReceipt.getInstance().setVisible(true);
				}
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(
												gl_panel.createSequentialGroup().addComponent(btnRezeptBearbeiten)
														.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE).addComponent(btnNeuesRezept)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRezeptLschen).addGap(20))
										.addGroup(
												gl_panel.createSequentialGroup()
														.addGroup(
																gl_panel.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblZutatWaehlen, GroupLayout.PREFERRED_SIZE, 136,
																				GroupLayout.PREFERRED_SIZE).addComponent(lblNewLabel))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(
																gl_panel.createParallelGroup(Alignment.LEADING)
																		.addGroup(
																				gl_panel.createSequentialGroup()
																						.addComponent(textFieldSearch, GroupLayout.DEFAULT_SIZE, 310,
																								Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(searchButton))
																		.addComponent(comboBoxCategory, 0, 369, Short.MAX_VALUE)).addGap(19))
										.addGroup(
												gl_panel.createSequentialGroup().addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
														.addGap(22)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblZutatWaehlen)
										.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
										.addComponent(textFieldSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGap(13)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnNeuesRezept).addComponent(btnRezeptLschen)
										.addComponent(btnRezeptBearbeiten)).addContainerGap()));

		scrollPane_2.setViewportView(list);

		entries = new DefaultListModel<Receipt>();

		for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
			entries.addElement(ReceiptList.getInstance().get(i));
		}
		list.setModel(entries);
		list.setSelectedIndex(0);
		list.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				Receipt receipt = (Receipt) value;
				label.setIcon(receipt.getIcon());
				label.setText(receipt.getName());
				return label;
			}
		});
		fillRightPanel();
		panel.setLayout(gl_panel);
		frmKochbuch.getContentPane().setLayout(groupLayout);

		// GroupLayout ends here

	}

	private void fillRightPanel() {
		DefaultListModel<Ingredient> newModel = new DefaultListModel<Ingredient>();
		
		if (list.getSize().height > 0) {
		
			for (int i = 0; i < list.getSelectedValue().getIngredients().size(); i++) {
				newModel.addElement(list.getSelectedValue().getIngredients().get(i));
			}
			lblRezeptselektiert.setText(list.getSelectedValue().getName());
			lblRezeptselektiert.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			listIngredientsRightSide.setModel(newModel);
			textPane.setText(list.getSelectedValue().getReceipt());
			lblCourse.setText(list.getSelectedValue().getCourse().toString());
			lblDifficulty.setText(list.getSelectedValue().getDifficulty().toString());
			lblDuration.setText(list.getSelectedValue().getDuration() + Messages.getString("Kochbuch.min")); //$NON-NLS-1$
			labelPicture.setIcon(list.getSelectedValue().getImage());
			if(FavoritList.getInstance().contains(list.getSelectedValue())){
				starButton.setSelected(true);
			} else {
				starButton.setSelected(false);
			}
			
		}
		
		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frmKochbuch.setJMenuBar(menuBar);
	}
	
	public void fillRightPanelWithFav(Receipt receipt){
		DefaultListModel<Ingredient> newModel = new DefaultListModel<Ingredient>();
		for (int i = 0; i < receipt.getIngredients().size(); i++) {
			newModel.addElement(receipt.getIngredients().get(i));
		}
		lblRezeptselektiert.setText(receipt.getName());
		lblRezeptselektiert.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		listIngredientsRightSide.setModel(newModel);
		textPane.setText(receipt.getReceipt());
		lblCourse.setText(receipt.getCourse().toString());
		lblDifficulty.setText(receipt.getDifficulty().toString());
		lblDuration.setText(receipt.getDuration() + Messages.getString("Kochbuch.min")); //$NON-NLS-1$
		labelPicture.setIcon(receipt.getImage());
		if(FavoritList.getInstance().contains(receipt)){
			starButton.setSelected(true);
		} else {
			starButton.setSelected(false);
		}
		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frmKochbuch.setJMenuBar(menuBar);
	}

	private void searchAndDisplay(String text) {

		//		DefaultListModel<Receipt> tmpModel = (DefaultListModel<Receipt>)list.getModel();
		DefaultListModel<Receipt> tmpModel = new DefaultListModel<Receipt>();
		if (!comboBoxCategory.getSelectedItem().equals(Messages.getString("Kochbuch.all"))) { //$NON-NLS-1$
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				if (ReceiptList.getInstance().get(i).getCategory().equals(comboBoxCategory.getSelectedItem())) {
					tmpModel.addElement(ReceiptList.getInstance().get(i));
				}
			}
		} else {
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				tmpModel.addElement(ReceiptList.getInstance().get(i));
			}
		}
		DefaultListModel<Receipt> newModel = new DefaultListModel<Receipt>();
		if (text.equals("")) { //$NON-NLS-1$
			filterList(comboBoxCategory.getSelectedItem().toString());
		} else {
			for (int i = 0; i < tmpModel.size(); i++) {
				boolean found = false;
				if (tmpModel.getElementAt(i).getName().contains(text) || tmpModel.getElementAt(i).getReceipt().contains(text)) {
					found = true;
				}
				for (int j = 0; j < tmpModel.get(i).getIngredients().size(); j++) {
					if (tmpModel.get(i).getIngredients().get(j).getName().contains(text)) {
						found = true;
					}
				}
				if (found) {
					newModel.addElement(tmpModel.get(i));
				}
			}
			list.setModel(newModel);
		}

	}

	private void filterList(String selectedItem) {
		if (selectedItem.equals(Messages.getString("Kochbuch.all"))) { //$NON-NLS-1$
			DefaultListModel<Receipt> model = new DefaultListModel<Receipt>();
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				model.addElement(ReceiptList.getInstance().get(i));
			}
			list.setModel(model);
		} else if (selectedItem.equals(Messages.getString("Kochbuch.favorits"))) { //$NON-NLS-1$
			DefaultListModel<Receipt> model = new DefaultListModel<Receipt>();
			for (int i = 0; i < FavoritList.getInstance().size(); i++) {
				model.addElement(FavoritList.getInstance().get(i));
			}
			list.setModel(model);
		} else {
			DefaultListModel<Receipt> tmpModel = new DefaultListModel<Receipt>();
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				if (ReceiptList.getInstance().get(i).getCategory().equals(selectedItem)) {
					tmpModel.addElement(ReceiptList.getInstance().get(i));
				}
			}
			list.setModel(tmpModel);
		}
	}

	/**
	 * adds a new receipt to the list of receipes
	 * @param receipt
	 */
	public void setReceipts() { //<-- das geht, receipt ist gesetzt und korrekt
		entries.removeAllElements();
		for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
			entries.addElement(ReceiptList.getInstance().get(i));
		}
		setCategories();
	}

	public void setCategories() {
		comboBoxCategory.removeAllItems();
		for (int i = 0; i < Categories.getInstance().size(); i++) {
			comboBoxCategory.addItem(Categories.getInstance().get(i));
		}
	}

	public void close() {
		frmKochbuch.setVisible(false);
		frmKochbuch.dispose();
	}

	private void createDataFolder() {
		
		File appDataFolder = new File(APP_DATA_FOLDER);
		
		//Pruefen, ob das Kochbuchverzeichniss exisitert !
		if (!appDataFolder.exists()) {				
			appDataFolder.mkdir();				
		}
		
	}

	private class TextFieldListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				searchAndDisplay(textFieldSearch.getText());
			}

		}

	}


}
