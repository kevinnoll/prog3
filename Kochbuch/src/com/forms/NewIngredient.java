package com.forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.receipt.Entity;
import com.receipt.Ingredient;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * DialogClass to create a Ingredient.
 * 
 * @author Kevin Noll
 * 
 */
public class NewIngredient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIngredient;
	private JComboBox comboBoxEntity;
	private JSpinner spinnerAmount;
	private static NewIngredient instance;

//	/**
//	 * Singleton pattern
//	 */
//	public static synchronized NewIngredient getInstance() {
//		if (instance == null)
//			instance = new NewIngredient();
//		return instance;
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewIngredient frame = new NewIngredient();
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
	public NewIngredient() {
		setResizable(false);
		setTitle("Zutat anlegen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAmount = new JLabel("Menge");

		comboBoxEntity = new JComboBox();
		comboBoxEntity.setModel(new DefaultComboBoxModel(Entity.values()));

		JLabel lblEntity = new JLabel("Einheit");

		textFieldIngredient = new JTextField();
		textFieldIngredient.setColumns(10);

		JLabel lblIngredient = new JLabel("Lebensmittel");
		spinnerAmount = new JSpinner();
		spinnerAmount.setValue(0);
		
		JButton btnDiscard = new JButton("Verwerfen");
		JButton btnSave = new JButton("Speichern");
		
		/**
		 * EventListener on focusLost-event to set a correct double value into the 
		 * spinner when the mouse leaves.
		 */
		spinnerAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double.parseDouble(spinnerAmount.getValue().toString());
				} catch (NumberFormatException ex) {
					spinnerAmount.setValue(0);
				}
			}
		});
		
		/**
		 * OnClick Exit-event
		 * closes the Dialog
		 */
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldIngredient.setText("");
				dispose();
			}
		});

		/**
		 * OnClick Save-event
		 * Saves back the Ingredient if correct and closes the dialog
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textFieldIngredient.getText().trim().isEmpty()) {
						Ingredient ingredient = new Ingredient(
								textFieldIngredient.getText(),
								(Entity) comboBoxEntity.getSelectedItem(),
								Double.parseDouble(spinnerAmount.getValue()
										.toString()));

						NewReceipt.getInstance().setIngredient(ingredient);
						dispose();
					}
				} catch (NumberFormatException ex) {
					textFieldIngredient.setText(ex.toString());
				}
			}
		});

		/**
		 * LayoutManager, do not touch!
		 */
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblAmount)
																						.addComponent(
																								spinnerAmount,
																								GroupLayout.PREFERRED_SIZE,
																								86,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblEntity)
																						.addComponent(
																								comboBoxEntity,
																								GroupLayout.PREFERRED_SIZE,
																								57,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblIngredient)
																						.addComponent(
																								textFieldIngredient,
																								GroupLayout.DEFAULT_SIZE,
																								204,
																								Short.MAX_VALUE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				btnSave)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnDiscard)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblIngredient)
																		.addGap(77))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblAmount)
																						.addComponent(
																								lblEntity))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								comboBoxEntity,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textFieldIngredient,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								spinnerAmount,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnDiscard)
																						.addComponent(
																								btnSave))
																		.addContainerGap()))));
		contentPane.setLayout(gl_contentPane);
	}
}
