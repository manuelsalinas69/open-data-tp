package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pescadoresHome")
public class PescadoresHome extends EntityHome<Pescadores> {

	public void setPescadoresId(Integer id) {
		setId(id);
	}

	public Integer getPescadoresId() {
		return (Integer) getId();
	}

	@Override
	protected Pescadores createInstance() {
		Pescadores pescadores = new Pescadores();
		return pescadores;
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

	public Pescadores getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
