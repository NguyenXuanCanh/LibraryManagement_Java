import java.sql.ResultSet;

public class DaoPunish{
	protected SQL sql = new SQL();
	
	public String[][] loadAllPunish(){
		sql.open();
		String query = "select count(*) from punish";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		String data[][] = new String[size][5];
		query = "select * from punish";
		rs = sql.excutiveQuery(query);
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				if(rs.getDouble(3) <=1) {
					data[j][2] = Double.toString(rs.getDouble(3)*100) + "%";
				}else data[j][2] = Double.toString(rs.getDouble(3));
				if(rs.getInt(4) == 1) {
					data[j][3] = "Punish Using";
				}else data[j][3] = "Punish Not Using";
				data[j][4] = rs.getString(5);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void insert(String name, String money, String status) {
		sql.open();
		double moneyD = Double.parseDouble(money);
		int statusInt;
		if(status.equals("Punish Using") == true) {
			statusInt = 1;
		}else statusInt = 0;
		String query = "insert into punish(nameError,moneyPunish,StatusUse,DateCreate) values(" + "\"" + name + "\"" + "," +
				moneyD + "," + statusInt + "," + "\"" +  getDateCurrent() + "\"" + ")";
		sql.excutiveUpdate(query);
	}
	
	public void update(String ID, String name, String money, String status) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		double moneyD = Double.parseDouble(money);
		if(IDint == 4) name ="late";
		if(IDint == 3) name ="lose";
		int statusInt;
		if(status.equals("Punish Using") == true) {
			statusInt = 1;
		}else statusInt = 0;
		String query = "update punish set nameError=" + "\"" + name + "\"" + "," + "moneyPunish=" + moneyD + "," +
		"StatusUse=" + statusInt + " where IDPunish=" + IDint;
		sql.excutiveUpdate(query);
	}
	
	public void delete(String ID) {
		int IDint = Integer.parseInt(ID);
		sql.open();
		String query = "delete from punish where IDPunish=" + IDint;
		sql.excutiveUpdate(query);
	}
	
	public String getDateCurrent() {
		return java.time.LocalDate.now().toString();
	}
	
	public String[][] findID(String ID){
		int IDint = Integer.parseInt(ID);
		sql.open();
		String query = "select count(*) from punish where IDPunish=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		String data[][] = new String[size][5];
		query = "select * from punish where IDPunish=" + IDint;
		rs = sql.excutiveQuery(query);
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				if(rs.getDouble(3)<=1) {
					data[j][2] = Double.toString(rs.getDouble(3)*100) + "%";
				}else data[j][2] = Double.toString(rs.getDouble(3));
				if(rs.getInt(4) == 1) {
					data[j][3] = "Punish Using";
				}else data[j][3] = "Punish Not Using";
				data[j][4] = rs.getString(5);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;		
	}
	
	public String[][] findName(String name){
		sql.open();
		String query = "select count(*) from punish where nameError=" + "\"" + name + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		String data[][] = new String[size][5];
		query = "select * from punish where nameError=" + "\"" + name + "\"";
		rs = sql.excutiveQuery(query);
		int j = 0;
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				if(rs.getDouble(3)<=1) {
					data[j][2] = Double.toString(rs.getDouble(3)*100) + "%";
				}else data[j][2] = Double.toString(rs.getDouble(3));
				if(rs.getInt(4) == 1) {
					data[j][3] = "Punish Using";
				}else data[j][3] = "Punish Not Using";
				data[j][4] = rs.getString(5);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;		
	}
	
	public boolean checkID(String ID) {
		if(ID.equals("") == true) return false;
		int IDint = 0;
		try {
			IDint = Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		sql.open();
		String query = "select count(*) from punish where IDPunish=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			
		}
		if(size <=0) return false;
		else return true;
	}
}