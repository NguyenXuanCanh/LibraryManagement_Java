import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GuiHeadBook {
	
	protected JPanel panel;
	
	protected JButton btnAdd;
	
	protected JButton btnClear;
	
	protected JButton btnRepair;
	
	protected JButton btnBackAdd;
	
	protected JButton btnBackRepair;
	
	protected JButton btnSelect;
	
	protected JButton btnUnSelect;
	
	protected JButton selectAuthor;
	
	protected JButton btnLoadData;
	
	protected JTextField inputFind;
	
	protected JButton btnFindName;
	
	protected JButton btnFindCategory;
	
	protected JButton btnFindAuthor;
	
	protected JButton btnFindID;
	
	protected JTextField inputID;
	
	protected JTextField inputNameBook;
	
	protected JComboBox barCategory;
	
	protected JComboBox barLanguage;
	
	protected JComboBox barPubCompany;
	
	protected JTextField inputAuthor;
	
	protected JTextField inputPrice;
	
	protected JTextField inputNumberBorrow;
	
	protected JButton menuAdd;
	
	protected JButton menuRepair;
	
	protected JButton menuClear;
	
	protected JButton menuFind;
	
	protected JButton menuImport;
	
	protected JButton menuExport;
	
	protected JButton menuPrint;
	
	protected JButton menuShowData;
	
	protected JPanel panelLayerOne;
	
	protected JPanel panelLayerTwo;
	
	protected JPanel panelLayerThree;
	
	protected JPanel panelLayerFour;
	
	protected JPanel panelLayerFive;
	
	protected JPanel panelLayerSix;
	
	protected JPanel panelLayerSeven;
	
	protected JPanel panelLayerEight;
	
	protected JPanel panelLayerNight;
	
	protected JPanel panelNorth;
	
	protected JPanel panelWest;
	
	protected JPanel panelCenter;
	
	protected JPanel panelEast;
	
	protected JPanel panelSouth;
	
	protected DefaultTableModel tableModel;
	
	protected String [][] dataRowAuthor;
	
	protected int amountRow = 0;
	
	protected JLabel displayAuthorselect;
	
	protected JLabel lblID;
	
	protected JLabel lblNameBook;
	
	protected JLabel lblAuthor;
	
	protected JLabel lblPub;
	
	protected JLabel lblCategory;
	
	protected JLabel lblLanguage; 
	
	protected JLabel lblPrice;
	
	protected JLabel lblAuthorAlready;
	
	protected JTable tableAuthor;
	
	protected JLabel lblIDHeadBook;
	
	protected int status;
	
	protected String dataFind[][];
	
	protected JButton btnBackHeadBook;
	
	protected JButton btnChooseHeadBook;
	
	protected JButton btnReset;
	
	protected JTable tableHeadBook;
	
	protected JScrollPane tableScroll;
	
	protected String[][] dataRowHeadBook;
	
	protected String [][] dataTableClear;
	
	protected JTable tableClear;
	
	protected DefaultTableModel model;
	
	protected JTextField inputFindClear;
	
	protected JButton FindIDClear;
	
	protected JButton FindNameClear;
	
	protected JButton loadDataClear;

	GuiHeadBook(){
		
		bootPanel();
		
		bootComboBox();
		
		bootTextField();
		
		bootBtn();
		
		bootJLabel();
		
		bootOther();
		
		eventButton();
		
		eventSelectHeadBook();
		
		eventFindIDClear();
		
		eventFindNameClear();
		
		eventBtnChooseDataClear();
		
		eventExport();
	}
	
	public void bootBtn() {
		menuAdd = new JButton("ADD");
		
		menuRepair = new JButton("REPAIR");
		
		menuClear = new JButton("CLEAR");
		
		menuFind = new JButton("FIND");
		
		menuImport = new JButton("IMPORT");
		
		menuExport = new JButton("EXPORT - IMPORT");
		
		menuPrint = new JButton("PRINT");
		
		menuShowData = new JButton("DATA");
		
		btnAdd = new JButton("ADD");
		
		btnRepair = new JButton("Repair");
		
		btnLoadData = new JButton("+");
		
		btnClear = new JButton("Clear");
		
		btnBackAdd = new JButton("back");
		
		btnBackRepair = new JButton("back");
		
		selectAuthor = new JButton("+");
		
		btnSelect = new JButton("select");
		
		btnUnSelect = new JButton("UnSelect");
		
		btnBackHeadBook = new JButton("Back");
		
		btnChooseHeadBook = new JButton("Select");
		
		btnReset = new JButton("Reset");
		
		FindIDClear = new JButton("Follow ID");
		
		FindNameClear = new JButton("Follow Name");
		
		loadDataClear = new JButton("Choose");
	}
	
	public void bootTextField() {
		inputNameBook = new JTextField();
		
		inputAuthor = new JTextField();
		
		inputPrice = new JTextField();
		
		inputNumberBorrow = new JTextField();
		
		inputID = new JTextField();
		
		inputFind = new JTextField();
		
		inputFindClear = new JTextField();
	}
	
	public void bootPanel() {
		panelNorth = new JPanel();
		
		panelWest = new JPanel();
		
		panelCenter = new JPanel();
		
		panelEast = new JPanel();
		
		panelSouth = new JPanel();
		
		panel = new JPanel();
		
		panel.setBounds(0, 0, 1000, 500);
	}
	
	public void bootComboBox() {
		barPubCompany = new JComboBox();
		
		barCategory = new JComboBox();
		
		barLanguage = new JComboBox();
	}
	
	public void bootOther(){
		dataRowAuthor = new String[100][2];
		
		amountRow = 0;
		
		status = 0;
		
		model = new DefaultTableModel();
		
		tableHeadBook = new JTable();
		
		tableClear = new JTable();
		
		tableScroll = new JScrollPane();
		
	}
	
	public void bootJLabel() {
		lblID = new JLabel("ID HeadBook");
		
		lblNameBook = new JLabel("Name Book");
		
		lblAuthor = new JLabel("Author new");
		
		lblPub = new JLabel("Publish");
		
		lblCategory = new JLabel("Category");
		
		lblLanguage = new JLabel("Language");
		
		lblPrice = new JLabel("Price");
		
		lblAuthorAlready = new JLabel("Author Old");
		
		displayAuthorselect = new JLabel();
		
		lblIDHeadBook = new JLabel();
	}

	public String getNameHeadBook() {
		return this.inputNameBook.getText();
	}
	
	public String getNameAuthor() {
		return this.inputAuthor.getText();
	}
	
	public String getPrice() {
		return this.inputPrice.getText();
	}
	
	public String getIDHeadBook() {
		return this.inputID.getText();
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
	
	public void decorationMenuChild() {
		decoration(menuAdd);
		
		decoration(menuRepair);
		
		decoration(menuClear);
		
		decoration(menuFind);
		
		decoration(menuImport);
		
		decoration(menuExport);
		
		decoration(menuPrint);
		
		decoration(menuShowData);
	}
	
	public void fixMenuChild(MyFrame frame) {
		frame.panelTop.add(menuAdd);
		
		frame.panelTop.add(menuRepair);
		
		frame.panelTop.add(menuClear);
		
		frame.panelTop.add(menuFind);
		
		frame.panelTop.add(menuExport);
		
	}
	
	public void creatMenu(MyFrame frame) {
		
		decorationMenuChild();
		
		fixMenuChild(frame);
		
		eventMenuAdd(frame);
		
		eventMenuRepair(frame);
		
		eventMenuClear(frame);
		
		eventMenuFind(frame);
		
		eventMenuShowData(frame);
		
		eventChooseAuthor(frame);

	}
	
	public void eventChooseAuthor(MyFrame frame) {
		
		eventDisplayTableAuthor(frame);
		
		eventButtonBackAuthor(frame);
		
	}
	
	public void eventDisplayTableAuthor(MyFrame frame) {
		selectAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				if(status == 1) {
					selectAuthor(btnBackAdd);
				}else selectAuthor(btnBackRepair);
				panel.setVisible(true);
			}
		});
	}
	
	public void eventButtonBackAuthor(MyFrame frame) {
		
		btnBackAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiAddHeadBook();
				panel.setVisible(true);
			}
		});
		
		btnBackRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				guiRepairHeadBook();
				panel.setVisible(true);
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
				
				resetTextField();
				
				guiAddHeadBook();
				
				panel.setVisible(true);
				
				dataRowAuthor = new String[100][2];
				
				amountRow = 0;
				
				status = 1;
			}
		});
		
	}
	
	public void eventMenuRepair(MyFrame frame) {
		menuRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				
				frame.panelContent.add(panel);
				
				panel.removeAll();
				
				panel.setVisible(false);
				
				resetTextField();
				
				guiRepairHeadBook();
				
				panel.setVisible(true);
				
				dataRowAuthor = new String[100][2];
				
				amountRow = 0;
				
				status = 2;
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
				
				resetTextField();
				
				guiClearHeadBook();
				
				panel.setVisible(true);
				
				dataRowAuthor = new String[100][2];
				
				amountRow = 0;
				
				status = 3;
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
				resetTextField();
				guiFindHeadBook();
				panel.setVisible(true);
				status = 4;
			}
		});
	}
	
	public void eventExport() {
		menuExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExportHeadBook export = new ExportHeadBook();
				export.guiDataExport();
			}
		});
	}
	
	public void eventMenuShowData(MyFrame frame) {
		menuShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.add(panel);
				panel.removeAll();
				panel.setVisible(false);
				resetTextField();
				guiSHowdata();
				panel.setVisible(true);
				status = 4;
			}
		});
	}
	
	public void guiSHowdata() {
		BusHeadBook bus = new BusHeadBook();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
		String data[][] = bus.showData();
		for(int i = 0 ; i<data.length; i++) {
			data[i][5] = bus.findAuthorHeadBook(Integer.parseInt(data[i][0]));
		}
		tableModel = new DefaultTableModel(data, column);
		JTable table = new JTable();
		table.setModel(tableModel);
		table.setRowHeight(30);
		table.setEnabled(false);
		CellTableCenter(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setBounds(10, 30, 965, 400);
		panel.add(tableScroll);
	}

	public void guiAddHeadBook(){
		
		panel.setLayout(null);
		panel.setBackground(Color.white);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
		JLabel label = new JLabel("ADD HEAD BOOK");
		label.setFont(font);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 10, 1000, 30);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTitle.setBackground(Color.white);
		panelTitle.add(label);
		
		JPanel panelLabel = new JPanel();
		JPanel panelInput = new JPanel();
		
		panelLabel.setBounds(120, 50, 100, 330);
		panelLabel.setBackground(Color.white);
		panelLabel.setLayout(new GridLayout(7,1,0,20));
		
		JLabel nameBook1 = new JLabel("Name book");
		nameBook1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
//		JLabel nameBook2 = new JLabel("Author new");
//		nameBook2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		JLabel nameBook3 = new JLabel("Publish");
		nameBook3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		JLabel nameBook4 = new JLabel("Category");
		nameBook4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		JLabel nameBook5 = new JLabel("Language");
		nameBook5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		JLabel nameBook6 = new JLabel("Price");
		nameBook6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		JLabel AuthorOld = new JLabel("Author Old");
		AuthorOld.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		panelLabel.add(nameBook1);
//		panelLabel.add(nameBook2);
		panelLabel.add(AuthorOld);
		panelLabel.add(nameBook3);
		panelLabel.add(nameBook4);
		panelLabel.add(nameBook5);
		panelLabel.add(nameBook6);
		
		panelInput.setBounds(250, 50, 500, 330);
		panelInput.setBackground(Color.white);
		panelInput.setLayout(new GridLayout(7,1,0,20));
		
		loadComboBox();
		displayAuthorselect.setBorder(BorderFactory.createLineBorder(Color.black));
		panelInput.add(inputNameBook);
//		panelInput.add(inputAuthor);
		panelInput.add(displayAuthorselect);
		panelInput.add(barPubCompany);
		panelInput.add(barCategory);
		panelInput.add(barLanguage);
		panelInput.add(inputPrice);
	
		btnAdd.setBounds(400, 380, 200, 50);
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(Color.decode("#ff0000"));
		btnAdd.setForeground(Color.white);
		selectAuthor.setForeground(Color.white);
		selectAuthor.setBackground(Color.decode("#1a89cc"));
		
		selectAuthor.setBounds(760, 99, 50, 30);
		
		panel.add(panelTitle);
		panel.add(panelLabel);
		panel.add(panelInput);
		panel.add(btnAdd);
		panel.add(selectAuthor);

	}
	
	public void bootPanelLayerGuiRepair() {
		panelLayerOne = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 8));
		panelLayerTwo = new JPanel(new FlowLayout(FlowLayout.CENTER, 26, 8));
		panelLayerThree = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 8));
		panelLayerFour = new JPanel(new FlowLayout(FlowLayout.CENTER, 53, 8));
		panelLayerFive = new JPanel(new FlowLayout(FlowLayout.CENTER, 37, 8));
		panelLayerSix = new JPanel(new FlowLayout(FlowLayout.CENTER, 43, 8));
		panelLayerSeven = new JPanel(new FlowLayout(FlowLayout.CENTER, 68, 8));
		panelLayerEight = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
		panelLayerNight = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 8));
	
	}
	
	public void setBackGroundPanelGuiRepair() {
		panelLayerOne.setBackground(Color.white);
		panelLayerTwo.setBackground(Color.white);
		panelLayerThree.setBackground(Color.white);
		panelLayerFour.setBackground(Color.white);
		panelLayerFive.setBackground(Color.white);
		panelLayerSix.setBackground(Color.white);
		panelLayerSeven.setBackground(Color.white);
		panelLayerEight.setBackground(Color.white);
		panelLayerNight.setBackground(Color.white);
		panelNorth.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		panelWest.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		barCategory.setBackground(Color.white);
		barLanguage.setBackground(Color.white);
		barPubCompany.setBackground(Color.white);
		panel.setBackground(Color.white);
	}
	
	public void removeAllInPanelLayer() {
		panelLayerOne.removeAll();
		panelLayerTwo.removeAll();
		panelLayerThree.removeAll();
		panelLayerFour.removeAll();
		panelLayerFive.removeAll();
		panelLayerSix.removeAll();
		panelLayerSeven.removeAll();
		panelLayerEight.removeAll();
		panelLayerNight.removeAll();
	}
	
	public void setSize() {
		panelNorth.setPreferredSize(new Dimension(985, 30));
		panelWest.setPreferredSize(new Dimension(100, 450));
		panelEast.setPreferredSize(new Dimension(100, 450));
		btnLoadData.setPreferredSize(new Dimension(100, 35));
		lblIDHeadBook.setPreferredSize(new Dimension(270, 35));
		inputNameBook.setPreferredSize(new Dimension(385, 35));
		inputAuthor.setPreferredSize(new Dimension(385, 35));
		barPubCompany.setPreferredSize(new Dimension(385, 35));
		barLanguage.setPreferredSize(new Dimension(385, 35));
		displayAuthorselect.setPreferredSize(new Dimension(315, 35));
		btnRepair.setPreferredSize(new Dimension(150, 40));
		barCategory.setPreferredSize(new Dimension(385, 35));
		inputPrice.setPreferredSize(new Dimension(385, 35));
		//
	}
	
	public void addNightLayerIntoCenter() {
		panelCenter.add(panelLayerOne);
		panelCenter.add(panelLayerTwo);
//		panelCenter.add(panelLayerThree);
		panelCenter.add(panelLayerNight);
		panelCenter.add(panelLayerFour);
		panelCenter.add(panelLayerFive);
		panelCenter.add(panelLayerSix);
		panelCenter.add(panelLayerSeven);
		panelCenter.add(panelLayerEight);
	}
	
	public void decorateButton() {
		btnLoadData.setFocusPainted(false);
		btnLoadData.setBorderPainted(false);
		btnRepair.setFocusPainted(false);
		btnRepair.setBorderPainted(false);
		displayAuthorselect.setBorder(BorderFactory.createLineBorder(Color.black));
		btnLoadData.setBackground(Color.decode("#1a89cc"));
		btnRepair.setBackground(Color.decode("#ff0000"));
		btnRepair.setForeground(Color.white);
		btnLoadData.setForeground(Color.white);
	}
	
	public void setFont() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
		lblID.setFont(font);
		lblNameBook.setFont(font);
		lblAuthor.setFont(font);
		lblPub.setFont(font);
		lblCategory.setFont(font);
		lblLanguage.setFont(font);
		lblPrice.setFont(font);
		lblAuthorAlready.setFont(font);
	}
	
	public void addComponentNightLayer() {
		lblIDHeadBook.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLayerOne.add(lblID);
		panelLayerOne.add(lblIDHeadBook);
		panelLayerOne.add(btnLoadData);
		
		panelLayerTwo.add(lblNameBook);
		panelLayerTwo.add(inputNameBook);
		
//		panelLayerThree.add(lblAuthor);
//		panelLayerThree.add(inputAuthor);
		
		panelLayerFour.add(lblPub);
		panelLayerFour.add(barPubCompany);
		
		panelLayerFive.add(lblLanguage);
		panelLayerFive.add(barLanguage);
		
		panelLayerSix.add(lblCategory);
		panelLayerSix.add(barCategory);
	
		panelLayerSeven.add(lblPrice);
		panelLayerSeven.add(inputPrice);
		
		panelLayerEight.add(btnRepair);
		
		panelLayerNight.add(lblAuthorAlready);
		panelLayerNight.add(displayAuthorselect);
		panelLayerNight.add(selectAuthor);
	}
	
	public void setLayoutPanel() {
		
		panelCenter.setLayout(new GridLayout(9,1));
		panel.setBounds(0,0,985,450);
		panel.setLayout(new BorderLayout());
		
		panel.add(panelNorth,BorderLayout.NORTH);
		panel.add(panelCenter,BorderLayout.CENTER);
		panel.add(panelSouth,BorderLayout.SOUTH);
		panel.add(panelWest,BorderLayout.WEST);
		panel.add(panelEast,BorderLayout.EAST);
	
	}
	
	public void removeFourDirection() {
		panelNorth.removeAll();
		panelCenter.removeAll();
		panelSouth.removeAll();
		panelWest.removeAll();
		panelEast.removeAll();
		panelNorth.setLayout(new FlowLayout());
	}
	
	public void setTitle() {
		JLabel title = new JLabel("REPAIR HEAD BOOK");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		panelNorth.add(title);
	}
	
	public void guiRepairHeadBook() {
		
		setLayoutPanel();
		
		bootPanelLayerGuiRepair();
		
		removeFourDirection();
		
		setTitle();
		
		removeAllInPanelLayer();
		
		setFont();
		
		setBackGroundPanelGuiRepair();
		
		loadComboBox();
		
		setSize();
		
		decorateButton();
		
		addComponentNightLayer();
	
		addNightLayerIntoCenter();
		
		selectAuthor.setForeground(Color.white);
		selectAuthor.setBackground(Color.decode("#1a89cc"));
	}
	
	public void guiClearHeadBook() {
		panel.setBounds(0,0,985,500);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel lblTitle = new JLabel("CLEAR HEAD BOOK");
		lblTitle.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
		lblTitle.setBounds(350, 5, 300, 40);
		
		JLabel labelID = new JLabel("Enter ID Head Book");
		labelID.setBounds(140, 50, 200, 30);
		labelID.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
		
		inputID.setBounds(300, 50, 300, 30);
		
		btnClear.setFocusPainted(false);
		btnClear.setBorderPainted(false);
		btnClear.setBounds(620, 50, 80, 30);
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel.add(lblTitle);
		panel.add(labelID);
		panel.add(inputID);
		panel.add(btnClear);
		
		BusHeadBook bus = new BusHeadBook();
		String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
		dataTableClear = bus.showData();
		model = new DefaultTableModel(dataTableClear, column);
		tableClear.setModel(model);
		
		JTableHeader header = tableClear.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableClear.setTableHeader(header);
		tableClear.setSelectionForeground(Color.white);
		tableClear.setSelectionBackground(Color.decode("#28b928"));
		tableClear.setGridColor(Color.white);
		tableClear.setFocusable(false);
		tableClear.setFillsViewportHeight(true);
		tableClear.setRowHeight(25);
		
		JScrollPane tableScroll = new JScrollPane(tableClear);
		tableScroll.setBounds(0, 170, 980, 250);
		panel.add(tableScroll);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableClear.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableClear.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		JLabel lblFind = new JLabel("Find Head Book");
		lblFind.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
		lblFind.setBounds(80, 120, 150, 30);
		
		inputFindClear.setBounds(210, 120, 300, 30);
		
		FindIDClear.setBounds(520, 120, 120, 30);
		FindNameClear.setBounds(650, 120, 120, 30);
		
		loadDataClear.setBounds(720, 50, 100, 30);
		
		btnClear.setForeground(Color.white);
		loadDataClear.setForeground(Color.white);
		FindNameClear.setForeground(Color.white);
		FindIDClear.setForeground(Color.white);
		btnClear.setBackground(Color.decode("#ff0000"));
		loadDataClear.setBackground(Color.decode("#1a89cc"));
		FindNameClear.setBackground(Color.decode("#803ec0"));
		FindIDClear.setBackground(Color.decode("#f7941e"));
		
		panel.add(lblFind);
		panel.add(inputFindClear);
		panel.add(FindIDClear);
		panel.add(FindNameClear);
		panel.add(loadDataClear);
		
		// inputFindClear,FindIDClear,FindNameClear
	}
	
	public int checkIDFindClear() {
		String temp = inputFindClear.getText();
		int ID = -1;
		try {
			ID = Integer.parseInt(temp);
		}catch(Exception e) {
		}
		
		return ID;
	}
	
	public void eventFindIDClear() {
		FindIDClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = inputFindClear.getText();
				BusHeadBook bus = new BusHeadBook();
				String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
				
				if(checkIDFindClear() == -1) {
					dataTableClear = new String[0][7];
					model = new DefaultTableModel(dataTableClear,column);
					tableClear.setModel(model);
					return;
				}
				
						
				String result[] = bus.findBookFollowID(checkIDFindClear());
				if(result[0].equals("")!=true) dataTableClear = new String[1][7];
				else { 
					dataTableClear = new String[0][7];
					model = new DefaultTableModel(dataFind,column);
					tableClear.setModel(model);
					return;
				}
						
				dataTableClear[0][0] = result[0]; dataTableClear[0][1] = result[1];
				dataTableClear[0][2] = result[2]; dataTableClear[0][3] = result[3];
				dataTableClear[0][4] = result[4]; dataTableClear[0][6] = result[5];
				dataTableClear[0][5] = bus.findAuthorHeadBook(Integer.parseInt(dataTableClear[0][0]));
						
				model = new DefaultTableModel(dataTableClear,column);
				tableClear.setModel(model);
				CellTableCenter(tableClear);
					
			}
		});
	}
	
	public void eventBtnChooseDataClear() {
		loadDataClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableClear.getSelectedRow();
				if(row <0) return;
				String ID = (String) tableClear.getValueAt(row, 0);
				inputID.setText(ID);
			}
		});
	}
	
	public void eventFindNameClear() {
		
		FindNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = inputFindClear.getText();
				BusHeadBook bus = new BusHeadBook();
				String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
				dataTableClear = bus.findBookFollowName(name);
				for(int i = 0 ; i<dataTableClear.length; ++i) {
					dataTableClear[i][5] = bus.findAuthorHeadBook(Integer.parseInt(dataTableClear[i][0]));
				}
				model = new DefaultTableModel(dataTableClear, column);
				tableClear.setModel(model);
				
			}
		});
	}
	
	public void selectAuthor(JButton btnBack) {
		JLabel lblSelectAuthor = new JLabel("Select Author");
		lblSelectAuthor.setPreferredSize(new Dimension(120, 40));
		lblSelectAuthor.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 17));
		
		panel.removeAll();
		panel.setBackground(Color.white);
		
		String column[] = {"ID", "name"};
		
		BusHeadBook bus = new BusHeadBook();
		
		String dataRow[][] = bus.loadAuthor();
		
		tableAuthor = new JTable(dataRow, column);
		
		JScrollPane tableScroll = new JScrollPane(tableAuthor);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableAuthor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableAuthor.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		
		
		JTableHeader header = tableAuthor.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableAuthor.setTableHeader(header);
		tableAuthor.setSelectionForeground(Color.white);
		tableAuthor.setGridColor(Color.white);
		tableAuthor.setSelectionBackground(Color.decode("#28b928"));
		tableAuthor.setFocusable(false);
		tableAuthor.setRowHeight(25);
		tableAuthor.setFillsViewportHeight(true);
		
		
		JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelNorth.setPreferredSize(new Dimension(500, 60));
		panelNorth.setBackground(Color.white);
		
		btnSelect.setPreferredSize(new Dimension(200, 40));
		btnUnSelect.setPreferredSize(new Dimension(200, 40));
		btnBack.setPreferredSize(new Dimension(200,40));
		
		btnSelect.setForeground(Color.white);
		btnUnSelect.setForeground(Color.white);
		btnBack.setForeground(Color.white);
		
		btnSelect.setBackground(Color.decode("#ff0000"));
		btnUnSelect.setBackground(Color.decode("#1a89cc"));
		btnBack.setBackground(Color.decode("#f7941e"));
		
		panelNorth.add(lblSelectAuthor);
		panelNorth.add(btnSelect);
		panelNorth.add(btnUnSelect);
		panelNorth.add(btnBack);
		
		panel.setLayout(new BorderLayout());
		
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		
		panelWest.setPreferredSize(new Dimension(80,100));
		panelEast.setPreferredSize(new Dimension(80,100));
		panelWest.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		
		panel.add(panelWest,BorderLayout.WEST);
		panel.add(panelEast,BorderLayout.EAST);
		panel.add(panelNorth,BorderLayout.NORTH);
		panel.add(tableScroll, BorderLayout.CENTER);
		
		
	}
	
	public void takeAuthor(){
		
		int flag = 1;
		int row = tableAuthor.getSelectedRow();
		if(row <0) return;
		String ID = (String) tableAuthor.getValueAt(row, 0);
		
		for(int i = 0; i<amountRow; ++i) {
			if(ID.equals(dataRowAuthor[i][0]) == true) {
				flag = 0;
				break;
			}
		}
		
		if(flag == 1) {
			dataRowAuthor[amountRow][0] = (String) tableAuthor.getValueAt(row, 0);
			dataRowAuthor[amountRow][1] = (String) tableAuthor.getValueAt(row, 1);
			amountRow++;
		}
	}
	
	public void cancelSelectAuthor() {
		int flag = 0;
		int row = tableAuthor.getSelectedRow();
		if(row<0) return;
		String ID = (String) tableAuthor.getValueAt(row, 0);
		int index = 0;
		for(int i = 0; i<amountRow; ++i) {
			if(ID.equals(dataRowAuthor[i][0]) == true) {
				flag = 1;
				index = i;
				break;
			}
		}
		if(flag == 1) {
			for(int i = index ;i<amountRow ;i++) {
				dataRowAuthor[i][0] = dataRowAuthor[i+1][0];
				dataRowAuthor[i][1] = dataRowAuthor[i+1][1];
			}
			amountRow--;
		}
	}
	

	
	public void guiFindHeadBook() {
		panel.setBounds(0,0,985,500);
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.black);
		
		panelNorth.setPreferredSize(new Dimension(985, 80));
		panelWest.setPreferredSize(new Dimension(10, 450));
		panelEast.setPreferredSize(new Dimension(10, 450));
		
		panelNorth.setBackground(Color.white);
		panelWest.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		
		JLabel lblFind = new JLabel("Find Book");
		lblFind.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		
		btnFindID = new JButton("Follow ID");
		btnFindName = new JButton("Follow Name"); 
		
		btnFindID.setPreferredSize(new Dimension(120, 40));
		btnFindName.setPreferredSize(new Dimension(120, 40));
		
		btnFindID.setFocusPainted(false);
		btnFindName.setFocusPainted(false);
		
		btnFindID.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFindName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panelNorth.removeAll();
		
		btnFindID.setForeground(Color.white);
		btnFindName.setForeground(Color.white);
		
		btnFindID.setBackground(Color.decode("#ff0000"));
		btnFindName.setBackground(Color.decode("#1a89cc"));
		
		inputFind.setPreferredSize(new Dimension(450,40));
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 15 , 20));
		panelNorth.add(lblFind);
		panelNorth.add(inputFind);
		panelNorth.add(btnFindID);
		panelNorth.add(btnFindName);
		
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelWest, BorderLayout.WEST);
		panel.add(panelEast, BorderLayout.EAST);
		
		BusHeadBook bus = new BusHeadBook();
		
		String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
		String data[][]= bus.showData();
		
		tableModel = new DefaultTableModel(data,column);
	
		JTable table = new JTable();
		table.setModel(tableModel);
		table.setRowHeight(30);
		table.setBackground(Color.white);
		table.setGridColor(Color.black);
	
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
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
	
		
		eventFindBookID(table,column);
		eventFindBookName(table,column);
		panelCenter.removeAll();
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(tableScroll, BorderLayout.CENTER);
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
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
	}
	
	public void eventFindBookID(JTable table, String column[]) {
		BusHeadBook bus = new BusHeadBook();
		btnFindID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getIDFind() == -1) {
					dataFind = new String[0][7];
					tableModel = new DefaultTableModel(dataFind,column);
					table.setModel(tableModel);
					return;
				}
				String result[] = bus.findBookFollowID(getIDFind());
				if(result[0].equals("")!=true) dataFind = new String[1][7];
				else { 
					dataFind = new String[0][7];
					tableModel = new DefaultTableModel(dataFind,column);
					table.setModel(tableModel);
					return;
				}
				
				dataFind[0][0] = result[0]; dataFind[0][1] = result[1];
				dataFind[0][2] = result[2]; dataFind[0][3] = result[3];
				dataFind[0][4] = result[4]; dataFind[0][6] = result[5];
				dataFind[0][5] = bus.findAuthorHeadBook(getIDFind());
				
				tableModel = new DefaultTableModel(dataFind,column);
				table.setModel(tableModel);
				CellTableCenter(table);
			}
		});
	}
	
	public void eventFindBookName(JTable table, String column[]) {
		BusHeadBook bus = new BusHeadBook();
		
		btnFindName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getNameBookFind().equals("") == true) return;
				dataFind= bus.findBookFollowName(getNameBookFind());
				for(int i = 0 ; i<dataFind.length ; i++) {
					dataFind[i][5] = bus.findAuthorHeadBook(Integer.parseInt(dataFind[i][0]));
				}
				tableModel = new DefaultTableModel(dataFind,column);
				table.setModel(tableModel);
				CellTableCenter(table);
			}
		});
	}
	
	public int getIDFind() {
		String temp = inputFind.getText();
		int ID = -1;
		try {
			ID = Integer.parseInt(temp);
		}catch(Exception e) {
		}
		
		return ID;
	}
	
	public String getNameBookFind() {
		return this.inputFind.getText();
	}
	
	public void eventAddHeadBook() {
		String nameHeadBook = getNameHeadBook();
		String nameAuthor = getNameAuthor();
		String price = getPrice();
		String pubCompany = (String) barPubCompany.getItemAt(barPubCompany.getSelectedIndex());
		String language = (String) barLanguage.getItemAt(barLanguage.getSelectedIndex());
		String category = (String) barCategory.getItemAt(barCategory.getSelectedIndex());
		
		BusHeadBook bus = new BusHeadBook();
		DTOLanguage listLanguage[] = bus.loadLanguage();
		DTOCategory listCategory[] = bus.loadCategory();
		DTOPublishCompany listPubCompany[] = bus.loadPubCompany();
		
		int IDLanguage = 0;
		int IDCategory = 0;
		int IDPubCompany = 0;
		
		for(int i = 0; i<listLanguage.length; ++i) {
			if(listLanguage[i].nameLanguage.equals(language) == true) {
				IDLanguage = listLanguage[i].IDLanguage;
				break;
			}
		}
		
		for(int j = 0; j<listCategory.length; ++j) {
			if(listCategory[j].nameCategory.equals(category) == true) {
				IDCategory = listCategory[j].IDCategory;
				break;
			}
		}
		
		for(int k = 0; k<listPubCompany.length; ++k) {
			if(listPubCompany[k].namePubCompany.equals(pubCompany) == true) {
				IDPubCompany = listPubCompany[k].IDPubCompany;
				break;
			}
		}
		
		BusHeadBook busHeadBook = new BusHeadBook();
		if(busHeadBook.checkNameHeadBook(nameHeadBook) &&
		    busHeadBook.checkPrice(price)) {
			int status = busHeadBook.addHeadBook(nameHeadBook, nameAuthor, price, IDCategory, IDLanguage, IDPubCompany,dataRowAuthor,amountRow);
			if(status == 1) JOptionPane.showMessageDialog(inputNameBook,"ADD SUCCESS A HEAD BOOK");
			//inputNameBook,inputPrice,displayAuthorselect
			inputNameBook.setText("");
			inputPrice.setText("");
			displayAuthorselect.setText("");
		}
	}
	
	public void eventClearHeadBook() {
		String ID = inputID.getText();
		BusHeadBook busHeadBook = new BusHeadBook();
		if(busHeadBook.checkID(ID) == true) {
			busHeadBook.clearHeadBook(ID);
			JOptionPane.showMessageDialog(inputID, "CLEAR SUCCESSFULLY");
			inputID.setText("");
		}else JOptionPane.showMessageDialog(inputID, "CLEAR Fail");
	}
	
	public void evenRepairHeadBook() {
		BusHeadBook busHeadBook = new BusHeadBook();
		String IDHeadBook = lblIDHeadBook.getText();
		String nameHeadBook = getNameHeadBook();
		String nameAuthor = getNameAuthor();
		String price = getPrice();
		String pubCompany = (String) barPubCompany.getItemAt(barPubCompany.getSelectedIndex());
		String language = (String) barLanguage.getItemAt(barLanguage.getSelectedIndex());
		String category = (String) barCategory.getItemAt(barCategory.getSelectedIndex());
		
		
		DTOLanguage listLanguage[] = busHeadBook.loadLanguage();
		DTOCategory listCategory[] = busHeadBook.loadCategory();
		DTOPublishCompany listPubCompany[] = busHeadBook.loadPubCompany();
		
		int IDLanguage = 0;
		int IDCategory = 0;
		int IDPubCompany = 0;
		
		for(int i = 0; i<listLanguage.length; ++i) {
			if(listLanguage[i].nameLanguage.equals(language) == true) {
				IDLanguage = listLanguage[i].IDLanguage;
				break;
			}
		}
		
		for(int j = 0; j<listCategory.length; ++j) {
			if(listCategory[j].nameCategory.equals(category) == true) {
				IDCategory = listCategory[j].IDCategory;
				break;
			}
		}
		
		for(int k = 0; k<listPubCompany.length; ++k) {
			if(listPubCompany[k].namePubCompany.equals(pubCompany) == true) {
				IDPubCompany = listPubCompany[k].IDPubCompany;
				break;
			}
		}
		
		if(busHeadBook.checkID(IDHeadBook) &&
		   busHeadBook.checkNameHeadBook(nameHeadBook) && busHeadBook.checkPrice(price)) {
			int status = busHeadBook.repairHeadBook(IDHeadBook, nameHeadBook, nameAuthor, price, IDCategory, IDLanguage, IDPubCompany,dataRowAuthor,amountRow);
			if(status == 1) JOptionPane.showMessageDialog(inputNameBook, "REPAIR SUCCESS");
			
		}else JOptionPane.showMessageDialog(inputNameBook, "REPAIR FAIL");
	}
	
	public void selectHeadBook() {
		panel.setVisible(false);
		panelNorth.removeAll();
		panelCenter.removeAll();
		panel.removeAll();
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		panel.add(panelNorth,BorderLayout.NORTH);
		
		panel.setBackground(Color.white);
		
		panelNorth.setPreferredSize(new Dimension(900, 60));
		panel.add(panelCenter,BorderLayout.CENTER);
		
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setBackground(Color.white);
		
		BusHeadBook busHeadBook = new BusHeadBook();
		String colum[] = {"ID","Name Book","Category","Language","PublishCompany","Author","Price"};
		dataRowHeadBook = busHeadBook.showData();
		for(int i = 0 ;i<dataRowHeadBook.length;++i) {
			dataRowHeadBook[i][5] = busHeadBook.findAuthorHeadBook(Integer.parseInt(dataRowHeadBook[i][0]));
		}
		
		tableModel = new DefaultTableModel(dataRowHeadBook, colum);
		tableHeadBook.setModel(tableModel);
		tableHeadBook.setRowHeight(30);
		
		JTableHeader header = tableHeadBook.getTableHeader();
		header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		header.setBackground(Color.white);
		tableHeadBook.setTableHeader(header);
		tableHeadBook.setSelectionForeground(Color.white);
		tableHeadBook.setGridColor(Color.white);
		tableHeadBook.setSelectionBackground(Color.decode("#28b928"));
		tableHeadBook.setFocusable(false);
		tableHeadBook.setFillsViewportHeight(true);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeadBook.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableHeadBook.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableHeadBook.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		tableScroll = new JScrollPane(tableHeadBook);
		btnChooseHeadBook.setPreferredSize(new Dimension(150,35));
		btnBackHeadBook.setPreferredSize(new Dimension(150,35));
		JLabel lbl = new JLabel("Invite you choose head book");
		lbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		
		btnChooseHeadBook.setForeground(Color.white);
		btnBackHeadBook.setForeground(Color.white);
		
		btnChooseHeadBook.setBackground(Color.decode("#ff0000"));
		btnBackHeadBook.setBackground(Color.decode("#1a89cc"));
		
		panelNorth.setBackground(Color.white);
		
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 13));
		panelNorth.add(lbl);
		panelNorth.add(btnChooseHeadBook);
		panelNorth.add(this.btnBackHeadBook);
		panelCenter.add(tableScroll,BorderLayout.CENTER);
	}
	
	public void eventSelectHeadBook() {
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectHeadBook();
			}
		});
		
		btnBackHeadBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				guiRepairHeadBook();
				if(tableHeadBook.getSelectedRow() >=0) {
					int row = tableHeadBook.getSelectedRow();
					String category = (String)tableHeadBook.getValueAt(row, 2);
					String language = (String)tableHeadBook.getValueAt(row, 3);
					String publish = (String)tableHeadBook.getValueAt(row, 4);
					barCategory.setSelectedItem(category);
					barLanguage.setSelectedItem(language);
					barPubCompany.setSelectedItem(publish);
				}
				panel.setVisible(true);
			}
		});
		
		btnChooseHeadBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableHeadBook.getSelectedRow() == -1) return;
				int row = tableHeadBook.getSelectedRow();
				String ID = (String)tableHeadBook.getValueAt(row, 0);
				lblIDHeadBook.setText(ID);
				eventLoadData();
			}
		});
	
	}
	
	public void eventLoadData() {
		BusHeadBook busHeadBook = new BusHeadBook();
		DTOHeadBook listHeadBook[] = busHeadBook.loadHeadBook();
		
		
		if(busHeadBook.checkID(lblIDHeadBook.getText()) == false) {
			return;
		}
		
		int IDHeadBook = Integer.parseInt(lblIDHeadBook.getText());
		int indexHeadBook = -1;
		
		DTOAuthor listAuthor[] = busHeadBook.loadAuthor(IDHeadBook);
		
		for(int i = 0 ; i<listHeadBook.length; ++i) {
			if(listHeadBook[i].IDHeadBook == IDHeadBook) {
				indexHeadBook = i;
				break;
			}
		}
		
		inputNameBook.setText(listHeadBook[indexHeadBook].NameBook);
		inputPrice.setText(Integer.toString(listHeadBook[indexHeadBook].Price));
		
		String authorOfBook = "";
		
		dataRowAuthor = new String[100][2];
		amountRow = listAuthor.length;
		
		for(int i = 0 ;i<listAuthor.length;++i) {
			authorOfBook+=listAuthor[i].nameAuthor;
			dataRowAuthor[i][0] = Integer.toString(listAuthor[i].IDAuthor);
			dataRowAuthor[i][1] = listAuthor[i].nameAuthor;
			if(i<listAuthor.length-1) {
				authorOfBook+=",";
			}
		}
		
		displayAuthorselect.setText(authorOfBook);
		
	}
	
	public void loadComboBox() {
		BusHeadBook busHeadBook = new BusHeadBook();
		
		DTOLanguage listLanguage[] = busHeadBook.loadLanguage();
		
		String listComboBoxLanguage[] = new String[listLanguage.length];
		
		for(int i = 0; i<listLanguage.length; ++i) {
			listComboBoxLanguage[i] = listLanguage[i].nameLanguage;
		}
		
		barLanguage = new JComboBox(listComboBoxLanguage);
		
		DTOCategory listCategory[] = busHeadBook.loadCategory();
		
		String listComboBoxCategory[] = new String[listCategory.length];
		
		for(int i = 0; i<listCategory.length; ++i) {
			listComboBoxCategory[i] = listCategory[i].nameCategory;
		}
		
		barCategory = new JComboBox(listComboBoxCategory);
		
		
		DTOPublishCompany listPubCompany[] = busHeadBook.loadPubCompany();
		
		String listComboPubCompany[] = new String[listPubCompany.length];
		
		for(int i = 0; i<listPubCompany.length; ++i) {
			listComboPubCompany[i] = listPubCompany[i].namePubCompany;
		}
		
		barPubCompany = new JComboBox(listComboPubCompany);
	}
	
	public void resetTextField() {
		inputFind.setText("");
		inputID.setText("");
		inputAuthor.setText("");
		inputNameBook.setText("");
		inputPrice.setText("");
		inputNumberBorrow.setText("");
		displayAuthorselect.setText("");
	}
	
	public void eventButton() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventAddHeadBook();
			}
		});
		
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evenRepairHeadBook();
				inputNameBook.setText("");
				displayAuthorselect.setText("");
				inputPrice.setText("");
				lblIDHeadBook.setText("");
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventClearHeadBook();
				BusHeadBook busHeadBook = new BusHeadBook();
				String column[] = {"ID", "Name", "Category", "Language","Publish Company", "Author",  "Price"};
				dataTableClear = busHeadBook.showData();
				model = new DefaultTableModel(dataTableClear, column);
				tableClear.setModel(model);
			}
		});
		
		btnBackAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listAuthor = "";
				for(int i = 0; i<amountRow ;i++) {
					listAuthor+=dataRowAuthor[i][1];
					if(i<amountRow-1) {
						listAuthor+=", ";
					}
				}
				displayAuthorselect.setText(listAuthor);
			}
		});
		
		btnBackRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listAuthor = "";
				for(int i = 0; i<amountRow ;i++) {
					listAuthor+=dataRowAuthor[i][1];
					if(i<amountRow-1) {
						listAuthor+=", ";
					}
				}
				displayAuthorselect.setText(listAuthor);
			}
		});
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takeAuthor();
			}
		});
		
		btnUnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSelectAuthor();
				String listAuthor = "";
				for(int i = 0; i<amountRow ;i++) {
					listAuthor+=dataRowAuthor[i][1];
					if(i<amountRow-1) {
						listAuthor+=", ";
					}
				}
			}
		});
	}
	
}