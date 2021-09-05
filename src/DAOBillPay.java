import java.sql.*;

public class DAOBillPay{
	SQL sql = new SQL();
	
	public DTOPunish[] takeColumAdd() {
		sql.open();
		String query = "select count(*) from punish  where StatusUse = 1";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		amount++;
		
		DTOPunish colum[] = new DTOPunish[amount];
		for(int i =0 ; i<colum.length; ++i) {
			colum[i] = new DTOPunish();
		}
		colum[0].namePunish = "ID Book";
		int index = 1;

		query = "select * from punish where StatusUse = 1";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				colum[index].IDPunish = rs.getInt(1);
				colum[index].namePunish = rs.getString(2);
				colum[index].moneyPunish = rs.getDouble(3);
				index++;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return colum;
	}
	
	public Object[][] takeBookRent(String IDBorrow){
		DAOBillLent daoBL = new DAOBillLent();
		String amountBook[] = daoBL.takebookBL(IDBorrow).split(",");
		int row = amountBook.length;
		int colum = takeColumAdd().length;
		
		Object data[][] = new Object[row][colum];
		for(int i = 0;i<row;++i) {
			for(int j = 0;j<colum;++j) {
				if(j==0) {
					data[i][j] = amountBook[i];
				}else data[i][j] = false;
			}
		}
		return data;
	}
	
