import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiBillPay{
	protected JPanel panel;
	
	protected JPanel north;
	
	protected JPanel east;
	
	protected JPanel west;
	
	protected JPanel south;
	
	protected JPanel center;
	
	protected JButton menuAdd;
	
	protected JButton menuUpdate;
	
	protected JButton menuClear;
	
	protected JButton menuFind;
	
	protected JTextField inputIDBorrowAdd;
	
	protected JTextField inputDatePayAdd;
	
	protected JTextField inputDateExpiryAdd;
	
	protected JTextField inputDateBorrowAdd;
	
	protected JTextField inputPunishMoneyAdd;
	
	protected JTextField inputMoneyBook;
	
	protected JPanel p0Add;
	
	protected JPanel p1Add;
	
	protected JPanel p2Add;
	
	protected JPanel p3Add;
	
	protected JPanel p4Add;
	
	protected JPanel p5Add;
	
	protected JPanel p6Add;
	
	protected JPanel p7Add;
	
	protected JPanel p1Update;
	
	protected JPanel p2Update;
	
	protected JPanel p3Update;
	
	protected JPanel p4Update;
	
	protected JPanel p5Update;
	
	protected JPanel p6Update;
	
	protected JButton btnCheck;
	
	protected JButton btnAdd;
	
	protected JButton btnLoad;
	
	protected JTable JTabelAdd;
	
	protected DefaultTableModel model;
	
	protected Object[][] dataAdd;
	
	protected JTextField inputFindAdd;
	
	protected JComboBox cbbFilterAdd;
	
	protected JButton btnFindIDReaderAdd;
	
	protected JButton btnBackAdd;
	
	protected JButton btnSelectAdd;
	
	protected JTable tableSelectBL;
	
	protected String[][] dataSelectBL;
	
	protected JButton Btncalculate;
	
	protected String [][] dataPunishBook;
	
	protected JTextField inputIDBillPayUpdate;
	
	protected JTextField inputIDBillLentUpdate;
	
	protected JTextField inputDatePayUpdate;
	
	protected JTextField inputMoneyUpdate;
	
	protected JButton btnUpdate;
	
	protected JButton chooseBillPay;
	
	protected JButton btnCalculateUpdate;
	
	protected JTable tableUpdate;
	
	protected Object[][] dataUpdate;
	
	protected JButton btnBack;
	
	protected JButton findIDBillLentUpdate;
	
	protected JButton findIDReaderUpdate;
	
	protected JTextField inputFindUpdate;
	
	protected JTable tableSelectBLUpdate;
	
	protected String[][] dataSelectBLUpdate;
	
	protected JButton selectBillPayUpdate;
	
	protected String varSaveBLOld;
	
	protected JButton loadDateUpdate;
	
	protected JTextField inputIDBPClear;
	
	protected JButton btnClear;
	
	protected JButton btnChooseClear;
	
	protected JTable tableFindClear;
	
	protected JTextField inputFindClear;
	
	protected JButton btnFindIDBLClear;
	
	protected JButton btnFindIDReaderClear;
	
	protected String[][] dataBillPay;
	
	protected JTextField inputFindF;
	
	protected JButton btnFindIDReaderF;
	
	protected JButton btnFindIDBLF;
	
	protected JTable TableF;
	
	protected String[][] dataF;
	
	protected JButton btnFindIDBPF;
	
	protected BusBillPay bus;
	
	//inputFindF,btnFindIDReaderF,btnFindIDBLF,TableF,dataF
	
	GuiBillPay(){
		bootPanel();
		bootButton();
		bootTextField();
		bootTable();
		bootComboBox();
		eventBtn();
	}
	
	public void bootTable() {
		
		TableF = new JTable();
		
		JTabelAdd = new JTable();
		
		tableUpdate = new JTable();
		
		tableFindClear = new JTable();
		
		tableSelectBLUpdate = new JTable();
		
		model = new DefaultTableModel();
		
		tableSelectBL = new JTable();
		
		bus = new BusBillPay();
	}
	
	public void bootPanel() {
		panel = new JPanel();
		
		north = new JPanel();
		
		east = new JPanel();
		
		west = new JPanel();
		
		south = new JPanel();
		
		center = new JPanel();
		
		p0Add = new JPanel();
		
		p1Add = new JPanel();
		
		p2Add = new JPanel();
		
		p3Add = new JPanel();
		
		p4Add = new JPanel();
		
		p5Add = new JPanel();
		
		p6Add = new JPanel();
		
		p7Add = new JPanel();
		
		p1Update = new JPanel();
		
		p2Update = new JPanel();
		
		p3Update = new JPanel();
		
		p4Update = new JPanel();
		
		p5Update = new JPanel();
		
		p6Update = new JPanel();
		
	}
	
	public void bootButton() {
		
		btnFindIDBPF = new JButton("Follow ID BP");
		
		btnFindIDReaderF = new JButton("Follow ID Reader");
		
		btnFindIDBLF = new JButton("Follow ID Bill Lent");
		
		btnClear = new JButton("Clear");
		
		btnChooseClear = new JButton("Choose");
		
		menuAdd = new JButton("ADD");
		
		menuUpdate = new JButton("Update");
		
		menuClear = new JButton("Clear");
		
		menuFind = new JButton("Find");
		
		btnCheck = new JButton("+");
		
		btnAdd = new JButton("Create");
		
		btnLoad = new JButton("Load");
		
		btnFindIDReaderAdd = new JButton("Follow ID Reader");
		
		btnBackAdd = new JButton("Back");
		
		btnSelectAdd = new JButton("Select");
		
		Btncalculate = new JButton("Calculate");
		
		btnUpdate = new JButton("Update");
		
		chooseBillPay = new JButton("+");
		
		btnCalculateUpdate = new JButton("Calculate");
		
		btnBack = new JButton("Back");
		
		findIDBillLentUpdate = new JButton("Follow ID Bill Lent");
		
		findIDReaderUpdate = new JButton("Follow ID Reader");
		
		selectBillPayUpdate = new JButton("Select");
		
		btnFindIDBLClear = new JButton("Follow ID Bill Lent");
		
		btnFindIDReaderClear = new JButton("Follow ID Reader");
	}
	
	public void bootTextField() {
		
		inputFindF = new JTextField();
		
		inputFindClear = new JTextField();
		
		inputIDBPClear = new JTextField();
		
		inputIDBorrowAdd = new JTextField();
		
		inputDatePayAdd = new JTextField();
		
		inputPunishMoneyAdd = new JTextField();
		
		inputDateExpiryAdd = new JTextField();
		
		inputDateBorrowAdd = new JTextField();
		
		inputFindAdd = new JTextField();
		
		inputIDBillPayUpdate = new JTextField();
		
		inputIDBillLentUpdate = new JTextField();
		
		inputDatePayUpdate = new JTextField();
		
		inputMoneyUpdate = new JTextField();
		
		inputFindUpdate = new JTextField();
		
		inputMoneyBook = new JTextField();

	}
	
	public void bootComboBox() {
		cbbFilterAdd = new JComboBox();
	}
	
	public void addMenuChild(MyFrame frame) {
		frame.panelTop.add(menuAdd);
		frame.panelTop.add(menuUpdate);
		frame.panelTop.add(menuClear);
		frame.panelTop.add(menuFind);
	}

	public void createMenu(MyFrame frame) {
		addMenuChild(frame);
		decorationMenu();
		eventMenuAdd(frame);
		eventMenuUpdate(frame);
		eventMenuClear(frame);
		eventMenuFind(frame);
	}
	
	public void decorationMenu() {
		decoration(menuAdd);
		decoration(menuClear);
		decoration(menuUpdate);
		decoration(menuFind);
		
	}
	
	public void decoration(JButton btn) {
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,18);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setFont(font);
		btn.setBackground(Color.decode("#202b30"));
		btn.setForeground(Color.decode("#ffffff"));
		btn.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				btn.setBackground(Color.decode("#202b30"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setBackground(Color.decode("#26a69a"));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setBackground(Color.decode("#202b30"));
			}
			
		});
	}
	
	public void eventMenuAdd(MyFrame frame) {
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiAddBillPay();
				panel.setVisible(true);
			}
		});	
	}
	
	public void eventMenuUpdate(MyFrame frame) {
		menuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiUpdate();
				panel.setVisible(true);
			}
		});	
	}
	
	public void eventMenuClear(MyFrame frame) {
		menuClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiClear();
				panel.setVisible(true);
			}
		});	
	}

	public void eventMenuFind(MyFrame frame) {
		menuFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiFind();
				panel.setVisible(true);
			}
		});	
	}
	
	public void guiAddBillPay() {
		panel.setBounds(0, 0, 986, 500);
//		panel.setBackground(Color.black);
		
		east.removeAll();
		west.removeAll();
		
		p0Add.removeAll();
		p1Add.removeAll();
		p2Add.removeAll();
		p3Add.removeAll();
		p4Add.removeAll();
		p5Add.removeAll();
		p6Add.removeAll();
		p7Add.removeAll();
		
		p0Add.setBackground(Color.white);
		p1Add.setBackground(Color.white);
		p2Add.setBackground(Color.white);
		p3Add.setBackground(Color.white);
		p4Add.setBackground(Color.white);
		p5Add.setBackground(Color.white);
		p6Add.setBackground(Color.white);
		p7Add.setBackground(Color.white);
	
		JLabel lbIDBorrow = new JLabel("ID Borrow");
		lbIDBorrow.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbIDBorrow.setPreferredSize(new Dimension(70,35));
		inputIDBorrowAdd.setPreferredSize(new Dimension(220,35));
		
		JLabel lbDatePay = new JLabel("Date Pay");
		lbDatePay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbDatePay.setPreferredSize(new Dimension(70,35));
		inputDatePayAdd.setPreferredSize(new Dimension(290,35));
		inputDatePayAdd.setEnabled(false);
		inputDatePayAdd.setText(getDateCurrent());
		
		JLabel lbDateExpiry = new JLabel("Expiry");
		lbDateExpiry.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbDateExpiry.setPreferredSize(new Dimension(70,35));
		inputDateExpiryAdd.setPreferredSize(new Dimension(290,35));
		inputDateExpiryAdd.setEnabled(false);
		
		JLabel lbMoneyPunish = new JLabel("Forfiet");
		lbMoneyPunish.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbMoneyPunish.setPreferredSize(new Dimension(70,35));
	
		inputPunishMoneyAdd.setPreferredSize(new Dimension(290,35));
		inputPunishMoneyAdd.setEnabled(false);
		
		JLabel lbMoneyBook = new JLabel("Rent");
		lbMoneyBook.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbMoneyBook.setPreferredSize(new Dimension(70,35));
		inputMoneyBook.setPreferredSize(new Dimension(290,35));
		inputMoneyBook.setEnabled(false);
		
		JLabel lbDateBorrow = new JLabel("Date Rent");
		lbDateBorrow.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbDateBorrow.setPreferredSize(new Dimension(70,35));
		inputDateBorrowAdd.setPreferredSize(new Dimension(290,35));
		inputDateBorrowAdd.setEnabled(false);
		
		JLabel title = new JLabel("Add Bill Pay");
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		
		west.setPreferredSize(new Dimension(403, 450));
		
		east.setPreferredSize(new Dimension(583,450));
		east.setLayout(new BorderLayout());
		
		panel.setLayout(new BorderLayout());
		panel.add(east, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
	
		west.setLayout(new GridLayout(8, 1));
		west.add(p0Add);
		west.add(p1Add);
		west.add(p2Add);
		west.add(p3Add);
		west.add(p6Add);
		west.add(p4Add);
		west.add(p7Add);
		west.add(p5Add);
		
		west.setBackground(Color.white);
		
		p0Add.add(title);
		p0Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,15));
		
		btnCheck.setPreferredSize(new Dimension(60,32));
		p1Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p1Add.add(lbIDBorrow);
		p1Add.add(inputIDBorrowAdd);
		p1Add.add(btnCheck);
		
		p2Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p2Add.add(lbDatePay);
		p2Add.add(inputDatePayAdd);
		
		p3Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p3Add.add(lbDateExpiry);
		p3Add.add(inputDateExpiryAdd);
		
		p4Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p4Add.add(lbMoneyPunish);
		p4Add.add(inputPunishMoneyAdd);
		
		btnAdd.setPreferredSize(new Dimension(100,35));
		btnLoad.setPreferredSize(new Dimension(100,35));
		Btncalculate.setPreferredSize(new Dimension(100,35));
		p5Add.setLayout(new FlowLayout(FlowLayout.CENTER, 15 , 0));
		p5Add.add(btnAdd);
		p5Add.add(btnLoad);
		p5Add.add(Btncalculate);
		
		btnAdd.setForeground(Color.white);
		btnLoad.setForeground(Color.white);
		Btncalculate.setForeground(Color.white);
		
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnLoad.setBackground(Color.decode("#1a89cc"));
		Btncalculate.setBackground(Color.decode("#803ec0"));
		
		btnCheck.setForeground(Color.white);
		btnCheck.setBackground(Color.decode("#f7941e"));
		
		btnAdd.setFocusable(false);
		btnLoad.setFocusable(false);
		Btncalculate.setFocusable(false);
		btnCheck.setFocusable(false);
		
		p6Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p6Add.add(lbDateBorrow);
		p6Add.add(inputDateBorrowAdd);
		
		p7Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
		p7Add.add(lbMoneyBook);
		p7Add.add(inputMoneyBook);
	
		DTOPunish punish[] = bus.takeColumAdd();
		String colum[] = new String[punish.length];
		for(int i = 0;i <colum.length;++i) {
			colum[i] = punish[i].namePunish;
		}
	       
		model = new DefaultTableModel(dataAdd,colum);
		JTabelAdd = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                    	return Boolean.class;
                    case 2:
                    	return Boolean.class;
                    case 3:
                    	return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        	
		};
		
		JTabelAdd.setRowHeight(30);
		JTabelAdd.setFillsViewportHeight(true);
		JTableHeader header = JTabelAdd.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		JTabelAdd.setTableHeader(header);
		JTabelAdd.setSelectionForeground(Color.white);
		JTabelAdd.setSelectionBackground(Color.decode("#28b928"));
		JTabelAdd.setGridColor(Color.white);
		JTabelAdd.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		JTabelAdd.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		JScrollPane scrollPane = new JScrollPane(JTabelAdd);
		east.add(scrollPane, BorderLayout.CENTER);
		east.setBackground(Color.white);
	}
	
	public void resetFormAdd() {
		inputIDBorrowAdd.setText("");
		inputDateExpiryAdd.setText("");
		inputPunishMoneyAdd.setText("");
		inputDateBorrowAdd.setText("");
		inputMoneyBook.setText("");
	}
	
	public void eventBtnLoadAdd() {
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputPunishMoneyAdd.setText("");
				if(bus.checkBillLentForBP(inputIDBorrowAdd.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBorrowAdd, "Bill Lent no valid");
					resetFormAdd();
					DTOPunish punish[] = bus.takeColumAdd();
					String colum[] = new String[punish.length];
					for(int i = 0;i <colum.length;++i) {
						colum[i] = punish[i].namePunish;
					}
					dataAdd = null;
					model = new DefaultTableModel(dataAdd,colum);
					JTabelAdd.setModel(model);
					return;
				}
				loadBooksAdd();
			}
		});
		
	}
	
	public void loadBooksAdd() {
		String IDBorrow = inputIDBorrowAdd.getText();
		DTOPunish punish[] = bus.takeColumAdd();
		String colum[] = new String[punish.length];
		for(int i = 0;i <colum.length;++i) {
			colum[i] = punish[i].namePunish;
		}
		dataAdd = bus.takeBookRent(IDBorrow);
		model = new DefaultTableModel(dataAdd,colum);
		JTabelAdd.setModel(model);
		BUSBillLent busBL = new BUSBillLent();
		String []informationBL = busBL.findIDBillLent(IDBorrow);
		inputDateExpiryAdd.setText(informationBL[2]);
		inputDateBorrowAdd.setText(informationBL[1]);
	}
	
	public void guiSelectBL(){
		panel.setVisible(false);
		panel.removeAll();
		panel.setBounds(0, 0, 986, 500);
		panel.setLayout(new BorderLayout());
		north.removeAll();
		center.removeAll();
		
		north.setPreferredSize(new Dimension(980, 60));
		north.setLayout(new FlowLayout(FlowLayout.CENTER, 30 , 10));
		
		panel.setBackground(Color.white);
		north.setBackground(Color.white);
		center.setBackground(Color.white);
		
		panel.add(north,BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		
		panel.setVisible(true);
		
		JLabel lbFind = new JLabel("Find Bill Lent");
		lbFind.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputFindAdd.setPreferredSize(new Dimension(280,35));
		
		String caseBL[] = {"UnPaid"};
		cbbFilterAdd = new JComboBox(caseBL);
		cbbFilterAdd.setPreferredSize(new Dimension(100, 35));
		btnFindIDReaderAdd.setPreferredSize(new Dimension(140, 35));
		btnBackAdd.setPreferredSize(new Dimension(80, 35));
		btnSelectAdd.setPreferredSize(new Dimension(80, 35));
		
		north.add(lbFind);
		north.add(inputFindAdd);
		north.add(btnFindIDReaderAdd);
		north.add(cbbFilterAdd);
		north.add(btnSelectAdd);
		north.add(btnBackAdd);
		
		cbbFilterAdd.setBackground(Color.white);
		cbbFilterAdd.setFocusable(false);
		
		btnFindIDReaderAdd.setForeground(Color.white);
		btnSelectAdd.setForeground(Color.white);
		btnBackAdd.setForeground(Color.white);
		
		btnFindIDReaderAdd.setFocusable(false);
		btnSelectAdd.setFocusable(false);
		btnBackAdd.setFocusable(false);
		
		btnFindIDReaderAdd.setBackground(Color.decode("#ff0000"));
		btnSelectAdd.setBackground(Color.decode("#1a89cc"));
		btnBackAdd.setBackground(Color.decode("#f7941e"));
		
		BUSBillLent busBL = new BUSBillLent();
		
		String colum[] = {"ID Bill","Date Make","Date Expiry","Reader","Status","List Books"};
		dataSelectBL = busBL.loadAllBillLentNoPay();
		
		model = new DefaultTableModel(dataSelectBL,colum);
		
		tableSelectBL.setModel(model);
		
		tableSelectBL.setRowHeight(30);
		tableSelectBL.setFillsViewportHeight(true);
		JTableHeader header = tableSelectBL.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableSelectBL.setTableHeader(header);
		tableSelectBL.setSelectionForeground(Color.white);
		tableSelectBL.setSelectionBackground(Color.decode("#28b928"));
		tableSelectBL.setGridColor(Color.white);
		tableSelectBL.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableSelectBL.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableSelectBL.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableSelectBL.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableSelectBL.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableSelectBL.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableSelectBL.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableSelectBL.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		JScrollPane tableScrollUpdate = new JScrollPane(tableSelectBL);
		
		center.setLayout(new BorderLayout());
		
		center.add(tableScrollUpdate,BorderLayout.CENTER);
		
	}
	
	public void eventBtnFindIDReaderAdd() {
		btnFindIDReaderAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBillLent busBL = new BUSBillLent();
				String IDReader = inputFindAdd.getText();
				if(busBL.checkIDReader(IDReader) == false) return;
				String status = (String)cbbFilterAdd.getItemAt(cbbFilterAdd.getSelectedIndex());
				if(IDReader.equals("") == true) return;
				dataSelectBL = busBL.findFollowReader(IDReader, status);
				String colum[] = {"ID Bill","Date Make","Date Expiry","Reader","Status","List Books"};
				model = new DefaultTableModel(dataSelectBL,colum);
				tableSelectBL.setModel(model);
			}
		});
	}
	
	public void eventBtnSelectBLAdd() {
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiSelectBL();
			}
		});
	}
	
	public void eventBackSelectBLAdd() {
		btnBackAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				guiAddBillPay();
				panel.setVisible(true);
			}
		});
	}
	
	public void eventBtnChooseBLAdd() {
		btnSelectAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableSelectBL.getSelectedRow();
				if(row == -1) return;
				String ID = (String) tableSelectBL.getValueAt(row, 0);
				String dateMake = (String) tableSelectBL.getValueAt(row, 1);
				String dateExpiry = (String) tableSelectBL.getValueAt(row, 2);
				inputIDBorrowAdd.setText(ID);
				inputDateExpiryAdd.setText(dateExpiry);
				inputDateBorrowAdd.setText(dateMake);
				loadBooksAdd();
				inputPunishMoneyAdd.setText("");
			}
		});
	}
	
	public int calculateDate() {
		String ExpiryDate[] = inputDateExpiryAdd.getText().split("-");
		String PayDate[] = inputDatePayAdd.getText().split("-");
		
		int YearE = Integer.parseInt(ExpiryDate[0]);
		int MonthE = Integer.parseInt(ExpiryDate[1]);
		int DateE = Integer.parseInt(ExpiryDate[2]);
		
		int YearP = Integer.parseInt(PayDate[0]);
		int MonthP = Integer.parseInt(PayDate[1]);
		int DateP = Integer.parseInt(PayDate[2]);
		
		int numberDateLate = (YearP - YearE)*365 + (MonthP-MonthE)*30 + (DateP-DateE);
		if(numberDateLate<=0) return 0;
		else return numberDateLate;
	}
	
	public int calculateDateUpdate() {
		
		String ExpiryDate[] = bus.getDateExpridayBL(this.inputIDBillLentUpdate.getText()).split("-");
		String PayDate[] = inputDatePayUpdate.getText().split("-");
		
		int YearE = Integer.parseInt(ExpiryDate[0]);
		int MonthE = Integer.parseInt(ExpiryDate[1]);
		int DateE = Integer.parseInt(ExpiryDate[2]);
		
		int YearP = Integer.parseInt(PayDate[0]);
		int MonthP = Integer.parseInt(PayDate[1]);
		int DateP = Integer.parseInt(PayDate[2]);
		
		int numberDateLate = (YearP - YearE)*365 + (MonthP-MonthE)*30 + (DateP-DateE);
		if(numberDateLate<0) return 0;
		else return numberDateLate;
	}
	
	public int findIndexPunish(DTOPunish punish[], String namePunish) {
		for(int i = 1 ;i < punish.length; ++i) {
			if(punish[i].namePunish.equals(namePunish)) return i;
			
		}
		return -1;
	}
	
	public void eventCalculate() {
		Btncalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputIDBorrowAdd.getText().equals("") == true) return;
				if(inputDateExpiryAdd.getText().equals("") == true) return;
				if(inputDateBorrowAdd.getText().equals("") == true) return;
				if(dataAdd == null) return;
				
				
				DTOPunish punish[] = bus.takeColumAdd();
				String colum[] = new String[punish.length];
				
				for(int i = 0;i <colum.length;++i) {
					colum[i] = punish[i].namePunish;
				}
				
				int amountRow = dataAdd.length;
				double money = 0;
				
				dataPunishBook = new String[amountRow][colum.length];
				
				//findIndexPunish
				for(int i = 0 ;i <amountRow; ++i) {
					int check = 0;
					boolean caseLose = false;
					dataPunishBook[i][0] = (String)JTabelAdd.getValueAt(i, 0);
					for(int j = 1 ; j<colum.length ; j++) {
						boolean isPunish = (boolean)JTabelAdd.getValueAt(i, j);
						
						int indexPunish = findIndexPunish(punish,colum[j]);
						
						if(punish[j].namePunish.equals("late") && isPunish == true && calculateDate()<=0) {
							continue;
						}
						
						if(isPunish == true) {
							dataPunishBook[i][j] = Integer.toString(punish[indexPunish].IDPunish);
						}
						
						if(punish[indexPunish].namePunish.equals("lose") && isPunish == true) {
							caseLose = true;
						}
						
						if(punish[j].namePunish.equals("late") && isPunish == true) {
							money+= calculateDate()*punish[j].moneyPunish;
							check++;
							continue;
						}
						
						if(isPunish == true && punish[indexPunish].moneyPunish<=1) {
							double price = bus.takePrice(dataAdd[i][0].toString());
							money+= punish[indexPunish].moneyPunish * price;
							check++;
						}
						
						if(isPunish == true && punish[indexPunish].moneyPunish>1) {
							money+= punish[indexPunish].moneyPunish;
							check++;
						}
					}

					if(caseLose == true && check>1) {
						inputPunishMoneyAdd.setText("");
						JOptionPane.showMessageDialog(JTabelAdd, "Not choose error lose along error others");
						return;
					}
				}
				for(int i = 0;i<amountRow;++i) {
					for(int j = 0 ;j<colum.length;++j) {
						System.out.print(dataPunishBook[i][j] + " ");
					}
					System.out.println();
				}
				int rent = dataPunishBook.length*bus.calculateRent(inputDateBorrowAdd.getText(), inputDatePayAdd.getText())*1000;
				inputMoneyBook.setText(Integer.toString(rent));
				inputPunishMoneyAdd.setText(Double.toString(money));
			}
		});
	}
	
	public void calculateUpdate() {
		
		DTOPunish punish[] = bus.takeColumAdd();
		String colum[] = new String[punish.length];
		
		for(int i = 0;i <colum.length;++i) {
			colum[i] = punish[i].namePunish;
		}
		if(dataUpdate == null) return;
		int amountRow = dataUpdate.length;
		
		double money = 0;
		dataPunishBook = new String[amountRow][colum.length];
		System.out.println("number row:" + amountRow);
		System.out.println("value row:" + tableUpdate.getValueAt(0, 0));
		
		for(int i = 0 ;i <amountRow; ++i) {
			int check = 0;
			boolean caseLose = false;
			dataPunishBook[i][0] = tableUpdate.getValueAt(i, 0).toString();
			for(int j = 1 ; j<colum.length ; j++) {
				boolean isPunish = (boolean)tableUpdate.getValueAt(i, j);
				
				int indexPunish = findIndexPunish(punish,colum[j]);
				
				if(punish[j].namePunish.equals("late") && isPunish == true && calculateDateUpdate()<=0) {
					continue;
				}
				
				if(isPunish == true) {
					dataPunishBook[i][j] = Integer.toString(punish[indexPunish].IDPunish);
				}
				
				if(punish[indexPunish].namePunish.equals("lose") && isPunish == true) {
					caseLose = true;
				}
				
				if(punish[j].namePunish.equals("late") && isPunish == true) {
					money+= calculateDateUpdate()*punish[j].moneyPunish;
					check++;
					continue;
				}
				
				if(isPunish == true && punish[indexPunish].moneyPunish<=1) {
					double price = bus.takePrice(dataUpdate[i][0].toString());
					money+= punish[indexPunish].moneyPunish * price;
					check++;
				}
				
				if(isPunish == true && punish[indexPunish].moneyPunish>1) {
					money+= punish[indexPunish].moneyPunish;
					check++;
				}
			}

			if(caseLose == true && check>1) {
				inputMoneyUpdate.setText("");
				JOptionPane.showMessageDialog(tableUpdate, "Not choose error lose along error others");
				return;
			}
		}
		for(int i = 0;i<amountRow;++i) {
			for(int j = 0 ;j<colum.length;++j) {
				System.out.print(dataPunishBook[i][j] + " ");
			}
			System.out.println();
		}
		inputMoneyUpdate.setText(Double.toString(money));
	}
	

	public void eventCreateBL() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusBillPay bus = new BusBillPay();
				DTOPunish punish[] = bus.takeColumAdd();
				String colum[] = new String[punish.length];
				for(int i = 0;i <colum.length;++i) {
					colum[i] = punish[i].namePunish;
				}
				String dateMake = inputDateBorrowAdd.getText();
				String dateExpiry = inputDateExpiryAdd.getText();
