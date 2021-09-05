import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiBook{
	
	protected JPanel panel;
	
	protected JPanel panelNorth;
	
	protected JPanel panelSouth;
	
	protected JPanel panelWest;
	
	protected JPanel panelEast;
	
	protected JPanel panelCenter;
	
	protected JPanel panelLayerOne;
	
	protected JPanel panelLayerTwo;
	
	protected JPanel panelLayerThree;
	
	protected JPanel panelLayerFour;
	
	protected JPanel panelLayerFive;
	
	protected JPanel panelLayerSix;
	
	protected JPanel panelLayerSeven;
	
	protected JComboBox cbbHeadBook;
	
	protected JComboBox cbbStatus;
	
	protected JComboBox cbbState;
	
	protected JTextArea taNote;
	
	protected JScrollPane taScroll;
	
	protected JButton menuAdd;
	
	protected JButton menuRepair;
	
	protected JButton menuClear;
	
	protected JButton menuFind;
	
	protected JButton menuImport;
	
	protected JButton menuExport;
	
	protected JButton menuShowData;
	
	protected JLabel title;
	
	protected JLabel lblHeadBook;
	
	protected JLabel lblStatus;
	
	protected JLabel lblState;
	
	protected JLabel lblNote;
	
	protected JLabel lblAmount;
	
	protected JLabel lblExplain;
	
	protected JLabel lblIDBook;
	
	protected JLabel inputIDBook;
	
	protected JLabel inputIDHeadBook;
	
	protected JTextField inputIDRepair;
	
	protected JTextField inputIDClear;
	
	protected JLabel inputIDHeadBookRepair;
	
	protected JTextField inputAmount;
	
	protected JButton btnAdd;
	
	protected JButton btnRepair;
	
	protected JButton btnSelectBook;
	
	protected JButton btnSelectHeadBook;
	
	protected String [][]dataRow;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected JButton btnChooseBook;
	
	protected JButton btnBackB;
	
	protected JButton btnFindBookRP;
	
	protected JScrollPane tableScroll;
	
	protected JButton btnBackHB;
	
	protected JButton btnResetHB;
	
	protected JButton btnChooseHB;
	
	protected int identifyFunction = 0;
	
	protected JButton btnClear;
	
	protected JButton btnFindFollowID;
	
	protected JButton btnFindFollowName;
	
	protected JTextField inputMenuFind;
	
	protected JButton btnLoadDataClear;
	
	protected String[][] dataTableClear;
	
	protected JTable tableClear;
	
	protected JTextField inputFindClear;
	
	protected JButton followIDClear;
	
	protected JButton followNameClear;
	
	GuiBook(){
		bootMenu();
		bootPanel();
		bootComboBox();
		bootTextArea();
		bootLabel();
		bootButton();
		bootTextField();
		bootTable();
		eventButton();
		eventSelectBook();
		eventSelectHeadBook();
	}
	
	public void bootMenu() {
		menuAdd = new JButton("ADD");
		
		menuClear = new JButton("CLEAR");
		
		menuRepair = new JButton("REPAIR");
		
		menuFind = new JButton("FIND");
		
		menuImport = new JButton("IMPORT");
		
		menuExport = new JButton("EXPORT");
		
		menuShowData = new JButton("DATA");
		
		
	}
	
	public void bootTable() {
		tableClear = new JTable();
	}
	
	public void bootPanel() {
		panel = new JPanel();
		
		panelNorth = new JPanel();
		
		panelSouth = new JPanel();
		
		panelWest = new JPanel();
		
		panelEast = new JPanel();
		
		panelCenter = new JPanel();
		
		panelLayerOne = new JPanel();
		
		panelLayerTwo = new JPanel();
		
		panelLayerThree = new JPanel();
		
		panelLayerFour = new JPanel();
		
		panelLayerFive = new JPanel();
		
		panelLayerSix = new JPanel();
		
		panelLayerSeven = new JPanel();
	}
	
	public void bootComboBox() {
		cbbHeadBook = new JComboBox();
		
		cbbStatus = new JComboBox();
		
		cbbState = new JComboBox();
	}
	
	public void bootTextArea() {
		taNote = new JTextArea();
		taScroll = new JScrollPane(taNote); 
	}
	
	public void bootLabel() {
		lblHeadBook = new JLabel("Head Book");
		
		lblStatus = new JLabel("Status");
		
		lblState = new JLabel("State");
		
		lblNote = new JLabel("Note");
		
		lblAmount = new JLabel("Amount");
		
		lblExplain = new JLabel("ID - Name Book");
		
		inputIDBook = new JLabel();
		
		inputIDHeadBook = new JLabel();
		
		inputIDHeadBookRepair = new JLabel();
		
		lblIDBook = new JLabel("ID Book");
		
		title = new JLabel();
	}
	
	public void bootButton() {
		btnAdd = new JButton("ADD");
		
		btnRepair = new JButton("REPAIR");
		
		btnSelectBook = new JButton("+");
		
		btnChooseBook = new JButton("choose");
		
		btnBackB = new JButton("Back");
		
		btnBackHB = new JButton("Back");
		
		btnResetHB = new JButton("Reset");
		
		btnFindBookRP = new JButton("Follow ID");
		
		btnSelectHeadBook = new JButton("+");
		
		btnChooseHB = new JButton("choose"); 
		
		btnClear = new JButton("Clear");
		
		btnLoadDataClear = new JButton("Choose");
		
		btnFindFollowName = new JButton("follow name");
		
		btnFindFollowID = new JButton("follow ID");
		
		followIDClear = new JButton("Follow ID");
		
		followNameClear = new JButton("Follow Name");
	}
	
	public void bootTextField() {
		inputAmount = new JTextField();
		
		inputIDRepair = new JTextField();
		
		inputIDClear = new JTextField();
		
		inputMenuFind = new JTextField();
		
		inputFindClear = new JTextField();
	}
	
	public void decorationMenu() {
		decoration(menuAdd);
		decoration(menuClear);
		decoration(menuRepair);
		decoration(menuFind);
		decoration(menuImport);
		decoration(menuExport);
		decoration(menuShowData);
	}
	
	public void addMenuChild(MyFrame frame) {

		frame.panelTop.add(menuAdd);
		frame.panelTop.add(menuRepair);
		frame.panelTop.add(menuClear);
		frame.panelTop.add(menuFind);
	}
	
	public void createMenu(MyFrame frame) {
	
		decorationMenu();
		
		addMenuChild(frame);
		
		eventMenuAdd(frame);
		
		eventMenuRepair(frame);
		
		eventMenuClear(frame);
		
		eventMenuFind(frame);
	}
	
	public void decoration(JButton btn) {
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,18);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setFont(font);
		btn.setBackground(Color.decode("#202b30"));
		btn.setForeground(Color.decode("#ffffff"));
		
	}
	
	public void eventMenuAdd(MyFrame frame) {
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setBackground(Color.white);
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiAddBook();
				panel.setVisible(true);
				identifyFunction = 1;
			}
		});	
	}
	
	public void eventMenuRepair(MyFrame frame) {
		menuRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setBackground(Color.white);
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiRepairBook();
				panel.setVisible(true);
				identifyFunction = 2;
			}
		});	
	}
	
	public void eventMenuClear(MyFrame frame) {
		menuClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setBackground(Color.white);
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiClearBook();
				panel.setVisible(true);
				identifyFunction = 2;
			}
		});	
	}
	
	public void eventMenuFind(MyFrame frame) {
		menuFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setBackground(Color.white);
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiFindBook();
				panel.setVisible(true);
				identifyFunction = 7;
			}
		});	
	}
	
	public void menuAddBackGround() {
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		panelWest.setBackground(Color.white);
		panelLayerOne.setBackground(Color.white);
		panelLayerTwo.setBackground(Color.white);
		panelLayerThree.setBackground(Color.white);
		panelLayerFour.setBackground(Color.white);
		panelLayerFive.setBackground(Color.white);
		panelLayerSix.setBackground(Color.white);
	}
	
	public void removePanelLayer() {
		panelLayerOne.removeAll();
		panelLayerTwo.removeAll();
		panelLayerThree.removeAll();
		panelLayerFour.removeAll();
		panelLayerFive.removeAll();
		panelLayerSix.removeAll();
		panelLayerSeven.removeAll();
	}
	
	public void removePanelDirection() {
		panelNorth.removeAll();
		panelCenter.removeAll();
		panelEast.removeAll();
		panelWest.removeAll();
	}
	
	public void menuAddPanelMain() {
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(new BorderLayout());
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelEast, BorderLayout.EAST);
		panel.add(panelWest, BorderLayout.WEST);
		
	}
	
	public void menuAddPanelNorth() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 21);
		title = new JLabel("ADD BOOK");
		title.setFont(font);
		panelNorth.removeAll();
		panelNorth.add(title);
		panelNorth.setPreferredSize(new Dimension(980, 40));
	}
	
	public void menuAddPanelLayer() {

		panelLayerOne.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLayerTwo.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLayerThree.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLayerFour.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLayerFive.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLayerSix.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		removePanelLayer();
		
		panelLayerOne.add(lblHeadBook);
		panelLayerOne.add(inputIDHeadBook);
		panelLayerOne.add(btnSelectHeadBook);
		
		panelLayerTwo.add(lblStatus);
		panelLayerTwo.add(cbbStatus);
		
		panelLayerThree.add(lblState);
		panelLayerThree.add(cbbState);
		
		panelLayerFour.add(lblNote);
		panelLayerFour.add(taScroll);
		
		panelLayerFive.add(lblAmount);
		panelLayerFive.add(inputAmount);
		
		panelLayerSix.add(btnAdd);
		panelLayerSix.add(btnAdd);
		
		menuAddSetSizeComponent();
	}
	
	public void menuAddSetSizeComponent() {
		
		inputIDHeadBook.setBorder(BorderFactory.createLineBorder(Color.black));
		lblHeadBook.setPreferredSize(new Dimension(72,35));
		btnSelectHeadBook.setPreferredSize(new Dimension(40,35));
		inputIDHeadBook.setPreferredSize(new Dimension(255,35));
		cbbHeadBook.setPreferredSize(new Dimension(300,35));
		
		btnSelectHeadBook.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		lblStatus.setPreferredSize(new Dimension(72,35));
		cbbStatus.setPreferredSize(new Dimension(300,35));
		
		lblState.setPreferredSize(new Dimension(72,35));
		cbbState.setPreferredSize(new Dimension(300,35));
		
		lblNote.setPreferredSize(new Dimension(72,60));
		taScroll.setPreferredSize(new Dimension(300,60));
		
		lblAmount.setPreferredSize(new Dimension(72,35));
		inputAmount.setPreferredSize(new Dimension(300,35));
		inputAmount.setText("1");
		
		btnAdd.setPreferredSize(new Dimension(100,40));
		
		inputIDHeadBook.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		taScroll.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		inputAmount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		eventDecoration(btnAdd);
		
	}
	
	public void eventDecoration(JButton btn) {
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,16);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setBorder(null);
		btn.setFont(font);
		btn.setBackground(Color.decode("#ff0000"));
		btn.setForeground(Color.decode("#ffffff"));
		
		btnSelectHeadBook.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSelectHeadBook.setBorderPainted(false);
		btnSelectHeadBook.setFocusPainted(false);
		btnSelectHeadBook.setBorder(null);
		btnSelectHeadBook.setFont(font);
		btnSelectHeadBook.setBackground(Color.decode("#1a89cc"));
		btnSelectHeadBook.setForeground(Color.decode("#ffffff"));
	}
	
	public void menuAddLoadComboBox() {
		BUSBook busBook = new BUSBook();
		String []listStatus = {"Ready borrow","Not ready yet"};
		cbbStatus = new JComboBox(listStatus);
		cbbStatus.setBackground(Color.white);
		cbbStatus.setFocusable(false);
		String []listState = {"Normal", "Damage"};
		cbbState = new JComboBox(listState);
		cbbState.setBackground(Color.white);
		cbbState.setFocusable(false);
	}
	
	public void menuAddSetFont() {
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
		lblHeadBook.setFont(font);
		lblStatus.setFont(font);
		lblState.setFont(font);
		lblNote.setFont(font);
		lblAmount.setFont(font);
		btnAdd.setFont(font);
	}
	
	public void decorationMenuAdd() {
		decoration(btnAdd);
	}
	
	public void menuAddPanelCenter() {
		menuAddLoadComboBox();
		menuAddPanelLayer();
		menuAddSetFont();
		panelCenter.setLayout(new GridLayout(6, 1));
		panelCenter.add(panelLayerOne);
		panelCenter.add(panelLayerTwo);
		panelCenter.add(panelLayerFive);
		panelCenter.add(panelLayerThree);
		panelCenter.add(panelLayerFour);
		panelCenter.add(panelLayerSix);
	}
	
	public void menuAddSetSizeOther() {
		panelEast.setPreferredSize(new Dimension(80, 450));
		panelWest.setPreferredSize(new Dimension(80, 450));
	}
	
	public void guiAddBook() {
		menuAddBackGround();
		menuAddPanelMain();
		menuAddSetSizeOther();
		menuAddPanelNorth();
		menuAddPanelCenter();	
	}
	
	public void menuRepairBackGround() {
		panelNorth.setBackground(Color.WHITE);
		panelCenter.setBackground(Color.WHITE);
		panelEast.setBackground(Color.WHITE);
		panelWest.setBackground(Color.WHITE);
		panelLayerOne.setBackground(Color.WHITE);
		panelLayerTwo.setBackground(Color.WHITE);
		panelLayerThree.setBackground(Color.WHITE);
		panelLayerFour.setBackground(Color.WHITE);
		panelLayerFive.setBackground(Color.WHITE);
		panelLayerSix.setBackground(Color.WHITE);
	}

	
	public void menuRepairPanelMain() {
		removePanelLayer();
		removePanelDirection();
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(new BorderLayout());
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelEast, BorderLayout.EAST);
		panel.add(panelWest, BorderLayout.WEST);
	}
	
	public void menuRepairPanelNorth() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 21);
		title = new JLabel("Repair Book");
		title.setFont(font);
		panelNorth.add(title);
	}
	
	public void menuRepairPanelLayer() {
		panelLayerOne.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panelLayerTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 40 ,0));
		panelLayerThree.setLayout(new FlowLayout(FlowLayout.CENTER, 48 ,0));
		panelLayerFour.setLayout(new FlowLayout(FlowLayout.CENTER, 50 ,0));
		panelLayerFive.setLayout(new FlowLayout(FlowLayout.CENTER,10, 0));
		panelLayerSix.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		removePanelLayer();
		
		inputIDHeadBookRepair.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLayerOne.add(lblHeadBook);
		panelLayerOne.add(inputIDHeadBookRepair);
		panelLayerOne.add(btnSelectHeadBook);
		
		panelLayerTwo.add(lblStatus);
		panelLayerTwo.add(cbbStatus);
		
		panelLayerThree.add(lblState);
		panelLayerThree.add(cbbState);
		
		panelLayerFour.add(lblNote);
		panelLayerFour.add(taScroll);
		
		panelLayerFive.add(lblIDBook);
		panelLayerFive.add(inputIDBook);
		panelLayerFive.add(btnSelectBook);
		
		panelLayerSix.add(btnRepair);
		panelLayerSix.add(btnRepair);
	}
	
	public void menuRepairPanelCenter() {
		menuRepairPanelLayer();
		panelCenter.setLayout(new GridLayout(6,1));
		panelCenter.add(panelLayerFive);
		panelCenter.add(panelLayerOne);
		panelCenter.add(panelLayerTwo);
		panelCenter.add(panelLayerThree);
		panelCenter.add(panelLayerFour);
		panelCenter.add(panelLayerSix);
	}
	
	public void menuRepairSetSize() {
		
		inputIDBook.setPreferredSize(new Dimension(305, 35));
		inputIDHeadBookRepair.setPreferredSize(new Dimension(300, 35));
		btnSelectBook.setPreferredSize(new Dimension(75, 35));
		btnSelectHeadBook.setPreferredSize(new Dimension(75, 35));
		cbbHeadBook.setPreferredSize(new Dimension(385, 35));
		cbbStatus.setPreferredSize(new Dimension(385, 35));
		cbbState.setPreferredSize(new Dimension(385, 35));
		taScroll.setPreferredSize(new Dimension(385, 62));
		btnRepair.setPreferredSize(new Dimension(100, 40));
		lblIDBook.setPreferredSize(new Dimension(72, 40));
		lblHeadBook.setPreferredSize(new Dimension(80, 40));
		lblStatus.setPreferredSize(new Dimension(50, 40));
		lblState.setPreferredSize(new Dimension(40, 40));
		lblNote.setPreferredSize(new Dimension(40, 40));
		
		btnSelectBook.setBackground(Color.decode("#1a89cc"));
		btnSelectBook.setFocusable(false);
		btnSelectBook.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSelectBook.setBorder(null);
		btnSelectBook.setForeground(Color.white);
		
		btnRepair.setBackground(Color.decode("#ff0000"));
		btnRepair.setFocusable(false);
		btnRepair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRepair.setBorder(null);
		btnRepair.setForeground(Color.white);
	}
	
	public void menuRepairSetFont() {
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		lblIDBook.setFont(font);
		lblHeadBook.setFont(font);
		lblStatus.setFont(font);
		lblState.setFont(font);
		lblNote.setFont(font);
	}
	
	public void menuRepairDecoration(){
		menuRepairSetFont();
		inputIDBook.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSelectHeadBook.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSelectHeadBook.setBorderPainted(false);
		btnSelectHeadBook.setFocusPainted(false);
		btnSelectHeadBook.setBorder(null);
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,16);
		btnSelectHeadBook.setFont(font);
		btnSelectHeadBook.setBackground(Color.decode("#1a89cc"));
		btnSelectHeadBook.setForeground(Color.decode("#ffffff"));
	}
	
	public void guiRepairBook() {
		menuAddLoadComboBox();
		menuRepairSetSize();
		menuRepairPanelMain();
		menuRepairBackGround();
		menuRepairPanelNorth();
		menuRepairDecoration();
		menuRepairPanelCenter();
	}
	
	public void guiClearBook() {
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel title = new JLabel("CLEAR BOOK");
		title.setBounds(400, 10, 200, 20);
		title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		JLabel lbl = new JLabel("Enter ID Book");
		lbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		lbl.setBounds(175, 35, 150, 40);
		
		btnClear.setBounds(370, 80, 80, 30);
		inputIDClear.setBounds(290, 40, 350, 30);
		btnLoadDataClear.setBounds(475, 80, 80, 30);
		
		btnLoadDataClear.setForeground(Color.white);
		btnClear.setForeground(Color.white);
		
		btnLoadDataClear.setBackground(Color.decode("#1a89cc"));
		btnClear.setBackground(Color.decode("#ff0000"));
		
		panel.add(title);
		panel.add(lbl);
		panel.add(inputIDClear);
		panel.add(btnClear);
		panel.add(btnLoadDataClear);
		
		btnClear.setFocusable(false);
		btnLoadDataClear.setFocusable(false);
		
		String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
		BUSBook busBook = new BUSBook();
		dataTableClear = busBook.takeSelectBook();
		model = new DefaultTableModel(dataTableClear, colum);
		tableClear.setModel(model);
		JScrollPane tableScrollClear = new JScrollPane(tableClear);
		tableScrollClear.setBounds(2, 200, 980, 250);
		panel.add(tableScrollClear);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		JTableHeader header = tableClear.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		
		tableClear.setGridColor(Color.white);
		tableClear.setSelectionForeground(Color.white);
		tableClear.setSelectionBackground(Color.decode("#28b928"));
		tableClear.setFocusable(false);
		tableClear.setRowHeight(25);
		tableClear.setFillsViewportHeight(true);
		
		JLabel lbFind = new JLabel("Find Book");
		lbFind.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		lbFind.setBounds(50, 150, 100, 30);
		
		inputFindClear.setBounds(150, 150, 400, 30);
		followIDClear.setBounds(580, 151, 150, 28);
		followNameClear.setBounds(760, 151, 150, 28);
		
		followIDClear.setFocusable(false);
		followNameClear.setFocusable(false);
		
		followIDClear.setForeground(Color.white);
		followNameClear.setForeground(Color.white);
		
		followIDClear.setBackground(Color.decode("#f7941e"));
		followNameClear.setBackground(Color.decode("#803ec0"));
		
		panel.add(lbFind);
		panel.add(inputFindClear);
		panel.add(followIDClear);
		panel.add(followNameClear);
		
	}
	
	public void eventBtnFollowIDClear() {
		followIDClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindClear.getText();
				BUSBook busBook = new BUSBook();
				String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
				if(busBook.checkIDClear(ID) == false) {
					dataTableClear = null;
					model = new DefaultTableModel(dataTableClear, colum);
					tableClear.setModel(model);
					return;
				}
				dataTableClear = busBook.findBookFollowID(ID);
				model = new DefaultTableModel(dataTableClear, colum);
				tableClear.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				tableClear.getColumnModel().getColumn(0).setPreferredWidth(0);
				tableClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void evenBtnFollowNameClear() {
		followNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				String name = inputFindClear.getText(); 
				if(name.equals("") == true) return;
				dataTableClear = busBook.findBookFollowName(name);
				String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
				model = new DefaultTableModel(dataTableClear, colum);
				tableClear.setModel(model);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				tableClear.getColumnModel().getColumn(0).setPreferredWidth(0);
				tableClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				tableClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
			}
		});
	}
	
	public void eventBtnLoadDataClear() {
		btnLoadDataClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableClear.getSelectedRow()>=0) {
					String ID = (String) tableClear.getValueAt(tableClear.getSelectedRow(), 0);
					inputIDClear.setText(ID);
				}
			
			}
		});
	}
	
	public void guiFindBook() {
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(new BorderLayout());
		panelNorth.removeAll();
		panelNorth.setPreferredSize(new Dimension(980, 60));
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 13));
		panel.add(panelNorth, BorderLayout.NORTH);
		
		panel.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		
		BUSBook busBook = new BUSBook();
		String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
		dataRow = busBook.takeSelectBook();
		
		JLabel lbl = new JLabel("Search");
		lbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		inputMenuFind.setPreferredSize(new Dimension(400,35));
		btnFindFollowID.setPreferredSize(new Dimension(120,35));
		btnFindFollowName.setPreferredSize(new Dimension(120,35));
		panelNorth.add(lbl);
		panelNorth.add(inputMenuFind);
		panelNorth.add(btnFindFollowID);
		panelNorth.add(btnFindFollowName);
		
		btnFindFollowID.setForeground(Color.white);
		btnFindFollowName.setForeground(Color.white);
		
		btnFindFollowID.setBackground(Color.decode("#ff0000"));
		btnFindFollowName.setBackground(Color.decode("#1a89cc"));
		
		btnFindFollowName.setFocusable(false);
		btnFindFollowID.setFocusable(false);
		
		model = new DefaultTableModel(dataRow, colum);
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(30);
		
		table.setGridColor(Color.white);
		table.setSelectionForeground(Color.white);
		table.setSelectionBackground(Color.decode("#28b928"));
		table.setBackground(Color.white);
		table.setFillsViewportHeight(true);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		
		CellTableCenter(table);
		tableScroll = new JScrollPane(table);
		tableScroll.setBounds(50, 60, 900, 420);
		panel.add(tableScroll,BorderLayout.CENTER);
	}
	
	public void menuFindEventID() {
		btnFindFollowID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
				if(busBook.checkIDClear(inputMenuFind.getText()) == false) {
					dataRow = null;
					model = new DefaultTableModel(dataRow, colum);
					table.setModel(model);
					return;
				}
				dataRow = busBook.findBookFollowID(inputMenuFind.getText());
				model = new DefaultTableModel(dataRow, colum);
				table.setModel(model);
				CellTableCenter(table);
			}
		});
		
		btnFindFollowName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				if(inputMenuFind.getText().equals("") == true) return;
				dataRow = busBook.findBookFollowName(inputMenuFind.getText());
				String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
				model = new DefaultTableModel(dataRow, colum);
				table.setModel(model);
				CellTableCenter(table);
			}
		});
	}
	
	public void guiselectBook() {
		panelNorth.setVisible(false);
		panelNorth.removeAll();
		panelNorth.setVisible(true);
		panel.removeAll();
		panel.setBounds(0, 0, 980, 500);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		BUSBook busBook = new BUSBook();
		String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
		dataRow = busBook.takeSelectBook();
		model = new DefaultTableModel(dataRow, colum);
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(30);
		
		table.setFillsViewportHeight(true);
		table.setSelectionForeground(Color.white);
		table.setSelectionBackground(Color.decode("#28b928"));
		table.setGridColor(Color.white);
		table.setFocusable(false);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		
		CellTableCenter(table);
		tableScroll = new JScrollPane(table);
		tableScroll.setBounds(50, 50, 900, 390);
		btnChooseBook.setBounds(630, 10, 150, 30);
		btnBackB.setBounds(798, 10, 150, 30);
		btnFindBookRP.setBounds(460, 10, 150, 30);
		inputIDRepair.setBounds(120, 10, 300, 30);
		
		btnChooseBook.setFocusable(false);
		btnBackB.setFocusable(false);
		btnFindBookRP.setFocusable(false);
		
		btnChooseBook.setForeground(Color.white);
		btnBackB.setForeground(Color.white);
		btnFindBookRP.setForeground(Color.white);
		
		btnChooseBook.setBackground(Color.decode("#1a89cc"));
		btnBackB.setBackground(Color.decode("#f7941e"));
		btnFindBookRP.setBackground(Color.decode("#ff0000"));
		//,
		JLabel lbl = new JLabel("Search");
		lbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		lbl.setBounds(50, 10, 300, 30);
		panel.add(tableScroll);
		panel.add(lbl);
		panel.add(inputIDRepair);
		panel.add(btnFindBookRP);
		panel.add(btnChooseBook);
		panel.add(btnBackB);
	}
	
	public void guiTakeHeadbook() {
		panelNorth.setVisible(false);
		panelNorth.removeAll();
		panelNorth.setVisible(true);
		panel.removeAll();
		panel.setLayout(null);
		
		panelNorth.setBackground(Color.white);
		panel.setBackground(Color.white);
		
		BusHeadBook busHB = new BusHeadBook();
		String colum[] = {"ID","Name Book","Category","Language","PublishCompany","Author","Price"};
		dataRow = busHB.showData();
		for(int i = 0 ;i<dataRow.length;++i) {
			dataRow[i][5] = busHB.findAuthorHeadBook(Integer.parseInt(dataRow[i][0]));
		}
		model = new DefaultTableModel(dataRow, colum);
		table = new JTable();
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
		
		btnChooseHB.setForeground(Color.white);
		btnBackHB.setForeground(Color.white);
		btnResetHB.setForeground(Color.white);
		
		btnChooseHB.setFocusable(false);
		btnBackHB.setFocusable(false);
		btnResetHB.setFocusable(false);
		
		btnChooseHB.setBackground(Color.decode("#ff0000"));
		btnBackHB.setBackground(Color.decode("#1a89cc"));
		btnResetHB.setBackground(Color.decode("#f7941e"));
		
		
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
		
		CellTableCenter(table);
		tableScroll = new JScrollPane(table);
		tableScroll.setBounds(50, 50, 900, 390);
		btnChooseHB.setBounds(300, 10, 150, 30);
		btnBackHB.setBounds(500, 10, 150, 30);
		btnResetHB.setBounds(700, 10, 150, 30);
		JLabel lbl = new JLabel("Invite you choose HeadBook");
		lbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		lbl.setBounds(50, 10, 300, 30);
		panel.add(tableScroll);
		panel.add(btnChooseHB);
		panel.add(btnBackHB);
		panel.add(lbl);
		panel.add(btnResetHB);
	}
	
	
	
	public void CellTableCenter(JTable table) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
	}
	
	public String getInputIDHeadBook() {
		return inputIDHeadBook.getText();
	}
	
	public String getCbbStatus() {
		
		return (String)cbbStatus.getItemAt(cbbStatus.getSelectedIndex());

	}
	
	public String getAmount() {
		return inputAmount.getText();
	}
	
	public String getCbbState() {
		return (String)cbbState.getItemAt(cbbState.getSelectedIndex());
	}
	
	public String getNote() {
		return taNote.getText();
	}
	
	public void eventAdd() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String headbook = getInputIDHeadBook();
				String status = getCbbStatus();
				String amount = getAmount();
				String state = getCbbState();
				String note = getNote();
				BUSBook busBook = new BUSBook();
				
				if(busBook.checkAmount(amount) && busBook.checkHeadBook(headbook)) {
					busBook.addBook(headbook,status,amount,state,note);
					JOptionPane.showMessageDialog(cbbHeadBook, "ADD BOOK SUCCESS");
					inputIDHeadBook.setText("");
					inputAmount.setText("");
					taNote.setText("");
				}else JOptionPane.showMessageDialog(cbbHeadBook, "ADD BOOK FAIL");
				
			}
		});
	}
	
	public void eventRepair() {
	
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				String IDBook = inputIDBook.getText();
				String IDHeadBook = inputIDHeadBookRepair.getText();
				String status = getCbbStatus();
				String state = getCbbState();
				String note = getNote();
				if(busBook.checkIDBook(IDBook) && busBook.checkHeadBook(IDHeadBook)) {
					busBook.updateBook(IDBook, IDHeadBook, status, state, note);
					JOptionPane.showMessageDialog(inputIDBook, "UPDATE SUCCESS");
					inputIDBook.setText("");
					inputIDHeadBookRepair.setText("");
					taNote.setText("");
				}else JOptionPane.showMessageDialog(inputIDBook, "UPDATE FAIL");
			}
		});
	}
	
	public void eventClear() {
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				
				String IDBook = inputIDClear.getText();
				if(busBook.checkIDClear(IDBook)) {
					int status = busBook.clearBook(IDBook);
					if(status>0) {
						JOptionPane.showMessageDialog(inputIDBook, "CLEAR SUCCESS");
						inputIDClear.setText("");
						String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
						dataTableClear = busBook.takeSelectBook();
						model = new DefaultTableModel(dataTableClear, colum);
						tableClear.setModel(model);
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
						tableClear.getColumnModel().getColumn(0).setPreferredWidth(0);
						tableClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
						tableClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
						tableClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
						tableClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
						tableClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
						tableClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
					}
					else JOptionPane.showMessageDialog(inputIDBook, "CLEAR FAIL");
				}else JOptionPane.showMessageDialog(inputIDBook, "CLEAR FAIL");
			}
		});
	}
		
	
	public void eventSelectBook() {
		btnSelectBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				guiselectBook();
				panel.setVisible(true);
			}
		});
		
		btnBackB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				guiRepairBook();
				BUSBook busBook = new BUSBook();
				if(table.getSelectedRow()>=0 && inputIDBook.getText().equals("") == false) {
					cbbStatus.setSelectedItem(busBook.loadStatusMenuRepair(inputIDBook.getText()));
					cbbState.setSelectedItem(busBook.loadStateMenuRepair(inputIDBook.getText()));
				}
				
				panel.setVisible(true);
			}
		});
	
		btnChooseBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRowSelectBook();
				BUSBook busBook = new BUSBook();
				if(table.getSelectedRow()>=0) {
					taNote.setText(busBook.loadNoteMenuRepair(inputIDBook.getText()));
					inputIDHeadBookRepair.setText(busBook.loadIDHeadBookMenuRepair(inputIDBook.getText()));
				}
			}
		});

		btnFindBookRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUSBook busBook = new BUSBook();
				String colum[] = {"IDBook","IDHeadBook","name","status","state","note"};
				dataRow = busBook.findBookFollowID(inputIDRepair.getText());
				model = new DefaultTableModel(dataRow,colum);
				table.setModel(model);
				CellTableCenter(table);
			}
		});
	}
	
	public void eventSelectHeadBook() {
		
		btnSelectHeadBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				guiTakeHeadbook();
				panel.setVisible(true);
			}
		});
		
		btnBackHB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				if(identifyFunction == 1) {
					guiAddBook();
				}else guiRepairBook();
				panel.setVisible(true);
			}
		});
		
		btnChooseHB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(identifyFunction == 1) getRowSelectHeadBookAdd();
				else getRowSelectHeadBookRepair();
			}
		});
		
		btnResetHB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(identifyFunction == 1) inputIDHeadBook.setText("");
				else inputIDHeadBookRepair.setText("");
			}
		});
	}
	
	public void getRowSelectHeadBookRepair() {
		if(table.getSelectedRow() == -1) return;
		int indexRow = table.getSelectedRow();
		String ID = (String)table.getValueAt(indexRow, 0);
		inputIDHeadBookRepair.setText(ID);
	}
	
	public void getRowSelectHeadBookAdd() {
		if(table.getSelectedRow() == -1) return;
		int indexRow = table.getSelectedRow();
		String ID = (String)table.getValueAt(indexRow, 0);
		inputIDHeadBook.setText(ID);
	}
	
	public void getRowSelectBook() {
		if(table.getSelectedRow() == -1) return;
		int indexRow = table.getSelectedRow();
		String ID = (String)table.getValueAt(indexRow, 0);
		inputIDBook.setText(ID);
	}
	
	public void eventButton() {
		eventAdd();
		eventRepair();
		eventClear();
		menuFindEventID();
		eventBtnFollowIDClear();
		evenBtnFollowNameClear();
		eventBtnLoadDataClear();
	}
}