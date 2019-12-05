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
@Table(name = "TMR_RESOURCE_EXIT_DAY")
//@Table(name = "TMR_RESOURCE_EXIT")
public class TmrResourceExit {

	@Id
	private int id;

	private String abendcode;

	private String cpuname;

	private BigDecimal cputime;

	private BigDecimal cpuwmrj8;

	private BigDecimal cpuwmrl8;

	private BigDecimal cpuwmrqr;

	private BigDecimal cpuwmrro;

	private Timestamp endtime;

	private String jobname;

	private String lpar2;

	private String lparname;

	private Timestamp starttime;

	private BigDecimal tasknumber;

	private String tranid;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbendcode() {
		return this.abendcode;
	}

	public void setAbendcode(String abendcode) {
		this.abendcode = abendcode;
	}

	public String getCpuname() {
		return this.cpuname;
	}

	public void setCpuname(String cpuname) {
		this.cpuname = cpuname;
	}

	public BigDecimal getCputime() {
		return this.cputime;
	}

	public void setCputime(BigDecimal cputime) {
		this.cputime = cputime;
	}

	public BigDecimal getCpuwmrj8() {
		return this.cpuwmrj8;
	}

	public void setCpuwmrj8(BigDecimal cpuwmrj8) {
		this.cpuwmrj8 = cpuwmrj8;
	}

	public BigDecimal getCpuwmrl8() {
		return this.cpuwmrl8;
	}

	public void setCpuwmrl8(BigDecimal cpuwmrl8) {
		this.cpuwmrl8 = cpuwmrl8;
	}

	public BigDecimal getCpuwmrqr() {
		return this.cpuwmrqr;
	}

	public void setCpuwmrqr(BigDecimal cpuwmrqr) {
		this.cpuwmrqr = cpuwmrqr;
	}

	public BigDecimal getCpuwmrro() {
		return this.cpuwmrro;
	}

	public void setCpuwmrro(BigDecimal cpuwmrro) {
		this.cpuwmrro = cpuwmrro;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
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

	public Timestamp getStarttime() {
		return this.starttime;
	}

	protected void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public BigDecimal getTasknumber() {
		return this.tasknumber;
	}

	public void setTasknumber(BigDecimal tasknumber) {
		this.tasknumber = tasknumber;
	}

	public String getTranid() {
		return this.tranid;
	}

	public void setTranid(String tranid) {
		this.tranid = tranid;
	}

}