//				dataPunishBook
				if(bus.checkIDBillPay(inputPunishMoneyAdd.getText(),inputIDBorrowAdd.getText(),dateMake,dateExpiry) == false) {
					JOptionPane.showMessageDialog(inputIDBorrowAdd, "information not valid");
					dataAdd = null;
					model = new DefaultTableModel(dataAdd,colum);
					JTabelAdd.setModel(model);
					resetFormAdd();
					return;
				}else if(bus.checkMixIDBorrow(dataAdd, inputIDBorrowAdd.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBorrowAdd, "ID Borrow not valid");
					dataAdd = null;
					model = new DefaultTableModel(dataAdd,colum);
					JTabelAdd.setModel(model);
					resetFormAdd();
					return;
				}else {
					bus.insertBP(inputIDBorrowAdd.getText(), inputDatePayAdd.getText(), inputPunishMoneyAdd.getText(),inputMoneyBook.getText(), dataPunishBook,colum.length);
					JOptionPane.showMessageDialog(inputIDBorrowAdd, "Success");
					dataAdd = null;
					model = new DefaultTableModel(dataAdd,colum);
					JTabelAdd.setModel(model);
					resetFormAdd();
				}
				
			}
		});
	}
	
	public void guiUpdate() {
		panel.setBounds(0, 0, 986, 500);
		panel.removeAll();
		
		p1Update.removeAll();
		p2Update.removeAll();
		p3Update.removeAll();
		p4Update.removeAll();
		p5Update.removeAll();
		p6Update.removeAll();
		
		p1Update.setBackground(Color.white);
		p2Update.setBackground(Color.white);
		p3Update.setBackground(Color.white);
		p4Update.setBackground(Color.white);
		p5Update.setBackground(Color.white);
		p6Update.setBackground(Color.white);
		west.setBackground(Color.white);
		panel.setBackground(Color.white);
		
		panel.setLayout(new BorderLayout());
		
		west.removeAll();
		east.removeAll();
		
		west.setPreferredSize(new Dimension(430, 450));
		east.setPreferredSize(new Dimension(550, 450));
		
		panel.add(west, BorderLayout.WEST);
		panel.add(east, BorderLayout.EAST);
	
		west.setLayout(new GridLayout(8,1));
		west.add(p1Update);
		west.add(p2Update);
		west.add(p3Update);
		west.add(p4Update);
		west.add(p5Update);
		west.add(p6Update);
		
		east.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Update Bill Pay");
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		p1Update.add(title);
		p1Update.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		
		JLabel lbIDBillPay = new JLabel("ID Bill Pay");
		lbIDBillPay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		lbIDBillPay.setPreferredSize(new Dimension(90, 30));
		
		inputIDBillPayUpdate.setPreferredSize(new Dimension(220,30));
		chooseBillPay.setPreferredSize(new Dimension(63,30));
		
		p2Update.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		p2Update.add(lbIDBillPay);
		p2Update.add(inputIDBillPayUpdate);
		p2Update.add(chooseBillPay);
	
		JLabel lbIDBillLent = new JLabel("ID Bill Lent");
		lbIDBillLent.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbIDBillLent.setPreferredSize(new Dimension(90, 30));
		
		inputIDBillLentUpdate.setPreferredSize(new Dimension(300, 30));
		inputIDBillLentUpdate.setEditable(false);
		
		p3Update.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		p3Update.add(lbIDBillLent);
		p3Update.add(inputIDBillLentUpdate);
		
		JLabel lbDatePay = new JLabel("Date Pay");
		lbDatePay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbDatePay.setPreferredSize(new Dimension(90, 30));
		
		inputDatePayUpdate.setEnabled(false);
		inputDatePayUpdate.setPreferredSize(new Dimension(300, 30));
		
		p4Update.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		p4Update.add(lbDatePay);
		p4Update.add(inputDatePayUpdate);
		
		JLabel lbMoney = new JLabel("Money ");
		lbMoney.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		lbMoney.setPreferredSize(new Dimension(90, 30));
		
		inputMoneyUpdate.setPreferredSize(new Dimension(300, 30));
		inputMoneyUpdate.setEnabled(false);
		
		p5Update.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		p5Update.add(lbMoney);
		p5Update.add(inputMoneyUpdate);
		
		p6Update.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
		btnUpdate.setPreferredSize(new Dimension(120, 30));
		btnCalculateUpdate.setPreferredSize(new Dimension(120, 30));
		p6Update.add(btnUpdate);
		p6Update.add(btnCalculateUpdate);
		
		btnUpdate.setForeground(Color.white);
		btnCalculateUpdate.setForeground(Color.white);
		chooseBillPay.setForeground(Color.white);
		
		btnUpdate.setBackground(Color.decode("#ff0000"));
		btnCalculateUpdate.setBackground(Color.decode("#1a89cc"));
		chooseBillPay.setBackground(Color.decode("#f7941e"));
		
		btnUpdate.setFocusable(false);
		btnCalculateUpdate.setFocusable(false);
		chooseBillPay.setFocusable(false);
		
		DTOPunish punish[] = bus.takeColumAdd();
		
		String colum[] = new String[punish.length];
		
		for(int i = 0;i <colum.length;++i) {
			colum[i] = punish[i].namePunish;
		}
	       
		model = new DefaultTableModel(dataUpdate,colum);
		tableUpdate = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                    	return Boolean.class;
                    case 2:
                    	return Boolean.class;
                    case 3:
                    	return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        	
		};
		
		tableUpdate.setRowHeight(30);
		tableUpdate.setFillsViewportHeight(true);
		JTableHeader header = tableUpdate.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableUpdate.setTableHeader(header);
		tableUpdate.setSelectionForeground(Color.white);
		tableUpdate.setSelectionBackground(Color.decode("#28b928"));
		tableUpdate.setGridColor(Color.white);
		tableUpdate.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableUpdate.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableUpdate.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(tableUpdate);
		
		east.setBackground(Color.white);
		
		east.add(tableScroll, BorderLayout.CENTER);
	}
	
	public void eventChooseBillPay() {
		chooseBillPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiSelectBillPay();
			}
		});
	}
	
	public void guiSelectBillPay() {
		
		panel.setVisible(false);
		panel.setBounds(0, 0, 986, 500);
		
		panel.removeAll();
		north.removeAll();
		center.removeAll();
	
		panel.setLayout(new BorderLayout());
		
		panel.setBackground(Color.white);
		north.setBackground(Color.white);
		center.setBackground(Color.white);
		
		north.setPreferredSize(new Dimension(986, 60));
//		north.setBackground(Color.black);
		
		center.setLayout(new BorderLayout());
		
		JLabel lbFind = new JLabel("Find Bill Pay");
		lbFind.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
		
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		inputFindUpdate.setPreferredSize(new Dimension(300, 30));
		
		findIDBillLentUpdate.setPreferredSize(new Dimension(140, 30));
		
		findIDReaderUpdate.setPreferredSize(new Dimension(135, 30));
		
		selectBillPayUpdate.setPreferredSize(new Dimension(80, 30));
		
		btnBack.setPreferredSize(new Dimension(80, 30));
		
		north.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		north.add(lbFind);
		north.add(inputFindUpdate);
		north.add(findIDBillLentUpdate);
		north.add(findIDReaderUpdate);
		north.add(selectBillPayUpdate);
		north.add(btnBack);
		
		findIDBillLentUpdate.setForeground(Color.white);
		findIDReaderUpdate.setForeground(Color.white);
		selectBillPayUpdate.setForeground(Color.white);
		btnBack.setForeground(Color.white);
		
		findIDBillLentUpdate.setBackground(Color.decode("#ff0000"));
		findIDReaderUpdate.setBackground(Color.decode("#1a89cc"));
		selectBillPayUpdate.setBackground(Color.decode("#803ec0"));
		btnBack.setBackground(Color.decode("#f7941e"));
		
		findIDBillLentUpdate.setFocusable(false);
		findIDReaderUpdate.setFocusable(false);
		selectBillPayUpdate.setFocusable(false);
		btnBack.setFocusable(false);
		
		panel.setVisible(true);
		
		String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money punish","Rent"};
		dataSelectBLUpdate = bus.takeAllBillPay();
		model = new DefaultTableModel(dataSelectBLUpdate,colum);
		tableSelectBLUpdate.setModel(model);
		
		tableSelectBLUpdate.setRowHeight(30);
		tableSelectBLUpdate.setFillsViewportHeight(true);
		JTableHeader header = tableSelectBLUpdate.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableSelectBLUpdate.setTableHeader(header);
		tableSelectBLUpdate.setSelectionForeground(Color.white);
		tableSelectBLUpdate.setSelectionBackground(Color.decode("#28b928"));
		tableSelectBLUpdate.setGridColor(Color.white);
		tableSelectBLUpdate.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableSelectBLUpdate.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableSelectBLUpdate.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableSelectBLUpdate.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableSelectBLUpdate.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableSelectBLUpdate.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableSelectBLUpdate.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableSelectBLUpdate.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		
		JScrollPane tableScroll = new JScrollPane(tableSelectBLUpdate);
		center.add(tableScroll, BorderLayout.CENTER);
		//btnBack,findIDBillLentUpdate,findIDReaderUpdate,inputFindUpdate,tableSelectBLUpdate
	}
	
	public void eventBtnUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dataPunishBook == null) {
					JOptionPane.showMessageDialog(inputIDBillPayUpdate, "You not calculate");
					return;
				}
				String IDBP = inputIDBillPayUpdate.getText();
				BusBillPay bus = new BusBillPay();
				if(bus.checkIDBillPayExist(IDBP) == false) {
					JOptionPane.showMessageDialog(inputIDBillPayUpdate, "ID Bill Pay not valid");
					return;
				}
				
				String IDBL = inputIDBillLentUpdate.getText();
				String IDBLOld = bus.getIDBL(IDBP);
				if(bus.checkBillLentForBP(IDBL) == false && IDBL.equals(IDBLOld) == false) {
					JOptionPane.showMessageDialog(inputIDBillPayUpdate, "ID Bill Lent not valid");
					return;
				}
				
				//check money
				
				if(bus.checkMoneyUpdate(inputMoneyUpdate.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBillPayUpdate, "Money not valid");
					return;
				}
				
				DTOPunish punish[] = bus.takeColumAdd();
				bus.update(IDBP, IDBL, IDBLOld,inputMoneyUpdate.getText() , dataPunishBook, punish.length);
				JOptionPane.showMessageDialog(inputIDBillPayUpdate, "Update Ok");
				//inputIDBillPayUpdate,	inputIDBillLentUpdate,inputIDBillLentUpdate,inputMoneyUpdate
				inputIDBillPayUpdate.setText("");
				inputIDBillLentUpdate.setText("");
				inputDatePayUpdate.setText("");
				inputMoneyUpdate.setText("");
				
				String colum[] = new String[punish.length];
				
				for(int i = 0;i <colum.length;++i) {
					colum[i] = punish[i].namePunish;
				}
				dataUpdate = null;
				model = new DefaultTableModel(dataUpdate,colum);
				tableUpdate.setModel(model);
			}
		});
	}
	
	public void btnBackUpdate() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				guiUpdate();
				panel.setVisible(true);
			}
		});
	}
	
	public void eventSelectBPUpdate() {
		selectBillPayUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableSelectBLUpdate.getSelectedRow();
				if(row<0) return;
				inputIDBillPayUpdate.setText((String)tableSelectBLUpdate.getValueAt(row,0));
				inputIDBillLentUpdate.setText((String)tableSelectBLUpdate.getValueAt(row,1));
				inputDatePayUpdate.setText((String)tableSelectBLUpdate.getValueAt(row,3));
				inputMoneyUpdate.setText((String)tableSelectBLUpdate.getValueAt(row,4));
				
				DTOPunish punish[] = bus.takeColumAdd();
				
				String colum[] = new String[punish.length];
				
				for(int i = 0;i <colum.length;++i) {
					colum[i] = punish[i].namePunish;
				}
				
				dataUpdate = bus.takeBookUpadate(inputIDBillPayUpdate.getText());
			       
				model = new DefaultTableModel(dataUpdate,colum);
				
				tableUpdate.setModel(model);
			}
		});
	}
	
