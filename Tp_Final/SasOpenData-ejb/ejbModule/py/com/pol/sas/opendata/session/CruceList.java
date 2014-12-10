package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cruceList")
public class CruceList extends EntityQuery<Cruce> {

	private static final String EJBQL = "select cruce from Cruce cruce";

	private static final String[] RESTRICTIONS = {
			"lower(cruce.nroCedula) like lower(concat(#{cruceList.cruce.nroCedula},'%'))",
			"lower(cruce.nombreCompleto) like lower(concat('%',#{cruceList.cruce.nombreCompleto},'%'))",
			"lower(cruce.distrito) like lower(concat('%',#{cruceList.cruce.distrito},'%'))",
			"lower(cruce.tekopora) = lower(#{cruceList.tkp})",
			"lower(cruce.tekoha) =lower(#{cruceList.tkh})",
			"lower(cruce.pescador) =lower(#{cruceList.psc})",
			"lower(cruce.esTitular) = lower(#{cruceList.tit})",
			"lower(cruce.esConyuge)=lower(#{cruceList.cony})",
			"cruce.departamento.idDepartamento=#{cruceList.idDepartamento}",
			"lower(cruce.nroCedulaTitular) like lower(concat(#{cruceList.cruce.nroCedulaTitular},'%'))",
			"lower(cruce.nroCedulaConyuge) like lower(concat(#{cruceList.cruce.nroCedulaConyuge},'%'))",
			"lower(cruce.asociacionPescador) like lower(concat('%',#{cruceList.cruce.asociacionPescador},'%'))", };

	private Cruce cruce = new Cruce();
	
	private Boolean esTitular;
	private Boolean esConyuge;
	private Boolean tekoha;
	private Boolean tekopora;
	private Boolean pescador;
	private Long idDepartamento;

	public CruceList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public String getTkh(){
		if (getTekoha()!=null && getTekoha()) {
			return "SI";
		}
		return null;
	}
	
	public String getTkp(){
		if (getTekopora()!=null && getTekopora()) {
			return "SI";
		}
		return null;
	}
	public String getPsc(){
		if (getPescador()!=null && getPescador()) {
			return "SI";
		}
		return null;
	}
	public String getTit(){
		if (getEsTitular()!=null && getEsTitular()) {
			return "SI";
		}
		return null;
	}
	public String getCony(){
		if (getEsConyuge()!=null && getEsConyuge()) {
			return "SI";
		}
		return null;
	}
	
	
	public Cruce getCruce() {
		return cruce;
	}

	public Boolean getEsTitular() {
		return esTitular;
	}

	public void setEsTitular(Boolean esTitular) {
		this.esTitular = esTitular;
	}

	public Boolean getEsConyuge() {
		return esConyuge;
	}

	public void setEsConyuge(Boolean esConyuge) {
		this.esConyuge = esConyuge;
	}

	public Boolean getTekoha() {
		return tekoha;
	}

	public void setTekoha(Boolean tekoha) {
		this.tekoha = tekoha;
	}

	public Boolean getTekopora() {
		return tekopora;
	}

	public void setTekopora(Boolean tekopora) {
		this.tekopora = tekopora;
	}

	public Boolean getPescador() {
		return pescador;
	}

	public void setPescador(Boolean pescador) {
		this.pescador = pescador;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
}
