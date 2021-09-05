import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiUser{
	
	protected JPanel panel;
	
	protected JPanel north;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JPanel northL3;
	
	protected JPanel center;
	
	protected JPanel centerL1;
	
	protected JPanel centerL2;
	
	protected JTextField tfAccount;
	
	protected JPasswordField tfPassword1;
	
	protected JPasswordField tfPassword2;
	
	protected JTextField tfName;
	
	protected JTextField tfAddress;
	
	protected JTextField txFind;
	
	protected JComboBox barPower;
	
	protected JLabel lbAccount;
	
	protected JLabel lbPassword1;
	
	protected JLabel lbPassword2;
	
	protected JLabel lbName;
	
	protected JLabel lbAddress;
	
	protected JLabel lbPower;
	
	protected JLabel lbFind;

	protected JButton btnAdd;
	
	protected JButton btnBlock;
	
	protected JButton btnUnBlock;
	
	protected JButton btnReset;
	
	protected JButton btnDelete;
	
	protected JButton btnFind;
	
	protected JButton btnChoose;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected String[][] data;
	
	protected BusUser bus = new BusUser();
	
	protected JButton btnUpdatePower;
	
	GuiUser(){
		boot();
	}
	
	public void boot() {
		
		table = new JTable();
		
		model = new DefaultTableModel();

		lbFind = new JLabel("Find User");
		
		lbPower = new JLabel("Power");
		
		lbAddress = new JLabel("Address");
		
		lbName = new JLabel("Name");
		
		lbPassword2 = new JLabel("Confirm");
		
		lbPassword1 = new JLabel("Password");
		
		lbAccount = new JLabel("Account");
		
		txFind = new JTextField();
		
		tfAccount = new JTextField();
		
		tfPassword1 = new JPasswordField();
		
		tfPassword2 = new JPasswordField();
		
		tfName = new JTextField();
		
		tfAddress = new JTextField();
		
		barPower = new JComboBox();
		
		panel = new JPanel();
		
		north = new JPanel();
		
		northL1 = new JPanel();
		
		northL2 = new JPanel();
		
		northL3 = new JPanel();
		
		center = new JPanel();
		
		centerL1 = new JPanel();

		centerL2 = new JPanel();
		
		btnAdd = new JButton("ADD");
		
		btnBlock = new JButton("Block");
		
		btnUnBlock = new JButton("UnBlock");
		
		btnReset = new JButton("Reset");
		
		btnDelete = new JButton("Delete");
		
		btnFind = new JButton("Find");
		
		btnChoose = new JButton("Choose");
		
		btnUpdatePower = new JButton("Update Power");
		
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
		
		center.removeAll();
		north.removeAll();
		northL1.removeAll();
		northL2.removeAll();
		northL3.removeAll();
		centerL1.removeAll();
		centerL2.removeAll();
		
		panel.setBounds(0, 0, 980, 500);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		center.setBackground(Color.white);
		north.setBackground(Color.white);
		northL1.setBackground(Color.white);
		northL2.setBackground(Color.white);
		northL3.setBackground(Color.white);
		centerL1.setBackground(Color.white);
		centerL2.setBackground(Color.white);
		
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		north.setLayout(new GridLayout(3,1));
		north.setPreferredSize(new Dimension(980,130));
		north.add(northL1);
		north.add(northL2);
		north.add(northL3);
		
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		northL3.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		
		lbAccount.setPreferredSize(new Dimension(55,25));
		lbPassword1.setPreferredSize(new Dimension(55,25));
		lbPassword2.setPreferredSize(new Dimension(55,25));
		lbName.setPreferredSize(new Dimension(55,25));
		lbAddress.setPreferredSize(new Dimension(55,25));
		lbPower.setPreferredSize(new Dimension(55,25));
		
		lbAccount.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbPassword1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbPassword2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbName.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbAddress.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbPower.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		lbFind.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		
		BusPower busPw = new BusPower();
		DTOPower listPower[] = busPw.takeListPower();
		String[] contentBar = new String[listPower.length];
		
		for(int i = 0 ;i<contentBar.length;++i) {
			contentBar[i] = listPower[i].power;
		}
		
		barPower = new JComboBox(contentBar);
		barPower.setBackground(Color.white);
		barPower.setFocusable(false);
		
		tfAccount.setPreferredSize(new Dimension(200,25));
		tfPassword1.setPreferredSize(new Dimension(200,25));
		tfPassword2.setPreferredSize(new Dimension(200,25));
		tfName.setPreferredSize(new Dimension(200,25));
		tfAddress.setPreferredSize(new Dimension(200,25));
		barPower.setPreferredSize(new Dimension(200,25));
		
		btnAdd.setPreferredSize(new Dimension(100,25));
		btnBlock.setPreferredSize(new Dimension(100,25));
		btnUnBlock.setPreferredSize(new Dimension(100,25));
		btnReset.setPreferredSize(new Dimension(100,25));
		btnDelete.setPreferredSize(new Dimension(100,25));
		
		northL1.add(lbAccount);
		northL1.add(tfAccount);
		northL1.add(lbPassword1);
		northL1.add(tfPassword1);
		northL1.add(btnAdd);
		
		northL2.add(lbName);
		northL2.add(tfName);
		northL2.add(lbPassword2);
		northL2.add(tfPassword2);
		northL2.add(btnDelete);
		
		northL3.add(lbAddress);
		northL3.add(tfAddress);
		northL3.add(lbPower);
		northL3.add(barPower);
		northL3.add(btnReset);
		
		center.setLayout(new BorderLayout());
		center.add(centerL1, BorderLayout.NORTH);
		center.add(centerL2, BorderLayout.CENTER);
		
		centerL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,24));
		centerL1.setPreferredSize(new Dimension(980,60));
		centerL1.setBackground(Color.white);
		
		txFind.setPreferredSize(new Dimension(250,25));
		btnFind.setPreferredSize(new Dimension(120,25));
		btnChoose.setPreferredSize(new Dimension(80,25));
		btnUpdatePower.setPreferredSize(new Dimension(120,25));
		
