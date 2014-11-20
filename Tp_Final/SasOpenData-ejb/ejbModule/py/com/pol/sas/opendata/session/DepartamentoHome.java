package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("departamentoHome")
public class DepartamentoHome extends EntityHome<Departamento> {

	public void setDepartamentoDepartamento(String id) {
		setId(id);
	}

	public String getDepartamentoDepartamento() {
		return (String) getId();
	}

	@Override
	protected Departamento createInstance() {
		Departamento departamento = new Departamento();
		return departamento;
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

	public Departamento getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
