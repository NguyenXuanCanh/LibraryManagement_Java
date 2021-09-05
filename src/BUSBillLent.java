import java.sql.ResultSet;

public class BUSBillLent{
	DAOBillLent dao = new DAOBillLent();
	public boolean checkDate(String dateExpiry,String dateBorrow){
		String arrayExpiry[] = new String[3];
		arrayExpiry = dateExpiry.split("-");
		int ddExpiry = 0;
		int mmExpiry = 0;
		int yyExpiry = 0;
		try {
			yyExpiry = Integer.parseInt(arrayExpiry[0]);
			mmExpiry = Integer.parseInt(arrayExpiry[1]);
			ddExpiry = Integer.parseInt(arrayExpiry[2]);
		}catch(Exception e){
			return false;
		}
		
		if(ddExpiry <=0 || ddExpiry>31) return false;
		if(mmExpiry <=0 || mmExpiry>12) return false;
		if(yyExpiry<=0 || yyExpiry>9999) return false;
		
		int ddBorrow = 0;
		
		int mmBorrow = 0;
		
		int yyBorrow = 0;
		
		String arrayBorrow[] = new String[3];
		arrayBorrow = dateBorrow.split("-");
		
		yyBorrow = Integer.parseInt(arrayBorrow[0]);
				
		mmBorrow = Integer.parseInt(arrayBorrow[1]);
		
		ddBorrow =Integer.parseInt(arrayBorrow[2]);
		
		if(yyExpiry < yyBorrow) return false;
		
		if(yyExpiry == yyBorrow && mmExpiry < mmBorrow) return false;
		
		if(yyExpiry == yyBorrow && mmExpiry == mmBorrow && ddExpiry <= ddBorrow) return false;
		
		int amountDate = (yyExpiry-yyBorrow)*365 + (mmExpiry-mmBorrow)*30 + (ddExpiry-ddBorrow);
		
		if(amountDate>90) return false;
		
		return true;
	}
	
	public boolean checkFindUpdate(String id) {
		if(id.equals("") == true) return false;
		try {
			Integer.parseInt(id);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean checkIDReader(String IDReader) {
		boolean data = dao.checkIDReader(IDReader);
		return data;
	}
	
	public boolean checkListBookAdd(String listBook) {
		boolean data = dao.checkListBookAdd(listBook);
		return data;
	}
	
	public void insertBillLent(String IDReader,String dateBorrow,String dateExpiry,String listBook) {
		dao.insertBillLent(IDReader, dateBorrow, dateExpiry, listBook);
	}
	
	public String[][] loadAllBillLent(){
		String data[][] = dao.loadAllBillLent();
		return data;
	}
	
	public String[][] findFollowReader(String IDReader,String status){
		String data[][] = dao.findFollowReader(IDReader, status);
		return data;
	}
	
	public String[] findIDBillLent(String ID){
		String data[] = dao.findIDBillLent(ID);
		return data;
	}
	
	public boolean checkBillLent(String ID) {
		boolean data = dao.checkBillLent(ID);
		return data;
	}
	
	public boolean checkListBookUpdate(String listBook,String ID) {
		boolean data = dao.checkListBookUpdate(listBook,ID);
		return data;
	}
	
	public void updateBillLent(String IDBL,String expiry,String IDReader,String ListBook) {
		dao.updateBillLent(IDBL, expiry, IDReader, ListBook);
	}
	
	public boolean checkBLClear(String ID) {
		boolean data = dao.checkBLClear(ID);
		return data;
	}
	
	public void clearBillLent(String ID) {
		dao.clearBillLent(ID);
	}
	
	public String[][] loadAllBillLentNoPay(){
		return dao.loadAllBillLentNoPay();
	}
}