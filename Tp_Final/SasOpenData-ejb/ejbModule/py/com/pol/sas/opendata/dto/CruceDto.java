package py.com.pol.sas.opendata.dto;

public class CruceDto {
	String numeroCedula;
	String nombre;
	Boolean pescador;
	Boolean tekoha;
	Boolean tekopora;
	public CruceDto() {
		
	}
	
	
	
	public CruceDto(String numeroCedula, String nombre) {
		this.numeroCedula = numeroCedula;
		this.nombre = nombre;
	}



	public String getNumeroCedula() {
		return numeroCedula;
	}
	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
