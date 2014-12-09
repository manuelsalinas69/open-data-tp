package py.com.pol.sas.opendata.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import py.com.pol.sas.opendata.entity.Parametros;

@Name("exportManager")
@Scope(ScopeType.PAGE)
public class ExportManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@In(create=true)
	EntityManager entityManager;
	String TKH_FILE="tekoha";
	String TKP_FILE="tekopora";
	String PSC_FILE="pescadores";
	String CRUCE_FILE="cruce";
	String baseDir;
	String baseDirParam="system.reports.baseDir";
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
	
	@Create
	public void init(){
		baseDir=getBaseDirParam();
	}
	
	
	public void exportTkh(){
		String fileName=createFileName(TKH_FILE);
		String filePath=copy("Tekoha", createFilePath(fileName));
		if (filePath==null) {
			System.out.println("No se pudo crear el archivo CSV");
			return;
		}
		downloadCSV(fileName,filePath);
	}
	
	

	public void exportTkp(){
		String fileName=createFileName(TKP_FILE);
		String filePath=copy("Tekopora", createFilePath(fileName));
		if (filePath==null) {
			System.out.println("No se pudo crear el archivo CSV");
			return;
		}
		downloadCSV(fileName,filePath);
	}

	public void exportPsc(){
		String fileName=createFileName(PSC_FILE);
		String filePath=copy("Pescadores", createFilePath(fileName));
		if (filePath==null) {
			System.out.println("No se pudo crear el archivo CSV");
			return;
		}
		downloadCSV(fileName,filePath);
	}
	
	public void exportCruce(){
		String fileName=createFileName(CRUCE_FILE);
		String filePath=copy("Cruce", createFilePath(fileName));
		if (filePath==null) {
			System.out.println("No se pudo crear el archivo CSV");
			return;
		}
		downloadCSV(fileName,filePath);
	}
	
	private void downloadCSV(String fileName,String filePath) {
		try {
			File f= new File(filePath);
			FileInputStream fis=new FileInputStream(f);
			byte[] data= new byte[(int) f.length()];
			fis.read(data);
			fis.close();
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setHeader("Content-disposition", "attachment" + "; filename=\"" + fileName);
			response.setContentType("text/csv");
			OutputStream out;
			byte[] content =data;
			response.setContentLength(content.length);
			out = response.getOutputStream();
			out.write(content);
			out.flush();
			out.close();
			f.delete();

			FacesContext.getCurrentInstance().responseComplete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private String createFileName(String baseFileName){
		return baseFileName+"_"+sdf.format(new Date())+".csv";
	}
	
	private String createFilePath(String fileName) {
		return baseDir+fileName;
	}

	private String getBaseDirParam(){
		
		Parametros p= entityManager.find(Parametros.class,baseDirParam);
		return p.getValue();
	}
	
	private String copy(String table, String filePath){
		try {
			String sql="COPY <table> TO '<filePath>' WITH CSV HEADER";
			sql=sql.replace("<filePath>", filePath);
			sql=sql.replace("<table>", table);
			Query q= entityManager.createNativeQuery(sql);
			int r=q.executeUpdate();
			System.out.println("Execute result--> "+r);
			return filePath;
		} catch (Exception e) {
			System.out.println("ExportManager.copy(): "+e);
			e.printStackTrace();
		}
		return null;
	}
	
}
