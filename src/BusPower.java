import java.sql.ResultSet;

public class BusPower{
	DaoPower dao = new DaoPower();
	
	public DTOPower[] takeListPower() {
		return dao.takeListPower();
	}
	
	public boolean checkIDPower(String ID) {
		boolean data = dao.checkIDPower(ID);
		return data;
	}
	
	public void clearPower(String ID) {
		dao.clearPower(ID);
	}
	
	public Object[][] loadPower(String filter){
		return dao.loadPower(filter);
	}
	
	public void insert(String power) {
		dao.insert(power);
	}
	
	public void savePower(Object dataNew[][]) {
		dao.savePower(dataNew);
	}
	
	public boolean checkIDPowerUserOrNot(String ID) {
		boolean data = dao.checkIDPowerUserOrNot(ID);
		return data;
	}
}