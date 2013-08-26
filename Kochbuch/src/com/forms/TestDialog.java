package com.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class TestDialog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestDialog frame = new TestDialog();
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
	public TestDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("179px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("134px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("275px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JLabel lblTitel = new JLabel("Titel");
		contentPane.add(lblTitel, "2, 2, right, center");
		
		textField = new JTextField();
		contentPane.add(textField, "4, 2, 3, 1, fill, top");
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "4, 4, fill, center");
		
		JButton button = new JButton("+");
		contentPane.add(button, "6, 4, fill, top");
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "2, 6, fill, center");
		
		JList list = new JList();
		contentPane.add(list, "4, 6, fill, fill");
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2, "2, 8, left, top");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "4, 8, fill, center");
		textField_1.setColumns(10);
	}

}
