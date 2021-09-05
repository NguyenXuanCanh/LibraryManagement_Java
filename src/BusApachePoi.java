public class BusApachePoi{
	protected DaoApachePoin dao = new DaoApachePoin();
	public int ImportHeadBook(DTOHeadBook[] listHeadBook) {
		return dao.ImportHeadBook(listHeadBook);
	}
}