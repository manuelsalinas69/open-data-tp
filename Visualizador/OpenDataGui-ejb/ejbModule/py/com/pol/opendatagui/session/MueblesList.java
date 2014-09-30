package py.com.pol.opendatagui.session;

import py.com.pol.opendatagui.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("mueblesList")
public class MueblesList extends EntityQuery<Muebles> {

	private static final String EJBQL = "select muebles from Muebles muebles";

	private static final String[] RESTRICTIONS = {
			"lower(muebles.id.unidadJerarquica) like lower(concat(#{mueblesList.muebles.id.unidadJerarquica},'%'))",
			"lower(muebles.id.codigoReparticion) like lower(concat(#{mueblesList.muebles.id.codigoReparticion},'%'))",
			"lower(muebles.id.nombreReparticion) like lower(concat(#{mueblesList.muebles.id.nombreReparticion},'%'))",
			"lower(muebles.id.codigoDependencia) like lower(concat(#{mueblesList.muebles.id.codigoDependencia},'%'))",
			"lower(muebles.id.nombreDependencia) like lower(concat(#{mueblesList.muebles.id.nombreDependencia},'%'))",
			"lower(muebles.id.area) like lower(concat(#{mueblesList.muebles.id.area},'%'))",
			"lower(muebles.id.cuenta) like lower(concat(#{mueblesList.muebles.id.cuenta},'%'))",
			"lower(muebles.id.subcuenta) like lower(concat(#{mueblesList.muebles.id.subcuenta},'%'))",
			"lower(muebles.id.especificacion) like lower(concat(#{mueblesList.muebles.id.especificacion},'%'))",
			"lower(muebles.id.descripcion) like lower(concat(#{mueblesList.muebles.id.descripcion},'%'))",
			"lower(muebles.id.fechaAdquisicion) like lower(concat(#{mueblesList.muebles.id.fechaAdquisicion},'%'))",
			"lower(muebles.id.rotulado) like lower(concat(#{mueblesList.muebles.id.rotulado},'%'))",
			"lower(muebles.id.estadoConservacion) like lower(concat(#{mueblesList.muebles.id.estadoConservacion},'%'))",
			"lower(muebles.id.diferencia) like lower(concat(#{mueblesList.muebles.id.diferencia},'%'))",
			"lower(muebles.id.barras) like lower(concat(#{mueblesList.muebles.id.barras},'%'))",
			"lower(muebles.id.departamento) like lower(concat(#{mueblesList.muebles.id.departamento},'%'))", };

	private Muebles muebles;

	public MueblesList() {
		muebles = new Muebles();
		muebles.setId(new MueblesId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Muebles getMuebles() {
		return muebles;
	}
}
