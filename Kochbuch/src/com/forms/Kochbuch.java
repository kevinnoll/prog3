package com.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

import com.factories.MenuBarFactory;
import com.receipt.Difficulty;
import com.receipt.Entity;
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;
import com.serializer.ReceiptListSerializer;

public class Kochbuch {

	private JFrame frmKochbuch;
	private JTextField textField;
	private ReceiptList receiptList;
	private DefaultListModel entries;
	private NewReceipt receiptDialog;
	private static Kochbuch instance;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kochbuch window = new Kochbuch();
					window.frmKochbuch.setVisible(true);
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
		receiptDialog = NewReceipt.getInstance();
		
		frmKochbuch = new JFrame();
		frmKochbuch.setTitle("Kochbuch");
		frmKochbuch.setBounds(100, 100, 1127, 677);
		frmKochbuch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frmKochbuch.setJMenuBar(menuBar);

		ReceiptList.getInstance().add(getMeTheReceipt());
		entries = new DefaultListModel();
		entries.addElement("wtf?");
		entries.addElement(ReceiptList.getInstance().get(0));
		ReceiptList.getInstance().add(new Receipt("test", "test", 5, Difficulty.einfach, new LinkedList<Ingredient>()));
		entries.addElement(ReceiptList.getInstance().get(1));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblRezepte = new JLabel("Rezepte");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmKochbuch.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
						.addComponent(lblRezepte))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblRezepte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
					.addGap(37))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(new MigLayout("", "[grow][][][][grow]", "[][grow][][grow][][][]"));
		
		JLabel lblRezeptselektiert = new JLabel("Rezept (selektiert)");
		panel_1.add(lblRezeptselektiert, "cell 0 0");
		
		JList list_1 = new JList();
		panel_1.add(list_1, "cell 0 1 4 1,grow");
		
		JPanel panel_2 = new JPanel();
		
		ImageIcon image = new ImageIcon("C:/Users/Kev1n/Desktop/Fraeulein-Burger.jpg");
		JLabel label = new JLabel("", image, SwingConstants.CENTER);
		panel_2.add( label, "cell 0 0,alignx center,aligny center" );
		panel_1.add(panel_2, "cell 4 1,grow");
		panel_2.setLayout(new MigLayout("", "[::100px]", "[:1px:100px]"));
	
		
		JButton btnNewButton = new JButton("Auf Shoppingliste setzen");
		panel_1.add(btnNewButton, "cell 0 2 4 1,growx");
		
		JButton btnNewButton_1 = new JButton("Shoppingliste ansehen");
		panel_1.add(btnNewButton_1, "cell 4 2,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 3 5 1,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JLabel lblSchwierigkeit = new JLabel("Schwierigkeit:");
		panel_1.add(lblSchwierigkeit, "cell 0 4");
		
		JLabel lblNewLabel_1 = new JLabel("Einfach");
		panel_1.add(lblNewLabel_1, "cell 1 4");
		
		JLabel lblDauer = new JLabel("Dauer:");
		panel_1.add(lblDauer, "cell 0 5");
		
		JLabel lblMin = new JLabel("20 min");
		panel_1.add(lblMin, "cell 1 5");
		
		JLabel lblPlatzImMenu = new JLabel("Platz im Menu:");
		panel_1.add(lblPlatzImMenu, "cell 0 6");
		
		JLabel lblDessert = new JLabel("Dessert");
		panel_1.add(lblDessert, "cell 1 6");

		JButton btnNewButton_2 = new JButton("ok");

		JLabel lblZutatWaehlen = new JLabel("Kategorie w\u00E4hlen:");

		JList list = new JList(entries);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("bitte ausw\u00E4hlen!");

		JLabel lblNewLabel = new JLabel("Suchen:");

		textField = new JTextField();
		textField.setToolTipText("suchen!");
		textField.setColumns(10);

		JButton btnNeuesRezept = new JButton("Neues Rezept");
		btnNeuesRezept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receiptDialog.setVisible(true);
			}
		});
		
		JButton btnRezeptLschen = new JButton("Rezept l\u00F6schen");

		// may I introduce you to the GroupLayout?
		// Never touch, pure magic!
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblZutatWaehlen, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_2))
								.addComponent(comboBox, 0, 328, Short.MAX_VALUE))
							.addGap(19))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNeuesRezept)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRezeptLschen)))
							.addGap(20))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZutatWaehlen)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRezeptLschen)
						.addComponent(btnNeuesRezept))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frmKochbuch.getContentPane().setLayout(groupLayout);

		// GroupLayout ends here

	}

	private Receipt getMeTheReceipt() {
		Ingredient ingredient1 = new Ingredient("Kartoffel",
				Entity.kg, 1);
		Ingredient ingredient2 = new Ingredient("Salz", Entity.g, 10);
		Ingredient ingredient3 = new Ingredient("Wasser",
				Entity.Liter, 2.5);
		Ingredient ingredient4 = new Ingredient("Petersilie",
				Entity.Stück, 1);
		LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		String rezeptname = "Salzkartoffeln mit Petersilie";
		String anleitung = "Alles zusamnwerfen und 25 minuten kochen(außer die petersilie"
				+ ") dann mit der Gabel prüfen ob die Kartoffeln weich sind und das Wasser abgießen und die Petersilie "
				+ "drüberstreuen. Fertig.";

		Receipt receipt = new Receipt(rezeptname, anleitung, 25,
				Difficulty.einfach, ingredients);
		return receipt;
	}

	/**
	 * Auslesen der Warteschlange aus einer Datei
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void ReadReceiptListFromDisk() throws IOException,
			ClassNotFoundException {
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
	
	/**
	 * adds a new receipt to the list of receipes
	 * @param receipt
	 */
	public void setNewReceipt(Receipt receipt){
		ReceiptList.getInstance().add(receipt);
		entries.addElement(ReceiptList.getInstance().getLast());
	}
}
