package com.itau.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estatistica")
public class EstatisticaEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_estatistica")
    @SequenceGenerator(name = "employee_estatistica", sequenceName = "seq_estatistica", allocationSize = 1)
	@Column(name = "id_estatistica")
	private Long id;

	@Column(name = "tp_consulta")
	private String consulta;

	@Column(name = "dt_consulta")
	private Date dtconsulta;
	
	@Column(name = "st_termo")
    private String sttermo;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Date getDtconsulta() {
		return dtconsulta;
	}

	public void setDtconsulta(Date dtconsulta) {
		this.dtconsulta = dtconsulta;
	}

	public String getSttermo() {
		return sttermo;
	}

	public void setSttermo(String sttermo) {
		this.sttermo = sttermo;
	}


}