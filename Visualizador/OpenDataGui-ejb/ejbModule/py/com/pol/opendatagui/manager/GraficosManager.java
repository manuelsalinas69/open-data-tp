package py.com.pol.opendatagui.manager;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("graficosManager")
@Scope(ScopeType.PAGE)
public class GraficosManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@In(create=true)
	EntityManager entityManager;
	

	List<Object[]> jsonData;
	
	String departamento;
	String estadoConservacion;
	
	@Create
	public void init(){
		 departamento="central";
		 estadoConservacion="bueno";
	}
	

	public void reportCantidadPorDepartamento(){
		jsonData=getCantidadPorDepartamento();
	}
	
	public void reportEstadoGeneral(){
		jsonData=getEstadoGeneral();
	}
	
	public void reportEstadoPorDepartamento(){
		jsonData=null;
		if (departamento==null || departamento.trim().isEmpty()) {
			return;
		}
		jsonData=getEstadoPorDepartamento(departamento);
		
	}
	
	public void reportEstadoPorDepartamentoEstado(){
		jsonData=null;
		if (estadoConservacion==null || estadoConservacion.trim().isEmpty()) {
			return;
		}
		jsonData=getEstadoSeleccionadoPorDepartamento(estadoConservacion);
	}
	
	public void reportMontosPorDepartamento(){
		jsonData=null;
		jsonData=getMontosPorDepartamento();
	}

	
	
	
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getMontosPorDepartamento() {
		String hql="SELECT m.id.departamento, sum((m.id.valorTotal)/1000000) FROM Muebles m GROUP BY m.id.departamento ORDER BY m.id.departamento";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	private List<Object[]> getEstadoSeleccionadoPorDepartamento(String estadoConservacion) {
		String hql="SELECT m.id.departamento, sum((m.id.valorTotal)/1000000) FROM Muebles m WHERE lower(m.id.estadoConservacion)=lower(:estadoConservacion) GROUP BY m.id.departamento ORDER BY m.id.departamento";
		Query q= entityManager.createQuery(hql);
		q.setParameter("estadoConservacion", estadoConservacion);
		return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	private List<Object[]> getCantidadPorDepartamento() {
		String hql="SELECT m.id.departamento, sum((m.id.valorTotal)/1000000) FROM Muebles m GROUP BY m.id.departamento ORDER BY m.id.departamento";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	private List<Object[]> getEstadoPorDepartamento(String departamento) {
		String sql="SELECT estado_conservacion, sum((valor_total)/1000000) FROM Muebles WHERE lower(departamento)=lower(:departamento) GROUP BY estado_conservacion ORDER BY estado_conservacion";
		Query q= entityManager.createNativeQuery(sql);
		q.setParameter("departamento", departamento);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getEstadoGeneral() {
		String sql="SELECT estado_conservacion, sum((valor_total)/1000000) FROM Muebles GROUP BY estado_conservacion ORDER BY estado_conservacion";
		Query q= entityManager.createNativeQuery(sql);
		return q.getResultList();
	}
	
	

	/*
	 * GETTERS && SETTERS
	 * **/
	
	public List<Object[]> getJsonData() {
		return jsonData;
	}

	public void setJsonData(List<Object[]> jsonData) {
		this.jsonData = jsonData;
	}

	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getEstadoConservacion() {
		return estadoConservacion;
	}


	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}
	
	

	
	
}
