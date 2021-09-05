import javax.swing.*;
import javax.swing.JList.DropLocation;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

public class GuiBillLent{
	
	protected JButton menuAdd;
	
	protected JButton menuClear;
	
	protected JButton menuRepair;
	
	protected JButton menuFind;
	
	protected JButton tableBillLent;
	
	protected JPanel panel;
	
	protected JPanel panelNorth;
	
	protected JPanel panelCenter;
	
	protected JPanel panelEast;
	
	protected JPanel panelWest;
	
	protected JPanel p1Add;
	
	protected JPanel p2Add;
	
	protected JPanel p3Add;
	
	protected JPanel p4Add;
	
	protected JPanel p5Add;
	
	protected JPanel p6Add;
	
	protected JTextField inputIDReaderAdd;
	
	protected JTextField inputDateMakeAdd;
	
	protected JTextField inputDateExpiryAdd;
	
	protected JTextField inputStatusAdd;
	
	protected JTextField inputBookAdd;
	
	protected JButton btnAdd;
	
	protected JButton btnCheckIDReaderAdd;
	
	protected JPanel p1Update;

	protected JPanel p2Update;
	
	protected JPanel p3Update;
	
	protected JPanel p4Update;
	
	protected JPanel p5Update;
	
	protected JPanel p6Update;
	
	protected JPanel p7Update;
	
	protected JTextField inputIDBillLentUpdate;
	
	protected JTextField inputIDReaderUpdate;
	
	protected JTextField inputDateBorrowUpdate;
	
	protected JTextField inputDateExpiryUpdate;
	
	protected JTextField inputListBookUpdate;
	
	protected JComboBox cbStatus;
	
	protected JButton selectBillLent;
	
	protected JButton btnUpdate;
	
	protected JButton btnBackUpdate;
	
	protected JButton btnFindIDReaderUpdate;
	
	protected JTextField inputFindUpdate;
	
	protected JComboBox cbbFilterUpdate;
	
	protected JTable tableFilterUpdate;
	
	protected DefaultTableModel modelTabel;
	
	protected JScrollPane tableScrollUpdate;
	
	protected String [][]dataTableUpdate;
	
	protected JButton btnSelectUpdate;
	
	protected JPanel p1Clear;
	
	protected JPanel p2Clear;
	
	protected JTextField inputIDClear;
	
	protected JButton btnClear;
	
	protected JButton btnFindIDReaderF;
	
	protected JButton btnFindIDBLF;
	
	protected JTextField inputFindF;
	
	protected JComboBox cbbStatusBLF;
	
	protected JTable tabelF;
	
	protected DefaultTableModel modelTableF;
	
	protected String[][] dataFindF;
	
	protected String[][] dataClear;	
	
	protected JButton findIDReaderClear;
	
	protected JButton findIDBillPayClear;
	
	protected JButton btnChooseDataClear;
	
	protected JTable tableChooseDataClear;
	
	protected JTextField inputFindClear;
	
	protected BUSBillLent bus;
	
	protected JButton print;
	//findIDReaderClear,findIDBillPayClear,btnChooseDataClear,tableChooseDataClear,inputFindClear
	GuiBillLent(){
		bootButton();
		bootPanel();
		bootComboBox();
		bootTextField();
		bootTable();
		eventCheck();
		eventBtn();
	}
	
	public void bootTable() {
		modelTabel = new DefaultTableModel();
		tableFilterUpdate = new JTable();
		tableScrollUpdate = new JScrollPane();
		tabelF = new JTable();
		modelTableF = new DefaultTableModel();
		tableChooseDataClear = new JTable();
		bus = new BUSBillLent();
	}
	
	public void bootTextField() {
		inputFindClear =  new JTextField();
		
		inputIDReaderAdd = new JTextField();
		
		inputDateMakeAdd = new JTextField();
		
		inputDateExpiryAdd = new JTextField();
		
		inputStatusAdd = new JTextField();
		
		inputBookAdd = new JTextField();
		
		inputIDBillLentUpdate = new JTextField();
		
		inputIDReaderUpdate = new JTextField();
		
		inputDateBorrowUpdate = new JTextField();
		
		inputDateExpiryUpdate = new JTextField();
		
		inputListBookUpdate = new JTextField();
		
		inputFindUpdate = new JTextField();
		
		inputIDClear = new JTextField();
		
		inputFindF = new JTextField();
	}
	
