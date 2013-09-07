package com.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
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
import com.receipt.Ingredient;
import com.receipt.Receipt;
import com.receipt.ReceiptList;

public class MenuManager extends JDialog {

	private static MenuManager instance;
	private final JPanel contentPanel = new JPanel();
	private JList<Menu> menuList;
	private JLabel lblDessertCat;
	private JLabel lblDessertDiff;
	private JLabel lblDessertDur;
	private JLabel lblDessertTitle;
	private JLabel lblMainCat;
	private JLabel lblMainDiff;
	private JLabel lblMainDur;
	private JLabel lblMainTitle;
	private JLabel lblVorspeiseCat;
	private JLabel lblVorspeiseDiff;
	private JLabel lblVorspeiseDur;
	private JLabel lblVorspeiseTitle;
	private JList<Ingredient> dessertList;
	private JList<Ingredient> mainList;
	private JList<Ingredient> starterList;
	private JLabel lblStarterImage;
	private JLabel lblMainImage;
	private JLabel lblDessertImage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuManager.getInstance().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MenuManager getInstance() {
		if (instance == null)
			instance = new MenuManager();
		return instance;
	}

	/**
	 * Create the dialog.
	 */
	public MenuManager() {
		setTitle("Men\u00FCs verwalten");
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 917, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnNeu = new JButton("Neu");
		
		JButton btnLschen = new JButton("L\u00F6schen");
		
		JLabel lblMens = new JLabel("Men\u00FCs");
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]"));
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
								.addComponent(btnBearbeiten)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNeu))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMens))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
					.addContainerGap())
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
						.addComponent(btnLschen)
						.addComponent(btnBearbeiten))
					.addGap(5))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)))
		);
		
		JLabel lblVorspeise = new JLabel("Vorspeise");
		panel.add(lblVorspeise, "cell 0 0");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3, "cell 2 0 1 5,grow");
		
		starterList = new JList<Ingredient>();
		scrollPane_3.setViewportView(starterList);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 3 0 1 5");
		
		lblStarterImage = new JLabel("New label");
		panel_3.add(lblStarterImage);
		
		JLabel label_21 = new JLabel("Titel:");
		panel.add(label_21, "cell 0 1");
		
		lblVorspeiseTitle = new JLabel("asd");
		panel.add(lblVorspeiseTitle, "cell 1 1");
		
		JLabel label_22 = new JLabel("Schwierigkeit:");
		panel.add(label_22, "cell 0 2");
		
		lblVorspeiseDiff = new JLabel("New label");
		panel.add(lblVorspeiseDiff, "cell 1 2");
		
		JLabel label_23 = new JLabel("Dauer:");
		panel.add(label_23, "cell 0 3");
		
		lblVorspeiseDur = new JLabel("New label");
		panel.add(lblVorspeiseDur, "cell 1 3");
		
		JLabel label_24 = new JLabel("Kategorie:");
		panel.add(label_24, "cell 0 4");
		
		lblVorspeiseCat = new JLabel("New label");
		panel.add(lblVorspeiseCat, "cell 1 4");
		
		JLabel label_10 = new JLabel("Hauptgang");
		panel_1.add(label_10, "cell 0 0");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 0 1 5,grow");
		
		mainList = new JList<Ingredient>();
		scrollPane_1.setViewportView(mainList);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "cell 3 0 1 5");
		
		lblMainImage = new JLabel("New label");
		panel_4.add(lblMainImage);
		
		JLabel label_11 = new JLabel("Titel:");
		panel_1.add(label_11, "cell 0 1");
		
		lblMainTitle = new JLabel("New label");
		panel_1.add(lblMainTitle, "cell 1 1");
		
		JLabel label_12 = new JLabel("Schwierigkeit:");
		panel_1.add(label_12, "cell 0 2");
		
		lblMainDiff = new JLabel("New label");
		panel_1.add(lblMainDiff, "cell 1 2");
		
		JLabel label_13 = new JLabel("Dauer:");
		panel_1.add(label_13, "cell 0 3");
		
		lblMainDur = new JLabel("New label");
		panel_1.add(lblMainDur, "cell 1 3");
		
		JLabel label_14 = new JLabel("Kategorie:");
		panel_1.add(label_14, "cell 0 4");
		
		lblMainCat = new JLabel("New label");
		panel_1.add(lblMainCat, "cell 1 4");
		
		JLabel lblDessert = new JLabel("Dessert");
		panel_2.add(lblDessert, "cell 0 0");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, "cell 2 0 1 5,grow");
		
		dessertList = new JList<Ingredient>();
		scrollPane_2.setViewportView(dessertList);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 3 0 1 5");
		
		lblDessertImage = new JLabel("New label");
		panel_5.add(lblDessertImage);
		
		JLabel label_1 = new JLabel("Titel:");
		panel_2.add(label_1, "cell 0 1");
		
		lblDessertTitle = new JLabel("New label");
		panel_2.add(lblDessertTitle, "cell 1 1");
		
		JLabel label_2 = new JLabel("Schwierigkeit:");
		panel_2.add(label_2, "cell 0 2");
		
		lblDessertDiff = new JLabel("New label");
		panel_2.add(lblDessertDiff, "cell 1 2");
		
		JLabel label_3 = new JLabel("Dauer:");
		panel_2.add(label_3, "cell 0 3");
		
		lblDessertDur = new JLabel("New label");
		panel_2.add(lblDessertDur, "cell 1 3");
		
		JLabel label_4 = new JLabel("Kategorie:");
		panel_2.add(label_4, "cell 0 4");
		
		lblDessertCat = new JLabel("New label");
		panel_2.add(lblDessertCat, "cell 1 4");
		
		Menu menu = new Menu("erstes Menu",	ReceiptList.getInstance().get(1),ReceiptList.getInstance().get(0),ReceiptList.getInstance().get(2));
		DefaultListModel<Menu> entries = new DefaultListModel<Menu>();
		entries.addElement(menu);
		menuList = new JList<Menu>(entries);
		menuList.setSelectionBackground(new Color(154, 205, 50));
		menuList.setSelectedIndex(0);
		fillRightPanel(menuList.getSelectedValue());
		menuList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (listSelectionEvent.getValueIsAdjusting()) {
					if (menuList.getSelectedIndex() != -1) {
						fillRightPanel(menuList.getSelectedValue());
					}
				}
			}
		};
		menuList.addListSelectionListener(listSelectionListener);
		
		scrollPane.setViewportView(menuList);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void fillRightPanel(Menu selectedMenu) {
		setStarter(selectedMenu.getStarter());
		setMain(selectedMenu.getMain());
		setDessert(selectedMenu.getDessert());
	}

	private void setDessert(Receipt dessert) {
		lblDessertTitle.setText(dessert.getName());
		lblDessertDiff.setText(dessert.getDifficulty().toString());
		lblDessertDur.setText(dessert.getDuration() + " min");
		lblDessertCat.setText(dessert.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < dessert.getIngredients().size(); i++){
			listModel.addElement(dessert.getIngredients().get(i));
		}
		dessertList.setModel(listModel);
		lblDessertImage.setIcon(dessert.getIcon_big());
		lblDessertImage.setText("");
	}

	private void setMain(Receipt main) {
		lblMainTitle.setText(main.getName());
		lblMainDiff.setText(main.getDifficulty().toString());
		lblMainDur.setText(main.getDuration() + " min");
		lblMainCat.setText(main.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < main.getIngredients().size(); i++){
			listModel.addElement(main.getIngredients().get(i));
		}
		mainList.setModel(listModel);
		lblMainImage.setIcon(main.getIcon_big());
		lblMainImage.setText("");
	}

	private void setStarter(Receipt starter) {
		lblVorspeiseTitle.setText(starter.getName());
		lblVorspeiseDiff.setText(starter.getDifficulty().toString());
		lblVorspeiseDur.setText(starter.getDuration()+ " min");
		lblVorspeiseCat.setText(starter.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < starter.getIngredients().size(); i++){
			listModel.addElement(starter.getIngredients().get(i));
		}
		starterList.setModel(listModel);
		lblStarterImage.setIcon(starter.getIcon_big());
		lblStarterImage.setText("");
	}
}
