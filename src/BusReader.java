public class BusReader{
	protected DaoReader dao = new DaoReader();
	
	public String[][] loadAllReader(){
		return dao.loadAllReader();
	}
	
	public boolean checkMS(String ID, String type) {
		boolean data = dao.checkMS(ID, type);
		return data;
	}
	
	public String[] loadData(String ID, String type) { 
		return dao.loadData(ID, type);
	}
	
	public void add(String ms,String name,String depart,String birth,String sex,String type,String dateCreate) {
		dao.add(ms, name, depart, birth, sex, type, dateCreate);
	}
	
	public boolean checkLoopID(String ID) {
		boolean data = dao.checkLoopID(ID);
		return data;
	}
	
	public void update(String ID,String name,String depart,String birthday, String sex,String type) {
		dao.update(ID, name, depart, birthday, sex, type);
	}
	
	public void clear(String ID) {
		dao.clear(ID);
	}
	
	public String[][] findMs(String ID){
		return dao.findMS(ID);
	}
}