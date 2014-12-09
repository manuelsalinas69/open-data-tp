package py.com.pol.sas.opendata.dto;

public class SetDto {

	String label;
	Long size;
	public SetDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SetDto(String label, Long size) {
		this.label = label;
		this.size = size;
	}



	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	
	
}