	public void bootButton() {
		
		btnChooseDataClear =   new JButton("Choose");
		
		findIDBillPayClear =  new JButton("Follow ID Bill");
		
		findIDReaderClear =  new JButton("Follow ID Reader");
		
		menuAdd = new JButton("ADD");
		
		menuClear = new JButton("CLEAR");
		
		menuRepair = new JButton("UPDATE");
		
		menuFind = new JButton("FIND");
		
		tableBillLent = new JButton("TABLE DATA");
		
		btnAdd = new JButton("Add");
		
		btnCheckIDReaderAdd = new JButton("Check");
		
		selectBillLent = new JButton("+");
		
		btnUpdate = new JButton("Update");
		
		btnBackUpdate = new JButton("Back");
		
		btnFindIDReaderUpdate = new JButton("Follow ID Reader");
		
		btnSelectUpdate = new JButton("Select");
		
		btnClear = new JButton("Clear");
		
		btnFindIDReaderF = new JButton("Follow ID Reader");
		
		btnFindIDBLF = new JButton("Follow ID Bill");
		
		print = new JButton("Print");
	}
	
	public void bootPanel() {
		panel = new JPanel();
		
		panelNorth = new JPanel();
		
		panelCenter = new JPanel();
		
		panelEast = new JPanel();
		
		panelWest = new JPanel();
		
		p1Add = new JPanel();
		
		p2Add = new JPanel();
		
		p3Add = new JPanel();
		
		p4Add = new JPanel();
		
		p5Add = new JPanel();
		
		p6Add = new JPanel();
		
		p1Update = new JPanel();
		
		p2Update = new JPanel();
		
		p3Update = new JPanel();
		
		p4Update = new JPanel();
		
		p5Update = new JPanel();
		
		p6Update = new JPanel();
		
		p7Update = new JPanel();
		
		p1Clear = new JPanel();
		
		p2Clear = new JPanel();
	}
	
	public void bootComboBox() {
		cbbFilterUpdate = new JComboBox();
		
		cbStatus = new JComboBox();
		
		cbbStatusBLF = new JComboBox();
	}
	
	public void addMenuChild(MyFrame frame) {
		frame.panelTop.add(menuAdd);
		frame.panelTop.add(menuRepair);
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
		decoration(menuRepair);
		decoration(menuFind);
		
	}
	
