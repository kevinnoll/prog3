package com.forms;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import com.factories.MenuBarFactory;
import com.receipt.Difficulty;
import com.receipt.Entity;
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;
import com.serializer.ReceiptListSerializer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kochbuch {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 979, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = MenuBarFactory.getTheMenuBar();
		frame.setJMenuBar(menuBar);

		ReceiptList.getInstance().add(getMeTheReceipt());
		entries = new DefaultListModel();
		entries.addElement("wtf?");
		entries.addElement(ReceiptList.getInstance().get(0));
		ReceiptList.getInstance().add(new Receipt("test", "test", 5, Difficulty.einfach, new LinkedList<Ingredient>()));
		entries.addElement(ReceiptList.getInstance().get(1));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblRezepte = new JLabel("Rezepte");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRezepte))
						.addContainerGap(524, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(8)
						.addComponent(lblRezepte)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 555,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));

		JButton btnNewButton_2 = new JButton("ok");

		JLabel lblZutatWaehlen = new JLabel("Zutat w\u00E4hlen:");

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
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_2))
								.addComponent(comboBox, 0, 256, Short.MAX_VALUE))
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNeuesRezept)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRezeptLschen))
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
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
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRezeptLschen)
						.addComponent(btnNeuesRezept))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);

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
