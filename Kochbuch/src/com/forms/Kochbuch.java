package com.forms;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

import net.miginfocom.swing.MigLayout;

import com.factories.MenuBarFactory;
import com.receipt.Categories;
import com.receipt.Course;
import com.receipt.Difficulty;
import com.receipt.Entity;
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;
import com.serializer.ReceiptListSerializer;
import com.shoppinglist.ShoppingList;
import java.awt.Color;

public class Kochbuch extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmKochbuch;
	private JTextField textFieldSearch;
	private ReceiptList receiptList;
	private DefaultListModel<Receipt> entries;
	//	private NewReceipt receiptDialog;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kochbuch.getInstance();
					//					window.frmKochbuch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Kochbuch() {
		initialize();
	}

	public static synchronized Kochbuch getInstance() {
		if (instance == null)
			instance = new Kochbuch();
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//external initializations
		//		receiptDialog = NewReceipt.getInstance();

		frmKochbuch = new JFrame();
		frmKochbuch.setTitle("Kochbuch");
		frmKochbuch.setBounds(100, 100, 1127, 677);
		frmKochbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKochbuch.setVisible(false);
		frmKochbuch.setVisible(true);

		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frmKochbuch.setJMenuBar(menuBar);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblRezepte = new JLabel("Rezepte");

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
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][grow][][grow][][][]"));

		lblRezeptselektiert = new JLabel("Rezept (selektiert)");
		panel_1.add(lblRezeptselektiert, "cell 0 0 2 1,growx");

		JPanel panel_2 = new JPanel();

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, "cell 0 1,grow");

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
		panel_2.add(scrollPane_1, "flowx,cell 0 0,grow");
		ImageIcon image = new ImageIcon("C:/Users/Kev1n/Desktop/Fraeulein-Burger.jpg");

		labelPicture = new JLabel("", image, SwingConstants.CENTER);
		labelPicture.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		scrollPane_1.setViewportView(labelPicture);
		panel_1.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[50px,grow]"));

		JButton btnNewButton = new JButton("Auf Shoppingliste setzen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listIngredientsRightSide.getSelectedIndex() == -1) {
					JOptionPane.showConfirmDialog(listIngredientsRightSide, "Bitte eine Zutat zum Hinzufügen auswählen", "Keine Zutat angeklickt",
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
		panel_1.add(btnNewButton, "cell 0 2,growx");

		JButton btnNewButton_1 = new JButton("Shoppingliste ansehen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingListDialog shoppingListDialog = new ShoppingListDialog();
				shoppingListDialog.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_1, "cell 1 2,growx");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 200));
		panel_1.add(scrollPane, "cell 0 3 2 1,grow");

		textPane = new JTextPane();
		textPane.setSelectionColor(new Color(154, 205, 50));
		textPane.setPreferredSize(new Dimension(6, 200));
		textPane.setMaximumSize(new Dimension(2147483647, 200));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);

		JLabel lblSchwierigkeit = new JLabel("Schwierigkeit:");
		panel_1.add(lblSchwierigkeit, "cell 0 4");

		lblDifficulty = new JLabel("Einfach");
		panel_1.add(lblDifficulty, "cell 1 4");

		JLabel lblDauer = new JLabel("Dauer:");
		panel_1.add(lblDauer, "cell 0 5");

		lblDuration = new JLabel("20 min");
		panel_1.add(lblDuration, "cell 1 5");

		JLabel lblPlatzImMenu = new JLabel("Platz im Menu:");
		panel_1.add(lblPlatzImMenu, "cell 0 6");

		lblCourse = new JLabel("Dessert");
		panel_1.add(lblCourse, "cell 1 6");

		searchButton = new JButton("Los!");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //OnClick
				searchAndDisplay(textFieldSearch.getText());
			}
		});

		JLabel lblZutatWaehlen = new JLabel("Kategorie w\u00E4hlen:");

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setToolTipText("bitte ausw\u00E4hlen!");
		setCategories();
		comboBoxCategory.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSearch.setText("");
					filterList(comboBoxCategory.getSelectedItem().toString());
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Suchen:");

		textFieldSearch = new JTextField();
		textFieldSearch.setToolTipText("suchen!");

		JButton btnNeuesRezept = new JButton("Neues Rezept");
		btnNeuesRezept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewReceipt.getInstance().resetFields();
				NewReceipt.getInstance().setVisible(true);
			}
		});
		btnRezeptLschen = new JButton("Rezept l\u00F6schen");
		btnRezeptLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(scrollPane_2, "Wirklich löschen?", "Bitte bestätigen", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
					entries.removeElement(list.getSelectedValue());
					ReceiptList.getInstance().remove(list.getSelectedValue());
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
		
		
		JButton btnRezeptBearbeiten = new JButton("Rezept bearbeiten");
		btnRezeptBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showConfirmDialog(scrollPane_2, "Bitte ein Rezept zum bearbeiten auswählen", "Kein Rezept angeklickt",
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

		ReceiptList.getInstance().add(getMeTheReceipt());
		ReceiptList.getInstance().add(getMeTheReceipt2());
		entries = new DefaultListModel<Receipt>();

		entries.addElement(ReceiptList.getInstance().get(0));
		entries.addElement(ReceiptList.getInstance().get(1));
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
		for (int i = 0; i < list.getSelectedValue().getIngredients().size(); i++) {
			newModel.addElement(list.getSelectedValue().getIngredients().get(i));
		}
		lblRezeptselektiert.setText(list.getSelectedValue().getName());
		lblRezeptselektiert.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		listIngredientsRightSide.setModel(newModel);
		textPane.setText(list.getSelectedValue().getReceipt());
		lblCourse.setText(list.getSelectedValue().getCourse().toString());
		lblDifficulty.setText(list.getSelectedValue().getDifficulty().toString());
		lblDuration.setText(list.getSelectedValue().getDuration() + " min");
		labelPicture.setIcon(list.getSelectedValue().getImage());
	}

	protected void searchAndDisplay(String text) {

		//		DefaultListModel<Receipt> tmpModel = (DefaultListModel<Receipt>)list.getModel();
		DefaultListModel<Receipt> tmpModel = new DefaultListModel<Receipt>();
		if (!comboBoxCategory.getSelectedItem().equals("Alle")) {
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				if (ReceiptList.getInstance().get(i).getCategory().equals(comboBoxCategory.getSelectedItem())) {
					tmpModel.addElement(ReceiptList.getInstance().get(i));
				}
			}
		} else {
			for(int i= 0; i < ReceiptList.getInstance().size();i++){
				tmpModel.addElement(ReceiptList.getInstance().get(i));
			}
		}
		DefaultListModel<Receipt> newModel = new DefaultListModel<Receipt>();
		if (text.equals("")) {
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

	protected void filterList(String selectedItem) {
		if (selectedItem.equals("Alle")) {
			DefaultListModel<Receipt> model = new DefaultListModel<Receipt>();
			for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
				model.addElement(ReceiptList.getInstance().get(i));
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

	private Receipt getMeTheReceipt() {
		Ingredient ingredient1 = new Ingredient("Rinderhack", Entity.g, 150);
		Ingredient ingredient2 = new Ingredient("Salz", Entity.g, 10);
		Ingredient ingredient5 = new Ingredient("Pfeffer", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Salat", Entity.Stück, 1);
		Ingredient ingredient4 = new Ingredient("Brötchen", Entity.Stück, 1);
		Ingredient ingredient6 = new Ingredient("Ketchup", Entity.Milliliter, 20);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);

		String rezeptname = "Burger";
		String anleitung = "Das Hackfleisch mit dem Salz und dem Pfeffer würzen, eine flache Scheibe formen ganz durchbraten."
				+ " Das Brötchen in der in der Hälfte aufschneiden, nach Wunsch toasten und mit dem Ketchup nach Belieben bestreichen."
				+ " Das fertig gebratene Hackfleisch aus der Pfanne nehmen und auf den Ketchup legen. Anschließend mit Salat garnieren. Fertig. ";

		Receipt receipt = new Receipt(0, rezeptname, anleitung, 25, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(2));
		File file = new File("images/burger.jpg");
		receipt.setImage(file);
		return receipt;
	}

	private Receipt getMeTheReceipt2() {
		Ingredient ingredient1 = new Ingredient("Kartoffel", Entity.kg, 1);
		Ingredient ingredient2 = new Ingredient("Salz", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Wasser", Entity.Liter, 2.5);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);

		String rezeptname = "Salzkartoffeln";
		String anleitung = "Alles zusamnwerfen und 25 minuten kochen(außer die Petersilie"
				+ ") dann mit der Gabel prüfen ob die Kartoffeln weich sind und das Wasser abgießen und die Petersilie " + "drüberstreuen. Fertig.";

		Receipt receipt = new Receipt(1, rezeptname, anleitung, 25, Difficulty.einfach, Course.Hauptgericht, ingredients, Categories.getInstance().get(1));
		File file = new File("images/salzkartoffeln.png");
		receipt.setImage(file);
		return receipt;
	}

	public void close() {
		frmKochbuch.setVisible(false);
		frmKochbuch.dispose();
	}

	/**
	 * Auslesen der Warteschlange aus einer Datei
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void ReadReceiptListFromDisk() throws IOException, ClassNotFoundException {
		// Dateiname einlesen
		// TODO PFAD AUSLESEN ! ! ! ! String dateiname =
		// Stdin.readString(EINGABE_WARTESCHLANGE_EINLESEN);
		String dateiname = "%APPDATA%/Prog3Kochbuch/savegame";
		// die Studentenliste serialisieren
		receiptList = ReceiptListSerializer.deserialize(dateiname);

		// Ausgabe an den Nutzer
		// System.out.println(INFO_WARTESCHLANGE_EINLESEN);
	}

	/**
	 * Schreibt eine Warteschlange in eine vom Nutzer ausgewaehlte Datei
	 * 
	 * @throws IOException
	 */
	private void writeReceiptListToDisk() throws IOException {
		// Datiename einlesen
		// TODO String dateiname =
		// Stdin.readString(EINGABE_WARTESCHLANGE_ANLEGEN);
		String dateiname = "%APPDATA%/Prog3Kochbuch/savegame";
		// Objekt wegschreiben
		ReceiptListSerializer.serialize(dateiname, receiptList);

		// Ausgabe an den Nutzer
		// System.out.println(INFO_WARTESCHLANGE_ANLEGEN);
	}
	
}
