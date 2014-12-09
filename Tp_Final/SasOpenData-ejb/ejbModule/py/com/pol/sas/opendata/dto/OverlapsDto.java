package py.com.pol.sas.opendata.dto;

public class OverlapsDto {

	Integer[] sets;
	Integer size;
	public OverlapsDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OverlapsDto(Integer[] sets, Integer size) {
		this.sets = sets;
		this.size = size;
	}
	
	public Integer[] getSets() {
		return sets;
	}




	public void setSets(Integer[] sets) {
		this.sets = sets;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
}
