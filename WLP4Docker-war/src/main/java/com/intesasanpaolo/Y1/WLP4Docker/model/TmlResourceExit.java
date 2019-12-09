package com.intesasanpaolo.Y1.WLP4Docker.model;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;

/**
 * The persistent class for the TMR_RESOURCE_EXIT database table.
 * 
 */
@Entity

@Table(name = "TML_RESOURCE_EXIT" ,schema="AYY1")
//@Table(name = "TMR_RESOURCE_EXIT")

public class TmlResourceExit {

	@Id
	private int id;

	private String jobname;

	private String cpuname;

	private String lpar2;

	private String lparname;

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpuname() {
		return this.cpuname;
	}

	public void setCpuname(String cpuname) {
		this.cpuname = cpuname;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getLpar2() {
		return this.lpar2;
	}

	public void setLpar2(String lpar2) {
		this.lpar2 = lpar2;
	}

	public String getLparname() {
		return this.lparname;
	}

	public void setLparname(String lparname) {
		this.lparname = lparname;
	}

}