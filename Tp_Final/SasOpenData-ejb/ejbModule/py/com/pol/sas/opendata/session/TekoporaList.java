package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tekoporaList")
public class TekoporaList extends EntityQuery<Tekopora> {

	private static final String EJBQL = "select tekopora from Tekopora tekopora";

	private static final String[] RESTRICTIONS = {
			"lower(tekopora.nroCedula) like lower(concat(#{tekoporaList.tekopora.nroCedula},'%'))",
			"lower(tekopora.nombre) like lower(concat(#{tekoporaList.tekopora.nombre},'%'))",
			"tekopora.departamento.idDepartamento=#{tekoporaList.idDepartamento}",
			"lower(tekopora.distrito) like lower(concat(#{tekoporaList.tekopora.distrito},'%'))", };

	private Tekopora tekopora = new Tekopora();
	
	private Long idDepartamento;

	public TekoporaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tekopora getTekopora() {
		return tekopora;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
}
