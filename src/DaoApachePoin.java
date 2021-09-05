public class DaoApachePoin{
	protected SQL sql = new SQL();
	public int ImportHeadBook(DTOHeadBook[] listHeadBook) {
		sql.open();
		String query;
		int status = -1;
		for(int i = 0;i<listHeadBook.length;++i) {
			query = "insert into headbook(IDHeadBook,NameBook,IDCategory,IDLanguage,PublishCompany,Price) " +
			"values(" + listHeadBook[i].IDHeadBook + "," + "\"" + listHeadBook[i].NameBook + "\"" + "," +
			listHeadBook[i].IDCategory + "," + listHeadBook[i].IDLanguage + "," + listHeadBook[i].PublishCompany +
			"," + listHeadBook[i].Price + ")";
			status = sql.excutiveUpdate(query);
			if(status < 0) return -1;
		}
		
		sql.close();
		return status;
	}
}