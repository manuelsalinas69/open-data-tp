package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("pescadoresList")
public class PescadoresList extends EntityQuery<Pescadores> {

	private static final String EJBQL = "select pescadores from Pescadores pescadores";

	private static final String[] RESTRICTIONS = {
			"lower(pescadores.nroCedula) like lower(concat(#{pescadoresList.pescadores.nroCedula},'%'))",
			"lower(pescadores.nombre) like lower(concat(#{pescadoresList.pescadores.nombre},'%'))",
			"lower(pescadores.apellido) like lower(concat(#{pescadoresList.pescadores.apellido},'%'))",
			"lower(pescadores.asociacion) like lower(concat(#{pescadoresList.pescadores.asociacion},'%'))", };

	private Pescadores pescadores = new Pescadores();

	public PescadoresList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Pescadores getPescadores() {
		return pescadores;
	}
}
