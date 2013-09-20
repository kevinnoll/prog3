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

	public static MenuManager getInstance() {
		if (instance == null)
			instance = new MenuManager();
		return instance;
	}

	/**
	 * Create the dialog.
	 */
	private MenuManager() {
		setTitle(Messages.getString("MenuManager.manage_menus")); //$NON-NLS-1$
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 917, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnNeu = new JButton(Messages.getString("MenuManager.new")); //$NON-NLS-1$
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCreator menuCreator = new MenuCreator();
				menuCreator.setVisible(true);
			}
		});
		
		JButton btnLschen = new JButton(Messages.getString("MenuManager.delete")); //$NON-NLS-1$
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(scrollPane, Messages.getString("MenuManager.confirm_delete"), Messages.getString("MenuManager.please_confirm"), JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) { //$NON-NLS-1$ //$NON-NLS-2$
					DefaultListModel<Menu> model = (DefaultListModel<Menu>)menuList.getModel();
					MenuList.getInstance().remove(menuList.getSelectedValue());
					model.removeElement(menuList.getSelectedValue());
				}
			}
		});
		
		JLabel lblMens = new JLabel(Messages.getString("MenuManager.menus")); //$NON-NLS-1$
		lblMens.setFont(new Font("Calibri", Font.BOLD, 18)); //$NON-NLS-1$
		
		JButton btnBearbeiten = new JButton(Messages.getString("MenuManager.edit")); //$NON-NLS-1$
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCreator menuCreator = new MenuCreator(menuList.getSelectedValue());
				menuCreator.setVisible(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(new MigLayout("", "[][150px:150px:150px][250px:250px:250px,grow][110px:110px:110px,grow]", "[grow][][][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
		
		JLabel lblVorspeise = new JLabel(Messages.getString("MenuManager.starter")); //$NON-NLS-1$
		lblVorspeise.setFont(new Font("Calibri", Font.BOLD, 18)); //$NON-NLS-1$
		panel.add(lblVorspeise, "cell 0 0"); //$NON-NLS-1$
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3, "cell 2 0 1 5,grow"); //$NON-NLS-1$
		
		starterList = new JList<Ingredient>();
		scrollPane_3.setViewportView(starterList);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 3 0 1 5"); //$NON-NLS-1$
		
		lblStarterImage = new JLabel(""); //$NON-NLS-1$
		panel_3.add(lblStarterImage);
		
		JLabel label_21 = new JLabel(Messages.getString("MenuManager.title")); //$NON-NLS-1$
		panel.add(label_21, "cell 0 1"); //$NON-NLS-1$
		
		lblVorspeiseTitle = new JLabel(""); //$NON-NLS-1$
		panel.add(lblVorspeiseTitle, "cell 1 1"); //$NON-NLS-1$
		
		JLabel label_22 = new JLabel(Messages.getString("MenuManager.difficultly_level")); //$NON-NLS-1$
		panel.add(label_22, "cell 0 2"); //$NON-NLS-1$
		
		lblVorspeiseDiff = new JLabel(""); //$NON-NLS-1$
		panel.add(lblVorspeiseDiff, "cell 1 2"); //$NON-NLS-1$
		
		JLabel label_23 = new JLabel(Messages.getString("MenuManager.duration")); //$NON-NLS-1$
		panel.add(label_23, "cell 0 3"); //$NON-NLS-1$
		
		lblVorspeiseDur = new JLabel(""); //$NON-NLS-1$
		panel.add(lblVorspeiseDur, "cell 1 3"); //$NON-NLS-1$
		
		JLabel label_24 = new JLabel(Messages.getString("MenuManager.kategory")); //$NON-NLS-1$
		panel.add(label_24, "cell 0 4"); //$NON-NLS-1$
		
		lblVorspeiseCat = new JLabel(""); //$NON-NLS-1$
		panel.add(lblVorspeiseCat, "cell 1 4"); //$NON-NLS-1$
		
		JLabel labelMain = new JLabel(Messages.getString("MenuManager.main_course")); //$NON-NLS-1$
		labelMain.setFont(new Font("Calibri", Font.BOLD, 18)); //$NON-NLS-1$
		panel_1.add(labelMain, "cell 0 0"); //$NON-NLS-1$
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 0 1 5,grow"); //$NON-NLS-1$
		
		mainList = new JList<Ingredient>();
		scrollPane_1.setViewportView(mainList);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "cell 3 0 1 5"); //$NON-NLS-1$
		
		lblMainImage = new JLabel(""); //$NON-NLS-1$
		panel_4.add(lblMainImage);
		
		JLabel label_11 = new JLabel(Messages.getString("MenuManager.title")); //$NON-NLS-1$
		panel_1.add(label_11, "cell 0 1"); //$NON-NLS-1$
		
		lblMainTitle = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblMainTitle, "cell 1 1"); //$NON-NLS-1$
		
		JLabel label_12 = new JLabel(Messages.getString("MenuManager.difficultly_leve")); //$NON-NLS-1$
		panel_1.add(label_12, "cell 0 2"); //$NON-NLS-1$
		
		lblMainDiff = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblMainDiff, "cell 1 2"); //$NON-NLS-1$
		
		JLabel label_13 = new JLabel(Messages.getString("MenuManager.duration")); //$NON-NLS-1$
		panel_1.add(label_13, "cell 0 3"); //$NON-NLS-1$
		
		lblMainDur = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblMainDur, "cell 1 3"); //$NON-NLS-1$
		
		JLabel label_14 = new JLabel(Messages.getString("MenuManager.kategory")); //$NON-NLS-1$
		panel_1.add(label_14, "cell 0 4"); //$NON-NLS-1$
		
		lblMainCat = new JLabel(""); //$NON-NLS-1$
		panel_1.add(lblMainCat, "cell 1 4"); //$NON-NLS-1$
		
		JLabel lblDessert = new JLabel(Messages.getString("MenuManager.dessert")); //$NON-NLS-1$
		lblDessert.setFont(new Font("Calibri", Font.BOLD, 18)); //$NON-NLS-1$
		panel_2.add(lblDessert, "cell 0 0"); //$NON-NLS-1$
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, "cell 2 0 1 5,grow"); //$NON-NLS-1$
		
		dessertList = new JList<Ingredient>();
		scrollPane_2.setViewportView(dessertList);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 3 0 1 5"); //$NON-NLS-1$
		
		lblDessertImage = new JLabel(""); //$NON-NLS-1$
		panel_5.add(lblDessertImage);
		
		JLabel label_1 = new JLabel(Messages.getString("MenuManager.title")); //$NON-NLS-1$
		panel_2.add(label_1, "cell 0 1"); //$NON-NLS-1$
		
		lblDessertTitle = new JLabel(""); //$NON-NLS-1$
		panel_2.add(lblDessertTitle, "cell 1 1"); //$NON-NLS-1$
		
		JLabel label_2 = new JLabel(Messages.getString("MenuManager.difficultly_level")); //$NON-NLS-1$
		panel_2.add(label_2, "cell 0 2"); //$NON-NLS-1$
		
		lblDessertDiff = new JLabel(""); //$NON-NLS-1$
		panel_2.add(lblDessertDiff, "cell 1 2"); //$NON-NLS-1$
		
		JLabel label_3 = new JLabel(Messages.getString("MenuManager.duration")); //$NON-NLS-1$
		panel_2.add(label_3, "cell 0 3"); //$NON-NLS-1$
		
		lblDessertDur = new JLabel(""); //$NON-NLS-1$
		panel_2.add(lblDessertDur, "cell 1 3"); //$NON-NLS-1$
		
		JLabel label_4 = new JLabel(Messages.getString("MenuManager.kategorie")); //$NON-NLS-1$
		panel_2.add(label_4, "cell 0 4"); //$NON-NLS-1$
		
		lblDessertCat = new JLabel(""); //$NON-NLS-1$
		panel_2.add(lblDessertCat, "cell 1 4"); //$NON-NLS-1$
		
		//Menu menu = new Menu(0, "erstes Menu",	ReceiptList.getInstance().get(1),ReceiptList.getInstance().get(0),ReceiptList.getInstance().get(2));
		//MenuList.getInstance().add(menu);
		DefaultListModel<Menu> entries = new DefaultListModel<Menu>();
