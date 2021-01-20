package com.nttdata.EmployeeApp2.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SchedulerConfig {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String chiave;
	private Integer valore;
	
	public SchedulerConfig() {
		super();
	}

	public SchedulerConfig(String chiave, Integer valore) {
		super();
		this.chiave = chiave;
		this.valore = valore;
	}

	public String getChiave() {
		return chiave;
	}
	
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	
	public Integer getValore() {
		return valore;
	}
	
	public void setValore(Integer valore) {
		this.valore = valore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