	public void eventMenuAdd(MyFrame frame) {
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiAddBillLent();
				panel.setVisible(true);
				inputDateMakeAdd.setText(getDateCurrent());
			}
		});	
	}
	
	public void eventMenuUpdate(MyFrame frame) {
		menuRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiUpdateBillLent();
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
				guiClearBL();
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
	
	public void guiAddBillLent() {
		panelCenter.removeAll();
		panelNorth.removeAll();
		panelEast.removeAll();
		p1Add.removeAll();
		p2Add.removeAll();
		p3Add.removeAll();
		p4Add.removeAll();
		p5Add.removeAll();
		panel.setBounds(0, 0, 980, 500);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(980,40));
		
		panelCenter.setBackground(Color.white);
		
		panelEast.setBackground(Color.white);
		panelEast.setPreferredSize(new Dimension(300, 450));
		panelEast.setLayout(null);
		
		panelWest.setBackground(Color.white);
		panelWest.setPreferredSize(new Dimension(200, 450));
		
		panel.add(panelNorth,BorderLayout.NORTH);
		panel.add(panelCenter,BorderLayout.CENTER);
		panel.add(panelEast,BorderLayout.EAST);
		panel.add(panelWest,BorderLayout.WEST);
		
		JLabel title = new JLabel("ADD BILL LENT");
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		panelNorth.add(title);
		
		panelCenter.setLayout(new GridLayout(6,1));
		panelCenter.add(p1Add);
		panelCenter.add(p2Add);
		panelCenter.add(p3Add);
		panelCenter.add(p4Add);
		panelCenter.add(p5Add);
		panelCenter.add(p6Add);
		
		p1Add.setBackground(Color.white);
		p2Add.setBackground(Color.white);
		p3Add.setBackground(Color.white);
		p4Add.setBackground(Color.white);
		p5Add.setBackground(Color.white);
		p6Add.setBackground(Color.white);
		
		p1Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		JLabel lbl1 = new JLabel("CUSTOMER ID");
		lbl1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		inputIDReaderAdd.setPreferredSize(new Dimension(350,35));
		p1Add.add(lbl1);
		p1Add.add(inputIDReaderAdd);
		btnCheckIDReaderAdd.setBounds(0, 20, 100, 35);
		panelEast.add(btnCheckIDReaderAdd);
		btnCheckIDReaderAdd.setFocusPainted(false);
	
		JLabel lbl2 = new JLabel("Date Borrow    ");
		lbl2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		inputDateMakeAdd.setPreferredSize(new Dimension(350,35));
		inputDateMakeAdd.setEnabled(false);
		inputDateMakeAdd.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		p2Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		p2Add.add(lbl2);
		p2Add.add(inputDateMakeAdd);

		JLabel lblFormatDate = new JLabel("YY-MM-DD");
		lblFormatDate.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		lblFormatDate.setBounds(0, 157, 100, 35);
		
		panelEast.add(lblFormatDate);
		
		JLabel lbl3 = new JLabel("Date Expiry      ");
		lbl3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
//		inputDateExpiryAdd.setText("DD-MM-YY");
		inputDateExpiryAdd.setPreferredSize(new Dimension(350,35));
		p3Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		p3Add.add(lbl3);
		p3Add.add(inputDateExpiryAdd);

		JLabel lblInputBook = new JLabel("IDBook1,IDBook2,....");
		lblInputBook.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		lblInputBook.setBounds(0, 223, 200, 35);
		panelEast.add(lblInputBook);
		JLabel lbl4 = new JLabel("List ID Book     ");
		lbl4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		this.inputBookAdd.setPreferredSize(new Dimension(350,35));
		p4Add.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		p4Add.add(lbl4);
		p4Add.add(inputBookAdd);

		p5Add.setLayout(new FlowLayout(FlowLayout.RIGHT, 150, 0));
		btnAdd.setPreferredSize(new Dimension(100,40));
		
		btnAdd.setForeground(Color.white);
		btnCheckIDReaderAdd.setForeground(Color.white);
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnCheckIDReaderAdd.setBackground(Color.decode("#1a89cc"));
		btnAdd.setFocusPainted(false);
		
		p5Add.add(btnAdd);
	}
	
	public void eventPrint() {
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<DTOBillLent> Listbl = new ArrayList<DTOBillLent>();
				DTOBillLent blNew = new DTOBillLent();
//				inputIDBillLentUpdate,inputIDReaderUpdate,inputDateBorrowUpdate,inputDateExpiryUpdate,inputListBookUpdate
				blNew.IDBill = inputIDBillLentUpdate.getText();
				blNew.IDReader = inputIDReaderUpdate.getText();
				blNew.dateMake = inputDateBorrowUpdate.getText();
				blNew.dateExpiry = inputDateExpiryUpdate.getText();
				blNew.listBook = inputListBookUpdate.getText();
				Listbl.add(blNew);
				Report print = new Report();
				print.report(Listbl);
			}
		});
	}
	
	public void eventCheck() {
		btnCheckIDReaderAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if(bus.checkIDReader(inputIDReaderAdd.getText()) == true) {
					JOptionPane.showMessageDialog(inputIDReaderAdd, "ID exist");
				}else JOptionPane.showMessageDialog(inputIDReaderAdd, "ID not exist");
			}
		});
	}
	
	public void eventBtnAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bus.checkIDReader(inputIDReaderAdd.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDReaderAdd, "ID not exist");
					return;
				}
				if(bus.checkDate(inputDateExpiryAdd.getText(),inputDateMakeAdd.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDReaderAdd, "Date no valid");
					return;
				}
				
				if(bus.checkListBookAdd(inputBookAdd.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDReaderAdd, "Input book not valid");
					return;
				}
				String IDReader = inputIDReaderAdd.getText();
				String dateBorrow = inputDateMakeAdd.getText();
				String dateExpiry = inputDateExpiryAdd.getText();
				String listBook = inputBookAdd.getText();
				bus.insertBillLent(IDReader, dateBorrow, dateExpiry, listBook);
				JOptionPane.showMessageDialog(inputIDReaderAdd, "Create Bill Lent Success");
				inputIDReaderAdd.setText("");
				inputDateExpiryAdd.setText("");
				inputBookAdd.setText("");
			}
		});
	}
	
	public void removePnUpdate() {
		p1Update.removeAll();
		p2Update.removeAll();
		p3Update.removeAll();
		p4Update.removeAll();
		p5Update.removeAll();
		p6Update.removeAll();
		p7Update.removeAll();
	}
	
	public void guiUpdateBillLent() {
		panel.setBounds(0, 0, 980, 500);
		panelCenter.removeAll();
		panelNorth.removeAll();
		panelEast.removeAll();
		panel.setLayout(new BorderLayout());
		
		panelCenter.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		panelEast.setPreferredSize(new Dimension(290, 450));
		panelWest.setBackground(Color.white);
		panelWest.setPreferredSize(new Dimension(200, 450));
		panelEast.setLayout(null);
		
		panelNorth.setLayout(new FlowLayout());
		
		panel.add(panelCenter,BorderLayout.CENTER);
		panel.add(panelNorth,BorderLayout.NORTH);
		panel.add(panelEast,BorderLayout.EAST);
		panel.add(panelWest,BorderLayout.WEST);
		
		JLabel title = new JLabel("Update Bill Lent");
		title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,25));
		panelNorth.add(title);
		
		removePnUpdate();
		
		p1Update.setBackground(Color.white);
		p2Update.setBackground(Color.white);
		p3Update.setBackground(Color.white);
		p4Update.setBackground(Color.white);
		p5Update.setBackground(Color.white);
		p6Update.setBackground(Color.white);
		p7Update.setBackground(Color.white);
		
		panelCenter.setLayout(new GridLayout(7, 1));
		panelCenter.add(p1Update);
		panelCenter.add(p2Update);
		panelCenter.add(p3Update);
		panelCenter.add(p4Update);
		panelCenter.add(p5Update);
		panelCenter.add(p6Update);
		
		JLabel lbIDBillLent = new JLabel("ID Bill Lent");
		lbIDBillLent.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputIDBillLentUpdate.setPreferredSize(new Dimension(300, 35));
		selectBillLent.setPreferredSize(new Dimension(50, 35));
		p1Update.setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 10));
		p1Update.add(lbIDBillLent);
		p1Update.add(inputIDBillLentUpdate);
		p1Update.add(selectBillLent);
	
		JLabel lbIDReader = new JLabel("ID Reader");
		lbIDReader.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputIDReaderUpdate.setPreferredSize(new Dimension(360, 35));
		
		p2Update.setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 10));
		p2Update.add(lbIDReader);
		p2Update.add(inputIDReaderUpdate);
		
		JLabel lbDateBorrow = new JLabel("Date Make");
		lbDateBorrow.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputDateBorrowUpdate.setPreferredSize(new Dimension(360, 35));
		inputDateBorrowUpdate.setEnabled(false);
		
		p3Update.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 10));
		p3Update.add(lbDateBorrow);
		p3Update.add(inputDateBorrowUpdate);
		
		JLabel lbDateExpiry = new JLabel("Date Expiry");
		lbDateExpiry.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputDateExpiryUpdate.setPreferredSize(new Dimension(360, 35));
		
		p4Update.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		p4Update.add(lbDateExpiry);
		p4Update.add(inputDateExpiryUpdate);
		
		JLabel lbListBook = new JLabel("List Books"); 
		lbListBook.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputListBookUpdate.setPreferredSize(new Dimension(360, 35));
		
		p5Update.setLayout(new FlowLayout(FlowLayout.CENTER, 14, 10));
		p5Update.add(lbListBook);
		p5Update.add(inputListBookUpdate);
		
		p6Update.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 10));
		btnUpdate.setPreferredSize(new Dimension(150, 38));
		print.setPreferredSize(new Dimension(150,40));
		p6Update.add(btnUpdate);
		p6Update.add(print);
		
		btnUpdate.setFocusPainted(false);
		print.setFocusPainted(false);
		btnUpdate.setForeground(Color.white);
		print.setForeground(Color.white);
		selectBillLent.setForeground(Color.white);
		btnUpdate.setBackground(Color.decode("#ff0000"));
		print.setBackground(Color.decode("#f7941e"));
		selectBillLent.setBackground(Color.decode("#1a89cc"));
		selectBillLent.setFocusPainted(false);
		
		JLabel lbDateExplain = new JLabel("YY-MM-DD");
		lbDateExplain.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		lbDateExplain.setBounds(0, 185, 150, 35);
		
		JLabel lbBookExplain = new JLabel("IDBook1, IDBook2...");
		lbBookExplain.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		lbBookExplain.setBounds(0, 240, 200, 35);
		
		panelEast.add(lbDateExplain);
		panelEast.add(lbBookExplain);
	}
	
	public void guiSelectBL() {
		panel.setVisible(false);
		panel.removeAll();
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(new BorderLayout());
		
		panelNorth.removeAll();
		panelCenter.removeAll();
		
		panelNorth.setPreferredSize(new Dimension(980, 60));
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 30 , 10));
		
		panel.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		
		panel.add(panelNorth,BorderLayout.NORTH);
		panel.add(panelCenter,BorderLayout.CENTER);
		
		panel.setVisible(true);
		
		JLabel lbFind = new JLabel("Find Bill Lent");
		lbFind.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		inputFindUpdate.setPreferredSize(new Dimension(280,35));
		
		String caseBL[] = {"ALL","UnPaid","Paid"};
		cbbFilterUpdate = new JComboBox(caseBL);
		cbbFilterUpdate.setPreferredSize(new Dimension(100, 35));
		btnFindIDReaderUpdate.setPreferredSize(new Dimension(140, 35));
		btnBackUpdate.setPreferredSize(new Dimension(80, 35));
		btnSelectUpdate.setPreferredSize(new Dimension(80, 35));
		
		panelNorth.add(lbFind);
		panelNorth.add(inputFindUpdate);
		panelNorth.add(btnFindIDReaderUpdate);
		panelNorth.add(cbbFilterUpdate);
		panelNorth.add(btnSelectUpdate);
		panelNorth.add(btnBackUpdate);
		
		cbbFilterUpdate.setFocusable(false);
		cbbFilterUpdate.setBackground(Color.white);
		
		btnFindIDReaderUpdate.setForeground(Color.white);
		btnSelectUpdate.setForeground(Color.white);
		btnBackUpdate.setForeground(Color.white);
		
		btnFindIDReaderUpdate.setBackground(Color.decode("#ff0000"));
		btnSelectUpdate.setBackground(Color.decode("#1a89cc"));
		btnBackUpdate.setBackground(Color.decode("#f7941e"));
		
		String colum[] = {"ID Bill","Date Make","Date Expiry","Reader","Status","List Books"};
		dataTableUpdate = bus.loadAllBillLent();
		
		modelTabel = new DefaultTableModel(dataTableUpdate,colum);
		
		tableFilterUpdate.setModel(modelTabel);
		tableFilterUpdate.setRowHeight(25);
		tableFilterUpdate.setBackground(Color.white);
		tableFilterUpdate.setSelectionBackground(Color.decode("#28b928"));
		tableFilterUpdate.setSelectionForeground(Color.white);
		tableFilterUpdate.setGridColor(Color.white);
		tableFilterUpdate.setFocusable(false);
		tableFilterUpdate.setFillsViewportHeight(true);
		
		JTableHeader header = tableFilterUpdate.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		header.setResizingAllowed(false);
		tableFilterUpdate.setTableHeader(header);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		centerRenderer.setBackground(Color.white);
		tableFilterUpdate.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableFilterUpdate.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableFilterUpdate.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableFilterUpdate.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableFilterUpdate.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableFilterUpdate.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableFilterUpdate.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		tableScrollUpdate = new JScrollPane(tableFilterUpdate);
		
		panelCenter.setLayout(new BorderLayout());
		
		panelCenter.add(tableScrollUpdate,BorderLayout.CENTER);
		
	}
	
	public void eventFindBLUpdate() {
		btnFindIDReaderUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colum[] = {"ID Bill","Date Make","Date Expiry","Reader","Status","List Books"};
				if(bus.checkFindUpdate(inputFindUpdate.getText()) == false) {
					dataTableUpdate = null;
					modelTabel = new DefaultTableModel(dataTableUpdate,colum);
					tableFilterUpdate.setModel(modelTabel);
					return;
				}
				String IDReader = inputFindUpdate.getText();
				String status = (String)cbbFilterUpdate.getItemAt(cbbFilterUpdate.getSelectedIndex());
				dataTableUpdate = bus.findFollowReader(IDReader, status);
				modelTabel = new DefaultTableModel(dataTableUpdate,colum);
				tableFilterUpdate.setModel(modelTabel);
			}
		});
	}
	
	public void eventChooseBL() {
	
		btnSelectUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = -1;
				row = tableFilterUpdate.getSelectedRow();
				if(row == -1) return;
				String IDBillLent =(String) tableFilterUpdate.getValueAt(row, 0);
				inputIDBillLentUpdate.setText(IDBillLent);
				
				String dataLoad[] = bus.findIDBillLent(IDBillLent);
				
				if(dataLoad == null) return;
				inputIDReaderUpdate.setText(dataLoad[3]);
				inputDateBorrowUpdate.setText(dataLoad[1]);
				inputDateExpiryUpdate.setText(dataLoad[2]);
				inputListBookUpdate.setText(dataLoad[5]);
			}
		});
	}
	
	public void eventBackUpdate() {
		btnBackUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				guiUpdateBillLent();
				panel.setVisible(true);
			
			}
		});
	}
	
	public void eventChooseBLUpdate() {
		selectBillLent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiSelectBL();
			}
		});
	}
	
	public void eventBtnUpdate() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bus.checkBillLent(inputIDBillLentUpdate.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBillLentUpdate, "ID Bill Lent Not Exist");
					return;
				}
				
				if(bus.checkIDReader(inputIDReaderUpdate.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBillLentUpdate, "ID Reader Not Exist");
					return;
				}
				
				if(bus.checkDate(inputDateExpiryUpdate.getText(), inputDateBorrowUpdate.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBillLentUpdate, "Date Not Valid");
					return;
				}
				
				if(bus.checkListBookUpdate(inputListBookUpdate.getText(),inputIDBillLentUpdate.getText()) == false) {
					JOptionPane.showMessageDialog(inputIDBillLentUpdate, "Books Not Valid");
					return;
				}
			
				bus.updateBillLent(inputIDBillLentUpdate.getText(), inputDateExpiryUpdate.getText(), 
				inputIDReaderUpdate.getText(), inputListBookUpdate.getText());
				JOptionPane.showMessageDialog(inputIDBillLentUpdate, "Update Successfully");
				inputIDReaderUpdate.setText("");
				inputIDBillLentUpdate.setText("");
				inputDateExpiryUpdate.setText("");
				inputListBookUpdate.setText("");
			}
		});
	}
	
	public void eventBtnClear() {
		btnClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String IDBLClear = inputIDClear.getText();
				String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
				if(bus.checkBillLent(IDBLClear) == false ) {
					JOptionPane.showMessageDialog(inputIDClear, "ID Not Valid");
					return;
				}
				
				if(bus.checkBLClear(IDBLClear) == false) {
					JOptionPane.showMessageDialog(inputIDClear, "Bill lent no pay, clear fail");
					return;
				}
				
				bus.clearBillLent(IDBLClear);
				JOptionPane.showMessageDialog(inputIDClear, "Clear Successful");
				inputIDClear.setText("");
				dataClear = bus.loadAllBillLent();
				modelTableF = new DefaultTableModel(dataClear,proptertys);
				tableChooseDataClear.setModel(modelTableF);
			}
		});
	}
	
	public void guiClearBL() {
		panel.setBounds(0, 0, 980, 500);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		panelNorth.removeAll();
		panelCenter.removeAll();
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		
		p1Clear.setBackground(Color.white);
		p2Clear.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		
		panelCenter.setLayout(null);
		p1Clear.setBounds(0, 0, 980, 40);
		panelCenter.add(p1Clear);
		
		JLabel title = new JLabel("Clear Bill Lent");
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		panelNorth.add(title);
		
		JLabel lbClear = new JLabel("Enter ID Bill Lent");
		lbClear.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		lbClear.setBounds(160, 5, 200, 35);
		inputIDClear.setPreferredSize(new Dimension(300, 30));
		inputIDClear.setBounds(300, 5, 300, 35);
		btnClear.setBounds(620, 5, 100, 35);
		btnChooseDataClear.setBounds(740, 5, 100, 35);
		
		p1Clear.setLayout(null);;
		p1Clear.add(lbClear);
		p1Clear.add(inputIDClear);
		p1Clear.add(btnClear);
		p1Clear.add(btnChooseDataClear);
		
		btnClear.setForeground(Color.white);
		btnChooseDataClear.setForeground(Color.white);
		btnClear.setBackground(Color.decode("#ff0000"));
		btnChooseDataClear.setBackground(Color.decode("#1a89cc"));
		
		btnClear.setFocusPainted(false);
		btnChooseDataClear.setFocusPainted(false);
		
		String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
		dataClear = bus.loadAllBillLent();
		
		modelTableF = new DefaultTableModel(dataClear,proptertys);
		tableChooseDataClear.setModel(modelTableF);
		
		JTableHeader header = tableChooseDataClear.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		
		tableChooseDataClear.setFillsViewportHeight(true);
		tableChooseDataClear.setGridColor(Color.white);
		tableChooseDataClear.setSelectionBackground(Color.decode("#28b928"));
		tableChooseDataClear.setSelectionForeground(Color.white);
		tableChooseDataClear.setFocusable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableChooseDataClear.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableChooseDataClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableChooseDataClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableChooseDataClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableChooseDataClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableChooseDataClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableChooseDataClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(tableChooseDataClear);
		
		tableScroll.setBounds(0, 130, 980, 280);
		
		JLabel lbFind = new JLabel("Find Bill Lent");
		lbFind.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		lbFind.setBounds(70, 80, 150, 30);
		
		inputFindClear.setBounds(180, 80, 400, 33);
		
		findIDReaderClear.setBounds(600, 80, 140, 32);
		
		findIDBillPayClear.setBounds(750, 80, 140, 32);
		
		findIDReaderClear.setForeground(Color.white);
		findIDBillPayClear.setForeground(Color.white);
		findIDReaderClear.setBackground(Color.decode("#f7941e"));
		findIDBillPayClear.setBackground(Color.decode("#803ec0"));
		findIDBillPayClear.setFocusPainted(false);
		findIDReaderClear.setFocusPainted(false);
		
		panelCenter.add(lbFind);
		panelCenter.add(inputFindClear);
		panelCenter.add(findIDReaderClear);
		panelCenter.add(findIDBillPayClear);
		panelCenter.add(tableScroll);
		
//		p2Clear.setLayout(null);
//		p2Clear.add(btnClear);
		
		//findIDReaderClear,findIDBillPayClear,btnChooseDataClear,tableChooseDataClear,inputFindClear
		
	}
	
	public void eventBtnFindIDReaderClear() {
		findIDReaderClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindClear.getText();
				String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
				if(bus.checkIDReader(ID) == false) {
					dataClear = null;
					modelTableF = new DefaultTableModel(dataClear,proptertys);
					tableChooseDataClear.setModel(modelTableF);
					return;
				}
				dataClear = bus.findFollowReader(ID, "ALL");
				modelTableF = new DefaultTableModel(dataClear,proptertys);
				tableChooseDataClear.setModel(modelTableF);
			}
		});
	}
	
	public void evetnBtnFindIDBillPayClear() {
		findIDBillPayClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindClear.getText();
				String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
				if(bus.checkBillLent(ID) == false) { 
					dataClear = null;
					modelTableF = new DefaultTableModel(dataClear,proptertys);
					tableChooseDataClear.setModel(modelTableF);
					return;
				}
				dataClear = new String[1][6];
				dataClear[0] = bus.findIDBillLent(ID);
				modelTableF = new DefaultTableModel(dataClear,proptertys);
				tableChooseDataClear.setModel(modelTableF);
			}
		});
	}
	
	public void evetnBtnChooseDataClear() {
		btnChooseDataClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = tableChooseDataClear.getSelectedRow();
				if(row<0) return;
				String ID = (String) tableChooseDataClear.getValueAt(row, 0);
				inputIDClear.setText(ID);
			}
		});
	}
	
	public void guiFind() {
		panel.setBounds(0, 0, 980, 450);
		panelNorth.removeAll();
		panelCenter.removeAll();
		panel.setLayout(new BorderLayout());
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panelNorth.setPreferredSize(new Dimension(980, 60));
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		panelCenter.setLayout(new BorderLayout());
		
		String status[] = {"Paid","UnPaid"};
		cbbStatusBLF = new JComboBox(status);
		JLabel title = new JLabel("Find Bill Lent");
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		inputFindF.setPreferredSize(new Dimension(300,35));
		btnFindIDBLF.setPreferredSize(new Dimension(120,35));
		btnFindIDReaderF.setPreferredSize(new Dimension(150,35));
		cbbStatusBLF.setPreferredSize(new Dimension(150,35));
		
		panelCenter.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		
		cbbStatusBLF.setBackground(Color.white);
		cbbStatusBLF.setFocusable(false);
		
		btnFindIDBLF.setForeground(Color.white);
		btnFindIDReaderF.setForeground(Color.white);
		
		btnFindIDBLF.setBackground(Color.decode("#ff0000"));
		btnFindIDReaderF.setBackground(Color.decode("#1a89cc"));
		btnFindIDReaderF.setFocusPainted(false);
		btnFindIDBLF.setFocusPainted(false);
		
		panelNorth.add(title);
		panelNorth.add(inputFindF);
		panelNorth.add(btnFindIDBLF);
		panelNorth.add(btnFindIDReaderF);
		panelNorth.add(cbbStatusBLF);
		
		dataFindF = bus.loadAllBillLent();
		
		String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
		modelTableF = new DefaultTableModel(dataFindF,proptertys);
		tabelF.setModel(modelTableF);
		
		tabelF.setFillsViewportHeight(true);
		tabelF.setSelectionForeground(Color.white);
		tabelF.setSelectionBackground(Color.decode("#28b928"));
		tabelF.setFocusable(false);
		tabelF.setGridColor(Color.white);
		tabelF.setRowHeight(25);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tabelF.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabelF.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tabelF.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tabelF.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tabelF.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tabelF.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
//		tabelF.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		JTableHeader header = tabelF.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		
		JScrollPane tableScroll = new JScrollPane(tabelF);
		panelCenter.add(tableScroll, BorderLayout.CENTER);
	}
	
	public void eventBtnFindIDBLF() {
		btnFindIDBLF.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String valueInput = inputFindF.getText();
				
				if(bus.checkBillLent(valueInput) == false) {
					dataFindF = null;
					String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
					modelTableF = new DefaultTableModel(dataFindF,proptertys);
					tabelF.setModel(modelTableF);
					return;
				}
				dataFindF = new String[1][6];
				dataFindF[0] = bus.findIDBillLent(valueInput);
				String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
				modelTableF = new DefaultTableModel(dataFindF,proptertys);
				tabelF.setModel(modelTableF);
			}
		});
	}
	
	public void eventBtnFindIDReader() {
		btnFindIDReaderF.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String valueInput = inputFindF.getText();
				String status =(String) cbbStatusBLF.getItemAt(cbbStatusBLF.getSelectedIndex());
				
				if(bus.checkIDReader(valueInput) == false) {
					dataFindF = null;
					String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
					modelTableF = new DefaultTableModel(dataFindF,proptertys);
					tabelF.setModel(modelTableF);
					return;
				}
				
				dataFindF = bus.findFollowReader(valueInput, status);
				String proptertys[] = {"ID Bill","Date Make","Date Expiry","ID Reader","Status","List Books"};
				modelTableF = new DefaultTableModel(dataFindF,proptertys);
				tabelF.setModel(modelTableF);
			}
		});
	}

	
	public void eventBtn() {
		eventBtnAdd();
		eventChooseBLUpdate();
		eventFindBLUpdate();
		eventBackUpdate();
		eventChooseBL();
		eventBtnUpdate();
		eventBtnClear();
		eventBtnFindIDBLF();
		eventBtnFindIDReader();
		eventBtnFindIDReaderClear();
		evetnBtnFindIDBillPayClear();
		evetnBtnChooseDataClear();
		eventPrint();
	}
	
	public String getDateCurrent() {
		return java.time.LocalDate.now().toString();
	}
	
}