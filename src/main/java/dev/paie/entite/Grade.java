package dev.paie.entite;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Grade {
	
	private Integer id;
	private String code;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;
	
	
	@OneToMany(mappedBy="grade" ,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<RemunerationEmploye>remunerationEmployes;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Grade(){
		
	}
	
	public Grade(Integer id, String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		
		this.id = id;
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}
	
	

}
