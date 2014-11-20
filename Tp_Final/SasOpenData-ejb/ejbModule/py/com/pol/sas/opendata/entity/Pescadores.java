package py.com.pol.sas.opendata.entity;

// Generated Oct 31, 2014 7:15:20 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pescadores generated by hbm2java
 */
@Entity
@Table(name = "pescadores", schema = "public")
public class Pescadores implements java.io.Serializable {

	private int id;
	private String nroCedula;
	private Integer registro;
	private String nombre;
	private String apellido;
	private String asociacion;
	private Double importeSubsidio;

	public Pescadores() {
	}

	public Pescadores(int id) {
		this.id = id;
	}

	public Pescadores(int id, String nroCedula, Integer registro,
			String nombre, String apellido, String asociacion,
			Double importeSubsidio) {
		this.id = id;
		this.nroCedula = nroCedula;
		this.registro = registro;
		this.nombre = nombre;
		this.apellido = apellido;
		this.asociacion = asociacion;
		this.importeSubsidio = importeSubsidio;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nro_cedula")
	public String getNroCedula() {
		return this.nroCedula;
	}

	public void setNroCedula(String nroCedula) {
		this.nroCedula = nroCedula;
	}

	@Column(name = "registro")
	public Integer getRegistro() {
		return this.registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido")
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "asociacion")
	public String getAsociacion() {
		return this.asociacion;
	}

	public void setAsociacion(String asociacion) {
		this.asociacion = asociacion;
	}

	@Column(name = "importe_subsidio", precision = 17, scale = 17)
	public Double getImporteSubsidio() {
		return this.importeSubsidio;
	}

	public void setImporteSubsidio(Double importeSubsidio) {
		this.importeSubsidio = importeSubsidio;
	}

}
