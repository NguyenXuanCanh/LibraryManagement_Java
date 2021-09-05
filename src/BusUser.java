import java.sql.ResultSet;

public class BusUser{
	
	DaoUser dao = new DaoUser();
	
	public boolean checkPasswordSecond(String pass1, String pass2) {
		if(pass1.equals(pass2) == true) return true;
		else return false;
	}
	
	public String[][] loadAllUser(){
		return dao.loadAllUser();
	}
	
	public boolean checkAccount(String account) {
		boolean data = dao.checkAccount(account);
		return data;
	}
	
	public String[][] findAccount(String account){
		return dao.findAccount(account);
	}
	
	public void blockAccount(String account) {
		dao.blockAccount(account);
	}
	
	public void unBlockAccount(String account) {
		dao.unBlockAccount(account);
	}
	
	public boolean checkAccountExist(String account) {
		boolean data = dao.checkAccountExist(account);
		return data;
	}
	
	public void insertUser(String account,String pass1,String name,String address,String power) {
		dao.insertUser(account, pass1, name, address, power);
	}
	
	public void deleteAccount(String account) {
		dao.deleteAccount(account);
	}
	
	public void updatePower(String account, String power) {
		dao.updatePower(account, power);
	}
}