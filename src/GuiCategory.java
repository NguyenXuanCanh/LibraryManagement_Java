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

public class GuiCategory{
	
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
	
	protected BusCategory bus;
	
	GuiCategory(){
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
		bus = new BusCategory();
		eventBtnAdd();
		eventBtnDelete();
		eventChoose();
		eventReset();
		eventUpdate();
	}
	
	public void creatMenu(MyFrame frame) {
		frame.panelContent.add(frame.interfaceCategory.panel);
		frame.panelTop.setBackground(Color.white);
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
		labelID = new JLabel("ID Category");
		labelID.setBounds(150, 30, 100, 30);
		labelID.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		inputID = new JTextField();
		inputID.setEditable(false);
		inputID.setBounds(260, 32, 300, 30);
		
		JLabel lbName = new JLabel("Category");
		lbName.setBounds(150, 80, 120, 30);
		lbName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		inputName = new JTextField();
		inputName.setBounds(260, 80, 300, 30);
		
//		btnAdd,btnUpdate,btnDelete,btnChoose
		
		btnAdd.setBounds(590, 30, 100, 30);
		btnUpdate.setBounds(720, 30, 100, 30);
		
		btnDelete.setBounds(590, 80, 100, 30);
		btnChoose.setBounds(720, 80, 100, 30);
		
		btnReset.setBounds(840, 32, 80, 78);
		
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
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnUpdate.setBackground(Color.decode("#803ec0"));
		btnDelete.setBackground(Color.decode("#1a89cc"));
		btnChoose.setBackground(Color.decode("#f1c708"));
		btnReset.setBackground(Color.decode("#f7941e"));
		
		btnReset.setFocusable(false);
		btnAdd.setFocusable(false);
		btnUpdate.setFocusable(false);
		btnDelete.setFocusable(false);
		btnChoose.setFocusable(false);
		
		
		String colum[] = {"ID Category","Name Category","Date Create"};
		
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
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		tableScroll.setBounds(0, 150, 986, 300);
		
		panel.add(tableScroll);
	}
	
	public void eventBtnAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inputID.getText().equals("") == false) {
					JOptionPane.showMessageDialog(inputName, "ID Category Must Blank");
					return;
				}
				
				if(inputName.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "Name Category Blank");
					return;
				}
				bus.insert(inputName.getText());
				JOptionPane.showMessageDialog(inputName, "ADD Success");
				inputName.setText("");
				inputID.setText("");
				String colum[] = {"ID Category","Name Category","Date Create"};
				data = bus.takeData();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnDelete() {
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputID.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "ID Category Blank");
					return;
				}
				bus.clear(inputID.getText());
				JOptionPane.showMessageDialog(inputName, "Clear Success");
				inputName.setText("");
				inputID.setText("");
				String colum[] = {"ID Category","Name Category","Date Create"};
				data = bus.takeData();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
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
					JOptionPane.showMessageDialog(inputName, "ID Category Blank");
					return;
				}
				if(inputName.getText().equals("") == true) {
					JOptionPane.showMessageDialog(inputName, "Name Category Blank");
					return;
				}
				bus.update(inputID.getText(), inputName.getText());
				JOptionPane.showMessageDialog(inputName, "Update Success");
				inputName.setText("");
				inputID.setText("");
				String colum[] = {"ID Category","Name Category","Date Create"};
				data = bus.takeData();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
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