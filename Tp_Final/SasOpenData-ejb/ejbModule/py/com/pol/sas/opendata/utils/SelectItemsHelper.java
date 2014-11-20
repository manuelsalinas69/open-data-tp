package py.com.pol.sas.opendata.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("selectItemsHelper")
@Scope(ScopeType.PAGE)
public class SelectItemsHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@In(create=true)
	EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Factory(value="departamentoSelectItems",scope=ScopeType.PAGE,autoCreate=true)
	public List<SelectItem> departamentoSelectItems(){
		String hql="SELECT distinct(lower(tkh.departamento)) FROM Tekoha tkh  ORDER BY lower(tkh.departamento) ";
		List<SelectItem> selectItems= new ArrayList<SelectItem>();
		//selectItems.add(new SelectItem(null, "Seleccione..."));
		Query q=entityManager.createQuery(hql);
		List<String> l= q.getResultList();

		for (String dep : l) {
			selectItems.add(new SelectItem(dep, dep));
			
		}
		return selectItems;
	}
	
	@SuppressWarnings("unchecked")
	@Factory(value="departamento_1SelectItems",scope=ScopeType.PAGE,autoCreate=true)
	public List<SelectItem> departamento_1SelectItems(){
		String hql="SELECT distinct(lower(tkh.departamento)) FROM Tekopora tkh  ORDER BY lower(tkh.departamento) ";
		List<SelectItem> selectItems= new ArrayList<SelectItem>();
		//selectItems.add(new SelectItem(null, "Seleccione..."));
		Query q=entityManager.createQuery(hql);
		List<String> l= q.getResultList();

		for (String dep : l) {
			selectItems.add(new SelectItem(dep, dep));
			
		}
		return selectItems;
	}
	
	
}
