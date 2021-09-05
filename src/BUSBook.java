public class BUSBook{
	
	public String[] listHeadBook() {
		DAOHeadBook daoHeadBook = new DAOHeadBook();
		String data[][] = daoHeadBook.showData();
		int dataLength = data.length;
		String list[] = new String[dataLength+1];
		list[0] = "ID - name book";
		int j = 0;
		for(int i = 1 ; i<dataLength+1 ; ++i) {
			list[i] = "";
			list[i] = list[i] + data[j][0] + "-" + data[j][1];
			j++;
		}
		return list;
	}
	
	public boolean checkAmount(String amount) {
		if(amount.equals("") == true) return false;
		
		try {
			int number = Integer.parseInt(amount);
			if(number<=0 || number>1000) return false;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean checkHeadBook(String headbook) {
		if(headbook.equals("") == true) {
			return false;
		}else return true;
	}
	
	public int exchangeStatus(String status) {
		if(status.equals("Ready borrow") == true) return 1;
		else return 0;
	}
	
	public boolean checkIDBook(String IDBook) {
		if(IDBook.equals("") == true) {
			return false;
		} return true;
	}
	
	public boolean checkIDClear(String IDBook) {
		if(IDBook.equals("") == true) return false;
		try {
			Integer.parseInt(IDBook);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public int exchangeState(String state) {
		if(state.equals("Normal") == true) return 1;
		else return 0;
	}
	
	public String[][] findBookFollowID(String ID){
		DAOBook daoBook = new DAOBook();
		String data[][] = daoBook.findBookFollowID(ID);
		return data;
	}
	
	public String[][] findBookFollowName(String name){
		DAOBook daoBook = new DAOBook();
		String data[][]=daoBook.findBookFollowName(name);
		return data;
	}
	
	public String[][] takeSelectBook(){
		DAOBook daoBook = new DAOBook();
		String data[][] = daoBook.tableSelectBook();
		return data;
	}
	
	public void addBook(String headbook,String status,String amount,String state,String note) {
		DAOBook daoBook = new DAOBook();
		daoBook.addBook(headbook,status,amount,state,note);
	}
	
	public void updateBook(String IDBook,String IDHeadBook,String status,String state,String note) {
		DAOBook daoBook = new DAOBook();
		daoBook.updateBook(IDBook, IDHeadBook, status, state, note);
	}
	
	public int clearBook(String IDBook) {
		DAOBook daoBook = new DAOBook();
		int status = daoBook.clearBook(IDBook);
		return status;
	}
	
	public String loadStatusMenuRepair(String IDBook) {
		DAOBook daoBook = new DAOBook();
		String data = daoBook.loadStatusMenuRepair(IDBook);
		return data;
	}
	
	public String loadStateMenuRepair(String IDBook) {
		DAOBook daoBook = new DAOBook();
		String data = daoBook.loadStateMenuRepair(IDBook);
		return data;
	}
	
	public String loadNoteMenuRepair(String IDBook){
		DAOBook daoBook = new DAOBook();
		String data = daoBook.loadNoteMenuRepair(IDBook);
		return data;
	}
	
	public String loadIDHeadBookMenuRepair(String IDBook) {
		DAOBook daoBook = new DAOBook();
		String data = daoBook.loadIDHeadBookMenuRepair(IDBook);
		return data;
	}
}