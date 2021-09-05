import java.sql.ResultSet;

public class DaoReader{
	protected SQL sql = new SQL();
	
	public String[][] loadAllReader(){
		sql.open();
		String query = "select count(*) from reader";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String[][] data = new String[size][7];
		int j = 0;
		
		query = "select * from reader";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = rs.getString(1);
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				if(rs.getInt(5) == 1) data[j][4] = "Male";
				else data[j][4] = "Female";
				if(rs.getInt(6) == 0) data[j][5] = "student";
				else data[j][5] = "teacher";
				data[j][6] = rs.getString(7);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sql.close();
		return data;
	}
	
	public boolean checkMS(String ID,String type) {
		sql.open();
		String query = "select count(*) from " + type + " where ms=" + "\"" + ID + "\"";
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
	
	public String[] loadData(String ID, String type) {
		sql.open();
		String query = "select * from " + type + " where ms=" + "\"" + ID + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		String[] data = new String[5];
		try {
			rs.next();
			data[0] = rs.getString(1);
			data[1] = rs.getString(2);
			data[2] = rs.getString(3);
			if(rs.getInt(4) == 0) {
				data[3] = "Female";
			}else data[3] = "Male";
			
			data[4] = rs.getString(5);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void add(String ms,String name,String depart,String birth,String sex,String type,String dateCreate) {
		sql.open();
		int sexInt = 0;
		if(sex.equals("Male") == true) sexInt = 1;
		else sexInt = 0;
		int typeInt = 0;
		if(type.equals("student") == true) typeInt = 0;
		else typeInt = 1;
		String query= "insert into reader(IDReader,name,department,birthday,sex,type,dateCreate) " +
		"values(" + "\"" + ms + "\"" + "," + "\"" + name + "\"" + "," + "\"" + depart + "\"" + "," +
		"\"" + birth + "\"" + "," + sexInt + "," + typeInt + "," + "\"" + dateCreate + "\"" + ")";
		sql.excutiveUpdate(query);
		sql.close();
	}
	
	public boolean checkLoopID(String ID) {
		sql.open();
		String query = "select count(*) from reader where IDReader=" + "\"" + ID + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sql.close();
		if(size<=0) return true;
		else return false;
	}
	
	public void update(String ID,String name,String depart,String birthday, String sex,String type) {
		sql.open();
		int sexInt = 0;
		if(sex.equals("Male") == true) sexInt = 1;
		else sexInt = 0;
		int typeInt = 0;
		if(type.equals("student") == true) typeInt = 0;
		else typeInt = 1;
		String query = "update reader set name=" + "\"" + name + "\"" + ",department=" + "\"" + depart + "\"" + "," +
		"birthday=" + "\"" + birthday + "\"" + ",sex=" + sexInt + ",type=" + typeInt + " where IDReader=" + "\"" + ID + "\"";
		sql.excutiveUpdate(query);
		sql.close();
	}
	
	public void clear(String ID) {
		sql.open();
		String query ="delete from reader where IDReader=" + "\"" + ID + "\"";
		sql.excutiveUpdate(query);
		sql.close();
	}
	
	public String[][] findMS(String ID){
		sql.open();
		String query ="select * from reader where IDReader=" + "\"" + ID + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		String data[][] = new String[1][7];
		try {
			rs.next();
			data[0][0] = rs.getString(1);
			data[0][1] = rs.getString(2);
			data[0][2] = rs.getString(3);
			data[0][3] = rs.getString(4);
			if(rs.getInt(5) == 1) data[0][4] = "Male";
			else data[0][4] = "Female";
			if(rs.getInt(6) == 0) data[0][5] = "student";
			else data[0][5] = "teacher";
			data[0][6] = rs.getString(7);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
}