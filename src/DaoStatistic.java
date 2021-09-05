import java.sql.ResultSet;

public class DaoStatistic{
	
	SQL sql = new SQL();
	
	public boolean isNumber(String month) {
		try {
			Integer.parseInt(month);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean checkYear(String time,String yearChoose,String monthChoose) {
		String arrYear[] = time.split("-");
		int count = 0;
		
		if(arrYear[0].equals(yearChoose) == true) count++;
		if(isNumber(monthChoose) == true) {
			int monthBL = Integer.parseInt(arrYear[1]);
			int monthCbb = Integer.parseInt(monthChoose);
			if(monthCbb == monthBL) count++;
		}
		
		if(monthChoose.equals("ALL") == true && count==1) return true;
		if(monthChoose.equals("ALL") == false && count==2) return true;
		else return false;
	}
	
	public String[][] ListBL(String year,String month){
		sql.open();
		DAOBillLent daoBL = new DAOBillLent();
		String query = "select count(*) from callcard";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = -1;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select * from callcard";
		rs = sql.excutiveQuery(query);
		
		String data[][] = new String[size][5]; 
		int indexSize = 0;
		
		try {
			while(rs.next()) {
				if(checkYear(rs.getString(2), year,month) == true) {
					data[indexSize][0] = Integer.toString(rs.getInt(1));
					data[indexSize][1] = rs.getString(2);
					data[indexSize][2] = rs.getString(3);
					data[indexSize][3] = Integer.toString(rs.getInt(4));
					data[indexSize][4] = daoBL.takebookBL(data[indexSize][0]);
					indexSize++;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] listBP(String year,String month){
		sql.open();
		DAOBillLent daoBL = new DAOBillLent();
		String query = "select count(*) from ticketpay";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = -1;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select * from ticketpay";
		rs = sql.excutiveQuery(query);
		
		String data[][] = new String[size][5]; 
		int indexSize = 0;
		
		try {
			while(rs.next()) {
				if(checkYear(rs.getString(3), year,month) == true) {
					data[indexSize][0] = Integer.toString(rs.getInt(1));
					data[indexSize][1] = Integer.toString(rs.getInt(2));
					data[indexSize][2] = rs.getString(3);
					data[indexSize][3] = Double.toString(rs.getDouble(4));
					data[indexSize][4] = Integer.toString(rs.getInt(5));
					indexSize++;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] ALLBookBorrow(String year,String month){
		sql.open();
		String listBL[][] = ListBL(year,month);
		String listBook[][];
		String listBookOneBL ="";
		DAOBillLent dao = new DAOBillLent();
		
		for(int i = 0 ;i<listBL.length;++i) {
			if(listBL[i][0] == null) continue;
			listBookOneBL = listBookOneBL + dao.takebookBL(listBL[i][0]);
			if(i<listBL.length-1) {
				listBookOneBL+= ",";
			}
		}
		
		ResultSet rs;
		
		String[] listBookQuery = listBookOneBL.split(",");
		listBook = new String[listBookQuery.length][6];
		int k = 0;
		for(int i = 0;i<listBookQuery.length;++i) {
			try {
				Integer.parseInt(listBookQuery[i]);
			}catch(Exception e) {
				continue;
			}
			int ID = Integer.parseInt(listBookQuery[i]);

			String query ="select book.IDBook,headbook.IDHeadBook,NameBook,nameCategory,NameLanguage,NamePubCompany from book,headbook,category,language,publishcompany" +
			" where book.IDHeadBook=headbook.IDHeadBook and headbook.IDLanguage=language.IDLanguage and headbook.IDCategory=category.IDCategory and headbook.PublishCompany=publishcompany.IDPubCompany and book.IDBook=" + ID;
			rs = sql.excutiveQuery(query);
			
			try {
				while(rs.next()) {
					listBook[k][0] = Integer.toString(rs.getInt(1));
					listBook[k][1] = Integer.toString(rs.getInt(2));
					listBook[k][2] = rs.getString(3);
					listBook[k][3] = rs.getString(4);
					listBook[k][4] = rs.getString(5);
					listBook[k][5] = rs.getString(6);
					k++;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return listBook;
	}
	
}