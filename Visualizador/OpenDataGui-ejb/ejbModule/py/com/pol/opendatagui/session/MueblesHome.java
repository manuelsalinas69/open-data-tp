package py.com.pol.opendatagui.session;

import py.com.pol.opendatagui.entity.*;
import java.math.BigDecimal;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("mueblesHome")
public class MueblesHome extends EntityHome<Muebles> {

	public void setMueblesId(MueblesId id) {
		setId(id);
	}

	public MueblesId getMueblesId() {
		return (MueblesId) getId();
	}

	public MueblesHome() {
		setMueblesId(new MueblesId());
	}

	@Override
	public boolean isIdDefined() {
		if (getMueblesId().getUnidadJerarquica() == null
				|| "".equals(getMueblesId().getUnidadJerarquica()))
			return false;
		if (getMueblesId().getCodigoReparticion() == null
				|| "".equals(getMueblesId().getCodigoReparticion()))
			return false;
		if (getMueblesId().getNombreReparticion() == null
				|| "".equals(getMueblesId().getNombreReparticion()))
			return false;
		if (getMueblesId().getCodigoDependencia() == null
				|| "".equals(getMueblesId().getCodigoDependencia()))
			return false;
		if (getMueblesId().getNombreDependencia() == null
				|| "".equals(getMueblesId().getNombreDependencia()))
			return false;
		if (getMueblesId().getArea() == null
				|| "".equals(getMueblesId().getArea()))
			return false;
		if (getMueblesId().getCuenta() == null
				|| "".equals(getMueblesId().getCuenta()))
			return false;
		if (getMueblesId().getSubcuenta() == null
				|| "".equals(getMueblesId().getSubcuenta()))
			return false;
		if (getMueblesId().getEspecificacion() == null
				|| "".equals(getMueblesId().getEspecificacion()))
			return false;
		if (getMueblesId().getDescripcion() == null
				|| "".equals(getMueblesId().getDescripcion()))
			return false;
		if (getMueblesId().getFechaAdquisicion() == null
				|| "".equals(getMueblesId().getFechaAdquisicion()))
			return false;
		if (getMueblesId().getRotulado() == null
				|| "".equals(getMueblesId().getRotulado()))
			return false;
		if (getMueblesId().getCantidad() == null)
			return false;
		if (getMueblesId().getValorUnitario() == null)
			return false;
		if (getMueblesId().getValorTotal() == null)
			return false;
		if (getMueblesId().getEstadoConservacion() == null
				|| "".equals(getMueblesId().getEstadoConservacion()))
			return false;
		if (getMueblesId().getDiferencia() == null
				|| "".equals(getMueblesId().getDiferencia()))
			return false;
		if (getMueblesId().getBarras() == null
				|| "".equals(getMueblesId().getBarras()))
			return false;
		if (getMueblesId().getDepartamento() == null
				|| "".equals(getMueblesId().getDepartamento()))
			return false;
		return true;
	}

	@Override
	protected Muebles createInstance() {
		Muebles muebles = new Muebles();
		muebles.setId(new MueblesId());
		return muebles;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Muebles getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