//		entries.addElement(menu);
		for(int i= 0; i < MenuList.getInstance().size(); i++){
			entries.addElement(MenuList.getInstance().get(i));
		}
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
	
	private void fillRightPanel(Menu selectedMenu) {
		
		if (selectedMenu != null) {
			setStarter(selectedMenu.getStarter());
			setMain(selectedMenu.getMain());
			setDessert(selectedMenu.getDessert());
		}		
		
	}

	private void setDessert(Receipt dessert) {
		lblDessertTitle.setText(dessert.getName());
		lblDessertDiff.setText(dessert.getDifficulty().toString());
		lblDessertDur.setText(dessert.getDuration() + Messages.getString("MenuManager.min")); //$NON-NLS-1$
		lblDessertCat.setText(dessert.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < dessert.getIngredients().size(); i++){
			listModel.addElement(dessert.getIngredients().get(i));
		}
		dessertList.setModel(listModel);
		lblDessertImage.setIcon(dessert.getIcon_big());
		lblDessertImage.setText(""); //$NON-NLS-1$
	}

	private void setMain(Receipt main) {
		lblMainTitle.setText(main.getName());
		lblMainDiff.setText(main.getDifficulty().toString());
		lblMainDur.setText(main.getDuration() + Messages.getString("MenuManager.min")); //$NON-NLS-1$
		lblMainCat.setText(main.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < main.getIngredients().size(); i++){
			listModel.addElement(main.getIngredients().get(i));
		}
		mainList.setModel(listModel);
		lblMainImage.setIcon(main.getIcon_big());
		lblMainImage.setText(""); //$NON-NLS-1$
	}

	private void setStarter(Receipt starter) {
		lblVorspeiseTitle.setText(starter.getName());
		lblVorspeiseDiff.setText(starter.getDifficulty().toString());
		lblVorspeiseDur.setText(starter.getDuration()+ Messages.getString("MenuManager.min")); //$NON-NLS-1$
		lblVorspeiseCat.setText(starter.getCategory());
		DefaultListModel<Ingredient> listModel = new DefaultListModel<Ingredient>();
		for(int i = 0; i < starter.getIngredients().size(); i++){
			listModel.addElement(starter.getIngredients().get(i));
		}
		starterList.setModel(listModel);
		lblStarterImage.setIcon(starter.getIcon_big());
		lblStarterImage.setText(""); //$NON-NLS-1$
	}
	
	public void setMenus(){
		DefaultListModel<Menu> model = (DefaultListModel<Menu>)menuList.getModel();
		model.clear();
		for(int i = 0; i < MenuList.getInstance().size(); i++){
			model.addElement(MenuList.getInstance().get(i));
		}
	}
}
