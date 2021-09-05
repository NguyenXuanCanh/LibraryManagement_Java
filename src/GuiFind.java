import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFind{
	protected JPanel panel;
	
	protected JButton btnFindName;
	
	protected JButton btnFindType;
	
	protected JButton btnFindAuthor;
	
	protected JComboBox barCategory;
	
	protected JComboBox barAuthor;
	
	protected JTextField tfFind;
	
	protected JPanel north;
	
	protected JPanel northL1;
	
	protected JPanel northL2;
	
	protected JPanel center;
	
	protected JLabel lb;
	
	protected BusGuiFind bus = new BusGuiFind();
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected String[][] data;
	
	GuiFind(){
		boot();
		eventBtn();
	}
	
	public void boot() {
		panel = new JPanel();
		
		north = new JPanel();
		
		northL1 = new JPanel();
		
		northL2 = new JPanel();
		
		center = new JPanel();
		
		table = new JTable();
		
		model = new DefaultTableModel();
		
		btnFindName = new JButton("Find follow name");
		
		btnFindType = new JButton("List all Book of category");
		
		btnFindAuthor = new JButton("List all Book of author");
		
		tfFind = new JTextField();
		
		barCategory = new JComboBox();
		
		barAuthor = new JComboBox();
		
		lb = new JLabel("Find Book");
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
		north.removeAll();
		northL1.removeAll();
		northL2.removeAll();
		center.removeAll();
		
		panel.setBounds(0, 0, 986, 505);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		panel.add(north,BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		
		north.setPreferredSize(new Dimension(986,120));
		north.setLayout(new GridLayout(2,1));
		north.removeAll();
		northL1.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));
		northL2.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		
		northL1.setBackground(Color.white);
		northL2.setBackground(Color.white);
		center.setBackground(Color.white);
		panel.setBackground(Color.white);
		north.setBackground(Color.white);
		
		north.add(northL1);
		north.add(northL2);
		
		tfFind.setPreferredSize(new Dimension(400,30));
		btnFindName.setPreferredSize(new Dimension(200,30));
		
		northL1.add(lb);
		northL1.add(tfFind);
		northL1.add(btnFindName);
		
		String cbbCategory[] = bus.takeListCategory();
		barCategory = new JComboBox(cbbCategory);
		
		String cbbAuthor[] = bus.takeListAuthor();
		barAuthor = new JComboBox(cbbAuthor);
		
		barCategory.setPreferredSize(new Dimension(142,30));
		btnFindType.setPreferredSize(new Dimension(180,30));
		barAuthor.setPreferredSize(new Dimension(142,30));
		btnFindAuthor.setPreferredSize(new Dimension(180,30));
		
		northL2.add(barCategory);
		northL2.add(btnFindType);
		northL2.add(barAuthor);
		northL2.add(btnFindAuthor);
		
		barCategory.setBackground(Color.white);
		barCategory.setFocusable(false);
		barAuthor.setBackground(Color.white);
		barAuthor.setFocusable(false);
		
		btnFindName.setForeground(Color.white);
		btnFindType.setForeground(Color.white);
		btnFindAuthor.setForeground(Color.white);
		
		btnFindName.setFocusable(false);
		btnFindType.setFocusable(false);
		btnFindAuthor.setFocusable(false);
		
		btnFindName.setBackground(Color.decode("#ff0000"));
		btnFindType.setBackground(Color.decode("#1a89cc"));
		btnFindAuthor.setBackground(Color.decode("#f7941e"));
		
		center.setLayout(new BorderLayout());
		
		String colum[]= {"ID Book"," Name Book","Category","Language","publisher","Author","status"};
		data = bus.loadAllBook();
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
		
		JScrollPane scrollTable = new JScrollPane(table);
		center.add(scrollTable,BorderLayout.CENTER);
		
//		center
		
	}
	
	public void eventFindName() {
		btnFindName.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfFind.getText();
				String colum[]= {"ID Book"," Name Book","Category","Language","publisher","Author","status"};
				data = bus.findNameBook(name);
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
	
	public void eventListBookCategory() {
		btnFindType.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = (String) barCategory.getItemAt(barCategory.getSelectedIndex());
				int ID = bus.findIDCategory(category);
				String colum[]= {"ID Book"," Name Book","Category","Language","publisher","Author","status"};
				data = bus.loadBookFollowCategory(ID);
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
	
	public void eventListBookAuthor() {
		btnFindAuthor.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String author = (String) barAuthor.getItemAt(barAuthor.getSelectedIndex());
				String colum[]= {"ID Book"," Name Book","Category","Language","publisher","Author","status"};
				data = bus.loadBookFollowAuthor(author);
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
		eventFindName();
		eventListBookCategory();
		eventListBookAuthor();
	}
	
	
}