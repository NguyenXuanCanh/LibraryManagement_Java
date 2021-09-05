public class BusHeadBook{
	DAOHeadBook dao = new DAOHeadBook();
	public boolean checkNameHeadBook(String nameHeadBook) {
		if(nameHeadBook.equals("") == true) {
			return false;
		}
		return true;
	}
	
	public boolean checkNameAuthor(String nameAuthor) {
		if(nameAuthor.equals("") == true) {
			return false;
		}
		return true;
	}
	
	public boolean checkPrice(String price) {
		if(price.equals("") == true) return false;
		
		try {
			Double.parseDouble(price);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean checkID(String ID) {
		if(ID.equals("") == true) return false;
		try {
			Integer.parseInt(ID);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public String[] separateAuthor(String listAuthor){
		String author[] = listAuthor.split(",");
		return author;
	} 
	
	public String[][] showData(){
		String data[][] = dao.showData();
		return data;
	}
	
	public String findAuthorHeadBook(int ID){
		String data = dao.findAuthorHeadBook(ID);
		return data;
	}
	
	public String[] findBookFollowID(int ID){
		String data[] = dao.findBookFollowID(ID);
		return data;
	}
	
	public String[][] findBookFollowName(String name){
		String data[][] = dao.findBookFollowName(name);
		return data;
	}
	
	public String[][] loadAuthor(){
		String data[][] = dao.loadAuthor();
		return data;
	}
	
	public DTOLanguage[] loadLanguage() {
		DTOLanguage data[] = dao.loadLanguage();
		return data;
	}
	
	public DTOCategory[] loadCategory() {
		DTOCategory data[]= dao.loadCategory();
		return data;
	}
	
	public DTOPublishCompany[] loadPubCompany() {
		DTOPublishCompany data[]=dao.loadPubCompany();
		return data;
	}
	
	public int addHeadBook(String nameHeadBook,String nameAuthor,String price,int IDCategory,int IDLanguage,int IDPubCompany,String [][]dataRowAuthor,int amountRow) {
		int status = dao.addHeadBook(nameHeadBook, nameAuthor, price, IDCategory, IDLanguage, IDPubCompany,dataRowAuthor,amountRow);
		return status;
	}
	
	public void clearHeadBook(String ID) {
		dao.clearHeadBook(ID);
	}
	
	public int repairHeadBook(String IDHeadBook, String nameHeadBook, String nameAuthor, String price, int IDCategory,int IDLanguage,int IDPubCompany,String[][] dataRowAuthor,int amountRow) {
		int status = dao.repairHeadBook(IDHeadBook, nameHeadBook, nameAuthor, price, IDCategory, IDLanguage, IDPubCompany,dataRowAuthor,amountRow);
		return status;
	}
	
	public DTOAuthor[] loadAuthor(int ID) {
		DTOAuthor[] data = dao.loadAuthor(ID);
		return data;
	}
	
	public DTOHeadBook[] loadHeadBook() {
		DTOHeadBook[] data =dao.loadHeadBook();
		return data;
	}
	
	public String[][] takeDataExport(){
		return dao.takeDataExport();
	}
	
}