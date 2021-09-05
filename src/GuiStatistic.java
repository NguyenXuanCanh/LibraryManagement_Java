import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GuiStatistic{
	
	protected JPanel panel;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected String[][] data;
	
	protected JButton btnListBL;
	
	protected JButton btnBookBorrow;
	
	protected JButton btnListBP;
	
	protected JButton btnListBookLose;
	
	protected JButton btnListBookBreak;
	
	protected JPanel north;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JPanel center;
	
	protected JComboBox cbbYear;
	
	protected JComboBox cbbMonth;
	
	protected JLabel lbMonth;
	
	protected JLabel lbYear;
	
	protected JLabel lbMoneyPunish;
	
	protected JLabel lbMoneyRent;
	
	protected JLabel lbTotalRevenue;
	
	GuiStatistic(){
		boot();
	}
	
	public void boot() {
		cbbYear = new JComboBox();
		cbbMonth = new JComboBox();
		lbMoneyPunish = new JLabel();
		lbMoneyRent = new JLabel();
		lbTotalRevenue = new JLabel();
		panel = new JPanel();
		northL1 = new JPanel();
		northL2 = new JPanel();
		north = new JPanel();
		center = new JPanel();
		table = new JTable();
		model = new DefaultTableModel();
		btnListBL = new JButton("List Bill Lent");
		btnBookBorrow = new JButton("Book Borrow");
		btnListBP = new JButton("List Bill Pay");
		btnListBookLose = new JButton("List Book Lose");
		btnListBookBreak = new JButton("List Book break");
		lbMonth = new JLabel("Month");
		lbYear = new JLabel("Year");
		event();
	}
	
	public void createGui(MyFrame frame) {
		frame.panelContent.removeAll();
		frame.panelContent.add(panel);
		frame.panelTop.setBackground(Color.white);
		panel.removeAll();
		panel.setVisible(false);
		gui();
		panel.setVisible(true);
	}
	
	public void gui() {
		createYearCbb();
		String month[]= {"ALL","1","2","3","4","5","6","7","8","9","10","11","12"};
		cbbMonth = new JComboBox(month);
		panel.removeAll();
		north.removeAll();
		northL1.removeAll();
		northL2.removeAll();
		center.removeAll();
		
		panel.setBackground(Color.white);
		north.setBackground(Color.white);
		center.setBackground(Color.white);
		northL1.setBackground(Color.white);
		northL2.setBackground(Color.white);
		
		panel.setBounds(0, 0, 986, 500);
		panel.setLayout(new BorderLayout());
		panel.add(north, BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		
		north.setLayout(new GridLayout(2,1));
		north.add(northL1);
		north.add(northL2);
		
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		
		cbbMonth.setBackground(Color.white);
		cbbYear.setBackground(Color.white);
		
		cbbMonth.setFocusable(false);
		cbbYear.setFocusable(false);
		
		northL1.add(lbMonth);
		northL1.add(cbbMonth);
		northL1.add(lbYear);
		northL1.add(cbbYear);
		northL1.add(btnListBL);
		northL1.add(btnListBP);
		northL1.add(btnBookBorrow);
		
		northL2.add(lbMoneyPunish);
		northL2.add(lbMoneyRent);
		northL2.add(lbTotalRevenue);
		
		lbMoneyPunish.setVisible(false);
		lbMoneyRent.setVisible(false);
		lbTotalRevenue.setVisible(false);
		
		decoration(btnListBL);
		decoration(btnListBP);
		decoration(btnBookBorrow);
		decoration(btnListBookLose);
		decoration(btnListBookBreak);
		
		btnListBL.setForeground(Color.white);
		btnListBP.setForeground(Color.white);
		btnBookBorrow.setForeground(Color.white);
		
		btnListBL.setFocusable(false);
		btnListBP.setFocusable(false);
		btnBookBorrow.setFocusable(false);
		
		btnListBL.setBackground(Color.decode("#ff0000"));
		btnListBP.setBackground(Color.decode("#1a89cc"));
		btnBookBorrow.setBackground(Color.decode("#f7941e"));
		
		cbbYear.setPreferredSize(new Dimension(100,30));
		cbbMonth.setPreferredSize(new Dimension(100,30));
		
		center.setLayout(new BorderLayout());
		String []colum= {"colum 1","colum 2","colum 3","colum 4","colum 5","colum 6","colum 7"};
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
		
		JScrollPane tableScroll= new JScrollPane(table);
		
		center.add(tableScroll,BorderLayout.CENTER);
		
		
	}
	
	public void createYearCbb() {
		for(int i = 2021; i<=2200; ++i) {
			String year = Integer.toString(i);
			cbbYear.addItem(year);
		}
		
	}
	
	
	public void eventBtnBookBorrow() {
		btnBookBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusStatistic bus = new BusStatistic();
				String []colum= {"IDBook","IDHeadBook","Name Book","Category","Language","Publisher"};
				String year = (String) cbbYear.getItemAt(cbbYear.getSelectedIndex());
				String month = (String) cbbMonth.getItemAt(cbbMonth.getSelectedIndex());
				data = bus.takeAllBookBorrow(year,month);
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
				lbMoneyPunish.setVisible(false);
				lbMoneyRent.setVisible(false);
				lbTotalRevenue.setVisible(false);
				
			}
		});
	}
	
	public void eventListBP() {
		btnListBP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusStatistic bus = new BusStatistic();
				String []colum= {"ID Bill Pay","ID Borrow","Date Pay","Punish Money", "Rent"};
				String year = (String) cbbYear.getItemAt(cbbYear.getSelectedIndex());
				String month = (String) cbbMonth.getItemAt(cbbMonth.getSelectedIndex());
				data = bus.takeBillPay(year,month);
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
				
				int sumMoneyPunish = 0;
				int sumMoneyRent = 0;
				int totalRevenue = 0;
				for(int i = 0; i<data.length ; ++i) {
					try {
						sumMoneyPunish+=Double.parseDouble(data[i][3]);
						sumMoneyRent+=Integer.parseInt(data[i][4]);
					}catch(Exception e1) {
						return;
					}
					
				}
				totalRevenue = sumMoneyPunish + sumMoneyRent;
				lbMoneyPunish.setText("Total money Punish : " + sumMoneyPunish + " VND");
				lbMoneyRent.setText("Total money rent : " + sumMoneyRent + " VND");
				lbTotalRevenue.setText("Total Revenue : " + totalRevenue + " VND");
				lbMoneyPunish.setVisible(true);
				lbMoneyRent.setVisible(true);
				lbTotalRevenue.setVisible(true);
				//lbMoneyPunish,lbMoneyRent,lbTotalRevenue
			}
		});
	}
	
	public void eventBtnListBL() {
		btnListBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusStatistic bus = new BusStatistic();
				String []colum= {"IDBorrow","data Make","Date expiryday","IDReader","List Book"};
				String year = (String) cbbYear.getItemAt(cbbYear.getSelectedIndex());
				String month = (String) cbbMonth.getItemAt(cbbMonth.getSelectedIndex());
				data = bus.takeBillLent(year,month);
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
				
				lbMoneyPunish.setVisible(false);
				lbMoneyRent.setVisible(false);
				lbTotalRevenue.setVisible(false);
			}
		});
	}
	
	public void decoration(JButton btn) {
		btn.setPreferredSize(new Dimension(150,30));
	}
	
	public void event() {
		eventBtnBookBorrow();
		eventListBP();
		eventBtnListBL();
	}
}