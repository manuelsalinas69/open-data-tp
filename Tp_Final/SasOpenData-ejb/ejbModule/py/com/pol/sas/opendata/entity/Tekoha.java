package py.com.pol.sas.opendata.entity;

// Generated Oct 31, 2014 7:15:20 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tekoha generated by hbm2java
 */
@Entity
@Table(name = "tekoha", schema = "public")
public class Tekoha implements java.io.Serializable {

	private int id;
	private String nroCedulaTitular;
	private String nombreTitular;
	private String nroCedulaConyuge;
	private String nombreConyuge;
	private String departamento;
	private String distrito;
	private String territorioSocial;
	private String manzana;
	private Integer lote;

	public Tekoha() {
	}

	public Tekoha(int id) {
		this.id = id;
	}

	public Tekoha(int id, String nroCedulaTitular, String nombreTitular,
			String nroCedulaConyuge, String nombreConyuge, String departamento,
			String distrito, String territorioSocial, String manzana,
			Integer lote) {
		this.id = id;
		this.nroCedulaTitular = nroCedulaTitular;
		this.nombreTitular = nombreTitular;
		this.nroCedulaConyuge = nroCedulaConyuge;
		this.nombreConyuge = nombreConyuge;
		this.departamento = departamento;
		this.distrito = distrito;
		this.territorioSocial = territorioSocial;
		this.manzana = manzana;
		this.lote = lote;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nro_cedula_titular")
	public String getNroCedulaTitular() {
		return this.nroCedulaTitular;
	}

	public void setNroCedulaTitular(String nroCedulaTitular) {
		this.nroCedulaTitular = nroCedulaTitular;
	}

	@Column(name = "nombre_titular")
	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	@Column(name = "nro_cedula_conyuge")
	public String getNroCedulaConyuge() {
		return this.nroCedulaConyuge;
	}

	public void setNroCedulaConyuge(String nroCedulaConyuge) {
		this.nroCedulaConyuge = nroCedulaConyuge;
	}

	@Column(name = "nombre_conyuge")
	public String getNombreConyuge() {
		return this.nombreConyuge;
	}

	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}

	@Column(name = "departamento")
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Column(name = "distrito")
	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Column(name = "territorio_social")
	public String getTerritorioSocial() {
		return this.territorioSocial;
	}

	public void setTerritorioSocial(String territorioSocial) {
		this.territorioSocial = territorioSocial;
	}

	@Column(name = "manzana")
	public String getManzana() {
		return this.manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	@Column(name = "lote")
	public Integer getLote() {
		return this.lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

}
