import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPunish{
	
	protected JPanel panel;
	
	protected JPanel north;
	
	protected JPanel center;
	
	protected JPanel centerL1;
	
	protected JPanel centerL2;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JTextField inputID;
	
	protected JTextField inputName;
	
	protected JTextField inputMoney;
	
	protected JTextField inputFind;
	
	protected JButton btnFindID;
	
	protected JButton btnFindName;
	
	protected JComboBox status;
	
	protected JButton btnAdd;
	
	protected JButton btnDelete;
	
	protected JButton btnUpdate;
	
	protected JButton btnChoose;
	
	protected JButton btnReset;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected String[][] data;
	
	protected BusPunish bus = new BusPunish();
	
	GuiPunish(){
		boot();
	}
	
	public void boot() {
		
		table = new JTable();
		
		inputFind = new JTextField();
		
		btnFindID = new JButton("Follow ID");
		
		btnFindName = new JButton("Follow Name");
		
		panel = new JPanel();
		
		north = new JPanel();
		
		center= new JPanel();
		
		northL1 = new JPanel();
		
		northL2 = new JPanel();
		
		centerL1 = new JPanel();
		
		centerL2 = new JPanel();
		
		inputID = new JTextField();
		
		inputName = new JTextField();
		
		inputMoney = new JTextField();
		
		status = new JComboBox();
		
		btnAdd = new JButton("ADD");
		
		btnDelete = new JButton("Delete");
		
		btnUpdate = new JButton("Update");
		
		btnChoose = new JButton("Choose");
		
		btnReset = new JButton("Reset");
		
		eventBtn();
	}
	
	public void createMenu(MyFrame frame) {
		frame.panelContent.removeAll();
		frame.panelContent.add(panel);
		frame.panelTop.setBackground(Color.white);
		panel.removeAll();
		panel.setVisible(false);
		gui();
		panel.setVisible(true);
	}
	
	public void gui() {
		
		panel.removeAll();
		center.removeAll();
		north.removeAll();
		northL1.removeAll();
		northL2.removeAll();
		centerL1.removeAll();
		centerL2.removeAll();
		
		
		panel.setBounds(0, 0, 980, 500);
		panel.setBackground(Color.white);
		
		center.setBackground(Color.white);
		northL1.setBackground(Color.white);
		northL2.setBackground(Color.white);
		centerL1.setBackground(Color.white);
		centerL2.setBackground(Color.white);
		
		panel.setLayout(new BorderLayout());
		north.setPreferredSize(new Dimension(980,120));
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		JLabel lbID = new JLabel("ID Punish");
		lbID.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		JLabel lbName = new JLabel("Punish");
		lbName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		JLabel lbMoney = new JLabel("Money");
		lbMoney.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		JLabel lbStatus = new JLabel("Status");
		lbStatus.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		lbID.setPreferredSize(new Dimension(70, 25));
		lbName.setPreferredSize(new Dimension(50, 25));
		lbMoney.setPreferredSize(new Dimension(70, 25));
		lbStatus.setPreferredSize(new Dimension(50, 25));
		
		String combobox[] = {"Punish Using","Punish Not Using"};
		status = new JComboBox(combobox);
		
		status.setBackground(Color.white);
		status.setFocusable(false);
		status.setBorder(null);
		
		inputID.setEditable(false);
		inputID.setPreferredSize(new Dimension(200, 25));
		inputName.setPreferredSize(new Dimension(200, 25));
		inputMoney.setPreferredSize(new Dimension(200, 25));
		status.setPreferredSize(new Dimension(200, 25));
		
		
		btnAdd.setPreferredSize(new Dimension(100, 25));
		btnDelete.setPreferredSize(new Dimension(100, 25));
		
		btnUpdate.setPreferredSize(new Dimension(100, 25));
		btnReset.setPreferredSize(new Dimension(100, 25));
		
		
		north.setLayout(new GridLayout(2,1));
		north.add(northL1);
		north.add(northL2);
		
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER,12,20));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER,12,5));
		
		northL1.add(lbID);
		northL1.add(inputID);
		northL1.add(lbName);
		northL1.add(inputName);
		northL1.add(btnAdd);
		northL1.add(btnDelete);
		
		northL2.add(lbMoney);
		northL2.add(inputMoney);
		northL2.add(lbStatus);
		northL2.add(status);
		northL2.add(btnUpdate);
		northL2.add(btnReset);
		
		center.setLayout(new BorderLayout());
		
		centerL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		centerL1.setPreferredSize(new Dimension(986, 60));
		
		centerL2.setLayout(new BorderLayout());
		
		centerL1.setBackground(Color.white);
		
		center.add(centerL1,BorderLayout.NORTH);
		center.add(centerL2,BorderLayout.CENTER);
		
		JLabel lbFind = new JLabel("Find Punish");
		lbFind.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		inputFind.setPreferredSize(new Dimension(300, 30));
		
		btnFindID.setPreferredSize(new Dimension(120, 30));
		btnFindName.setPreferredSize(new Dimension(120, 30));
		btnChoose.setPreferredSize(new Dimension(120, 30));
		
		centerL1.add(lbFind);
		centerL1.add(inputFind);
		centerL1.add(btnFindID);
		centerL1.add(btnFindName);
		centerL1.add(btnChoose);
		
		btnAdd.setForeground(Color.white);
		btnDelete.setForeground(Color.white);
		btnUpdate.setForeground(Color.white);
		btnReset.setForeground(Color.white);
		btnFindID.setForeground(Color.white);
		btnFindName.setForeground(Color.white);
		btnChoose.setForeground(Color.white);
		
		btnAdd.setFocusable(false);
		btnDelete.setFocusable(false);
		btnUpdate.setFocusable(false);
		btnReset.setFocusable(false);
		btnFindID.setFocusable(false);
		btnFindName.setFocusable(false);
		btnChoose.setFocusable(false);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnDelete.setBackground(Color.decode("#1a89cc"));
		btnUpdate.setBackground(Color.decode("#803ec0"));
		btnReset.setBackground(Color.decode("#f7941e"));
		btnFindID.setBackground(Color.decode("#ff0000"));
		btnFindName.setBackground(Color.decode("#1a89cc"));
		btnChoose.setBackground(Color.decode("#803ec0"));
		
		String colum[] = {"ID","Name Punish","Money","Status","Date Create"};
		
		data = bus.loadAllPunish();
		model = new DefaultTableModel(data,colum);
		table.setModel(model);
		
		table.setRowHeight(25);
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
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		centerL2.add(tableScroll,BorderLayout.CENTER);
	}
	
	public void eventBtnChoose() {
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lbMoney = new JLabel("Money");
				lbMoney.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

				JLabel lbStatus = new JLabel("Status");
				lbStatus.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
				
				lbMoney.setPreferredSize(new Dimension(70, 25));
				lbStatus.setPreferredSize(new Dimension(50, 25));
				
				int row = table.getSelectedRow();
				if(row < 0) return;
				
				inputID.setText((String) table.getValueAt(row, 0));
				inputName.setText((String) table.getValueAt(row, 1));
				inputMoney.setText((String) table.getValueAt(row, 2));
				String statusP = (String) table.getValueAt(row, 3);
				status.setSelectedItem(statusP);
			}
		});
	}
	
	public void eventBtnAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputID.getText();
				String name = inputName.getText();
				String money = inputMoney.getText();
				String statusChoose = (String) status.getItemAt(status.getSelectedIndex());
				if(ID.equals("") == false) {
					JOptionPane.showMessageDialog(inputID, "ID Must Blank,Click Reset");
					return;
				}
				if(name.equals("") == true) {
					JOptionPane.showMessageDialog(inputID, "Name Punish Blank,Input Name Punish");
					return;
				}
				
				if(bus.checkMoney(money) == false) {
					JOptionPane.showMessageDialog(inputID,"Value money not valud");
					return;
				}
				bus.insert(name, money, statusChoose);
				JOptionPane.showMessageDialog(inputID,"Add Success");
				inputID.setText("");
				inputName.setText("");
				inputMoney.setText("");
				String colum[] = {"ID","Name Punish","Money","Status","Date Create"};
				data = bus.loadAllPunish();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputID.getText();
				String name = inputName.getText();
				String money = inputMoney.getText();
				String statusChoose = (String) status.getItemAt(status.getSelectedIndex());
				if(ID.equals("") == true) {
					JOptionPane.showMessageDialog(inputID, "ID Blank,Input ID");
					return;
				}
				if(name.equals("") == true) {
					JOptionPane.showMessageDialog(inputID, "Name Punish Blank,Input Name Punish");
					return;
				}
				if(bus.checkMoney(money) == false) {
					JOptionPane.showMessageDialog(inputID,"Value money not valid");
					return;
				}
				
				bus.update(ID, name, money, statusChoose);
				JOptionPane.showMessageDialog(inputID,"Update Success");
				String colum[] = {"ID","Name Punish","Money","Status","Date Create"};				
				data = bus.loadAllPunish();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				inputID.setText("");
				inputName.setText("");
				inputMoney.setText("");
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnReset() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputID.setText("");
				inputName.setText("");
				inputMoney.setText("");
			}
		});
	}
	
	public void evetBtnDelete() {
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputID.getText();
				if(ID.equals("") == true) {
					JOptionPane.showMessageDialog(inputID, "ID Blank,Input ID");
					return;
				}
				bus.delete(ID);
				JOptionPane.showMessageDialog(inputID, "Delete Success");
				inputID.setText("");
				inputName.setText("");
				inputMoney.setText("");
				String colum[] = {"ID","Name Punish","Money","Status","Date Create"};			
				data = bus.loadAllPunish();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnFindID() {
		btnFindID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFind.getText();
				String colum[] = {"ID","Name Punish","Money","Status","Date Create"};
				if(bus.checkID(ID) == false) {
					data = null;
					
				}else data = bus.findID(ID);
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void evetnBtnFindName() {
		btnFindName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFind.getText();
				String colum[] = {"ID","Name Punish","Money","Status","Date Create"};
				if(ID.equals("") == true) {
					data = null;
				}else data = bus.findName(ID);
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtn() {
		eventBtnChoose();
		eventBtnAdd();
		eventBtnReset();
		eventBtnUpdate();
		evetBtnDelete();
		eventBtnFindID();
		evetnBtnFindName();
	}
}