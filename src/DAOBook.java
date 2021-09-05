import java.sql.ResultSet;

public class DAOBook{
	
	protected SQL sql = new SQL();
	
	public void addBook(String headbook, String status, String amount, String state, String note) {
		BUSBook busBook = new BUSBook();
		int IDHeadBook = Integer.parseInt(headbook);
		int statusInt = busBook.exchangeStatus(status);
		int stateInt = busBook.exchangeState(state);
		int amountInt = Integer.parseInt(amount);
		sql.open();
		String query = "insert into book (IDHeadBook,status,state,note) " +
		"value(" + IDHeadBook + "," + statusInt + "," + stateInt + ",\"" + note +"\")";
		
		for(int i = 0 ; i<amountInt ; i++) {
			sql.excutiveUpdate(query);
		}
	}
	
	public int clearBook(String ID) {
		int IDint = Integer.parseInt(ID);
		sql.open();
		String query = "delete from book where IDBook=" + IDint;
		int status = sql.excutiveUpdate(query);
		return status;
	}
	
	public String[][] tableSelectBook(){
		sql.open();
		String query = "select count(*)" +
		"from book,headbook where book.IDHeadBook=headbook.IDHeadBook";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[amount][6];
		
		query = "select IDBook,book.IDHeadBook,NameBook,status,state,note " +
				"from book,headbook where book.IDHeadBook=headbook.IDHeadBook";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				if(rs.getInt(4) == 1) data[j][3] = "Ready borrow";
				else data[j][3] = "Not ready yet";
				if(rs.getInt(5) == 1) data[j][4] = "Normal";
				else  data[j][4] = "Damage";
				data[j][5] = rs.getString(6);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sql.close();
		return data;
	}
	
	public String[][] findBookFollowID(String ID){
		sql.open();
		try {
				int IDint = Integer.parseInt(ID);
		}catch(Exception e) {
			return null;
		}
	
		String query = "select count(*)" +
		"from book,headbook where book.IDHeadBook=headbook.IDHeadBook" +
		" and " + "IDBook=" + ID;
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		String data[][] = new String[amount][6];
		
		query = "select IDBook,book.IDHeadBook,NameBook,status,state,note " +
				"from book,headbook where book.IDHeadBook=headbook.IDHeadBook" +
				" and " + "IDBook=" + ID;
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				if(rs.getInt(4) == 1) data[j][3] = "Already borrow";
				else data[j][3] = "No already borrow";
				if(rs.getInt(5) == 1) data[j][4] = "Normal";
				else  data[j][4] = "Damage";
				data[j][5] = rs.getString(6);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] findBookFollowName(String nameBook) {
		sql.open();
		String query = "select count(*)" +
		"from book,headbook where book.IDHeadBook=headbook.IDHeadBook" +
		" and " + "NameBook=\"" + nameBook + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		String data[][] = new String[amount][6];
		
		query = "select IDBook,book.IDHeadBook,NameBook,status,state,note " +
				"from book,headbook where book.IDHeadBook=headbook.IDHeadBook" +
				" and " + "NameBook=\"" + nameBook + "\"";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				if(rs.getInt(4) == 1) data[j][3] = "Already borrow";
				else data[j][3] = "No already borrow";
				if(rs.getInt(5) == 1) data[j][4] = "Normal";
				else  data[j][4] = "Damage";
				data[j][5] = rs.getString(6);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String loadNoteMenuRepair(String IDBook) {
		sql.open();
		String query = "select note from book where IDBook=" + IDBook;
		ResultSet rs = sql.excutiveQuery(query);
		String note = "";
		try {
			rs.next();
			note= rs.getString(1);
		}catch(Exception e) {
			
		}
		return note;
	}
	
	public String loadIDHeadBookMenuRepair(String IDBook) {
		sql.open();
		String query = "select IDHeadBook from book where IDBook=" + IDBook;
		ResultSet rs = sql.excutiveQuery(query);
		String IDHeadBook = "";
		try {
			rs.next();
			IDHeadBook= Integer.toString(rs.getInt(1));
		}catch(Exception e) {
			
		}
		return IDHeadBook;
	}
	
	public String loadStatusMenuRepair(String IDBook) {
		sql.open();
		String query = "select status from book where IDBook=" + Integer.parseInt(IDBook);
		ResultSet rs = sql.excutiveQuery(query);
		String status="";
		try {
			rs.next();
			if(rs.getInt(1) == 1) status ="Already borrow";
			else status = "No already borrow";
		}catch(Exception e) {
			
		}
		return status;
	}
	
	public String loadStateMenuRepair(String IDBook) {
		sql.open();
		String query = "select state from book where IDBook=" + Integer.parseInt(IDBook);
		ResultSet rs = sql.excutiveQuery(query);
		String state="";
		try {
			rs.next();
			if(rs.getInt(1) == 1) state ="Normal";
			else state = "Damage";
		}catch(Exception e) {
			
		}
		return state;
	}
	
	public void updateBook(String IDBook,String IDHeadBook,String status,String state, String note) {
		sql.open();
		int IDBookInt = Integer.parseInt(IDBook);
		int IDHeadBookInt = Integer.parseInt(IDHeadBook);
		int statusInt;
		if(status.equals("Already borrow") == true) statusInt = 1;
		else statusInt = 0;
		int stateInt;
		if(state.equals("Normal") == true) stateInt = 1 ;
		else stateInt = 0;
		String query = "update book set IDHeadBook=" + IDHeadBookInt + "," +
		"status=" + statusInt + "," + "state=" + stateInt + "," + "note=\"" + note  + "\"" +
		" where IDBook=" + IDBookInt;
		sql.excutiveUpdate(query);
		sql.close();
	}
}