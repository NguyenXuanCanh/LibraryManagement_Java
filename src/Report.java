import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.lowagie.text.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Report{
	public void report(ArrayList<DTOBillLent> bl) {
		InputStream ar = Report.class.getResourceAsStream("C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\formPrint\\BillLent.jrxml");
		JasperReport rp = null;
		String link = "C:\\Users\\Acer\\Documents\\NetBeansProjects\\libraryManagement\\src\\formPrint\\BillLent.jrxml";
			try {
				rp = JasperCompileManager.compileReport(ar);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		JasperPrint print = null;
		try {
			print = JasperFillManager.fillReport(rp, null,new JRBeanCollectionDataSource(bl));
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JasperViewer.viewReport(print);
	}
}