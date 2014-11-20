package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tekohaList")
public class TekohaList extends EntityQuery<Tekoha> {

	private static final String EJBQL = "select tekoha from Tekoha tekoha";

	private static final String[] RESTRICTIONS = {
			"lower(tekoha.nroCedulaTitular) like lower(concat(#{tekohaList.tekoha.nroCedulaTitular},'%'))",
			"lower(tekoha.nombreTitular) like lower(concat(#{tekohaList.tekoha.nombreTitular},'%'))",
			"lower(tekoha.nroCedulaConyuge) like lower(concat(#{tekohaList.tekoha.nroCedulaConyuge},'%'))",
			"lower(tekoha.nombreConyuge) like lower(concat(#{tekohaList.tekoha.nombreConyuge},'%'))",
			"lower(tekoha.departamento) like lower(concat(#{tekohaList.tekoha.departamento},'%'))",
			"lower(tekoha.distrito) like lower(concat(#{tekohaList.tekoha.distrito},'%'))",
			"lower(tekoha.territorioSocial) like lower(concat(#{tekohaList.tekoha.territorioSocial},'%'))",
			"lower(tekoha.manzana) like lower(concat(#{tekohaList.tekoha.manzana},'%'))", };

	private Tekoha tekoha = new Tekoha();

	public TekohaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tekoha getTekoha() {
		return tekoha;
	}
}
