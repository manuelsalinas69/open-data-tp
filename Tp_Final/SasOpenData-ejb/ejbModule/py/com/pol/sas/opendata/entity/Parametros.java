package py.com.pol.sas.opendata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parametros", schema = "public")
public class Parametros {

	private String param;
	private String value;
	
	public Parametros() {
		
	}
	
	public Parametros(String param, String value) {
		this.param = param;
		this.value = value;
	}

	@Id
	@Column(name = "param", unique = true, nullable = false)
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	@Column(name = "valor", nullable = false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
	
}
