package com.forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.menu.Menu;
import com.menu.MenuList;
import com.receipt.Course;
import com.receipt.Receipt;
import com.receipt.ReceiptList;

public class MenuCreator extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox<Receipt> comboBoxMain;
	private JComboBox<Receipt> comboBoxDessert;
	private JComboBox<Receipt> comboBoxStarter;
	private static int iD = 1;
	private boolean newMenu = true;
	private int idToChange;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			MenuCreator dialog = new MenuCreator();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public MenuCreator(Menu menu) {
		this();
		textField.setText(menu.getName());
		comboBoxStarter.setSelectedItem(menu.getStarter());
		comboBoxMain.setSelectedItem(menu.getMain());
		comboBoxDessert.setSelectedItem(menu.getDessert());
		newMenu = false;
		idToChange = menu.getiD();
	}

	/**
	 * Create the dialog.
	 */
	public MenuCreator() {
		setTitle("Men\u00FC erstellen");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 364, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblName = new JLabel("Name:");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblVorspeise = new JLabel("Vorspeise:");

		comboBoxStarter = new JComboBox<Receipt>();
		for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
			if (ReceiptList.getInstance().get(i).getCourse().equals(Course.Vorspeise)) {
				comboBoxStarter.addItem(ReceiptList.getInstance().get(i));
			}
		}

		JLabel lblHauptgericht = new JLabel("Hauptgericht:");

		comboBoxMain = new JComboBox<Receipt>();
		for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
			if (ReceiptList.getInstance().get(i).getCourse().equals(Course.Hauptgericht)) {
				comboBoxMain.addItem(ReceiptList.getInstance().get(i));
			}
		}

		JLabel lblDessert = new JLabel("Dessert:");

		comboBoxDessert = new JComboBox<Receipt>();
		for (int i = 0; i < ReceiptList.getInstance().size(); i++) {
			if (ReceiptList.getInstance().get(i).getCourse().equals(Course.Dessert)) {
				comboBoxDessert.addItem(ReceiptList.getInstance().get(i));
			}
		}

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addGap(18)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblName).addComponent(lblVorspeise)
										.addComponent(lblHauptgericht).addComponent(lblDessert))
						.addGap(33)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBoxDessert, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxMain, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxStarter, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)).addContainerGap(20, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addGap(27)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblVorspeise)
										.addComponent(comboBoxStarter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblHauptgericht)
										.addComponent(comboBoxMain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblDessert)
										.addComponent(comboBoxDessert, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(183, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Hinzuf\u00FCgen");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (newMenu) {
							Menu menu = new Menu(iD, textField.getText(), (Receipt) comboBoxStarter.getSelectedItem(),
									(Receipt) comboBoxMain.getSelectedItem(), (Receipt) comboBoxDessert.getSelectedItem());
							iD++;
							MenuList.getInstance().add(menu);
						} else {
							Menu menu = new Menu(idToChange,textField.getText(), (Receipt) comboBoxStarter.getSelectedItem(),
									(Receipt) comboBoxMain.getSelectedItem(), (Receipt) comboBoxDessert.getSelectedItem());
							for(int i = 0; i < MenuList.getInstance().size();i++){
								if(MenuList.getInstance().get(i).getiD() == idToChange){
									MenuList.getInstance().set(i, menu);
								}
							}
						}
						MenuManager.getInstance().setMenus();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Verwerfen");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