//		txFind,btnFind
		centerL1.add(lbFind);
		centerL1.add(txFind);
		centerL1.add(btnFind);
		centerL1.add(btnUnBlock);
		centerL1.add(btnBlock);
		centerL1.add(btnChoose);
		centerL1.add(btnUpdatePower);
		
		btnAdd.setForeground(Color.white);
		btnBlock.setForeground(Color.white);
		btnReset.setForeground(Color.white);
		btnDelete.setForeground(Color.white);
		btnFind.setForeground(Color.white);
		btnUnBlock.setForeground(Color.white);
		btnBlock.setForeground(Color.white);
		btnChoose.setForeground(Color.white);
		btnUpdatePower.setForeground(Color.white);
		
		btnAdd.setFocusable(false);
		btnBlock.setFocusable(false);
		btnUnBlock.setFocusable(false);
		btnReset.setFocusable(false);
		btnDelete.setFocusable(false);
		btnFind.setFocusable(false);
		btnChoose.setFocusable(false);
		btnUpdatePower.setFocusable(false);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnDelete.setBackground(Color.decode("#1a89cc"));
		btnReset.setBackground(Color.decode("#f7941e"));
		
		btnFind.setBackground(Color.decode("#ff0000"));
		btnBlock.setBackground(Color.decode("#803ec0"));
		btnUnBlock.setBackground(Color.decode("#1a89cc"));
		btnChoose.setBackground(Color.decode("#f1c708"));
		btnUpdatePower.setBackground(Color.decode("#f7941e"));
		
		data = bus.loadAllUser();

		String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
		model = new DefaultTableModel(data,colum);
		table.setModel(model);
		
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		table.setTableHeader(header);
		table.setSelectionForeground(Color.white);
		table.setSelectionBackground(Color.decode("#28b928"));
		table.setGridColor(Color.white);
		table.setFocusable(false);
		
		AligmentMid();
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		centerL2.setLayout(new BorderLayout());
		centerL2.add(tableScroll);
	}
	
	public void AligmentMid() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
	}
	
	public void eventBtnFind() {
		btnFind.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = txFind.getText();
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				if(bus.checkAccount(account) == false) {
					data = null;
				}else data = bus.findAccount(account);
				
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				AligmentMid();
			}
		});
	}
	
	public void eventUpdatePower() {
		btnUpdatePower.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = tfAccount.getText();
				String power = (String) barPower.getItemAt(barPower.getSelectedIndex());
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				if(bus.checkAccount(account) == false) {
					JOptionPane.showMessageDialog(tfAccount, "account not exist");
					return;
				}
				bus.updatePower(account, power);
				JOptionPane.showMessageDialog(tfAccount, "Update Power Success");
				tfAccount.setText("");
				tfPassword1.setText("");
				tfPassword2.setText("");
				tfName.setText("");
				tfAddress.setText("");
				centerL2.setVisible(false);
				data = bus.loadAllUser();
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				centerL2.setVisible(true);
				AligmentMid();
			}
		});
	}
	
	public void eventBtnBlock() {
		btnBlock.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row<0) return;
				String account = table.getValueAt(row, 0).toString();
				bus.blockAccount(account);
				JOptionPane.showMessageDialog(txFind, "Block Success");
				centerL2.setVisible(false);
				data = bus.loadAllUser();
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				centerL2.setVisible(true);
				AligmentMid();

			}
		});
	}
	
	public void eventBtnUnBlock() {
		btnUnBlock.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row<0) return;
				String account = table.getValueAt(row, 0).toString();
				bus.unBlockAccount(account);
				JOptionPane.showMessageDialog(txFind, "UnBlock Success");
				centerL2.setVisible(false);
				data = bus.loadAllUser();
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				centerL2.setVisible(true);
				AligmentMid();
			}
		});
	}
	
	public void eventChoose() {
		btnChoose.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row<0) return;
				String account = table.getValueAt(row, 0).toString();
				String password = table.getValueAt(row, 1).toString();
				String name = table.getValueAt(row, 2).toString();
				String address = table.getValueAt(row, 3).toString();
				String power = table.getValueAt(row, 4).toString();
