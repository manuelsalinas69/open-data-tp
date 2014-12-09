package py.com.pol.sas.opendata.dto;

public class VennDto {

	SetDto[] sets;
	OverlapsDto[] overlaps;
	public VennDto() {
		
	}
	
	public SetDto[] getSets() {
		return sets;
	}
	public void setSets(SetDto[] sets) {
		this.sets = sets;
	}

	public OverlapsDto[] getOverlaps() {
		return overlaps;
	}

	public void setOverlaps(OverlapsDto[] overlaps) {
		this.overlaps = overlaps;
	}
	
	
}
