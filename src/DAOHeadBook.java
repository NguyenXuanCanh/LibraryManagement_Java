import java.sql.ResultSet;

public class DAOHeadBook{
	
	protected SQL sql = new SQL();
	
	public DTOLanguage[] loadLanguage() {
		sql.open();
		
		String query = "select count(*) from language";
		ResultSet rs = sql.excutiveQuery(query);
		int amountLanguage = 0;
		
		try {
			rs.next();
			amountLanguage = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOLanguage listLanguage[] = new DTOLanguage[amountLanguage];
		
		for(int i=0; i<amountLanguage; i++) {
			listLanguage[i] = new DTOLanguage();
		}
		
		query = "select * from language";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listLanguage[j].IDLanguage = rs.getInt(1);
				listLanguage[j].nameLanguage = rs.getString(2);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listLanguage;
	}
	
	public DTOAuthor[] loadAuthor(int IDint) {
		sql.open();
		
		String query = "select count(*) from detailauthor,author where detailauthor.IDHeadBook=" + IDint
				+ " and " + "detailauthor.IDAuthor = author.IDAuthor";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOAuthor listAuthor[] = new DTOAuthor[amount];
		
		for(int i=0; i<amount; i++) {
			listAuthor[i] = new DTOAuthor();
		}
		
		query = "select author.IDAuthor,author.nameAuthor from detailauthor,author where IDHeadBook=" + IDint
				+ " and " + "detailauthor.IDAuthor = author.IDAuthor";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listAuthor[j].IDAuthor = rs.getInt(1);
				listAuthor[j].nameAuthor = rs.getString(2);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listAuthor;
	}
	
	public DTOCategory[] loadCategory() {
		sql.open();
		
		String query = "select count(*) from category";
		ResultSet rs = sql.excutiveQuery(query);
		int amountCategory = 0;
		
		try {
			rs.next();
			amountCategory = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOCategory listCategory[] = new DTOCategory[amountCategory];
		
		for(int i=0; i<amountCategory; i++) {
			listCategory[i] = new DTOCategory();
		}
		
		query = "select * from category";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listCategory[j].IDCategory = rs.getInt(1);
				listCategory[j].nameCategory = rs.getString(2);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listCategory;
	}
	
	public DTOPublishCompany[] loadPubCompany() {
		sql.open();
		
		String query = "select count(*) from publishCompany";
		ResultSet rs = sql.excutiveQuery(query);
		int amountPublishCompany = 0;
		
		try {
			rs.next();
			amountPublishCompany = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOPublishCompany listPubCompany[] = new DTOPublishCompany[amountPublishCompany];
		
		for(int i=0; i<amountPublishCompany; i++) {
			listPubCompany[i] = new DTOPublishCompany();
		}
		
		query = "select * from publishCompany";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listPubCompany[j].IDPubCompany = rs.getInt(1);
				listPubCompany[j].namePubCompany = rs.getString(2);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listPubCompany;
	}
	
	public DTOHeadBook[] loadHeadBook() {
		sql.open();
		
		String query = "select count(*) from headbook";
		ResultSet rs = sql.excutiveQuery(query);
		int amountHeadBook = 0;
		
		try {
			rs.next();
			amountHeadBook = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOHeadBook listHeadBook[] = new DTOHeadBook[amountHeadBook];
		
		for(int i=0; i<amountHeadBook; i++) {
			listHeadBook[i] = new DTOHeadBook();
		}
		
		query = "select * from headbook";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listHeadBook[j].IDHeadBook = rs.getInt(1);
				listHeadBook[j].NameBook = rs.getString(2);
				listHeadBook[j].IDCategory = rs.getInt(3);
				listHeadBook[j].IDLanguage = rs.getInt(4);
				listHeadBook[j].PublishCompany = rs.getInt(5);
				listHeadBook[j].Price = rs.getInt(6);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listHeadBook;
		
	}
	
	public int addHeadBook(String nameHeadBook, String nameAuthor, String price,
						   int category, int language, int publishCompany,
						   String[][] AuthorOld, int amountRow) {
		
		if(nameAuthor.equals("") == true && amountRow == 0) return 0;
		
		sql.open();
		int priceInt = Integer.parseInt(price);
		// separate name author
		
		String query = "insert into headbook (NameBook,IDCategory,IDLanguage," + 
					   "PublishCompany,Price) " +
					   "value (\"" + nameHeadBook + "\"" + "," + category + "," + 
					   language + "," + publishCompany +
					   "," + priceInt + ")";
		
		int status = sql.excutiveUpdate(query);
		
		// find id head book last
		int IDHeadBook = searchIDHeadbookLast();
		
		if(nameAuthor.equals("") == false) {
			String listAuthor[] = nameAuthor.split(",");
			// remove space first and last
			for(int i=0; i<listAuthor.length;++i) {
				listAuthor[i].trim();
				query = "insert into author(nameAuthor) value(\"" + listAuthor[i] + "\")";
				sql.excutiveUpdate(query);
				int IDAuthor = searchIDAuthorLast();
				query = "insert into detailauthor (IDAuthor,IDHeadBook) " +
						"value (" + IDAuthor + "," + IDHeadBook + ")";
				sql.excutiveUpdate(query);
			}
		}
		
		for(int i=0 ;i<amountRow; i++) {
			query = "insert into detailauthor (IDAuthor,IDHeadBook) " +
					"value (" + AuthorOld[i][0] + "," + IDHeadBook + ")";
			sql.excutiveUpdate(query);
		}
		return 1;
	}
	
	public int searchIDAuthorLast() {
		sql.open();
		String query = "select* from author";
		ResultSet rs = sql.excutiveQuery(query);
		
		int IDAuthor = 0;
		
		try {
			while(rs.next()) {
				IDAuthor = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return IDAuthor;
	}
	
	public int searchIDHeadbookLast() {
		sql.open();
		String query = "select* from headbook";
		ResultSet rs = sql.excutiveQuery(query);
		
		int IDHeadBook = 0;
		
		try {
			while(rs.next()) {
				IDHeadBook = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return IDHeadBook;
	}
	
	public int repairHeadBook(String ID, String nameHeadBook, String nameAuthor, String price,
			   				  int category, int language, int publishCompany, String[][]dateRowAuthor, int amountRow) {
		
		if(nameAuthor.equals("") == true && amountRow == 0) return 0;
		
		sql.open();
		int IDInt = Integer.parseInt(ID);
		int priceInt = Integer.parseInt(price);
		
		String listAuthor[] = nameAuthor.split(",");
		
		String query = "update headbook " +
						" set " + "NameBook=\"" + nameHeadBook + "\"," + 
						"IDCategory=" + category + "," + "IDLanguage=" + language +
						"," + "PublishCompany=" + publishCompany +
						"," + "Price=" + priceInt +
						" where IDHeadBook=" + IDInt;
		
		sql.excutiveUpdate(query);
		
		query = "delete from detailauthor where IDHeadBook =" + IDInt;
		sql.excutiveUpdate(query);
		
		if(nameAuthor.equals("") == false) {
			for(int i=0; i<listAuthor.length;++i) {
				listAuthor[i].trim();
				query = "insert into author(nameAuthor) value(\"" + listAuthor[i] + "\")";
				sql.excutiveUpdate(query);
				int IDAuthor = searchIDAuthorLast();
				query = "insert into detailauthor (IDAuthor,IDHeadBook) " +
						"value (" + IDAuthor + "," + IDInt + ")";
				sql.excutiveUpdate(query);
			}
		}
		
		for(int i=0 ;i<amountRow;++i) {
			query = "insert into detailauthor (IDAuthor,IDHeadBook) " +
					"value (" + dateRowAuthor[i][0] + "," + IDInt + ")";
			sql.excutiveUpdate(query);
		}
		return 1;
	}
	
	public int clearHeadBook(String IDstring) {
		sql.open();
		int IDinteger = Integer.parseInt(IDstring);
		String query = "DELETE FROM headbook WHERE IDHeadBook =" + IDinteger;
		int status = sql.excutiveUpdate(query);
		return status;
	}
	
	public DTOHeadBook[] findHeadBook(String query, String nameBook) {
		sql.open();
		
		String queryCount = "select count(*) " + "from headbook,category,language,publishcompany where NameBook=\"" + nameBook + "\"" + " and " + 
		"IDCategory=IDCategory" + " and " + "IDLanguage=IDLanguage" + " and " + "PublishCompany=IDPubCompany";
		ResultSet rs = sql.excutiveQuery(queryCount);
		int amountHeadBook = 0;
		
		try {
			rs.next();
			amountHeadBook = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOHeadBook listHeadBook[] = new DTOHeadBook[amountHeadBook];
		
		for(int i=0; i<amountHeadBook; i++) {
			listHeadBook[i] = new DTOHeadBook();
		}

		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listHeadBook[j].IDHeadBook = rs.getInt(1);
				listHeadBook[j].NameBook = rs.getString(2);
//				listHeadBook[j].IDCategory = rs.getString(3);
//				listHeadBook[j].IDLanguage = rs.getString(4);
//				listHeadBook[j].Author = rs.getString(5);
//				listHeadBook[j].PublishCompany = rs.getString(6);
				listHeadBook[j].Price = rs.getInt(7);
				++j;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listHeadBook;
	}
	
	public String [][] loadAuthor() {
		sql.open();
		String query = "select count(*) from author";
		ResultSet rs = sql.excutiveQuery(query);
		int amountAuthor = 0;
		
		try {
			rs.next();
			amountAuthor = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		DTOAuthor listAuthor[] = new DTOAuthor[amountAuthor];
		
		for(int i=0; i<amountAuthor; i++) {
			listAuthor[i] = new DTOAuthor();
		}
		
		query = "select * from author";
		rs = sql.excutiveQuery(query);
		
		int j = 0;
		
		try {
			while(rs.next()) {
				listAuthor[j].IDAuthor = rs.getInt(1);
				listAuthor[j].nameAuthor = rs.getString(2);
				++j;
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String dataRow[][] = new String[listAuthor.length][2];
		
		for(int i = 0; i<listAuthor.length; ++i) {
			dataRow[i][0] = Integer.toString(listAuthor[i].IDAuthor);
			dataRow[i][1] = listAuthor[i].nameAuthor;
		}
		return dataRow;
		
	}
	
	public String[] findBookFollowID(int ID) {
		sql.open();
		String query = "select IDHeadBook,NameBook,nameCategory,NameLanguage,NamePubCompany,Price"
				+ " from headbook,language,category,publishcompany "
		+ "where IDHeadBook=" + ID + " and " + "headbook.IDCategory=category.IDCategory " +
		"and " + "headbook.IDLanguage=language.IDLanguage" + " and " +
		"headbook.PublishCompany=publishcompany.IDPubCompany";
		ResultSet rs = sql.excutiveQuery(query);
	
		String []result = new String[6];
		
		try{
			rs.next();
			result[0] = Integer.toString(rs.getInt(1));
			result[1] = rs.getString(2);
			result[2] = rs.getString(3);
			result[3] = rs.getString(4);
			result[4] = rs.getString(5);
			result[5] = Integer.toString(rs.getInt(6));
		}catch(Exception e) {
			result[0] = "";
		}
		return result;
	}
	
	public String findAuthorHeadBook(int ID){
		sql.open();
		String query = "select count(*) from detailauthor where IDHeadbook=" + ID;
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select nameAuthor from detailauthor,author where IDHeadbook=" + ID
		+ " and " + "detailauthor.IDAuthor=author.IDAuthor";
		rs = sql.excutiveQuery(query);
		String data[] = new String[amount];
		String listAuthor ="";
		
		int j = 0;
		try {
			while(rs.next()) {
				data[j]=rs.getString(1);
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i<amount; ++i) {
			listAuthor+=data[i];
			if(i<amount-1) {
				listAuthor+=",";
			}
		}
		return listAuthor;
	}
	
	public String[][] findBookFollowName(String nameBook) {
		sql.open();
		String query = "select count(*) " +
				" from headbook " + "where NameBook=\"" + nameBook + "\"";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDHeadBook,NameBook,nameCategory,NameLanguage,NamePubCompany,Price"
				+ " from headbook,language,category,publishcompany "
		+ "where NameBook=\"" + nameBook + "\"" + " and " + "headbook.IDCategory=category.IDCategory " +
		"and " + "headbook.IDLanguage=language.IDLanguage" + " and " +
		"headbook.PublishCompany=publishcompany.IDPubCompany";
		rs = sql.excutiveQuery(query);
		
		String [][]dataRow = new String[amount][7];
		int j = 0;
		try {
			while(rs.next()) {
				dataRow[j][0] = Integer.toString(rs.getInt(1));
				dataRow[j][1] = rs.getString(2);
				dataRow[j][2] = rs.getString(3);
				dataRow[j][3] = rs.getString(4);
				dataRow[j][4] = rs.getString(5);
				dataRow[j][5] = "";
				dataRow[j][6] = Integer.toString(rs.getInt(6));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dataRow;
	}
	
	public String[][] showData() {
		sql.open();
		String query = "select count(*) " +
				" from headbook ";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select IDHeadBook,NameBook,nameCategory,NameLanguage,NamePubCompany,Price"
				+ " from headbook,language,category,publishcompany "
		+ "where "  + "headbook.IDCategory=category.IDCategory " +
		"and " + "headbook.IDLanguage=language.IDLanguage" + " and " +
		"headbook.PublishCompany=publishcompany.IDPubCompany";
		rs = sql.excutiveQuery(query);
		
		String [][]dataRow = new String[amount][7];
		int j = 0;
		try {
			while(rs.next()) {
				dataRow[j][0] = Integer.toString(rs.getInt(1));
				dataRow[j][1] = rs.getString(2);
				dataRow[j][2] = rs.getString(3);
				dataRow[j][3] = rs.getString(4);
				dataRow[j][4] = rs.getString(5);
				dataRow[j][5] = findAuthorHeadBook(rs.getInt(1));
				dataRow[j][6] = Integer.toString(rs.getInt(6));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dataRow;
	}
	
	public String[][] takeDataExport(){
		sql.open();
		String query = "select count(*) " +
				" from headbook ";
		ResultSet rs = sql.excutiveQuery(query);
		int amount = 0;
		
		try {
			rs.next();
			amount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		query = "select * from headbook";
		rs = sql.excutiveQuery(query);
		
		String [][]dataRow = new String[amount][6];
		int j = 0;
		try {
			while(rs.next()) {
				dataRow[j][0] = Integer.toString(rs.getInt(1));
				dataRow[j][1] = rs.getString(2);
				dataRow[j][2] = Integer.toString(rs.getInt(3));
				dataRow[j][3] = Integer.toString(rs.getInt(4));
				dataRow[j][4] = Integer.toString(rs.getInt(5));
				dataRow[j][5] = Integer.toString(rs.getInt(6));
				j++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dataRow;
	}
		
}