//				tfAccount,tfPassword1,tfPassword2,tfName,tfAddress,barPower
				tfAccount.setText(account);
				tfPassword1.setText(password);
				tfPassword2.setText(password);
				tfName.setText(name);
				tfAddress.setText(address);
				barPower.setSelectedItem(power);
			}
		});
	}
	
	public void btnAddEvent() {
		btnAdd.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = tfAccount.getText();
				String pass1 = tfPassword1.getText();
				String pass2 = tfPassword2.getText();
				String name = tfName.getText();
				String address = tfAddress.getText();
				String power = (String) barPower.getItemAt(barPower.getSelectedIndex());
				
				if(account.equals("") == true) {
					JOptionPane.showMessageDialog(tfAccount, "Account blank");
					return;
				}
				
				if(bus.checkAccountExist(account) == true) {
					JOptionPane.showMessageDialog(tfAccount, "Account exist");
					return;
				}
				
				if(pass1.equals("") == true) {
					JOptionPane.showMessageDialog(tfAccount, "password blank, input password");
					return;
				}
				
				if(pass2.equals("") == true) {
					JOptionPane.showMessageDialog(tfAccount, "Confirm password blank, input Confirm password");
					return;
				}
				
				
				
				if(bus.checkPasswordSecond(pass1, pass2) == false) {
					JOptionPane.showMessageDialog(tfAccount, "Cofirm Password false");
					return;
				}
				bus.insertUser(account, pass1, name, address, power);
				JOptionPane.showMessageDialog(tfAccount, "Account Create Success");
				tfAccount.setText("");
				tfPassword1.setText("");
				tfPassword2.setText("");
				tfName.setText("");
				tfAddress.setText("");
				centerL2.setVisible(false);
				data = bus.loadAllUser();
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				centerL2.setVisible(true);
				AligmentMid();
			}
		});
	}
	
	public void eventReset() {
		btnReset.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfAccount.setText("");
				tfPassword1.setText("");
				tfPassword2.setText("");
				tfName.setText("");
				tfAddress.setText("");
			}
		});
		
	}
	
	public void eventDelete() {
		btnDelete.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = tfAccount.getText();
				if(bus.checkAccount(account) == false) {
					JOptionPane.showMessageDialog(tfAccount, "Account not exist");
					return;
				}
				bus.deleteAccount(account);
				JOptionPane.showMessageDialog(tfAccount, "Delete account success");
				tfAccount.setText("");
				tfPassword1.setText("");
				tfPassword2.setText("");
				tfName.setText("");
				tfAddress.setText("");
				centerL2.setVisible(false);
				data = bus.loadAllUser();
				String colum[] = {"Account","Password","Name","Address","Power","StatusUse"};
				model = new DefaultTableModel(data,colum);
				table.setModel(model);
				centerL2.setVisible(true);
				AligmentMid();
			}
		});
	}
	
	public void event() {
		eventBtnFind();
		eventBtnBlock();
		eventBtnUnBlock();
		eventChoose();
		eventReset();
		btnAddEvent();
		eventDelete();
		eventUpdatePower();
	}
}