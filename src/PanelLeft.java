import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelLeft extends JPanel{
	
	protected ImageIcon image;
	
	protected JButton btnAccount;
	
	protected JButton btnBook;
	
	protected JButton btnHeadBook;
	
	protected JButton btnBillLend;
	
	protected JButton btnBillPay;
	
	protected JButton btnCategory;
	
	protected JButton btnUser;
	
	protected JButton btnPunish;
	
	protected JButton btnStatistic;
	
	protected JButton btnLanguage;
	
	protected JButton btnPublish;
	
	protected JButton btnAuthor;
	
	protected JButton btnPower;
	
	protected JButton btnReader;
	
	protected String[] listFuntion;
	
	protected JButton btnSearch;
	
	protected JPanel arrPanel[];
	
	PanelLeft(DTOAccount ObjectAccount){
		setBounds(0, 0, 300, 750);
		setLayout(null);
		setBackground(Color.decode("#202b30"));
		
		image = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\ico_avatar_default.jpg");
		Image imageUser = image.getImage();
		
		JLabel labelContainImg = new JLabel();
		labelContainImg.setIcon(image);
		labelContainImg.setBounds(90, 25, 150, 150);
	
		btnAccount = new JButton("Account");
		btnAccount.setBounds(100, 150, 100, 40);
//		decoration(btnAccount);
		
		JPanel panelAccount = new JPanel();
		panelAccount.setLayout(null);
		panelAccount.add(labelContainImg);
		panelAccount.setBackground(Color.decode("#263238"));
		panelAccount.setBounds(0, 0, 300, 210);
		
		listFuntion = new String[13];
		
		ImageIcon IconBook = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconBook.png");
		btnBook = new JButton("Management Book");
		btnBook.setIcon(IconBook);
		
		decoration(btnBook,0);
		
		ImageIcon IconBillLent = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconBillLent.png");
		btnBillLend = new JButton("Management Bill Lent");
		btnBillLend.setIcon(IconBillLent);
		decoration(btnBillLend,2);
		
		ImageIcon IconBillPay = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconBillPay.png");
		btnBillPay = new JButton("Management Bill Pay");
		btnBillPay.setIcon(IconBillPay);
		decoration(btnBillPay,3);
		
		ImageIcon IconStatistic = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconStatistic.png");
		btnStatistic = new JButton("Management Statistic");
		btnStatistic.setIcon(IconStatistic);
		decoration(btnStatistic,12);
		
		ImageIcon IconUser = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconUser.png");
		btnUser = new JButton("Management User");
		btnUser.setIcon(IconUser);
		decoration(btnUser,6);
		
		ImageIcon IconPunish = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconPunish.png");
		btnPunish = new JButton("Management Punish");
		btnPunish.setIcon(IconPunish);
		decoration(btnPunish,4);
		
		ImageIcon IconHeadBook = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconHeadBook.png");
		btnHeadBook = new JButton("Management Head Book");
		btnHeadBook.setIcon(IconHeadBook);
		decoration(btnHeadBook,1);
		
		ImageIcon IconCategory = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconCategory.png");
		btnCategory = new JButton("Management Category");
		btnCategory.setIcon(IconCategory);
		decoration(btnCategory,5);
		
		ImageIcon IconLanguage = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconLanguage.png");
		btnLanguage = new JButton("Management Language");
		btnLanguage.setIcon(IconLanguage);
		decoration(btnLanguage,10);
		
		ImageIcon IconPublisher = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconPublisher.png");
		btnPublish = new JButton("Management Publisher");
		btnPublish.setIcon(IconPublisher);
		decoration(btnPublish,9);
		
		ImageIcon IconAuthor = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconAuthor.png");
		btnAuthor = new JButton("Management Author");
		btnAuthor.setIcon(IconAuthor);
		decoration(btnAuthor,7);
		
		ImageIcon IconPower = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconPower.png");
		btnPower = new JButton("Management Power");
		btnPower.setIcon(IconPower);
		decoration(btnPower,11);
		
		ImageIcon IconReader = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconReader.png");
		btnReader = new JButton("Management Reader");
		btnReader.setIcon(IconReader);
		decoration(btnReader,8);
		
		ImageIcon IconSearch = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\IconSearch.png");
		btnSearch = new JButton("Search Book");
		btnSearch.setIcon(IconSearch);
		decoration(btnSearch,13);
		
		JPanel panelFunction = new JPanel();
		
		panelFunction.setBackground(Color.decode("#202b30"));
		panelFunction.setLayout(new GridLayout(15,1,0,0));
		panelFunction.setBounds(0, 211, 300, 540);
		
		arrPanel = new JPanel[14];
		for(int i = 0;i<arrPanel.length;++i) {
			arrPanel[i] = new JPanel();
			arrPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT, 35, 5));
			arrPanel[i].setBackground(Color.decode("#202b30"));
			panelFunction.add(arrPanel[i]);
		}
		arrPanel[12].setLayout(new FlowLayout(FlowLayout.LEFT, 35, 0));
		DaoLogin dao = new DaoLogin();
		listFuntion = dao.takeFuntionOfAccount(ObjectAccount.IDPower);
		
		for(int i = 0 ;i<listFuntion.length;++i) {
			if(listFuntion[i].equals("Management Book")) arrPanel[0].add(btnBook);
			if(listFuntion[i].equals("Management Head Book")) arrPanel[1].add(btnHeadBook);
			if(listFuntion[i].equals("Management Bill Lent")) arrPanel[2].add(btnBillLend);
			if(listFuntion[i].equals("Management Bill Pay")) arrPanel[3].add(btnBillPay);
			if(listFuntion[i].equals("Management Reader")) arrPanel[8].add(btnReader);
			if(listFuntion[i].equals("Management Category")) arrPanel[5].add(btnCategory);
			if(listFuntion[i].equals("Management User")) arrPanel[6].add(btnUser);
			if(listFuntion[i].equals("Management Punish")) arrPanel[4].add(btnPunish);
			if(listFuntion[i].equals("Management Statistic")) arrPanel[12].add(btnStatistic);
			if(listFuntion[i].equals("Management Language")) arrPanel[10].add(btnLanguage);
			if(listFuntion[i].equals("Management Author")) arrPanel[7].add(btnAuthor);
			if(listFuntion[i].equals("Management Publisher")) arrPanel[9].add(btnPublish);
			if(listFuntion[i].equals("Management Power")) arrPanel[11].add(btnPower);
			if(listFuntion[i].equals("Search Book")) arrPanel[13].add(btnSearch);
		}
		
		
		
		JPanel PanelMid = new JPanel();
		PanelMid.setBounds(0,210, 300, 15);
		PanelMid.setBackground(Color.decode("#202b30"));
		
		add(panelAccount);
		add(PanelMid);
		add(panelFunction);
	}
	
	public void decoration(JButton btn,int indexPanel) {
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN, 14);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setFont(font);
		btn.setForeground(Color.decode("#edf2e6"));
		btn.setBackground(Color.decode("#202b30"));
		btn.setBorder(null);
		btn.addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setBackground(Color.decode("#202b30"));
				arrPanel[indexPanel].setBackground(Color.decode("#202b30"));
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
				arrPanel[indexPanel].setBackground(Color.decode("#26a69a"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setBackground(Color.decode("#202b30"));
				arrPanel[indexPanel].setBackground(Color.decode("#202b30"));
			}
			
		});
	}
	
	public void btnAccountClick() {
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public void btnSearch(MyFrame frame) {
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceSearch.createGui(frame);	
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
			}
		});
	}
	
	public void btnReader(MyFrame frame) {
		btnReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceReader.createGui(frame);		
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
			}
		});
	}
	
	
	public void btnPower(MyFrame frame) {
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);
				frame.interfacePower.createGui(frame);
				frame.panelTop.setVisible(true);
			}
		});
	}
	
	public void btnBookClick(MyFrame frame) {
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);
				frame.interfaceBook.createMenu(frame);			
				frame.panelTop.setVisible(true);
				btnBook.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnAuthor(MyFrame frame) {
		btnAuthor.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);			
				frame.interfaceAuthor.creatMenu(frame);
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
				btnAuthor.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnPublish(MyFrame frame) {
		btnPublish.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);			
				frame.interfacePunlish.creatMenu(frame);
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
				btnPublish.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnLanguage(MyFrame frame) {
		btnLanguage.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);			
				frame.interfaceLanguage.creatMenu(frame);
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
				btnLanguage.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnHeadBook(MyFrame frame) {
		btnHeadBook.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();
				frame.panelTop.setVisible(false);			
				frame.interfaceHeadBook.creatMenu(frame);
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
				btnHeadBook.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnBillLend(MyFrame frame) {
		btnBillLend.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceBillLent.createMenu(frame);
				frame.panelTop.setVisible(true);
				btnBillLend.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnBillPay(MyFrame frame) {
		btnBillPay.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceBillPay.createMenu(frame);
				frame.panelTop.setVisible(true);
				btnBillPay.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnCategory(MyFrame frame) {
		btnCategory.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(false);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceCategory.creatMenu(frame);			
				frame.panelTop.setVisible(true);
				frame.panelContent.setVisible(true);
				btnCategory.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnUser(MyFrame frame) {
		btnUser.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceUser.createGui(frame);	
				frame.panelTop.setVisible(true);
				btnUser.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnPunish(MyFrame frame) {
		btnPunish.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfacePunish.createMenu(frame);		
				frame.panelTop.setVisible(true);
				btnPunish.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public void btnStatistic(MyFrame frame) {
		btnStatistic.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.panelContent.setVisible(false);
				frame.panelContent.removeAll();
				frame.panelContent.setVisible(true);
				frame.panelTop.removeAll();				
				frame.panelTop.setVisible(false);			
				frame.interfaceStatistic.createGui(frame);				
				frame.panelTop.setVisible(true);
				btnStatistic.setBackground(Color.decode("#202b30"));
				ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_bottom.png");
				JLabel bg = new JLabel();
				bg.setIcon(icon);
				bg.setBounds(0, 0, 986, 540);
				frame.panelContent.add(bg);
			}
		});
	}
	
	public static void fixEvent(MyFrame frame) {
		frame.panelLeft.btnBookClick(frame);
		frame.panelLeft.btnHeadBook(frame);
		frame.panelLeft.btnBillLend(frame);
		frame.panelLeft.btnBillPay(frame);
		frame.panelLeft.btnCategory(frame);
		frame.panelLeft.btnUser(frame);
		frame.panelLeft.btnPunish(frame);
		frame.panelLeft.btnStatistic(frame);
		frame.panelLeft.btnLanguage(frame);
		frame.panelLeft.btnPublish(frame);
		frame.panelLeft.btnAuthor(frame);
		frame.panelLeft.btnPower(frame);
		frame.panelLeft.btnReader(frame);
		frame.panelLeft.btnSearch(frame);
	}
	
}