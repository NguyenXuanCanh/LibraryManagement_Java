public class BusAuthor{
	DAOAuthor dao = new DAOAuthor();
	
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
	
	public boolean checkDate(String date) {
		String[] arrayDate = date.split("-");
		int year,month,day;
		try {
			year = Integer.parseInt(arrayDate[0]);
			month = Integer.parseInt(arrayDate[1]);
			day = Integer.parseInt(arrayDate[2]);
		}catch(Exception e) {
			return false;
		}
		
		if(year<=0) {
			return false;
		}
		
		if(month<=0 || month>12) return false;
		
		if(day<=0 || day>31) return false;
		
		return true;
	}
	
	public void insert(String name,String birthday,String address) {
		dao.insert(name,birthday,address);
	}
	
	public String[][] takeData(){
		return dao.takeData();
	}
	
	public void clear(String ID) {
		dao.clear(ID);
	}
	
	public void update(String ID, String name,String birthday,String address) {
		dao.update(ID, name,birthday,address);
	}
	
}