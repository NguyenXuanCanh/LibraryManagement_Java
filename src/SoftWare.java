import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class SoftWare{
	
	protected MyFrame frame;
	
	protected GuiLogin formLogin;
	
	SoftWare(){
		
		formLogin = new GuiLogin();
		eventBtnLogin();
	}
	
	public static void main(String ar[]) {
		SoftWare library = new SoftWare();
		
	}
	
	public void processLogin() {
		String account = formLogin.tfAccount.getText();
		String password = formLogin.tfPassword.getText();
		DaoLogin dao = new DaoLogin();
		formLogin.objectAccount = dao.login(account, password);
		 
		if(formLogin.objectAccount == null) formLogin.sessionLogin = 0;
		else formLogin.sessionLogin = 1;
		if(formLogin.sessionLogin == 1) {
			frame = new MyFrame(formLogin.objectAccount);
			formLogin.login.setVisible(false);
		}
	}
	
	public void eventBtnLogin() {
		formLogin.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processLogin();
			}
		});
		
		formLogin.tfPassword.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					processLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		formLogin.tfAccount.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					processLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}