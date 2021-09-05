import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAuthor{
	
	protected SQL sql = new SQL();
	
	public String getDateCurrent() {
		return java.time.LocalDate.now().toString();
	}
	
	public int insert(String name,String birth,String address) {
		sql.open();
		if(birth.equals("") == true) birth="0000-00-00";
		String query = "INSERT INTO author (nameAuthor,birthday,address) " + 
						"VALUES (\"" + name + "\"" + "," + "\"" + birth + "\"" + ",\"" + address +  "\")";
		int status = sql.excutiveUpdate(query);
		return status;
	}
	
	public int clear(String value) {
		sql.open();
		int ID = Integer.parseInt(value);
		String query = "DELETE FROM Author WHERE IDAuthor =" + ID;
		int status = sql.excutiveUpdate(query);
		return status;
	}
	
	public int update(String ID,String name,String birth,String address) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "update Author set nameAuthor =\"" + name + "\"," +"birthday=\"" +birth +"\"," +"address= \""+address + "\" " + " where IDAuthor=" + IDint;
		
		sql.excutiveUpdate(query);
		return 1;
	}
	
	public String[][] takeData(){
		
		sql.open();
		String query = "SELECT * FROM Author";
		ResultSet rs = sql.excutiveQuery(query);
		
		query = "select count(*) from Author";
		ResultSet rs1 = sql.excutiveQuery(query);
		int amountRow = 0;
		
		try {
			rs1.next();
			amountRow = rs1.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[amountRow][4];
		int row = 0;
		
		try {
			while(rs.next()) {
				data[row][0] = Integer.toString(rs.getInt(1));
				data[row][1] = rs.getString(2);
				data[row][2] = rs.getString(3);
				data[row][3] = rs.getString(4);
				
				row++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}
}