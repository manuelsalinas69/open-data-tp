package py.com.pol.sas.opendata.session;

import py.com.pol.sas.opendata.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tekohaHome")
public class TekohaHome extends EntityHome<Tekoha> {

	public void setTekohaId(Integer id) {
		setId(id);
	}

	public Integer getTekohaId() {
		return (Integer) getId();
	}

	@Override
	protected Tekoha createInstance() {
		Tekoha tekoha = new Tekoha();
		return tekoha;
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

	public Tekoha getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
