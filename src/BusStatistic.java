public class BusStatistic{
	
	public String[][] takeAllBookBorrow(String year,String month){
		DaoStatistic dao = new DaoStatistic();
		String data[][] = dao.ALLBookBorrow(year,month);
		return data;
	}
	
	public String[][] takeBillPay(String year,String month){
		DaoStatistic dao = new DaoStatistic();
		String data[][] = dao.listBP(year,month);
		return data;
	}
	
	public String[][] takeBillLent(String year,String month){
		DaoStatistic dao = new DaoStatistic();
		String data[][] =dao.ListBL(year,month);
		return data;
	}
}