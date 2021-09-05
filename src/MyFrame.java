import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyFrame extends JFrame{
	
	protected PanelLeft panelLeft;
	
	protected JPanel panelTop;
	
	protected GuiCategory interfaceCategory;
	
	protected GuiHeadBook interfaceHeadBook;
	
	protected GuiBook interfaceBook;
	
	protected GuiBillLent interfaceBillLent;
	
	protected GuiLanguage interfaceLanguage;
	
	protected GuiPunlish interfacePunlish;
	
	protected GuiAuthor interfaceAuthor;
	
	protected GuiBillPay interfaceBillPay;
	
	protected GuiPunish interfacePunish;
	
	protected GuiPower interfacePower;
	
	protected GuiUser interfaceUser;
	
	protected GuiStatistic interfaceStatistic;
	
	protected GuiReader interfaceReader;
	
	protected GuiFind interfaceSearch;
	
	protected JPanel panelContent;
	
	MyFrame(DTOAccount ObjectAccount){
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\\\src\\img\\iconSoftWare.png");
		Image icon = imageIcon.getImage();
		setIconImage(icon);
		setTitle("Library");
		this.setBackground(Color.decode("#202b30"));
		
		setSize(1300, 750);
		
		panelContent = new JPanel();
		JLabel bgContent = new JLabel();
		ImageIcon Icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\�Pngtree�online library electronic reading isometric_1169158.png");
		ImageIcon btnOver = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\btnOverBig.PNG");
		JLabel btnOverGS = new JLabel();
		btnOverGS.setIcon(btnOver);
		btnOverGS.setBorder(null);
		btnOverGS.setBounds(65, 363, 240, 40);
		bgContent.setIcon(Icon);
		bgContent.setBounds(0, 0, 1000, 540);
		panelContent.setBounds(300, 210, 1000, 540);
		panelContent.setBackground(Color.decode("#f5eaea"));
		panelContent.add(btnOverGS);
		panelContent.add(bgContent);
		add(panelContent);
		panelContent.setLayout(null);
		
		panelLeft = new PanelLeft(ObjectAccount);
		add(panelLeft);
		panelLeft.fixEvent(this);
		
		panelTop= new JPanel();
		panelTop.setBackground(Color.decode("#250555"));
		panelTop.setBounds(298, 150, 1000, 60);
		panelTop.setLayout(new GridLayout(1,1,0,0));
		add(panelTop);
		
		
		
		interfaceSearch = new GuiFind();
		
		interfaceStatistic = new GuiStatistic();
		
		interfaceUser = new GuiUser();
		
		interfacePower = new GuiPower();
		
		interfaceCategory = new GuiCategory();
		
		interfacePunish = new GuiPunish();
		
		interfaceHeadBook = new GuiHeadBook();
		
		interfaceBook = new GuiBook();
		
		interfaceBillLent = new GuiBillLent();
		
		interfaceLanguage = new GuiLanguage();
		
		interfacePunlish = new GuiPunlish();
		
		interfaceAuthor = new GuiAuthor();
		
		interfaceBillPay = new GuiBillPay();
		
		interfaceReader = new GuiReader();
		
		
		JPanel panelBanner = new JPanel();
		panelBanner.setBounds(294, 1, 1000, 149);
		panelBanner.setBackground(Color.black);
		panelBanner.setLayout(null);
		
		JLabel lbContainImgTop = new JLabel();
		lbContainImgTop.setBounds(0, 0, 1000, 149);
		ImageIcon imgTop = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\7518.jpg_wh860.jpg");
		lbContainImgTop.setIcon(imgTop);
		panelBanner.add(lbContainImgTop);
		
		add(panelBanner);
		
		getContentPane().setBackground(Color.white);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
	}
	
	
	
}