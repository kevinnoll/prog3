package com.forms;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.receipt.Difficulty;
import com.receipt.Ingredient;
import com.receipt.IngredientList;

import javax.swing.JSpinner;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private DefaultListModel entries;
	private JList jList;
	private JSpinner spinner;
	private JTextField txtPfad;

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

		entries = new DefaultListModel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Neues Rezept");
		setBounds(100, 100, 452, 763);
		contentPane = new JPanel();
		setContentPane(contentPane);
		

		ingredientDialog = NewIngredient.getInstance();

		JLabel lblTitle = new JLabel("Titel:");

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);

		JLabel lblTag = new JLabel("Kategorie:");

		JComboBox comboBoxTag = new JComboBox();

		JButton buttonAddTag = new JButton("+");

		JLabel lblIngredient = new JLabel("Zutaten:");

		jList = new JList(entries);

		JButton btnDeleteIngredient = new JButton("Zutat l\u00F6schen");
		btnDeleteIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete selected Object from the list of Ingredients
				ingredientList.remove((Ingredient)jList.getSelectedValue());
				//delete selected Object from the List Form
				entries.removeElement(jList.getSelectedValue());
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

		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Receipt receipt = new Receipt();

			}
		});

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPaneForTextPane = new JScrollPane(textPane);
		contentPane.add(scrollPaneForTextPane);

		JLabel lblDifficulty = new JLabel("Schwierigkeit:");

		JComboBox comboBoxDifficulty = new JComboBox();
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
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblBild = new JLabel("Bild:");
		
		txtPfad = new JTextField();
		txtPfad.setText("Pfad");
		txtPfad.setColumns(10);
		
		JButton btnSuchen = new JButton("Suchen");
		
		JLabel lblAnlegen = new JLabel("Anlegen");
		lblAnlegen.setFont(new Font("Calibri", Font.BOLD, 18));

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDiscard))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblReceipt)
								.addComponent(lblTag)
								.addComponent(lblTitle)
								.addComponent(lblIngredient)
								.addComponent(lblDifficulty)
								.addComponent(lblDurationTitle)
								.addComponent(lblGang)
								.addComponent(lblBild)
								.addComponent(lblAnlegen))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtPfad, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, 0, 276, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBoxTag, 0, 217, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(buttonAddTag, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(comboBoxDifficulty, 0, 276, Short.MAX_VALUE)
								.addComponent(jList, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblDuration))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewIngredient)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteIngredient)))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAnlegen)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxTag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTag)
						.addComponent(buttonAddTag))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jList, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(lblIngredient))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewIngredient)
						.addComponent(btnDeleteIngredient))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblReceipt)
							.addGap(207))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPaneForTextPane, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
							.addGap(17)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDifficulty)
						.addComponent(comboBoxDifficulty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDurationTitle)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDuration))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGang)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBild)
						.addComponent(txtPfad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSuchen))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDiscard)
						.addComponent(btnSave))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);

	}

	public void setIngredient(Ingredient ingredient) {
		ingredientList.add(ingredient);
		insertInJList(ingredient);
	}

	private void insertInJList(Ingredient ingredient) {
		entries.addElement(ingredient);
	}
}
