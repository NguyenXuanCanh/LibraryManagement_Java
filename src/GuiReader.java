import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiReader{
	protected JPanel panel;
	
	protected JPanel north;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JPanel northL3;
	
	protected JPanel center;
	
	protected JPanel centerL1;
	
	protected JPanel centerL2;
	
	protected JTextField tfMs;
	
	protected JTextField tfName;
	
	protected JTextField tfBirthday;
	
	protected JComboBox cbbSex;
	
	protected JTextField tfDepartment;
	
	protected JComboBox type;
	
	protected JTextField tfFind;
	
	protected JLabel lbMs;
	
	protected JLabel lbName;
	
	protected JLabel lbBirthday;
	
	protected JLabel lbSex;
	
	protected JLabel lbDepartment;
	
	protected JLabel lbDateCreate;
	
	protected JLabel lbFind;
	
	protected JButton btnAdd;
	
	protected JButton btnUpdate;
	
	protected JButton btnClear;
	
	protected JButton btnReset;
	
	protected JButton btnChoose;
	
	protected JButton btnLoadData;
	
	protected JButton btnFindMs;
	
	protected JButton btnFindName;
	
	protected JTable table;
	
	protected String[][] data;
	
	protected DefaultTableModel model;
	
	protected BusReader bus = new BusReader();
	
	GuiReader(){
		boot();
	}
	
	public void boot() {
		model = new DefaultTableModel();
		table = new JTable();
		String cbbType[] = {"student","teacher"};
		String barSex[] = {"Male","Female"};
		panel = new JPanel();
		north = new JPanel();
		northL1 = new JPanel();
		northL2 = new JPanel();
		northL3 = new JPanel();
		center = new JPanel();
		centerL1 = new JPanel();
		centerL2 = new JPanel();
		lbMs = new JLabel("Ms Reader");
		lbName = new JLabel("Name");
		lbBirthday = new JLabel("Birthday");
		lbSex = new JLabel("Sex");
		lbDepartment = new JLabel("Depart");
		lbDateCreate = new JLabel("Type");
		lbFind = new JLabel("Find Reader");
		tfMs = new JTextField();
		tfName = new JTextField();
		tfBirthday = new JTextField();
		tfDepartment = new JTextField();
		type = new JComboBox(cbbType);
		tfFind = new JTextField();
		cbbSex = new JComboBox(barSex);
		btnAdd = new JButton("ADD");
		btnUpdate = new JButton("Update");
		btnClear = new JButton("Clear");
		btnFindMs = new JButton("Find Follow MS");
		btnReset = new JButton("Reset");
		btnChoose = new JButton("Choose");
		btnLoadData = new JButton("Load Data");
		btnFindName = new JButton("Find Follow Name");
		eventBtn();
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
		panel.setBounds(0, 0, 986, 500);
		panel.setBackground(Color.white);
		panel.removeAll();
		north.removeAll();
		northL1.removeAll();
		northL2.removeAll();
		northL3.removeAll();
		center.removeAll();
		centerL1.removeAll();
		centerL2.removeAll();
		//north,northL1,northL2,northL3,center,centerL1,centerL2
		//tfMs,tfName,tfBirthday,cbbSex,tfDepartment,tfDateCreate,tfFind
		//lbMs,lbName,lbBirthday,lbSex,lbDepartment,lbDateCreate,lbFind
		//btnAdd,btnUpdate,btnClear,btnFindMs,btnReset,btnChoose,btnLoadData
		panel.setLayout(new BorderLayout());
		panel.add(north,BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		
		north.setBackground(Color.white);
		north.setPreferredSize(new Dimension(986,120));
		north.setLayout(new GridLayout(3,1));
		north.add(northL1);
		north.add(northL2);
		north.add(northL3);
		
		northL1.setBackground(Color.white);
		northL2.setBackground(Color.white);
		northL3.setBackground(Color.white);
		
		lbMs.setPreferredSize(new Dimension(65,25));
		lbName.setPreferredSize(new Dimension(40,25));
		lbBirthday.setPreferredSize(new Dimension(65,25));
		lbSex.setPreferredSize(new Dimension(40,25));
		lbDepartment.setPreferredSize(new Dimension(65,25));
		lbDateCreate.setPreferredSize(new Dimension(40,25));
		
		tfMs.setPreferredSize(new Dimension(200,25));
		tfName.setPreferredSize(new Dimension(200,25));
		btnAdd.setPreferredSize(new Dimension(100,25));
		btnLoadData.setPreferredSize(new Dimension(100,25));
		
		tfBirthday.setEditable(false);
		tfBirthday.setPreferredSize(new Dimension(200,25));
		cbbSex.setPreferredSize(new Dimension(200,25));
		btnUpdate.setPreferredSize(new Dimension(100,25));
		btnReset.setPreferredSize(new Dimension(100,25));
		
		tfDepartment.setPreferredSize(new Dimension(200,25));
		type.setPreferredSize(new Dimension(200,25));
		btnClear.setPreferredSize(new Dimension(100,25));
		btnChoose.setPreferredSize(new Dimension(100,25));
		
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		northL3.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		
		northL1.add(lbMs);
		northL1.add(tfMs);
		northL1.add(lbName);
		northL1.add(tfName);
		northL1.add(btnAdd);
		northL1.add(btnLoadData);
		
		northL2.add(lbBirthday);
		northL2.add(tfBirthday);
		northL2.add(lbSex);
		northL2.add(cbbSex);
		northL2.add(btnUpdate);
		northL2.add(btnReset);
		
		cbbSex.setBackground(Color.white);
		cbbSex.setFocusable(false);
		
		northL3.add(lbDepartment);
		northL3.add(tfDepartment);
		northL3.add(lbDateCreate);
		northL3.add(type);
		northL3.add(btnClear);
		northL3.add(btnChoose);
		
		type.setBackground(Color.white);
		type.setFocusable(false);
		
		centerL1.setPreferredSize(new Dimension(986,60));
		centerL1.setBackground(Color.white);
		centerL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		
		tfFind.setPreferredSize(new Dimension(400,25));
		btnFindMs.setPreferredSize(new Dimension(150,25));
		btnFindName.setPreferredSize(new Dimension(150,25));
		
		centerL1.add(lbFind);
		centerL1.add(tfFind);
		centerL1.add(btnFindMs);
		
		center.setLayout(new BorderLayout());
		center.add(centerL1,BorderLayout.NORTH);
		center.add(centerL2,BorderLayout.CENTER);
		
		centerL2.setLayout(new BorderLayout());
		
//		btnAdd,btnUpdate,btnClear,btnFindMs,btnReset,btnChoose,btnLoadData
		
		btnAdd.setForeground(Color.white);
		btnUpdate.setForeground(Color.white);
		btnClear.setForeground(Color.white);
		btnFindMs.setForeground(Color.white);
		btnReset.setForeground(Color.white);
		btnChoose.setForeground(Color.white);
		btnLoadData.setForeground(Color.white);
		
		btnAdd.setFocusable(false);
		btnUpdate.setFocusable(false);
		btnClear.setFocusable(false);
		btnFindMs.setFocusable(false);
		btnReset.setFocusable(false);
		btnChoose.setFocusable(false);
		btnLoadData.setFocusable(false);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnUpdate.setBackground(Color.decode("#1a89cc"));
		btnClear.setBackground(Color.decode("#f1c708"));
		btnFindMs.setBackground(Color.decode("#ff0000"));
		btnReset.setBackground(Color.decode("#f7941e"));
		btnChoose.setBackground(Color.decode("#28b928"));
		btnLoadData.setBackground(Color.decode("#803ec0"));
		
		String colum[] = {"ID Reader","Name","department","birthday","sex","type","date Create"};
		data = bus.loadAllReader();
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
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(table);

		centerL2.add(tableScroll);
	}
	
	public void loadTable() {
		String colum[] = {"ID Reader","Name","department","birthday","sex","type","date Create"};
		data = bus.loadAllReader();
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
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
	}
	
	public void eventLoadData() {
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ms = tfMs.getText();
				String typeR = type.getItemAt(type.getSelectedIndex()).toString();
				if(bus.checkMS(ms, typeR) == false) {
					JOptionPane.showMessageDialog(tfMs,"MS not exist");
					tfMs.setText("");
					tfName.setText("");
					tfBirthday.setText("");
					tfDepartment.setText("");
					return;
				}
				//tfMs,tfName,tfBirthday,cbbSex,tfDepartment,tfDateCreate,tfFind
				String[] information = bus.loadData(ms, typeR);
				tfName.setText(information[1]);
				tfBirthday.setText(information[2]);
				cbbSex.setSelectedItem(information[3]);
				tfDepartment.setText(information[4]);
			}
		});
	}
	
	public void eventAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ms = tfMs.getText();
				String name = tfName.getText();
				String birth = tfBirthday.getText();
				String sex = cbbSex.getItemAt(cbbSex.getSelectedIndex()).toString();
				String depart = tfDepartment.getText();
				String typeR = type.getItemAt(type.getSelectedIndex()).toString();
				String dateCreate = getDateCurrent();
				if(ms.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Blank");
					return;
				}
				if(name.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"Name Blank");
					return;
				}
				if(birth.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"Birthday Blank");
					return;
				}
				if(depart.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"department Blank");
					return;
				}
				if(bus.checkMS(ms, typeR) == false) {
					JOptionPane.showMessageDialog(tfMs,"MS not exist");
					tfMs.setText("");
					tfName.setText("");
					tfBirthday.setText("");
					tfDepartment.setText("");
					return;
				}
				
				if(bus.checkLoopID(ms) == false) {
					JOptionPane.showMessageDialog(tfMs,"Reader exist");
					tfMs.setText("");
					tfName.setText("");
					tfBirthday.setText("");
					tfDepartment.setText("");
					return;
				}
				bus.add(ms, name, depart, birth, sex, typeR, dateCreate);
				JOptionPane.showMessageDialog(tfMs,"ADD Success");
				tfMs.setText("");
				tfName.setText("");
				tfBirthday.setText("");
				tfDepartment.setText("");
				loadTable();
				
			}
		});
	}
	
	public void eventChoose() {
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tfMs,tfName,tfBirthday,cbbSex,tfDepartment,tfDateCreate,tfFind
				int row = table.getSelectedRow();
				if(row < 0) return;
				tfMs.setText(table.getValueAt(row, 0).toString());
				tfName.setText(table.getValueAt(row, 1).toString());
				tfDepartment.setText(table.getValueAt(row, 2).toString());
				tfBirthday.setText(table.getValueAt(row, 3).toString());
				cbbSex.setSelectedItem(table.getValueAt(row, 4).toString());
				type.setSelectedItem(table.getValueAt(row, 5).toString());
			}
		});
	}
	
	public void eventUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tfMs,tfName,tfBirthday,cbbSex,tfDepartment,tfDateCreate,tfFind
				String ms = tfMs.getText();
				String name = tfName.getText();
				String birth = tfBirthday.getText();
				String sex = cbbSex.getItemAt(cbbSex.getSelectedIndex()).toString();
				String depart = tfDepartment.getText();
				String typeR = type.getItemAt(type.getSelectedIndex()).toString();
				
				if(ms.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Blank");
					return;
				}
				if(name.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"Name Blank");
					return;
				}
				if(birth.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"Birthday Blank");
					return;
				}
				if(depart.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"department Blank");
					return;
				}
				if(bus.checkLoopID(ms) == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Reader not exist");
					tfMs.setText("");
					tfName.setText("");
					tfBirthday.setText("");
					tfDepartment.setText("");
					return;
				}
				
				bus.update(ms, name, depart, birth, sex, typeR);
				JOptionPane.showMessageDialog(tfMs,"Update Success");
				tfMs.setText("");
				tfName.setText("");
				tfBirthday.setText("");
				tfDepartment.setText("");
				loadTable();
			}
		});
	}
	
	public void eventClear() {
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tfMs,tfName,tfBirthday,cbbSex,tfDepartment,tfDateCreate,tfFind
				String ms = tfMs.getText();
				if(ms.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Blank");
					return;
				}
				
				if(bus.checkLoopID(ms) == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Reader not exist");
					tfMs.setText("");
					tfName.setText("");
					tfBirthday.setText("");
					tfDepartment.setText("");
					return;
				}
				
				bus.clear(ms);
				JOptionPane.showMessageDialog(tfMs,"Clear Success");
				tfMs.setText("");
				tfName.setText("");
				tfBirthday.setText("");
				tfDepartment.setText("");
				loadTable();
			}
		});
	}
	
	public void eventReset() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMs.setText("");
				tfName.setText("");
				tfBirthday.setText("");
				tfDepartment.setText("");
			}
		});
	}
	
	public void eventFindMS() {
		btnFindMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ms = tfFind.getText();
				if(ms.equals("") == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Find Blank");
					return;
				}
				
				if(bus.checkLoopID(ms) == true) {
					JOptionPane.showMessageDialog(tfMs,"MS Reader not exist");
					return;
				}
				String colum[] = {"ID Reader","Name","department","birthday","sex","type","date Create"};
				data = bus.findMs(ms);
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
				table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
				table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtn() {
		eventLoadData();
		eventChoose();
		eventAdd();
		eventUpdate();
		eventClear();
		eventReset();
		eventFindMS();
	}
	
	public String getDateCurrent() {
		return java.time.LocalDate.now().toString();
	}
}