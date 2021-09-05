import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPower{
	protected JPanel panel;
	
	protected JPanel north;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JPanel center;
	
	protected JPanel centerL1;
	
	protected JPanel centerL2;
	
	protected JLabel lbID;
	
	protected JLabel lbName;
	
	protected JTextField tfID;
	
	protected JTextField tfPower;
	
	protected JButton btnAdd;

	protected JButton btnClear;
	
	protected JButton btnUpdate;
	
	protected JButton Reset;
	
	protected JButton btnChoose;
	
	protected JComboBox barFilter;
	
	protected JButton btnFilter;
	
	protected JButton btnSave;
	
	protected JLabel lbTable;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected Object[][] data;
	
	protected BusPower bus = new BusPower();

	GuiPower(){
		boot();
	}
	
	public void boot() {
		table = new JTable();
		model = new DefaultTableModel();
		btnChoose = new JButton("Choose");
		centerL2 = new JPanel();
		centerL1 = new JPanel();
		center = new JPanel();
		northL2 = new JPanel();
		northL1 = new JPanel();
		north = new JPanel();
		panel = new JPanel();
		lbID = new JLabel("ID Power");
		lbName = new JLabel("Name Power");
		lbTable = new JLabel("Table Power");
		tfID = new JTextField();
		tfPower = new JTextField();
		btnAdd = new JButton("ADD");
		btnClear = new JButton("Clear");
		btnUpdate = new JButton("Update");
		Reset = new JButton("Reset");
		btnFilter = new JButton("Filter");
		btnSave = new JButton("Save");
		event();
	}
	
	public void createGui(MyFrame frame) {
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
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		north.setLayout(new GridLayout(2,1));
		north.add(northL1);
		north.add(northL2);
		//btnAdd,btnClear,btnUpdate,Reset
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER,12,15));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		
		north.setPreferredSize(new Dimension(980,80));
		
		lbID.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		lbID.setPreferredSize(new Dimension(90,25));
		lbName.setPreferredSize(new Dimension(90,25));
		
		tfID.setEditable(false);
		tfID.setPreferredSize(new Dimension(300,25));
		tfPower.setPreferredSize(new Dimension(300,25));
		
		btnAdd.setPreferredSize(new Dimension(100,25));
		btnClear.setPreferredSize(new Dimension(100,25));
		btnUpdate.setPreferredSize(new Dimension(100,25));
		Reset.setPreferredSize(new Dimension(100,25));
		
		northL1.add(lbID);
		northL1.add(tfID);
		northL1.add(btnAdd);
//		northL1.add(btnClear);
		
		northL2.add(lbName);
		northL2.add(tfPower);
		northL2.add(btnClear);
//		northL2.add(Reset);
		
		lbTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		center.setLayout(new BorderLayout());
		centerL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,25));
		centerL1.setPreferredSize(new Dimension(986, 60));
		
		centerL2.setLayout(new BorderLayout());
		
