package py.com.pol.sas.opendata.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import py.com.pol.sas.opendata.dto.TreeMapDto;

@Name("estadisticasManager")
@Scope(ScopeType.PAGE)
public class EstadisticasManager implements Serializable{

	/*
	 * tekoha -> tkh
	 * tekopora -> tkp
	 * pescadores -> psc
	 * 
	 * */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@In EntityManager entityManager;
	
	private List<Object[]> data;
	private List<TreeMapDto> treeMapData;
	private TreeMapDto[] treeMapDataArray;
	private Long departamento;
	private Long departamento_1;
	

	@Create
	public void init(){
		treeMapData=new ArrayList<TreeMapDto>();
		departamento=11L;//Central
		departamento_1=11L;//Central
	}
	
	
	public void tkh_terrenosPorDepartamento(){
		data=null;
		data=getTerrenosPorDpto();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			treeMapDataArray[i]=new TreeMapDto((String)_d[0],(Long) _d[1]);
			i++;
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getTerrenosPorDpto() {
		String hql="SELECT tkh.departamento.departamento, count(*) FROM Tekoha tkh GROUP BY tkh.departamento.departamento ORDER BY tkh.departamento.departamento";
		Query q=entityManager.createQuery(hql);
		return q.getResultList();
	}


	public void tkh_terrenosPorDistrito(){
		data=null;
		if (departamento==null) {
			return;
		}
		data=getTerrenosPorDistrito(departamento);
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			treeMapDataArray[i]=new TreeMapDto((String)_d[0],(Long) _d[1]);
			i++;
		}
	}
	@SuppressWarnings("unchecked")
	private List<Object[]> getTerrenosPorDistrito(Long depto) {
		String hql="SELECT tkh.distrito,count(*) FROM Tekoha tkh WHERE tkh.departamento.idDepartamento=:depto GROUP BY tkh.distrito ORDER BY tkh.distrito";
		Query q=entityManager.createQuery(hql);
		q.setParameter("depto", depto);
		return q.getResultList();
	}


	public void tkp_montosPorDepartamento(){
		
		data=null;
		data=getMontosPorDpto();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			treeMapDataArray[i]=new TreeMapDto((String)_d[0],((Double) _d[1]).longValue());
			i++;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getMontosPorDpto() {
		String hql="SELECT tkp.departamento.departamento, sum(tkp.importeMensual) FROM Tekopora tkp GROUP BY tkp.departamento.departamento ORDER BY tkp.departamento.departamento";
		Query q=entityManager.createQuery(hql);
		return q.getResultList();
	}


	public void tkp_montosPorDistrito(){
		data=null;
		if (departamento_1==null) {
			return;
		}
		data=getMontosPorDistrito(departamento_1);
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			treeMapDataArray[i]=new TreeMapDto((String)_d[0],((Double) _d[1]).longValue());
			i++;
		}
		
		
	}


	
	@SuppressWarnings("unchecked")
	private List<Object[]> getMontosPorDistrito(Long depto) {
		String hql="SELECT tkp.distrito, sum(tkp.importeMensual) FROM Tekopora tkp WHERE tkp.departamento.idDepartamento=:depto GROUP BY tkp.distrito ORDER BY tkp.distrito";
		Query q=entityManager.createQuery(hql);
		q.setParameter("depto", depto);
		return q.getResultList();
	}

	
	public void psc_MontosPorAsociacion(){
		data=null;
		data=null;
		data=getMontosPorAsociacionPescador();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			treeMapDataArray[i]=new TreeMapDto((String)_d[0],((Double) _d[1]).longValue());
			i++;
		}
	}
	@SuppressWarnings("unchecked")
	private List<Object[]> getMontosPorAsociacionPescador() {
		String hql="SELECT psc.asociacion, sum(psc.importeSubsidio) FROM Pescadores psc GROUP BY psc.asociacion ORDER BY psc.asociacion";
		Query q=entityManager.createQuery(hql);
		return q.getResultList();
	}


	/**
	 * 
	 * GETTERS && SETTERS
	 * 
	 * */
	public List<Object[]> getData() {
		return data;
	}


	public void setData(List<Object[]> data) {
		this.data = data;
	}


	public Long getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}


	public Long getDepartamento_1() {
		return departamento_1;
	}


	public void setDepartamento_1(Long departamento_1) {
		this.departamento_1 = departamento_1;
	}


	public List<TreeMapDto> getTreeMapData() {
		return treeMapData;
	}


	public void setTreeMapData(List<TreeMapDto> treeMapData) {
		this.treeMapData = treeMapData;
	}


	public TreeMapDto[] getTreeMapDataArray() {
		return treeMapDataArray;
	}


	public void setTreeMapDataArray(TreeMapDto[] treeMapDataArray) {
		this.treeMapDataArray = treeMapDataArray;
	}
	
	
}
