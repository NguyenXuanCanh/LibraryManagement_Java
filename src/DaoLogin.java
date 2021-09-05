import java.sql.ResultSet;

public class DaoLogin{
	SQL sql = new SQL();
	
	public DTOAccount login(String account, String password) {
		sql.open();
		
		String query = "select count(*) from account where IDStaff=" + "\"" + account + "\"" + " and password=" +
				"\"" + password + "\"" + " and statusUse=1 and clear=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int exist = 0;
		
		try {
			rs.next();
			exist = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		if(exist<=0 ) return null;
	
		query ="select * from account where IDStaff=" + "\"" + account + "\"" + " and password=" +
		"\"" + password + "\"" + " and statusUse=1 and clear=1";
		rs = sql.excutiveQuery(query);
		DTOAccount objectAccount = new DTOAccount();
		
		try {
			rs.next();
			objectAccount.account = rs.getString(1);
			objectAccount.password = rs.getString(2);
			objectAccount.name = rs.getString(3);
			objectAccount.address = rs.getString(4);
			objectAccount.IDPower = rs.getInt(5);
			objectAccount.statusUse = rs.getInt(6);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return objectAccount;
	}
	
	public String[] takeFuntionOfAccount(int IDPower) {
		sql.open();
		String query = "select count(*) from detailpower,function where detailpower.IDPower=" + IDPower +
				" and enable=1 and function.IDFunction=detailpower.IDFunction";
		
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		query = "select Function from detailpower,function where detailpower.IDPower=" + IDPower +
		" and enable=1 and function.IDFunction=detailpower.IDFunction";
		rs = sql.excutiveQuery(query);
		
		String[] function = new String[size];
		int j = 0;
		
		try {
			while(rs.next()) {
				function[j] = rs.getString(1);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return function;
	}
}