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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
import com.receipt.Receipt;
import com.receipt.ReceiptList;
import com.serializer.ImageFileView;
import com.serializer.ImageFilter;
import com.serializer.ImagePreview;

import javax.swing.JSpinner;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.LinkedList;

import javax.swing.JTable;

import java.awt.Dimension;
import java.io.File;

public class NewReceipt extends JFrame {

	public static int CURRENT_ID = 3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitle;
	private GroupLayout gl_contentPane;
	//	private NewIngredient ingredientDialog;
	private static NewReceipt instance;
	private LinkedList<Ingredient> ingredientList;
	private JSpinner spinner;
	private JTextField txtPfad;
	private JComboBox<String> comboBoxCategory;
	private JComboBox<Course> comboBoxGang;
	private JTextPane textPane;
	private DefaultTableModel tableModel;
	private JComboBox<Difficulty> comboBoxDifficulty;
	private JButton btnSave;
	private boolean newReceipt;
	private int receiptId;
	private JTable table;
	private File file;

	static private String newline = "\n";
	private JFileChooser fc;

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
		ingredientList = new LinkedList<Ingredient>();
		tableModel = new DefaultTableModel(new Object[] { "Anzahl", "Einheit", "Bezeichnung" }, 0);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Neues Rezept");
		setBounds(100, 100, 460, 777);
		contentPane = new JPanel();
		setContentPane(contentPane);

		textPane = new JTextPane();
		textPane.setMinimumSize(new Dimension(1, 1));
		textPane.setPreferredSize(new Dimension(6, 1));
		JScrollPane scrollPaneForTextPane = new JScrollPane(textPane);
		scrollPaneForTextPane.setPreferredSize(new Dimension(8, 2));
		contentPane.add(scrollPaneForTextPane);

