package com.forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.receipt.Entity;
import com.receipt.Ingredient;
import com.shoppinglist.ShoppingList;

public class ShoppingListDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ShoppingListDialog dialog = new ShoppingListDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShoppingListDialog() {
		setTitle("Shoppingliste");

		setBounds(100, 100, 477, 541);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnDrucken = new JButton("Drucken");

		JButton btnVerwerfen = new JButton("Verwerfen");
		btnVerwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete selected Object from the list of Ingredients
				int row = table.getSelectedRow();
				// delete selected Object from the List Form
				DefaultTableModel tmpModel = (DefaultTableModel) table.getModel();
				removeFromShoppingList(tmpModel, row);
				tmpModel.removeRow(row);
			}

			private void removeFromShoppingList(DefaultTableModel defaultModel, int row) {
				String name = defaultModel.getValueAt(row, 2).toString();
				Entity entity = Entity.valueOf(defaultModel.getValueAt(row, 1).toString());
				Double quantity = Double.parseDouble(defaultModel.getValueAt(row, 0).toString());
				for (int i = 0; i < ShoppingList.getInstance().size(); i++) {
					Ingredient tmp = ShoppingList.getInstance().get(i);
					if (tmp.getName().equals(name) && tmp.getQuantity() == quantity && tmp.getEntity().equals(entity)) {
						ShoppingList.getInstance().remove(i);
					}
				}
			}

		});

		JButton btnAllesVerwerfen = new JButton("Alles Verwerfen");
		btnAllesVerwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblZutatenAufIhrer = new JLabel("Zutaten auf Ihrer Shoppingliste:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
										.addGroup(
												gl_contentPanel.createSequentialGroup().addComponent(btnDrucken)
														.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE).addComponent(btnAllesVerwerfen)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVerwerfen))
										.addComponent(lblZutatenAufIhrer)).addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblZutatenAufIhrer)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(btnDrucken).addComponent(btnVerwerfen)
										.addComponent(btnAllesVerwerfen)).addGap(9)));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "Anzahl", "Einheit", "Bezeichnung" }, 0);
		for (int i = 0; i < ShoppingList.getInstance().size(); i++) {
			tableModel.addRow(new Object[] { ShoppingList.getInstance().get(i).getQuantity(), ShoppingList.getInstance().get(i).getEntity(),
					ShoppingList.getInstance().get(i).getName() });

		}
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Schlie\u00DFen");
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING).addGroup(
					Alignment.TRAILING,
					gl_buttonPane.createSequentialGroup().addContainerGap(350, Short.MAX_VALUE)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE).addGap(19)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING).addGroup(
					gl_buttonPane.createSequentialGroup().addContainerGap(5, Short.MAX_VALUE).addComponent(cancelButton).addContainerGap()));
			buttonPane.setLayout(gl_buttonPane);
		}
	}
}
