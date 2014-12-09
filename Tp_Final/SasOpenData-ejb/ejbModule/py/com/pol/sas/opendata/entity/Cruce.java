package py.com.pol.sas.opendata.entity;

// Generated Dec 8, 2014 1:39:34 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Cruce generated by hbm2java
 */
@Entity
@Table(name = "cruce", schema = "public")
public class Cruce implements java.io.Serializable {

	private String nroCedula;
	private Departamento departamento;
	private String nombreCompleto;
	private String distrito;
	private String tekopora;
	private String tekoha;
	private String pescador;
	private String esTitular;
	private String esConyuge;
	private String nroCedulaTitular;
	private String nroCedulaConyuge;
	private Double importeMensualTekopra;
	private Double importSubsidioPescadores;
	private String asociacionPescador;

	public Cruce() {
	}

	public Cruce(String nroCedula, String nombreCompleto) {
		this.nroCedula = nroCedula;
		this.nombreCompleto = nombreCompleto;
	}

	public Cruce(String nroCedula, Departamento departamento,
			String nombreCompleto, String distrito, String tekopora,
			String tekoha, String pescador, String esTitular, String esConyuge,
			String nroCedulaTitular, String nroCedulaConyuge,
			Double importeMensualTekopra, Double importSubsidioPescadores,
			String asociacionPescador) {
		this.nroCedula = nroCedula;
		this.departamento = departamento;
		this.nombreCompleto = nombreCompleto;
		this.distrito = distrito;
		this.tekopora = tekopora;
		this.tekoha = tekoha;
		this.pescador = pescador;
		this.esTitular = esTitular;
		this.esConyuge = esConyuge;
		this.nroCedulaTitular = nroCedulaTitular;
		this.nroCedulaConyuge = nroCedulaConyuge;
		this.importeMensualTekopra = importeMensualTekopra;
		this.importSubsidioPescadores = importSubsidioPescadores;
		this.asociacionPescador = asociacionPescador;
	}

	@Id
	@Column(name = "nro_cedula", unique = true, nullable = false, length = 50)
	@NotNull
	@Size(max = 50)
	public String getNroCedula() {
		return this.nroCedula;
	}

	public void setNroCedula(String nroCedula) {
		this.nroCedula = nroCedula;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Column(name = "nombre_completo", nullable = false, length = 200)
	@NotNull
	@Size(max = 200)
	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Column(name = "distrito", length = 200)
	@Size(max = 200)
	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Column(name = "tekopora", length = 20)
	@Size(max = 20)
	public String getTekopora() {
		return this.tekopora;
	}

	public void setTekopora(String tekopora) {
		this.tekopora = tekopora;
	}

	@Column(name = "tekoha", length = 20)
	@Size(max = 20)
	public String getTekoha() {
		return this.tekoha;
	}

	public void setTekoha(String tekoha) {
		this.tekoha = tekoha;
	}

	@Column(name = "pescador", length = 20)
	@Size(max = 20)
	public String getPescador() {
		return this.pescador;
	}

	public void setPescador(String pescador) {
		this.pescador = pescador;
	}

	@Column(name = "es_titular", length = 20)
	@Size(max = 20)
	public String getEsTitular() {
		return this.esTitular;
	}

	public void setEsTitular(String esTitular) {
		this.esTitular = esTitular;
	}

	@Column(name = "es_conyuge", length = 20)
	@Size(max = 20)
	public String getEsConyuge() {
		return this.esConyuge;
	}

	public void setEsConyuge(String esConyuge) {
		this.esConyuge = esConyuge;
	}

	@Column(name = "nro_cedula_titular", length = 50)
	@Size(max = 50)
	public String getNroCedulaTitular() {
		return this.nroCedulaTitular;
	}

	public void setNroCedulaTitular(String nroCedulaTitular) {
		this.nroCedulaTitular = nroCedulaTitular;
	}

	@Column(name = "nro_cedula_conyuge", length = 50)
	@Size(max = 50)
	public String getNroCedulaConyuge() {
		return this.nroCedulaConyuge;
	}

	public void setNroCedulaConyuge(String nroCedulaConyuge) {
		this.nroCedulaConyuge = nroCedulaConyuge;
	}

	@Column(name = "importe_mensual_tekopra", precision = 17, scale = 17)
	public Double getImporteMensualTekopra() {
		return this.importeMensualTekopra;
	}

	public void setImporteMensualTekopra(Double importeMensualTekopra) {
		this.importeMensualTekopra = importeMensualTekopra;
	}

	@Column(name = "import_subsidio_pescadores", precision = 17, scale = 17)
	public Double getImportSubsidioPescadores() {
		return this.importSubsidioPescadores;
	}

	public void setImportSubsidioPescadores(Double importSubsidioPescadores) {
		this.importSubsidioPescadores = importSubsidioPescadores;
	}

	@Column(name = "asociacion_pescador", length = 500)
	@Size(max = 500)
	public String getAsociacionPescador() {
		return this.asociacionPescador;
	}

	public void setAsociacionPescador(String asociacionPescador) {
		this.asociacionPescador = asociacionPescador;
	}

}