		//		ingredientDialog = NewIngredient.getInstance();

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
				ingredientList.remove(getIngredientIndexFromTable((DefaultTableModel) table.getModel(), row));
				// delete selected Object from the List Form
				DefaultTableModel tmpModel = (DefaultTableModel) table.getModel();
				tmpModel.removeRow(row);
				table.setModel(tmpModel);
				// entries.removeElement(jList.getSelectedValue());
			}

			private int getIngredientIndexFromTable(DefaultTableModel defaultModel, int row) {
				String name = defaultModel.getValueAt(row, 2).toString();
				Entity entity = Entity.valueOf(defaultModel.getValueAt(row, 1).toString());
				Double quantity = Double.parseDouble(defaultModel.getValueAt(row, 0).toString());
				for (int i = 0; i < ingredientList.size(); i++) {
					Ingredient tmp = ingredientList.get(i);
					if (tmp.getName().equals(name) && tmp.getQuantity() == quantity && tmp.getEntity().equals(entity)) {
						return i;
					}
				}
				return -1;
			}
		});

		JButton btnNewIngredient = new JButton("Neue Zutat");
		btnNewIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewIngredient newIngredientDialog = new NewIngredient();
				newIngredientDialog.setVisible(true);

			}
		});

		JLabel lblReceipt = new JLabel("Rezept:");

		JButton btnDiscard = new JButton("Verwerfen");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				Receipt receipt = new Receipt();
				if (textFieldTitle.getText().trim().isEmpty() || textPane.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(btnSave, "Bitte alles ausfüllen!");
				} else {
					if (newReceipt) {
						Receipt toReturn = new Receipt(CURRENT_ID, textFieldTitle.getText(), textPane.getText(), Integer
								.parseInt(spinner.getValue().toString()), Difficulty.valueOf(comboBoxDifficulty.getSelectedItem().toString()), Course
								.valueOf(comboBoxGang.getSelectedItem().toString()), ingredientList, comboBoxCategory.getSelectedItem().toString());
						toReturn.setImage(file);
						CURRENT_ID++;
						ReceiptList.getInstance().add(toReturn);
						Kochbuch.getInstance().setReceipts();
						dispose();
					} else {
						for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
							if (ReceiptList.getInstance().get(i).getiD() == receiptId) {
								Receipt toReturn = new Receipt(receiptId, textFieldTitle.getText(), textPane.getText(), Integer.parseInt(spinner.getValue()
										.toString()), Difficulty.valueOf(comboBoxDifficulty.getSelectedItem().toString()), Course.valueOf(comboBoxGang
										.getSelectedItem().toString()), ingredientList, comboBoxCategory.getSelectedItem().toString());
								ReceiptList.getInstance().set(i, toReturn);
								Kochbuch.getInstance().setReceipts();
								dispose();
							}
						}
					}
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
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set up the file chooser.
				if (fc == null) {
					fc = new JFileChooser();
					//Add a custom file filter and disable the default
					//(Accept All) file filter.
					fc.addChoosableFileFilter(new ImageFilter());
					fc.setAcceptAllFileFilterUsed(false);
					//Add custom icons for file types.
					fc.setFileView(new ImageFileView());
					//Add the preview pane.
					fc.setAccessory(new ImagePreview(fc));
				}
				//Show it.
				int returnVal = fc.showDialog(contentPane, "Attach");
				//Process the results.
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					if (fc.getSelectedFile().getName().endsWith(".gif") || fc.getSelectedFile().getName().endsWith(".png") || fc.getSelectedFile().getName().endsWith(".jpg")
							|| fc.getSelectedFile().getName().endsWith(".jpeg")) {
						file = fc.getSelectedFile();
						txtPfad.setText(file.getAbsolutePath());
					}
				} 
				fc.setSelectedFile(null);
			}
		});

		JLabel lblAnlegen = new JLabel("Anlegen");
		lblAnlegen.setFont(new Font("Calibri", Font.BOLD, 18));

		Object[][] data = { { "1", "gramm", "bier" } };
		String[] columnNames = { "Anzahl", "Einheit", "Bezeichnung" };

		JScrollPane scrollPane = new JScrollPane();
		// table.addColumn(new TableColumn(modelIndex, width, cellRenderer,
		// cellEditor));
		// table.addColumn(new TableColumn(1, 40));
		// table.addColumn(new TableColumn(2, 30));

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
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
																gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblBild)
																		.addComponent(lblGang).addComponent(lblReceipt).addComponent(lblTag)
																		.addComponent(lblTitle).addComponent(lblIngredient).addComponent(lblDifficulty)
																		.addComponent(lblDurationTitle).addComponent(lblAnlegen))
														.addGap(50)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(comboBoxGang, 0, 284, Short.MAX_VALUE)
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 283,
																								Short.MAX_VALUE).addGap(1))
																		.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(comboBoxCategory, 0, 225, Short.MAX_VALUE)
																						.addGap(18)
																						.addComponent(buttonAddTag, GroupLayout.PREFERRED_SIZE, 41,
																								GroupLayout.PREFERRED_SIZE))
																		.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
																		.addComponent(comboBoxDifficulty, 0, 284, Short.MAX_VALUE)
																		.addGroup(
																				gl_contentPane.createSequentialGroup()
																						.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
																						.addGap(18).addComponent(lblDuration))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(Alignment.TRAILING)
																										.addComponent(txtPfad, GroupLayout.DEFAULT_SIZE, 186,
																												Short.MAX_VALUE).addComponent(btnSave))
																						.addPreferredGap(ComponentPlacement.UNRELATED)
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(Alignment.TRAILING, false)
																										.addComponent(btnDiscard, GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(btnSuchen, GroupLayout.DEFAULT_SIZE, 88,
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
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblIngredient)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewIngredient).addComponent(btnDeleteIngredient))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblReceipt).addGap(207))
										.addGroup(
												gl_contentPane.createSequentialGroup()
														.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE).addGap(17)))
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDifficulty)
										.addComponent(comboBoxDifficulty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDurationTitle)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(lblDuration))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBoxGang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGang))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtPfad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSuchen).addComponent(lblBild)).addGap(27)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnDiscard).addComponent(btnSave)).addGap(20)));

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

	}

	private void addItemsToCategoryBox() {
		Categories categories = Categories.getInstance();
		for (int i = 1; i < categories.size(); i++) { //bei 1 anfangen schliesst kategorie ALLE aus. 
			comboBoxCategory.addItem(categories.get(i).toString());
		}
	}

	public void setIngredient(Ingredient ingredient) {
		ingredientList.add(ingredient);
		insertInTable(ingredient);
	}

	public void resetFields() {
		newReceipt = true;
		ingredientList = new LinkedList<Ingredient>();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Anzahl", "Einheit", "Bezeichnung" }, 0);
		table.setModel(model);
		textFieldTitle.setText("");
		textPane.setText("");
		spinner.setValue(0);
		comboBoxDifficulty.setSelectedIndex(0);
		comboBoxGang.setSelectedIndex(0);
		comboBoxCategory.setSelectedIndex(0);
	}

	private void insertInTable(Ingredient ingredient) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { ingredient.getQuantity(), ingredient.getEntity(), ingredient.getName() });
	}

	public void setCategory(String category) {
		//		Categories.getInstance().add(category);
		comboBoxCategory.removeAllItems();
		addItemsToCategoryBox();
	}

	public void setFields(Receipt selectedValue) {
		resetFields();
		newReceipt = false;
		receiptId = selectedValue.getiD();
		ingredientList = new LinkedList<Ingredient>();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Anzahl", "Einheit", "Bezeichnung" }, 0);
		for (int i = 0; i < selectedValue.getIngredients().size(); i++) {
			model.addRow(new Object[] { selectedValue.getIngredients().get(i).getQuantity(), selectedValue.getIngredients().get(i).getEntity(),
					selectedValue.getIngredients().get(i).getName() });
			ingredientList.add(selectedValue.getIngredients().get(i));
		}
		table.setModel(model);
		textFieldTitle.setText(selectedValue.getName());
		textPane.setText(selectedValue.getReceipt());
		spinner.setValue(selectedValue.getDuration());
		comboBoxDifficulty.setSelectedItem(selectedValue.getDifficulty());
		comboBoxGang.setSelectedItem(selectedValue.getCourse());
		comboBoxCategory.setSelectedItem(selectedValue.getCategory());
	}
}
