import java.sql.*;

public class SQL {
	
	protected String url;
	protected String user;
	protected String password;
	protected Connection connect;
	
	
	public void open() {
		url = "jdbc:mysql://localhost:3306/librarymanagement";
		user = "root";
		password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url,user,password);
		
		}catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connect.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet excutiveQuery(String query){
		ResultSet rs = null;
		try {
			Statement stmt = connect.createStatement();
			rs = stmt.executeQuery(query);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	
	public int excutiveUpdate(String query) {
		int status = -1;
		try {
			Statement stmt = connect.createStatement();
			status=stmt.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}