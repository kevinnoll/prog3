package com.forms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.jgoodies.forms.layout.ColumnSpec;
import com.receipt.Categories;
import com.receipt.Course;
import com.receipt.Difficulty;
import com.receipt.Entity;
import com.receipt.Ingredient;
import com.receipt.IngredientList;
import com.receipt.Receipt;

import javax.swing.JSpinner;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTable;

public class NewReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitle;
	private GroupLayout gl_contentPane;
	private NewIngredient ingredientDialog;
	private static NewReceipt instance;
	private IngredientList ingredientList;
	private JSpinner spinner;
	private JTextField txtPfad;
	private JComboBox<String> comboBoxCategory;
	private JTable table;
	private JComboBox<Course> comboBoxGang;
	private JTextPane textPane;
	private DefaultTableModel tableModel;
	private JComboBox<Difficulty> comboBoxDifficulty;
	private JButton btnSave;

	public static synchronized NewReceipt getInstance() {
		if (instance == null)
			instance = new NewReceipt();
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReceipt frame = new NewReceipt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private NewReceipt() {
		ingredientList = new IngredientList();
		tableModel = new DefaultTableModel(new Object[] { "Anzahl", "Einheit", "Bezeichnung" }, 0);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Neues Rezept");
		setBounds(100, 100, 460, 777);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		textPane = new JTextPane();
		JScrollPane scrollPaneForTextPane = new JScrollPane(textPane);
		contentPane.add(scrollPaneForTextPane);

		ingredientDialog = NewIngredient.getInstance();

		JLabel lblTitle = new JLabel("Titel:");

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);

		JLabel lblTag = new JLabel("Kategorie:");

		comboBoxCategory = new JComboBox<String>();
		addItemsToCategoryBox();

		JButton buttonAddTag = new JButton("+");
		buttonAddTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCategory addCategoryDialog = new AddCategory();
				addCategoryDialog.setVisible(true);
			}
		});

		JLabel lblIngredient = new JLabel("Zutaten:");

		JButton btnDeleteIngredient = new JButton("Zutat l\u00F6schen");
		btnDeleteIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete selected Object from the list of Ingredients
				int row = table.getSelectedRow();
				ingredientList.remove(getIngredientIndexFromTable(row));
				// delete selected Object from the List Form
				tableModel.removeRow(row);
				// entries.removeElement(jList.getSelectedValue());
			}

			private int getIngredientIndexFromTable(int row) {
				String name = tableModel.getValueAt(row, 2).toString();
				Entity entity = Entity.valueOf(tableModel.getValueAt(row, 1).toString());
				Double quantity = Double.parseDouble(tableModel.getValueAt(row, 0).toString());
				for(int i = 0; i < ingredientList.size(); i++){
					Ingredient tmp = ingredientList.get(i);
					if(tmp.getName().equals(name) && tmp.getQuantity() == quantity && tmp.getEntity().equals(entity)){
						return i;
					}
				}
				return -1;
			}
		});

		JButton btnNewIngredient = new JButton("Neue Zutat");
		btnNewIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientDialog.setVisible(true);

			}
		});

		JLabel lblReceipt = new JLabel("Rezept:");

		JButton btnDiscard = new JButton("Verwerfen");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kochbuch.getInstance().setCategories();
			}
		});

		btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Receipt receipt = new Receipt();
				if(textFieldTitle.getText().trim().isEmpty() || textPane.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(btnSave, "Bitte alles ausfüllen!");
				} else {
					Receipt toReturn = new Receipt(textFieldTitle.getText(),
							textPane.getText(),
							Integer.parseInt(spinner.getValue().toString()),
							Difficulty.valueOf(comboBoxDifficulty.getSelectedItem().toString()),
							Course.valueOf(comboBoxGang.getSelectedItem().toString()),
							ingredientList,
							comboBoxCategory.getSelectedItem().toString());
					Kochbuch.getInstance().setNewReceipt(toReturn);
					dispose();
				}
			}
		});


		JLabel lblDifficulty = new JLabel("Schwierigkeit:");

		comboBoxDifficulty = new JComboBox<Difficulty>();
		comboBoxDifficulty.addItem(Difficulty.einfach);
		comboBoxDifficulty.addItem(Difficulty.mittel);
		comboBoxDifficulty.addItem(Difficulty.schwer);

		JLabel lblDurationTitle = new JLabel("Dauer:");

		JLabel lblDuration = new JLabel("min");

		spinner = new JSpinner();
		spinner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double.parseDouble(spinner.getValue().toString());
				} catch (NumberFormatException ex) {
					spinner.setValue(0);
				}
			}
		});

		JLabel lblGang = new JLabel("Gang:");

		comboBoxGang = new JComboBox<Course>();
		comboBoxGang.addItem(Course.Vorspeise);
		comboBoxGang.addItem(Course.Hauptgericht);
		comboBoxGang.addItem(Course.Dessert);
		
		JLabel lblBild = new JLabel("Bild:");

		txtPfad = new JTextField();
		txtPfad.setText("Pfad");
		txtPfad.setColumns(10);

		JButton btnSuchen = new JButton("Suchen");

		JLabel lblAnlegen = new JLabel("Anlegen");
		lblAnlegen.setFont(new Font("Calibri", Font.BOLD, 18));

		Object[][] data = { { "1", "gramm", "bier" } };
		String[] columnNames = { "Anzahl", "Einheit", "Bezeichnung" };
		table = new JTable(tableModel);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		// table.addColumn(new TableColumn(modelIndex, width, cellRenderer,
		// cellEditor));
		// table.addColumn(new TableColumn(1, 40));
		// table.addColumn(new TableColumn(2, 30));

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addGroup(
																		gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblReceipt)
																				.addComponent(lblTag).addComponent(lblTitle).addComponent(lblIngredient)
																				.addComponent(lblDifficulty).addComponent(lblDurationTitle)
																				.addComponent(lblGang).addComponent(lblBild).addComponent(lblAnlegen))
																.addGap(50)
																.addGroup(
																		gl_contentPane
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 276,
																						Short.MAX_VALUE)
																				.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 284,
																						Short.MAX_VALUE)
																				.addComponent(comboBoxGang, 0, 276, Short.MAX_VALUE)
																				.addGroup(
																						gl_contentPane
																								.createSequentialGroup()
																								.addComponent(comboBoxCategory, 0, 217, Short.MAX_VALUE)
																								.addGap(18)
																								.addComponent(buttonAddTag, GroupLayout.PREFERRED_SIZE, 41,
																										GroupLayout.PREFERRED_SIZE))
																				.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
																				.addComponent(comboBoxDifficulty, 0, 276, Short.MAX_VALUE)
																				.addGroup(
																						gl_contentPane
																								.createSequentialGroup()
																								.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 242,
																										Short.MAX_VALUE).addGap(18).addComponent(lblDuration))
																				.addGroup(
																						Alignment.TRAILING,
																						gl_contentPane
																								.createSequentialGroup()
																								.addGroup(
																										gl_contentPane
																												.createParallelGroup(Alignment.TRAILING)
																												.addComponent(btnSave)
																												.addComponent(txtPfad,
																														GroupLayout.DEFAULT_SIZE, 178,
																														Short.MAX_VALUE))
																								.addPreferredGap(ComponentPlacement.UNRELATED)
																								.addGroup(
																										gl_contentPane
																												.createParallelGroup(Alignment.LEADING, false)
																												.addComponent(btnDiscard,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(btnSuchen,
																														GroupLayout.DEFAULT_SIZE, 88,
																														Short.MAX_VALUE)))))
												.addGroup(
														gl_contentPane.createSequentialGroup().addComponent(btnNewIngredient)
																.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDeleteIngredient))).addGap(34)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblAnlegen)
						.addGap(14)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTitle))
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTag).addComponent(buttonAddTag))
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblIngredient)
										.addComponent(table, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewIngredient).addComponent(btnDeleteIngredient))
						.addGap(18)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblReceipt).addGap(207))
										.addGroup(
												gl_contentPane.createSequentialGroup()
														.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE).addGap(17)))
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDifficulty)
										.addComponent(comboBoxDifficulty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDurationTitle)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(lblDuration))
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblGang)
										.addComponent(comboBoxGang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblBild)
										.addComponent(txtPfad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSuchen)).addGap(27)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnDiscard).addComponent(btnSave)).addGap(33)));
		contentPane.setLayout(gl_contentPane);

	}

	private void addItemsToCategoryBox() {
		Categories categories = Categories.getInstance();
		for(int i = 0; i < categories.size(); i++){
			comboBoxCategory.addItem(categories.get(i).toString());
		}
	}

	public void setIngredient(Ingredient ingredient) {
		ingredientList.add(ingredient);
		insertInTable(ingredient);
	}

	private void insertInTable(Ingredient ingredient) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { ingredient.getQuantity(), ingredient.getEntity(), ingredient.getName() });
	}
	
	public void setCategory(String category){
//		Categories.getInstance().add(category);
		comboBoxCategory.removeAllItems();
		addItemsToCategoryBox();
	}
}
