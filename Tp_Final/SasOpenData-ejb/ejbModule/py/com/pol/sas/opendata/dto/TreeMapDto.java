package py.com.pol.sas.opendata.dto;

import java.io.Serializable;

public class TreeMapDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;
	String size;
	Long value;
	public TreeMapDto() {
		
	}
	
	
	
	public TreeMapDto(String name, String size) {
		this.name = name;
		this.size = size;
	}

	


	public TreeMapDto(String name, Long value) {
		this.name = name;
		this.value = value;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}



	public Long getValue() {
		return value;
	}



	public void setValue(Long value) {
		this.value = value;
	}
	
	
}
