import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DAOBillLent{
	
	protected SQL sql = new SQL();
	
	public boolean checkIDReader(String ID) {
		sql.open();
		int IDint = -1;
		try {
			IDint = Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		
		String query ="select count(*) from reader where IDReader=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		int exist = 0;
		try {
			rs.next();
			exist = rs.getInt(1);
		}catch(Exception e) {
			
		}
		
		if(exist == 0) return false;
		else return true;
	}
	
	public int insertBillLent(String IDReader, String dateBorrow, String dateExpiry, String listBook) {
		sql.open();
		int IDReaderI = Integer.parseInt(IDReader);
		String arrayBook[] = listBook.split(",");
		String query;
		
		query = "insert into callcard (dateBorrow,expiryDay,IDReader,status,display)" + 
		" value(" + "\"" + dateBorrow + "\"" + "," + "\"" + dateExpiry + "\"" + "," +
		IDReaderI + "," + 0 + "," + 1 + ")";
		
		int status = sql.excutiveUpdate(query);
		
		query = "SELECT IDBorrow FROM callcard ORDER BY IDBorrow DESC LIMIT 1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int idCallCard = 0;
		
		try {
			rs.next();
			idCallCard = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0 ;i<arrayBook.length;++i) {
			query = "update book set status=" + 0 + " where IDBook=" + Integer.parseInt(arrayBook[i]);
			sql.excutiveUpdate(query);
			query = "insert into detailcallcard (IDBorrow,IDBook) " +
			"value(" + idCallCard + ", " + Integer.parseInt(arrayBook[i]) + ")";
			sql.excutiveUpdate(query);
		}
		
		query = "select amountBorrow from reader where IDReader=" + IDReaderI;
		rs = sql.excutiveQuery(query);
		int amountBorrow = - 1;
		try {
			rs.next();
			amountBorrow = rs.getInt(1);
			amountBorrow++;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "update reader set amountBorrow=" + amountBorrow + " where IDReader=" + IDReaderI;
		sql.excutiveUpdate(query);
		return status;
	}
	
	public void clearBillLent(String ID) {
		int IDBL = Integer.parseInt(ID);
		sql.open();
		
		String query = "update callcard set display = 0 where IDBorrow =" + IDBL;
		sql.excutiveUpdate(query);
		
		query = "select * from detailcallcard where IDBorrow =" + IDBL;
		ResultSet rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				String query1 = "update book set status = " + 1 + " where IDBook =" + rs.getInt(2);
				sql.excutiveUpdate(query1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "update ticketpay set display=0 where IDBorrow =" + IDBL;
		sql.excutiveUpdate(query);
	}
	
	public String[][] loadAllBillLent() {
		sql.open();
		String query = "select count(*) from callcard where display=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int amountRow = 0;
		
		try {
			rs.next();
			amountRow = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDBorrow,dateBorrow,expiryDay,IDReader,status from " +
		"callcard where display=1";
		rs = sql.excutiveQuery(query);
		String data[][] = new String[amountRow][6];
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getString(3);
				data[j][3] = Integer.toString(rs.getInt(4));
				if(rs.getInt(5) == 1) {
					data[j][4] = "Paid";
				}else data[j][4] = "UnPaid";
				data[j][5] = takebookBL(data[j][0]);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] loadAllBillLentNoPay() {
		sql.open();
		String query = "select count(*) from callcard where status = 0 and display=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		int amountRow = 0;
		
		try {
			rs.next();
			amountRow = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDBorrow,dateBorrow,expiryDay,IDReader,status from " +
		"callcard where status = 0 and display=1";
		rs = sql.excutiveQuery(query);
		String data[][] = new String[amountRow][6];
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getString(3);
				data[j][3] = Integer.toString(rs.getInt(4));
				if(rs.getInt(5) == 1) {
					data[j][4] = "Paid";
				}else data[j][4] = "UnPaid";
				data[j][5] = takebookBL(data[j][0]);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String takebookBL(String IDBorrow) {
		int IDint = Integer.parseInt(IDBorrow);
		
		sql.open();
		String query = "select count(*) from detailcallcard where IDBorrow=" + IDint;
		ResultSet rs = sql.excutiveQuery(query);
		
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDBook from detailcallcard where IDBorrow=" + IDint;
		rs = sql.excutiveQuery(query);
		
		String listBook = "";
		int j = 0;
		try {
			while(rs.next()) {
				listBook+=Integer.toString(rs.getInt(1));
				if(j<amount-1) listBook+= ",";
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listBook;
	}
	
	public String[][] findFollowReader(String IDReader, String status){
		sql.open();
		int IDint = Integer.parseInt(IDReader);
		int statusInt = 2;
		
		if(status.equals("UnPaid") == true ) statusInt = 0;
		if(status.equals("Paid") == true ) statusInt = 1;
		String query;
		if(statusInt!=2) {
			query = "select count(*) from callcard where IDReader=" + IDint + " and status=" + statusInt + " and display=1";
		}else query = "select count(*) from callcard where IDReader=" + IDint + " and display=1";
		
		ResultSet rs = sql.excutiveQuery(query);
		
		int amountRow = 0;
		
		try {
			rs.next();
			amountRow = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(statusInt!=2) {
			query = "select IDBorrow,dateBorrow,expiryDay,IDReader,status from " +
					"callcard where IDReader =" + IDint +  " and status=" + statusInt + " and display=1";
		}else query = "select IDBorrow,dateBorrow,expiryDay,IDReader,status from callcard where IDReader=" + IDint + " and display=1";
		
		rs = sql.excutiveQuery(query);
		String data[][] = new String[amountRow][6];
		int j = 0;
		
		try {
			while(rs.next()) {
				data[j][0] = Integer.toString(rs.getInt(1));
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getString(3);
				data[j][3] = Integer.toString(rs.getInt(4));
				if(rs.getInt(5) == 1) {
					data[j][4] = "Paid";
				}else data[j][4] = "UnPaid";
				data[j][5] = takebookBL(data[j][0]);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[] findIDBillLent(String ID) {
		sql.open();
		int IDint = Integer.parseInt(ID);
		String query = "select * from callcard where IDBorrow=" + IDint + " and display=1";
		ResultSet rs = sql.excutiveQuery(query);
		
		if(rs==null) return null;
		
		String data[] = new String[6];
		
		try {
			while(rs.next()) {
				data[0] = Integer.toString(rs.getInt(1));
				data[1] = rs.getString(2);
				data[2] = rs.getString(3);
				data[3] = Integer.toString(rs.getInt(4));
				if(rs.getInt(5) == 1) data[4] = "Paid";
				else data[4] = "UnPaid";
				data[5] = takebookBL(ID);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public void updateBillLent(String IDBL,String expiryDay,String IDReader,String listBook) {
		int IDBLInt = Integer.parseInt(IDBL);
		int IDReaderInt = Integer.parseInt(IDReader);
		sql.open();
		
		String query = "select IDReader from callcard where IDBorrow=" + IDBLInt;
		ResultSet rs = sql.excutiveQuery(query);
		int IDReaderOld = -1;
		
		try {
			rs.next();
			IDReaderOld = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(IDReaderOld != IDReaderInt) {
			query = "select amountBorrow from reader where IDReader=" + IDReaderOld;
			rs = sql.excutiveQuery(query);
			int amountBorrow = - 1;
			try {
				rs.next();
				amountBorrow = rs.getInt(1);
				amountBorrow--;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			query = "update reader set amountBorrow=" + amountBorrow + " where IDReader=" + IDReaderOld;
			sql.excutiveUpdate(query);
			
			///
			query = "select amountBorrow from reader where IDReader=" + IDReaderInt;
			rs = sql.excutiveQuery(query);
			amountBorrow = - 1;
			try {
				rs.next();
				amountBorrow = rs.getInt(1);
				amountBorrow++;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			query = "update reader set amountBorrow=" + amountBorrow + " where IDReader=" + IDReaderInt;
			sql.excutiveUpdate(query);
			
		}
		
		query = "update callcard set expiryDay=\"" + expiryDay + "\"" + "," +
		"IDReader=" + IDReaderInt  + " where IDBorrow =" + IDBLInt;
		sql.excutiveUpdate(query);
		
		String listBookIDString[] = listBook.split(",");
		int listBookIDInt[] = new int[listBookIDString.length];
	
		for(int i = 0 ; i<listBookIDInt.length;++i) {
			listBookIDInt[i] = Integer.parseInt(listBookIDString[i]);
		}
		
		query = "select count(*) from detailcallcard where IDBorrow=" + IDBLInt;
		rs = sql.excutiveQuery(query);
		int amount = 0;
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDBook from detailcallcard where IDBorrow=" + IDBLInt;
		rs = sql.excutiveQuery(query);
		
		int listBookOld[] = new int[amount];
		int k = 0;
		
		try {
			while(rs.next()) {
				listBookOld[k] = rs.getInt(1);
				k++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		int listBookRemove[] = new int[listBookIDInt.length + listBookOld.length];
		int indexBookRemove = 0;
		
		int listBookOldInNew[] = new int[listBookIDInt.length + listBookOld.length];
		int indexBookOldInNew = 0;
		
		for(int i = 0 ;i<listBookOld.length; i++) {
			int flag = 0;
			for(int j = 0 ; j<listBookIDInt.length; ++j) {
				if(listBookOld[i] == listBookIDInt[j]) {
					flag = 1;
					listBookOldInNew[indexBookOldInNew] = listBookOld[i];
					indexBookOldInNew++;
					break;
				}
			}
			if(flag == 0) {
				listBookRemove[indexBookRemove] = listBookOld[i];
				indexBookRemove++;
			}
		}
		
		if(indexBookRemove > 0) {
			for(int i = 0; i<indexBookRemove ;++i) {
				query = "update book set status = " + 1 + " where IDBook = " + listBookRemove[i];
				sql.excutiveUpdate(query);
				
			}
		}
		
		// delete
		
		query = "delete from detailcallcard where IDBorrow =" + IDBLInt;
		sql.excutiveUpdate(query);
		
		// update
		int sign;
		for(int i = 0; i<listBookIDInt.length ; ++i) {
			query = "insert into detailcallcard (IDBorrow,IDBook) values(" + IDBLInt + "," + listBookIDInt[i] + ")";
			sql.excutiveUpdate(query);
			query = "update book set status = " + 0 + " where IDBook = " + listBookIDInt[i];
			sql.excutiveUpdate(query);
		}
		
	}
	
	public boolean checkListBookAdd(String listBook) {
		if(listBook.equals("") == true) return false;
		SQL sql = new SQL();
		sql.open();
		String arrayBook[] = listBook.split(",");
		String query;
		for(int i = 0 ;i<arrayBook.length-1;++i) {
			for(int j = i+1 ; j<arrayBook.length;j++) {
				if(arrayBook[i].equals(arrayBook[j]) == true) return false;
			}
		}
		int count = 0;
		for(int i = 0 ;i <arrayBook.length;++i) {
			try {
				Integer.parseInt(arrayBook[i]);
			}catch(Exception e) {
				return false;
			}
			query = "select count(*) from book where IDBook=" + Integer.parseInt(arrayBook[i]);
			ResultSet rs = sql.excutiveQuery(query);
			try{
				rs.next();
				if(rs.getInt(1) > 0) count++;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		for(int i = 0; i<arrayBook.length; i++) {
			query = "select status from book where IDBook=" + Integer.parseInt(arrayBook[i]);
			ResultSet rs = sql.excutiveQuery(query);
			try {
				rs.next();
				if(rs.getInt(1) == 0) return false;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(count == arrayBook.length) return true;
		else return false;
		
	}
	
	public boolean checkListBookUpdate(String listBook, String IDBorrow) {
		if(listBook.equals("") == true) return false;
		SQL sql = new SQL();
		sql.open();
		String arrayBook[] = listBook.split(",");
		String query;
		// check loop
		for(int i = 0 ;i<arrayBook.length-1;++i) {
			for(int j = i+1 ; j<arrayBook.length;j++) {
				if(arrayBook[i].equals(arrayBook[j]) == true) return false;
			}
		}
		
		// check exist and check is no stringNumber
		int count = 0;
		for(int i = 0 ;i <arrayBook.length;++i) {
			try {
				Integer.parseInt(arrayBook[i]);
			}catch(Exception e) {
				return false;
			}
			query = "select count(*) from book where IDBook=" + Integer.parseInt(arrayBook[i]);
			ResultSet rs = sql.excutiveQuery(query);
			try{
				rs.next();
				if(rs.getInt(1) > 0) count++;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		if(count != arrayBook.length) return false;
		
		
		// find amount book old
		int IDBorrowInt = Integer.parseInt(IDBorrow);
		
		query = "select count(*) from detailcallcard where IDBorrow=" + IDBorrowInt;
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// find book old
		query = "select IDBook from detailcallcard where IDBorrow=" + IDBorrowInt;
		rs = sql.excutiveQuery(query);
		
		int listBookOld[] = new int[amount];
		int k = 0;
		
		try {
			while(rs.next()) {
				listBookOld[k] = rs.getInt(1);
				k++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// find book new
		int listBookNew[] = new int[arrayBook.length];
		int indexBookNew = 0;
		
		for(int i = 0 ; i<arrayBook.length;++i) {
			int flag = 0;
			for(int j = 0;j<listBookOld.length;++j) {
				if(Integer.parseInt(arrayBook[i]) == listBookOld[j]) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				listBookNew[indexBookNew] = Integer.parseInt(arrayBook[i]);
				indexBookNew++;
			}
		}
		
		
		// check status of book new
		for(int i = 0; i<indexBookNew; i++) {
			query = "select status from book where IDBook=" + listBookNew[i];
			rs = sql.excutiveQuery(query);
			try {
				rs.next();
				if(rs.getInt(1) == 0) return false;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return true;
	
	}
	
	
	public boolean checkBillLent(String id) {
		if(id.equals("") == true) return false;
		int IDint = -1;
		try{
			IDint = Integer.parseInt(id);
		}catch(Exception e) {
			
			return false;
		}
		sql.open();
		String query ="select count(*) from callcard where IDBorrow =" + IDint + " and display=1";
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
	
	public boolean checkBLClear(String ID) {
		
		sql.open();
		
		int IDBL = Integer.parseInt(ID);
		
		String query = "select count(*) from callcard,ticketpay where callcard.IDBorrow = ticketpay.IDBorrow"
				+ " and callcard.IDBorrow=" + IDBL;
		ResultSet rs = sql.excutiveQuery(query);
		
		int BPExist = -1;
		
		try {
			rs.next();
			BPExist = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(BPExist <= 0) return false;
		else return true;
	}

}