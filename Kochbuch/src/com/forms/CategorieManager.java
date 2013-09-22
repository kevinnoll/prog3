package com.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

import com.menu.Menu;
import com.menu.MenuList;
import com.receipt.Categories;
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;

public class CategorieManager extends JDialog {

	private static CategorieManager instance;
	private final JPanel contentPanel = new JPanel();
	private JList<String> catList;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			MenuManager.getInstance().setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static CategorieManager getInstance() {
		if (instance == null)
			instance = new CategorieManager();
		return instance;
	}

	/**
	 * Create the dialog.
	 */
	private CategorieManager() {
		setTitle("Kategorie Manager"); //$NON-NLS-1$
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnNeu = new JButton("Anlegen"); //$NON-NLS-1$
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCategory addCategoryDialog = new AddCategory(true);
				addCategoryDialog.setVisible(true);
			}
		});
		
		JButton btnLschen = new JButton("Löschen"); //$NON-NLS-1$
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(scrollPane, "Möchten Sie die Kategorie wirklich löschen ?", "Bitte bestätigen", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) { //$NON-NLS-1$ //$NON-NLS-2$
					DefaultListModel<String> model = (DefaultListModel<String>)catList.getModel();
					
					String 	selectedCat = catList.getSelectedValue();
					boolean saveDelete 	= true;
										
					for (Receipt receipt : ReceiptList.getInstance()) {
						if (receipt.getCategory().equals(selectedCat)) {
							saveDelete = false;
						}
					}
					
					if (saveDelete) {
						Categories.getInstance().remove(Categories.getInstance().indexOf(selectedCat));
						model.removeElement(selectedCat);
					} else {
						JOptionPane.showMessageDialog(null, "Die Kategorie kann nicht gelÃ¶scht werden, da sie noch in einem Rezept verwendet wird.", "LÃ¶schen nicht mÃ¶glich", JOptionPane.WARNING_MESSAGE);
					}	
					
				}
			}
		});
		
		JLabel lblMens = new JLabel("Kategorien"); //$NON-NLS-1$
		lblMens.setFont(new Font("Calibri", Font.BOLD, 18)); //$NON-NLS-1$
						
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(btnLschen)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNeu))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMens))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)).addContainerGap())
							
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblMens)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNeu)
						.addComponent(btnLschen))
					.addGap(5))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)).addComponent(separator, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)))
		);
		
		DefaultListModel<String> entries = new DefaultListModel<String>();

		for(int i= 2; i < Categories.getInstance().size(); i++){
			entries.addElement(Categories.getInstance().get(i));
		}
		
		catList = new JList<String>(entries);
		catList.setSelectionBackground(new Color(154, 205, 50));
		catList.setSelectedIndex(0);
		
		catList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (listSelectionEvent.getValueIsAdjusting()) {
					if (catList.getSelectedIndex() != -1) {
						//TODO Delete
						System.out.println("Was mache ich eigentlich ?");
					}
				}
			}
		};
		
		catList.addListSelectionListener(listSelectionListener);
		
		scrollPane.setViewportView(catList);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getString("MenuManager.close")); //$NON-NLS-1$
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand(Messages.getString("MenuManager.ok")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public void setKategories(){
		DefaultListModel<String> model = (DefaultListModel<String>)catList.getModel();
		model.clear();
		for(int i = 2; i < Categories.getInstance().size(); i++){
			model.addElement(Categories.getInstance().get(i));
		}
	}
}
