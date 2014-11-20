package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("departamentoList")
public class DepartamentoList extends EntityQuery<Departamento> {

	private static final String EJBQL = "select departamento from Departamento departamento";

	private static final String[] RESTRICTIONS = { "lower(departamento.departamento) like lower(concat(#{departamentoList.departamento.departamento},'%'))", };

	private Departamento departamento = new Departamento();

	public DepartamentoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Departamento getDepartamento() {
		return departamento;
	}
}
