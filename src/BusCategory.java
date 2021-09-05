public class BusCategory{
	DAOCategory dao = new DAOCategory();
	
	public boolean processValueInputAdd(String input){
		if(input.equals("") == true) return false;
		else return true;
	}
	
	public boolean processValueInputClear(String input){
		
		if(input.equals("") == true) return false;
		
		try {
			Integer.parseInt(input);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String[][] takeData(){
		return dao.takeData();
	}
	
	public void insert(String name) {
		dao.insert(name);
	}
	
	public void clear(String ID) {
		dao.clear(ID);
	}
	
	public void update(String ID, String name) {
		dao.update(ID, name);
	}
}