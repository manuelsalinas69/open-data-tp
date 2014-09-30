package py.com.pol.opendatagui.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.international.StatusMessages;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@Name("csvImporterManager")
@Scope(ScopeType.PAGE)
public class CsvImporterManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@In EntityManager entityManager;
	@In StatusMessages statusMessages;
	
	
	byte[] data;
	String fileName;
	
	String tempDir="g:/Facultad/dirToProcess/";
	
	@Create
	public void init(){
		
	}
	
	public void fileUploadListener(FileUploadEvent event){
		UploadedFile file= event.getUploadedFile();
		data=file.getData();
		fileName=file.getName();
		
		try {
			File f=new File(tempDir+fileName);
			if (f.exists()) {
				f.delete();
			}
			
			if(f.createNewFile()){
				FileOutputStream fos=new FileOutputStream(f);
				fos.write(data);
				fos.close();
			}
			else{
				System.out.println("No se pudo crear el archivo--> "+fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void processFile(){
		String sql="COPY muebles FROM '"+tempDir+fileName+"' DELIMITER ',' CSV";
		
		Query q=entityManager.createNativeQuery(sql);
		
		//q.setParameter("path", tempDir+fileName);
		int update= q.executeUpdate();
		System.out.println("Execute result--> "+update);
		//statusMessages.add(Severity.INFO,"Pedido de suscripcion enviando a la plataforma con exito, para ver los resultados del pedido verifique los registros de suscripciones en /Consultas/Registros de Suscripciones");
	}

	
	/*
	 * GETTERS && SETTERS
	 * 
	 * */
	
	
	
	

	public boolean isFileDefined(){
		return data!=null && data.length>=0 && fileName!=null && !fileName.trim().isEmpty();
	}
	

}
