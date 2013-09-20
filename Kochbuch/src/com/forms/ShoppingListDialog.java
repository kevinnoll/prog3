package com.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ShoppingListDialog dialog = new ShoppingListDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ShoppingListDialog() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(Messages.getString("ShoppingListDialog.shopping_list")); //$NON-NLS-1$

		setBounds(100, 100, 477, 541);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		scrollPane = new JScrollPane();

		JButton btnDrucken = new JButton(Messages.getString("ShoppingListDialog.print")); //$NON-NLS-1$
		btnDrucken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnVerwerfen = new JButton(Messages.getString("ShoppingListDialog.discard")); //$NON-NLS-1$
		btnVerwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showConfirmDialog(scrollPane, Messages.getString("ShoppingListDialog.please_choose_incredient_to_delete"), Messages.getString("ShoppingListDialog.no_ingredient_selected"), //$NON-NLS-1$ //$NON-NLS-2$
							JOptionPane.DEFAULT_OPTION);
				} else {
					// delete selected Object from the list of Ingredients
					int row = table.getSelectedRow();
					// delete selected Object from the List Form
					DefaultTableModel tmpModel = (DefaultTableModel) table.getModel();
					removeFromShoppingList(tmpModel, row);
					tmpModel.removeRow(row);
				}
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

		JButton btnAllesVerwerfen = new JButton(Messages.getString("ShoppingListDialog.discard_all")); //$NON-NLS-1$
		btnAllesVerwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tmpModel = new DefaultTableModel(new Object[] { Messages.getString("ShoppingListDialog.number"), Messages.getString("ShoppingListDialog.unit"), Messages.getString("ShoppingListDialog.describtion") }, 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				table.setModel(tmpModel);
				ShoppingList.getInstance().clear();
			}
		});

		JLabel lblZutatenAufIhrer = new JLabel(Messages.getString("ShoppingListDialog.ingredient_to_shopping_list")); //$NON-NLS-1$
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
		table.setSelectionBackground(new Color(154, 205, 50));
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { Messages.getString("ShoppingListDialog.number"), Messages.getString("ShoppingListDialog.unit"), Messages.getString("ShoppingListDialog.describtion") }, 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
				cancelButton = new JButton(Messages.getString("ShoppingListDialog.close")); //$NON-NLS-1$
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand(Messages.getString("ShoppingListDialog.cancel")); //$NON-NLS-1$
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
