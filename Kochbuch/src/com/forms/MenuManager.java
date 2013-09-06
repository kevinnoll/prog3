package com.forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

public class MenuManager extends JDialog {

	private static MenuManager instance;
	private final JPanel contentPanel = new JPanel();

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
		panel_2.setLayout(new MigLayout("", "[][][100px,grow][100px:100px:100px,grow]", "[grow][][][][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new MigLayout("", "[][][100px,grow][100px:100px:100px,grow]", "[grow][][][][]"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(new MigLayout("", "[][][grow][100px:100px:100px,grow]", "[grow][][][][]"));
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
		panel.add(scrollPane_3, "cell 2 0 1 5,alignx right,growy");
		
		JList list_3 = new JList();
		scrollPane_3.setViewportView(list_3);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 3 0 1 5");
		
		JLabel label_29 = new JLabel("New label");
		panel_3.add(label_29);
		
		JLabel label_21 = new JLabel("Titel:");
		panel.add(label_21, "cell 0 1");
		
		JLabel lblVorspeiseTitel = new JLabel("asd");
		panel.add(lblVorspeiseTitel, "cell 1 1");
		
		JLabel label_22 = new JLabel("Schwierigkeit:");
		panel.add(label_22, "cell 0 2");
		
		JLabel lblVorspeiseDiff = new JLabel("New label");
		panel.add(lblVorspeiseDiff, "cell 1 2");
		
		JLabel label_23 = new JLabel("Dauer:");
		panel.add(label_23, "cell 0 3");
		
		JLabel lblVorspeiseDur = new JLabel("New label");
		panel.add(lblVorspeiseDur, "cell 1 3");
		
		JLabel label_24 = new JLabel("Kategorie:");
		panel.add(label_24, "cell 0 4");
		
		JLabel lblVorspeiseCat = new JLabel("New label");
		panel.add(lblVorspeiseCat, "cell 1 4");
		
		JLabel label_10 = new JLabel("Hauptgang");
		panel_1.add(label_10, "cell 0 0");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 0 1 5,alignx right");
		
		JList list_2 = new JList();
		scrollPane_1.setViewportView(list_2);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "cell 3 0 1 5");
		
		JLabel label_19 = new JLabel("New label");
		panel_4.add(label_19);
		
		JLabel label_11 = new JLabel("Titel:");
		panel_1.add(label_11, "cell 0 1");
		
		JLabel lblMainTitle = new JLabel("New label");
		panel_1.add(lblMainTitle, "cell 1 1");
		
		JLabel label_12 = new JLabel("Schwierigkeit:");
		panel_1.add(label_12, "cell 0 2");
		
		JLabel lblMainDiff = new JLabel("New label");
		panel_1.add(lblMainDiff, "cell 1 2");
		
		JLabel label_13 = new JLabel("Dauer:");
		panel_1.add(label_13, "cell 0 3");
		
		JLabel lblMainDur = new JLabel("New label");
		panel_1.add(lblMainDur, "cell 1 3");
		
		JLabel label_14 = new JLabel("Kategorie:");
		panel_1.add(label_14, "cell 0 4");
		
		JLabel lblMainCat = new JLabel("New label");
		panel_1.add(lblMainCat, "cell 1 4");
		
		JLabel lblDessert = new JLabel("Dessert");
		panel_2.add(lblDessert, "cell 0 0");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, "cell 2 0 1 5,alignx right");
		
		JList list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 3 0 1 5");
		
		JLabel label_9 = new JLabel("New label");
		panel_5.add(label_9);
		
		JLabel label_1 = new JLabel("Titel:");
		panel_2.add(label_1, "cell 0 1");
		
		JLabel lblDessertTitle = new JLabel("New label");
		panel_2.add(lblDessertTitle, "cell 1 1");
		
		JLabel label_2 = new JLabel("Schwierigkeit:");
		panel_2.add(label_2, "cell 0 2");
		
		JLabel lblDessertDiff = new JLabel("New label");
		panel_2.add(lblDessertDiff, "cell 1 2");
		
		JLabel label_3 = new JLabel("Dauer:");
		panel_2.add(label_3, "cell 0 3");
		
		JLabel lblDessertDur = new JLabel("New label");
		panel_2.add(lblDessertDur, "cell 1 3");
		
		JLabel label_4 = new JLabel("Kategorie:");
		panel_2.add(label_4, "cell 0 4");
		
		JLabel lblDessertCat = new JLabel("New label");
		panel_2.add(lblDessertCat, "cell 1 4");
		
		JList list = new JList();
		scrollPane.setViewportView(list);
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
}
