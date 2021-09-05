import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPunlish{

    protected SQL sql = new SQL();

    public int insert(String value) {
        sql.open();
        String query = "INSERT INTO publishcompany (NamePubCompany) " +
                "VALUES (\"" + value + "\")";
        int status = sql.excutiveUpdate(query);
        return status;
    }

    public int clear(String value) {
        sql.open();
        int ID = Integer.parseInt(value);
        String query = "DELETE FROM publishcompany WHERE IDPubCompany = " + ID;
        int status = sql.excutiveUpdate(query);
        return status;
    }

    public String[][] takeData(){

        sql.open();
        String query = "SELECT * FROM publishcompany";
        ResultSet rs = sql.excutiveQuery(query);

        query = "select count(*) from publishcompany";
        ResultSet rs1 = sql.excutiveQuery(query);
        int amountRow = 0;

        try {
            rs1.next();
            amountRow = rs1.getInt(1);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        String data[][] = new String[amountRow][2];
        int row = 0;

        try {
            while(rs.next()) {
                data[row][0] = Integer.toString(rs.getInt(1));
                data[row][1] = rs.getString(2);
                row++;
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
    
    public int update(String ID,String name) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "update publishcompany set NamePubCompany =\"" + name + "\"" + " where IDPubCompany=" + IDint;
		sql.excutiveUpdate(query);
		return 1;
	}
}