import java.sql.ResultSet;

public class DaoPower{
	protected SQL sql = new SQL();
	
	public DTOPower[] takeListPower() {
		sql.open();
		String query = "select count(*) from power where IDPower !=18";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOPower listPower[] = new DTOPower[size];
		
		for(int i = 0; i<size;++i) {
			listPower[i] = new DTOPower();
		}
		
		int j = 0;
		
		query = "select * from power";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				if(rs.getInt(1) == 18) continue;
				listPower[j].IDPower = rs.getInt(1);
				listPower[j].power = rs.getString(2);
				++j;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listPower;
	}
	
	public String[][] takeAllFuntion(){
		sql.open();
		String query = "select count(*) from function";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String[][] data = new String[size][2];
		int j = 0;
		
		query = "select * from function";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void insert(String namePower) {
		sql.open();
		
		String listFuntion[][] = takeAllFuntion();
		
		String query = "insert into power(Power) values(" + "\"" + namePower + "\"" + ")";
		sql.excutiveUpdate(query);
		
		query = "SELECT IDPower FROM power ORDER BY IDPower DESC LIMIT 1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int IDPower = 0;
		
		try {
			rs.next();
			IDPower = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0;i<listFuntion.length;++i) {
			int IDFuntion = Integer.parseInt(listFuntion[i][0]);
			query = "insert into detailpower(IDPower,IDFunction,enable) values(" + IDPower + "," + IDFuntion + "," + 0 + ")";
			sql.excutiveUpdate(query);
		}
	}
	
	public Object[][] loadPower(String filter){
		sql.open();
		
		DTOPower listPower[] = takeListPower();
		
		int IDPower = 0;
		
		for(int i = 0 ;i<listPower.length;++i) {
			if(listPower[i].power.equals(filter) == true) {
				IDPower = listPower[i].IDPower;
				break;
			}
		}
		
		String query = "select count(*) from detailpower where 	IDPower=" + IDPower;
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select detailpower.IDPower,Power,detailpower.IDFunction,Function,enable from detailpower,power,function where power.IDPower=" + IDPower + 
				" and detailpower.IDPower=Power.IDPower and Function.IDFunction=detailpower.IDFunction";
		rs = sql.excutiveQuery(query);
		
		Object[][] data = new Object[size][5];
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = rs.getInt(1);
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getInt(3);
				data[j][3] = rs.getString(4);
				data[j][4] = rs.getBoolean(5);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void savePower(Object[][] dataNew) {
		sql.open();
		
		int enable = 0;
		
		for(int i = 0 ;i<dataNew.length;++i) {
			if((boolean)dataNew[i][2] == true) {
				enable = 1 ;
			}else enable = 0;
			int IDPower = Integer.parseInt(dataNew[i][0].toString());
			int IDFunction = Integer.parseInt(dataNew[i][1].toString());
			String query = "update detailpower set enable=" + enable + " where IDPower=" + IDPower + " and IDFunction =" + IDFunction;
			sql.excutiveUpdate(query);
		}
	}
	
	public void clearPower(String ID) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "delete from power where IDPower=" + IDint;
		sql.excutiveUpdate(query);
		query = "delete from detailpower where IDPower=" + IDint;
		sql.excutiveUpdate(query);
	}
	
	public boolean checkIDPower(String ID) {
		sql.open();
		if(ID.equals("")== true) return false;
		int IDint = 0;
		try {
			IDint = Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		
		int size = 0;
		
		String query = "select count(*) from power where IDPower=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		
		try {
			rs.next();
			size =rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(size<=0) return false;
		return true;
	}
	
	public boolean checkIDPowerUserOrNot(String ID) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "select count(*) from account,power where power.IDPower=account.IDPower and clear=1 and power.IDPower=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		int size = -1;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(size);
		if(size <=0) return true;
		else return false;
	}
}







