package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tekoporaHome")
public class TekoporaHome extends EntityHome<Tekopora> {

	public void setTekoporaId(Integer id) {
		setId(id);
	}

	public Integer getTekoporaId() {
		return (Integer) getId();
	}

	@Override
	protected Tekopora createInstance() {
		Tekopora tekopora = new Tekopora();
		return tekopora;
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

	public Tekopora getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
