import java.sql.ResultSet;

public class BusPunish{
	DaoPunish dao = new DaoPunish();
	public boolean checkMoney(String money) {
		double moneyD = 0;
		if(money.equals("") == true) return false;
		try {
			moneyD = Double.parseDouble(money);
		}catch(Exception e) {
			return false;
		}
		
		if(moneyD < 0) return false;
		
		return true;
	}
	
	public String[][] loadAllPunish(){
		return dao.loadAllPunish();
	}
	
	public void insert(String name,String money,String statusChoose) {
		dao.insert(name, money, statusChoose);
	}
	
	public void update(String ID,String name,String money,String statusChoose) {
		dao.update(ID, name, money, statusChoose);
	}
	
	public void delete(String ID) {
		dao.delete(ID);
	}
	
	public boolean checkID(String ID) {
		boolean data = dao.checkID(ID);
		return data;
	}
	
	public String[][] findID(String ID){
		return dao.findID(ID);
	}
	
	public String[][] findName(String ID){
		return dao.findName(ID);
	}
}