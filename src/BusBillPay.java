import java.sql.ResultSet;

public class BusBillPay{
	DAOBillPay dao = new DAOBillPay();
	public boolean checkMixIDBorrow(Object dataAdd[][], String IDBorrow) {
		DAOBillLent daoBL = new DAOBillLent();
		String BookInBL[] = daoBL.takebookBL(IDBorrow).split(",");
		int flag = 0;
		for(int i = 0 ; i<dataAdd.length;++i) {
			flag = 0;
			for(int j = 0 ; j<BookInBL.length;++j) {
				 if(dataAdd[i][0].equals(BookInBL[j]) == true) {
					flag = 1;
					break;
				 }
			}
			if(flag == 0) return false;
		}
		return true;
	}
	
	public DTOPunish[] takeColumAdd() {
		return dao.takeColumAdd();
	}
	
	public boolean checkBillLentForBP(String ID) {
		boolean data = dao.checkBillLentForBP(ID);
		return data;
	}
	
	public Object[][] takeBookRent(String IDBorrow){
		return dao.takeBookRent(IDBorrow);
	}
	
	public String getDateExpridayBL(String ID) {
		return dao.getDateExpridayBL(ID);
	}
	
	public boolean checkIDBillPay(String moneyPunish,String iDBorrow,String make,String expiry) {
		boolean data =dao.checkIDBillPay(moneyPunish,iDBorrow,make,expiry);
		return data;
	}
	
	public void insertBP(String IDBorrow,String datePay,String moneyPunish,String moneyBook,String [][] dataPunishBook, int length) {
		dao.insertBP(IDBorrow, datePay, moneyPunish, moneyBook, dataPunishBook,length);
	}
	
	public double takePrice(String ID) {
		return dao.takePrice(ID);
	}
	
	public String[][] takeAllBillPay(){
		return dao.takeAllBillPay();
	}
	
	public boolean checkIDBillPayExist(String ID) {
		boolean data = dao.checkIDBillPayExist(ID);
		return data;
	}
	
	public void update(String IDBP,String IDBL,String IDBLOld,String moneyUpdate,String [][] dataPunishBook,int length) {
		dao.update(IDBP, IDBL, IDBLOld,moneyUpdate , dataPunishBook, length);
	}
	
	public String getIDBL(String IDBP) {
		return dao.getIDBL(IDBP);
	}
	
	public Object[][] takeBookUpadate(String IDBP){
		return dao.takeBookUpadate(IDBP);
	}
	
	public boolean checkBillLent(String ID) {
		return dao.checkBillLent(ID);
	}
	
	public String[][] findIDBillLent(String ID){
		return dao.findIDBillLent(ID);
	}
	
	public String[][] findIDReader(String ID){
		return dao.findIDReader(ID);
	}
	
	public void clear(String ID) {
		dao.clear(ID);
	}
	
	public String[][] loadAllBPMenuFind(){
		return dao.loadAllBPMenuFind();
	}
	
	public String[][] findDetailBPFollowBL(String ID){
		return dao.findDetailBPFollowBL(ID);
	}
	
	public String[][] findDetailBPFollowBP(String ID){
		return dao.findDetailBPFollowBP(ID);
	}
	
	public String[][] findDetailBPFollowReader(String ID){
		return dao.findDetailBPFollowReader(ID);
	}
	
	public boolean checkMoneyUpdate(String money) {
		if(money.equals("") == true) return false;
		try {
			Double.parseDouble(money);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public int calculateRent(String dateBorrow, String datePay) {
		String arrDateBrr[] = dateBorrow.split("-");
		String arrDatePay[] = datePay.split("-");
		
		int yearBrr = Integer.parseInt(arrDateBrr[0]);
		int monthBrr = Integer.parseInt(arrDateBrr[1]);
		int dateBrr = Integer.parseInt(arrDateBrr[2]);
		
		int yearP = Integer.parseInt(arrDatePay[0]);
		int monthP = Integer.parseInt(arrDatePay[1]);
		int dateP = Integer.parseInt(arrDatePay[2]);
		
		int sumDateRent = (yearP-yearBrr)*365 + (monthP-monthBrr)*30 + (dateP-dateBrr);
		if(sumDateRent <=0 ) return 1;
		else return sumDateRent;
		
	}
}