import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiLogin{
	protected JFrame login;
	
	protected JTextField tfAccount;
	
	protected JPasswordField tfPassword;
	
	protected JButton btnLogin;
	
	protected int boot;
	
	protected int sessionLogin = 0;
	
	protected DTOAccount objectAccount;
	
	GuiLogin(){
		login = new JFrame();
		boot = 0;
		login.setLayout(null);
		JLabel lb = new JLabel();
		lb.setBounds(0,0, 386, 1000);
//		lb.setBorder(BorderFactory.createLineBorder(Color.red));
		
		ImageIcon Icon = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\bg_theme_00.jpg");
		Image img = Icon.getImage();
		lb.setIcon(Icon);
		
		
		ImageIcon Symboy = new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\img\\loginLogo_mainCorner.png");
		JLabel lbSymbol = new JLabel("");
		lbSymbol.setIcon(Symboy);
		
		lbSymbol.setBounds(145, 30, 130, 105);
		
		JLabel title = new JLabel("Library");
		title.setBounds(145, 118, 150, 50);
		title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 32));
		
		title.setForeground(Color.decode("#e61e25"));
		
		tfAccount = new JTextField("Login name");
		tfAccount.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
		eventAccount();
		
		Color color = new Color(0,0,0,1);
//		Color color = new Color();
		tfAccount.setOpaque(false);
		tfAccount.setBounds(65, 190, 250, 35);
		tfAccount.setBackground(color);
		tfAccount.setBackground(Color.white);
		tfAccount.setForeground(new Color(255,255,255));
		tfAccount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#946e71")));
		
		tfPassword = new JPasswordField("Password");
		tfPassword.setForeground(new Color(255,255,255));
		tfPassword.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
		tfPassword.setOpaque(false);
		tfPassword.setBounds(65, 230, 250, 35);
		tfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#946e71")));
		eventPassword();
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(65, 290, 250, 50);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.decode("#ea1c23"));
		btnLogin.setForeground(new Color(255,255,255));
		btnLogin.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 15));
		
		login.add(btnLogin);
		login.add(tfAccount);
		login.add(tfPassword);
		
		login.add(lbSymbol);
		login.add(title);
		login.add(lb);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(400, 580);
		login.setResizable(false);
		login.setVisible(true);
		
		login.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tfAccount.getText().isEmpty()) {
					tfAccount.setText("Login name");
				}
				if(tfPassword.getText().isEmpty() == true) {
					tfPassword.setText("Password");
				}
				
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		objectAccount = new DTOAccount();
		
		login.setLocationRelativeTo(null);
	}
	
	public void eventAccount() {
		tfAccount.addFocusListener((FocusListener) new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(tfAccount.getText().equals("Login name")) {
				
					tfAccount.setText("");
					tfAccount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#946e71")));
					if(boot == 0) tfAccount.setText("Login name");
					boot++;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(tfAccount.getText().isEmpty()) {
					tfAccount.setText("Login name");
					tfAccount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#946e71")));
				}
			}
		});
		
		
		

		tfAccount.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tfAccount.setText("");
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void eventPassword() {
		tfPassword.addFocusListener((FocusListener) new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(tfPassword.getText().equals("Password")) {
					tfPassword.setText("");
					tfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#946e71")));
				}
			
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(tfPassword.getText().isEmpty() == true) {
					tfPassword.setText("Password");
					tfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#946e71")));
				}
			}
		});
	}
	
	
}