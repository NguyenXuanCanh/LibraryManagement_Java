import java.sql.ResultSet;

public class DaoUser{
	SQL sql = new SQL();
	
	public String[][] loadAllUser(){
		sql.open();
		String query = "select count(*) from account where clear =1 and IDStaff !=" + "\"" + "admin" + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][6];
		int j = 0;
		
		query = "select IDStaff,password,name,address,Power,statusUse from account,power where clear=1" + 
		" and power.IDPower = account.IDPower and IDStaff !=" + "\"" + "admin" + "\"";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = rs.getString(1);
				data[j][1] = "I don't Know";
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = rs.getString(5);
				if(rs.getInt(6) == 1) {
					data[j][5] = "Using";
				}else data[j][5] = "not Using";
				j++;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] findAccount(String account){
		sql.open();
		if(account.equals("admin") == true) return null;
		String query = "select count(*) from account where clear =1 and IDStaff=" + "\"" + account + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][6];
		int j = 0;
		
		query = "select IDStaff,password,name,address,Power,statusUse from account,power where clear=1" + 
				" and power.IDPower = account.IDPower and IDStaff=" + "\"" + account + "\"";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = rs.getString(1);
				data[j][1] = "I don't Know";
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = rs.getString(5);
				if(rs.getInt(6) == 1) {
					data[j][5] = "Using";
				}else data[j][5] = "not Using";
				j++;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void blockAccount(String account) {
		sql.open();
		String query = "update account set statusUse = 0 where 	IDStaff=" + "\"" + account + "\"";
		sql.excutiveUpdate(query);
	}
	
	public void unBlockAccount(String account) {
		sql.open();
		String query = "update account set statusUse = 1 where 	IDStaff=" + "\"" + account + "\"";
		sql.excutiveUpdate(query);
	}
	
	public void insertUser(String account,String pass,String name,String address,String power) {
		sql.open();
		DaoPower daoPower = new DaoPower();
		DTOPower listPower[] = daoPower.takeListPower();
		
		int IDPower = 0;
		for(int i = 0;i<listPower.length;++i) {
			if(listPower[i].power.equals(power) == true) {
				IDPower = listPower[i].IDPower;
				break;
			}
		}
		
		String query ="insert into account(IDStaff,password,name,address,IDPower,statusUse,clear) values(" +
		"\"" + account + "\"" + "," + "\"" + pass + "\"" + "," + "\"" + name + "\"" + "," + "\"" + address +
		"\"" + "," + IDPower + "," + 1 + "," + 1 + ")";
		
		sql.excutiveUpdate(query);
	}
	
	public void deleteAccount(String account) {
		sql.open();
		String query = "update account set clear = 0 where IDStaff=" + "\"" + account + "\"";
		sql.excutiveUpdate(query);
	}
	
	public boolean checkAccount(String account) {
		sql.open();
		if(account.equals("") == true) return false;
		String query ="select count(*) from account where IDStaff=" + "\"" + account + "\"" + " and clear=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		if(size<=0) return false;
		else return true;
	}
	
	public boolean checkAccountExist(String account) {
		sql.open();
		if(account.equals("") == true) return true;
		String query ="select count(*) from account where IDStaff=" + "\"" + account + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		if(size<=0) return false;
		else return true;
	}
	
	public void updatePower(String account, String power) {
		sql.open();
		DaoPower daoPower = new DaoPower();
		DTOPower listPower[] = daoPower.takeListPower();
		
		int IDPower = 0;
		for(int i = 0;i<listPower.length;++i) {
			if(listPower[i].power.equals(power) == true) {
				IDPower = listPower[i].IDPower;
				break;
			}
		}
		
		String query = "update account set IDPower=" + IDPower + " where IDStaff=" + "\"" + account + "\"";
		sql.excutiveUpdate(query);
	}
}