	public double takePrice(String IDBook) {
		sql.open();
		System.out.println(IDBook);
		String query ="select Price from headbook,book where book.IDHeadBook=headbook.IDHeadBook " +
		"and IDBook =" + Integer.parseInt(IDBook);
		ResultSet rs = sql.excutiveQuery(query);
		double price = -1;
		
		try {
			rs.next();
			price = rs.getDouble(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return price;
	}
	
	public void insertBP(String IDBorrow, String datePay, String moneyPunish, String moneyBook,String dataPunishBook[][],int lengthColum) {
		sql.open();
		String query;
		ResultSet rs = null;
		int IDBorrowInt = Integer.parseInt(IDBorrow);
		double money = Double.parseDouble(moneyPunish);
		int moneyRent = Integer.parseInt(moneyBook);
		query = "insert into ticketpay(IDBorrow,datePay,punishMoney,moneyBook,display) values(" + IDBorrowInt + "," +
		"\"" + datePay + "\"" + "," + money + "," + moneyRent + "," + 1 + ")";
		sql.excutiveUpdate(query);
		
		query = "SELECT IDTicketPay FROM ticketpay ORDER BY IDTicketPay DESC LIMIT 1";
		rs = sql.excutiveQuery(query);
		
		int IDTicketPay = 0;
		
		try {
			rs.next();
			IDTicketPay = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "update callcard set status = 1 where IDBorrow=" + IDBorrowInt;
		sql.excutiveUpdate(query);
		
		for(int i = 0 ;i<dataPunishBook.length;i++) {
			int IDBook = Integer.parseInt(dataPunishBook[i][0]);
			query = "update book set status = 1 where IDBook=" + IDBook;
			sql.excutiveUpdate(query);
			for(int j = 1; j<lengthColum; ++j) {
				if(dataPunishBook[i][j] == null) continue;
				int IDPunish = Integer.parseInt(dataPunishBook[i][j]);
				query = "insert into detailticketpay(IDTicketPay,IDBook,IDPunish) values(" + IDTicketPay + "," +
				IDBook + "," + IDPunish + ")";
				sql.excutiveUpdate(query);
						
			}
		}
	}
	
	public String[][] takeAllBillPay(){
		sql.open();
		
		String query = "select count(*) from ticketpay where display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][6];
		
		if(size == 0) return null;
		
		query = "select IDTicketPay,callcard.IDBorrow,IDReader,datePay,punishMoney,moneyBook from ticketpay,callcard where " +
		"ticketpay.IDBorrow = callcard.IDBorrow and ticketpay.display = 1";
		rs = sql.excutiveQuery(query);
		
		int i = 0;
		
		try {
			while(rs.next()) {
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = Integer.toString(rs.getInt(2));
				data[i][2] = Integer.toString(rs.getInt(3));
				data[i][3] = rs.getString(4);
				data[i][4] = Double.toString(rs.getDouble(5));
				data[i][5] = Integer.toString(rs.getInt(6));
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}
	
	public String[][] findIDBillLent(String ID){
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "select count(*) from ticketpay where ticketpay.IDBorrow =" + IDint +
		" and display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][6];
		
		if(size == 0) return null;
		
		query = "select IDTicketPay,callcard.IDBorrow,IDReader,datePay,punishMoney,moneyBook from ticketpay,callcard where " +
				"ticketpay.IDBorrow = callcard.IDBorrow and ticketpay.IDBorrow =" + IDint + " and ticketpay.display = 1";
		rs = sql.excutiveQuery(query);
		
		int i = 0;
		
		try {
			while(rs.next()) {
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = Integer.toString(rs.getInt(2));
				data[i][2] = Integer.toString(rs.getInt(3));
				data[i][3] = rs.getString(4);
				data[i][4] = Double.toString(rs.getDouble(5));
				data[i][5] = Integer.toString(rs.getInt(6));
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	} 
	
	public String[][] findIDReader(String ID){
		sql.open();
		int IDint = Integer.parseInt(ID);
		
		String query = "select count(*) from ticketpay,callcard where ticketpay.IDBorrow=callcard.IDBorrow " +
		"and IDReader =" + IDint + " and ticketpay.display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][6];
		
		if(size == 0) return null;
		
		query = "select IDTicketPay,callcard.IDBorrow,IDReader,datePay,punishMoney,moneyBook from ticketpay,callcard where " +
				"ticketpay.IDBorrow = callcard.IDBorrow and IDReader =" + IDint + " and ticketpay.display = 1";
		rs = sql.excutiveQuery(query);
		
		int i = 0;
		
		try {
			while(rs.next()) {
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = Integer.toString(rs.getInt(2));
				data[i][2] = Integer.toString(rs.getInt(3));
				data[i][3] = rs.getString(4);
				data[i][4] = Double.toString(rs.getDouble(5));
				data[i][5] = Integer.toString(rs.getInt(6));
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}
	
	public Object[][] takeBookUpadate(String IDTicket){
		sql.open();
		int IDTicketInt = Integer.parseInt(IDTicket);
		String query = "select count(*) from detailticketpay where IDTicketPay=" + IDTicketInt;
		ResultSet rs = sql.excutiveQuery(query);
		
		int sizeDateTP = 0;
		
		try {
			rs.next();
			sizeDateTP = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int dataTicketPay[][] = new int[sizeDateTP][2];
		
		query = "select IDBook,IDPunish from detailticketpay where IDTicketPay=" + IDTicketInt;
		rs = sql.excutiveQuery(query);
		
		int i = 0;
		
		try {
			while(rs.next()) {
				dataTicketPay[i][0] = rs.getInt(1);
				dataTicketPay[i][1] = rs.getInt(2);
				++i;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int sizeDataBook = 0;
				
		query ="select count(*) from ticketpay,detailcallcard where ticketpay.IDBorrow = detailcallcard.IDBorrow" +
				" and IDTicketPay=" + IDTicketInt;
		rs = sql.excutiveQuery(query);
		
		try {
			rs.next();
			sizeDataBook = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int dataBook[] = new int[sizeDataBook];
		int j = 0;
		
		query ="select IDBook from ticketpay,detailcallcard where ticketpay.IDBorrow = detailcallcard.IDBorrow" +
		" and IDTicketPay=" + IDTicketInt;
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				dataBook[j] = rs.getInt(1);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DAOBillPay dao = new DAOBillPay();
		DTOPunish punish[] = dao.takeColumAdd();
		
		Object data[][] = new Object[sizeDataBook][punish.length];
		
		for(int k = 0 ;k<sizeDataBook; ++k) {
			data[k][0] = dataBook[k];
			for(int o = 1;o<punish.length;++o) {
				if(findPunish((int)data[k][0],dataTicketPay,punish[o].IDPunish) == true) {
					data[k][o] = true;
				}else data[k][o] = false;
			}
		}
		
		return data;
	}
	
	public boolean findPunish(int IDBook,int data[][],int IDPunish) {
		for(int i = 0;i<data.length;++i) {
			if(data[i][0] == IDBook && data[i][1] == IDPunish) return true;
		}
		return false;
	}
	
	public String getIDBL(String IDBP) {
		sql.open();
		int IDint = Integer.parseInt(IDBP);
		String query = "select IDBorrow from ticketpay where IDTicketPay=" + IDint;
		ResultSet rs =sql.excutiveQuery(query);
		try {
			rs.next();
			return Integer.toString(rs.getInt(1));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
	public String getDateExpridayBL(String ID) {
		sql.open();
		int IDInt = Integer.parseInt(ID);
		String query = "select expiryDay from callcard where IDBorrow=" + IDInt;
		String date;
		ResultSet rs =sql.excutiveQuery(query);
		try {
			rs.next();
			return rs.getString(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public void update(String IDBP, String IDBLNew,String IDBLOld,String Money, String dataPunishBook[][], int lengthColum) {
		sql.open();
		int IDBPint = Integer.parseInt(IDBP);
		int IDBLOldint = Integer.parseInt(IDBLOld);
		int IDBLNewint = Integer.parseInt(IDBLNew);
		Double moneyDouble;
		try {
			moneyDouble = Double.parseDouble(Money);
		}catch(Exception e) {
			return;
		}
		
		String query ="delete from detailticketpay where IDTicketPay=" + IDBPint;
		sql.excutiveUpdate(query);
		
		DAOBillLent daoBL = new DAOBillLent();
		
		query = "update ticketpay set IDBorrow=" + IDBLNewint + ",punishMoney=" + moneyDouble + "where " +
		"IDTicketPay=" + IDBPint;
		sql.excutiveUpdate(query);
		
		if(IDBLNew.equals(IDBLOld) == false) {
			query = "update callcard set status =" + 0 + " where IDBorrow =" + IDBLOldint;
			sql.excutiveUpdate(query);
			String books = daoBL.takebookBL(IDBLOld);
			String listBooks[] = books.split(",");
			for(int i = 0 ; i<listBooks.length;++i) {
				int IDBook = Integer.parseInt(listBooks[i]);
				query = "update book set status=" + 0 + " where IDBook=" + IDBook;
				sql.excutiveUpdate(query);
			}
			
			query = "update callcard set status =" + 1 + " where IDBorrow=" + IDBLNewint;
			sql.excutiveUpdate(query);
			
			books = daoBL.takebookBL(IDBLNew);
			listBooks = books.split(",");
			for(int i = 0 ; i<listBooks.length;++i) {
				int IDBook = Integer.parseInt(listBooks[i]);
				query = "update book set status=" + 1 + " where IDBook=" + IDBook;
				sql.excutiveUpdate(query);
			}
			
			for(int i = 0 ;i<dataPunishBook.length;i++) {
				int IDBook = Integer.parseInt(dataPunishBook[i][0]);
				query = "update book set status = 1 where IDBook=" + IDBook;
				sql.excutiveUpdate(query);
				for(int j = 1; j<lengthColum; ++j) {
					if(dataPunishBook[i][j] == null) continue;
					int IDPunish = Integer.parseInt(dataPunishBook[i][j]);
					query = "insert into detailticketpay(IDTicketPay,IDBook,IDPunish) values(" + IDBPint + "," +
					IDBook + "," + IDPunish + ")";
					sql.excutiveUpdate(query);
							
				}
			}
		}else {
			for(int i = 0 ;i<dataPunishBook.length;i++) {
				int IDBook = Integer.parseInt(dataPunishBook[i][0]);
				query = "update book set status = 1 where IDBook=" + IDBook;
				sql.excutiveUpdate(query);
				for(int j = 1; j<lengthColum; ++j) {
					if(dataPunishBook[i][j] == null) continue;
					int IDPunish = Integer.parseInt(dataPunishBook[i][j]);
					query = "insert into detailticketpay(IDTicketPay,IDBook,IDPunish) values(" + IDBPint + "," +
					IDBook + "," + IDPunish + ")";
					sql.excutiveUpdate(query);
							
				}
			}
		}
	}
	
	public void clear(String ID) {
		int IDint = Integer.parseInt(ID);
		sql.open();
		String query ="select IDBorrow from ticketpay where IDTicketPay=" + IDint + " and display=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int IDBorrow = 0;
		
		try {
			rs.next();
			IDBorrow = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		query = "delete from ticketpay where IDTicketPay ="+ IDint + " and display=1";
		sql.excutiveUpdate(query);
		
		query = "delete from detailticketpay where IDTicketPay ="+ IDint;
		sql.excutiveUpdate(query);
		
		query ="update callcard set status = 0 where IDBorrow=" + IDBorrow;
		sql.excutiveUpdate(query);
		
		query = "select IDBook from detailcallcard where IDBorrow=" + IDBorrow;
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				query = "update book set status = 0 where IDBook=" + rs.getInt(1);
				sql.excutiveUpdate(query);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String[][] loadAllBPMenuFind(){
		sql.open();
		String query = "select count(*) from " +
				"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
				"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and display = 1"
				+ " and ticketpay.IDTicketPay=detailticketpay.IDTicketPay";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][5];
		int j = 0;
		
		query = "select ticketpay.IDTicketPay,detailticketpay.IDBook,NameBook,nameError,moneyPunish from " +
		"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
		"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and display = 1" + 
		" and ticketpay.IDTicketPay=detailticketpay.IDTicketPay";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = Double.toString(rs.getDouble(5));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] findDetailBPFollowBL(String IDBL){
		int IDBLInt = Integer.parseInt(IDBL);
		sql.open();
		String query = "select count(*) from " +
				"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
				"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
				"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and ticketpay.IDBorrow=" + IDBLInt + 
				" and display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][5];
		int j = 0;
		
		query = "select detailticketpay.IDTicketPay,detailticketpay.IDBook,NameBook,nameError,moneyPunish from " +
		"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
		"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
		"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and ticketpay.IDBorrow=" + IDBLInt +
		" and display = 1";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = Double.toString(rs.getDouble(5));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	//
	
	public String[][] findDetailBPFollowBP(String IDBP){
		int IDBPInt = Integer.parseInt(IDBP);
		sql.open();
		String query = "select count(*) from " +
				"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
				"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
				"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and ticketpay.IDTicketPay=" + IDBPInt + 
				" and display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][5];
		int j = 0;
		
		query = "select detailticketpay.IDTicketPay,detailticketpay.IDBook,NameBook,nameError,moneyPunish from " +
		"ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
		"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
		"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and ticketpay.IDTicketPay=" + IDBPInt + 
		" and display = 1";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = Double.toString(rs.getDouble(5));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	//
	
	public String[][] findDetailBPFollowReader(String IDRD){
		int IDRDInt = Integer.parseInt(IDRD);
		sql.open();
		String query = "select count(*) from " +
				"callcard,ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
				"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
				"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and callcard.IDReader=" + IDRDInt + 
				" and callcard.IDBorrow=ticketpay.IDBorrow and ticketpay.display = 1";
		ResultSet rs = sql.excutiveQuery(query);
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String data[][] = new String[size][5];
		int j = 0;
		
		query = "select detailticketpay.IDTicketPay,detailticketpay.IDBook,NameBook,nameError,moneyPunish from " +
		"callcard,ticketpay,punish,book,headbook,detailticketpay where detailticketpay.IDBook=book.IDBook and " +
		"book.IDHeadBook = headbook.IDHeadBook and detailticketpay.IDPunish = punish.IDPunish and " +
		"ticketpay.IDTicketPay=detailticketpay.IDTicketPay and callcard.IDReader=" + IDRDInt + 
		" and callcard.IDBorrow=ticketpay.IDBorrow and ticketpay.display = 1";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = Integer.toString(rs.getInt(2));
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);
				data[j][4] = Double.toString(rs.getDouble(5));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public boolean checkIDBillPay(String Forfiet, String IDBorrow, String dateMake, String dateExpiry) {
		try {
			Double.parseDouble(Forfiet);
		}catch(Exception e) {
			return false;
		}
		
		if(dateMake.equals("") == true ) return false;
		if(dateExpiry.equals("") == true) return false;
		if(checkBillLentForBP(IDBorrow) == false) return false;
		else return true;
	}
	
	
	public boolean checkIDBillPayExist(String ID) {
		if(ID.equals("") == true) return false;
		try {
			Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		SQL sql = new SQL();
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "select count(*) from ticketpay where IDTicketPay=" + IDint + " and display =1";
		ResultSet rs= sql.excutiveQuery(query);
		int size = 0;
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			
		}
		if(size == 0) return false;
		else return true;
	}
	
	public boolean checkBillLentForBP(String id) {
		SQL sql = new SQL();
		if(id.equals("") == true) return false;
		int IDint = -1;
		try{
			IDint = Integer.parseInt(id);
		}catch(Exception e) {
			
			return false;
		}
		sql.open();
		String query ="select count(*) from callcard where IDBorrow =" + IDint + " and status = 0";
		ResultSet rs = sql.excutiveQuery(query);
		int exist = 0;
		try {
			rs.next();
			exist = rs.getInt(1);
		}catch(Exception e) {
		
		
		}
		if(exist>0) return true;
		else return false;
		
	}
	
	public boolean checkBillLent(String id) {
		SQL sql = new SQL();
		if(id.equals("") == true) return false;
		int IDint = -1;
		try{
			IDint = Integer.parseInt(id);
		}catch(Exception e) {
			
			return false;
		}
		sql.open();
		String query ="select count(*) from callcard where IDBorrow =" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		int exist = 0;
		try {
			rs.next();
			exist = rs.getInt(1);
		}catch(Exception e) {
		
		
		}
		if(exist>0) return true;
		else return false;
		
	}
	
}