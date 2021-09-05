
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExportHeadBook{
	
	protected JFrame frame;
	
	protected JTable table;
	
	protected DefaultTableModel model;
	
	protected JButton btnExport;
	
	protected JButton btnImport;
	
	protected String[][] data;
	
	protected DTOHeadBook[] listHeadBook;

	ExportHeadBook(){
		frame = new JFrame();
		table = new JTable();
		model = new DefaultTableModel();
		btnExport = new JButton("Export");
		btnImport = new JButton("Import");
		eventExport();
		eventImport();
	}
	
	public void guiDataExport() {
		
		frame.setLayout(new BorderLayout());
		
		frame.setBackground(Color.white);
		
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		JPanel north = new JPanel();
		
		center.setBackground(Color.white);
		south.setBackground(Color.white);
		north.setBackground(Color.white);
		
		String colum[]= {"ID HeadBook","Name Book","ID Category","ID Language","ID Publisher","price"};
		BusHeadBook bushb = new BusHeadBook();
		data = bushb.takeDataExport();
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
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
//		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		JScrollPane tableScroll = new JScrollPane(table);
		
		center.setLayout(new BorderLayout());
		
		center.add(tableScroll,BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(600,100));
		
		btnExport.setPreferredSize(new Dimension(150,30));
		
		btnImport.setPreferredSize(new Dimension(150,30));
		
		btnExport.setFocusable(false);
		btnImport.setFocusable(false);
		
		btnExport.setForeground(Color.white);
		btnImport.setForeground(Color.white);
		
		btnExport.setBackground(Color.decode("#ff0000"));
		btnImport.setBackground(Color.decode("#1a89cc"));
		
		south.add(btnExport);
		south.add(btnImport);
		
		frame.add(center,BorderLayout.CENTER);
		frame.add(south,BorderLayout.SOUTH);
		frame.setSize(1000, 400);
		frame.setVisible(true);
	}
	
	public void eventExport() {
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.length == 0) {
					JOptionPane.showMessageDialog(table,"data blank,export fail");
					return;
				}
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU = null;
				XSSFWorkbook wb = null;
				JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Dung\\OneDrive\\Desktop");
				excelFileChooser.setDialogTitle("Save As");
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xlsx","xls");
				excelFileChooser.setFileFilter(fnef);
				
				int excelChooser = excelFileChooser.showSaveDialog(null);
				
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					
						wb = new XSSFWorkbook();
						XSSFSheet sheet = wb.createSheet("HeadBook");
						
						XSSFRow header = sheet.createRow(0);
						XSSFCell ID = header.createCell(0);
						XSSFCell name = header.createCell(1);
						XSSFCell category = header.createCell(2);
						XSSFCell language = header.createCell(3);
						XSSFCell publisher = header.createCell(4);
						XSSFCell price = header.createCell(5);
						
						ID.setCellValue("ID Head Book");
						name.setCellValue("Name Book");
						category.setCellValue("ID Category");
						language.setCellValue("ID Language");
						publisher.setCellValue("ID Publisher");
						price.setCellValue("Price");
						
						for(int i = 1 ; i<=data.length ; i++) {
							XSSFRow row = ((XSSFSheet) sheet).createRow(i);
							for(int j = 0; j<6 ;++j) {
								XSSFCell cell = row.createCell(j);	
								cell.setCellValue(table.getValueAt(i-1, j).toString());
							}
						}
						
						for(int i = 0;i<6;++i) {
							sheet.autoSizeColumn(i);
						}
						
						try {
							excelFOU = new FileOutputStream(new File(excelFileChooser.getSelectedFile() + ".xlsx"));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						try {
							wb.write(excelFOU);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(table,"Export Success");
					
				}
			}
		});
	}
	
	public void eventImport() {
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\ACER\\Desktop");
				excelFileChooser.setDialogTitle("Open");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xlsx","xls");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				XSSFWorkbook wb = null;
				File path = null;
				FileInputStream fileIp = null;
				BufferedInputStream bufferIp = null;
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					path = excelFileChooser.getSelectedFile();
					try {
						fileIp = new FileInputStream(path);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					bufferIp = new BufferedInputStream(fileIp);
					try {
						wb = new XSSFWorkbook(bufferIp);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					XSSFSheet sheet = wb.getSheetAt(0);
					listHeadBook = new DTOHeadBook[sheet.getLastRowNum()];
					for(int i = 1;i<=sheet.getLastRowNum();i++) {
                                            XSSFRow row = sheet.getRow(i);
                                            listHeadBook[i-1] = new DTOHeadBook();
                                            listHeadBook[i-1].IDHeadBook =  (int) row.getCell(0).getNumericCellValue();
                                            listHeadBook[i-1].NameBook = row.getCell(1).getStringCellValue();
                                            listHeadBook[i-1].IDCategory = (int) row.getCell(2).getNumericCellValue();
                                            listHeadBook[i-1].IDLanguage= (int) row.getCell(3).getNumericCellValue();
                                            listHeadBook[i-1].PublishCompany = (int) row.getCell(4).getNumericCellValue();
                                            listHeadBook[i-1].Price = (int) row.getCell(5).getNumericCellValue();
					}
					BusApachePoi bus = new BusApachePoi();
					int status = bus.ImportHeadBook(listHeadBook);
					if(status < 0) {
						JOptionPane.showMessageDialog(table,"Import fail");
					}else {
						JOptionPane.showMessageDialog(table,"Import Success");
						String colum[]= {"ID HeadBook","Name Book","ID Category","ID Language","ID Publisher","Price"};
						BusHeadBook bushb = new BusHeadBook();
						data = bushb.takeDataExport();
						model = new DefaultTableModel(data,colum);
						table.setModel(model);
					}
				}
			}
	
		});
	}
}