//		centerL1.setBackground(Color.blue);
		
		center.add(centerL1,BorderLayout.NORTH);
		center.add(centerL2,BorderLayout.CENTER);
		
		String colum[] = {"ID Power","Power","ID Function","Function","Use"};
		
		DTOPower listPower[] = bus.takeListPower();
		
		String[] contentBar = new String[listPower.length];
		
		for(int i = 0 ;i<contentBar.length;++i) {
			contentBar[i] = listPower[i].power;
		}
		
		barFilter = new JComboBox(contentBar);
		
		barFilter.setPreferredSize(new Dimension(200, 25));
		btnFilter.setPreferredSize(new Dimension(100, 25));
		btnChoose.setPreferredSize(new Dimension(100, 25));
		btnSave.setPreferredSize(new Dimension(100, 25));
		
		//btnChoose,btnFilter,btnSave
		centerL1.add(lbTable);
		centerL1.add(barFilter);
		centerL1.add(btnFilter);
		centerL1.add(btnChoose);
		centerL1.add(btnSave);
		centerL1.add(Reset);
		
		barFilter.setBackground(Color.white);
		barFilter.setFocusable(false);
		
		btnAdd.setForeground(Color.white);
		btnClear.setForeground(Color.white);
		btnFilter.setForeground(Color.white);
		btnChoose.setForeground(Color.white);
		btnSave.setForeground(Color.white);
		Reset.setForeground(Color.white);
		
		btnAdd.setFocusable(false);
		btnClear.setFocusable(false);
		btnFilter.setFocusable(false);
		btnChoose.setFocusable(false);
		btnSave.setFocusable(false);
		Reset.setFocusable(false);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnClear.setBackground(Color.decode("#1a89cc"));
		btnFilter.setBackground(Color.decode("#ff0000"));
		btnChoose.setBackground(Color.decode("#28b928"));
		btnSave.setBackground(Color.decode("#803ec0"));
		Reset.setBackground(Color.decode("#f7941e"));
		
		data = null;
		
		model = new DefaultTableModel(data,colum);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public Class getColumnClass(int column) {
                switch (column) {
                    case 4:
                    	return Boolean.class;
                    default:
                    	return String.class;
                }
            }
        	
		};
		
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
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		centerL2.add(tableScroll,BorderLayout.CENTER);
	}
	
	public void eventBtnClear() {
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = tfID.getText();
				if(bus.checkIDPower(ID) == false) {
					JOptionPane.showMessageDialog(tfID, "ID not valid");
					tfID.setText("");
					tfPower.setText("");
					return;
				}
				if(bus.checkIDPowerUserOrNot(ID) == false) {
					JOptionPane.showMessageDialog(tfID, "Power is using for account");
					tfID.setText("");
					tfPower.setText("");
					return;
				}
				
				bus.clearPower(ID);
				tfID.setText("");
				tfPower.setText("");
				JOptionPane.showMessageDialog(tfID, "Delete Success");
				String colum[] = {"ID Power","Power","ID Function","Function","Use"};
				data = null;
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
			}
		});
	}
	
	public void eventBtnChoose() {
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row < 0) return;
				String ID =  table.getValueAt(row, 0).toString();
				String name =  table.getValueAt(row, 1).toString();
				tfID.setText(ID);
				tfPower.setText(name);
			}
		});
	}
	
	public void eventBtnFilter() {
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colum[] = {"ID Power","Power","ID Function","Function","Use"};
				String filter = (String) barFilter.getItemAt(barFilter.getSelectedIndex());
				data = bus.loadPower(filter);
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setPreferredWidth(0);
				table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnReset() {
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfID.setText("");
				tfPower.setText("");
				String colum[] = {"ID Power","Power","ID Function","Function","Use"};
				data = null;
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				panel.removeAll();
				panel.setVisible(false);
				gui();
				panel.setVisible(true);
			}
		});
	}
	
	public void evetnBtnAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				tfID.setText("");
//				tfPower.setText("");
				String ID = tfID.getText();
				String power = tfPower.getText();
				if(ID.equals("") == false) {
					JOptionPane.showMessageDialog(tfID, "ID Must Blank, Click Reset");
					return;
				}
				
				if(power.equals("") == true) {
					JOptionPane.showMessageDialog(tfID, "Name Blank, input Name");
					return;
				}
				bus.insert(power);
				JOptionPane.showMessageDialog(tfID, "ADD Success");
				tfID.setText("");
				tfPower.setText("");
			}
		});
	}
	
	public void eventBtnSave() {
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data == null) {
					return;
				}
				Object dataNew[][] = new Object[data.length][3];
				for(int i = 0;i<dataNew.length;++i) {
					dataNew[i][0] = table.getValueAt(i, 0);
					dataNew[i][1] = table.getValueAt(i, 2);
					dataNew[i][2] = table.getValueAt(i, 4);
				}
				
				bus.savePower(dataNew);
				JOptionPane.showMessageDialog(tfID, "Save Success");
			}
		});
		
	}
	
	public void event() {
		eventBtnReset();
		evetnBtnAdd();
		eventBtnFilter();
		eventBtnSave();
		eventBtnChoose();
		eventBtnClear();
	}
}