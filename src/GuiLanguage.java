import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GuiLanguage{
	
	protected JPanel panel;
	
	protected JLabel labelID;

	protected JTextField inputID;
	
	protected JTextField inputName;
	
	protected JButton btnAdd;
	
	protected JButton btnUpdate;
	
	protected JButton btnDelete;
	
	protected JButton btnChoose;
	
	protected JButton btnReset;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected String[][] data;
	
	protected BusLanguage bus = new BusLanguage();
	
	GuiLanguage(){
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 495);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		btnAdd = new JButton("ADD");
		btnUpdate = new JButton("UPDATE");
		btnDelete = new JButton("DELETE");
		btnChoose = new JButton("CHOOSE");
		btnReset = new JButton("Reset");
		table = new JTable();
		eventBtnAdd();
		eventBtnDelete();
		eventChoose();
		eventReset();
		eventUpdate();
	}
	
	public void creatMenu(MyFrame frame) {
		frame.panelTop.setBackground(Color.white);
		frame.panelContent.add(frame.interfaceLanguage.panel);
		panel.removeAll();
		panel.setVisible(false);
		gui();
		panel.setVisible(true);
		
	}
	
	public void decoration(JButton btn) {
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,18);
		
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setFont(font);
	
	}
	
	public void gui() {
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		labelID = new JLabel("ID Language");
		labelID.setBounds(150, 10, 100, 30);
		labelID.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		inputID = new JTextField();
		inputID.setEditable(false);
		inputID.setBounds(260, 12, 300, 30);
		
		JLabel lbName = new JLabel("Language");
		lbName.setBounds(150, 60, 120, 30);
		lbName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		inputName = new JTextField();
		inputName.setBounds(260, 60, 300, 30);
		
//		btnAdd,btnUpdate,btnDelete,btnChoose
		
		btnAdd.setBounds(590, 12, 100, 30);
		btnUpdate.setBounds(720, 12, 100, 30);
		
		btnDelete.setBounds(590, 60, 100, 30);
		btnChoose.setBounds(720, 60, 100, 30);
		
		btnReset.setBounds(840, 12, 80, 78);
		
		panel.setLayout(null);
		panel.add(labelID);
		panel.add(inputID);
		panel.add(lbName);
		panel.add(inputName);
		panel.add(btnAdd);
		panel.add(btnUpdate);
		panel.add(btnDelete);
		panel.add(btnChoose);
		panel.add(btnReset);
		
		btnAdd.setForeground(Color.white);
		btnUpdate.setForeground(Color.white);
		btnDelete.setForeground(Color.white);
		btnChoose.setForeground(Color.white);
		btnReset.setForeground(Color.white);
		
		btnAdd.setFocusable(false);
		btnUpdate.setFocusable(false);
		btnDelete.setFocusable(false);
		btnChoose.setFocusable(false);
		btnReset.setFocusable(false);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnUpdate.setBackground(Color.decode("#803ec0"));
		btnDelete.setBackground(Color.decode("#1a89cc"));
		btnChoose.setBackground(Color.decode("#28b928"));
		btnReset.setBackground(Color.decode("#f7941e"));
		
		String colum[] = {"ID Language","Name Language"};
		
		data = bus.takeData();
		
		model = new DefaultTableModel(data,colum);
		
		table.setModel(model);
		
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		table.setTableHeader(header);
		table.setSelectionForeground(Color.white);
		table.setSelectionBackground(Color.decode("#28b928"));
		table.setGridColor(Color.white);
		table.setFocusable(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		tableScroll.setBounds(0, 150, 986, 300);
		
		panel.add(tableScroll);
	}
	
	public void eventBtnAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inputID.getText().equals("") == false) {
					JOptionPane.showMessageDialog(inputName, "ID Language Must Blank");
					return;
				}
				
				if(inputName.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "Name Language Blank");
					return;
				}
				bus.insert(inputName.getText());
				JOptionPane.showMessageDialog(inputName, "ADD Success");
				panel.removeAll();
				panel.setVisible(false);
				gui();
				panel.setVisible(true);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnDelete() {
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOLanguage dao = new DAOLanguage();
				if(inputID.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "ID Language Blank");
					return;
				}
				bus.clear(inputID.getText());
				JOptionPane.showMessageDialog(inputName, "Clear Success");
				panel.removeAll();
				panel.setVisible(false);
				gui();
				panel.setVisible(true);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventChoose() {
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row < 0) return;
				String ID = (String) table.getValueAt(row, 0);
				String name = (String) table.getValueAt(row, 1);
				inputName.setText(name);
				inputID.setText(ID);
			}
		});
	}
	
	public void eventUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputID.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "ID Language Blank");
					return;
				}
				if(inputName.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "Name Language Blank");
					return;
				}
				bus.update(inputID.getText(), inputName.getText());
				JOptionPane.showMessageDialog(inputName, "Update Success");
				panel.removeAll();
				panel.setVisible(false);
				gui();
				panel.setVisible(true);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventReset() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputName.setText("");
				inputID.setText("");
			}
		});
	}
	

	
	
}