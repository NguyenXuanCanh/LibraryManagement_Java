public class BusGuiFind{
	protected DaoFind dao = new DaoFind();
	public String[] takeListCategory(){
		BusHeadBook busHB = new BusHeadBook();
		DTOCategory[] listCategory = busHB.loadCategory();
		String[] contentCbb = new String[listCategory.length];
		for(int i = 0;i<listCategory.length;++i) {
			contentCbb[i] = listCategory[i].nameCategory;
		}
		return contentCbb;
	}
	
	public String[] takeListAuthor() {
		BusHeadBook busHB = new BusHeadBook();
		String[][] listAuthor = busHB.loadAuthor();
		String[] contentCbb = new String[listAuthor.length];
		for(int i = 0;i<contentCbb.length;++i) {
			contentCbb[i] = listAuthor[i][1];
		}
		return contentCbb;
	}
	
	public String[][] findNameBook(String name){
		return dao.findNameBook(name);
	}
	
	public String[][] loadAllBook(){
		return dao.loadAllBook();
	}
	
	public int findIDCategory(String category) {
		BusHeadBook busHB = new BusHeadBook();
		DTOCategory[] listCategory = busHB.loadCategory();
		for(int i = 0;i<listCategory.length;++i) {
			if(listCategory[i].nameCategory.equals(category) == true) {
				return listCategory[i].IDCategory;
			}
		}
		return -1;
	}
	
	public String[][] loadBookFollowCategory(int IDCategory){
		return dao.loadBookFollowCategory(IDCategory);
	}
	
	public String[][] loadBookFollowAuthor(String author){
		return dao.loadBookFollowAuthor(author);
	}
}