//	loadDateUpdate
	
	public void evetnBtnLoadDataUpdate() {
		loadDateUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DTOPunish punish[] = bus.takeColumAdd();
				
				String colum[] = new String[punish.length];
				
				for(int i = 0;i <colum.length;++i) {
					colum[i] = punish[i].namePunish;
				}
				
				dataUpdate = bus.takeBookUpadate(inputIDBillPayUpdate.getText());
			       
				model = new DefaultTableModel(dataUpdate,colum);
				
				tableUpdate.setModel(model);
			}
		});
	}
	
	
	public void eventFindIDBLUpdate() {
		findIDBillLentUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindUpdate.getText();
				BusBillPay bus = new BusBillPay();
				String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money punish","Rent"};
				if(bus.checkBillLent(ID) == false) { 
					dataSelectBLUpdate = null;
					model = new DefaultTableModel(dataSelectBLUpdate,colum);
					tableSelectBLUpdate.setModel(model);
					return;
				}else {
					dataSelectBLUpdate = bus.findIDBillLent(ID);
					model = new DefaultTableModel(dataSelectBLUpdate,colum);
					tableSelectBLUpdate.setModel(model);
				}
			}
		});
	}
	
	public void eventFindIDReaderUpdate() {
		findIDReaderUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindUpdate.getText();
				BUSBillLent busBL = new BUSBillLent();
				String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money punish","Rent"};
				if(busBL.checkIDReader(ID) == false) { 
					dataSelectBLUpdate = null;
					model = new DefaultTableModel(dataSelectBLUpdate,colum);
					tableSelectBLUpdate.setModel(model);
					return;
				}else {
					dataSelectBLUpdate = bus.findIDReader(ID);
					model = new DefaultTableModel(dataSelectBLUpdate,colum);
					tableSelectBLUpdate.setModel(model);
				}
			}
		});
	}
	
	public void eventBtnCalculateUpdate() {
		btnCalculateUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateUpdate();
			}
		});
		
		
	}
	
	public void guiClear() {
		panel.setBounds(0, 0, 986, 500);
		panel.removeAll();
		north.removeAll();
		center.removeAll();
		
		north.setBackground(Color.white);
		center.setBackground(Color.white);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		//inputIDBPClear,btnClear,btnChooseClear
		
		JLabel title = new JLabel("Clear Bill Pay (ID)");
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
		
		inputIDBPClear.setPreferredSize(new Dimension(300,30));
		
		btnClear.setPreferredSize(new Dimension(80,30));
		
		btnChooseClear.setPreferredSize(new Dimension(80,30));
		
		north.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		north.setPreferredSize(new Dimension(986,70));
		north.add(title);
		north.add(inputIDBPClear);
		north.add(btnClear);
		north.add(btnChooseClear);
		
		center.setLayout(null);
		
		JLabel lbFind = new JLabel("Find Bill Pay");
		lbFind.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		lbFind.setBounds(50, 40, 100, 30);
		
		inputFindClear.setPreferredSize(new Dimension(300, 30));
		inputFindClear.setBounds(150, 42, 400, 30);
		
		btnFindIDBLClear.setPreferredSize(new Dimension(80, 30));
		btnFindIDBLClear.setBounds(570, 42, 150, 30);
		
		btnFindIDReaderClear.setPreferredSize(new Dimension(80, 30));
		btnFindIDReaderClear.setBounds(740, 42, 150, 30);
		
		btnClear.setForeground(Color.white);
		btnChooseClear.setForeground(Color.white);
		btnFindIDBLClear.setForeground(Color.white);
		btnFindIDReaderClear.setForeground(Color.white);
		
		btnClear.setBackground(Color.decode("#ff0000"));
		btnChooseClear.setBackground(Color.decode("#1a89cc"));
		btnFindIDBLClear.setBackground(Color.decode("#f7941e"));
		btnFindIDReaderClear.setBackground(Color.decode("#803ec0"));
		
		btnClear.setFocusable(false);
		btnChooseClear.setFocusable(false);
		btnFindIDBLClear.setFocusable(false);
		btnFindIDReaderClear.setFocusable(false);
		
		
		String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money Punish", "Rent"};
		
		dataBillPay = bus.takeAllBillPay();
		
		model = new DefaultTableModel(dataBillPay,colum);
				
		tableFindClear.setModel(model);
		
		tableFindClear.setRowHeight(25);
		tableFindClear.setFillsViewportHeight(true);
		JTableHeader header = tableFindClear.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableFindClear.setTableHeader(header);
		tableFindClear.setSelectionForeground(Color.white);
		tableFindClear.setSelectionBackground(Color.decode("#28b928"));
		tableFindClear.setGridColor(Color.white);
		tableFindClear.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableFindClear.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableFindClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableFindClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableFindClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableFindClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableFindClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableFindClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		JScrollPane tableScrollClear = new JScrollPane(tableFindClear);
		
		tableScrollClear.setBounds(0, 100, 986, 250);
		
		center.add(tableScrollClear);
		center.add(lbFind);
		center.add(inputFindClear);
		center.add(btnFindIDBLClear);
		center.add(btnFindIDReaderClear);
		//inputFindClear,tableFindClear,btnFindIDBLClear,btnFindIDReaderClear
	}
	
	public void eventBtnChoose() {
		btnChooseClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =  tableFindClear.getSelectedRow();
				if(row < 0) return;
				String ID = (String) tableFindClear.getValueAt(row, 0);
				inputIDBPClear.setText(ID);
			}
		});
	}
	
	public void eventBtnFindIDBLClear() {
		btnFindIDBLClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDBL = inputFindClear.getText();
				BusBillPay bus = new BusBillPay();
				String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money Punish", "Rent"};
				if(bus.checkBillLent(IDBL) == false) {
					
					dataBillPay = null;
					
					model = new DefaultTableModel(dataBillPay,colum);
							
					tableFindClear.setModel(model);
					return;
				}
				
				dataBillPay = bus.findIDBillLent(IDBL);
				
				
				
				model = new DefaultTableModel(dataBillPay,colum);
							
				tableFindClear.setModel(model);
				
				
			}
		});
	}
	
	public void eventBtnFindIDReaderClear() {
		btnFindIDReaderClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDReader = inputFindClear.getText();
				BusBillPay bus = new BusBillPay();
				BUSBillLent busBL = new BUSBillLent();
				String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money Punish", "Rent"};
				if(busBL.checkIDReader(IDReader) == false) {
					
					dataBillPay = null;
					
					model = new DefaultTableModel(dataBillPay,colum);
							
					tableFindClear.setModel(model);
					return;
				}
				
				dataBillPay = bus.findIDReader(IDReader);
				
				model = new DefaultTableModel(dataBillPay,colum);
							
				tableFindClear.setModel(model);
				
				
			}
		});
	}
	
	public void eventBtnClear() {
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputIDBPClear.getText();
				BusBillPay bus = new BusBillPay();
				if(bus.checkIDBillPayExist(ID) == false) {
					JOptionPane.showMessageDialog(inputIDBPClear, "Clear Fail");
					return;
				
				}
				else { 
					bus.clear(ID);
					JOptionPane.showMessageDialog(inputIDBPClear, "Clear Success");
					inputIDBPClear.setText("");
					String colum[] = {"ID Bill","ID Borrow","ID Reader","Date Pay","Money Punish", "Rent"};
					
					dataBillPay = bus.takeAllBillPay();
					
					model = new DefaultTableModel(dataBillPay,colum);
							
					tableFindClear.setModel(model);
				}
			}
		});
	}
	
	public void guiFind() {
		panel.setBounds(0, 0, 986, 450);
//		panel.setBackground(Color.red);
		
		panel.removeAll();
		north.removeAll();
		center.removeAll();
		
		panel.setBackground(Color.white);
		north.setBackground(Color.white);
		center.setBackground(Color.white);
		
		panel.setLayout(new BorderLayout());
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		center.setLayout(new BorderLayout());
		
		JLabel lbFind = new JLabel("Find detail");
		lbFind.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 18));
		
		inputFindF.setPreferredSize(new Dimension(300, 30));
		btnFindIDReaderF.setPreferredSize(new Dimension(150, 30));
		btnFindIDBLF.setPreferredSize(new Dimension(150, 30));
		btnFindIDBPF.setPreferredSize(new Dimension(150, 30));
		
		north.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		north.add(lbFind);
		north.add(inputFindF);
		north.add(btnFindIDBPF);
		north.add(btnFindIDReaderF);
		north.add(btnFindIDBLF);
		
		btnFindIDBPF.setForeground(Color.white);
		btnFindIDReaderF.setForeground(Color.white);
		btnFindIDBLF.setForeground(Color.white);
		
		btnFindIDBPF.setFocusable(false);
		btnFindIDReaderF.setFocusable(false);
		btnFindIDBLF.setFocusable(false);
		
		btnFindIDBPF.setBackground(Color.decode("#ff0000"));
		btnFindIDReaderF.setBackground(Color.decode("#1a89cc"));
		btnFindIDBLF.setBackground(Color.decode("#f7941e"));
		
		
		String colum[] = {"ID Bill","ID Book","Name Book","Name Punish","Money Punish"};
		dataF = bus.loadAllBPMenuFind();
		model = new DefaultTableModel(dataF,colum);
		TableF.setModel(model);
		
		TableF.setRowHeight(30);
		TableF.setFillsViewportHeight(true);
		JTableHeader header = TableF.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		TableF.setTableHeader(header);
		TableF.setSelectionForeground(Color.white);
		TableF.setSelectionBackground(Color.decode("#28b928"));
		TableF.setGridColor(Color.white);
		TableF.setFocusable(false);
		

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableF.getColumnModel().getColumn(0).setPreferredWidth(0);
		TableF.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		TableF.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		TableF.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		TableF.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		TableF.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(TableF);
		
		center.add(tableScroll, BorderLayout.CENTER);
		
		//inputFindF,btnFindIDReaderF,btnFindIDBLF,TableF,dataF
		
	}
	
	public void eventFindIDBLMenuF() {
		btnFindIDBLF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindF.getText();
				BusBillPay bus = new BusBillPay();
				String colum[] = {"ID Bill","ID Book","Name Book","Name Punish","Money Punish"};
				if(bus.checkBillLent(ID)== false) {
					dataF = null;
					model = new DefaultTableModel(dataF,colum);
					TableF.setModel(model);
					return;
				}
				dataF = bus.findDetailBPFollowBL(ID);
				model = new DefaultTableModel(dataF,colum);
				TableF.setModel(model);
			}
		});
	}
	
	public void eventFindIDBPMenuF() {
		btnFindIDBPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindF.getText();
				BusBillPay bus = new BusBillPay();
				String colum[] = {"ID Bill","ID Book","Name Book","Name Punish","Money Punish"};
				if(bus.checkIDBillPayExist(ID)== false) {
					dataF = null;
					model = new DefaultTableModel(dataF,colum);
					TableF.setModel(model);
					return;
				}
				dataF = bus.findDetailBPFollowBP(ID);
				model = new DefaultTableModel(dataF,colum);
				TableF.setModel(model);
			}
		});
	}
	
	public void eventFindIDReaderMenuF() {
		btnFindIDReaderF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindF.getText();
				BusBillPay bus = new BusBillPay();
				BUSBillLent busBL = new BUSBillLent();
				String colum[] = {"ID Bill","ID Book","Name Book","Name Punish","Money Punish"};
				if(busBL.checkIDReader(ID)== false) {
					dataF = null;
					model = new DefaultTableModel(dataF,colum);
					TableF.setModel(model);
					return;
				}
				dataF = bus.findDetailBPFollowReader(ID);
				model = new DefaultTableModel(dataF,colum);
				TableF.setModel(model);
			}
		});
	}
	
	public void eventBtn() {
		eventBtnLoadAdd();
		eventBtnSelectBLAdd();
		eventBackSelectBLAdd();
		eventBtnChooseBLAdd();
		eventCalculate();
		eventCreateBL();
		eventBtnFindIDReaderAdd();
		eventChooseBillPay();
		eventFindIDBLUpdate();
		eventFindIDReaderUpdate();
		btnBackUpdate();
		eventSelectBPUpdate();
		eventBtnUpdate();
		eventBtnCalculateUpdate();
		eventBtnFindIDBLClear();
		eventBtnFindIDReaderClear();
		eventBtnChoose();
		eventBtnClear();
		eventFindIDBLMenuF();
		eventFindIDBPMenuF();
		eventFindIDReaderMenuF();
	}
	
	public String getDateCurrent() {
		return java.time.LocalDate.now().toString();
	}
}