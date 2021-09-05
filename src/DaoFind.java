import java.sql.ResultSet;

public class DaoFind{
	protected SQL sql = new SQL();
	
	public String[][] findNameBook(String name){
		sql.open();
		String query="select count(*) from book,headbook,category,language,publishcompany where NameBook=" + "\"" + name + "\""
		+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
		+ " and headbook.PublishCompany=publishcompany.IDPubCompany";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String [][] data = new String[size][7];
		int i = 0;
		
		query="select book.IDBook,NameBook,nameCategory,NameLanguage,NamePubCompany,book.status,book.IDHeadBook from book,headbook,category,language,publishcompany where NameBook=" + "\"" + name + "\""
				+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
				+ " and headbook.PublishCompany=publishcompany.IDPubCompany";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				DAOHeadBook daohb = new DAOHeadBook();
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = daohb.findAuthorHeadBook(rs.getInt(7));
				if(rs.getInt(6) == 1) {
					data[i][6] = "Already Borrow";
				}else data[i][6] = "No Already Borrow";
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] loadAllBook(){
		sql.open();
		String query="select count(*) from book";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String [][] data = new String[size][7];
		int i = 0;
		
		query="select book.IDBook,NameBook,nameCategory,NameLanguage,NamePubCompany,book.status,book.IDHeadBook " +
		"from book,headbook,category,language,publishcompany " +
		"where headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
		+ " and headbook.PublishCompany=publishcompany.IDPubCompany";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				DAOHeadBook daohb = new DAOHeadBook();
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = daohb.findAuthorHeadBook(rs.getInt(7));
				if(rs.getInt(6) == 1) {
					data[i][6] = "Already Borrow";
				}else data[i][6] = "No Already Borrow";
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] loadBookFollowCategory(int IDCategory){
		sql.open();
		String query="select count(*) from book,headbook,category,language,publishcompany where headbook.IDCategory=" + IDCategory
		+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
		+ " and headbook.PublishCompany=publishcompany.IDPubCompany";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String [][] data = new String[size][7];
		int i = 0;
		
		query="select book.IDBook,NameBook,nameCategory,NameLanguage,NamePubCompany,book.status,book.IDHeadBook from book,headbook,category,language,publishcompany where headbook.IDCategory=" + IDCategory
				+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
				+ " and headbook.PublishCompany=publishcompany.IDPubCompany";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				DAOHeadBook daohb = new DAOHeadBook();
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = daohb.findAuthorHeadBook(rs.getInt(7));
				if(rs.getInt(6) == 1) {
					data[i][6] = "Already Borrow";
				}else data[i][6] = "No Already Borrow";
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public String[][] loadBookFollowAuthor(String author){
		sql.open();
		String query="select count(*) from book,headbook,category,language,publishcompany,author,detailauthor where nameAuthor=\"" + author + "\""
		+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
		+ " and headbook.PublishCompany=publishcompany.IDPubCompany and author.IDAuthor=detailauthor.IDAuthor and headbook.IDHeadBook=detailauthor.IDHeadBook";
		ResultSet rs = sql.excutiveQuery(query);
		
		int size = 0;
		
		try {
			rs.next();
			size = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String [][] data = new String[size][7];
		int i = 0;
		
		query="select book.IDBook,NameBook,nameCategory,NameLanguage,NamePubCompany,book.status,book.IDHeadBook from book,headbook,category,language,publishcompany,author,detailauthor where nameAuthor=\"" + author + "\""
				+ " and headbook.IDHeadBook=book.IDHeadBook and headbook.IDCategory=category.IDCategory and headbook.IDLanguage=language.IDLanguage"
				+ " and headbook.PublishCompany=publishcompany.IDPubCompany and author.IDAuthor=detailauthor.IDAuthor and headbook.IDHeadBook=detailauthor.IDHeadBook";
		rs = sql.excutiveQuery(query);
		
		try {
			while(rs.next()) {
				DAOHeadBook daohb = new DAOHeadBook();
				data[i][0] = Integer.toString(rs.getInt(1));
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = daohb.findAuthorHeadBook(rs.getInt(7));
				if(rs.getInt(6) == 1) {
					data[i][6] = "Already Borrow";
				}else data[i][6] = "No Already Borrow";
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		
	}
}