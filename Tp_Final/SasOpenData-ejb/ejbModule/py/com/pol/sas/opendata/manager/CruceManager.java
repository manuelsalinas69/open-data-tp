package py.com.pol.sas.opendata.manager;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import py.com.pol.sas.opendata.dto.CruceDto;
import py.com.pol.sas.opendata.dto.OverlapsDto;
import py.com.pol.sas.opendata.dto.SetDto;
import py.com.pol.sas.opendata.dto.TreeMapDto;
import py.com.pol.sas.opendata.dto.VennDto;

@Name("cruceManager")
@Scope(ScopeType.PAGE)
public class CruceManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@In(create=true)
	EntityManager entityManager;
	
	List<CruceDto> list;
	private TreeMapDto[] treeMapDataArray;
	private VennDto vennDto;
	public void getTekohaConTekoporaTitular(){
		List<Object[]> data=getTkhTkpTitular();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			TreeMapDto dto= new TreeMapDto((String)_d[1],(Long) _d[2]);
			dto.setGroup((String)_d[0]);
			treeMapDataArray[i]=dto;
			i++;
		}
	}
	
	public void getTekohaConTekoporaConyuge(){
		List<Object[]> data=getTkhTkpConyuge();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			TreeMapDto dto= new TreeMapDto((String)_d[1],(Long) _d[2]);
			dto.setGroup((String)_d[0]);
			treeMapDataArray[i]=dto;
			i++;
		}
	}
	
	public void getTekohaConPescadoresTitular(){
		List<Object[]> data=getTkhPscTitular();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			TreeMapDto dto= new TreeMapDto((String)_d[1],(Long) _d[2]);
			dto.setGroup((String)_d[0]);
			treeMapDataArray[i]=dto;
			i++;
		}
	}
	
	public void getTekohaConPescadoresConyuge(){
		List<Object[]> data=getTkhPscConyuge();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			TreeMapDto dto= new TreeMapDto((String)_d[1],(Long) _d[2]);
			dto.setGroup((String)_d[0]);
			treeMapDataArray[i]=dto;
			i++;
		}
	}
	
	public void getTekoporaConPescadores(){
		List<Object[]> data=getTkpPsc();
		treeMapDataArray= new TreeMapDto[data.size()];
		int i=0;
		for (Object[] _d : data) {
			//treeMapData.add(new TreeMapDto((String)_d[0],(Long) _d[1]));
			TreeMapDto dto= new TreeMapDto((String)_d[1],(Long) _d[2]);
			dto.setGroup((String)_d[0]);
			treeMapDataArray[i]=dto;
			i++;
		}
	}
	
	public void getVennDiagramGeneral(){
		SetDto s1= new SetDto("Tekoha", getTkhTitu()+getTkhConyuge());
		SetDto s2= new SetDto("Tekopora", getTkp());
		SetDto s3= new SetDto("Pescadores", getPsc());
		
		OverlapsDto o1= new OverlapsDto(new Integer[]{0,1}, getTkhTkpGeneral());
		OverlapsDto o2= new OverlapsDto(new Integer[]{0,2}, getTkhPscGeneral());
		OverlapsDto o3= new OverlapsDto(new Integer[]{1,2}, getTkpPscCount());
		
		OverlapsDto[] overL={o1,o2,o3};
		SetDto[] sets={s1,s2,s3};
		
		vennDto= new VennDto();
		vennDto.setOverlaps(overL);
		vennDto.setSets(sets);
		
		
	}
	
	
	

	public void getVennDiagramTitular(){
		SetDto s1= new SetDto("Tekoha - Titular", getTkhTitu());
		SetDto s2= new SetDto("Tekopora", getTkp());
		SetDto s3= new SetDto("Pescadores", getPsc());
		OverlapsDto o1= new OverlapsDto(new Integer[]{0,1}, getTkhTkpTitu());
		OverlapsDto o2= new OverlapsDto(new Integer[]{0,2}, getTkhPscTitu());
		OverlapsDto o3= new OverlapsDto(new Integer[]{1,2}, getTkpPscCount());
		
		OverlapsDto[] overL={o1,o2,o3};
		SetDto[] sets={s1,s2,s3};
		
		vennDto= new VennDto();
		vennDto.setOverlaps(overL);
		vennDto.setSets(sets);
	}
	
	

	public void getVennDiagramConyuge(){
		SetDto s1= new SetDto("Tekoha - Conyuge", getTkhConyuge());
		SetDto s2= new SetDto("Tekopora", getTkp());
		SetDto s3= new SetDto("Pescadores", getPsc());
		OverlapsDto o1= new OverlapsDto(new Integer[]{0,1}, getTkhTkpCony());
		OverlapsDto o2= new OverlapsDto(new Integer[]{0,2}, getTkhPscCony());
		OverlapsDto o3= new OverlapsDto(new Integer[]{1,2}, getTkpPscCount());
		
		OverlapsDto[] overL={o1,o2,o3};
		SetDto[] sets={s1,s2,s3};
		
		vennDto= new VennDto();
		vennDto.setOverlaps(overL);
		vennDto.setSets(sets);
		
	}
	
	
	


	

	/**
	 * Privates
	 * */
	
	
	
	/*For Venn Diagram*/
	
	/*
	 * Sumas Generales
	 * **/
	
	private Long getTkhTitu() {
		String hql="SELECT count(_t) FROM Tekoha _t";
		Query q= entityManager.createQuery(hql);
		Number r=(Number) q.getSingleResult();
		return r.longValue();
	}
	
	private Long getTkhConyuge() {
		String hql="SELECT count(_t) FROM Tekoha _t WHERE (_t.nroCedulaConyuge is not null and trim(_t.nroCedulaConyuge)!='0')";
		Query q= entityManager.createQuery(hql);
		Number r=(Number) q.getSingleResult();
		return r.longValue();
	}
	
	private Long getTkp() {
		String hql="SELECT count(_t) FROM Tekopora _t";
		Query q= entityManager.createQuery(hql);
		Number r=(Number) q.getSingleResult();
		return r.longValue();
	}
	
	private Long getPsc() {
		String hql="SELECT count(_p) FROM Pescadores _p";
		Query q= entityManager.createQuery(hql);
		Number r=(Number) q.getSingleResult();
		return r.longValue();
		
	}

	

	/*
	 * Sumas de cruces
	 * */
	private Integer getTkhTkpGeneral() {
		String hql="SELECT count(*) FROM Tekoha tkh , Tekopora tkp WHERE (tkh.nroCedulaTitular=tkp.nroCedula OR tkh.nroCedulaConyuge=tkp.nroCedula) ";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}
	
	private Integer getTkhTkpTitu() {
		String hql="SELECT count(*) FROM Tekoha tkh , Tekopora tkp WHERE tkh.nroCedulaTitular=tkp.nroCedula ";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}
	
	
	private Integer getTkhTkpCony() {
		String hql="SELECT count(*) FROM Tekoha tkh , Tekopora tkp WHERE tkh.nroCedulaConyuge=tkp.nroCedula ";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}

	private Integer getTkhPscGeneral() {
		String hql="SELECT count(*) FROM Tekoha tkh , Pescadores psc WHERE (tkh.nroCedulaTitular=psc.nroCedula OR tkh.nroCedulaConyuge=psc.nroCedula)";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}
	
	private Integer getTkhPscTitu() {
		String hql="SELECT count(*) FROM Tekoha tkh , Pescadores psc WHERE tkh.nroCedulaTitular=psc.nroCedula";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}
	
	private Integer getTkhPscCony() {
		String hql="SELECT count(*) FROM Tekoha tkh , Pescadores psc WHERE tkh.nroCedulaConyuge=psc.nroCedula";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}

	
	private Integer getTkpPscCount() {
		String hql="SELECT count(*) FROM Tekopora tkp , Pescadores psc WHERE tkp.nroCedula=psc.nroCedula ";
		Query q= entityManager.createQuery(hql);
		Number r= (Number) q.getSingleResult();
		return r.intValue();
	}

	
	
	
	/* For TreeMap*/
	@SuppressWarnings("unchecked")
	private List<Object[]> getTkhTkpTitular() {
		String hql="SELECT tkh.departamento.departamento,tkh.distrito,count(*) FROM Tekoha tkh , Tekopora tkp WHERE tkh.nroCedulaTitular=tkp.nroCedula GROUP BY tkh.departamento.departamento,tkh.distrito";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getTkhTkpConyuge() {
		String hql="SELECT tkh.departamento.departamento,tkh.distrito,count(*) FROM Tekoha tkh , Tekopora tkp WHERE tkh.nroCedulaConyuge=tkp.nroCedula GROUP BY tkh.departamento.departamento,tkh.distrito";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getTkhPscTitular() {
		String hql="SELECT tkh.departamento.departamento,tkh.distrito,count(*) FROM Tekoha tkh , Pescadores psc WHERE tkh.nroCedulaTitular=psc.nroCedula GROUP BY tkh.departamento.departamento,tkh.distrito";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getTkhPscConyuge() {
		String hql="SELECT tkh.departamento.departamento,tkh.distrito,count(*) FROM Tekoha tkh , Pescadores psc WHERE tkh.nroCedulaConyuge=psc.nroCedula GROUP BY tkh.departamento.departamento,tkh.distrito";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private List<Object[]> getTkpPsc() {
		String hql="SELECT tkp.departamento.departamento,tkp.distrito,count(*) FROM Tekopora tkp , Pescadores psc WHERE tkp.nroCedula=psc.nroCedula GROUP BY tkp.departamento.departamento,tkp.distrito";
		Query q= entityManager.createQuery(hql);
		return q.getResultList();
	}
	
	/**
	 * GETTERS && SETTERS
	 * */
	
	public TreeMapDto[] getTreeMapDataArray() {
		return treeMapDataArray;
	}
	public void setTreeMapDataArray(TreeMapDto[] treeMapDataArray) {
		this.treeMapDataArray = treeMapDataArray;
	}

	public VennDto getVennDto() {
		return vennDto;
	}

	public void setVennDto(VennDto vennDto) {
		this.vennDto = vennDto;
	}
	
	
	
	
}
